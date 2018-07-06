public aspect Notes {

	declare precedence: Title; 

	private String Task.notes;
	
	public String Task.getNotes() {
		return notes;
	}
	
	public void Task.setNotes(String notes) {
		this.notes = notes;
	}
	
	after(Task task): execution(* TodoManagerMain.updateTask(Task)) && args(task){
		System.out.print("Enter Notes/Description: ");
		TodoManagerMain.sc.nextLine();
		String notes = TodoManagerMain.sc.nextLine();
		task.setNotes(notes);
	}
	
	String around(Task task): execution(String Task.toString()) && this(task){
		String result = proceed(task);
		return result + "\t" + task.getNotes();
	}
	
	String around(): execution(String TodoManager.getHeaderDescription()){
		String result = proceed();
		return result + "\t\tNotes";
	}
	
}
