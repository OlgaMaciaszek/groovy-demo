package missing

import spock.lang.Specification

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class ClassWithMethodMissingSpec extends Specification {

	def "should return true when calling a method that does not even exist"() {
		expect:
			new ClassWithMethodMissing().test() == 'Method found'
	}
}
