/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typing;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.xbase.tests.typesystem.XbaseNewTypeSystemInjectorProvider;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseNewTypeSystemInjectorProvider.class)
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
