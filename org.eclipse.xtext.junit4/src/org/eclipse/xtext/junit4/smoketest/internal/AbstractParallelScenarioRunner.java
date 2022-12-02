/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.eclipse.xtext.junit4.IInjectorProvider;
import org.eclipse.xtext.junit4.IRegistryConfigurator;
import org.eclipse.xtext.junit4.smoketest.ScenarioProcessor;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true, since = "2.30")
public abstract class AbstractParallelScenarioRunner extends AbstractScenarioRunner {

	private final Map<FrameworkMethod, String> testData;
	private RunnerScheduler scheduler;
	private List<FrameworkMethod> children;

	public AbstractParallelScenarioRunner(Class<?> klass, Class<? extends ScenarioProcessor> processorClass)
			throws InitializationError {
		super(klass, processorClass);
		testData = new ConcurrentHashMap<FrameworkMethod, String>();
		setScheduler(new ParallelRunnerScheduler());
	}
	
	@Override
	public void setScheduler(RunnerScheduler scheduler) {
		super.setScheduler(scheduler);
		this.scheduler = scheduler;
	}

	@Override
	protected Statement childrenInvoker(final RunNotifier notifier) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				WrappingInjectorProvider wrapped = getOrCreateInjectorProvider();
				wrapped.setupRegistry();
				try {
					prepareChildren(notifier);
				} finally {
					wrapped.restoreRegistry();
				}
				IInjectorProvider delegate = wrapped.getDelegate();
				if (delegate instanceof IRegistryConfigurator) {
					IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) delegate;
					registryConfigurator.setupRegistry();
					try {
						runChildren(notifier);
					} finally {
						registryConfigurator.restoreRegistry();
					}
				} else {
					runChildren(notifier);
				}
			}
		};
	}
	
	@Override
	protected void runChild(final FrameworkMethod method, RunNotifier notifier) {
		Description description= describeChild(method);
		if (isIgnored(method)) {
			notifier.fireTestIgnored(description);
		} else if (testData.containsKey(method)) {
			runLeaf(methodBlock(method), description, notifier);
		}
	}
	
	@Override
	protected List<FrameworkMethod> getChildren() {
		if (children == null) {
			return children = Lists.newArrayList(super.getChildren());
		}
		return children;
	}
	
	private void prepareChildren(final RunNotifier notifier) throws Throwable {
		for (final FrameworkMethod each : getChildren())
 			prepareChild(each, notifier);
	}

	protected void prepareChild(FrameworkMethod method, RunNotifier notifier) throws Throwable {
		if (!super.isIgnored(method)) {
			prepareMethodBlock(method, notifier).evaluate();
		}
	}

	private void runChildren(final RunNotifier notifier) {
		for (final FrameworkMethod each : getChildren())
			scheduler.schedule(new Runnable() {			
				@Override
				public void run() {
					AbstractParallelScenarioRunner.this.runChild(each, notifier);
				}
			});
		scheduler.finished();
	}
	
	protected Statement prepareMethodBlock(final FrameworkMethod method, final RunNotifier notifier) {
		final Statement methodBlock = superMethodBlock(method);
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					methodBlock.evaluate();
					Description description = describeChild(method);
					try {
						notifier.fireTestStarted(description);
						notifier.fireTestAssumptionFailed(new Failure(description, new AssumptionViolatedException("Method " + method.getName() + " did parse any input")));
					} finally {
						notifier.fireTestFinished(description);
					}
				} catch(TestDataCarrier testData) {
					AbstractParallelScenarioRunner.this.testData.put(method, testData.getData());
				}
			}
		};
	}
	
	@Override
	protected Statement methodBlock(final FrameworkMethod method) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				String testData = AbstractParallelScenarioRunner.this.testData.remove(method);
				if (testData != null)
					process(testData);
			}
		};
	}
	
	@Override
	protected void process(String data) throws Exception {
		IInjectorProvider delegate = getOrCreateInjectorProvider().getDelegate();
		ScenarioProcessor processor = delegate.getInjector().getInstance(getProcessorClass());
		String preProcessed = processor.preProcess(data);
		if (preProcessed == null) {
			throw new AssumptionViolatedException("Input is filtered by the pre processing step: " + data);
		}
		doProcess(preProcessed, processor);
	}
	
	private static class ParallelRunnerScheduler implements RunnerScheduler {
		private final List<Future<?>> futures;
        private ExecutorService executor = Executors.newFixedThreadPool(Integer.getInteger("org.eclipse.xtext.junit4.parallel.threads", 4));

        public ParallelRunnerScheduler() {
            futures = Collections.synchronizedList(new ArrayList<Future<?>>());
        }

        @Override
		public void finished() {
        	executor.shutdown();
            for(Future<?> future: futures) {
            	try {
					future.get();
            	} catch(ExecutionException e) {
            		if (e.getCause() instanceof RuntimeException) {
            			throw (RuntimeException) e.getCause();
            		} else if (e.getCause() instanceof Error){
            			throw (Error) e.getCause();
            		} else {
            			throw new RuntimeException(e.getCause());
            		}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
            }
            try {
				executor.awaitTermination(1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
        }

        @Override
		public void schedule(Runnable childStatement) {
            futures.add(executor.submit(childStatement));
        }
    }

}
