package interfaces;

public class Comment implements IComment {
	private String comment = "";
	// Feature Comment
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
