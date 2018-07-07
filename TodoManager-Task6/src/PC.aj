import base.TodoManager;

public aspect PC{
	String platform;

	after(TodoManager tm): execution(TodoManager.new()) && this(tm){
		tm.setPlatform("PC");
	}
}