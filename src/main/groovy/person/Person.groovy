package person

import groovy.transform.Canonical

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */

@Canonical
class Person {

	String name
	String surname
	Address address
	List<Person> children = []
	List<FamilyCard> cards = []
}
