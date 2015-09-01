/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import org.junit.Test

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class FinalFieldsConstructorCompilerTest extends AbstractXtendCompilerTest {
	
	@Inject
	extension ValidationTestHelper
	
	@Test def testOnClass() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			@FinalFieldsConstructor class C {
				val int a
				val String b
			}
		'''
		source.clazz.assertNoErrors
		source.compile[
			assertTrue(compiledClass.declaredConstructors.exists[
				parameterTypes.toList == #[int, String]
			])
		]
	}
	
	@Test def testOnConstructor() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				val int a
				val String b
				
				@FinalFieldsConstructor new() {}
			}
		'''
		source.clazz.assertNoErrors
		source.compile[
			assertTrue(compiledClass.declaredConstructors.exists[
				parameterTypes.toList == #[int, String]
			])
			assertFalse(compiledClass.declaredConstructors.exists[
				parameterTypes.empty
			])
		]
	}
	
	@Test def testOnGenericClass() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			@FinalFieldsConstructor class C<T> {
				val T a
			}
		'''
		source.clazz.assertNoErrors
		source.compile[
			assertTrue(singleGeneratedCode.contains("C(final T a)"))
		]
	}
	
	@Test def testDuplicate() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			@FinalFieldsConstructor
			class C {
				val int a
				@FinalFieldsConstructor new() {}
			}
		'''
		source.clazz.assertError(XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "FinalFieldsConstructor", "new(int)", "already exists")
	}
	
	@Test def testDuplicate2() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				val int a
				@FinalFieldsConstructor new() {}
				@FinalFieldsConstructor new() {}
			}
		'''
		source.clazz.assertError(XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "FinalFieldsConstructor", "new(int)", "already exists")
	}
	
	@Test def testParameterListValidation() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				val int a
				@FinalFieldsConstructor new(String a) {}
			}
		'''
		source.clazz.assertError(XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "Parameter list must be empty")
	}
	
	@Test def testBodyValidation() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			class C {
				val int a
				@FinalFieldsConstructor new() {
					this.a = 1
				}
			}
		'''
		source.clazz.assertError(XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "Body must be empty")
	}
	
	@Test def testIntegrationWithData() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			import org.eclipse.xtend.lib.annotations.Data
			@FinalFieldsConstructor @Data class C {
				val int a
				val String b
			}
		'''
		source.clazz.assertNoErrors
		source.compile[
			assertTrue(compiledClass.declaredConstructors.exists[
				parameterTypes.toList == #[int, String]
			])
		]
	}
	
	@Test def testIntegrationWithData2() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			import org.eclipse.xtend.lib.annotations.Data
			@FinalFieldsConstructor @Data class C {
				val int a
				val String b
				new() {
					a = 1
					b = "Foo"
				}
			}
		'''
		source.clazz.assertNoErrors
		source.compile[
			assertTrue(compiledClass.declaredConstructors.exists[
				parameterTypes.toList == #[int, String]
			])
		]
	}
	
	@Test def testIntegrationWithAccessors() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			import org.eclipse.xtend.lib.annotations.Accessors
			@FinalFieldsConstructor @Accessors class C {
				val int a
				val String b
			}
		'''
		source.clazz.assertNoErrors
		source.compile[
			assertTrue(compiledClass.declaredConstructors.exists[
				parameterTypes.toList == #[int, String]
			])
		]
	}
	
	@Test def testNoFinalFields() {
		val source = '''
			import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
			@FinalFieldsConstructor 
			class Foo{}
		'''
		source.clazz.assertWarning(XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no final fields")
	}
}