/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.setup;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.ComparisonFailure;
import org.xpect.util.IssueVisualizer;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssertingValidator {

	protected static class ListAcceptor<T> implements IAcceptor<T> {
		private List<T> list;

		public ListAcceptor(List<T> list) {
			super();
			this.list = list;
		}

		@Override
		public void accept(T t) {
			list.add(t);
		}
	}

	private Predicate<Issue> issueFilter = Predicates.alwaysTrue();

	private boolean resolveAllReferences = true;

	private boolean validate = true;

	public boolean isResolveAllReferences() {
		return resolveAllReferences;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setResolveAllReferences(boolean resolveAllReferences) {
		this.resolveAllReferences = resolveAllReferences;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public void validate(Resource resource) {
		List<Issue> allIssues = validate((XtextResource) resource);
		if (allIssues.isEmpty())
			return;
		List<Issue> filteredIssues = Lists.newArrayList(Iterables.filter(allIssues, issueFilter));
		if (filteredIssues.isEmpty())
			return;
		String document = ((XtextResource) resource).getParseResult().getRootNode().getText();
		String visualized = new IssueVisualizer().visualize(document, filteredIssues);
		throw new ComparisonFailure(Joiner.on("\n").join(filteredIssues), document, visualized);
	}

	protected List<Issue> validate(XtextResource resource) {
		if (resolveAllReferences)
			EcoreUtil.resolveAll(resource);
		if (validate) {
			IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
			return validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		} else {
			List<Issue> result = Lists.newArrayList();
			IDiagnosticConverter converer = resource.getResourceServiceProvider().get(IDiagnosticConverter.class);
			for (Diagnostic diagnostic : resource.getErrors())
				converer.convertResourceDiagnostic(diagnostic, Severity.ERROR, new ListAcceptor<Issue>(result));
			for (Diagnostic diagnostic : resource.getErrors())
				converer.convertResourceDiagnostic(diagnostic, Severity.WARNING, new ListAcceptor<Issue>(result));
			return result;
		}
	}

}
