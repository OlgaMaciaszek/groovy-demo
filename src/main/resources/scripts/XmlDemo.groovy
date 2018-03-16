package scripts

import groovy.util.slurpersupport.GPathResult

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */

def text = '''
    <person>
        <children>
           <child id="1">
            <name>Jane</name>
            <surname>Smith</surname>
           </child>
        </children>
    </person>
'''

def person = new XmlSlurper().parseText(text)

assert person instanceof GPathResult
assert person.children.child[0].name == 'Jane'
assert person.children.child[0].@id.toInteger() == 1