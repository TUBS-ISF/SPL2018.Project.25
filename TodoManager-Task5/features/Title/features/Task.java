package features;

public class Task {
	private String title;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString() {
		return original() + "\t\t" + title;
	}
}
