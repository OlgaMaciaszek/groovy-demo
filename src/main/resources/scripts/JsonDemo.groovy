package scripts

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */

def jsonSlurper = new JsonSlurper()
def object = jsonSlurper.parseText('{ "name": "John Doe" } /* some comment */')

assert object instanceof Map
assert object.name == 'John Doe'

object = jsonSlurper.parseText('{ "myList": [4, 8, 15, 16, 23, 42] }')

assert object instanceof Map
assert object.myList instanceof List
assert object.myList == [4, 8, 15, 16, 23, 42]

object = jsonSlurper.parseText '''
    { "simple": 123,
      "fraction": 123.66,
      "exponential": 123e12
    }'''

assert object instanceof Map
assert object.simple.class == Integer
assert object.fraction.class == BigDecimal
assert object.exponential.class == BigDecimal

def json = JsonOutput.toJson([name: 'John Doe', age: 42])

assert json == '{"name":"John Doe","age":42}'

class Person { String name }

json = JsonOutput.toJson([ new Person(name: 'John'), new Person(name: 'Max') ])

assert json == '[{"name":"John"},{"name":"Max"}]'

json = JsonOutput.toJson([name: 'John Doe', age: 42])

assert json == '{"name":"John Doe","age":42}'

assert JsonOutput.prettyPrint(json) == '''\
{
    "name": "John Doe",
    "age": 42
}'''.stripIndent()