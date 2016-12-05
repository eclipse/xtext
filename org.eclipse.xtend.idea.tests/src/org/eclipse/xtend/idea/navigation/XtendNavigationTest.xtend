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
import org.eclipse.xtend.core.xtend.AnonymousClass
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendConstructor
import org.eclipse.xtend.core.xtend.XtendEnum
import org.eclipse.xtend.core.xtend.XtendEnumLiteral
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendInterface
import org.eclipse.xtend.core.xtend.XtendParameter
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.PsiEObject
import org.eclipse.xtext.psi.PsiNamedEObject

import static org.eclipse.xtend.idea.navigation.NavigationTestData.*
import org.eclipse.xtend.core.xtend.XtendVariableDeclaration

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
				
					def void sayHello(String «NAVIGATION_ELEMENT_START_OFFSET»name«NAVIGATION_ELEMENT_END_OFFSET») {
						println(na«REFERENCE_OFFSET»me)
					}
				
				}
			''',
			XtendParameter
		)
	}

	def void testNavigateToClass() {
		testNavigateTo(
			'mypackage/Greeter.xtend',
			'''
				package mypackage
				
				class «NAVIGATION_ELEMENT_START_OFFSET»Greeter«NAVIGATION_ELEMENT_END_OFFSET» {
				
					def static void main(String ... args) {
						new «REFERENCE_OFFSET»Greeter().sayHello(args.head)
					}
				
					def void sayHello(String name) {
						println(name)
					}
				
				}
			''',
			XtendClass // constructor
		)
	}

	def void testNavigateToClass_Extends() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				class «NAVIGATION_ELEMENT_START_OFFSET»Foo«NAVIGATION_ELEMENT_END_OFFSET» {
				}
				
				class Bar extends «REFERENCE_OFFSET»Foo {
				}
			''',
			XtendClass
		)
	}

	def void testNavigateToClass_Implements() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				interface «NAVIGATION_ELEMENT_START_OFFSET»Foo«NAVIGATION_ELEMENT_END_OFFSET» {
				}
				
				class Bar implements «REFERENCE_OFFSET»Foo {
				}
			''',
			XtendInterface
		)
	}

	def void testNavigateToClass_Throws() {
		testNavigateTo(
			'mypackage/Exception.xtend',
			'''
				package mypackage
				
				class «NAVIGATION_ELEMENT_START_OFFSET»MyException«NAVIGATION_ELEMENT_END_OFFSET» extends Exception {
				}
				
				class Client {
				
					def void someMethod() throws My«REFERENCE_OFFSET»Exception {}
				
				}
			''',
			XtendClass
		)
	}

	def void testNavigateToClass_ExtendsBound() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				class «NAVIGATION_ELEMENT_START_OFFSET»Foo«NAVIGATION_ELEMENT_END_OFFSET» {
				}
				
				class Bar<T extends Fo«REFERENCE_OFFSET»o> {
				}
			''',
			XtendClass
		)
	}

	def void testNavigateToInnerClass() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				class Foo {
					static class «NAVIGATION_ELEMENT_START_OFFSET»Bar«NAVIGATION_ELEMENT_END_OFFSET» {}
					static class Baz extends «REFERENCE_OFFSET»Bar {}
				}
			''',
			XtendClass
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
				
					def static void main(String ... args) {«NAVIGATION_ELEMENT_START_OFFSET»
						new Greeter() {
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
			AnonymousClass
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
						}«NAVIGATION_ELEMENT_START_OFFSET»
						new Greeter() {
							override sayHello(String name) {
								«REFERENCE_OFFSET»this.sayHello(name)
							}
						}«NAVIGATION_ELEMENT_END_OFFSET»
					}
				
				}
			''',
			AnonymousClass
		)
	}

	def void testNavigateToAnnonymousClass3() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				interface «NAVIGATION_ELEMENT_START_OFFSET»Greeter«NAVIGATION_ELEMENT_END_OFFSET» {
					def void sayHello(String name)
				}
				
				class Foo {
				
					def static void main(String ... args) {
						acceptGreeter [ String name |
							«REFERENCE_OFFSET»self.sayHello(name)
						]
						new Greeter() {
							override sayHello(String name) {
								throw new UnsupportedOperationException("TODO: auto-generated method stub")
							}
						}
					}
				
					def static void acceptGreeter(Greeter greeter) {}
				
				}
			''',
			XtendInterface
		)
	}

	def void testNavigateToAnnonymousClass4() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				abstract class Greeter {
					abstract def void sayHello(String name)
				}
				
				class Foo {
				
					def static void main(String ... args) {
						acceptGreeter [ String name |
							throw new UnsupportedOperationException("TODO: auto-generated method stub")
						]«NAVIGATION_ELEMENT_START_OFFSET»
						new Greeter() {
							override sayHello(String name) {
								«REFERENCE_OFFSET»this.sayHello(name)
							}
						}«NAVIGATION_ELEMENT_END_OFFSET»
					}
				
					def static void acceptGreeter(Greeter greeter) {}
				
				}
			''',
			AnonymousClass
		)
	}

	def void testNavigateToAnnonymousClass5() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				abstract class Greeter {
					abstract def void sayHello(String name)
				}
				
				class Foo {
				
					static val greeter =«NAVIGATION_ELEMENT_START_OFFSET» new Greeter() {
							override sayHello(String name) {
								«REFERENCE_OFFSET»this.sayHello(name)
							}
						}«NAVIGATION_ELEMENT_END_OFFSET»
				
					def static void main(String ... args) {
						greeter.sayHello(args.head)
					}
				
				}
			''',
			AnonymousClass
		)
	}

	def void testNavigateToEnumeration() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				enum «NAVIGATION_ELEMENT_START_OFFSET»Light«NAVIGATION_ELEMENT_END_OFFSET» {
					ON, OFF
				}
				
				class Room {
				
					«REFERENCE_OFFSET»Light light
				
					def void enable() {
						light = Light.ON
					}
				
				}
			''',
			XtendEnum
		)
	}

	def void testNavigateToEnumConstant() {
		testNavigateTo(
			'mypackage/Foo.xtend',
			'''
				package mypackage
				
				enum Light {
					«NAVIGATION_ELEMENT_START_OFFSET»ON«NAVIGATION_ELEMENT_END_OFFSET», OFF
				}
				
				class Room {
				
					Light light
				
					def void enable() {
						light = Light.«REFERENCE_OFFSET»ON
					}
				
				}
			''',
			XtendEnumLiteral
		)
	}

	def void testNavigateToConstructor() {
		testNavigateTo(
			'mypackage/Greeter.xtend',
			'''
				package mypackage
				
				class Greeter {
				
					def static void main(String ... args) {
						new «REFERENCE_OFFSET»Greeter(args.head)
					}«NAVIGATION_ELEMENT_START_OFFSET»
				
					new(String name) {
						println(name)
					}«NAVIGATION_ELEMENT_END_OFFSET»
				
				}
			''',
			XtendConstructor
		)
	}

	def void testNavigateToMethod() {
		testNavigateTo(
			'mypackage/Greeter.xtend',
			'''
				package mypackage
				
				class Greeter {
				
					def static void main(String ... args) {
						new Greeter().«REFERENCE_OFFSET»sayHello(args.head)
					}
				
					def void «NAVIGATION_ELEMENT_START_OFFSET»sayHello«NAVIGATION_ELEMENT_END_OFFSET»(String name) {
						println(name)
					}
				
				}
			''',
			XtendFunction
		)
	}

	def void testNavigateToAnnotationMethod() {
		testNavigateTo(
			'mypackage/MyAnnotation.xtend',
			'''
				package mypackage
				
				annotation MyAnnotation {
					Class<?> «NAVIGATION_ELEMENT_START_OFFSET»type«NAVIGATION_ELEMENT_END_OFFSET»
				}
				
				class Foo {
					
					def getType(MyAnnotation myAnnotation) {
						myAnnotation.ty«REFERENCE_OFFSET»pe()
					}
				
				}
			''',
			XtendField
		)
	}

	def void testNavigateToField() {
		testNavigateTo(
			'mypackage/MyAnnotation.xtend',
			'''
				package mypackage
				
				class Greeter {
				
					String «NAVIGATION_ELEMENT_START_OFFSET»name«NAVIGATION_ELEMENT_END_OFFSET»
				
					def void sayHello() {
						println('Hello ' + na«REFERENCE_OFFSET»me)
					}
				
				}
			''',
			XtendField
		)
	}

	def void testNavigateToVariable() {
		testNavigateTo(
			'mypackage/MyFunction.xtend',
			'''
				package mypackage
				
				class MyFunction {
				
					def calc() {
						val «NAVIGATION_ELEMENT_START_OFFSET»x«NAVIGATION_ELEMENT_END_OFFSET» = 1
						val y = 1
						«REFERENCE_OFFSET»x + y
					}
				
				}
			''',
			XtendVariableDeclaration
		)
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
		val actualNavigationElement = targetElement.navigationElement
		if (expectedNavigationElement != actualNavigationElement) {
			assertEquals(DebugUtil.psiToString(file, true, true), expectedNavigationElement, actualNavigationElement)
		}
		
		val result = (targetElement as PsiEObject).EObject
		assertTrue(
			result.class + ' is not assignable from ' + expectedType,
			expectedType.isAssignableFrom(result.class)
		)
		result as T
	}

	protected def findNavigationElement(TextRange range) {
		var element = file.findElementAt(range.startOffset)
		assertNotNull(element)

		val namedEObject = element.findPsiNamedEObject(range)
		if (namedEObject !== null) {
			assertEquals(namedEObject, namedEObject.navigationElement)
			return namedEObject
		}

		while (element.textRange != range) {
			element = element.parent
			assertNotNull(element)
		}
		assertEquals(element, element.navigationElement)
		element
	}

	protected def PsiElement findPsiNamedEObject(PsiElement element, TextRange identifierRange) {
		if (element === null) {
			return null
		}
		if (element instanceof PsiNamedEObject) {
			val nameIdentifier = element.nameIdentifier
			if (nameIdentifier !== null) {
				return if (nameIdentifier.textRange == identifierRange)
					element
				else
					null
			}
		}
		return element.parent.findPsiNamedEObject(identifierRange)
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
	static val OFFSET_MARKERS = #[NAVIGATION_ELEMENT_START_OFFSET, NAVIGATION_ELEMENT_END_OFFSET, REFERENCE_OFFSET]

	val String model
	val int navigationElementStartOffset
	val int navigationElementEndOffset
	val int referenceOffset

	new(String model) {
		val offsetMarkers = newHashMap
		this.model = model.removeOffsetMarkers(offsetMarkers)
		this.navigationElementStartOffset = offsetMarkers.get(NAVIGATION_ELEMENT_START_OFFSET)
		this.navigationElementEndOffset = offsetMarkers.get(NAVIGATION_ELEMENT_END_OFFSET)
		this.referenceOffset = offsetMarkers.get(REFERENCE_OFFSET)
	}

	protected def String removeOffsetMarkers(String model, Map<String, Integer> offsetMarkers) {
		val offsetMarker = model.findFirstOffsetMarker
		if (offsetMarker.value == -1) {
			return model
		}
		offsetMarkers.put(offsetMarker.key, offsetMarker.value)
		model.removeOffsetMarker(offsetMarker).removeOffsetMarkers(offsetMarkers)
	}
	
	protected def removeOffsetMarker(String model, Pair<String, Integer> offsetMarker) {
		model.substring(0, offsetMarker.value) + model.substring(offsetMarker.value + offsetMarker.key.length)
	}
	
	protected def findFirstOffsetMarker(String model) {
		model.findOffsetMarkers.reduce [
			if ($0.value == -1)
				$1
			else if ($1.value == -1)
				$0
			else if ($0.value < $1.value)
				$0
			else
				$1
		]
	}
	
	protected def findOffsetMarkers(String model) {
		OFFSET_MARKERS.map[it -> model.indexOf(it)]
	}

}