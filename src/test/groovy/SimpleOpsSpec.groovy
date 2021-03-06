import spock.lang.Specification

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */
class SimpleOpsSpec extends Specification {

	def cleanup() {
		new File('test.txt').delete()
	}

	def "should get from URL"() {
		expect:
			'https://gr8conf.us/'.toURL().text.contains('Welcome to GR8Conf US')
	}

	def "should create files"() {
		given:
			File file = new File('test.txt')
			file << 'File Content'
		when:
			def lines = file.readLines()
		then:
			lines[0] == 'File Content'
	}


}


