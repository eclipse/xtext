/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import org.junit.Ignore;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.xpect.XjmMethod;
import org.xpect.state.Creates;
import org.xpect.state.StateContainer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTestRunner extends Runner {
	private Description description;
	private final XpectFileRunner uriRunner;

	public AbstractTestRunner(XpectFileRunner uriRunner) {
		super();
		this.uriRunner = uriRunner;
	}

	public abstract StateContainer getState();

	public abstract Description createDescription();

	public Description getDescription() {
		if (this.description == null)
			this.description = createDescription();
		return description;
	}

	@Creates
	public abstract XjmMethod getMethod();

	public XpectFileRunner getFileRunner() {
		return uriRunner;
	}

	protected boolean isIgnore() {
		Ignore annotation = getMethod().getJavaMethod().getAnnotation(Ignore.class);
		return annotation != null;
	}

	public void run(RunNotifier notifier) {
		try {
			notifier.fireTestStarted(getDescription());
			if (isIgnore())
				notifier.fireTestIgnored(getDescription());
			else {
				runInternal();
			}
		} catch (Throwable t) {
			notifier.fireTestFailure(new Failure(getDescription(), t));
		} finally {
			try {
				getState().invalidate();
			} catch (Throwable t) {
				notifier.fireTestFailure(new Failure(getDescription(), t));
			} finally {
				notifier.fireTestFinished(getDescription());
			}
		}
	}

	protected abstract void runInternal() throws Throwable;

	@Override
	public String toString() {
		return getDescription().getDisplayName();
	}

}
