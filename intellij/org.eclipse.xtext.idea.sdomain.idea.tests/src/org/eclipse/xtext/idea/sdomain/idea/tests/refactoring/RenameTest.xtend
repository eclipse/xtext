package org.eclipse.xtext.idea.sdomain.idea.tests.refactoring

import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase

class RenameTest extends LightCodeInsightFixtureTestCase {

	def void testRenameQualifiedName() {
		myFixture.configureByText("Foo.sdomain",
			'''
				foo {
					entity Foo {
					}
				}
			''')
		myFixture.configureByText("Bar.sdomain",
			'''
				entity Bar {
					foo.Fo<caret>o foo
				}
			''')
		myFixture.renameElementAtCaret("Foo2")
		myFixture.checkResult(
			'''
				entity Bar {
					foo.Foo2 foo
				}
			''')
	}

	def void testRenameWithSeveralCandidates() {
		myFixture.configureByText("Foo.sdomain",
			'''
				foo {
				    import bar.*
				    bar {
				        datatype String
				    }
				    entity Foo {
				        String abc
				    }
				    datatype Strin<caret>g2
				}
			''')
		myFixture.renameElementAtCaret("String")
		myFixture.checkResult(
			'''
				foo {
				    import bar.*
				    bar {
				        datatype String
				    }
				    entity Foo {
				        String abc
				    }
				    datatype String
				}
			''')
	}

}
