/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import org.eclipse.xtext.xbase.lib.util.ReflectExtensions
import org.junit.Test
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard
import org.junit.Assert

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class RecursionGuardTest {
	
	extension ReflectExtensions = new ReflectExtensions
	
	@Test
	def void tryNextAndDoneYieldsEmpty() {
		new RecursionGuard<String> => [
			val s = 'literal'
			Assert.assertTrue(tryNext(s))
			done(s)
			Assert.assertNull(get('head'))
		]	
	}
	
	@Test
	def void tryNextTwiceYieldsFalse() {
		new RecursionGuard<String> => [
			val s = 'literal'
			Assert.assertTrue(tryNext(s))
			Assert.assertFalse(tryNext(s))
		]	
	}
	
	@Test
	def void tryNextWithDifferentValuesYieldsTrue() {
		new RecursionGuard<String> => [
			Assert.assertTrue(tryNext('first'))
			Assert.assertTrue(tryNext('second'))
		]	
	}
	
	@Test
	def void clearYieldsEmpty() {
		new RecursionGuard<String> => [
			Assert.assertTrue(tryNext('dummy'))
			clear
			Assert.assertNull(get('head'))
		]	
	}
	
	@Test(expected = IllegalStateException)
	def void doneTwice() {
		new RecursionGuard<String> => [
			val s = 'literal'
			Assert.assertTrue(tryNext(s))
			done(s)
			done(s)
		]	
	}
	
}