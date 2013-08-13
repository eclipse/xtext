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
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.xpect.XjmMethod;
import org.xpect.setup.IXpectRunnerSetup;
import org.xpect.setup.SetupContext;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTestRunner {

	private Description description;
	private final XpectFileRunner uriRunner;

	public AbstractTestRunner(XpectFileRunner uriRunner) {
		super();
		this.uriRunner = uriRunner;
	}

	public abstract Description createDescription();

	public Description getDescription() {
		if (this.description == null)
			this.description = createDescription();
		return description;
	}

	public abstract XjmMethod getMethod();

	protected abstract String getTitle();

	public XpectFileRunner getUriRunner() {
		return uriRunner;
	}

	protected boolean isIgnore() {
		Ignore annotation = getMethod().getJavaMethod().getAnnotation(Ignore.class);
		return annotation != null;
	}

	public void run(RunNotifier notifier, IXpectRunnerSetup<Object, Object, Object, Object> setup, SetupContext ctx) {
		notifier.fireTestStarted(getDescription());
		try {
			if (isIgnore())
				notifier.fireTestIgnored(getDescription());
			else {
				runInternal(setup, ctx);
			}
		} catch (Throwable t) {
			notifier.fireTestFailure(new Failure(getDescription(), t));
		} finally {
			notifier.fireTestFinished(getDescription());
		}
	}

	protected abstract void runInternal(IXpectRunnerSetup<Object, Object, Object, Object> setup, SetupContext ctx) throws Throwable;

}
