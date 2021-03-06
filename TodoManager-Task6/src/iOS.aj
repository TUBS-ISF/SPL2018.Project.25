package base;

public aspect iOS {
	String platform;

	after(TodoManager tm): execution(TodoManager.new()) && this(tm){
		tm.setPlatform("iOS");
	}
}
