/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.services;

import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xpect.registry.DefaultBinding;
import org.xpect.ui.util.XpectFileAccess;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
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

	public List<Issue> validateDelegate(Resource resource, CheckMode mode, CancelIndicator indicator) {
		return delegate.validate(resource, mode, indicator);
	}

	public List<Issue> validateXpect(Resource resource, CheckMode mode, CancelIndicator indicator) {
		XtextResource xpectResource = XpectFileAccess.getXpectResource(resource);
		IResourceValidator validator = xpectResource.getResourceServiceProvider().getResourceValidator();
		return validator.validate(xpectResource, mode, indicator);
	}
}