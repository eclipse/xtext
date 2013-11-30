package org.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.addAll;
import static com.google.common.collect.Iterables.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xpect.Environment;
import org.xpect.XpectFile;
import org.xpect.XpectInvocation;
import org.xpect.registry.AbstractDelegatingModule;
import org.xpect.registry.DefaultBinding;
import org.xpect.setup.IXpectGuiceModuleSetup;
import org.xpect.state.Creates;
import org.xpect.ui.services.XtResourceValidator;
import org.xpect.ui.util.XpectFileAccess;
import org.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;
import org.xpect.xtext.lib.setup.ThisResource;
import org.xpect.xtext.lib.setup.XtextValidatingSetup;
import org.xpect.xtext.lib.util.IssueOverlapsRangePredicate;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ValidationTestModuleSetup implements IXpectGuiceModuleSetup {
	@Retention(RetentionPolicy.RUNTIME)
	public @interface IssuesByLine {
	}

	public static class IssuesByOffsetSetup extends XtextValidatingSetup {

		private Multimap<Integer, Issue> issuesByLine = null;

		public IssuesByOffsetSetup(@ThisResource XtextResource resource) {
			super(resource);
		}

		@Override
		protected List<Issue> collectIssues() {
			return Lists.newArrayList(collectIssuesByLine().get(UNMATCHED));
		}

		@Creates(IssuesByLine.class)
		public Multimap<Integer, Issue> collectIssuesByLine() {
			if (issuesByLine == null) {
				TestingResourceValidator validator = (TestingResourceValidator) getResource().getResourceServiceProvider()
						.getResourceValidator();
				issuesByLine = validator.validateAndMapByOffset(getResource(), CheckMode.ALL, CancelIndicator.NullImpl);
			}
			return issuesByLine;
		}
	}

	public static class TestingResourceValidator extends XtResourceValidator {

		protected Severity getExpectedSeverity(XpectInvocation inv) {
			if (inv == null || inv.eIsProxy() || inv.getMethod() == null || inv.getMethod().eIsProxy())
				return null;
			String methodName = inv.getMethod().getName();
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
			return Lists.newArrayList(validateAndMapByOffset(resource, mode, indicator).get(UNMATCHED));
		}

		public Multimap<Integer, Issue> validateAndMapByOffset(Resource resource, CheckMode mode, CancelIndicator indicator) {
			Multimap<Integer, Issue> result = LinkedHashMultimap.create();
			if (resource instanceof XtextResource && ((XtextResource) resource).getParseResult() != null) {
				XtextResource xresource = (XtextResource) resource;
				List<Issue> issuesFromDelegate = validateDelegate(resource, mode, indicator);
				if (issuesFromDelegate != null && !issuesFromDelegate.isEmpty()) {
					Set<Issue> issues = Sets.newLinkedHashSet(issuesFromDelegate);
					XpectFile xpectFile = XpectFileAccess.getXpectFile(resource);
					Set<Issue> matched = Sets.newHashSet();
					for (XpectInvocation inv : xpectFile.getInvocations()) {
						int offset = new ThisOffsetProvider(inv, xresource).getOffset();
						Iterable<Issue> selected = filter(issues, new IssueOverlapsRangePredicate(xresource, offset,
								getExpectedSeverity(inv)));
						result.putAll(offset, selected);
						addAll(matched, selected);
					}
					issues.removeAll(matched);
					result.putAll(UNMATCHED, issues);
				}
				result.putAll(UNMATCHED, validateXpect(xresource, mode, indicator));
			} else
				result.putAll(UNMATCHED, super.validate(resource, mode, indicator));
			return ImmutableMultimap.copyOf(result);
		}
	}

	public static class ValidationTestWorkbenchModule extends AbstractDelegatingModule {

		public void configure(Binder binder) {
			binder.bind(IResourceValidator.class).to(TestingResourceValidator.class);
			binder.bind(IResourceValidator.class).annotatedWith(DefaultBinding.class)
					.to(getOriginalType(Key.get(IResourceValidator.class)));
		}
	}

	public static final Integer UNMATCHED = -1;

	public EnumSet<Environment> getEnvironments() {
		return EnumSet.of(Environment.PLUGIN_TEST, Environment.STANDALONE_TEST, Environment.WORKBENCH);
	}

	public Class<? extends Module> getModule() {
		return ValidationTestWorkbenchModule.class;
	}

}
