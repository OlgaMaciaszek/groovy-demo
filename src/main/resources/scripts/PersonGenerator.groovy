package scripts

import io.codearte.jfairy.Fairy
import io.codearte.jfairy.producer.person.Person as FairyPerson
import person.Person as MyPerson

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */


(1..200).each {
	FairyPerson fairyPerson = Fairy.create(Locale.getDefault()).person()
	new MyPerson(name: fairyPerson.getFirstName(), surname: fairyPerson.getLastName())
//	personRepository.save(new MyPerson(name: fairyPerson.getFirstName(), surname: fairyPerson.getLastName()))
}

