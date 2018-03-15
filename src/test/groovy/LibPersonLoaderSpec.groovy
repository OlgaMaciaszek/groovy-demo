import spock.lang.Specification
import spock.lang.Subject

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class LibPersonLoaderSpec extends Specification {

	@Subject
	LibPersonLoader personLoader = new LibPersonLoader()

	def "should load person from json with standard lib"() {
		expect:
			personLoader.parseJson('person.json').name == 'Anna'
	}

}
