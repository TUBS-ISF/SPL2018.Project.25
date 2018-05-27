package features;

public class TodoManagerTask3 {

	public static void main(String[] args) {
		String platform = "";
		//#if PC
//@		platform = "PC";
		//#endif
		//#if Android
			platform = "Android";
		//#endif
		//#if Mac
//@			platform = "Mac";
		//#endif
		//#if iOS
//@			platform = "iOS";
		//#endif

		// Read user input
		String title = "Test";
		String notes = "Some notes...";
		String category = "SampleCategory";
		
		Task task = new Task(title, notes, category);
		//#if Severity
//@		task.setSeverity("HIGH");
		//#endif
		
		//#if Deadline
//@		task.setDeadline(task.getCreationTime() + 1000);
		//#endif
		System.out.println("Task created!");
		return;
	}
}
