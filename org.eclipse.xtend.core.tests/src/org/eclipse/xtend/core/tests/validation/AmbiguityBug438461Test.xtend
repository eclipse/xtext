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
class AmbiguityBug438461Test extends AmbiguityValidationTest {
	
	@Test
	def void testUnambiguousMethod_01() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ "".notify() ]
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_02() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ return '' ]
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_03() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ return ]
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_04() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ "" ]
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_05() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ return null ]
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_06() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ null ]
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_07() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ if (true) return null else null ]
				}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_08() {
		'''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit []
				}
			}
		'''.assertUnambiguous()
	}
	
}