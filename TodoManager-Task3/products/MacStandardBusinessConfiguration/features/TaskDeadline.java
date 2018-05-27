package features;

public class TaskDeadline extends Task{
	
	private long deadline;

	public TaskDeadline(String title, String notes, String category) {
		super(title, notes, category);
		this.deadline = 0;
	}

	public long getDeadline() {
		return deadline;
	}
	
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
}
