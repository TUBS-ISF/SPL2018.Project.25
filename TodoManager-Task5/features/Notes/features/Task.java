package features;

public class Task {
	private String notes;
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public String toString() {
		return original() + "\t\t" + notes;
	}
}
