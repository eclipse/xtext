/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.xpect.XjmMethod;
import org.xpect.XpectInvocation;
import org.xpect.setup.IXpectRunnerSetup;
import org.xpect.setup.SetupContext;
import org.xpect.util.TestDataUtil;

import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractTestRunner {

	private Description description;
	private final XpectInvocation invocation;
	private final XpectFileRunner uriRunner;

	public AbstractTestRunner(XpectFileRunner uriRunner, XpectInvocation invocation) {
		super();
		this.uriRunner = uriRunner;
		this.invocation = invocation;
	}

	public Description createDescription() {
		XpectRunner runner = uriRunner.getRunner();
		Class<?> javaClass = runner.getTestClass().getJavaClass();
		return Description.createTestDescription(javaClass, getFullName());
	}

	public Description getDescription() {
		if (this.description == null)
			this.description = createDescription();
		return description;
	}

	protected String getFullName() {
		Map<String, String> result = Maps.newLinkedHashMap();
		result.put("title", uriRunner.getRunner().getUniqueName(getTitle()));
		if (invocation.getMethod() != null && !invocation.getMethod().eIsProxy())
			result.put("method", invocation.getMethod().getJvmMethod().getSimpleName());
		result.put("file", EcoreUtil.getURI(invocation).toString());
		return TestDataUtil.encode(result);
	}

	public XpectInvocation getInvocation() {
		return invocation;
	}

	public abstract XjmMethod getMethod();

	protected String getTitle() {
		return new XpectTestTitleProvider().getTitle(invocation);
	}

	public XpectFileRunner getUriRunner() {
		return uriRunner;
	}

	public void run(RunNotifier notifier, IXpectRunnerSetup<Object, Object, Object, Object> setup, SetupContext ctx) {
		notifier.fireTestStarted(getDescription());
		try {
			if (invocation.isIgnore())
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
