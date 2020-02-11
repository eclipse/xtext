/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import java.util.Iterator;
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
	
	public static Date DATE = new Date(); 

	public void printStopwatchData(Description description, Map<String, Stopwatches.NumbersForTask> data, long timeSpend) {
		String property = System.getProperty("stopwatch.file");
		String isJson = System.getProperty("stopwatch.json");
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
			if (isJson == null) {
				out.println("-------------------------------------------------------------------------------------------------------------------------\n");
				out.println("Test '" + description.getDisplayName() + "' :");
				out.println(getStopwatchDataAsReadableString(data));
			} else {
				out.println(",{");
				out.println("  \"name\" : \""+description.getDisplayName()+"\",");
				out.println("  \"date\" : \""+DATE+"\",");
				out.println("  \"time\" : \""+timeSpend+"\",");
				out.println("  \"tasks\" : [");
				Iterator<Entry<String, NumbersForTask>> iter = data.entrySet().iterator();
				while (iter.hasNext()) {
					Entry<String, NumbersForTask> task = iter.next(); 
					out.print("    {\"name\" : \""+task.getKey()+"\",\"time\" : "+task.getValue().getMilliseconds()+",\"measurements\" : "+task.getValue().getNumberOfMeasurements());
					if (iter.hasNext()) {
						out.println("},");
					} else {
						out.println("}");
					}
				}
				out.println("  ]");
				out.println("}");
			}
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

	@Override
	public Statement apply(final Statement base, final Description description) {
		if (!watchAll && description.getAnnotation(Timed.class) == null)
			return base;
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				long timeSpend = -1;
				try {
					Stopwatches.setEnabled(true);
					Stopwatches.resetAll();
					long before = System.currentTimeMillis();
					base.evaluate();
					timeSpend = System.currentTimeMillis()-before;
				} finally {
					printStopwatchData(description, Stopwatches.allNumbers(), timeSpend);
					Stopwatches.resetAll();
					Stopwatches.setEnabled(false);
				}
			}
		};
	}

}
