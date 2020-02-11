/*******************************************************************************
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util

import org.junit.Test

import static org.junit.Assert.*

/**
 * @author koehnlein - Initial contribution and API
 */
class StringsDiffTest {
	
	@Test def testDiff_0() {
		assertDiff('foo', 'foo', null)
	}

	@Test def testDiff_1() {
		assertDiff('foo', 'bar', '''
			[foo]
			vs
			[bar]
		''')
	}

	@Test def testDiff_2() {
		assertDiff('foo1', 'foobar', '''
			foo[1]
			vs
			foo[bar]
		''')
	}
	
	@Test def testDiff_3() {
		assertDiff('foo', 'foofoo', '''
			foo[]
			vs
			foo[foo]
		''')
	}
	
	@Test def testDiff_4() {
		assertDiff('foo', 'barfoo', '''
			[]foo
			vs
			[bar]foo
		''')
	}
	
	@Test def testDiff_5() {
		assertDiff('2foo', 'barfoo', '''
			[2]foo
			vs
			[bar]foo
		''')
	}
	
	@Test def testDiff_6() {
		assertDiff('0123456789foo1', '0123456789foobar', '''
			...3456789foo[1]
			vs
			...3456789foo[bar]
		''')
	}
	
	@Test def testDiff_7() {
		assertDiff('0123456789foo', '0123456789foofoo', '''
			...3456789foo[]
			vs
			...3456789foo[foo]
		''')
	}
	
	@Test def testDiff_8() {
		assertDiff('foo0123456789', 'barfoo0123456789', '''
			[]foo0123456...
			vs
			[bar]foo0123456...
		''')
	}
	
	@Test def testDiff_9() {
		assertDiff('2foo0123456789', 'barfoo0123456789', '''
			[2]foo0123456...
			vs
			[bar]foo0123456...
		''')
	}
	
	
	protected def assertDiff(String one, String two, CharSequence expected) {
		val expectedM = expected?.toString()?.trim?.replaceAll(System.lineSeparator, "\n")
		val actualM = DiffUtil.diff(one, two)?.replaceAll(System.lineSeparator, "\n")
		assertEquals(expectedM, actualM)
	}
		
}
