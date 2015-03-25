/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.sdomain.idea.tests.psi

import com.intellij.codeInsight.TargetElementUtilBase
import com.intellij.testFramework.fixtures.LightCodeInsightFixtureTestCase
import com.intellij.util.IncorrectOperationException
import org.eclipse.xtext.psi.PsiEObjectIdentifier
import org.eclipse.xtext.psi.PsiNamedEObject

import static com.intellij.codeInsight.TargetElementUtilBase.*

class PsiNamedEObjectTest extends LightCodeInsightFixtureTestCase {

	def void testEntity_01() {
		'''
			entity Foo {
			}
		'''.testPsiNamedEObject('Foo', 'Bar')
	}

	def void testEntity_02() {
		'''
			entity 			
				// Hello World!
				
				
				/* Hello 
						World! */
						
							Foo
							
							// Hello World!
				
				
				/* Hello 
						World! */
							
				{
			}
		'''.testPsiNamedEObject('Foo', 'Bar')
	}

	def void testEntity_03() {
		'''
			a.b.c {
				entity Foo {
				}
			}
		'''.testPsiNamedEObject('Foo', 'Bar')
	}

	def void testEntity_04() {
		'''
			a.b.c {
				entity 
				
				// Hello World!
				
				
				/* Hello 
						World! */
						
								Foo 
						// Hello World!
				
				
				/* Hello 
						World! */				{
				}
			}
		'''.testPsiNamedEObject('Foo', 'Bar')
	}

	def void testEntity_05() {
		try {
			'entity Foo {}'.testPsiNamedEObject('Foo', '12')
			fail('IncorrectOperationException is expected')
		} catch (RuntimeException e) {
			if (e.cause instanceof IncorrectOperationException) {
				// Do nothing	
			} else {
				throw e
			}
		}
	}

	def void testEntity_06() {
		try {
			'entity Foo {}'.testPsiNamedEObject('Foo', 'a.b.c')
			fail('IncorrectOperationException is expected')
		} catch (RuntimeException e) {
			if (e.cause instanceof IncorrectOperationException) {
				// Do nothing	
			} else {
				throw e
			}
		}
	}

	def void testEntity_07() {
		try {
			'entity Foo {}'.testPsiNamedEObject('Foo', '')
			fail('IncorrectOperationException is expected')
		} catch (RuntimeException e) {
			if (e.cause instanceof IncorrectOperationException) {
				// Do nothing	
			} else {
				throw e
			}
		}
	}

	def void testEntity_08() {
		try {
			'entity Foo {}'.testPsiNamedEObject('Foo', '		')
			fail('IncorrectOperationException is expected')
		} catch (RuntimeException e) {
			if (e.cause instanceof IncorrectOperationException) {
				// Do nothing	
			} else {
				throw e
			}
		}
	}

	def void testEntity_09() {
		'entity Foo {}'.testPsiNamedEObject('oo', 'Foo', 'Bar')
	}

	def void testEntity_10() {
		'entity Foo {}'.testPsiNamedEObject('o ', 'Foo', 'Bar')
	}

	def void testEntity_11() {
		'entity Foo {}'.testPsiNamedEObject(' {', 'Foo', 'Bar')
	}

	def void testEntity_12() {
		'entity Foo {}'.testNotPsiNamedEObject(' Foo')
	}

	def void testEntity_13() {
		'entity Foo {}'.testNotPsiNamedEObject('{}')
	}

	def void testNamespace_01() {
		'''
			a.b.c {
			}
		'''.testPsiNamedEObject('a.b.c', 'd.e.f')
	}

	def void testNamespace_02() {
		'''
							
							
							// Hello World!
				
				
				/* Hello 
						World! */
						
							a.b.c 
						
							// Hello World!
				
				
				/* Hello 
						World! */
					{
			}
		'''.testPsiNamedEObject('a.b.c', 'd.e.f')
	}

	def void testNamespace_03() {
		'''
			a.b.c {
				d.e.f {
				}
			}
		'''.testPsiNamedEObject('d.e.f', 'c.b.a')
	}

	def void testNamespace_04() {
		'''
			a.b.c {
							
			// Hello World!
				
				
				/* Hello 
						World! */				
							
							d.e.f 
							
							// Hello World!
				
				
				/* Hello 
						World! */
						{
				}
			}
		'''.testPsiNamedEObject('d.e.f', 'c.b.a')
	}

	def void testNamespace_05() {
		try {
			'a.b.c {}'.testPsiNamedEObject('a.b.c', '12')
			fail('IncorrectOperationException is expected')
		} catch (RuntimeException e) {
			if (e.cause instanceof IncorrectOperationException) {
				// Do nothing	
			} else {
				throw e
			}
		}
	}

	def void testNamespace_06() {
		try {
			'a.b.c {}'.testPsiNamedEObject('a.b.c', '')
			fail('IncorrectOperationException is expected')
		} catch (RuntimeException e) {
			if (e.cause instanceof IncorrectOperationException) {
				// Do nothing	
			} else {
				throw e
			}
		}
	}

	def void testNamespace_07() {
		try {
			'a.b.c {}'.testPsiNamedEObject('a.b.c', '		')
			fail('IncorrectOperationException is expected')
		} catch (RuntimeException e) {
			if (e.cause instanceof IncorrectOperationException) {
				// Do nothing	
			} else {
				throw e
			}
		}
	}
	
	def void testNamespace_08() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testNotPsiNamedEObject(' a')
	}
	
	def void testNamespace_09() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject('a.', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_10() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject('.b', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_11() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject('b.', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_12() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject('./* lalala */c', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_13() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject('/* lalala */c', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_14() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject('ala */c', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_15() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject('c ', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_16() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testPsiNamedEObject(' {}', 'a.b./* lalala */c', 'd.e.f')
	}
	
	def void testNamespace_17() {
		'''
			import foo
			
			 a.b./* lalala */c {}
		'''.testNotPsiNamedEObject('{}')
	}

	def void testDatatype_01() {
		'''
			datatype String
		'''.testPsiNamedEObject('String', 'Integer')
	}

	def void testDatatype_02() {
		'''
						
					datatype 
					
					// Hello World!
				
				
				/* Hello 
						World! */
								
			String
					// Hello World!
				
				
				/* Hello 
						World! */
					
		'''.testPsiNamedEObject('String', 'Integer')
	}

	def void testDatatype_03() {
		'''
			a.b.c {
				datatype String
			}
		'''.testPsiNamedEObject('String', 'Integer')
	}

	def void testDatatype_04() {
		'''
			a.b.c {
				datatype 
				
				// Hello World!
				
				
				/* Hello 
						World! */
						
							String
							
					// Hello World!
				
				
				/* Hello 
						World! */		
							
							
			}
		'''.testPsiNamedEObject('String', 'Integer')
	}

	protected def testNotPsiNamedEObject(CharSequence text, String textAfterCaret) {
		text.toString.testNotPsiNamedEObject(textAfterCaret)
	}

	protected def testPsiNamedEObject(CharSequence text, String name, String newName) {
		text.testPsiNamedEObject(name, name, newName)
	}

	protected def testPsiNamedEObject(CharSequence text, String textAfterCaret, String name, String newName) {
		text.toString.testPsiNamedEObject(textAfterCaret, name, newName)
	}

	protected def testNotPsiNamedEObject(String text, String textAfterCaret) {
		assertNull(text.findPsiNamedEObject(textAfterCaret))
	}

	protected def testPsiNamedEObject(String text, String textAfterCaret, String name, String newName) {
		text.findPsiNamedEObject(textAfterCaret).testPsiNamedEObject(text, name, newName)
	}

	protected def testPsiNamedEObject(PsiNamedEObject element, String text, String name, String newName) {
		assertNotNull(element)

		val nameOffset = text.indexOf(name)
		element.assertPsiNamedEObject(name, nameOffset)

		myFixture.renameElement(element, newName)
		element.assertPsiNamedEObject(newName, nameOffset)
	}

	protected def assertPsiNamedEObject(PsiNamedEObject element, String name, int nameOffset) {
		assertEquals(nameOffset, element.textOffset)
		assertEquals(name, element.name)
		element.nameIdentifier.assertPsiEObjectIdentifier(element, name, nameOffset)
	}

	protected def assertPsiEObjectIdentifier(PsiEObjectIdentifier identifier, PsiNamedEObject element, String name,
		int nameOffset) {
		assertNotNull(identifier)
		assertTrue(identifier.valid)
		assertEquals(element.containingFile, identifier.containingFile)
		assertEquals(element, identifier.parent)
		assertEquals(name, identifier.text)
		assertEquals(nameOffset, identifier.textRange.startOffset)
		assertEquals(nameOffset + name.length, identifier.textRange.endOffset)
		assertEquals(nameOffset, identifier.textOffset)
		assertEquals(name.length, identifier.textLength)
	}

	protected def findPsiNamedEObject(String text, String textAfterCaret) {
		val caretOffset = text.indexOf(textAfterCaret)
		text.findPsiNamedEObject(caretOffset)
	}

	protected def findPsiNamedEObject(String text, int caretOffset) {
		myFixture.configureByText('aaa.sdomain', text)
		val targetElement = TargetElementUtilBase.instance.findTargetElement(myFixture.editor, ELEMENT_NAME_ACCEPTED, caretOffset)
		if (targetElement instanceof PsiNamedEObject) {
			targetElement
		}
	}

}