
public aspect Title {
	private String Task.title;
	
	public String Task.getTitle() {
		return title;
	}
	
	public void Task.setTitle(String title) {
		this.title = title;
	}
	
	before(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Title: ");
		TodoManagerMain.sc.nextLine();
		String title = TodoManagerMain.sc.nextLine();
		task.setTitle(title);
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t" + task.getTitle();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tTitle";
	}
}
