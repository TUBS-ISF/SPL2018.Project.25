import java.util.ArrayList;

import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Archive {
	declare precedence : Title, Notes, Categorize;

	
	private ArrayList<Task> TodoManager.archive = new ArrayList<Task>();
	
	public ArrayList<Task> TodoManager.getArchivedTasks(){
		return archive;
	}
	
	public boolean TodoManager.removeTask(Task task) {
		if (this.getTaskList().remove(task))
			archive.add(task);
		else
			return false;
		return true;
	}
	
	private static void TodoManagerMain.listAllArchivedTasks() {
		System.out.println(TodoManagerMain.getTodoManager().getHeaderDescription());
		if (TodoManagerMain.getTodoManager().getArchivedTasks().isEmpty()) {
			System.out.println("No Tasks archived!");
			return;
		}
		for(int i = 0; i<TodoManagerMain.getTodoManager().getArchivedTasks().size();i++) {
			Task task = TodoManagerMain.getTodoManager().getArchivedTasks().get(i);
			System.out.println(i + ". " + task.toString());
		}
	}
	
	private static void TodoManagerMain.listAllTasksDelete() {
		System.out.println(TodoManagerMain.getTodoManager().getHeaderDescription());
		if (TodoManagerMain.getTodoManager().getTaskList().isEmpty()) {
			System.out.println("No Tasks saved!");
			return;
		}
		for(int i = 0; i<TodoManagerMain.getTodoManager().getTaskList().size();i++) {
			Task task = TodoManagerMain.getTodoManager().getTaskList().get(i);
			System.out.println(i + ". " + task.toString());
		}
		System.out.println("Enter Task ID to delete or enter 'm' to go back to Menu.");
		TodoManagerMain.getScanner().nextLine();
		String input = TodoManagerMain.getScanner().nextLine();
		if (input.charAt(0) == 'm') {
			return;
		}
		else {
			int id = Integer.parseInt(input);
			Task task = TodoManagerMain.getTodoManager().getTaskList().get(id);
			if (TodoManagerMain.getTodoManager().removeTask(task)) {
				System.out.println(task.getTitle() + " was archived!");
			}
		}
	}
	
	void around(): execution(void TodoManagerMain.printMenu()){
		proceed();
		TodoManagerMain.methodMap.put(TodoManagerMain.getMenuCounter(), () -> TodoManagerMain.listAllArchivedTasks());
		System.out.println(TodoManagerMain.getMenuCounter() + ". Show Archived Tasks.");
		TodoManagerMain.incrementCounter();
		
		TodoManagerMain.methodMap.put(TodoManagerMain.getMenuCounter(), () -> TodoManagerMain.listAllTasksDelete());
		System.out.println(TodoManagerMain.getMenuCounter() + ". Remove Task.");
		TodoManagerMain.incrementCounter();
	}
}
