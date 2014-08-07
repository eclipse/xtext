/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;

import com.google.common.annotations.Beta;

/**
 * A runner that will execute the test methods of a class in parallel.
 * 
 * The number of threads that are used defaults to '4' but can be configured
 * by the envionment variable 'org.eclipse.xtext.junit4.parallel.threads'.
 * 
 * Clients who use this runner have to be sure that their test methods don't
 * affect any global state and do not depend on each other or shared state.
 * 
 * This is an experimental feature.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.7
 * @noreference This class is not intended to be referenced by clients.
 */
@Beta
public class ParallelXtextRunner extends XtextRunner {

	public ParallelXtextRunner(Class<?> c) throws InitializationError {
		super(c);
		setScheduler(new ThreadPoolScheduler());
	}
	
	@Override
	protected Statement classBlock(RunNotifier notifier) {
		IInjectorProvider injectorProvider = getOrCreateInjectorProvider();
		if (injectorProvider instanceof IRegistryConfigurator) {
			final IRegistryConfigurator registryConfigurator = (IRegistryConfigurator) injectorProvider;
			registryConfigurator.setupRegistry();
			final Statement classBlock = super.classBlock(notifier);
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					try {
						classBlock.evaluate();
					} finally {
						registryConfigurator.restoreRegistry();
					}
				}
			};
		} else {
			return super.classBlock(notifier);
		}
	}
	
	@Override
	protected Statement methodBlock(FrameworkMethod method) {
		return methodBlockWithoutRegistrySetup(method);
	}
	
	private static class ThreadPoolScheduler implements RunnerScheduler {
		private final List<Future<?>> futures;
        private ExecutorService executor = Executors.newFixedThreadPool(Integer.getInteger("org.eclipse.xtext.junit4.parallel.threads", 4));

        public ThreadPoolScheduler() {
            futures = Collections.synchronizedList(new ArrayList<Future<?>>());
        }

        public void finished() {
        	executor.shutdown();
            for(Future<?> future: futures) {
            	try {
					future.get();
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

        public void schedule(Runnable childStatement) {
            futures.add(executor.submit(childStatement));
        }
    }
	
}
