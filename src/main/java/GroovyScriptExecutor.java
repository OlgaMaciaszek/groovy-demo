import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
public class GroovyScriptExecutor {

	public void executeScript(String inputScript) {
		Binding binding = new Binding();
		GroovyShell shell = new GroovyShell(binding);
		binding.setProperty("personHelper", new PersonHelper());
		Script script = shell.parse(inputScript);
		script.run();
	}
}
