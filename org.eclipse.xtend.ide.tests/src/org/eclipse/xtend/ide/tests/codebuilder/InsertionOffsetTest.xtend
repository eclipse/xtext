package org.eclipse.xtend.ide.tests.codebuilder

import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import com.google.inject.Inject
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtend.core.xtend.XtendFile
import org.junit.Test
import org.eclipse.xtend.ide.codebuilder.InsertionOffsets
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtext.resource.EObjectAtOffsetHelper
import org.eclipse.xtext.resource.XtextResource

class InsertionOffsetTest extends AbstractXtendUITestCase {
	
	@Inject extension ParseHelper<XtendFile> parseHelper
	
	@Inject extension InsertionOffsets
	 
	@Inject extension EObjectAtOffsetHelper
	 
	@Test
	def testField_0() {
		'''
			class Foo {
				int x$
				new() {
				}
				def foo() {|
				}
			}
		'''.checkFieldInsertionOffset
	}
	
	@Test
	def testField_1() {
		'''
			class Foo {
				int x
				new() {
				}
				int y$
				def foo() {|
				}
			}
		'''.checkFieldInsertionOffset
	}
	
	@Test
	def testField_2() {
		'''
			class Foo {
				$new() {
				}
				def foo() {|
				}
			}
		'''.checkFieldInsertionOffset
	}
	
	@Test
	def testField_3() {
		'''
			class Foo {$
				|
			}
		'''.checkFieldInsertionOffset
	}
	
	@Test
	def testMethod_0() {
		'''
			class Foo {
				int x
				new() {
				}
				def foo() {|
				}$
				def bar() {
				}
			}
		'''.checkMethodInsertionOffset
	}
	
	@Test
	def testMethod_1() {
		'''
			class Foo {
				int x
				new() {
					|
				}$
			}
		'''.checkMethodInsertionOffset
	}
	
	@Test
	def testMethod_2() {
		'''
			class Foo {$
				|
			}
		'''.checkMethodInsertionOffset
	}
	
	@Test
	def testConstructor_0() {
		'''
			class Foo {
				int x
				new() {
				}$
				def foo() {
				}
				def bar() {|
				}
			}
		'''.checkConstructorInsertionOffset
	}
	
	@Test
	def testConstructor_1() {
		'''
			class Foo {
				new() {
					|
				}$
			}
		'''.checkConstructorInsertionOffset
	}
	
	@Test
	def testConstructor_2() {
		'''
			class Foo {
				int x
				double y$
				
				def foo() {|
				}
			}
		'''.checkConstructorInsertionOffset
	}
	
	@Test
	def testConstructor_3() {
		'''
			class Foo {$
				|
			}
		'''.checkConstructorInsertionOffset
	}
	
	@Test
	def testClass() {
		'''
			class Foo {
				|
			}$
			class Bar {
			}
		'''.checkTypeInsertionOffset
	}
	
	def protected checkFieldInsertionOffset(CharSequence model) {
		val modelAsString = model.toString
		val caretOffset = modelAsString.replace('$', '').indexOf('|')
		val expectedOffset = modelAsString.replace('|', '').indexOf('$')
		val xtendClass = parse(modelAsString.replace('|', '').replace('$', '')).xtendTypes.head as XtendClass
		val xtextResource = xtendClass.eResource as XtextResource
		val caretElement = xtextResource.resolveContainedElementAt(caretOffset)
		assertEquals(expectedOffset, getNewFieldInsertOffset(caretElement, xtendClass))		
	}
	
	def protected checkMethodInsertionOffset(CharSequence model) {
		val modelAsString = model.toString
		val caretOffset = modelAsString.replace('$', '').indexOf('|')
		val expectedOffset = modelAsString.replace('|', '').indexOf('$')
		val xtendClass = parse(modelAsString.replace('|', '').replace('$', '')).xtendTypes.head as XtendClass
		val xtextResource = xtendClass.eResource as XtextResource
		val caretElement = xtextResource.resolveContainedElementAt(caretOffset)
		assertEquals(expectedOffset, getNewMethodInsertOffset(caretElement, xtendClass))		
	}
	
	def protected checkConstructorInsertionOffset(CharSequence model) {
		val modelAsString = model.toString
		val caretOffset = modelAsString.replace('$', '').indexOf('|')
		val expectedOffset = modelAsString.replace('|', '').indexOf('$')
		val xtendClass = parse(modelAsString.replace('|', '').replace('$', '')).xtendTypes.head as XtendClass
		val xtextResource = xtendClass.eResource as XtextResource
		val caretElement = xtextResource.resolveContainedElementAt(caretOffset)
		assertEquals(expectedOffset, getNewConstructorInsertOffset(caretElement, xtendClass))		
	}

	def protected checkTypeInsertionOffset(CharSequence model) {
		val modelAsString = model.toString
		val caretOffset = modelAsString.replace('$', '').indexOf('|')
		val expectedOffset = modelAsString.replace('|', '').indexOf('$')
		val xtendClass = parse(modelAsString.replace('|', '').replace('$', '')).xtendTypes.head as XtendClass
		val xtextResource = xtendClass.eResource as XtextResource
		val caretElement = xtextResource.resolveContainedElementAt(caretOffset)
		assertEquals(expectedOffset, getNewTypeInsertOffset(caretElement, xtendClass))		
	}
}