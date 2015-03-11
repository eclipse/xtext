/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguityBug426779Test extends AmbiguityValidationTest {
	
	@Test
	def void testUnambiguousMethod_01() {
		'''
			class Bug {
				def void m(String s) {}
				def <T extends CharSequence> void m(T t) {}
				def void n(Iterable<String> it) {
					m(it.head)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_02() {
		'''
			class Bug {
				def <T extends Object> void m(T t) {}
				def <T extends CharSequence> void m(T t) {}
				def void n(Iterable<String> it) {
					m(it.head)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_03() {
		'''
			class Bug {
				def void m(Object t) {}
				def void m(CharSequence t) {}
				def void n(Iterable<String> it) {
					m(it.head)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_04() {
		'''
			class Bug {
				def <T extends Object> void m(T t) {}
				def void m(CharSequence t) {}
				def void n(Iterable<String> it) {
					m(it.head)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testAmbiguousMethod_01() {
		'''
			class Bug {
				def void n(Iterable<String> it) {
					m(it.head)
				}
				def void m(java.io.Serializable s) {}
				def void m(CharSequence t) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(Serializable) in Bug and
				m(CharSequence) in Bug
			both match.''')
	}
		
}