/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import org.eclipse.xtext.testing.Flaky;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Sebastian Zarnekow
 */
public class IllegalFlakyConfigTest {

	@Rule 
	public Flaky.Rule rule = new Flaky.Rule();
	
	@Rule
	public TestRule verifier = new TestRule() {

		@Override
		public Statement apply(final Statement base, Description description) {
			return new Statement() {
				
				@Override
				public void evaluate() throws Throwable {
					try {
						base.evaluate();
						Assert.fail("Expected exception");
					} catch(IllegalArgumentException expected) {
						// ok
					}
				}
			};
		}
		
	};
	
	@Test
	@Flaky(trials = 1)
	public void testIllegalNumberOfTrials_01() {}
	
	@Test
	@Flaky(trials = 101)
	public void testIllegalNumberOfTrials_02() {}
	
}
