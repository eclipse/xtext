/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguityBug421831Test extends AmbiguityValidationTest {
	
	@Test
	def void testAmbiguousStaticImports_01() {
		'''
			import static MockitoMatchers.* 
			import static HarmcrestMatchers.*
			
			class Bug {
			  def static accept(Bug bug) {
			    any(Bug)
			  }
			}
			class MockitoMatchers {
				static def <T> Matcher<T> any(Class<T> type) {}
			}
			class Matcher<T> {}
			class HarmcrestMatchers {
				static def <T> T any(Class<T> clazz) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				<T> any(Class<T>) in MockitoMatchers and
				<T> any(Class<T>) in HarmcrestMatchers
			both match.''')
	}
	
	@Test
	def void testUnambiguousStaticImports_01() {
		'''
			import static MockitoMatchers.* 
			import static HarmcrestMatchers.*
			
			class Bug {
			  def static accept(Bug bug) {
			    any(Bug)
			  }
			}
			class MockitoMatchers {
				static def <T extends Number> Matcher<T> any(Class<T> type) {}
			}
			class Matcher<T> {}
			class HarmcrestMatchers {
				static def <T> T any(Class<T> clazz) {}
			}
		'''.assertUnambiguous
	}
	
	@Ignore("TODO fix me")
	@Test
	def void testUnambiguousStaticImports_02() {
		'''
			import static MockitoMatchers.* 
			import static HarmcrestMatchers.*
			
			class Bug {
			  def static accept(Bug bug) {
			    any(Bug)
			  }
			}
			class MockitoMatchers {
				static def <T> Matcher<T> any(Class<T> type) {}
			}
			class Matcher<T> {}
			class HarmcrestMatchers {
				static def Bug any(Class<? extends Bug> clazz) {}
			}
		'''.assertUnambiguous
	}
	
	@Ignore("TODO fix me")
	@Test
	def void testUnambiguousStaticImports_03() {
		'''
			import static MockitoMatchers.* 
			import static HarmcrestMatchers.*
			
			class Bug {
			  def static accept(Bug bug) {
			    any(Bug)
			  }
			}
			class MockitoMatchers {
				static def <T> Matcher<T> any(Class<T> type) {}
			}
			class Matcher<T> {}
			class HarmcrestMatchers {
				static def <T extends Bug> T any(Class<T> clazz) {}
			}
		'''.assertUnambiguous
	}
	
}