package org.eclipse.xtend.core.tests.formatting

import org.junit.Test

class TypeVariableFormatterTest extends AbstractXtendFormatterTest {
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

	def assertTypeParam(CharSequence toBeFormatted) {
		assertFormatted(toBeFormatted.paramToFile)
	}
	
	@Test def integration() {
		assertFormatted('''
			import java.util.*
			
			class Foo<T extends Collection<?>, K extends Collection<?>> {
			
				new<A extends Collection<?>, B extends Collection<?>>() {
				}
			
				def <U extends Collection<?>, V extends Collection<?>> void methode() {
				}
			}
		''')
	} 

	@Test def tparam1() {
		assertTypeParam("<T>")
	}

	@Test def tparam2() {
		assertTypeParam("<T, K>")
	}

	@Test def tparamUpperBound() {
		assertTypeParam("<T extends String>")
	}
	
	@Test def tparamUpperBound2() {
		assertTypeParam("<T extends Collection<?>>")
	}

	@Test def tparamUpperBound3() {
		assertTypeParam("<T extends Collection<?>, K extends Collection<?>>")
	}
	
	@Test def tparamUpperBound4() {
		assertTypeParam("<T extends Collection<?> & List<?>>")
	}
}