import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import groovy.lang.Script;

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
// Awesome for demo and stage environments - please do not use it in production
// @Bean
public class GroovyScriptExecutor {

	private final PersonRepository personRepository;

	public GroovyScriptExecutor(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public void executeScript(String inputScript) {
		Binding binding = new Binding();
		GroovyShell shell = new GroovyShell(binding);
		binding.setProperty("personRepository", personRepository);
		Script script = shell.parse(inputScript);
		script.run();
	}
}
