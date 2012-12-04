/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.internal;

import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.util.internal.StopWatches;
import org.eclipse.xtext.util.internal.StopWatches.NumbersForTask;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StopWatchRule implements TestRule {

	private boolean watchAll = false;

	public StopWatchRule() {
	}

	/**
	 * @param watchAll
	 *            - whether all tests should be watched (<code>true</code>) or just the ones annotated with @
	 *            {@link StopWatched} (<code>false</code>).
	 */
	public StopWatchRule(boolean watchAll) {
		this.watchAll = watchAll;
	}

	public void printStopWatchData(Description description, Map<String, StopWatches.NumbersForTask> data) {
		System.out
				.println("-------------------------------------------------------------------------------------------------------------------------\n");
		System.out.println("Test '" + description.getDisplayName() + "' :");
		System.out.println(getStopWatchDataAsReadableString(data));
	}

	public String getStopWatchDataAsReadableString(Map<String, NumbersForTask> data) {
		StringBuilder sb = new StringBuilder();
		sb.append("-------------------------------------------------------------------------------------------------------------------------\n");
		for (Entry<String, NumbersForTask> task : data.entrySet()) {
			sb.append("Task '" + task.getKey() + "' took " + task.getValue().getMilliseconds() + "ms ("
					+ task.getValue().getNumberOfMeasurements() + " measurements).\n");
		}
		sb.append("-------------------------------------------------------------------------------------------------------------------------\n");
		return sb.toString();
	}

	public Statement apply(final Statement base, final Description description) {
		if (!watchAll && description.getAnnotation(StopWatched.class) == null)
			return base;
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					StopWatches.setEnabled(true);
					StopWatches.resetAll();
					base.evaluate();
					printStopWatchData(description, StopWatches.allNumbers());
				} finally {
					StopWatches.resetAll();
					StopWatches.setEnabled(false);
				}
			}
		};
	}

}
