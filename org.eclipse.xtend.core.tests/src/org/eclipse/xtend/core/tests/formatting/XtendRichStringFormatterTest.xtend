/*******************************************************************************
 * Copyright (c) 2012, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.junit.Ignore
import org.junit.Test

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

	@Test def testIrregularIndentation() {
		assertFormattedRichStringExpression('''
			val x = ```
				foo
				  {
				      x
				    }
			```
		''')
	}

	@Test def testIrregularIndentation2() {
		assertFormattedRichStringExpression('''
			val x = ```
				aaaaaaaaaaaaaa: <<bar>>
				        aaaaaa: <<bar>>
				          aaaa: <<bar>>
				 aaaaaaaaaaaaa: <<bar>>
				        aaaaaa: <<bar>>
				           aaa: <<bar>>
				       aaaaaaa: <<bar>>
				 aaaaaaaaaaaaa: <<bar>>
			```
		''')
	}

	@Ignore("indentation increases every time the formatter runs")
	@Test def prefixedForLoop() {
		assertFormattedRichStringExpression('''
			val x = ```
				return <<FOR field : cls.persistentState SEPARATOR "&&">>
					<<Objects>>.equal(<<field.simpleName>>, other.<<field.simpleName>>)
				<<ENDFOR>>
			```
		''')
	}

	@Test def smokeTest() {
		assertFormattedRichStringExpression('''
			val x = ```
				<html>
					<body>
						<<FOR p : paragraphs BEFORE '<div>' SEPARATOR '</div><div>' AFTER '</div>'>>
							<<IF p.headLine != null>>
								<h1><<p.headline>></h1>
							<<ENDIF>>
							<p>
								<<p.text>>
							</p>
						<<ENDFOR>>
					</body>
				</html>
			```
		''')
	}

	@Test def bug450458() {
		'''
			class Foo {
				@Test def testDefaultPackageLeadingWhitespace() {
					```
						<<>>
						   	
						class Foo implements java.io.Serializable {}
					```.assertIsOrganizedTo(```
						import java.io.Serializable
						
						class Foo implements Serializable {}
					```)
				}
			}
		'''.decode.assertUnformattedEqualsFormatted
	}

	@Test def indentThreeTabsLineInIf() {
		'''
			class Generator {
				def generate() {
					```
						<<IF true>>
						
						<<ENDIF>>
					```
				}
			}
		'''.decode.assertFormattedTo('''
			class Generator {
				def generate() {
					```
						<<IF true>>
							
						<<ENDIF>>
					```
				}
			}
		'''.decode)
	}

	// TODO this test case is not 100% correct ... one additional tab should be generated for the blank line.
	// But the formatter code is to complicated. Was not able to generate the correct indentation. But as it is now
	// the test at least ensures that there is no exception generated.
	// See: https://github.com/eclipse/xtext-core/issues/710
	@Test def indentEmptyLineInIf() {
		'''
			class Generator {
				def generate() {
					```
						<<IF true>>
			
						<<ENDIF>>
					```
				}
			}
		'''.decode.assertFormattedTo('''
			class Generator {
				def generate() {
					```
						<<IF true>>
						
						<<ENDIF>>
					```
				}
			}
		'''.decode)
	}

}
