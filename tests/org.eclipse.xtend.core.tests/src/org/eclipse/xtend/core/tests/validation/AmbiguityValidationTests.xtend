/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.eclipse.xtext.diagnostics.AbstractDiagnostic
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AmbiguityValidationTest extends AbstractXtendTestCase {
	
	@Inject extension ParseHelper<XtendFile>
	@Inject extension IBatchTypeResolver
	
	protected def void assertAmbiguous(CharSequence contents, String... messageParts) {
		val file = contents.parsedXtendFile
		val errors = file.eResource.errors
		assertEquals(errors.toString, 1, errors.size)
		val singleError = errors.head as AbstractDiagnostic
		assertEquals(singleError.message, IssueCodes.AMBIGUOUS_FEATURE_CALL, singleError.code)
		messageParts.forEach [
			val message = singleError.message
			if (!message.contains(it)) {
				assertEquals(it, message)
			}
		]
		val firstType = file.xtendTypes.head
		val firstMember = firstType.members.head as XtendFunction
		val block = firstMember.expression as XBlockExpression
		val featureCall = block.expressions.last as XAbstractFeatureCall
		val linkingCandidate = file.resolveTypes.getLinkingCandidate(featureCall)
		assertTrue(linkingCandidate instanceof IAmbiguousLinkingCandidate) 
	}
	
	protected def void assertUnambiguous(CharSequence contents) {
		val file = contents.parsedXtendFile
		val errors = file.eResource.errors
		assertEquals(errors.toString, 0, errors.size)
	}
	
	private def getParsedXtendFile(CharSequence contents) {
		val file = contents.parse
		val errors = file.eResource.errors
		assertTrue(errors.toString, errors.empty)
		EcoreUtil.resolveAll(file)
		return file
		
	}
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguousPlainFeatureCallTest extends AmbiguityValidationTest {
	@Test
	def void testAmbiguousMethods_01() {
		'''
			class C {
				def void m(StringBuilder b) {
					m2(b)
				}
				def void m2(CharSequence c) {}
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m2(CharSequence) in C and
				m2(Appendable) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_02() {
		'''
			class C {
				def void m(StringBuilder b) {
					m2(b)
				}
				def void m2(CharSequence c) {}
				def void m2(java.io.Serializable s) {}
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m2(CharSequence) in C,
				m2(Serializable) in C and
				m2(Appendable) in C
			all match.''')
	}
	
	@Test
	def void testAmbiguousMethods_03() {
		'''
			class C extends D {
				def void m(StringBuilder b) {
					m2(b)
				}
				def void m2(CharSequence c) {}
			}
			class D {
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m2(CharSequence) in C and
				m2(Appendable) in D
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_04() {
		'''
			class C {
				def void m(StringBuilder b, D it) {
					m2(b)
				}
				def void m2(CharSequence c) {}
			}
			class D {
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('m2(Appendable) in D', 'm2(CharSequence) in C')
	}
	
	@Test
	def void testUnambiguousMethods_01() {
		'''
			class C {
				def void m(StringBuilder b, D it) {
					m2(b)
				}
				def void m2(Object o) {}
			}
			class D {
				def void m2(Appendable a) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_02() {
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
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_03() {
		'''
			class C {
				def void m(Object o) {
					switch o {
						I : switch o {
							J : o.m2
						}
					}
				}
			}
			class I {
				def void m2() {}
			}
			class J {
				def void m2() {}
			}
		'''.assertUnambiguous
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguousExtensionFeatureCallTest extends AmbiguityValidationTest {
	@Test
	def void testAmbiguousMethods_01() {
		'''
			class C {
				def void m(StringBuilder b) {
					b.m2
				}
				def void m2(CharSequence c) {}
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(CharSequence) in C and
				m2(Appendable) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_02() {
		'''
			class C {
				def void m(StringBuilder it) {
					m2
				}
				def void m2(CharSequence c) {}
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(CharSequence) in C and
				m2(Appendable) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_03() {
		'''
			class C extends D {
				def void m(StringBuilder it) {
					m2
				}
				def void m2(Appendable a) {}
			}
			class D {
				def void m2(CharSequence c) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(Appendable) in C and
				m2(CharSequence) in D
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_04() {
		'''
			class C {
				def void m(StringBuilder it, extension D d, extension E e) {
					m2
				}
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(CharSequence) in D and
				m2(Appendable) in E
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_05() {
		'''
			class C {
				def void m(StringBuilder it) {
					m2
				}
				extension D
				extension E
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(CharSequence) in D and
				m2(Appendable) in E
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_06() {
		'''
			class C {
				def void m(StringBuilder it) {
					val extension D d = null
					val extension E e = null
					m2
				}
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(Appendable) in E and
				m2(CharSequence) in D
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_07() {
		'''
			import static extension D.*
			import static extension E.*
			class C {
				def void m(StringBuilder it) {
					m2
				}
			}
			class D {
				def static void m2(CharSequence c) {}
			}
			class E {
				def static void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(CharSequence) in D and
				m2(Appendable) in E
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_08() {
		'''
			class C {
				def void m(StringBuilder it) {
					val extension D d = null
					m2
				}
				extension E
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(Appendable a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(CharSequence) in D and
				m2(Appendable) in E
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_09() {
		'''
			class C {
				def void m(StringBuilder it) {
					val extension D d = null
					val extension E e = null
					m2
				}
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(CharSequence a) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				m2(CharSequence) in E and
				m2(CharSequence) in D
			both match.''')
	}
	
	@Test
	def void testUnambiguousMethods_01() {
		'''
			class C {
				def void m(StringBuilder it) {
					val extension D d = null
					{
						val extension E e = null
						m2
					}
				}
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(CharSequence a) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_02() {
		'''
			class C {
				def void m(StringBuilder it) {
					val extension D d = null
					m2
				}
				extension E
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(CharSequence a) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_03() {
		'''
			class C {
				def void m(StringBuilder it) {
					val extension D d1 = null
					val extension D d2 = null
					{
						val extension E e = null
						m2
					}
				}
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(StringBuilder bd) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_04() {
		'''
			class C {
				def void m(StringBuilder it) {
					val extension E e = null
					val extension D d1 = null
					val extension D d2 = null
					m2
				}
			}
			class D {
				def void m2(CharSequence c) {}
			}
			class E {
				def void m2(StringBuilder bd) {}
			}
		'''.assertUnambiguous
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguousOperatorsTest extends AmbiguityValidationTest {
	@Test
	def void testAmbiguousOperators_01() {
		'''
			class C {
				def void m(C c1, C c2) {
					c1 + c2
				}
				def void operator_plus(C c, Object o) {}
				def void operator_plus(Object o, C c) {}
			}
		'''.assertAmbiguous('''
			Ambiguous binary operation.
			The operator declarations
				operator_plus(C, Object) in C and
				operator_plus(Object, C) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousOperators_02() {
		'''
			class C {
				def void n(String s) {
					-s
				}
				def void operator_minus(CharSequence c) {}
				def void operator_minus(java.io.Serializable s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous unary operation.
			The operator declarations
				operator_minus(CharSequence) in C and
				operator_minus(Serializable) in C
			both match.''')
	}
	
	@Test
	def void testUnambiguousOperators() {
		'''
			class C {
				def void n(String s) {
					s+s
				}
				def void operator_plus(String s1, String s2) {}
			}
		'''.assertUnambiguous
	}
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguousGenericFeatureCallTest extends AmbiguityValidationTest {
	@Test
	def void testAmbiguousMethods_01() {
		'''
			class C {
				def void n(StringBuilder b) {
					m2(b)
				}
				def <T extends CharSequence> void m2(T c) {}
				def <X extends Appendable> void m2(X a) {}
			}
		'''.assertAmbiguous('<T extends CharSequence> m2(T)', '<X extends Appendable> m2(X)')
	}
	
	@Test
	def void testAmbiguousMethods_02() {
		'''
			class C {
				def void n(StringBuilder b) {
					m2(get)
				}
				def void m2(CharSequence c) {}
				def void m2(Appendable a) {}
				def <T> T get() {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m2(CharSequence) in C and
				m2(Appendable) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_03() {
		'''
			class C {
				def void n(D<String> it) {
					m('')
				}
			}
			class D<T> {
				def void m(String s) {}
				def void m(T t) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String) in D and
				m(T) in D
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_04() {
		'''
			class C {
				def void m(D<String> it) {
					add('')
				}
			}
			class D<T> {
				def void add(T t) {}
				def <X extends String> void add(X x) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				add(T) in D and
				<X extends String> add(X) in D
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_05() {
		'''
			class C {
				def void m(D<String> it) {
					add('')
				}
				def <X extends String> void add(X x) {}
			}
			class D<T> {
				def void add(T t) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				add(T) in D and
				<X extends String> add(X) in C
			both match.''')
	}
	
	@Test
	def void testUnambiguousMethods_01() {
		'''
			class C {
				def void n(E<String> it) {
					m('')
				}
			}
			class D<T> {
				def void m(T t) {}
			}
			class E<T> extends D<T> {
				def void m(String s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_02() {
		'''
			class C {
				def void n(D<CharSequence> it) {
					m('')
				}
			}
			class D<T> {
				def void m(String s) {}
				def void m(T t) {}
			}
		'''.assertUnambiguous
	}
	
}