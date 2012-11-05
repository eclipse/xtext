package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

class XtypeFormatterTest extends AbstractFormatterTest {
	def CharSequence refToFile(CharSequence string) '''
		import java.util.*
		
		class Foo {
			«string» x
		}
	'''

	def CharSequence paramToFile(CharSequence string) '''
		import java.util.*
		
		class Foo«string» {
		}
	'''

	def assertTypeRef(CharSequence expectation, CharSequence toBeFormatted) {
		assertFormatted(expectation.refToFile, toBeFormatted.refToFile)
	}

	def assertTypeParam(CharSequence expectation, CharSequence toBeFormatted) {
		assertFormatted(expectation.paramToFile, toBeFormatted.paramToFile)
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
		assertTypeRef("String", "String")
	}

	@Test def array1() {
		assertTypeRef("String[]", "String  []")
	}

	@Test def array2() {
		assertTypeRef("String[][]", "String  []  []")
	}

	@Test def function0() {
		assertTypeRef("=>void", "=>  void")
	}
	
	@Test def function1() {
		assertTypeRef("()=>void", "(  )  =>  void")
	}

	@Test def function2() {
		assertTypeRef("(String)=>String", "(  String  )  =>  String")
	}

	@Test def function3() {
		assertTypeRef("(Collection<?>)=>Collection<?>", "(  Collection  <  ?  >  )  =>  Collection  <  ?  >")
	}

	@Test def function4() {
		assertTypeRef("(Collection<? extends String>)=>Collection<? extends String>",
			"(  Collection  <  ?  extends  String  >  )  =>  Collection  <  ?  extends  String  >")
	}

	@Test def function5() {
		assertTypeRef("(String, String)=>String", "(  String  ,  String)  =>  String")
	}

	@Test def parameters1() {
		assertTypeRef("Collection<String>", "Collection  <  String  >")
	}

	@Test def parameters2() {
		assertTypeRef("Map<String, String>", "Map  <  String  , String  >")
	}

	@Test def parametersNested() {
		assertTypeRef("Map<Collection<String>, Collection<String>>",
			"Map  <  Collection  <  String  >  , Collection  <  String  >  >")
	}

	@Test def parametersUpperBound() {
		assertTypeRef("Collection<? extends String>", "Collection  <  ?  extends  String  >")
	}

	@Test def parametersLowerBound() {
		assertTypeRef("Collection<? super String>", "Collection  <  ?  super  String  >")
	}

//	@Test def tparam1() {
//		assertTypeParam("<T>", "  <  T  >")
//	}
//
//	@Test def tparam2() {
//		assertTypeParam("<T, K>", "  <  T  ,  K  >")
//	}
//
//	@Test def tparamUpperBound() {
//		assertTypeParam("<T extends String>", "  <  T   extends   String  >")
//	}
//
//	@Test def tparamLowerBound() {
//		assertTypeParam("<T super String>", "  <  T   super   String  >")
//	}
}

