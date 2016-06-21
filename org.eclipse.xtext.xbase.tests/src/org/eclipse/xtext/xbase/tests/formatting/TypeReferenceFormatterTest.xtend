package org.eclipse.xtext.xbase.tests.formatting

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.FormatterTestRequest
import org.eclipse.xtext.xbase.junit.formatter.FormatterTester
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(XbaseFormatterTestInjectorProvider)
class TypeReferenceFormatterTest {

	@Inject FormatterTester tester

	def private assertFormattedTypeRef((FormatterTestRequest)=>void test) {
		tester.assertFormatted [
			test.apply(it)
			toBeFormatted = '''
				{
					var «toBeFormatted» x
				}
			'''.toString.trim
		]
	}

	@Test def simple() {
		assertFormattedTypeRef [
			toBeFormatted = "String"
		]
	}

	@Test def array1() {
		assertFormattedTypeRef [
			toBeFormatted = "String[]"
		]
	}

	@Test def array2() {
		assertFormattedTypeRef [
			toBeFormatted = "String[][]"
		]
	}

	@Test def function0() {
		assertFormattedTypeRef [
			toBeFormatted = "=>void"
		]
	}

	@Test def function1() {
		assertFormattedTypeRef [
			toBeFormatted = "()=>void"
		]
	}

	@Test def function2() {
		assertFormattedTypeRef [
			toBeFormatted = "(String)=>String"
		]
	}

	@Test def function3() {
		assertFormattedTypeRef [
			toBeFormatted = "(Collection<?>)=>Collection<?>"
		]
	}

	@Test def function4() {
		assertFormattedTypeRef [
			toBeFormatted = "(Collection<? extends String>)=>Collection<? extends String>"
		]
	}

	@Test def function5() {
		assertFormattedTypeRef [
			toBeFormatted = "(String, String)=>String"
		]
	}

	@Test def parameters1() {
		assertFormattedTypeRef [
			toBeFormatted = "Collection<String>"
		]
	}

	@Test def parameters2() {
		assertFormattedTypeRef [
			toBeFormatted = "Map<String, String>"
		]
	}

	@Test def parametersNested() {
		assertFormattedTypeRef [
			toBeFormatted = "Map<Collection<String>, Collection<String>>"
		]
	}

	@Test def parametersUpperBound() {
		assertFormattedTypeRef [
			toBeFormatted = "Collection<? extends String>"
		]
	}

	@Test def parametersLowerBound() {
		assertFormattedTypeRef [
			toBeFormatted = "Collection<? super String>"
		]
	}
}
