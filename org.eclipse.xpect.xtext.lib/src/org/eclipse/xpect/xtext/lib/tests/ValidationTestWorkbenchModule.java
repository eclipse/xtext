package org.eclipse.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.addAll;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xpect.XpectFile;
import org.eclipse.xpect.XpectInvocation;
import org.eclipse.xpect.registry.DefaultBinding;
import org.eclipse.xpect.ui.editor.XpectResourceValidator;
import org.eclipse.xpect.ui.util.XpectFileAccess;
import org.eclipse.xpect.util.AbstractDelegatingModule;
import org.eclipse.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;
import org.eclipse.xpect.xtext.lib.util.IssueOverlapsRangePredicate;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.Sets;
import com.google.inject.Binder;

public class ValidationTestWorkbenchModule extends AbstractDelegatingModule {

	public static class TestingResourceValidator extends XpectResourceValidator {

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
		binder.bind(IResourceValidator.class).annotatedWith(DefaultBinding.class).to(getOriginalType(IResourceValidator.class));
	}
}