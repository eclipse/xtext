package org.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.addAll;
import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
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
import org.xpect.ui.services.XtResourceValidator;
import org.xpect.ui.util.XpectFileAccess;
import org.xpect.xtext.lib.setup.ThisOffset.ThisOffsetProvider;
import org.xpect.xtext.lib.util.IssueOverlapsRangePredicate;

import com.google.common.collect.Sets;
import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ValidationTestModuleSetup implements IXpectGuiceModuleSetup {

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

		public List<Issue> unfilteredValidate(Resource resource, CheckMode mode, CancelIndicator indicator) {
			return super.validate(resource, mode, indicator);
		}

		@Override
		public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator) {
			if (resource instanceof XtextResource && ((XtextResource) resource).getParseResult() != null) {
				XtextResource xresource = (XtextResource) resource;
				List<Issue> issuesFromDelegate = validateDelegate(resource, mode, indicator);
				if (issuesFromDelegate == null || issuesFromDelegate.isEmpty())
					return Collections.emptyList();
				Set<Issue> issues = Sets.newLinkedHashSet(issuesFromDelegate);
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

	public static class ValidationTestWorkbenchModule extends AbstractDelegatingModule {

		public void configure(Binder binder) {
			binder.bind(IResourceValidator.class).to(TestingResourceValidator.class);
			binder.bind(IResourceValidator.class).annotatedWith(DefaultBinding.class)
					.to(getOriginalType(Key.get(IResourceValidator.class)));
		}
	}

	public EnumSet<Environment> getEnvironments() {
		return EnumSet.of(Environment.PLUGIN_TEST, Environment.STANDALONE_TEST, Environment.WORKBENCH);
	}

	public Class<? extends Module> getModule() {
		return ValidationTestWorkbenchModule.class;
	}

}
