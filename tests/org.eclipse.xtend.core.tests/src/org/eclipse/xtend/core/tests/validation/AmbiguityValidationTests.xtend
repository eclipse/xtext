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
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.diagnostics.AbstractDiagnostic
import org.eclipse.xtext.junit4.internal.LineDelimiters
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBlockExpression
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.computation.IAmbiguousLinkingCandidate
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
abstract class AmbiguityValidationTest extends AbstractXtendTestCase {
	
	@Inject protected extension ParseHelper<XtendFile>
	@Inject protected extension IBatchTypeResolver
	@Inject protected extension ValidationTestHelper
	
	protected def void assertAmbiguous(CharSequence contents, String... messageParts) {
		val file = contents.parsedXtendFile
		val errors = file.eResource.errors
		assertEquals(errors.toString, 1, errors.size)
		val singleError = errors.head as AbstractDiagnostic
		assertEquals(singleError.message, IssueCodes.AMBIGUOUS_FEATURE_CALL, singleError.code)
		messageParts.map[LineDelimiters.toUnix(it)].forEach [
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
		file.assertNoErrors
	}
	
	protected def getParsedXtendFile(CharSequence contents) {
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
	def void testAmbiguousMethods_05() {
		'''
			class C {
				def void m() {
					m2
				}
				def void getM2() {}
				def void m2() {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m2() in C and
				getM2() in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_06() {
		'''
			class C {
				def void n() {
					m(#[ null ])
				}
				def void m(String[] s) {}
				def void m(Boolean[] s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String[]) in C and
				m(Boolean[]) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_07() {
		'''
			class C {
				def void n() {
					m(#[])
				}
				def void m(String[] s) {}
				def void m(Boolean[] s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String[]) in C and
				m(Boolean[]) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_08() {
		'''
			class C {
				def void n() {
					m(#[])
				}
				def void m(String... s) {}
				def void m(Boolean... s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String[]) in C and
				m(Boolean[]) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_09() {
		'''
			class C {
				def void n() {
					m(null)
				}
				def void m(String... s) {}
				def void m(Boolean... s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String[]) in C and
				m(Boolean[]) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_10() {
		'''
			class C {
				def void n() {
					m
				}
				def void m(String... s) {}
				def void m(Boolean... s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String[]) in C and
				m(Boolean[]) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_11() {
		'''
			import java.util.*
			class C {
				def void n() {
					m(#[])
				}
				def void m(List<String> s) {}
				def void m(Collection<Boolean> s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(List<String>) in C and
				m(Collection<Boolean>) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_12() {
		'''
			import java.util.*
			class C {
				def void n() {
					m []
				}
				def void m((int, int, int)=>void p) {}
				def void m((int, int)=>void p) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m((int, int, int)=>void) in C and
				m((int, int)=>void) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_13() {
		'''
			import java.util.*
			class C {
				def void n() {
					m []
				}
				def void m(()=>void p) {}
				def void m((int, int)=>void p) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(()=>void) in C and
				m((int, int)=>void) in C
			both match.''')
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
			interface I {
				def void m2()
			}
			interface J {
				def void m2()
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_04() {
		'''
			import static D.*
			class C extends D {
				def void m() {
					m2
				}
			}
			class D {
				def static void m2() {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_05() {
		'''
			import static D.*
			class C extends D {
				def void m() {
					m2
				}
			}
			class D {
				def static void m2() {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_06() {
		'''
			class C {
				def void m() {
					m2()
					getM2
				}
				def void getM2() {}
				def void m2() {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_07() {
		'''
			class C {
				def m() {
					m2
				}
				String m2
				def void getM2() {}
				def void m2() {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_08() {
		'''
			import static D.*
			import static E.*
			class C {
				def void m() {
					m2
				}
			}
			class D {
				def static void m2() {}
			}
			class E extends D {}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_09() {
		'''
			import static D.*
			class C {
				def void m() {
					E.m2
				}
			}
			class D {
				def static void m2() {}
			}
			class E extends D {}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_10() {
		'''
			class C {
				def void n() {
					m(#[ null ])
				}
				def void m(String[] s) {}
				def void m(boolean[] s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_11() {
		'''
			class C {
				def void n() {
					m(#[ true ])
				}
				def void m(String[] s) {}
				def void m(boolean[] s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_12() {
		'''
			class C {
				def void n() {
					m(#[ '' ])
				}
				def void m(String[] s) {}
				def void m(boolean[] s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_13() {
		'''
			class C {
				def void n() {
					m(true)
				}
				def void m(String... s) {}
				def void m(boolean... s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_14() {
		'''
			class C {
				def void n() {
					m('')
				}
				def void m(String... s) {}
				def void m(boolean... s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_15() {
		'''
			class C {
				def void n() {
					m(#[ null ])
				}
				def void m(String... s) {}
				def void m(boolean... s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_16() {
		'''
			class C {
				def void n() {
					m(#[ true ])
				}
				def void m(String... s) {}
				def void m(boolean... s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_17() {
		'''
			class C {
				def void n() {
					m(#[ '' ])
				}
				def void m(String... s) {}
				def void m(boolean... s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_18() {
		'''
			import java.util.*
			class C {
				def void n() {
					m(#[ true ])
				}
				def void m(List<String> s) {}
				def void m(Collection<Boolean> s) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_19() {
		'''
			import java.util.*
			class C {
				def void n() {
					m(#[ '' ])
				}
				def void m(List<String> s) {}
				def void m(Collection<Boolean> s) {}
			}
		'''.assertUnambiguous
	}

	@Test
	def void testUnambiguousMethods_20() {
		'''
			import java.util.*
			class C {
				def void n() {
					m []
				}
				def void m(()=>void p) {}
				def void m((int)=>void p) {}
			}
		'''.assertUnambiguous
	}	

	@Test
	def void testUnambiguousMethods_21() {
		'''
			import java.util.*
			class C {
				def void n() {
					m []
				}
				def void m((int, int)=>void p) {}
				def void m((int)=>void p) {}
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
	def void testAmbiguousOperators_03() {
		'''
			class C {
				def void m(C c1, C c2) {
					c1 + c2
				}
				def void +(C c, Object o) {}
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
	def void testAmbiguousOperators_04() {
		'''
			class C {
				def void n(String s) {
					-s
				}
				def void operator_minus(CharSequence c) {}
				def void -(java.io.Serializable s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous unary operation.
			The operator declarations
				operator_minus(CharSequence) in C and
				operator_minus(Serializable) in C
			both match.''')
	}
	
	@Test
	def void testUnambiguousOperators_01() {
		'''
			class C {
				def void n(String s) {
					s+s
				}
				def void operator_plus(String s1, String s2) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousOperators_02() {
		'''
			class C {
				def void n(String s) {
					s+s
				}
				def void +(String s1, String s2) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousOperators_03() {
		'''
			class C {
				def void n(String s) {
					s+s
				}
				def static void operator_plus(String s1, String s2) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousOperators_04() {
		'''
			class C {
				def void n(String s) {
					s+s
				}
				def static void +(String s1, String s2) {}
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
	def void testAmbiguousMethods_06() {
		'''
			class C {
				def bar() { foo("foo") }
				def foo(CharSequence x) {}
				def foo(Comparable<?> x) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				foo(CharSequence) in C and
				foo(Comparable<?>) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_07() {
		'''
			class C {
				def bar() { foo }
				def foo() {}
				def getFoo() {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				foo() in C and
				getFoo() in C
			both match.''')
	}
	
	
	@Test
	def void testAmbiguousMethods_08() {
		'''
			class C {
				def Iterable<String> m() {
					val list = new java.util.ArrayList
					list.add(new java.util.ArrayList)
					list.head.head.head
				}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The extension methods
				<T> head(Iterable<T>) in IterableExtensions and
				<T> head(Iterator<T>) in IteratorExtensions
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_09() {
		'''
			import java.util.*
			class C {
				def void n() {
					m(<StringBuilder>newArrayList)
				}
				def void m(Collection<? extends CharSequence> c) {}
				def void m(List<? extends Appendable> c) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(Collection<? extends CharSequence>) in C and
				m(List<? extends Appendable>) in C
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethods_10() {
		'''
			import java.util.*
			class C {
				def void n() {
					m(<StringBuilder>newArrayList)
				}
				def void m(Collection<? extends CharSequence> c) {}
				def void m(List<? extends Appendable> c) {}
				def void m(Iterable<? extends StringBuilder> c) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(Collection<? extends CharSequence>) in C,
				m(List<? extends Appendable>) in C and
				m(Iterable<? extends StringBuilder>) in C
			all match.''')
	}
	
	@Test
	def void testAmbiguousMethods_11() {
		'''
			import java.util.*
			class C {
				def void n(List<Integer> list) {
					m(list)
				}
				def void m(List list) {}
				def void m(Collection<Integer> coll) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(List) in C and
				m(Collection<Integer>) in C
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
	
	@Test
	def void testUnambiguousMethods_03() {
		'''
			class C {
				def Iterable<String> m() {
					val list = new java.util.ArrayList
					list.add(new java.util.ArrayList)
					list.head.flatten.head
				}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_04() {
		'''
			import java.util.*
			class C {
				def Iterator<String> m() {
					val list = new ArrayList
					list.add(new ArrayList)
					list.head.flatten.head
				}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_05() {
		'''
			import java.util.*
			class C {
				def void n() {
					m(<StringBuilder>newArrayList)
				}
				def void m(Collection<? extends CharSequence> c) {}
				def void m(List<? extends Appendable> c) {}
				def void m(AbstractList<? extends StringBuilder> c) {}
				def void m(Iterable<? extends StringBuilder> c) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_06() {
		'''
			class C {
				def void n(L<String> list) {
					list.addListener [
						LC<? extends String> c |
					]
				}
			}
			interface O {
				def void addListener(IL listener)
			}
			interface L<E> extends O {
				def void addListener(LL<? super E> listener)
			}
			interface LL<E> {
				def void onChanged(LC<? extends E> c)
			}
			interface LC<E> {}
			interface IL {
				def void invalidated(O o)
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_07() {
		'''
			class C {
				def void n(L<String> list) {
					list.addListener [
						LC<? extends CharSequence> lc |
					]
				}
			}
			interface O {
				def void addListener(IL listener)
			}
			interface L<E> extends O {
				def void addListener(LL<? super E> listener)
			}
			interface LL<E> {
				def void onChanged(LC<? extends E> c)
			}
			interface LC<E> {}
			interface IL {
				def void invalidated(O o)
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_08() {
		'''
			class C {
				def void n(L<String> list) {
					list.addListener [
						O o |
					]
				}
			}
			interface O {
				def void addListener(IL listener)
			}
			interface L<E> extends O {
				def void addListener(LL<? super E> listener)
			}
			interface LL<E> {
				def void onChanged(LC<? extends E> c)
			}
			interface LC<E> {}
			interface IL {
				def void invalidated(O o)
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_09() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| return; ]
				}
				def void m(Runnable r) {}
				def void m(Callable<String> c) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_10() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| return ''; ]
				}
				def void m(Runnable r) {}
				def void m(Callable<String> c) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_11() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| if (true) return '' ]
				}
				def void m(Runnable r) {}
				def void m(Callable<String> c) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_12() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| if (true) return ''; '' ]
				}
				def void m(Runnable r) {}
				def void m(Callable<String> c) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_13() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| if (true) return '' else '' ]
				}
				def void m(Runnable r) {}
				def void m(Callable<String> c) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_14() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| '' ]
				}
				def void m(()=>String f) {}
				def void m(Callable<Integer> c) {}
			}
		'''.assertUnambiguous
	}
	
	@Test
	def void testUnambiguousMethods_15() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| 1 ]
				}
				def void m(()=>String f) {}
				def void m(Callable<Integer> c) {}
			}
		'''.assertUnambiguous
	}

	@Test
	def void testUnambiguousMethods_16() {
		'''
			import java.util.concurrent.*
			class C {
				def void n() {
					m [| '' ]
				}
				def void m(Runnable r) {}
				def void m(Callable<String> c) {}
			}
		'''.assertUnambiguous
	}	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguousRawFeatureCallTest extends AmbiguityValidationTest {
	@Test
	def void testAmbiguousMethods_01() {
		'''
			class C {
				def void n() {
					m(newArrayList)
				}
				def void m(Iterable i) {}
				def void m(java.io.Serializable s) {}
			}
		'''.assertAmbiguous('''
		Ambiguous feature call.
		The methods
			m(Iterable) in C and
			m(Serializable) in C
		both match.''')
	}
	
	@Test
	def void testUnambiguousMethods_01() {
		'''
			class C {
				def void n() {
					m(newArrayList)
				}
				def void m(Iterable i) {}
				def void m(Object o) {}
			}
		'''.assertUnambiguous
	}

	@Test
	def void testUnambiguousMethods_02() {
		'''
			import java.util.Collection
			class C {
				def void n() {
					new C(newArrayList)
				}
				new(Collection i) {}
				new(Object s) {}
			}
		'''.assertUnambiguous
	}
	
}