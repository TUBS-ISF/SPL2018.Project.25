package interfaces;

public interface ITask {
	
	// Base Features
	public String getTitle();
	public void setTitle(String title);
	public String getNotes();
	public void setNotes(String notes);
	public String getCategory();
	public void setCategory(String category);
	public long getCreationTime();
	
	// Feature Platform
	public String getPlatform();
	public void setPlatform(String platform);
}
