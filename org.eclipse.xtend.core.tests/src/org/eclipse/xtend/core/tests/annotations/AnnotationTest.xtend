package org.eclipse.xtend.core.tests.annotations

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
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