package person

import groovy.transform.TupleConstructor

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
@TupleConstructor
class PersonService {

	FamilyCardPolicyProvider policyProvider

	PersonService(FamilyCardPolicyProvider policyProvider) {
		this.policyProvider = policyProvider
	}

	void addChild(Person person, Person child) {
		if (person.children.contains(child)) {
			throw new IllegalArgumentException('Child already exists for this person.')
		}
		person.children << child
	}

	void addFamilyCard(Person person, int cardType) {
		if(!policyProvider.canAddCardType(cardType)) {
			return
		}
		if (!person.children) {
			if (policyProvider.canGiveFamilyCardForPersonWithNoChildren()) {
				person.cards << new FamilyCard(UUID.randomUUID().toString())
			}
		}
	}
}

