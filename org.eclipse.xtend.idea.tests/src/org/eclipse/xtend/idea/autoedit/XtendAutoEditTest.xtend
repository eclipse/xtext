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
import org.eclipse.xtext.xbase.idea.formatting.AbstractXbaseAutoEditTest

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

class XtendAutoEditTest extends AbstractXbaseAutoEditTest {

	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichStringComment_01() {
		'''
		class Foo {
			def foo() '«»''
				«'«««'» lalala|
			'«»''
		}
		'''.assertAutoIndentOnNewLine(
		'''
		class Foo {
			def foo() '«»''
				«'«««'» lalala
				|
			'«»''
		}
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichStringComment_02() {
		'''
		class Foo {
			def foo() '«»''
				«'«««'» lalala|
		'''.assertAutoIndentOnNewLine(
		'''
		class Foo {
			def foo() '«»''
				«'«««'» lalala
				|
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichStringComment_03() {
		'''
		class Foo {
			def foo() '«»''
			«'«'» lalala|
			'«»''
		}
		'''.assertAutoIndentOnNewLine(
		'''
		class Foo {
			def foo() '«»''
			«'«'» lalala
			|
			'«»''
		}
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichStringComment_04() {
		'''
		class Foo {
			def foo() '«»''
			«'«'» lalala|
		'''.assertAutoIndentOnNewLine(
		'''
		class Foo {
			def foo() '«»''
			«'«'» lalala
			|
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichStringComment_05() {
		'''
		class Foo {
			def foo() '«»''
			«'««'» lalala|
			'«»''
		}
		'''.assertAutoIndentOnNewLine(
		'''
		class Foo {
			def foo() '«»''
			«'««'» lalala
			|
			'«»''
		}
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichStringComment_06() {
		'''
		class Foo {
			def foo() '«»''
			«'««'» lalala|
		'''.assertAutoIndentOnNewLine(
		'''
		class Foo {
			def foo() '«»''
			«'««'» lalala
			|
		''')
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
	
	override void test_return_01() {
		'''
			return |
		'''.assertAutoIndentOnNewLine(
		'''
			return 
			|
		''')
	}

	override protected assertAutoIndentOnNewLine(CharSequence model, CharSequence expectedModel) {
		super.assertAutoIndentOnNewLine('''
			class Foo {
				def foo() {
					«model»
				}
			}
		''', '''
			class Foo {
				def foo() {
					«expectedModel»
				}
			}
		''')
	}

}