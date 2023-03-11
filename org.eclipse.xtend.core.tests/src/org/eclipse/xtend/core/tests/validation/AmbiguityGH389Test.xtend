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
class AmbiguityGH389Test extends AmbiguityValidationTest {
	
	@Test
	def void testAmbiguousConstructorCall_01() {
		'''
			class Bug {
			  def static m() {
			    new Bug(null)
			  }
			  new(String s) {}
			  new(Void v) {}
			}
		'''.assertAmbiguous('''
			Ambiguous constructor call.
			The constructors
				Bug(String) and
				Bug(Void)
			both match.''')
	}
	
	@Test
	def void testUnambiguousConstructorCall_01() {
		'''
			class Bug {
			  def static m() {
			    new Bug(null)
			  }
			  new(String s) {
			  }
			  new(CharSequence c) {}
			}
		'''.assertUnambiguous
	}
	
}