package interfaces;

public class Severity implements ISeverity {
	private String severity;
	
	// Feature Severity
	public boolean isSeverityAvailable() {
		return true;
	}
	public String getSeverity(){
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
