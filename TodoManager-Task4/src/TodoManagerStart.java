import java.util.List;

import interfaces.IPlatform;
import loader.PluginLoader;

public class TodoManagerStart {
	public static void main(String[] args) {
		List<IPlatform> taskPlugins = PluginLoader.load(IPlatform.class);
		System.out.println(taskPlugins);
	}
}
