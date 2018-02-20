/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.eclipse.xtext.diagnostics.Severity

/**
 * Test that the SuppressWarnings annotation is considered for raised warnings.
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 */
class SuppressWarningsTest extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_MissingAnnotationRaisesWarning() {
		val file = parser.parse('''
			interface IAdaptable {
				def <T> T getAdapter(Class<T> adapter)
			}
			class FooAdapter implements IAdaptable {
				override getAdapter(Class adapter) {}
			}
		''')
		helper.assertWarning(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE)
	}


	@Test def void test_01() {
		val file = parser.parse('''
			interface IAdaptable {
				def <T> T getAdapter(Class<T> adapter)
			}
			class FooAdapter implements IAdaptable {
				override getAdapter(@SuppressWarnings("rawtypes") Class adapter) {}
			}
		''')
		helper.assertNoIssues(file)
	}

	@Test def void test_02() {
		val file = parser.parse('''
			interface IAdaptable {
				def <T> T getAdapter(Class<T> adapter)
			}
			class FooAdapter implements IAdaptable {
				override getAdapter(@SuppressWarnings("all") Class adapter) {}
			}
		''')
		helper.assertNoIssues(file)
	}

	/** Test: Place annotation on the method, not direct at the parameter */
	@Test def void test_03() {
		val file = parser.parse('''
			interface IAdaptable {
				def <T> T getAdapter(Class<T> adapter)
			}
			class FooAdapter implements IAdaptable {
				@SuppressWarnings("rawtypes")
				override getAdapter(Class adapter) {}
			}
		''')
		helper.assertNoIssues(file)
	}

	/** Test: Place annotation on the class, not direct at the parameter */
	@Test def void test_04() {
		val file = parser.parse('''
			interface IAdaptable {
				def <T> T getAdapter(Class<T> adapter)
			}
			@SuppressWarnings("rawtypes")
			class FooAdapter implements IAdaptable {
				override getAdapter(Class adapter) {}
			}
		''')
		helper.assertNoIssues(file)
	}

	/** Test: Raw variable */
	@Test def void test_05() {
		val file = parser.parse('''
			@SuppressWarnings("rawtypes")
			class Foo {
				val Class foo = null
			}
		''')
		helper.assertNoIssues(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE, Severity.WARNING)
	}

	/** Test: Raw variable, missing annotation raises warning */
	@Test def void test_06() {
		val file = parser.parse('''
			class Foo {
				val Class foo = null
			}
		''')
		helper.assertIssue(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE, Severity.WARNING)
	}

	/** Test: SuppressWarnings present, but with ignored value */
	@Test def void test_IgnoredSuppressedWarnings() {
		val file = parser.parse('''
			interface IAdaptable {
				def <T> T getAdapter(Class<T> adapter)
			}
			class FooAdapter implements IAdaptable {
				override getAdapter(@SuppressWarnings("dummy") Class adapter) {}
			}
		''')
		helper.assertWarning(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE)
	}

}