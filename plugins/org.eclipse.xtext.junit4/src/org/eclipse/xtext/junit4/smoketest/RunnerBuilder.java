/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.internal.builders.AnnotatedBuilder;
import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;

/**
 * Reads all the smoke test suite related annotations on a class and 
 * initializes the test suite.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 */
class RunnerBuilder extends org.junit.runners.model.RunnerBuilder {
	
	private final Delegate delegate;

	RunnerBuilder(Class<?> klass) throws InitializationError {
		Class<? extends ScenarioProcessor> processor = getProcessor(klass);
		String[] filters = getFilters(klass);
		boolean completeInput = isProcessingCompleteInput(klass);
		Scenario[] scenarios = getScenarios(klass, completeInput);
		this.delegate = new Delegate(processor, filters, scenarios, completeInput);
	}
	
	private static Class<? extends ScenarioProcessor> getProcessor(Class<?> klass) throws InitializationError {
		ProcessedBy annotation= klass.getAnnotation(ProcessedBy.class);
		if (annotation == null)
			throw new InitializationError(String.format("class '%s' must have a ProcessedBy annotation", klass.getName()));
		return annotation.value();
	}
	
	private boolean isProcessingCompleteInput(Class<?> klass) {
		ProcessedBy annotation= klass.getAnnotation(ProcessedBy.class);
		return annotation.processCompleteInput();
	}
	
	private static String[] getFilters(Class<?> klass) {
		IgnoredMethods annotation= klass.getAnnotation(IgnoredMethods.class);
		if (annotation == null)
			return new String[0];
		return annotation.value();
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

		private final Class<? extends ScenarioProcessor> processorClass;
		private final String[] filters;
		private final Scenario[] scenarios;
		private final boolean completeInput;
		
		public Delegate(Class<? extends ScenarioProcessor> processorClass, String[] filters, Scenario[] scenarios, boolean completeInput) {
			super(true);
			this.processorClass = processorClass;
			this.filters = filters;
			this.scenarios = scenarios;
			this.completeInput = completeInput;
		}
		
		@Override
		protected AnnotatedBuilder annotatedBuilder() {
			return new AnnotatedBuilder(this) {
				@Override
				public Runner buildRunner(Class<? extends Runner> runnerClass,
						Class<?> testClass) throws Exception {
					if (XtextRunner.class.equals(runnerClass)) {
						return new AllScenariosRunner(testClass, processorClass, filters, scenarios, completeInput);
					}
					return super.buildRunner(runnerClass, testClass);
				}
			};
		}
	}

}