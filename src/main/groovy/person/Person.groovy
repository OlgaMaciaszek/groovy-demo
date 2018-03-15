package person

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */

@ToString
@Canonical
@EqualsAndHashCode
class Person {

	String name
	String surname
	Address address
	List<Person> children = []
	List<FamilyCard> cards = []
}
