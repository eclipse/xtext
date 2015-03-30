/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.psi

import com.intellij.psi.PsiModifier
import com.intellij.psi.PsiReferenceList
import org.eclipse.xtend.idea.LightXtendTest

/**
 * @author kosyakov - Initial contribution and API
 */
class JvmPsiClassTest extends LightXtendTest {

	def void testCyclicResolution() {
		myFixture.addClass('''
			package mypackage;
			
			public class Bar {
			
				public void callToFoo(Foo foo) {
					foo.callToBar(this);
				}
			
			}
		''')
		val xtendFile = myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
			
				def void callToBar(Bar bar) {
					bar.callToFoo(this)
				}
			
			}
		''')
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
	}
	
	def void testMethodBodyWithErrors() {
		myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
			
				def methodWithErros() {
					Bar.blabla
				}
			
			}
		''')
		val psiClass = 'mypackage.Foo'.findJvmPsiClass
		assertSize(1, psiClass.methods)
		
		val method = psiClass.findMethodsByName('methodWithErros', false)
		assertNotNull(method)
	}

	def void testStub() {
		myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			class Foo {
			}
		''')
		val psiClass = 'mypackage.Foo'.findJvmPsiClass
		psiClass.psiClassProvider = [
			fail()
			null
		]
		assertEquals('Foo', psiClass.name)
		assertEquals('mypackage.Foo', psiClass.qualifiedName)
		assertNotNull(psiClass.containingFile)
		assertNull(psiClass.containingClass)
		
		assertTrue(psiClass.modifierList.hasModifierProperty(PsiModifier.PUBLIC))
		assertFalse(psiClass.modifierList.hasModifierProperty(PsiModifier.PACKAGE_LOCAL))
		assertFalse(psiClass.modifierList.hasModifierProperty(PsiModifier.PRIVATE))
		
		assertTrue(psiClass.hasModifierProperty(PsiModifier.PUBLIC))
		assertFalse(psiClass.hasModifierProperty(PsiModifier.PACKAGE_LOCAL))
		assertFalse(psiClass.hasModifierProperty(PsiModifier.PRIVATE))
		
		assertFalse(psiClass.interface)
		assertFalse(psiClass.enum)
		assertFalse(psiClass.annotationType)
	}

	def void testStub_Accessability() {
		myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			package class Foo {
			}
		''')
		val psiClass = 'mypackage.Foo'.findJvmPsiClass
		psiClass.psiClassProvider = [
			fail()
			null
		]
		
		assertFalse(psiClass.modifierList.hasModifierProperty(PsiModifier.PUBLIC))
		assertTrue(psiClass.modifierList.hasModifierProperty(PsiModifier.PACKAGE_LOCAL))
		assertFalse(psiClass.modifierList.hasModifierProperty(PsiModifier.PRIVATE))
		
		assertFalse(psiClass.hasModifierProperty(PsiModifier.PUBLIC))
		assertTrue(psiClass.hasModifierProperty(PsiModifier.PACKAGE_LOCAL))
		assertFalse(psiClass.hasModifierProperty(PsiModifier.PRIVATE))
	}

	def void testStub_Interface() {
		myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			interface Foo {
			}
		''')
		val psiClass = 'mypackage.Foo'.findJvmPsiClass
		psiClass.psiClassProvider = [
			fail()
			null
		]
		assertTrue(psiClass.interface)
	}

	def void testStub_Enum() {
		myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			enum Foo {
			}
		''')
		val psiClass = 'mypackage.Foo'.findJvmPsiClass
		psiClass.psiClassProvider = [
			fail()
			null
		]
		assertTrue(psiClass.enum)
	}

	def void testStub_Annotation() {
		myFixture.addFileToProject('mypackage/Foo.xtend', '''
			package mypackage
			
			annotation Foo {
			}
		''')
		val psiClass = 'mypackage.Foo'.findJvmPsiClass
		psiClass.psiClassProvider = [
			fail()
			null
		]
		assertTrue(psiClass.annotationType)
	}

	def void testGetQualifiedName() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			class Foo {
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		assertEquals('foo.Foo', psiClass.qualifiedName)
		assertFalse(psiClass.interface)
		assertFalse(psiClass.annotationType)
		assertFalse(psiClass.enum)
		assertEmpty(psiClass.extendsList.referenceElements)
		assertEmpty(psiClass.extendsList.referencedTypes)
		assertEmpty(psiClass.fields)
		assertEmpty(psiClass.methods)
		assertFalse(psiClass.hasTypeParameters)
		assertEmpty(psiClass.typeParameterList.typeParameters)
		assertEmpty(psiClass.typeParameters)
	}

	def void testIsInterface() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			interface Foo {
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		assertTrue(psiClass.interface)
	}

	def void testIsAnnotationType() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			annotation Foo {
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		assertTrue(psiClass.annotationType)
	}

	def void testIsEnum() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			enum Foo {
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		assertTrue(psiClass.enum)
	}

	def void testGetExtendsList() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			
			import java.util.ArrayList
			
			class Foo extends ArrayList<Object> {
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		val extendsList = psiClass.extendsList
		assertEquals(PsiReferenceList.Role.EXTENDS_LIST, extendsList.role)
		assertSize(1, extendsList.referenceElements)
		assertSize(1, extendsList.referencedTypes)
		assertEquals('java.util.ArrayList', extendsList.referencedTypes.head.resolve.qualifiedName)
	}

	def void testGetExtendsList2() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			
			class Foo extends Bar {
			}
			
			class Bar {
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		val extendsList = psiClass.extendsList
		assertEquals(PsiReferenceList.Role.EXTENDS_LIST, extendsList.role)
		assertSize(1, extendsList.referenceElements)
		assertSize(1, extendsList.referencedTypes)
		val extendedClass = extendsList.referencedTypes.head.resolve
		assertEquals('foo.Bar', extendedClass.qualifiedName)
	}
	
	def void testGetFields() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			class Foo {
				String foo
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		val fields = psiClass.fields
		assertSize(1, fields)
		val field = fields.head
		assertNotNull(field)
		assertEquals('foo', field.name)
	}
	
	def void testGetMethods() {
		myFixture.configureByText('Foo.xtend', '''
			package foo

			class Foo {
			
			    def foo() {
			    }
			
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		val methods = psiClass.methods
		assertSize(1, methods)
		val method = methods.head
		assertNotNull(method)
		assertEquals('foo', method.name)
	}
	
	def testPsiTypeParameterListOwner() {
		myFixture.configureByText('Foo.xtend', '''
			package foo
			class Foo<T extends Number> {
			}
		''')
		val psiClass = 'foo.Foo'.findJvmPsiClass
		
		assertTrue(psiClass.hasTypeParameters)
		
		val typeParameters = psiClass.typeParameters
		assertSize(1, typeParameters)
		
		val typeParameter = typeParameters.head
		assertEquals(0, typeParameter.index)
		assertEquals('T', typeParameter.name)
		assertEquals(psiClass.delegate, typeParameter.owner)
		
		val extendsList = typeParameter.extendsList
		assertEquals(PsiReferenceList.Role.EXTENDS_BOUNDS_LIST, extendsList.role)
		assertSize(1, extendsList.referenceElements)
		assertSize(1, extendsList.referencedTypes)
		val extendedClass = extendsList.referencedTypes.head.resolve
		assertEquals('java.lang.Number', extendedClass.qualifiedName)
		
		assertSize(1, psiClass.typeParameterList.typeParameters)
		assertEquals(typeParameter, psiClass.typeParameterList.typeParameters.head)
		assertEquals(0, psiClass.typeParameterList.getTypeParameterIndex(typeParameter))
	}

}