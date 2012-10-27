package org.eclipse.xpect.ui.services;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xpect.registry.DefaultBinding;
import org.eclipse.xpect.ui.util.XpectFileAccess;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class XtResourceValidator implements IResourceValidator {

	@Inject
	@DefaultBinding
	private IResourceValidator delegate;

	public IResourceValidator getDelegate() {
		return delegate;
	}

	public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator) {
		List<Issue> issues = Lists.newArrayList();
		List<Issue> delegateIssues = validateDelegate(resource, mode, indicator);
		if (delegateIssues != null)
			issues.addAll(delegateIssues);
		List<Issue> xpectIssues = validateXpect(resource, mode, indicator);
		if (xpectIssues != null)
			issues.addAll(xpectIssues);
		return issues;
	}

	protected List<Issue> validateDelegate(Resource resource, CheckMode mode, CancelIndicator indicator) {
		return delegate.validate(resource, mode, indicator);
	}

	protected List<Issue> validateXpect(Resource resource, CheckMode mode, CancelIndicator indicator) {
		XtextResource xpectResource = XpectFileAccess.getXpectResource(resource);
		IResourceValidator validator = xpectResource.getResourceServiceProvider().getResourceValidator();
		return validator.validate(xpectResource, mode, indicator);
	}
}