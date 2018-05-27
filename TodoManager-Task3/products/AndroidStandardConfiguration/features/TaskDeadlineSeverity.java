package features;

public class TaskDeadlineSeverity extends Task {

	private long deadline;
	private String severity;
	
	public TaskDeadlineSeverity(String title, String notes, String category) {
		super(title, notes, category);
		this.severity = "MEDIUM";
		this.deadline = 0;
	}
	
	public long getDeadline() {
		return deadline;
	}
	
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
	
	public String getSeverity() {
		return severity;
	}
	
	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
