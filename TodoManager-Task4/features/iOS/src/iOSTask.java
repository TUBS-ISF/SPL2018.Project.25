import interfaces.ITask;

public class iOSTask extends Task {
	
	public iOSTask(String title, String notes, String category) {
		super(String title, String notes, String category);
		this.setPlatform("iOS");
	}
}
