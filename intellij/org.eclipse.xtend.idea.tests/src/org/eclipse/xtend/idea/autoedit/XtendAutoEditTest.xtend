/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import com.intellij.openapi.module.Module
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.roots.ModifiableRootModel
import org.eclipse.xtend.core.idea.lang.XtendFileType
import org.eclipse.xtext.idea.tests.AbstractAutoEditTest

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

class XtendAutoEditTest extends AbstractAutoEditTest {

	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
	}

	def void testClassBraces() {
		configureByText('''class Foo {|''')
		newLine
		assertState('''
		class Foo {
			|
		}''')
	}

	def void testMethodParentheses() {
		configureByText('''
			class Foo {
				def bar|
			}
		''')
		myFixture.type("(")
		assertState('''
			class Foo {
				def bar(|)
			}
		''')
	}

	def void testMethodBraces() {
		configureByText('''
			class Foo {
				def bar() {|
			}
		''')
		newLine
		assertState('''
			class Foo {
				def bar() {
					|
				}
			}
		''')
	}

	def void testFeatureCallParentheses() {
		configureByText('''
			class Foo {
				def bar() {
					toString|
				}
			}
		''')
		myFixture.type("(")
		assertState('''
			class Foo {
				def bar() {
					toString(|)
				}
			}
		''')
	}

	def void testArrayBrackets() {
		configureByText('''
			class Foo {
				def bar(int|)
			}
		''')
		myFixture.type("[")
		assertState('''
			class Foo {
				def bar(int[|])
			}
		''')
	}

	def void testGuillemets() {
		configureByText("
			class Foo {
				def bar() {
					'''|'''
				}
			}
		")
		myFixture.type("«")
		assertState("
			class Foo {
				def bar() {
					'''«|»'''
				}
			}
		")
	}

	def void testEnterBetweenMethods_01() {
		configureByText('''
			class Foo {
				def foo() {
				}|
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				|
				def bar() {
				}
			}
		''')
	}

	def void testEnterBetweenMethods_02() {
		configureByText('''
			class Foo {
				def foo() {
				}
				|
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				
				|
				def bar() {
				}
			}
		''')
	}

	def void testEnterBetweenMethods_03() {
		configureByText('''
			class Foo {
				def foo() {
				}
				//lalala|
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				//lalala
				|
				def bar() {
				}
			}
		''')
	}

	def void testEnterBetweenMethods_04() {
		configureByText('''
			class Foo {
				def foo() {
				}
				|//lalala
				def bar() {
				}
			}
		''')
		newLine
		assertState('''
			class Foo {
				def foo() {
				}
				
				|//lalala
				def bar() {
				}
			}
		''')
	}

}