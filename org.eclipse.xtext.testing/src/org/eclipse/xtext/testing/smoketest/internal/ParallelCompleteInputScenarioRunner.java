/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testing.smoketest.internal;

import org.eclipse.xtext.testing.smoketest.DeltaScenarioProcessor;
import org.eclipse.xtext.testing.smoketest.ScenarioProcessor;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;

import com.google.common.annotations.Beta;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class ParallelCompleteInputScenarioRunner extends AbstractParallelScenarioRunner {

	public ParallelCompleteInputScenarioRunner(Class<?> klass, Class<? extends ScenarioProcessor> processorClass)
			throws InitializationError {
		super(klass, processorClass);
	}

	@Override
	protected String getName() {
		return getTestClass().getJavaClass().getSimpleName() + " [" + getProcessorName() + "]";
	}
	
	@Override
	protected String testName(FrameworkMethod method) {
		return super.testName(method) + " [" + getProcessorName() + "]";
	}
	
	@Override
	protected void doProcess(String data, ScenarioProcessor processor) throws Exception {
		if (processor instanceof DeltaScenarioProcessor) {
			((DeltaScenarioProcessor) processor).processFile(data, data, 0, 0, "");
		} else {
			processor.processFile(data);
		}
	}
	
}
