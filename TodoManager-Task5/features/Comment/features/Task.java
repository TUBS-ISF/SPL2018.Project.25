package features;

public class Task {
	private String comment;
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String toString() {
		return original() + "\t\t" + comment;
	}
}
