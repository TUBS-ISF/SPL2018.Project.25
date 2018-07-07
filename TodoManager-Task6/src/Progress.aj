import base.Task;
import base.TodoManager;
import base.TodoManagerMain;

public aspect Progress {
	declare precedence : Title, Notes, Categorize;

	private double Task.progress;
	
	public double Task.getProgress() {
		return progress;
	}
	
	public void Task.setProgress(double progress) {
		this.progress = progress;
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t\t" + task.getProgress();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tProgress";
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Progress (Double): ");
//		TodoManagerMain.getScanner().nextDouble();
		double progress = TodoManagerMain.getScanner().nextDouble();
		task.setProgress(progress);
	}
}
