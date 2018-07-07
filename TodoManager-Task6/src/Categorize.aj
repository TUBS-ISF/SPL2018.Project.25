import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Categorize {
	
	declare precedence : Title, Notes;

	private String Task.category;
	
	public String Task.getCategory() {
		return category;
	}
	
	public void Task.setCategory(String category) {
		this.category = category;
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getCategory();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tCategory";
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Category (String): ");
		String category = TodoManagerMain.getScanner().nextLine();
		task.setCategory(category);
	}

}
