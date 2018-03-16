import person.Address
import person.FamilyCardPolicyProvider
import person.Person
import person.PersonService
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class PersonServiceSpec extends Specification {

	@Subject
	PersonService personService
	FamilyCardPolicyProvider policyProvider = Mock(FamilyCardPolicyProvider)
	Person person
	Person child
	Address address

	def setup() {
		personService = new PersonService(policyProvider)
		address = new Address('58. Birch Street', '00000', 'Shady Valley')
		person = new Person('Anna', 'Smith')
		child = new Person('Jane', 'Smith', address)
	}

	def "newly created person should have no children"() {
		expect:
			!new Person().children
	}

	def "should add new child"() {
		when:
			personService.addChild(person, child)
		then:
			notThrown IllegalArgumentException
			person.children
			person.children[0].name == 'Jane'
	}

	def "should not add the same child twice"() {
		when:
			personService.addChild(person, child)
			personService.addChild(person, child)
		then:
			thrown IllegalArgumentException
	}

	def "should add two different children"() {
		given:
			Person childTwo = new Person('Adam', 'Smith', address)
		when:
			personService.addChild(person, child)
			personService.addChild(person, childTwo)
		then:
			person.children.size() == 2
			person.children*.surname.every {it == 'Smith'} // not: each{} !!!
			person.children.surname.every {it == 'Smith'}
	}

	def "should not add family card when person has no children"() {
		given:
			Person person = new Person('Anna', 'Smith')
		when:
			personService.addFamilyCard(person, 1)
		then:
			1 * policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> false
//			0 * policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> false // zero calls
//			(1..3) * policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> false // between one and three calls (inclusive)
//			(1.._) * policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> false  // at least one call
//			(_..3) * policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> false  // at most three calls
//			_ * policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> false  // any number of calls - should not be used most of the time
			1 * policyProvider.canAddCardType(1) >> true
//			1 * policyProvider.canAddCardType(!1) >> true
//			1 * policyProvider.canAddCardType() >> true
//			1 * policyProvider.canAddCardType(_) >> true
//			1 * policyProvider.canAddCardType(*_) >> true
//			1 * policyProvider.canAddCardType(!null) >> true
//			1 * policyProvider.canAddCardType(_ as int) >> true
			0* _  // Nothin else happened
			!person.cards
	}

	@Unroll
	def "should add family card only when canAddCardType = #canAddCardType and canAddForNoChildren = #canAddForNoChildren"() {
		given:
			policyProvider.canAddCardType(1) >> canAddCardType
			policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> canAddForNoChildren
		when:
			personService.addFamilyCard(person, 1)
		then:
			person.cards.size() == added
		where:
			canAddCardType | canAddForNoChildren | added
			true           | false               | 0
			false          | true                | 0
			false          | false               | 0
			true           | true                | 1
	}

	@Unroll
	def "should add family card only when card type 1 and 2"() {
		given:
			policyProvider.canAddCardType(1) >> true
			policyProvider.canAddCardType(2) >> true
			policyProvider.canGiveFamilyCardForPersonWithNoChildren() >> true
		when:
			personService.addFamilyCard(person, cardType)
		then:
			person.cards
		where:
			cardType << [1, 2]
	}
}
