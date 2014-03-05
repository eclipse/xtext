/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class AmbiguityBug429623Test extends AmbiguityValidationTest {
	
	@Test
	def void testUnambiguousMethod_01() {
		'''
			class Bug {
				def void m(String... s) {}
				def void m(String[] s, int... i) {}
				def void n(String[] s) {
					m(s)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_02() {
		'''
			class Bug {
				def void n() {
					m('', '')
				}
				def void m(String s, String... s2) {}
				def void m(String... s) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testAmbiguousMethod_01() {
		'''
			class Bug {
				def void n() {
					m()
				}
				def void m(String... s) {}
				def void m(int... i) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String[]) in Bug and
				m(int[]) in Bug
			both match.''')
	}
	
	@Test
	def void testAmbiguousMethod_02() {
		'''
			class Bug {
				def void n() {
					m('')
				}
				def void m(String s, String... s2) {}
				def void m(String... s) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				m(String, String[]) in Bug and
				m(String[]) in Bug
			both match.''')
	}
	
}