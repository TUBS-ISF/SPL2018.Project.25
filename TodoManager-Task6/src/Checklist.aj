import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Checklist {
	declare precedence : Title, Notes, Categorize;

	private String Task.checklist;
	
	public String Task.getChecklist() {
		return checklist;
	}
	public void Task.setChecklist(String checklist) {
		this.checklist = checklist;
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getChecklist();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tChecklist";
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Checklist not implemented yet!\n");
		task.setChecklist("-Empty-");
	}
}
