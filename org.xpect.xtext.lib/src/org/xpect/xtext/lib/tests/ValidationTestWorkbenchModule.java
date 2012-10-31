/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.addAll;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.registry.AbstractDelegatingModule;
import org.xpect.registry.DefaultBinding;
import org.xpect.ui.services.XtResourceValidator;
import org.xpect.ui.util.XpectFileAccess;
import org.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;
import org.xpect.xtext.lib.util.IssueOverlapsRangePredicate;

import com.google.common.collect.Sets;
import com.google.inject.Binder;
import com.google.inject.Key;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ValidationTestWorkbenchModule extends AbstractDelegatingModule {

	public static class TestingResourceValidator extends XtResourceValidator {

		protected Severity getExpectedSeverity(XpectInvocation inv) {
			if (inv == null || inv.eIsProxy() || inv.getElement() == null || inv.getElement().eIsProxy())
				return null;
			String methodName = inv.getElement().getSimpleName();
			if (methodName.startsWith("error"))
				return Severity.ERROR;
			if (methodName.startsWith("warning"))
				return Severity.WARNING;
			if (methodName.startsWith("info"))
				return Severity.INFO;
			return null;
		}

		@Override
		public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator) {
			if (resource instanceof XtextResource && ((XtextResource) resource).getParseResult() != null) {
				XtextResource xresource = (XtextResource) resource;
				Set<Issue> issues = Sets.newLinkedHashSet(validateDelegate(resource, mode, indicator));
				if (issues.isEmpty())
					return Collections.emptyList();
				XpectFile xpectFile = XpectFileAccess.getXpectFile(resource);
				Set<Issue> matched = Sets.newHashSet();
				for (XpectInvocation inv : xpectFile.getInvocations())
					if (!inv.isIgnore()) {
						int offset = new ThisOffsetProvider(inv, xresource).getOffset();
						addAll(matched, filter(issues, new IssueOverlapsRangePredicate(xresource, offset, getExpectedSeverity(inv))));
					}
				issues.removeAll(matched);
				issues.addAll(validateXpect(xresource, mode, indicator));
				return newArrayList(issues);
			}
			return super.validate(resource, mode, indicator);
		}
	}

	@Override
	public void configure(Binder binder) {
		binder.bind(IResourceValidator.class).to(ValidationTestWorkbenchModule.TestingResourceValidator.class);
		binder.bind(IResourceValidator.class).annotatedWith(DefaultBinding.class).to(getOriginalType(Key.get(IResourceValidator.class)));
	}
}