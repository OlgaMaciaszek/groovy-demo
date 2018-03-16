package closures

import closures.context.PersonContext

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/13/18
 */

addPerson {
	name 'Juan'
	surname 'Perez'
	address {
		streetAddress 'C/Trafalgar 2'
		postalCode '0000'
		city 'Madrid'
		country 'Spain'
	}
}

void addPerson(@DelegatesTo(PersonContext) Closure closure) {
	PersonContext personContext = new PersonContext()
	closure.setDelegate(personContext)
	closure.setResolveStrategy(Closure.DELEGATE_ONLY)
	closure()
}