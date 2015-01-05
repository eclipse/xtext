package org.eclipse.xtext.idea.sdomain.idea.tests.refactoring

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType
import org.eclipse.xtext.idea.tests.LightToolingTest

class RenameTest extends LightToolingTest {
	
	new() {
		super(SDomainFileType.INSTANCE)
	}

	def void testRenameQualifiedName() {
		configureByText("Foo.sdomain",
			'''
				foo {
					entity Foo {
					}
				}
			''')
		configureByText("Bar.sdomain",
			'''
				entity Bar {
					foo.Fo<caret>o foo
				}
			''')
		renameElementAtCaret("Foo2")
		checkResult(
			'''
				entity Bar {
					foo.Foo2 foo
				}
			''')
	}

	def void testRenameWithSeveralCandidates() {
		configureByText("Foo.sdomain",
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
		renameElementAtCaret("String")
		checkResult(
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
