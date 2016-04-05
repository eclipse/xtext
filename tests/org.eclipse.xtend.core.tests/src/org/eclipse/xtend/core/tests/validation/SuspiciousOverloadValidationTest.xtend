/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.diagnostics.AbstractDiagnostic
import org.eclipse.xtext.junit4.internal.LineDelimiters
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.computation.ISuspiciouslyOverloadedCandidate
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class SuspiciousOverloadValidationTest extends AbstractXtendTestCase {
	
	@Inject extension ParseHelper<XtendFile>
	@Inject extension IBatchTypeResolver
	@Inject extension ValidationTestHelper
	
	protected def void assertSuspicious(CharSequence contents, String... messageParts) {
		val file = contents.parsedXtendFile
		val errors = file.eResource.errors
		assertEquals(errors.toString, 1, errors.size)
		val singleError = errors.head as AbstractDiagnostic
		assertEquals(singleError.message, IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE, singleError.code)
		for (it : messageParts.map[LineDelimiters.toUnix(it)]) {
			val message = singleError.message
			if (!message.contains(it)) {
				assertEquals(it, message)
			}
		}
		val firstType = file.xtendTypes.head
		val firstMember = firstType.members.head as XtendFunction
		val block = firstMember.expression as XBlockExpression
		val featureCall = block.eAllContents.filter(XAbstractFeatureCall).findLast[
			eContainingFeature != XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER
			&& feature instanceof JvmOperation
		]
		val linkingCandidate = file.resolveTypes.getLinkingCandidate(featureCall)
		assertTrue(linkingCandidate instanceof ISuspiciouslyOverloadedCandidate) 
	}
	
	protected def void assertSuspiciousInInnerClass(CharSequence contents, String... messageParts) {
		val file = contents.parsedXtendFile
		val errors = file.eResource.errors
		assertEquals(errors.toString, 1, errors.size)
		val singleError = errors.head as AbstractDiagnostic
		assertEquals(singleError.message, IssueCodes.SUSPICIOUSLY_OVERLOADED_FEATURE, singleError.code)
		for (it : messageParts.map[LineDelimiters.toUnix(it)]) {
			val message = singleError.message
			if (!message.contains(it)) {
				assertEquals(it, message)
			}
		}
		val firstType = file.xtendTypes.head
		val innerType = firstType.members.head as XtendClass
		val firstMember = innerType.members.head as XtendFunction
		val block = firstMember.expression as XBlockExpression
		val featureCall = block.eAllContents.filter(XAbstractFeatureCall).findLast[
			eContainingFeature != XbasePackage.Literals.XABSTRACT_FEATURE_CALL__IMPLICIT_RECEIVER
			&& feature instanceof JvmOperation
		]
		val linkingCandidate = file.resolveTypes.getLinkingCandidate(featureCall)
		assertTrue(linkingCandidate instanceof ISuspiciouslyOverloadedCandidate) 
	}
	
	protected def void assertValid(CharSequence contents) {
		val file = contents.parsedXtendFile
		val errors = file.eResource.errors
		assertEquals(errors.toString, 0, errors.size)
		file.assertNoErrors
	}
	
	private def getParsedXtendFile(CharSequence contents) {
		val file = contents.parse
		val errors = file.eResource.errors
		assertTrue(errors.toString, errors.empty)
		EcoreUtil.resolveAll(file)
		return file
	}
	
	@Test
	def void testSuspiciousMethods_01() {
		'''
			class C {
				def void m(D it) {
					m2('')
				}
				def void m2(String s) {}
			}
			class D {
				def void m2(CharSequence c) {}
			}
		'''.assertSuspicious('''
			Suspiciously overloaded method.
			The method
				m2(String) in C on 'this'
			overloads the method
				m2(CharSequence) in D on parameter 'it'.''')
	}
	
	@Test
	def void testSuspiciousMethods_02() {
		'''
			class B {
			  def m(extension A a) {
			    foo("")
			  }
			  def foo(CharSequence c) {}
			}
			class A {
			  def foo(String s) {}
			}
		'''.assertSuspicious('''
			Suspiciously overloaded method.
			The method
				foo(String) in A on parameter 'a'
			overloads the method
				foo(CharSequence) in B on 'this'.''')
	}
	
	@Test
	def void testSuspiciousMethods_03() {
		'''
			class B {
			  def bar() {
			    new A => [
			      foo("baz")
			    ]
			  }
			  def foo(String str) {}
			}
			class A {
			  def foo(CharSequence chars) {}
			}
		'''.assertSuspicious('''
			Suspiciously overloaded method.
			The method
				foo(String) in B on 'this'
			overloads the method
				foo(CharSequence) in A on parameter 'it'.''')
	}
	
	
	@Test
	def void testSuspiciousMethods_04() {
		'''
			class C {
				def void m(StringBuilder b, D it) {
					m2(b)
				}
				def void m2(Appendable a) {}
			}
			class D {
				def void m2(Object o) {}
			}
		'''.assertSuspicious('''
			Suspiciously overloaded method.
			The method
				m2(Appendable) in C on 'this'
			overloads the method
				m2(Object) in D on parameter 'it'.''')
	}
	
	@Test
	def void testSuspiciousMethods_05() {
		'''
			class A {
				static class B {
					def static void m(CharSequence c) {
						m('')
					}
				}
				def static void m(String s) {}
			}
		'''.assertSuspiciousInInnerClass('''
			Suspiciously overloaded method.
			The method
				m(String) in A
			overloads the method
				m(CharSequence) in B.''')
	}
	
	@Test
	def void testValidOverloads_01() {
		'''
			class B {
			  def bar(A it) {
			    foo("")
			  }
			  def foo(CharSequence c) {}
			}
			class A {
			  def foo(String s) {}
			}
		'''.assertValid
	}
	
	@Test
	def void testValidOverloads_02() {
		'''
			class A {
			  def foo(){}
			}
			
			class B {
			  def foo(){}
			  def bar() {
			    new A => [
			      foo
			    ]
			  }
			}
		'''.assertValid
	}
	
	@Test
	def void testValidOverloads_03() {
		'''
			class A {
				static class B {
					def static void m(CharSequence c) {
						m('')
					}
				}
				def void m(String s) {}
			}
		'''.assertValid
	}
	
	@Test
	def void testValidOverloads_04() {
		'''
			class A {
				static class B {
					def void m(CharSequence c) {
						m('')
					}
				}
				def static void m(String s) {}
			}
		'''.assertValid
	}
	
}

