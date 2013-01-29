/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.NumbersForTask;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StopwatchRule implements TestRule {

	private boolean watchAll = false;

	public StopwatchRule() {
	}

	/**
	 * @param watchAll <code>true</code> if all tests should be timed, <code>false</code>
	 * 		if only tests should be considered which are annotated with {@link Timed @Timed}
	 */
	public StopwatchRule(boolean watchAll) {
		this.watchAll = watchAll;
	}

	public void printStopwatchData(Description description, Map<String, Stopwatches.NumbersForTask> data) {
		String property = System.getProperty("stopwatch.file");
		PrintStream out = System.out;
		FileOutputStream outputStream = null;
		if (property != null) {
			try {
				outputStream = new FileOutputStream(new File(property), true);
				out = new PrintStream(outputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			out.println("-------------------------------------------------------------------------------------------------------------------------\n");
			out.println("Test '" + description.getDisplayName() + "' :");
			out.println(getStopwatchDataAsReadableString(data));
		} finally {
//			out.flush();
			if (outputStream != null)
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	public String getStopwatchDataAsReadableString(Map<String, NumbersForTask> data) {
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
		if (!watchAll && description.getAnnotation(Timed.class) == null)
			return base;
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				try {
					Stopwatches.setEnabled(true);
					Stopwatches.resetAll();
					base.evaluate();
				} finally {
					printStopwatchData(description, Stopwatches.allNumbers());
					Stopwatches.resetAll();
					Stopwatches.setEnabled(false);
				}
			}
		};
	}

}
