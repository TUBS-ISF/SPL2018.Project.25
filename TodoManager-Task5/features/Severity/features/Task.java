package features;

public class Task {
	private String severity;
	
	public String getSeverity() {
		return severity;
	}
	
	public void setSeverity(String severity) {
		this.severity = severity;
	}
	
	public String toString() {
		return original() + "\t\t" + severity;
	}
}
