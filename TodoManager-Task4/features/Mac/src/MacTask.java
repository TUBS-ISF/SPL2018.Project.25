import interfaces.ITask;

public class MacTask extends Task {
	
	public MacTask(String title, String notes, String category) {
		super(String title, String notes, String category);
		this.setPlatform("MacOS");
	}
}
