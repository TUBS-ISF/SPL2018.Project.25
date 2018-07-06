
import java.util.HashMap;
import java.util.Scanner;

public class TodoManagerMain {
	static TodoManager tm;
	static Scanner sc;
	static int menuCounter;
	static HashMap<Integer, Runnable> methodMap;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		tm = new TodoManager();
		methodMap = new HashMap<>();
		while (true) {
			menuCounter = 1;
			System.out.println("###\tTodoManager\t###");
			System.out.println("###\tMenu\t\t###");
			System.out.println("###\tPlatform: " + tm.getPlatform() + "\t###");
			printMenu();
			methodMap.put(menuCounter, () -> System.exit(0));
			System.out.println(menuCounter++ + ". Exit.");
			int index = sc.nextInt();
			methodMap.get(index).run();
//			switch(index) {
//			case 1:
//				listAllTasks();
//				break;
//			case 2:
//				createTask();
//				break;
//			case 3:
//				System.exit(0);
//			default:
//				System.out.println("Invalid Userinput.");
//				break;
//			}
		}
	}

	private static void printMenu() {
		methodMap.put(menuCounter, () -> listAllTasks());
		System.out.println(menuCounter++ + ". List all tasks.");
		methodMap.put(menuCounter, () -> createTask());
		System.out.println(menuCounter++ + ". Create new task.");
	}

	private static void createTask() {
		Task task = new Task();
		tm.addTask(task);
		updateTask(task);
	}

	private static void listAllTasks() {
		System.out.println(tm.getHeaderDescription());
		if (tm.getTaskList().isEmpty()) {
			System.out.println("No Tasks saved!");
			return;
		}
		for(int i = 0; i<tm.getTaskList().size();i++) {
			Task task = tm.getTaskList().get(i);
			System.out.println(i + ". " + task.toString());
		}
		detailedView();
	}
	
	private static void detailedView() {
		System.out.println("For details enter Task ID or enter 'm' to go back to Menu.");
		sc.nextLine();
		String input = sc.nextLine();
		if (input.charAt(0) == 'm') {
			return;
		}
		else {
			int id = Integer.parseInt(input);
			Task task = tm.getTaskList().get(id);
			System.out.println(task);
		}
	}
	
	public static void updateTask(Task task) {
		
	}
}
