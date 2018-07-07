import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Notes {
	
	declare precedence : Title; 
	private String Task.notes;
	
	public String Task.getNotes() {
		return notes;
	}
	
	public void Task.setNotes(String notes) {
		this.notes = notes;
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Notes/Description (String): ");
//		TodoManagerMain.getScanner().nextLine();
		String notes = TodoManagerMain.getScanner().nextLine();
		task.setNotes(notes);
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getNotes();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tNotes";
	}
	
	
}
