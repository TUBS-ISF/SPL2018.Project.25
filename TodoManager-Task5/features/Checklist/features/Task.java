package features;

public class Task {
	private String checklist;
	
	public String getChecklist() {
		return checklist;
	}
	public void setChecklist(String checklist) {
		this.checklist = checklist;
	}
	
	public String toString() {
		return original() + "\t\t" + checklist;
	}
}
