package features;

import properties.PropertyManager;

public class Task {
	private String title;
	private String notes;
	private String category;
	private long creationTime;

	public Task(String title, String notes, String category) {
		this.title = title;
		this.notes = notes;
		this.category = category;
		
		this.creationTime = System.currentTimeMillis();
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public String getCategory() {
		return category;
	}
	
	public long getCreationTime() {
		return creationTime;
	}
}
