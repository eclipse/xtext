/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.ComparisonFailure;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.xpect.XjmMethod;
import org.xpect.XjmTestMethod;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.XpectJavaModel;
import org.xpect.setup.ISetupInitializer;
import org.xpect.setup.IXpectRunnerSetup;
import org.xpect.setup.SetupContext;
import org.xpect.setup.SetupInitializer;
import org.xpect.util.IssueVisualizer;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XpectFileRunner implements Filterable, Sortable {
	private List<AbstractTestRunner> children;
	private Description description;
	private Throwable error;
	private final XpectRunner runner;
	private final URI uri;
	private final XpectFile xpectFile;

	public XpectFileRunner(XpectRunner runner, URI uri) {
		this.runner = runner;
		this.uri = uri;
		XpectFile file = null;
		try {
			file = loadXpectFile(loadXpectResource(uri));
		} catch (Throwable t) {
			this.error = t;
		}
		this.xpectFile = file;
	}

	protected List<AbstractTestRunner> createChildren() {
		List<AbstractTestRunner> children = Lists.newArrayList();
		XpectJavaModel xjm = xpectFile.getTest().getTestClassOrSuite();
		for (XjmMethod method : xjm.getMethods().values())
			if (method instanceof XjmTestMethod)
				children.add(createTestRunner(method));
		for (XpectInvocation inv : xpectFile.getInvocations())
			children.add(createTestRunner(inv));
		return children;
	}

	protected Description createDescription() {
		String title = getFullName();
		if (error == null) {
			Description result = Description.createSuiteDescription(title);
			for (AbstractTestRunner child : getChildren())
				result.addChild(child.getDescription());
			return result;
		} else {
			return Description.createTestDescription(runner.getTestClass().getJavaClass(), title);
		}
	}

	protected ISetupInitializer<Object> createSetupInitializer() {
		return new SetupInitializer<Object>(xpectFile.getTest());
	}

	protected TestRunner createTestRunner(XjmMethod method) {
		return new TestRunner(this, (XjmTestMethod) method);
	}

	protected AbstractTestRunner createTestRunner(XpectInvocation invocation) {
		return new XpectTestRunner(this, invocation);
	}

	public void filter(Filter filter) throws NoTestsRemainException {
		List<AbstractTestRunner> filtered = Lists.newArrayList();
		for (AbstractTestRunner child : getChildren())
			if (filter.shouldRun(child.getDescription()))
				filtered.add(child);
		this.description = null;
		this.children = filtered;
	}

	protected List<AbstractTestRunner> getChildren() {
		if (children == null)
			children = createChildren();
		return children;
	}

	public Description getDescription() {
		if (description == null)
			description = createDescription();
		return description;
	}

	public Throwable getError() {
		return error;
	}

	protected String getFullName() {
		URI deresolved = runner.getUriProvider().deresolveToProject(getUri());
		return deresolved.lastSegment() + ": " + deresolved.trimSegments(1).toString();
	}

	public XpectRunner getRunner() {
		return runner;
	}

	public URI getUri() {
		return uri;
	}

	public XpectFile getXpectFile() {
		return xpectFile;
	}

	protected XpectFile loadXpectFile(XtextResource res) throws IOException {
		IResourceValidator validator = res.getResourceServiceProvider().get(IResourceValidator.class);
		List<Issue> issues = validator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!issues.isEmpty()) {
			String document = res.getParseResult().getRootNode().getText();
			String errors = new IssueVisualizer().visualize(document, issues);
			throw new ComparisonFailure("Errors in " + res.getURI(), document.trim(), errors.trim());
		}
		if (res.getContents().isEmpty())
			throw new IllegalStateException("Resource for " + res.getURI() + " is empty.");
		EObject obj = res.getContents().get(0);
		if (!(obj instanceof XpectFile))
			throw new IllegalStateException("Root type differs from expectation: " + obj.eClass().getName() + " instead of "
					+ XpectFile.class.getSimpleName());
		return (XpectFile) obj;
	}

	protected XtextResource loadXpectResource(URI uri) throws IOException {
		XtextResource resource = (XtextResource) runner.getXpectInjector().getInstance(XtextResourceFactory.class).createResource(uri);
		runner.getXpectJavaModel().eResource().getResourceSet().getResources().add(resource);
		resource.load(null);
		return resource;
	}

	public void run(RunNotifier notifier, IXpectRunnerSetup<Object, Object, Object, Object> setup, SetupContext ctx) {
		if (error != null) {
			notifier.fireTestFailure(new Failure(getDescription(), error));
		} else if (xpectFile.getTest() == null) {
			notifier.fireTestIgnored(getDescription());
		} else {
			ctx.setXpectFile(xpectFile);
			try {
				if (setup != null)
					ctx.setUserFileCtx(setup.beforeFile(ctx, ctx.getUserClassCtx(), createSetupInitializer()));
				if (getChildren().isEmpty()) {
					notifier.fireTestStarted(getDescription());
					notifier.fireTestFinished(getDescription());
				} else
					for (AbstractTestRunner child : getChildren())
						try {
							child.run(notifier, setup, ctx);
						} catch (Throwable t) {
							notifier.fireTestFailure(new Failure(getDescription(), t));
						}
			} catch (Throwable t) {
				notifier.fireTestFailure(new Failure(getDescription(), t));
			} finally {
				try {
					if (setup != null)
						setup.afterFile(ctx, ctx.getUserFileCtx());
				} catch (Throwable t) {
					notifier.fireTestFailure(new Failure(getDescription(), t));
				}
			}
		}
	}

	public void sort(final Sorter sorter) {
		this.description = null;
		Collections.sort(getChildren(), new Comparator<AbstractTestRunner>() {
			public int compare(AbstractTestRunner o1, AbstractTestRunner o2) {
				return sorter.compare(o1.getDescription(), o2.getDescription());
			}
		});
	}

}
