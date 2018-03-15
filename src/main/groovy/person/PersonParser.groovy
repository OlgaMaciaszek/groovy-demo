package person

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class PersonParser {

	Person generateDefaultPerson() {
		return new Person('Anna', 'Smith', new Address('58 Birch Street', 'Chicago'))
	}

	String toJson(Person person = generateDefaultPerson()) {
		return JsonOutput.toJson(person)
	}

	Person fromJson(URL personJsonURL) {
		return new JsonSlurper().parse(personJsonURL)
	}

}
