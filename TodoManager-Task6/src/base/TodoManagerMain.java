package base;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoManagerMain {
	static TodoManager tm;
	private static Scanner sc;
	static int menuCounter;
	public static HashMap<Integer, Runnable> methodMap;
	
	public static void main(String[] args) {
		setScanner(new Scanner(System.in));
		tm = new TodoManager();
		setMethodMap(new HashMap<>());
		while (true) {
			menuCounter = 1;
			System.out.println("###\tTodoManager\t###");
			System.out.println("###\tMenu\t\t###");
			System.out.println("###\tPlatform: " + tm.getPlatform() + "\t###");
			printMenu();
			getMethodMap().put(menuCounter, () -> System.exit(0));
			System.out.println(menuCounter + ". Exit.");
			TodoManagerMain.incrementCounter();
			int index;
			try{
				index = getScanner().nextInt();
				getMethodMap().get(index).run();
			}catch (NullPointerException e) {
				System.out.println("Invalid Input!");
			}
		}
	}

	private static void printMenu() {
		getMethodMap().put(menuCounter, () -> listAllTasks());
		System.out.println(menuCounter + ". List all tasks.");
		TodoManagerMain.incrementCounter();
		getMethodMap().put(menuCounter, () -> createTask());
		System.out.println(menuCounter + ". Create new task.");
		TodoManagerMain.incrementCounter();
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
		getScanner().nextLine();
		String input = getScanner().nextLine();
		if (input.charAt(0) == 'm') {
			return;
		}
		else {
			int id = Integer.parseInt(input);
			Task task = tm.getTaskList().get(id);
			System.out.println(task.toString());
		}
	}
	
	public static void updateTask(Task task) {
		
	}

	public static TodoManager getTodoManager() {
		return tm;
	}
	
	public static HashMap<Integer, Runnable> getMethodMap() {
		return methodMap;
	}

	public static void setMethodMap(HashMap<Integer, Runnable> methodMap) {
		TodoManagerMain.methodMap = methodMap;
	}

	public static Scanner getScanner() {
		return sc;
	}

	public static void setScanner(Scanner sc) {
		TodoManagerMain.sc = sc;
	}
	
	public static int getMenuCounter() {
		return menuCounter;
	}
	
	public static void incrementCounter() {
		menuCounter = menuCounter + 1;
	}
}
