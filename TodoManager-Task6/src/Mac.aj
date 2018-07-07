import base.TodoManager;

public aspect Mac{
	String platform;

	after(TodoManager tm): execution(TodoManager.new()) && this(tm){
		tm.setPlatform("Mac");
	}
}