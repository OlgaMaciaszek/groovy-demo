package scripts

import groovy.json.JsonOutput
import groovy.json.JsonSlurper

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */

JsonSlurper jsonSlurper = new JsonSlurper()

def person = jsonSlurper.parseText(this.getClass().getResource('secondPerson.json').text)

assert person instanceof Map
assert person.children instanceof List
assert person.children.size == 2
assert person.name == 'Anna'
assert person.surname instanceof String
assert person.children.find {it.name == 'Jane'}.surname == 'Smith'
assert person.children[1].name == 'Adam'
println person

String json = JsonOutput.toJson(person)
println json