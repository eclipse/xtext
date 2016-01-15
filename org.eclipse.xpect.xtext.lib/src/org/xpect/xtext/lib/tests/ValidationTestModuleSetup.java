package org.xpect.xtext.lib.tests;

import static com.google.common.collect.Iterables.filter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xpect.XjmXpectMethod;
import org.xpect.XpectFile;
import org.xpect.XpectImport;
import org.xpect.XpectInvocation;
import org.xpect.XpectReplace;
import org.xpect.registry.AbstractDelegatingModule;
import org.xpect.registry.DefaultBinding;
import org.xpect.setup.XpectGuiceModule;
import org.xpect.setup.XpectSetupFactory;
import org.xpect.state.Creates;
import org.xpect.state.XpectStateAnnotation;
import org.xpect.text.IRegion;
import org.xpect.text.Region;
import org.xpect.ui.services.XtResourceValidator;
import org.xpect.ui.util.XpectFileAccess;
import org.xpect.util.JvmAnnotationUtil;
import org.xpect.xtext.lib.setup.ThisResource;
import org.xpect.xtext.lib.setup.XtextValidatingSetup;
import org.xpect.xtext.lib.tests.ValidationTestModuleSetup.IssuesByLineProvider;
import org.xpect.xtext.lib.util.IssueOverlapsRangePredicate;
import org.xpect.xtext.lib.util.NextLine.NextLineProvider;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Binder;
import com.google.inject.Key;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@XpectGuiceModule
@XpectImport(IssuesByLineProvider.class)
public class ValidationTestModuleSetup extends AbstractDelegatingModule {
	@XpectStateAnnotation
	@Retention(RetentionPolicy.RUNTIME)
	public @interface ConsumedIssues {
		Severity[]value();
	}

	@XpectStateAnnotation
	@Retention(RetentionPolicy.RUNTIME)
	public @interface IssuesByLine {
	}

	@XpectSetupFactory
	@XpectReplace(XtextValidatingSetup.class)
	public static class IssuesByLineProvider extends XtextValidatingSetup {

		private Multimap<IRegion, Issue> issuesByLine = null;

		public IssuesByLineProvider(@ThisResource XtextResource resource) {
			super(resource);
		}

		@Override
		protected List<Issue> collectIssues() {
			return Lists.newArrayList(collectIssuesByLine().get(UNMATCHED));
		}

		@Creates(IssuesByLine.class)
		public Multimap<IRegion, Issue> collectIssuesByLine() {
			if (issuesByLine == null) {
				TestingResourceValidator validator = (TestingResourceValidator) getResource().getResourceServiceProvider().getResourceValidator();
				issuesByLine = validator.validateAndMapByOffset(getResource(), CheckMode.ALL, CancelIndicator.NullImpl);
			}
			return issuesByLine;
		}
	}

	public static class TestingResourceValidator extends XtResourceValidator {

		protected Set<Severity> getExpectedSeverity(XpectInvocation inv) {
			if (inv == null || inv.eIsProxy())
				return null;
			XjmXpectMethod method = inv.getMethod();
			if (method == null || method.eIsProxy())
				return null;
			JvmOperation operation = method.getJvmMethod();
			if (operation == null || operation.eIsProxy())
				return null;
			ConsumedIssues annotation = JvmAnnotationUtil.getJavaAnnotation(operation, ConsumedIssues.class);
			if (annotation == null)
				return null;
			EnumSet<Severity> result = EnumSet.copyOf(Lists.newArrayList(annotation.value()));
			return result;
		}

		@Override
		public List<Issue> validate(Resource resource, CheckMode mode, CancelIndicator indicator) {
			return Lists.newArrayList(validateAndMapByOffset(resource, mode, indicator).get(UNMATCHED));
		}

		public Multimap<IRegion, Issue> validateAndMapByOffset(Resource resource, CheckMode mode, CancelIndicator indicator) {
			Multimap<IRegion, Issue> result = LinkedHashMultimap.create();
			if (resource instanceof XtextResource && ((XtextResource) resource).getParseResult() != null) {
				XtextResource xresource = (XtextResource) resource;
				List<Issue> issuesFromDelegate = validateDelegate(resource, mode, indicator);
				if (issuesFromDelegate != null && !issuesFromDelegate.isEmpty()) {
					XpectFile xpectFile = XpectFileAccess.getXpectFile(resource);
					ValidationTestConfig config = new ValidationTestConfig(xpectFile.<ValidationTestConfig> createSetupInitializer());
					Set<Issue> issues = Sets.newLinkedHashSet(issuesFromDelegate);
					Set<Issue> matched = Sets.newHashSet();
					for (XpectInvocation inv : xpectFile.getInvocations()) {
						Set<Severity> severities = getExpectedSeverity(inv);
						if (severities != null) {
							IRegion region = new NextLineProvider(xresource, inv).getNextLine();
							List<Issue> selected = Lists.newArrayList(filter(issues, new IssueOverlapsRangePredicate(region, severities)));
							result.putAll(region, selected);
							matched.addAll(selected);
						}
					}
					issues.removeAll(matched);
					result.putAll(UNMATCHED, filter(issues, config.getIgnoreFilter()));
				}
				result.putAll(UNMATCHED, validateXpect(xresource, mode, indicator));
			} else
				result.putAll(UNMATCHED, super.validate(resource, mode, indicator));
			return ImmutableMultimap.copyOf(result);
		}
	}

	public static final IRegion UNMATCHED = new Region("(unmatched)", -1, 0);

	public void configure(Binder binder) {
		binder.bind(IResourceValidator.class).to(TestingResourceValidator.class);
		binder.bind(IResourceValidator.class).annotatedWith(DefaultBinding.class).to(getOriginalType(Key.get(IResourceValidator.class)));
	}

}
