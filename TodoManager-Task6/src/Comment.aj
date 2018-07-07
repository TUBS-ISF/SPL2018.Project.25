import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Comment {
	declare precedence : Title, Notes, Categorize;
	
	private String Task.comment;
	
	public String Task.getComment() {
		return comment;
	}
	
	public void Task.setComment(String comment) {
		this.comment = comment;
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getComment();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tComment";
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Comment (String): ");
//		TodoManagerMain.getScanner().nextLine();
		String comment = TodoManagerMain.getScanner().nextLine();
		task.setComment(comment);
	}
}
