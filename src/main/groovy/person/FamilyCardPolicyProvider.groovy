package person

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class FamilyCardPolicyProvider {

	boolean canGiveFamilyCardForPersonWithNoChildren() {
		return true
	}

	boolean canAddCardType(int cardType) {
		return true
	}
}
