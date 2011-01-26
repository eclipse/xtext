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
}
