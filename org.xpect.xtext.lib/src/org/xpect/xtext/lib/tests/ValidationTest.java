package org.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.runner.RunWith;
import org.xpect.parameters.ILinesExpectation;
import org.xpect.parameters.LinesExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.setup.XpectSetup;
import org.xpect.setup.XtextInjectorSetup;
import org.xpect.xtext.lib.setup.FileCtx;
import org.xpect.xtext.lib.setup.ThisOffset;
import org.xpect.xtext.lib.setup.ThisResource;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.tests.ValidationTest.XtextValidationStandaloneSetuo;
import org.xpect.xtext.lib.util.IssueFormatter;
import org.xpect.xtext.lib.util.IssueOverlapsRangePredicate;

@RunWith(XpectRunner.class)
@XpectSetup(XtextValidationStandaloneSetuo.class)
@XtextInjectorSetup(workbenchModule = ValidationTestWorkbenchModule.class)
public class ValidationTest {

	public static class XtextValidationStandaloneSetuo extends XtextStandaloneSetup {
		@Override
		protected void validate(FileCtx ctx, Resource resource) {
		}
	}

	@Xpect
	public void errors(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource, @ThisOffset int offset) {
		List<String> issues = validate(resource, offset, Severity.ERROR);
		expectation.assertEquals(issues);
	}

	@Xpect
	public void infos(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource, @ThisOffset int offset) {
		List<String> issues = validate(resource, offset, Severity.INFO);
		expectation.assertEquals(issues);
	}

	@Xpect
	public void issues(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource, @ThisOffset int offset) {
		List<String> issues = validate(resource, offset, null);
		expectation.assertEquals(issues);
	}

	protected List<String> validate(XtextResource resource, int offset, Severity severity) {
		IResourceValidator validator = resource.getResourceServiceProvider().getResourceValidator();
		Collection<Issue> allIssues = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		List<Issue> issuesInLine = newArrayList(filter(allIssues, new IssueOverlapsRangePredicate(resource, offset, severity)));
		List<String> formattedIssues = newArrayList(transform(issuesInLine, new IssueFormatter(resource, false)));
		return formattedIssues;
	}

	@Xpect
	public void warnings(@LinesExpectation ILinesExpectation expectation, @ThisResource XtextResource resource, @ThisOffset int offset) {
		List<String> issues = validate(resource, offset, Severity.WARNING);
		expectation.assertEquals(issues);
	}
}
