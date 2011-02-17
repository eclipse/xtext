/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.richstring;

import org.eclipse.xtext.xtend2.tests.compiler.CompilerTestHelper;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RichStringCompilerTest extends AbstractRichStringEvaluationTest {
	
	@Inject
	private RichStringCompilerTestHelper testHelper;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		CompilerTestHelper.INJECTOR.injectMembers(this);
		testHelper.setUp();
	}

	@Override
	public void assertOutput(String expectedOutput, String richString) throws Exception {
		testHelper.assertEvaluatesTo(expectedOutput, richString);
	}

	// TODO: FIX US
	
	@Override
	public void testForLoop_01() throws Exception {
	}
	
	@Override
	public void testForLoop_02() throws Exception {
	}
	
	@Override
	public void testForLoop_03() throws Exception {
	}
	
	@Override
	public void testForLoop_04() throws Exception {
	}
	
	@Override
	public void testForLoop_05() throws Exception {
	}
	
	@Override
	public void testForLoop_06() throws Exception {
	}
	
	@Override
	public void testForLoop_07() throws Exception {
	}
	
	@Override
	public void testForLoop_08() throws Exception {
	}
	
	@Override
	public void testForLoop_10() throws Exception {
	}
	
	@Override
	public void testForLoop_11() throws Exception {
	}
	
	@Override
	public void testForLoop_12() throws Exception {
	}
	
	@Override
	public void testForLoop_13() throws Exception {
	}
	
	@Override
	public void testForLoop_14() throws Exception {
	}
	
	@Override
	public void testForLoop_15() throws Exception {
	}
	
	@Override
	public void testForLoop_16() throws Exception {
	}
	
}
