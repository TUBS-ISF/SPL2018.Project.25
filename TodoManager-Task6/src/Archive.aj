import java.util.ArrayList;

public aspect Archive {
	
	declare precedence: Title, Notes; 
	
	private ArrayList<Task> TodoManager.archive = new ArrayList<Task>();
	
	public ArrayList<Task> TodoManager.getArchivedTasks(){
		return archive;
	}
	
	static void TodoManagerMain.listAllArchivedTasks() {
		System.out.println(tm.getHeaderDescription());
		if (tm.getArchivedTasks().isEmpty()) {
			System.out.println("No Tasks archived!");
			return;
		}
		for(int i = 0; i<tm.getArchivedTasks().size();i++) {
			Task task = tm.getArchivedTasks().get(i);
			System.out.println(i + ". " + task.toString());
		}
	}
	
	static void TodoManagerMain.listAllTasksDelete() {
		System.out.println(tm.getHeaderDescription());
		if (tm.getTaskList().isEmpty()) {
			System.out.println("No Tasks saved!");
			return;
		}
		for(int i = 0; i<tm.getTaskList().size();i++) {
			Task task = tm.getTaskList().get(i);
			System.out.println(i + ". " + task.toString());
		}
		System.out.println("Enter Task ID to delete or enter 'm' to go back to Menu.");
		sc.nextLine();
		String input = sc.nextLine();
		if (input.charAt(0) == 'm') {
			return;
		}
		else {
			int id = Integer.parseInt(input);
			Task task = tm.getTaskList().get(id);
			if (tm.removeTask(task)) {
				System.out.println(task.getTitle() + " was archived!");
			}
		}
	}
	
	public boolean TodoManager.removeTask(Task task) {
		if (taskList.remove(task))
			archive.add(task);
		else
			return false;
		return true;
	}
	
	before(TodoManager tm): execution(* TodoManagerMain.printMenu()) && this(tm){
		TodoManagerMain.methodMap.put(TodoManagerMain.menuCounter, () -> TodoManagerMain.listAllArchivedTasks());
		System.out.println(TodoManagerMain.menuCounter++ + ". Show Archived Tasks.");
		TodoManagerMain.methodMap.put(TodoManagerMain.menuCounter, () -> TodoManagerMain.listAllTasksDelete());
		System.out.println(TodoManagerMain.menuCounter++ + ". Remove Task.");
	}
}
