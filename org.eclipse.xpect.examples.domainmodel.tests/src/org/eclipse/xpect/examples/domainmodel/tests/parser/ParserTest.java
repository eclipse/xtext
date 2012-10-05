package org.eclipse.xpect.examples.domainmodel.tests.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xpect.parameters.IStringExpectation;
import org.eclipse.xpect.parameters.StringExpectation;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xpect.xtext.lib.setup.ThisModel;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.eclipse.xtext.util.EmfFormatter;
import org.junit.runner.RunWith;

@RunWith(XpectRunner.class)
@XpectSetup(XtextStandaloneSetup.class)
public class ParserTest {

	@Xpect
	public void ast(@StringExpectation IStringExpectation expectation, @ThisModel EObject model) {
		String actual = EmfFormatter.objToStr(model);
		expectation.assertEquals(actual);
	}

}
