import person.PersonParser
import spock.lang.Specification
import spock.lang.Subject

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class PersonLoaderSpec extends Specification {

	@Subject
	PersonLoader personLoader = new PersonLoader()

	def "should load person from json"() {
		expect:
			personLoader.getPerson('person.json') == new PersonParser().generateDefaultPerson()
	}
}
