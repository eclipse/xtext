/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest.internal;

import org.eclipse.xtext.junit4.smoketest.Scenario;
import org.eclipse.xtext.junit4.smoketest.ScenarioProcessor;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public class ParallelPermutingScenarioRunner extends AbstractParallelScenarioRunner {

	private final Scenario scenario;
	
	public ParallelPermutingScenarioRunner(Class<?> klass, Scenario scenario, Class<? extends ScenarioProcessor> processorClass) throws InitializationError {
		super(klass, processorClass);
		this.scenario = scenario;
	}
	
	@Override
	protected String getName() {
		return getTestClass().getJavaClass().getSimpleName() + " [" + getProcessorName() + "]";
	}
	
	@Override
	protected String testName(FrameworkMethod method) {
		return super.testName(method) + " [" + scenario.toString() + "][" + getProcessorName() + "]";
	}
	
	@Override
	protected void doProcess(String data, ScenarioProcessor processor) throws Exception {
		scenario.processInput(data, processor);
	}
	
}
