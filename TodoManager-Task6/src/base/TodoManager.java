package base;
import java.util.ArrayList;

public class TodoManager {
	ArrayList<Task> taskList= new ArrayList<Task>();
	String platform;
	
	public TodoManager() {
	}
	
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	public ArrayList<Task> getTaskList(){
		return taskList;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public String getHeaderDescription() {
		return "ID";
	}
}
