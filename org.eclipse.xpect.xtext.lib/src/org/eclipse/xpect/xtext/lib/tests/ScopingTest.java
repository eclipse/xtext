package org.eclipse.xpect.xtext.lib.tests;

import org.eclipse.xpect.parameters.CommaSeparatedValuesExpectation;
import org.eclipse.xpect.parameters.ICommaSeparatedValuesExpectation;
import org.eclipse.xpect.parameters.ParameterParser;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xpect.xtext.lib.setup.ThisOffset;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.eclipse.xpect.xtext.lib.setup.XtextOffsetAdapter.ICrossEReferenceAndEObject;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.junit.runner.RunWith;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

@RunWith(XpectRunner.class)
@XpectSetup(XtextStandaloneSetup.class)
public class ScopingTest {

	protected static class EObjectDescriptionToStringMapper implements Function<IEObjectDescription, String> {
		public String apply(IEObjectDescription desc) {
			return desc.getName().toString();
		}
	}

	@Inject
	private IScopeProvider scopeProvider;

	public IScopeProvider getScopeProvider() {
		return scopeProvider;
	}

	@Xpect
	@ParameterParser(syntax = "('at' arg1=OFFSET)?")
	public void scopedElements( //
			@CommaSeparatedValuesExpectation ICommaSeparatedValuesExpectation expectation, //
			@ThisOffset ICrossEReferenceAndEObject arg1 //
	) {
		IScope scope = scopeProvider.getScope(arg1.getEObject(), arg1.getCrossEReference());
		Iterable<String> names = Iterables.transform(scope.getAllElements(), new EObjectDescriptionToStringMapper());
		expectation.assertEquals(names);
	}
}
