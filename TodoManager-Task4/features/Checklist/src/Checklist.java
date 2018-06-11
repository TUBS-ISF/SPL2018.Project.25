package interfaces;

import java.util.List;

public class Checklist implements IChecklist {
	private List<String> checklist = new ArrayList<String>();
	
	public boolean isChecklistAvailable() {
		return true;
	}
	public List<String> getChecklist(){
		return checklist;
	}
	public void addToChecklist(String note) {
		this.checklist.add(note);
	}
	public void removeObjectFromChecklist(String note) {
		this.checklist.remove(note);
	}

}
