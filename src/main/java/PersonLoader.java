import person.Person;
import person.PersonParser;

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
public class PersonLoader {

	private PersonParser personParser = new PersonParser();

	public Person getPerson(String jsonPath) {
		return personParser.fromJson(this.getClass().getResource(jsonPath));
	}
}
