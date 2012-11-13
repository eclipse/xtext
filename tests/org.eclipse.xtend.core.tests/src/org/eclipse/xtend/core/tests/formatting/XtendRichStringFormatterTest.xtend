package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

class XtendRichStringFormatterTest extends AbstractFormatterTest {
	
	def private String decode(CharSequence seq) {
		seq.toString.replace("<<", "«").replace(">>", "»").replace("```", "'''")
	}
	
	def void assertFormattedRichStringExpression(CharSequence seq) {
		assertFormattedExpression(seq.decode) 
	}
	
	def void assertFormattedRichStringExpression(CharSequence expected, CharSequence actual) {
		assertFormattedExpression(expected.decode, actual.decode) 
	}
	
	@Test def testSimple() {
		assertFormattedRichStringExpression('''
			val x = ```foo```;
		''')
	}
	
	@Test def testSimpleVar() {
		assertFormattedRichStringExpression('''
			val x = ```foo<<newArrayList()>>>bar```
		''')
	}
	
	@Test def testIndentation1() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
			```
		''', '''
			val x = ```
			foo
			```
		''')
	}
	
	@Test def testIndentation2() {
		assertFormattedRichStringExpression('''
			val x = ```x
			foo
			```
		''')
	}
	
	@Test def testIndentation3() {
		assertFormattedRichStringExpression('''
			val x = ```x
			  foo
			```
		''')
	}
	
	@Test def testIndentation4() {
		assertFormattedRichStringExpression('''
			val x = ```
			  foo
			x```
		''')
	}
	
	@Test def testIndentation5() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
				<<IF true>>
					bar
				<<ENDIF>>
			```
		''', '''
			val x = ```
			foo
			<<IF true>>
			bar
			<<ENDIF>>
			```
		''')
	}
}