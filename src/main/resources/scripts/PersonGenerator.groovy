package scripts

import io.codearte.jfairy.Fairy

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */

PersonRepos

(1..200).each {
	io.codearte.jfairy.producer.person.Person fairyPerson = Fairy.create(Locale.getDefault()).person();
	personHelper.save(new person.Person(fairyPerson.getFirstName(), fairyPerson.getLastName()));
}

