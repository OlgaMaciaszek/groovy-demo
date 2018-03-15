package scripts

import groovy.util.slurpersupport.GPathResult

/**
 * @author Olga Maciaszek-Sharma
 * @since 3/15/18
 */

def text = '''
    <list>
        <technology>
            <name>Groovy</name>
        </technology>
    </list>
'''

def list = new XmlSlurper().parseText(text)

assert list instanceof GPathResult
assert list.technology.name == 'Groovy'


String books = '''
    <response version-api="2.0">
        <value>
            <books>
                <book available="20" id="1">
                    <title>Don Xijote</title>
                    <author id="1">Manuel De Cervantes</author>
                </book>
                <book available="14" id="2">
                    <title>Catcher in the Rye</title>
                   <author id="2">JD Salinger</author>
               </book>
               <book available="13" id="3">
                   <title>Alice in Wonderland</title>
                   <author id="3">Lewis Carroll</author>
               </book>
               <book available="5" id="4">
                   <title>Don Xijote</title>
                   <author id="4">Manuel De Cervantes</author>
               </book>
           </books>
       </value>
    </response>
'''

def response = new XmlSlurper().parseText(books)
def authorResult = response.value.books.book[0].author

assert authorResult.text() == 'Manuel De Cervantes'

def book = response.value.books.book[0]
def bookAuthorId1 = book.@id

assert bookAuthorId1 == '1'
assert bookAuthorId1.toInteger() == 1