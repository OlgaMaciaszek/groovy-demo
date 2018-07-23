import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import person.Person

JsonSlurper jsonSlurper = new JsonSlurper();

Person person = jsonSlurper.parse(new File('secondPerson.json'))

assert person instanceof Person

println(JsonOutput.toJson(person))