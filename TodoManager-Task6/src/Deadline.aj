import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Deadline {
	declare precedence : Title, Notes, Categorize;

	private String Task.deadline;
	
	public String Task.getDeadline() {
		return deadline;
	}
	
	public void Task.setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getDeadline();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tDeadline";
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Deadline (String): ");
		String deadline = TodoManagerMain.getScanner().nextLine();
		task.setDeadline(deadline);
	}
}
