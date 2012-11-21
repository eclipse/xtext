package org.eclipse.xtext.xbase.tests.formatting

import org.junit.Test

class TypeReferenceFormatterTest extends AbstractXbaseFormatterTest {
	def assertTypeRef(CharSequence toBeFormatted) {
		assertFormatted('''
			{
				var «toBeFormatted» x
			}
		''')
	}
	
	@Test def simple() {
		assertTypeRef("String")
	}

	@Test def array1() {
		assertTypeRef("String[]")
	}

	@Test def array2() {
		assertTypeRef("String[][]")
	}

	@Test def function0() {
		assertTypeRef("=>void")
	}
	
	@Test def function1() {
		assertTypeRef("()=>void")
	}

	@Test def function2() {
		assertTypeRef("(String)=>String")
	}

	@Test def function3() {
		assertTypeRef("(Collection<?>)=>Collection<?>")
	}

	@Test def function4() {
		assertTypeRef("(Collection<? extends String>)=>Collection<? extends String>")
	}

	@Test def function5() {
		assertTypeRef("(String, String)=>String")
	}

	@Test def parameters1() {
		assertTypeRef("Collection<String>")
	}

	@Test def parameters2() {
		assertTypeRef("Map<String, String>")
	}

	@Test def parametersNested() {
		assertTypeRef("Map<Collection<String>, Collection<String>>")
	}

	@Test def parametersUpperBound() {
		assertTypeRef("Collection<? extends String>")
	}

	@Test def parametersLowerBound() {
		assertTypeRef("Collection<? super String>")
	}
}

