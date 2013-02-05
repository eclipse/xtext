/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReturnTypeComputationTest2 extends ReturnTypeComputationTest {

	@Override
	@Test
	public void testReturnType_01() throws Exception {
		assertReturnType("java.lang.String", "'foo'");
	}
	
	@Override
	@Test
	public void testReturnType_03() throws Exception {
		// unresolved feature 'e' is intentional
		assertReturnType("()=>java.lang.Object", "[| return e]");
	}
	
	@Override
	@Test
	public void testReturnType_04() throws Exception {
		assertReturnType("()=>java.lang.String", "{ [| return '']}");
	}
}
