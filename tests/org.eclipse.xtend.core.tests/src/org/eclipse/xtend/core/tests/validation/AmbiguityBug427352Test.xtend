/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguityBug427352Test extends AmbiguityValidationTest {
	
	@Test
	def void testNoAmbiguityIfUnresolvedParam_01() {
		'''
			class C {
				def void m() {
					val x = doesnotexist
					String.valueOf(x)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testNoAmbiguityIfUnresolvedParam_02() {
		'''
			class C {
				def void m() {
					String.valueOf(x)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testNoAmbiguityIfUnresolvedParam_03() {
		'''
			class C {
				def void m(DoesNotExist x) {
					String.valueOf(x)
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testNoAmbiguityIfUnresolvedParam_04() {
		'''
			class C {
				def void m() {
					m('')
				}
				def void m(Unknown1 u) {}
				def void m(Unknown2 u) {}
			}
		'''.assertUnambiguous()
	}
	
	override assertUnambiguous(CharSequence contents) {
		val file = contents.parsedXtendFile
		file.assertNoErrors(IssueCodes.AMBIGUOUS_FEATURE_CALL)
	}
	
}