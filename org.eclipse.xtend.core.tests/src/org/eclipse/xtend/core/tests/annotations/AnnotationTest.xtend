/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.annotations

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(RuntimeInjectorProvider))
class AnnotationTest extends AbstractXtendTestCase {
	
	@Test
	def testAnnotationValue_0() {
		'''
		@Click(2)
		class Foo {
		}
		annotation Click {
			int[] value
		}
		'''.compileToJavaCode.assertContains('@Click(2)')
	}

	@Test
	def testAnnotationValue_1() {
		'''
		@Click(#[2])
		class Foo {
		}
		annotation Click {
			int[] value
		}
		'''.compileToJavaCode.assertContains('@Click({ 2 })')
	}

	@Test
	def testAnnotationValue_2() {
		'''
		@Click(#[2,3])
		class Foo {
		}
		annotation Click {
			int[] value
		}
		'''.compileToJavaCode.assertContains('@Click({ 2, 3 })')
	}

	@Test
	def testAnnotationValue_3() {
		'''
		@Click(value = 2)
		class Foo {
		}
		annotation Click {
			int[] value
		}
		'''.compileToJavaCode.assertContains('@Click(value = 2)')
	}

	@Test
	def testAnnotationValue_4() {
		'''
		@Click(value = #[2])
		class Foo {
		}
		annotation Click {
			int[] value
		}
		'''.compileToJavaCode.assertContains('@Click(value = { 2 })')
	}

	@Test
	def testAnnotationValue_5() {
		'''
		@Click(value = #[2,3])
		class Foo {
		}
		annotation Click {
			int[] value
		}
		'''.compileToJavaCode.assertContains('@Click(value = { 2, 3 })')
	}

	protected def assertContains(CharSequence code, String text) {
		assertTrue('''Substring '«text»' not found in '«code»' ''', code.toString.contains(text))
	}

	
	@Inject ParseHelper<XtendFile> parseHelper
	@Inject ValidationTestHelper validationHelper
	@Inject IXtendJvmAssociations associations
	@Inject JvmModelGenerator generator
	@Inject IGeneratorConfigProvider generatorConfigProvider 
	
	protected def compileToJavaCode(CharSequence xtendCode) {
		val file = parseHelper.parse(xtendCode);
		validationHelper.assertNoErrors(file);
		val inferredType = associations.getInferredType(file.getXtendTypes().get(0));
		generator.generateType(inferredType, generatorConfigProvider.get(inferredType));
	}

		
	
}