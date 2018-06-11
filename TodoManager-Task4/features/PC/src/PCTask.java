import interfaces.ITask;

public class PCTask extends Task {
	
	public PCTask(String title, String notes, String category) {
		super(String title, String notes, String category);
		this.setPlatform("PC");
	}
}
