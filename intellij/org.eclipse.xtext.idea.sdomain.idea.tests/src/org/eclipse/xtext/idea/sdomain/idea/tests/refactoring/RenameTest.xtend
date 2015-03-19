/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.tests.refactoring

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType
import org.eclipse.xtext.idea.tests.LightToolingTest

class RenameTest extends LightToolingTest {
	
	new() {
		super(SDomainFileType.INSTANCE)
	}

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
