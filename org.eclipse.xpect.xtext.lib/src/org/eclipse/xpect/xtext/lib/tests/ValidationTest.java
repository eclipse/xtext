package org.eclipse.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xpect.parameters.ILinesExpectation;
import org.eclipse.xpect.parameters.LinesExpectation;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xpect.setup.XtextInjectorSetup;
import org.eclipse.xpect.xtext.lib.setup.FileCtx;
import org.eclipse.xpect.xtext.lib.setup.ThisOffset;
import org.eclipse.xpect.xtext.lib.setup.ThisResource;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.eclipse.xpect.xtext.lib.tests.ValidationTest.XtextValidationStandaloneSetuo;
import org.eclipse.xpect.xtext.lib.util.IssueFormatter;
import org.eclipse.xpect.xtext.lib.util.IssueOverlapsRangePredicate;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.junit.runner.RunWith;

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
