/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.internal;

import static com.google.common.collect.Maps.*;

import java.util.Map;
import java.util.Set;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class StopWatches {
	
	public static class StopWatchForTask {
		final static long notRunning = -1;
		
		long milliseconds = 0;
		long lastStart = notRunning;
		int numberOfStopEvents = 0;
		
		public void start() {
			if (!isRunning())
				lastStart = System.currentTimeMillis();
		}
		
		public boolean isRunning() {
			return lastStart != notRunning;
		}
		
		public long stop() {
			if (isRunning()) {
				long currentTimeMillis = System.currentTimeMillis();
				milliseconds += currentTimeMillis - lastStart;
				lastStart = notRunning;
				numberOfStopEvents++;
			}
			return milliseconds;
		}
		
		public long getMilliSeconds() {
			return milliseconds;
		}
		
		public int getNumberOfStopEvents() {
			return numberOfStopEvents;
		}
	}

	private static Map<String, StopWatchForTask> data = newLinkedHashMap();
	
	public static void resetAll() {
		synchronized (data) {
			data.clear();
		}
	}
	
	public static StopWatchForTask forTask(String task) {
		synchronized (data) {
			StopWatchForTask stopWatch = data.get(task);
			if (stopWatch == null) {
				stopWatch = new StopWatchForTask();
				data.put(task, stopWatch);
			}
			return stopWatch;
		}
	}
	
	public static Set<String> allTasks() {
		synchronized (data) {
			return data.keySet();
		}
	}
	
}
