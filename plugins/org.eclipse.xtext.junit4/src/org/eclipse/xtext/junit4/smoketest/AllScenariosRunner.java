/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import com.google.common.collect.Lists;

/**
 * A test runner that will run the test methods of the given class
 * as smoke tests with all the configured scenarios.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AllScenariosRunner extends ParentRunner<Runner> {

	private final List<Runner> runners;

	AllScenariosRunner(Class<?> testClass, Class<? extends ScenarioProcessor> processorClass, String[] filters, Scenario[] scenarios, boolean completeInput) throws InitializationError {
		super(testClass);
		this.runners = Lists.newArrayList();
		if (completeInput) {
			runners.add(new CompleteInputScenarioRunner(testClass, processorClass, filters));
		} else {
			for(Scenario scenario: scenarios) {
				runners.add(new PermutingScenarioRunner(testClass, scenario, processorClass, filters));
			}
		}
	}
	
	@Override
	protected List<Runner> getChildren() {
		return runners;
	}

	@Override
	protected Description describeChild(Runner child) {
		return child.getDescription();
	}

	@Override
	protected void runChild(Runner child, RunNotifier notifier) {
		child.run(notifier);
	}
	
}