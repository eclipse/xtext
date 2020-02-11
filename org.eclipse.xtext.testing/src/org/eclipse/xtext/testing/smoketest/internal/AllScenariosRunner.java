/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest.internal;

import java.util.List;

import org.eclipse.xtext.testing.smoketest.ProcessedBy;
import org.eclipse.xtext.testing.smoketest.Scenario;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;

import com.google.common.annotations.Beta;
import com.google.common.collect.Lists;

/**
 * A test runner that will run the test methods of the given class
 * as smoke tests with all the configured scenarios.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class AllScenariosRunner extends ParentRunner<Runner> {

	private final List<Runner> runners;

	public AllScenariosRunner(Class<?> testClass, ProcessedBy processor, Scenario[] scenarios) throws InitializationError {
		super(testClass);
		this.runners = Lists.newArrayList();
		if (processor.processCompleteInput()) {
			if (processor.processInParallel()) {
				runners.add(new ParallelCompleteInputScenarioRunner(testClass, processor.value()));
			} else {
				runners.add(new CompleteInputScenarioRunner(testClass, processor.value()));
			}
		} else if (processor.processInParallel()) {
			for(Scenario scenario: scenarios) {
				runners.add(new ParallelPermutingScenarioRunner(testClass, scenario, processor.value()));
			}
		} else {
			for(Scenario scenario: scenarios) {
				runners.add(new PermutingScenarioRunner(testClass, processor.value(), scenario));
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