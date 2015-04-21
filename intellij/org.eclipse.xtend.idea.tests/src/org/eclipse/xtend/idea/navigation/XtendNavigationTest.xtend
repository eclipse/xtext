/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.navigation

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.DebugUtil
import java.util.Map
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiAnonymousClass
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiClassImpl
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiMethodImpl
import org.eclipse.xtext.xbase.idea.jvm.JvmPsiParameterImpl
import org.eclipse.xtext.xbase.idea.types.psi.JvmPsiClass

import static org.eclipse.xtend.idea.navigation.NavigationTestData.*

/**
 * @author kosyakov - Initial contribution and API
 */
class XtendNavigationTest extends LightXtendTest {

	def void testNavigateToParameter() {
		testNavigateTo(
			'mypackage/Greeter.xtend',
			'''
				package mypackage
				
				class Greeter {
				
					def void sayHello(«NAVIGATION_ELEMENT_START_OFFSET»String name«NAVIGATION_ELEMENT_END_OFFSET») {
						println(na«REFERENCE_OFFSET»me)
					}
				
				}
			''',
			JvmPsiParameterImpl
		)
	}

	def void testNavigateToClass() {
		testNavigateTo(
			'mypackage/Greeter.xtend',
			'''
				package mypackage
				
				«NAVIGATION_ELEMENT_START_OFFSET»class Greeter {
				
					def static void main(String ... args) {
						new «REFERENCE_OFFSET»Greeter().sayHello(args.head)
					}
				
					def void sayHello(String name) {
						println(name)
					}
				
				}«NAVIGATION_ELEMENT_END_OFFSET»
			''',
			JvmPsiClassImpl
		)
	}

	def void testNavigateToClass2() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				«NAVIGATION_ELEMENT_START_OFFSET»class Foo {
				}«NAVIGATION_ELEMENT_END_OFFSET»
				
				class Bar extends «REFERENCE_OFFSET»Foo {
				}
			''',
			JvmPsiClass
		)
	}

	def void testNavigateToClass3() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				class Foo {
					«NAVIGATION_ELEMENT_START_OFFSET»static class Bar {}«NAVIGATION_ELEMENT_END_OFFSET»
					static class Baz extends «REFERENCE_OFFSET»Bar {}
				}
			''',
			JvmPsiClassImpl
		)
	}

	def void testNavigateToAnnonymousClass() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				interface Greeter {
					def void sayHello(String name)
				}
				
				class Foo {
				
					def static void main(String ... args) {
						«NAVIGATION_ELEMENT_START_OFFSET»new Greeter() {
							override sayHello(String name) {
								«REFERENCE_OFFSET»this.sayHello(name)
							}
						}«NAVIGATION_ELEMENT_END_OFFSET»
						new Greeter() {
							override sayHello(String name) {
								throw new UnsupportedOperationException("TODO: auto-generated method stub")
							}
						}
					}
				
				}
			''',
			JvmPsiAnonymousClass
		)
	}

	def void testNavigateToAnnonymousClass2() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				interface Greeter {
					def void sayHello(String name)
				}
				
				class Foo {
				
					def static void main(String ... args) {
						new Greeter() {
							override sayHello(String name) {
								throw new UnsupportedOperationException("TODO: auto-generated method stub")
							}
						}
						«NAVIGATION_ELEMENT_START_OFFSET»new Greeter() {
							override sayHello(String name) {
								«REFERENCE_OFFSET»this.sayHello(name)
							}
						}«NAVIGATION_ELEMENT_END_OFFSET»
					}
				
				}
			''',
			JvmPsiAnonymousClass
		)
	}

	def void testNavigateToConstructor() {
		val psiConstructor = testNavigateTo(
			'mypackage/Greeter.xtend',
			'''
				package mypackage
				
				class Greeter {
				
					def static void main(String ... args) {
						new «REFERENCE_OFFSET»Greeter(args.head)
					}
				
					«NAVIGATION_ELEMENT_START_OFFSET»new(String name)«NAVIGATION_ELEMENT_END_OFFSET» {
						println(name)
					}
				
				}
			''',
			JvmPsiMethodImpl
		)
		assertTrue(psiConstructor.constructor)
	}

	def void testNavigateToMethod() {
		val psiMethod = testNavigateTo(
			'mypackage/Greeter.xtend',
			'''
				package mypackage
				
				class Greeter {
				
					def static void main(String ... args) {
						new Greeter().«REFERENCE_OFFSET»sayHello(args.head)
					}
				
					«NAVIGATION_ELEMENT_START_OFFSET»def void sayHello(String name) {
						println(name)
					}«NAVIGATION_ELEMENT_END_OFFSET»
				
				}
			''',
			JvmPsiMethodImpl
		)
		assertFalse(psiMethod.constructor)
	}

	protected def <T> T testNavigateTo(String relativePath, String fileText, Class<T> expectedType) {
		val navigationTestData = new NavigationTestData(fileText)
		openFileInEditor(relativePath, navigationTestData.model)
		val navigationElement = findNavigationElement(
			new TextRange(
				navigationTestData.navigationElementStartOffset,
				navigationTestData.navigationElementEndOffset
			)
		)
		assertReference(navigationTestData.referenceOffset, expectedType, navigationElement)
	}

	protected def <T> T assertReference(
		int referenceOffset,
		Class<T> expectedType,
		PsiElement expectedNavigationElement
	) {
		myFixture.editor.caretModel.moveToOffset(referenceOffset)
		val targetElement = myFixture.elementAtCaret
		assertNotNull(targetElement)
		assertTrue(
			targetElement.class + ' is not assignable from ' + expectedType,
			expectedType.isAssignableFrom(targetElement.class)
		)
		val actualNavigationElement = targetElement.navigationElement
		if (expectedNavigationElement != actualNavigationElement) {
			assertEquals(DebugUtil.psiToString(file, true, true), expectedNavigationElement, actualNavigationElement)
		}
		targetElement as T
	}

	protected def findNavigationElement(TextRange range) {
		var element = file.findElementAt(range.startOffset)
		var navigationElement = if (element instanceof LeafXtextPsiElement) {
				element.parent
			} else
				element

		assertNotNull(navigationElement)
		assertTrue('' + navigationElement.class, PsiEObject.isAssignableFrom(navigationElement.class))

		while (!navigationElement.textRange.contains(range)) {
			navigationElement = navigationElement.parent
			assertNotNull(navigationElement)
		}

		assertEquals(navigationElement, navigationElement.navigationElement)
		navigationElement
	}

	protected def openFileInEditor(String relativePath, String fileText) {
		val xtendFile = myFixture.addFileToProject(relativePath, fileText)
		myFixture.testHighlighting(true, true, true, xtendFile.virtualFile)
		myFixture.openFileInEditor(xtendFile.virtualFile)
		xtendFile
	}

}

@Accessors
class NavigationTestData {
	public static val NAVIGATION_ELEMENT_START_OFFSET = '<navigationElementStartOffset>'
	public static val NAVIGATION_ELEMENT_END_OFFSET = '<navigationElementEndOffset>'
	public static val REFERENCE_OFFSET = '<referenceOffset>'
	static val TAGS = #[NAVIGATION_ELEMENT_START_OFFSET, NAVIGATION_ELEMENT_END_OFFSET, REFERENCE_OFFSET]

	val String model
	val int navigationElementStartOffset
	val int navigationElementEndOffset
	val int referenceOffset

	new(String model) {
		val offsets = newHashMap
		this.model = model.findOffsets(offsets)
		this.navigationElementStartOffset = offsets.get(NAVIGATION_ELEMENT_START_OFFSET)
		this.navigationElementEndOffset = offsets.get(NAVIGATION_ELEMENT_END_OFFSET)
		this.referenceOffset = offsets.get(REFERENCE_OFFSET)
	}

	protected def String findOffsets(String model, Map<String, Integer> offsets) {
		val tagToOffset = TAGS.map[it -> model.indexOf(it)].reduce [
			if ($0.value == -1)
				$1
			else if ($1.value == -1)
				$0
			else if ($0.value < $1.value)
				$0
			else
				$1
		]
		if (tagToOffset.value == -1) {
			return model
		}
		offsets.put(tagToOffset.key, tagToOffset.value)
		val newModel = model.substring(0, tagToOffset.value) +
			model.substring(tagToOffset.value + tagToOffset.key.length)
		newModel.findOffsets(offsets)
	}

}