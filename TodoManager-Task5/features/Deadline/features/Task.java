package features;

public class Task {
	private String deadline;
	
	public String getDeadline() {
		return deadline;
	}
	
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public String toString() {
		return original() + "\t\t" + deadline;
	}
}
