/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.util;

import org.eclipse.xtext.xbase.util.XSwitchExpressionCompilationState;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class XSwitchExpressionCompilationStateTest {

	private XSwitchExpressionCompilationState state;

	@Before
	public void setup() {
		state = new XSwitchExpressionCompilationState();
	}

	@Test
	public void testStateWithSingleCase() {
		state.startProcessingCase();
		assertNeedsIfCheck(false);
		state.finishProcessingCase();
		assertNeedsIfCheck(true);
	}

	@Test
	public void testStateWithSeveralCases() {
		state.startProcessingCase();
		assertNeedsIfCheck(false);
		state.startProcessingCase();
		assertNeedsIfCheck(false);
		state.finishProcessingCase();
		assertNeedsIfCheck(true);
		state.finishProcessingCase();
		assertNeedsIfCheck(true);
	}

	private void assertNeedsIfCheck(boolean expected) {
		Assert.assertEquals(expected, state.caseNeedsIfCheck());
	}
}
