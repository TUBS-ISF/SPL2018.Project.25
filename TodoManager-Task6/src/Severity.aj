import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Severity {
	declare precedence : Title, Notes, Categorize;
	
	private String Task.severity;
	
	public String Task.getSeverity() {
		return severity;
	}
	
	public void Task.setSeverity(String severity) {
		this.severity = severity;
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getSeverity();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\t\tSeverity";
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Severity (String): ");
		TodoManagerMain.getScanner().nextLine();
		String severity = TodoManagerMain.getScanner().nextLine();
		task.setSeverity(severity);
	}
}
