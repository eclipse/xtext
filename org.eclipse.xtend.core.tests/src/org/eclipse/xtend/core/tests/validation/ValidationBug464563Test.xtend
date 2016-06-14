/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
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
 * @author kosyakov - Initial contribution and API
 */
class ValidationBug464563Test extends AbstractXtendTestCase {

	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<XtendFile>

	@Test def void testJvmOperation_01() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def Unknown foo(Unknown2 arg0, List<Unknown3> arg1) throws Unknown4 {
				}

				def void bar() {
					foo(null, null) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown'
		)
		file.assertNoErrors(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown2'
		)
	}

	@Test def void testJvmOperation_02() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def Object foo(Unknown2 arg0, List<Unknown3> arg1) throws Unknown4 {
				}

				def void bar() {
					foo(null, null) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown2'
		)
		file.assertNoErrors(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Unknown2, List<Unknown3>) from the type Foo refers to the missing type Unknown3'
		)
	}

	@Test def void testJvmOperation_03() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def Object foo(Object arg0, List<Unknown3> arg1) throws Unknown4 {
				}

				def void bar() {
					foo(null, null) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Object, List<Unknown3>) from the type Foo refers to the missing type Unknown3'
		)
		file.assertNoErrors(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Object, List<Unknown3>) from the type Foo refers to the missing type Unknown4'
		)
	}

	@Test def void testJvmOperation_04() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def Object foo(Object arg0, List<Object> arg1) throws Unknown4 {
				}

				def void bar() {
					foo(null, null) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Object, List<Object>) from the type Foo refers to the missing type Unknown4'
		)
	}

	@Test def void testJvmOperation_05() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def void foo(List<Unknown[]> arg0) {
				}

				def void bar() {
					foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(List<Unknown[]>) from the type Foo refers to the missing type Unknown'
		)
	}

	@Test def void testJvmOperation_06() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def void foo(List<? extends Unknown> arg0) {
				}

				def void bar() {
					foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(List<? extends Unknown>) from the type Foo refers to the missing type Unknown'
		)
	}

	@Test def void testJvmOperation_07() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def void foo(List<? super Unknown> arg0) {
				}

				def void bar() {
					foo(notify) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(List<? super Unknown>) from the type Foo refers to the missing type Unknown'
		)
	}

	@Test def void testJvmOperation_08() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				def <T extends Unknown & Unknown2> void foo(List<T> arg0) {
				}

				def void bar() {
					foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(List<T>) from the type Foo refers to the missing type Unknown'
		)
	}

	@Test def void testJvmOperation_09() {
		val file = '''
			package mypackage
			
			class Foo {
			
				def <T extends Unknown & Unknown2> void foo(T arg0) {
				}

				def void bar() {
					foo(notify) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(T) from the type Foo refers to the missing type Unknown'
		)
	}

	@Test def void testJvmOperation_10() {
		val file = '''
			package mypackage
			
			class Foo {
			
				def void foo(void arg0) {
				}

				def void bar() {
					foo(notify) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(void) from the type Foo has an illegal argument type'
		)
	}

	@Test def void testJvmOperation_11() {
		val file = '''
			package mypackage
			
			class Foo {
			
				def void foo(Unknown<?> arg0) {
				}

				def void bar() {
					foo(notify) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XFEATURE_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The method foo(Unknown) from the type Foo refers to the missing type Unknown'
		)
	}

	@Test def void testJvmConstructor_01() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				new (Unknown arg0, List<Unknown2> arg1) throws Unknown3 {
				}

				def void bar() {
					new Foo(null, null) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(Unknown, List<Unknown2>) refers to the missing type Unknown'
		)
		file.assertNoErrors(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(Unknown, List<Unknown2>) refers to the missing type Unknown2'
		)
	}

	@Test def void testJvmConstructor_02() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				new (Object arg0, List<Unknown2> arg1) throws Unknown3 {
				}

				def void bar() {
					new Foo(null, null) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(Object, List<Unknown2>) refers to the missing type Unknown2'
		)
		file.assertNoErrors(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(Object, List<Unknown2>) refers to the missing type Unknown3'
		)
	}

	@Test def void testJvmConstructor_03() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				new (Object arg0, List<Object> arg1) throws Unknown3 {
				}

				def void bar() {
					new Foo(null, null) 
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(Object, List<Object>) refers to the missing type Unknown3'
		)
	}

	@Test def void testJvmConstructor_04() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				new (List<Unknown[]> arg0) {
				}

				def void bar() {
					new Foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(List<Unknown[]>) refers to the missing type Unknown'
		)
	}

	@Test def void testJvmConstructor_05() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				new (List<? extends Unknown> arg0) {
				}

				def void bar() {
					new Foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(List<? extends Unknown>) refers to the missing type Unknown'
		)
	}

	@Test def void testJvmConstructor_06() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				new (List<? super Unknown> arg0) {
				}

				def void bar() {
					new Foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(List<? super Unknown>) refers to the missing type Unknown'
		)
	}

	@Test def void testJvmConstructor_07() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				new <T extends Unknown & Unknown2> (List<T> arg0) {
				}

				def void bar() {
					new Foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(List<T>) refers to the missing type Unknown'
		)
	}

	@Test def void testJvmConstructor_08() {
		val file = '''
			package mypackage
			
			class Foo {
			
				new <T extends Unknown & Unknown2> (T arg0) {
				}

				def void bar() {
					new Foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(T) refers to the missing type Unknown'
		)
	}

	@Test def void testJvmConstructor_09() {
		val file = '''
			package mypackage
			
			class Foo {
			
				new(void arg0) {
				}

				def void bar() {
					new Foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(void) has an illegal argument type'
		)
	}

	@Test def void testJvmConstructor_10() {
		val file = '''
			package mypackage
			
			class Foo {

				new (Unknown<?> arg0) {
				}

				def void bar() {
					new Foo(notify)
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XCONSTRUCTOR_CALL,
			IssueCodes.REFER_INVALID_TYPES,
			'The constructor Foo(Unknown) refers to the missing type Unknown'
		)
	}

	@Test def void testJvmField_01() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				List<Unknown[]> myField

				def void bar() {
					myField = notify
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XASSIGNMENT,
			IssueCodes.REFER_INVALID_TYPES,
			'The field Foo.myField refers to the missing type Unknown'
		)
	}

	@Test def void testJvmField_02() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				List<? extends Unknown> myField

				def void bar() {
					myField = notify
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XASSIGNMENT,
			IssueCodes.REFER_INVALID_TYPES,
			'The field Foo.myField refers to the missing type Unknown'
		)
	}

	@Test def void testJvmField_03() {
		val file = '''
			package mypackage
			
			import java.util.List
			
			class Foo {
			
				List<? super Unknown> myField

				def void bar() {
					myField = notify
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XASSIGNMENT,
			IssueCodes.REFER_INVALID_TYPES,
			'The field Foo.myField refers to the missing type Unknown'
		)
	}

	@Test def void testJvmField_04() {
		val file = '''
			package mypackage
			
			class Foo {
			
				void myField

				def void bar() {
					myField = notify
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XASSIGNMENT,
			IssueCodes.REFER_INVALID_TYPES,
			'The field Foo.myField has an illegal argument type'
		)
	}

	@Test def void testJvmField_05() {
		val file = '''
			package mypackage
			
			class Foo {

				Unknown<?> myField

				def void bar() {
					myField = notify
				}
			
			}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XASSIGNMENT,
			IssueCodes.REFER_INVALID_TYPES,
			'The field Foo.myField refers to the missing type Unknown'
		)
	}

}