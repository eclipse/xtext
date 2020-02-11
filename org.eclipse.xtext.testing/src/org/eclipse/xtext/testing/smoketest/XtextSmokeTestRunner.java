/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest;

import org.eclipse.xtext.testing.smoketest.internal.RunnerBuilder;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;

import com.google.common.annotations.Beta;

/**
 * Use this runner on a class that is annotated with {@link org.junit.runners.Suite.SuiteClasses SuitClasses}
 * to test the input documents that are used in that test class for exceptions
 * by using a {@link ScenarioProcessor}. The suite has to be annotated with {@link ProcessedBy}
 * to find the processor instance and the parameters.
 * 
 * Clients use inheritance to turn a conventional test suite into a smoke test suite, e.g
 * the smoke test suite can simple extend the other suite and use the {@link org.junit.runner.RunWith}
 * annotation with the {@link XtextSmokeTestRunner}.
 * 
 * If the original test suite contains test classes or test methods that should be skipped
 * by the smoke test, annotate those with {@link IgnoredBySmokeTest}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class XtextSmokeTestRunner extends Suite {

	public XtextSmokeTestRunner(Class<?> klass) throws InitializationError {
		super(klass, new RunnerBuilder(klass));
	}

}
