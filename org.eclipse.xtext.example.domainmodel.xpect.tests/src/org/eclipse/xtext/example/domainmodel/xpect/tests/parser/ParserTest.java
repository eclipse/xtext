package org.eclipse.xtext.example.domainmodel.xpect.tests.parser;

import org.eclipse.emf.ecore.EObject;
import org.junit.runner.RunWith;
import org.xpect.parameters.IStringExpectation;
import org.xpect.parameters.ParameterParser;
import org.xpect.parameters.StringExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectTestFiles;
import org.xpect.setup.XpectSetup;
import org.xpect.xtext.lib.setup.ThisModel;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.util.EObjectFormatter;

@RunWith(XpectRunner.class)
@XpectSetup(XtextStandaloneSetup.class)
@XpectTestFiles(fileExtensions = "xt")
public class ParserTest {

	@Xpect
	public void ast(@StringExpectation IStringExpectation expectation, @ThisModel EObject model) {
		String actual = new EObjectFormatter().resolveCrossReferences().format(model);
		expectation.assertEquals(actual);
	}

	@Xpect
	@ParameterParser(syntax = "arg0=TEXT")
	public void param(String param) {
		System.out.println("param " + param);
	}

}
