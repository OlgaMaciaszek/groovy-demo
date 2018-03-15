import java.util.Locale;
import java.util.stream.IntStream;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
public class PersonGenerator {

	private PersonHelper personHelper = new PersonHelper();

	public void populatePersons() {

		IntStream.range(1, 200).forEach(number -> {
			Person fairyPerson = Fairy.create(Locale.getDefault()).person();
			personHelper.save(new person.Person(fairyPerson.getFirstName(), fairyPerson.getLastName()));
		});


	}

}
