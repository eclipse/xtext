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
import org.eclipse.xtext.xbase.idea.formatting.AbstractXbaseAdjustLineIndentTest

import static extension org.eclipse.xtext.idea.tests.LibraryUtil.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendAdjustLineIndentTest extends AbstractXbaseAdjustLineIndentTest {

	new() {
		super(XtendFileType.INSTANCE)
	}

	override protected configureModule(Module module, ModifiableRootModel model, ContentEntry contentEntry) {
		model.addXtendLibrary
	}

	def void testXAssignment_05() {
		'''
			class Foo {
				int a
				def foo() {
					this.a = 3
				}
			}
		'''.assertAdjustLineIndent(
		'''
			class Foo {
				int a
				def foo() {
					this.a = 3
				}
			}
		''', false)
	}

	def void testXAssignment_06() {
		'''
			class Foo {
				int a
				def foo() {
					this.a
					=
					3
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				int a
				def foo() {
					this.a
							=
							3
				}
			}
		''', false)
	}

	def void testXFeatureCall_01() {
		'''
			class Foo {
				def foo() {
					values.head
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values.head
				}
			
				def java.util.List<String> values() { null }
			}
		''', false)
	}

	def void testXFeatureCall_02() {
		'''
			class Foo {
				def foo() {
					values
					.
					head
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values
					.
					head
				}
			
				def java.util.List<String> values() { null }
			}
		''', false)
	}

	def void testXFeatureCall_03() {
		'''
			class Foo {
				def foo() {
					values.get(0)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values.get(0)
				}
			
				def java.util.List<String> values() { null }
			}
		''', false)
	}

	def void testXFeatureCall_04() {
		'''
			class Foo {
				def foo() {
					values.get(
					0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values.get(
							0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		''', false)
	}

	def void testXFeatureCall_05() {
		'''
			class Foo {
				def foo() {
					values
					.
					get
					(
					0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values
					.
					get
					(
							0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		''', false)
	}

	def void testXFeatureCall_06() {
		'''
			class Foo {
				def foo() {
					values
					.
					get(
					0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					values
					.
					get(
							0
					)
				}
			
				def java.util.List<String> values() { null }
			}
		''', false)
	}

	def void testXConstructorCall_01() {
		'''
			class Foo {
				def foo() {
					new
					Foo
				}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new
					Foo
				}
			}
		''', false)
	}

	def void testXConstructorCall_02() {
		'''
			class Foo {
				def foo() {
					new Foo(0)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new Foo(0)
				}
			
				new(int x) {}
			}
		''', false)
	}

	def void testXConstructorCall_03() {
		'''
			class Foo {
				def foo() {
					new Foo(
					0
					)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new Foo(
							0
					)
				}
			
				new(int x) {}
			}
		''', false)
	}

	def void testXConstructorCall_04() {
		'''
			class Foo {
				def foo() {
					new
					Foo
					(
					0
					)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new
					Foo
					(
							0
					)
				}
			
				new(int x) {}
			}
		''', false)
	}

	def void testXConstructorCall_05() {
		'''
			class Foo {
				def foo() {
					new
					Foo(
					0
					)
				}
			
				new(int x) {}
			}
		'''.assertAdjustLineIndent('''
			class Foo {
				def foo() {
					new
					Foo(
							0
					)
				}
			
				new(int x) {}
			}
		''', false)
	}

	protected def void assertAdjustLineIndent(CharSequence model, String expectedAdjustedModel, boolean wrap) {
		if (wrap) {
			super.assertAdjustLineIndent(
				'''
					class Foo {
						def foo() {
							«model»
						}
					}
				''',
				'''
					class Foo {
						def foo() {
							«expectedAdjustedModel»
						}
					}
				'''
			)
		} else {
			super.assertAdjustLineIndent(model, expectedAdjustedModel)
		}

	}

	protected override void assertAdjustLineIndent(CharSequence model, String expectedAdjustedModel) {
		assertAdjustLineIndent(model, expectedAdjustedModel, true)
	}

}