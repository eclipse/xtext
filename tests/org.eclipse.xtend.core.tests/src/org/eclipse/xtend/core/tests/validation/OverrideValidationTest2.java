/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(NewTypeSystemRuntimeInjectorProvider.class)
public class OverrideValidationTest2 extends OverrideValidationTest {
	// These are disabled in the super class
	@Override
	@Test public void testOverrideReturnType_1() throws Exception {
		super.testOverrideReturnType_1();
	}

	@Override
	@Test public void testOverrideReturnType_2() throws Exception {
		super.testOverrideReturnType_2();
	}
	
	@Override
	@Test
	public void testOverrideReturnType_4() throws Exception {
		super.testOverrideReturnType_4();
	}

	@Override
	@Ignore("TODO")
	@Test
	public void testIncompatibleThrowsClause() throws Exception {
		super.testIncompatibleThrowsClause();
	}
	
	@Override
	@Ignore("TODO")
	@Test
	public void testIncompatibleThrowsClause_01() throws Exception {
		super.testIncompatibleThrowsClause();
	}
	
	@Override
	@Ignore("TODO")
	@Test
	public void testIncompatibleThrowsClause_02() throws Exception {
		super.testIncompatibleThrowsClause();
	}
	
	@Override
	@Ignore("TODO")
	@Test
	public void testIncompatibleThrowsClause_03() throws Exception {
		super.testIncompatibleThrowsClause();
	}
}
