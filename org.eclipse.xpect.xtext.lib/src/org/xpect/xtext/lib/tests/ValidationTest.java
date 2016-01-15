/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.Issue;
import org.junit.Assert;
import org.junit.ComparisonFailure;
import org.junit.runner.RunWith;
import org.xpect.XpectImport;
import org.xpect.expectation.ILinesExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.text.IRegion;
import org.xpect.util.IssueVisualizer;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.ConsumedIssues;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.IssuesByLine;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.IssuesByLineProvider;
import org.xpect.xtext.lib.util.IssueFormatter;
import org.xpect.xtext.lib.util.NextLine;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XpectRunner.class)
@XpectImport({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class, ValidationTestModuleSetup.class, IssuesByLineProvider.class, ValidationTestConfig.class })
public class ValidationTest {

	protected Function<? super Issue, String> createIssueFormatter(CharSequence document, Severity severity) {
		return new IssueFormatter(document, false);
	}

	@Xpect
	@ConsumedIssues(Severity.ERROR)
	public void errors(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line, ValidationTestConfig cfg) {
		List<String> issues = getActualIssues(line2issue, line, cfg, Severity.ERROR);
		expectation.assertEquals(issues);
	}

	protected List<String> getActualIssues(Multimap<IRegion, Issue> line2issue, IRegion line, ValidationTestConfig cfg, Severity severity) {
		Collection<Issue> issuesInLine = line2issue.get(line);
		List<Issue> filteredIssues = Lists.newArrayList(filter(issuesInLine, cfg.getIgnoreFilter()));
		List<String> formattedIssues = newArrayList(transform(filteredIssues, createIssueFormatter(line.getDocument(), severity)));
		if (formattedIssues.isEmpty())
			Assert.fail("No issues found in line " + line);
		return formattedIssues;
	}

	@Xpect
	@ConsumedIssues(Severity.INFO)
	public void infos(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line, ValidationTestConfig cfg) {
		List<String> issues = getActualIssues(line2issue, line, cfg, Severity.INFO);
		expectation.assertEquals(issues);
	}

	@Xpect
	@ConsumedIssues({ Severity.INFO, Severity.ERROR, Severity.WARNING })
	public void issues(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line, ValidationTestConfig cfg) {
		List<String> issues = getActualIssues(line2issue, line, cfg, null);
		expectation.assertEquals(issues);
	}

	@Xpect
	@ConsumedIssues({ Severity.INFO, Severity.ERROR, Severity.WARNING })
	public void noIssues(@IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line) {
		Collection<Issue> issues = line2issue.get(line);
		if (!issues.isEmpty()) {
			String document = line.getDocument().toString();
			String visualized = new IssueVisualizer().visualize(document, issues);
			throw new ComparisonFailure("no Issues expected, but found:", document, visualized);
		}
	}

	@Xpect
	@ConsumedIssues({ Severity.INFO, Severity.ERROR, Severity.WARNING })
	public void warnings(ILinesExpectation expectation, @IssuesByLine Multimap<IRegion, Issue> line2issue, @NextLine IRegion line, ValidationTestConfig cfg) {
		List<String> issues = getActualIssues(line2issue, line, cfg, Severity.WARNING);
		expectation.assertEquals(issues);
	}
}
