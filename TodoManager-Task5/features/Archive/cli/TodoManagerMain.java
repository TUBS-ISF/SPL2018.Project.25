package cli;
import java.util.Scanner;

import features.Task;
import features.TodoManager;

public class TodoManagerMain {
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		tm = new TodoManager();
		while (true) {
			System.out.println("###\tTodoManager\t###");
			System.out.println("###\tMenu\t\t###");
			System.out.println("###\tPlatform: " + tm.getPlatform() + "\t###");
			System.out.println("1. List all tasks.");
			System.out.println("2. Create new task.");
			System.out.println("3. Show Archived Tasks.");
			System.out.println("4. Remove Task.");
			System.out.println("5. Exit.");
			int index = sc.nextInt();
			switch(index) {
			case 1:
				listAllTasks();
				break;
			case 2:
				createTask();
				break;
			case 3:
				listAllArchivedTasks();
				break;
			case 4:
				listAllTasksDelete();
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid Userinput.");
				break;
			}
		}
	}
	
	private static void listAllTasksDelete() {
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
}
