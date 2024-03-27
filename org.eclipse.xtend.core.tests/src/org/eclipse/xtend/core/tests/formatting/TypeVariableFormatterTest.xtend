/*******************************************************************************
 * Copyright (c) 2012, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.formatting

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.formatter.AbstractFormatterTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class TypeVariableFormatterTest extends AbstractFormatterTest {
	
	private def CharSequence paramToFile(CharSequence string) '''
		import java.util.*
		
		class Foo«string» {
		}
	'''

	def assertTypeParam(CharSequence toBeFormatted) {
		toBeFormatted.paramToFile.assertUnformattedEqualsFormatted
	}
	
	@Test def integration() {
		assertUnformattedEqualsFormatted('''
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