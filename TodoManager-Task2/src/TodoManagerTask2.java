import features.TaskDeadline;
import features.TaskDeadlineSeverity;
import features.TaskSeverity;
import properties.PropertyManager;

public class TodoManagerTask2 {
	
	String platform = "ANDROID";
	
	public static void main(String[] args) {
		// Read user input
		String title = "Test";
		String notes = "Some notes...";
		String category = "SampleCategory";
		
		if (PropertyManager.getProperty("Severity")) {
			if (PropertyManager.getProperty("Deadline")) {
				TaskDeadlineSeverity taskSeverityDeadline = new TaskDeadlineSeverity(title, notes, category);
				taskSeverityDeadline.setSeverity("HIGH");
				taskSeverityDeadline.setDeadline(taskSeverityDeadline.getCreationTime() + 1000);
				System.out.println("SeverityDeadline created!");
				return;
			}
			else {
				TaskSeverity taskSeverity = new TaskSeverity(title, notes, category);
				taskSeverity.setSeverity("MEDIUM");
				System.out.println("Severity created!");
				return;
			}
		}
		if (PropertyManager.getProperty("Deadline")) {
			if (PropertyManager.getProperty("Severity")) {
				TaskDeadlineSeverity taskSeverityDeadline = new TaskDeadlineSeverity(title, notes, category);
				taskSeverityDeadline.setSeverity("HIGH");
				taskSeverityDeadline.setDeadline(taskSeverityDeadline.getCreationTime() + 1000);
				System.out.println("SeverityDeadline created!");
				return;
			}
			else {
				TaskDeadline taskDeadline = new TaskDeadline(title, notes, category);
				taskDeadline.setDeadline(taskDeadline.getCreationTime() + 1000);
				System.out.println("Deadline created!");
				return;
			}
		}
	}
}
