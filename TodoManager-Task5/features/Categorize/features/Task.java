package features;

public class Task {
	private String category;
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString() {
		return original() + "\t\t" + category;
	}
}
