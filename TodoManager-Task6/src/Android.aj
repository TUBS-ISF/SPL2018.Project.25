public aspect Android {
	String platform;
	
	after(TodoManager tm): execution(TodoManager.new()) && this(tm){
		tm.platform = "Android";
	}
}
