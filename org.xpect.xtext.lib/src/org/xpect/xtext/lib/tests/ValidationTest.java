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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.validation.Issue;
import org.junit.runner.RunWith;
import org.xpect.expectation.ILinesExpectation;
import org.xpect.expectation.LinesExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.setup.XpectSetup;
import org.xpect.xtext.lib.setup.ThisOffset;
import org.xpect.xtext.lib.setup.ThisResource;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.IssuesByLine;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.IssuesByOffsetSetup;
import org.xpect.xtext.lib.util.IssueFormatter;

import com.google.common.base.Function;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XpectRunner.class)
@XpectSetup({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class, ValidationTestModuleSetup.class, IssuesByOffsetSetup.class })
public class ValidationTest {

	protected Function<? super Issue, String> createIssueFormatter(XtextResource resource, Severity severity) {
		return new IssueFormatter(resource, false);
	}

	@Xpect
	public void errors(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource,
			@IssuesByLine Multimap<Integer, Issue> line2issue, @ThisOffset int offset) {
		List<String> issues = format(resource, line2issue.get(offset), Severity.ERROR);
		expectation.assertEquals(issues);
	}

	@Xpect
	public void infos(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource,
			@IssuesByLine Multimap<Integer, Issue> line2issue, @ThisOffset int offset) {
		List<String> issues = format(resource, line2issue.get(offset), Severity.INFO);
		expectation.assertEquals(issues);
	}

	@Xpect
	public void issues(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource,
			@IssuesByLine Multimap<Integer, Issue> line2issue, @ThisOffset int offset) {
		List<String> issues = format(resource, line2issue.get(offset), null);
		expectation.assertEquals(issues);
	}

	protected List<String> format(XtextResource resource, Collection<Issue> issues, Severity severity) {
		Function<? super Issue, String> formatter = createIssueFormatter(resource, severity);
		List<String> formattedIssues = newArrayList();
		for (Issue issue : issues)
			formattedIssues.add(formatter.apply(issue));
		return formattedIssues;
	}

	@Xpect
	public void warnings(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource,
			@IssuesByLine Multimap<Integer, Issue> line2issue, @ThisOffset int offset) {
		List<String> issues = format(resource, line2issue.get(offset), Severity.WARNING);
		expectation.assertEquals(issues);
	}
}
