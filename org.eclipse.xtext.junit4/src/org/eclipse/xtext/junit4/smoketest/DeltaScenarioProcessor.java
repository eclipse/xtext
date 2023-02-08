/*******************************************************************************
 * Copyright (c) 2015, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.junit4.smoketest;

import org.eclipse.xtext.util.ReplaceRegion;

/**
 * An extension to the ScenarioProcessor in case the test is interested
 * in more information about the scenario.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 * @deprecated Use org.eclipse.xtext.testing.smoketest.DeltaScenarioProcessor instead
 */
@Deprecated(forRemoval = true)
public abstract class DeltaScenarioProcessor extends ScenarioProcessor {

	@Override
	public void processFile(String data) throws Exception {
		throw new UnsupportedOperationException();
	}
	
	protected String applyDelta(String data, int offset, int len, String change) {
		StringBuilder builder = new StringBuilder(data);
		new ReplaceRegion(offset, len, change).applyTo(builder);
		String result = builder.toString();
		return result;
	}
	
	public String processFile(String completeData, String data, int offset, int len, char change) throws Exception {
		return processFile(completeData, data, offset, len, Character.toString(change));
	}
	
	/**
	 * @return the new data that is the result of the delta being applied to the previous data.
	 */
	public abstract String processFile(String completeData, String data, int offset, int len, String change) throws Exception;

	static class Adapter extends DeltaScenarioProcessor {

		private final ScenarioProcessor processor;

		Adapter(ScenarioProcessor processor) {
			this.processor = processor;
		}
		
		@Override
		public String processFile(String completeData, String data, int offset, int len, String change) throws Exception {
			String newData = applyDelta(data, offset, len, change);
			processor.processFile(newData);
			return newData;
		}
		
		@Override
		protected <T> T get(Class<T> service) {
			return processor.get(service);
		}
		
		@Override
		public String preProcess(String data) {
			return processor.preProcess(data);
		}

	}
	
}
