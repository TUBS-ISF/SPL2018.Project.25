package interfaces;

import java.util.List;

public interface IChecklist {
	// Feature Checklist
	public boolean isChecklistAvailable();
	public List<String> getChecklist();
	public void addToChecklist(String note);
	public void removeObjectFromChecklist(String note);

}
