package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

class TypeReferenceFormatterTest extends AbstractFormatterTest {
	def assertTypeRef(CharSequence toBeFormatted) {
		assertFormatted('''
			import java.util.*
			
			class Foo {
				«toBeFormatted» x
			}
		''')
	}

	@Test def integration() {
		assertFormatted('''
			import java.util.*
			
			abstract class Foo extends AbstractMap<String, Collection<?>> implements List<String>, Map<String, Collection<?>> {
				String[] field
			
				def String[] methode(String[] param) {
					val String[] valTypes = null
					val featureCall1 = <String>newArrayList
					val featureCall2 = <String, Collection<?>>newHashMap
					val memberFeatureCall1 = featureCall1.<String>toList
					val memberFeatureCall2 = featureCall1.<String, Collection<?>>toMap[it]
					val constructorCall1 = new ArrayList<String>
					val constructorCall2 = new HashMap<String, Collection<?>>
					val slclosure1 = [Collection<String> x|x]
					val slclosure2 = [Collection<String> x, Map<String, Collection<?>> y|x]
					val mlclosure1 = [ Collection<String> x |
						x
					]
					val mlclosure2 = [ Collection<String> x, Map<String, Collection<?>> y |
						x
					]
					null
				}
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

