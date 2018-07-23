package missing

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class ClassWithMethodMissing {

	def methodMissing(String name, args) {
		return 'Method found'
	}
}
