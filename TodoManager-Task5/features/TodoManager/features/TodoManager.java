package features;
import java.util.ArrayList;

import features.Task;

public class TodoManager {
	private ArrayList<Task> taskList= new ArrayList<Task>();
	private String platform;
	
	public TodoManager() {
	}
	
	public void addTask(Task task) {
		taskList.add(task);
	}
	
	public ArrayList<Task> getTaskList(){
		return taskList;
	}
	
	public boolean removeTask(Task task) {
		return (taskList.remove(task) != null);
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public String getHeaderDescription() {
		return "ID";
	}
}
