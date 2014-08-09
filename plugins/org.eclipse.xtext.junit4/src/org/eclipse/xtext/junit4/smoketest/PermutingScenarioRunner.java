/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PermutingScenarioRunner extends AbstractScenarioRunner {

	private final Scenario scenario;
	
	PermutingScenarioRunner(Class<?> klass, Scenario scenario, Class<? extends ScenarioProcessor> processorClass, String[] filters) throws InitializationError {
		super(klass, processorClass, filters);
		this.scenario = scenario;
	}
	
	@Override
	protected String getName() {
		return getTestClass().getJavaClass().getSimpleName() + " [" + scenario.toString() + "][" + getProcessorName() + "]";
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