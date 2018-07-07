import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Title {
	
	private String Task.title;
	
	public String Task.getTitle() {
		return title;
	}
	
	public void Task.setTitle(String title) {
		this.title = title;
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Title (String): ");
		TodoManagerMain.getScanner().nextLine();
		String title = TodoManagerMain.getScanner().nextLine();
		task.setTitle(title);
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getTitle();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tTitle";
	}
}
