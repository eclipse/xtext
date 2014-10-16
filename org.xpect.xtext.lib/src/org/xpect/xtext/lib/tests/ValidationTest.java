/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.tests;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.junit.runner.RunWith;
import org.xpect.XpectImport;
import org.xpect.expectation.ILinesExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.text.IRegion;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.IssuesByLine;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.IssuesByLineProvider;
import org.xpect.xtext.lib.util.IssueFormatter;
import org.xpect.xtext.lib.util.NextLine;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XpectRunner.class)
@XpectImport({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class, ValidationTestModuleSetup.class, IssuesByLineProvider.class })
public class ValidationTest {

	protected Function<? super Issue, String> createIssueFormatter(CharSequence document, Severity severity) {
		return new IssueFormatter(document, false);
	}

	@Xpect
	public void errors(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line) {
		List<String> issues = format(line.getDocument(), line2issue.get(line), Severity.ERROR);
		expectation.assertEquals(issues);
	}

	protected List<String> format(CharSequence document, Collection<Issue> issues, Severity severity) {
		Function<? super Issue, String> formatter = createIssueFormatter(document, severity);
		List<String> formattedIssues = newArrayList();
		for (Issue issue : issues)
			formattedIssues.add(formatter.apply(issue));
		return formattedIssues;
	}

	@Xpect
	public void infos(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line) {
		List<String> issues = format(line.getDocument(), line2issue.get(line), Severity.INFO);
		expectation.assertEquals(issues);
	}

	@Xpect
	public void issues(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line) {
		List<String> issues = format(line.getDocument(), line2issue.get(line), null);
		expectation.assertEquals(issues);
	}

	@Xpect
	public void warnings(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line) {
		List<String> issues = format(line.getDocument(), line2issue.get(line), Severity.WARNING);
		expectation.assertEquals(issues);
	}
}
