/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.psi

import com.intellij.psi.PsiClass
import com.intellij.psi.PsiField
import com.intellij.psi.PsiMethod
import org.eclipse.xtend.idea.LightXtendTest
import org.junit.Test
import com.intellij.psi.PsiEnumConstant

/**
 * @author kosyakov - Initial contribution and API
 */
class XtextPsiReferenceTest extends LightXtendTest {

	@Test
	def void testGetTextOffset() {
		val model = '''
			package mypackage
			
			import java.io.File
			
			class Main {
				def static void main(String[] args) {
					val file = new File('lalala')
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('File(')
		val reference = file.findReferenceAt(index)
		val element = reference.element
		val textRange = element.textRange
		val textOffset = element.textOffset
		assertTrue(textRange + ' ' + textOffset, textRange.contains(textOffset))
	}

	@Test
	def void testDeclaredType() {
		val model = '''
			package mypackage
			
			class Foo {
				def foo(String value) {}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Foo.xtend', model)

		val index = model.indexOf('String')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		if (referencedElement instanceof PsiClass)
			assertEquals('java.lang.String', referencedElement.qualifiedName)
		else
			fail('' + referencedElement)
	}

	@Test
	def void testDefaultConstructor() {
		val psiClass = myFixture.addClass('''
			package mypackage;
			
			public class Bar {}
		''')

		val model = '''
			package mypackage
			
			class Foo {
				def foo() {
					new Bar
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Foo.xtend', model)

		val index = model.indexOf('Bar')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		assertEquals(psiClass, referencedElement)
	}

	@Test
	def void testConstructor() {
		val model = '''
			package mypackage
			
			class Foo {
				def foo() {
					new String('lalala')
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('String')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		if (referencedElement instanceof PsiMethod) {
			assertTrue(referencedElement.constructor)
			assertEquals('String', referencedElement.name)
		} else
			fail('' + referencedElement)
	}

	@Test
	def void testField() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar {
				public String myField = "Hello World!";
			}
		''')
		val model = '''
			package mypackage
			
			class Foo {
				def foo(Bar bar) {
					bar.myField
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('myField')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		if (referencedElement instanceof PsiField) {
			assertEquals('myField', referencedElement.name)
		} else
			fail('' + referencedElement)
	}

	@Test
	def void testEnumLiteral() {
		myFixture.addClass('''
			package mypackage;
			
			public enum Bar {
				MY_ENUM_LITERAL
			}
		''')
		val model = '''
			package mypackage
			
			class Foo {
				def foo() {
					Bar.MY_ENUM_LITERAL
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('MY_ENUM_LITERAL')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		if (referencedElement instanceof PsiEnumConstant) {
			assertEquals('MY_ENUM_LITERAL', referencedElement.name)
		} else
			fail('' + referencedElement)
	}
	
	@Test
	def void testValueOf() {
		val psiClass = myFixture.addClass('''
			package mypackage;
			
			public enum Bar {}
		''')
		val model = '''
			package mypackage
			
			class Foo {
				def foo() {
					Bar.valueOf('MY_ENUM_LITERAL')
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('valueOf')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		assertEquals(psiClass, referencedElement)
	}

	@Test
	def void testValues() {
		val psiClass = myFixture.addClass('''
			package mypackage;
			
			public enum Bar {}
		''')
		val model = '''
			package mypackage
			
			class Foo {
				def foo() {
					Bar.values
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('values')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		assertEquals(psiClass, referencedElement)
	}

	@Test
	def void testMethod() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar {
				public String myMethod() { 
					return "Hello World!";
				}
			}
		''')
		val model = '''
			package mypackage
			
			class Foo {
				def foo(Bar bar) {
					bar.myMethod
				}
			}
		'''
		val file = myFixture.addFileToProject('mypackage/Main.xtend', model)

		val index = model.indexOf('myMethod')
		val reference = file.findReferenceAt(index)
		val referencedElement = reference.resolve
		if (referencedElement instanceof PsiMethod) {
			assertFalse(referencedElement.constructor)
			assertEquals('myMethod', referencedElement.name)
		} else
			fail('' + referencedElement)
	}

}