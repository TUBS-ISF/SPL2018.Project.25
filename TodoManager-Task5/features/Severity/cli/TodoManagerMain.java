package cli;
import java.util.Scanner;

import features.Task;
import features.TodoManager;

public class TodoManagerMain {
	public static void updateTask(Task task) {
		original(task);
		System.out.print("Enter Severity: ");
		String severity = sc.nextLine();
		task.setSeverity(severity);
	}
	
}
