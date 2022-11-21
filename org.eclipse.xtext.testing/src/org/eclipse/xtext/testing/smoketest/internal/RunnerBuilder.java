/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest.internal;

import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.smoketest.IgnoredBySmokeTest;
import org.eclipse.xtext.testing.smoketest.ProcessedBy;
import org.eclipse.xtext.testing.smoketest.Scenario;
import org.eclipse.xtext.testing.smoketest.Scenarios;
import org.junit.Ignore;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.builders.AnnotatedBuilder;
import org.junit.internal.builders.IgnoredBuilder;
import org.junit.internal.builders.IgnoredClassRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;

import com.google.common.annotations.Beta;

/**
 * Reads all the smoke test suite related annotations on a class and 
 * initializes the test suite.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class RunnerBuilder extends org.junit.runners.model.RunnerBuilder {
	
	private final Delegate delegate;

	public RunnerBuilder(Class<?> klass) throws InitializationError {
		ProcessedBy processor = getProcessor(klass);
		Scenario[] scenarios = getScenarios(klass, processor.processCompleteInput());
		this.delegate = new Delegate(processor, scenarios);
	}
	
	private static ProcessedBy getProcessor(Class<?> klass) throws InitializationError {
		ProcessedBy result= klass.getAnnotation(ProcessedBy.class);
		if (result == null)
			throw new InitializationError(String.format("class '%s' must have a ProcessedBy annotation", klass.getName()));
		return result;
	}
	
	private static Scenario[] getScenarios(Class<?> klass, boolean completeInput) throws InitializationError {
		Scenarios annotation= klass.getAnnotation(Scenarios.class);
		if (annotation == null) {
			return Scenario.values();
		} else if (completeInput) {
			throw new InitializationError("Must not use ProcessedBy.processCompleteInput together with the Scenarios annotation");
		}
		Scenario[] result = annotation.value();
		if (result.length == 0) {
			throw new InitializationError("Must at least specify one smoke test scenario or omit the Scenarios annotation");
		}
		return result;
	}

	@Override
	public Runner runnerForClass(Class<?> testClass) throws Throwable {
		return delegate.runnerForClass(testClass);
	}
	
	// internal delegate to avoid dependency to non-public junit types on the package API
	private static class Delegate extends AllDefaultPossibilitiesBuilder {

		private final ProcessedBy processor;
		private final Scenario[] scenarios;
		
		public Delegate(ProcessedBy processor, Scenario[] scenarios) {
			super();
			this.processor = processor;
			this.scenarios = scenarios;
		}
		
		@Override
		protected AnnotatedBuilder annotatedBuilder() {
			return new AnnotatedBuilder(this) {
				@Override
				public Runner buildRunner(Class<? extends Runner> runnerClass,
						Class<?> testClass) throws Exception {
					if (XtextRunner.class.equals(runnerClass)) {
						return new AllScenariosRunner(testClass, processor, scenarios);
					}
					return super.buildRunner(runnerClass, testClass);
				}
			};
		}
		
		@Override
		protected IgnoredBuilder ignoredBuilder() {
			return new IgnoredBuilder() {
				@Override
				public Runner runnerForClass(Class<?> testClass) {
					if (testClass.getAnnotation(Ignore.class) != null || testClass.getAnnotation(IgnoredBySmokeTest.class) != null)
						return new IgnoredClassRunner(testClass);
					return null;
				}
			};
		}
	}

}