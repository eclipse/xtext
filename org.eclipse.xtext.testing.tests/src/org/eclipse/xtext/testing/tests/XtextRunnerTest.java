/*******************************************************************************
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.model.Statement;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
@InjectWith(XtextRunnerTest.MyInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XtextRunnerTest extends AbstractJUnitIntegrationTest {
	@Inject
	private Injector injector;
	
	@Inject
	@Rule
	public SomeRule someRule;
	
	static class SomeRule implements TestRule {
		@Inject Injector injector;
		boolean didApplyRule;

		@Override
		public Statement apply(Statement base, Description description) {
			return new Statement() {
				
				@Override
				public void evaluate() throws Throwable {
					assertNotNull(injector);
					didApplyRule = true;
					base.evaluate();
					didApplyRule = false;
				}
			};
		}
	}
	
	@Before
	public void setUp () {
		assertNotNull(injector);
	}
	
	/**
	 * Need to override to add proper {@code @Test}, otherwise no tests are found in Gradle build
	 */
	@Test
	@Override
	public void shouldSaveRegistriesBeforeCreatingAnInjector() {
		// tests are performed in MyInjectorProvider
	}

	@Test
	public void didUseTestRule() {
		assertNotNull(someRule);
		assertTrue(someRule.didApplyRule);
	}
}
