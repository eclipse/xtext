/*******************************************************************************
 * Copyright (c) 2014, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest.internal;

import java.lang.annotation.Annotation;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.smoketest.IgnoredBySmokeTest;
import org.eclipse.xtext.junit4.smoketest.ScenarioProcessor;
import org.junit.Ignore;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public abstract class AbstractScenarioRunner extends XtextRunner {

	private WrappingInjectorProvider injectorProvider = null;
	private final Class<? extends ScenarioProcessor> processorClass;
	
	public AbstractScenarioRunner(Class<?> klass, Class<? extends ScenarioProcessor> processorClass) throws InitializationError {
		super(klass);
		this.processorClass = processorClass;
	}
	
	@Override
	protected Annotation[] getRunnerAnnotations() {
		return new Annotation[0];
	}
	
	protected String getProcessorName() {
		return processorClass.getSimpleName();
	}
	
	protected Class<? extends ScenarioProcessor> getProcessorClass() {
		return processorClass;
	}
	
	@Override
	protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
		Description description= describeChild(method);
		if (isIgnored(method)) {
			notifier.fireTestIgnored(description);
		} else {
			runLeaf(methodBlock(method), description, notifier);
		}
	}

	@Override
	protected boolean isIgnored(final FrameworkMethod method) {
		if (method.getAnnotation(Ignore.class) != null) {
			return true;
		}
		if (method.getAnnotation(IgnoredBySmokeTest.class) != null) {
			return true;
		}
		return false;
	}
	
	@Override
	protected Statement methodBlock(final FrameworkMethod method) {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
		final IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) injectorProvider;
		registryConfigurator.setupRegistry();
		final Statement methodBlock = superMethodBlock(method);
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					try {
						methodBlock.evaluate();
						throw new AssumptionViolatedException("Method " + method.getName() + " did parse any input");
					} finally {
						registryConfigurator.restoreRegistry();
					}
				} catch(TestDataCarrier testData) {
					process(testData.getData());
				}
			}
		};
	}
	
	protected void process(String data) throws Exception {
		IInjectorProvider delegate = getOrCreateInjectorProvider().getDelegate();
		if (delegate instanceof IRegistryConfigurator) {
			IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) delegate;
			registryConfigurator.setupRegistry();
			try {
				ScenarioProcessor processor = delegate.getInjector().getInstance(processorClass);
				String preProcessed = processor.preProcess(data);
				if (preProcessed == null) {
					throw new AssumptionViolatedException("Input is filtered by the pre processing step: " + data);
				}
				doProcess(preProcessed, processor);
			} finally {
				registryConfigurator.restoreRegistry();
			}
		}
	}
	
	protected abstract void doProcess(String data, ScenarioProcessor processor) throws Exception;

	protected <T> T get(Class<T> service) {
		return getOrCreateInjectorProvider().getDelegate().getInjector().getInstance(service);
	}
	
	@Override
	protected WrappingInjectorProvider getOrCreateInjectorProvider() {
		if (injectorProvider == null) {
			return injectorProvider = InjectorCache.wrap(super.getOrCreateInjectorProvider());
		}
		return injectorProvider;
	}

}