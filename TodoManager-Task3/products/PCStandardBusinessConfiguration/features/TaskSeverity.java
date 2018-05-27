package features;

public class TaskSeverity extends Task {
	
	private String severity;

	public TaskSeverity(String title, String notes, String category) {
		super(title, notes, category);
		this.severity = "MEDIUM";
	}
	
	public String getSeverity() {
		return severity;
	}
	
	public void setSeverity(String severity) {
		this.severity = severity;
	}
}
