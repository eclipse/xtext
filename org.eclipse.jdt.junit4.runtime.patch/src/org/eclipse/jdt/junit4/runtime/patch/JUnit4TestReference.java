/*******************************************************************************
 * Copyright (c) 2006, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   David Saff (saff@mit.edu) - initial API and implementation
 *             (bug 102632: [JUnit] Support for JUnit 4.)
 *******************************************************************************/

package org.eclipse.jdt.junit4.runtime.patch;

import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

import org.eclipse.jdt.internal.junit.runner.IStopListener;
import org.eclipse.jdt.internal.junit.runner.ITestReference;
import org.eclipse.jdt.internal.junit.runner.TestExecution;

public abstract class JUnit4TestReference implements ITestReference {
	protected Runner fRunner;

	public JUnit4TestReference(Request request, String[] failureNames) {
		if (failureNames != null) {
			request = request.sortWith(new FailuresFirstSorter(failureNames));
		}
		fRunner = request.getRunner();
	}

	public void run(TestExecution execution) {
		final RunNotifier notifier = new RunNotifier();
		notifier.addListener(new JUnit4TestListener(execution.getListener()));
		execution.addStopListener(new IStopListener() {
			public void stop() {
				notifier.pleaseStop();
			}
		});

		Result result = new Result();
		RunListener listener = result.createListener();
		notifier.addListener(listener);
		try {
			notifier.fireTestRunStarted(fRunner.getDescription());
			fRunner.run(notifier);
			notifier.fireTestRunFinished(result);
		} catch (StoppedByUserException e) {
			// not interesting, see https://bugs.eclipse.org/329498
		} finally {
			notifier.removeListener(listener);
		}
	}
}
