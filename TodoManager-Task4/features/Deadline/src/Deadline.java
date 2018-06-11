package interfaces;

public class Deadline implements IDeadline {
	private long deadline = 0;
	
	
	public boolean isDeadlineAvailabe() {
		return true;
	}
	public long getDeadline() {
		return deadline;
	}
	public void setDeadline(long deadline) {
		this.deadline = deadline;
	}
}
