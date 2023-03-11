/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguityGH897Test extends AmbiguityValidationTest {
	
	@Test
	def void testAmbiguousConstructorCall_01() {
		'''
			class SampleImpl implements Sample {
				def x() {
					new Demo(null)
				}
			}
			interface Sample {
				class Demo {
					new(String s) {}
					new(Integer s) {}
				}
			}
		'''.assertAmbiguous('''
			Ambiguous constructor call.
			The constructors
				Demo(String) and
				Demo(Integer)
			both match.''')
	}
	
	@Test
	def void testUnambiguousConstructorCall_01() {
		'''
			interface Sample {
				class Demo {
					
				}
				static class SampleImpl implements Sample {
					def x() {
						new Demo
					}
				}
			}
		'''.assertUnambiguous
	}
	
}