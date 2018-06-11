import interfaces.ITask;

public class Task implements ITask {
	
	private String title;
	private String notes;
	private String category;
	private long creationTime;
	private String platform;
	
	public Task(String title, String notes, String category) {
		this.title = title;
		this.notes = notes;
		this.category = category;
		this.creationTime = System.currentTimeMillis();
		this.platform = "";
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getNotes() {
		return notes;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public long getCreationTime() {
		return creationTime;
	}

	@Override
	public String getPlatform() {
		// TODO Auto-generated method stub
		return platform;
	}

	@Override
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public void setCategory(String category) {
		this.category = category;
	}

}
