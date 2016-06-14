/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ValidationBug432193Test extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val file = parser.parse('''
			interface Bar {
				def void bar(Object o) 
			}
			class Foo {
				Bar bar = [ String o | 
					o.substring(7)
				]
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (String)=>void to Bar')
	}
	
	@Test def void test_02() {
		val file = parser.parse('''
			interface Bar<T extends Number> {
				def void bar(T o) 
			}
			class Foo {
				public Bar<?> bar = [ String o | 
					o.substring(7)
				]
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (String)=>void to Bar')
	}
	
	@Test def void test_03() {
		val file = parser.parse('''
			interface Bar {
				def void bar(String o) 
			}
			class Foo {
				Bar bar = [ Object o | 
				]
			}
		''')
		helper.assertNoErrors(file)
	}
	
	@Test def void test_04() {
		val file = parser.parse('''
			interface Bar<T extends Number> {
				def void bar(T o) 
			}
			class Foo {
				public Bar<?> bar = [ Integer o | 
				]
			}
		''')
		helper.assertNoErrors(file)
	}
	
	@Test def void test_05() {
		val file = parser.parse('''
			class SAM {
				def foo() {
					val MyAbstract1<Integer> x1 = [String k|k.substring(0, 1).length]
				}
			}
			abstract class MyAbstract1<T> {
				def T myAbstract(int u);
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (String)=>int to MyAbstract1<Integer>')
	}
	
	@Test def void test_06() {
		val file = parser.parse('''
			class SAM {
				def foo() {
					val MyInterface<Integer> x2 = [String k|k.substring(0, 1).length]
				}
			}
			interface MyInterface<T> {
				def T myAbstract(int u);
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (String)=>int to MyInterface<Integer>')
	}

	@Test def void test_07() {
		val file = parser.parse('''
			interface Bar<T extends Number> {
				def void bar(Iterable<T> o) 
			}
			class Foo {
				public Bar<?> bar = [ Iterable<String> o | 
				]
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (Iterable<String>)=>void to Bar<?>')
	}

	@Test def void test_08() {
		val file = parser.parse('''
			interface Bar<T extends Number> {
				def void bar(Iterable<T> o) 
			}
			class Foo {
				public Bar<? super Integer> bar = [ Iterable<String> o | 
				]
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (Iterable<String>)=>void to Bar<? super Integer>')
	}

	@Test def void test_09() {
		val file = parser.parse('''
			interface Bar<T extends Number> {
				def String bar(Iterable<T> o) 
			}
			class Foo {
				public Bar<? extends Integer> bar = [ Iterable<Integer> o | 
					o.head
				]
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from Integer to String')
	}

	@Test def void test_10() {
		val file = parser.parse('''
			interface Bar {
				def void bar(java.util.List<Number> o) 
			}
			class Foo {
				public Bar bar = [ Iterable<String> o | 
				]
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (Iterable<String>)=>void to Bar')
	}

	@Test def void test_11() {
		val file = parser.parse('''
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
		''')
		helper.assertNoErrors(file)
	}

	@Test def void test_12() {
		val file = parser.parse('''
			class C {
				def void n(L<String> list) {
					list.addListener [
						LC<String> c |
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
		''')
		helper.assertError(file, XbasePackage.Literals.XCLOSURE, IssueCodes.INCOMPATIBLE_TYPES, 'Type mismatch: cannot convert from (LC<String>)=>void to LL<? super String>')
	}

	@Test def void test_13() {
		val file = parser.parse('''
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
				def void onChanged(LC<E> c)
			}
			interface LC<E> {}
			interface IL {
				def void invalidated(O o)
			}
		''')
		helper.assertNoErrors(file)
	}

	@Test def void test_14() {
		val file = parser.parse('''
			class C {
				def void n(L<String> list) {
					list.addListener [
						LC<? super String> c |
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
				def void onChanged(LC<E> c)
			}
			interface LC<E> {}
			interface IL {
				def void invalidated(O o)
			}
		''')
		helper.assertNoErrors(file)
	}
}