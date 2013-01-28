package org.eclipse.xtend.core.tests.formatting

import org.junit.Test
import org.junit.Ignore

class XtendRichStringFormatterTest extends AbstractXtendFormatterTest {
	
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
	
	@Test def testIf1() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
				<<IF 1 == 1>>
					bar
				<<ENDIF>>
			```
		''', '''
			val x = ```
			foo
			<<IF 1 == 1>>
			bar
			<<ENDIF>>
			```
		''')
	}
	
	@Test def testIf2() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
				  <<IF 1 == 1>>
				  	bar
				  <<ENDIF>>
				baz
			```
		''', '''
			val x = ```
			foo
			  <<IF 1 == 1>>
			  bar
			  <<ENDIF>>
			baz
			```
		''')
	}
	
	@Test def testIfElse() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
				<<IF 1 == 1>>
					bar
				<<ELSE>>
					baz
				<<ENDIF>>
			```
		''', '''
			val x = ```
			foo
			<<IF 1 == 1>>
			bar
			<<ELSE>>
			baz
			<<ENDIF>>
			```
		''')
	}
	
	@Test def testIfElseIfElse() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
				<<IF 1 == 1>>
					bar
				<<ELSEIF 1 == 1>>
					baz
				<<ELSE>>
					buz
				<<ENDIF>>
			```
		''', '''
			val x = ```
			foo
			<<IF 1 == 1>>
			bar
			<<ELSEIF 1 == 1>>
			baz
			<<ELSE>>
			buz
			<<ENDIF>>
			```
		''')
	}
	
	@Test def testIfElseIfElseInline() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo<<IF 1 == 1>>bar<<ELSEIF 1 == 1>>baz<<ELSE>>buz<<ENDIF>>
			```
		''', '''
			val x = ```
			foo<<IF 1 == 1>>bar<<ELSEIF 1 == 1>>baz<<ELSE>>buz<<ENDIF>>
			```
		''')
	}
	
	@Test def testIfNested() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
				<<IF 1 == 1>>
					bar
					<<IF 1 == 1>>
						baz
					<<ENDIF>>
				<<ENDIF>>
			```
		''', '''
			val x = ```
			foo
			<<IF 1 == 1>>
			bar
			<<IF 1 == 1>>
			baz
			<<ENDIF>>
			<<ENDIF>>
			```
		''')
	}
	
	@Test def testForLoop() {
		assertFormattedRichStringExpression('''
			val x = ```
				<<FOR String y : newArrayList("a")>>
					foo
				<<ENDFOR>>
			```
		''')
	}
	
	@Test def testForLoopInline() {
		assertFormattedRichStringExpression('''
			val x = ```
				<<FOR String y : newArrayList("a")>>foo<<ENDFOR>>
			```
		''')
	}
	
	@Test def testForLoopNested() {
		assertFormattedRichStringExpression('''
			val x = ```
				<<FOR String y : newArrayList("a")>>
					foo
					  <<FOR String y : newArrayList("a")>>
					  	bar
					  <<ENDFOR>>
				<<ENDFOR>>
			```
		''')
	}
	
	@Test def testForLoopParams() {
		assertFormattedRichStringExpression('''
			val x = ```
				<<FOR String y : newArrayList("a") BEFORE 1 + 1 SEPARATOR 1 + 1 AFTER 1 + 1>>
					foo
				<<ENDFOR>>
			```
		''')
	}
	
	@Ignore("https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
	@Test def testForEmpty() {
		assertFormattedRichStringExpression('''
			val x = ```
				<<>>
			```
		''')
	}
	
	@Test def testForSyntaxErrors() {
		assertFormattedRichStringExpressionWithErrors('''
			val x = ```
				<<
			```
		''')
	}
}