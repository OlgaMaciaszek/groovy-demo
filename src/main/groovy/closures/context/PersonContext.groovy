package closures.context
/**
 * @author Olga Maciaszek-Sharma
 * @since 3/13/18
 */
class PersonContext {

	void name(String name) {
		println name
	}

	void surname(String surname) {
		println surname
	}

	void address(@DelegatesTo Closure closure) {
		AddressContext addressContext = new AddressContext()
		Closure addressClosure = closure.rehydrate(addressContext, this, this)
		addressClosure.setResolveStrategy(Closure.DELEGATE_ONLY)
		addressClosure()
	}

}
