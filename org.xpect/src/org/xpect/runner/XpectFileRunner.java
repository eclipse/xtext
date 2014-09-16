/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.runner;

import static org.xpect.runner.DescriptionFactory.createFileDescription;
import static org.xpect.runner.DescriptionFactory.createFileDescriptionForError;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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
import org.xpect.XpectPackage;
import org.xpect.XpectTest;
import org.xpect.registry.ITestSuiteInfo;
import org.xpect.services.XpectGrammarAccess;
import org.xpect.setup.ISetupInitializer;
import org.xpect.setup.SetupInitializer;
import org.xpect.setup.XpectSetup;
import org.xpect.state.Configuration;
import org.xpect.state.Creates;
import org.xpect.state.ResolvedConfiguration;
import org.xpect.state.StateContainer;
import org.xpect.text.CharSequences;
import org.xpect.text.IReplacement;
import org.xpect.text.Replacement;
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
	private final StateContainer state;
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
		this.state = createState(createConfiguration());
	}

	protected List<AbstractTestRunner> createChildren() {
		List<AbstractTestRunner> children = Lists.newArrayList();
		if (xpectFile != null) {
			XpectJavaModel xjm = xpectFile.getJavaModel();
			for (XjmMethod method : xjm.getMethods().values())
				if (method instanceof XjmTestMethod)
					children.add(createTestRunner(method));
			for (XpectInvocation inv : xpectFile.getInvocations())
				children.add(createTestRunner(inv));
		}
		return children;
	}

	protected Configuration createConfiguration() {
		Configuration config = new Configuration();
		config.addDefaultValue(XpectFile.class, this.xpectFile);
		config.addDefaultValue(ISetupInitializer.class, createSetupInitializer());
		return config;
	}

	protected Description createDescription() {
		if (error == null) {
			Description result = createFileDescription(runner.getTestClass().getJavaClass(), runner.getUriProvider(), getUri());
			for (AbstractTestRunner child : getChildren())
				result.addChild(child.getDescription());
			return result;
		} else {
			return createFileDescriptionForError(runner.getTestClass().getJavaClass(), runner.getUriProvider(), getUri());
		}
	}

	protected ISetupInitializer<Object> createSetupInitializer() {
		if (xpectFile != null) {
			XpectTest test = xpectFile.getTest();
			if (test != null && !test.eIsProxy())
				return new SetupInitializer<Object>(xpectFile.getTest());
		}
		return new ISetupInitializer.Null<Object>();
	}

	protected StateContainer createState(Configuration config) {
		StateContainer parent = this.getRunner().getState();
		return new StateContainer(parent, new ResolvedConfiguration(parent.getConfiguration(), config));
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

	protected IReplacement getClassOrSuiteFix(XpectTest test, Set<String> allTests) {
		String defaultTest = getRunner().getXpectJavaModel().getTestOrSuite().getJavaClass().getName();
		for (INode node : NodeModelUtils.findNodesForFeature(test, XpectPackage.Literals.XPECT_TEST__DECLARED_SUITE)) {
			StringBuilder result = new StringBuilder();
			for (ILeafNode leaf : node.getLeafNodes())
				if (!leaf.isHidden()) {
					String t = leaf.getText();
					result.append(t.startsWith("^") ? t.substring(1) : t);
				}
			if (result.length() > 0) {
				String fix = CharSequences.getMostSimilarCandiate(allTests, defaultTest, result.toString());
				return new Replacement(node.getOffset(), node.getLength(), fix);
			}
		}
		XpectGrammarAccess grammarAccess = getRunner().getXpectInjector().getInstance(XpectGrammarAccess.class);
		ICompositeNode testNode = NodeModelUtils.getNode(test);
		for (ILeafNode node : testNode.getLeafNodes())
			if (node.getGrammarElement() == grammarAccess.getLexicalspace_SetupAccess().getXPECT_SETUPKeyword_1())
				return new Replacement(node.getOffset() + node.getLength(), 0, " " + defaultTest);
		return new Replacement(testNode.getOffset(), 0, " " + defaultTest + " ");
	}

	public Description getDescription() {
		if (description == null)
			description = createDescription();
		return description;
	}

	public Throwable getError() {
		return error;
	}

	public XpectRunner getRunner() {
		return runner;
	}

	public StateContainer getState() {
		return state;
	}

	public URI getUri() {
		return uri;
	}

	public XpectFile getXpectFile() {
		return xpectFile;
	}

	protected XpectFile loadXpectFile(XtextResource res) throws IOException {
		XpectFile file = !res.getContents().isEmpty() ? (XpectFile) res.getContents().get(0) : null;
		if (file == null)
			throw new IllegalStateException("Resource for " + res.getURI() + " is empty.");
		validate(file);
		validate(res);
		return file;
	}

	protected XtextResource loadXpectResource(URI uri) throws IOException {
		XtextResource resource = (XtextResource) runner.getXpectInjector().getInstance(XtextResourceFactory.class).createResource(uri);
		runner.getXpectJavaModel().eResource().getResourceSet().getResources().add(resource);
		resource.load(null);
		return resource;
	}

	public void run(RunNotifier notifier) {
		try {
			if (error != null) {
				notifier.fireTestFailure(new Failure(getDescription(), error));
			} else {
				state.get(ValidatingSetup.class).get().validate();
				if (getChildren().isEmpty()) {
					notifier.fireTestStarted(getDescription());
					notifier.fireTestFinished(getDescription());
				} else
					for (AbstractTestRunner child : getChildren())
						try {
							child.run(notifier);
						} catch (Throwable t) {
							notifier.fireTestFailure(new Failure(getDescription(), t));
						}
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
		Collections.sort(getChildren(), new Comparator<AbstractTestRunner>() {
			public int compare(AbstractTestRunner o1, AbstractTestRunner o2) {
				return sorter.compare(o1.getDescription(), o2.getDescription());
			}
		});
	}

	protected void validate(XpectFile file) {
		XpectJavaModel model = file.getJavaModel();
		if (model == null || model.eIsProxy()) {
			String fileName = file.eResource().getURI().lastSegment();
			String registry = ITestSuiteInfo.Registry.INSTANCE.toString();
			throw new IllegalStateException("Could not find test suite for " + fileName + ". Registry:\n" + registry);
		}
	}

	protected void validate(XtextResource res) {
		IResourceValidator validator = res.getResourceServiceProvider().get(IResourceValidator.class);
		List<Issue> issues = validator.validate(res, CheckMode.ALL, CancelIndicator.NullImpl);
		if (!issues.isEmpty()) {
			String document = res.getParseResult().getRootNode().getText();
			String errors = new IssueVisualizer().visualize(document, issues);
			throw new ComparisonFailure("Errors in " + res.getURI(), document.trim(), errors.trim());
		}
	}

}
