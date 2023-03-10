/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Abstract base class for a smoke test scenario processor.
 * Clients implement {@link #processFile(String)} and optionally
 * {@link #preProcess(String)}. The processor instance is created by
 * the guice injector that is returned by the {@link org.eclipse.xtext.junit4.IInjectorProvider}
 * of the test class.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 * @deprecated Use org.eclipse.xtext.testing.smoketest.ScenarioProcessor instead
 */
@Deprecated(forRemoval = true)
public abstract class ScenarioProcessor {

	@Inject
	private Injector injector;
	
	/**
	 * Obtain an instance of the given class from the injector.
	 * Primary use case is for {@link Scenario scenarios} to obtain
	 * a resource or a lexer.
	 */
	protected <T> T get(Class<T> service) {
		return injector.getInstance(service);
	}
	
	/**
	 * Optional pre processing of the input data to reduce the number of permutations.
	 * Return {@code null} if the data should be skipped. The test will be marked as ignored.
	 */
	public String preProcess(String data) {
		return data;
	}
	
	/**
	 * Implements the smoke test for the given input data.
	 */
	public abstract void processFile(String data) throws Exception;
	
}
