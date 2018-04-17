/*******************************************************************************
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testing.tests;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sebastian Benz - Initial contribution and API
 */
@InjectWith(XtextRunnerTest.MyInjectorProvider.class)
@RunWith(XtextRunner.class)
public class XtextRunnerTest extends AbstractJUnitIntegrationTest {
	/**
	 * Need to override, otherwise no tests are found in Gradle build
	 */
	@Test
	@Override
	public void shouldSaveRegistriesBeforeCreatingAnInjector() {
		super.shouldSaveRegistriesBeforeCreatingAnInjector();
	}
}
