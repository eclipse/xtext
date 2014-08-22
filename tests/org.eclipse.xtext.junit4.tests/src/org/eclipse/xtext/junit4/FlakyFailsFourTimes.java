/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Sebastian Zarnekow
 */
public class FlakyFailsFourTimes {
	@Rule 
	public Flaky.Rule rule = new Flaky.Rule();
	
	@Rule
	public TestRule verifier = new TestRule() {
	
		public Statement apply(final Statement base, Description description) {
			return new Statement() {
			
				@Override
				public void evaluate() throws Throwable {
					try {
						base.evaluate();
						Assert.fail("Expected exception");
					} catch(IllegalStateException e) {
						// expected
					}
				}
			};
		}
	};
	
	static int fails = 4;
	
	@Test
	@Flaky
	public void flakyTest() {
		fails--;
		if (fails > 0) {
			throw new IllegalStateException();
		}
	}
}