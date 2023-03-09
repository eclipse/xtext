/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.quickfix;

import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

public class Bug390595Test extends AbstractXbaseQuickfixTest {
	@Inject
	private IResourceValidator resourceValidator;

	@Inject
	private DefaultQuickfixProvider quickfixProvider;

	@Inject
	private TestIssueModificationContext modificationContext;

	@Inject
	private XtextDocument document;

	@Test
	public void testNoExceptionDuringResolutionCreation() {
		String code =
			// @formatter:off
			"{\n" +
			"val n = newHashSet ( )\n" +
			"val m = newHashSet ( )\n" +
			"if ( n < m ) { }\n" +
			"}";
			// @formatter:on
		XtextResource resource = getResourceFor(new StringInputStream(code));
		modificationContext.setDocument(getDocument(resource, code));
		Issue issue = Iterables.getFirst(resourceValidator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl), null);
		Iterables.getFirst(quickfixProvider.getResolutionsForLinkingIssue(issue), null);
	}

	public XtextDocument getDocument(XtextResource xtextResource, String code) {
		document.setInput(xtextResource);
		document.set(code);
		((XtextResourceSet) xtextResource.getResourceSet()).markSynced();
		return document;
	}
}
