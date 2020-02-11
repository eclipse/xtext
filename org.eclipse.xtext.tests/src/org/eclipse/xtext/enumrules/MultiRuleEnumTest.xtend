/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.enumrules

import org.eclipse.xtext.enumrules.multiRuleenums.MyEnum
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class MultiRuleEnumTest {
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=413395
	 */
	@Test def void testEnumOrder() {
		assertEquals(0, MyEnum.A_VALUE)	
		assertEquals(1, MyEnum.B_VALUE)	
		assertEquals(2, MyEnum.C_VALUE)	
		assertEquals(3, MyEnum.D_VALUE)	
		assertEquals(4, MyEnum.E_VALUE)	
	}
}