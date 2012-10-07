package org.eclipse.xpect.xtext.lib.setup;

import java.util.List;
import java.util.Set;

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

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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

	protected String issueToString(Issue issue) {
		StringBuffer result = new StringBuffer();
		result.append(issue.getSeverity().toString().toLowerCase());
		result.append(" - ");
		result.append(issue.getMessage().replace("\n", "\\n"));
		return result.toString();
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
		String visualized = visualize(document, filteredIssues);
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

	protected String visualize(String document, List<Issue> issues) {
		@SuppressWarnings("unchecked")
		List<Issue>[] mapped = new List[document.length()];
		List<Issue> unmapped = Lists.newArrayList();
		for (Issue issue : issues) {
			if (issue.getOffset() >= 0 && issue.getOffset() < document.length() && issue.getLength() > 0) {
				int max = Math.min(issue.getOffset() + issue.getLength(), document.length());
				for (int i = issue.getOffset(); i < max; i++) {
					if (mapped[i] == null)
						mapped[i] = Lists.newArrayList(issue);
					else
						mapped[i].add(issue);
				}
			} else
				unmapped.add(issue);
		}
		StringBuffer result = new StringBuffer();
		for (Issue issue : unmapped) {
			if (result.length() > 0)
				result.append("\n");
			result.append(issueToString(issue));
		}
		boolean first = true;
		int offset = 0;
		for (String line : document.split("\\n")) {
			if (first)
				first = false;
			else
				result.append("\n");
			result.append(line);
			boolean lineHasIssue = false;
			for (int i = offset; i < offset + line.length(); i++)
				if (mapped[i] != null)
					lineHasIssue = true;
			if (lineHasIssue) {
				result.append("\n");
				Set<Issue> lineIssues = Sets.newLinkedHashSet();
				for (int i = offset; i < offset + line.length(); i++)
					if (mapped[i] != null) {
						int mark = 0;
						lineIssues.addAll(mapped[i]);
						for (Issue issue : mapped[i])
							mark += 1 << Iterables.indexOf(lineIssues, Predicates.equalTo(issue));
						result.append(Integer.toHexString(mark));
					} else
						result.append(" ");
				for (Issue issue : lineIssues) {
					int id = 1 << Iterables.indexOf(lineIssues, Predicates.equalTo(issue));
					result.append("\n");
					result.append(id);
					result.append(": ");
					result.append(issueToString(issue));
				}
			}
			offset += line.length() + 1;
		}
		return result.toString();
	}
}
