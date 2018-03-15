package person

import groovy.transform.Canonical
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
@Canonical
class Address {

	String streetAddress
	String postalCode
	String city

}
