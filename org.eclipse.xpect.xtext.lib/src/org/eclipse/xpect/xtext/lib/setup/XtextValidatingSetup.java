/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.xtext.lib.setup;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xpect.XpectReplace;
import org.eclipse.xpect.runner.ValidatingSetup;
import org.eclipse.xpect.setup.XpectSetupFactory;
import org.eclipse.xpect.state.Creates;
import org.eclipse.xpect.util.IssueVisualizer;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.ComparisonFailure;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@XpectSetupFactory
@XpectReplace(ValidatingSetup.class)
public class XtextValidatingSetup extends ValidatingSetup {

	protected static class ListAcceptor<T> implements IAcceptor<T> {
		private List<T> list;

		public ListAcceptor(List<T> list) {
			super();
			this.list = list;
		}

		public void accept(T t) {
			list.add(t);
		}
	}

	private List<Issue> issues = null;
	private final XtextResource resource;

	public XtextValidatingSetup(@ThisResource XtextResource resource) {
		this.resource = resource;
	}

	protected List<Issue> collectIssues() {
		if (isResolveAllReferences())
			EcoreUtil.resolveAll(resource);
		if (isValidate()) {
			return collectIssuesFromValidator();
		} else {
			return collectIssuesFromResource();
		}
	}

	private List<Issue> collectIssuesFromResource() {
		List<Issue> result = Lists.newArrayList();
		IDiagnosticConverter converer = resource.getResourceServiceProvider().get(IDiagnosticConverter.class);
		for (Diagnostic diagnostic : resource.getErrors())
			converer.convertResourceDiagnostic(diagnostic, Severity.ERROR, new ListAcceptor<Issue>(result));
		for (Diagnostic diagnostic : resource.getErrors())
			converer.convertResourceDiagnostic(diagnostic, Severity.WARNING, new ListAcceptor<Issue>(result));
		return result;
	}

	private List<Issue> collectIssuesFromValidator() {
		IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
		return validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
	}

	@Creates
	public ValidatingSetup create() {
		return this;
	}

	public List<Issue> getIssues() {
		if (issues == null) {
			List<Issue> issues = Lists.newArrayList();
			for (Issue issue : collectIssues())
				if (includeIssue(issue))
					issues.add(issue);
			this.issues = ImmutableList.copyOf(issues);
		}
		return issues;
	}

	protected XtextResource getResource() {
		return resource;
	}

	protected boolean includeIssue(Issue issue) {
		return true;
	}

	public boolean isResolveAllReferences() {
		return true;
	}

	public boolean isValidate() {
		return true;
	}

	public void validate() {
		List<Issue> issues = getIssues();
		if (issues.isEmpty())
			return;
		String document = ((XtextResource) resource).getParseResult().getRootNode().getText();
		String visualized = new IssueVisualizer().visualize(document, issues);
		throw new ComparisonFailure(Joiner.on("\n").join(issues), document, visualized);
	}
}
