package features;
import java.util.ArrayList;

import features.Task;

public class TodoManager {
	private ArrayList<Task> archive = new ArrayList<Task>();
	
	public ArrayList<Task> getArchivedTasks(){
		return archive;
	}
	
	public boolean removeTask(Task task) {
		if (taskList.remove(task))
			archive.add(task);
		else
			return false;
		return true;
	}
}
