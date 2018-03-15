import groovy.json.JsonSlurper;

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
public class LibPersonLoader {

	public Object parseJson(String jsonPath) {
		return new JsonSlurper().parse(this.getClass().getResource(jsonPath));
	}

}
