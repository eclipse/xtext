/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import static org.xpect.runner.DescriptionFactory.createFileDescription;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.xpect.XjmMethod;
import org.xpect.XjmTestMethod;
import org.xpect.XjmXpectMethod;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.XpectJavaModel;
import org.xpect.setup.ThisTestClass;
import org.xpect.state.Configuration;
import org.xpect.state.Creates;
import org.xpect.state.ResolvedConfiguration;
import org.xpect.state.StateContainer;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectFileRunner extends Runner implements Filterable, Sortable {
	private List<Runner> children;
	private Description description;
	private final XpectRunner runner;
	private final StateContainer state;
	private final XpectFile xpectFile;

	public XpectFileRunner(StateContainer state, XpectRunner runner, XpectFile file) {
		this.runner = runner;
		this.xpectFile = file;
		this.state = state;
	}

	@Creates
	public XpectFileRunner create() {
		return this;
	}

	protected List<Runner> createChildren() {
		List<Runner> children = Lists.newArrayList();
		if (xpectFile != null) {
			XpectJavaModel xjm = xpectFile.getJavaModel();
			for (XjmMethod method : xjm.getMethods().values())
				if (method instanceof XjmTestMethod) {
					Runner testRunner = createTestRunner((XjmTestMethod) method);
					if (testRunner != null)
						children.add(testRunner);
				}
			for (XpectInvocation inv : xpectFile.getInvocations()) {
				Runner testRunner = createTestRunner(inv);
				if (testRunner != null)
					children.add(testRunner);
			}
		}
		return children;
	}

	protected Configuration createConfiguration(XjmTestMethod method) {
		Configuration config = new Configuration(method.getName() + "()");
		config.addValue(ThisTestClass.class, Class.class, method.getTest().getJavaClass());
		config.addDefaultValue(XjmTestMethod.class, method);
		return config;
	}

	protected Configuration createConfiguration(XpectInvocation invocation) {
		Configuration config = new Configuration(invocation.getMethodName() + "(...)");
		config.addValue(ThisTestClass.class, Class.class, invocation.getMethod().getTest().getJavaClass());
		config.addDefaultValue(XpectInvocation.class, invocation);
		config.addDefaultValue(XjmXpectMethod.class, invocation.getMethod());
		return config;
	}

	protected Description createDescription() {
		Description result = createFileDescription(runner.getTestClass().getJavaClass(), runner.getUriProvider(), getUri());
		for (Runner child : getChildren())
			result.addChild(child.getDescription());
		return result;
	}

	protected StateContainer createState(Configuration config) {
		return new StateContainer(state, new ResolvedConfiguration(state.getConfiguration(), config));
	}

	protected Runner createTestRunner(XjmTestMethod method) {
		StateContainer childState = createState(createConfiguration(method));
		return childState.get(TestRunner.class).get();
	}

	protected Runner createTestRunner(XpectInvocation invocation) {
		StateContainer childState = createState(createConfiguration(invocation));
		return childState.get(XpectTestRunner.class).get();
	}

	public void filter(Filter filter) throws NoTestsRemainException {
		List<Runner> filtered = Lists.newArrayList();
		for (Runner child : getChildren())
			if (filter.shouldRun(child.getDescription()))
				filtered.add(child);
		this.description = null;
		this.children = filtered;
	}

	protected List<Runner> getChildren() {
		if (children == null)
			children = createChildren();
		return children;
	}

	public Description getDescription() {
		if (description == null)
			description = createDescription();
		return description;
	}

	public XpectRunner getRunner() {
		return runner;
	}

	public StateContainer getState() {
		return state;
	}

	public URI getUri() {
		return xpectFile.eResource().getURI();
	}

	public XpectFile getXpectFile() {
		return xpectFile;
	}

	public void run(RunNotifier notifier) {
		try {
			state.get(ValidatingSetup.class).get().validate();
			if (getChildren().isEmpty()) {
				notifier.fireTestStarted(getDescription());
				notifier.fireTestFinished(getDescription());
			} else
				for (Runner child : getChildren())
					try {
						child.run(notifier);
					} catch (Throwable t) {
						notifier.fireTestFailure(new Failure(getDescription(), t));
					}
		} catch (Throwable t) {
			notifier.fireTestFailure(new Failure(getDescription(), t));
		} finally {
			try {
				state.invalidate();
			} catch (Throwable t) {
				notifier.fireTestFailure(new Failure(getDescription(), t));
			}
		}
	}

	public void sort(final Sorter sorter) {
		this.description = null;
		Collections.sort(getChildren(), new Comparator<Runner>() {
			public int compare(Runner o1, Runner o2) {
				return sorter.compare(o1.getDescription(), o2.getDescription());
			}
		});
	}

}
