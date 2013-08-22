package org.eclipse.xtext.example.domainmodel.xpect.tests.parser;

import org.eclipse.emf.ecore.EObject
import org.junit.Test
import org.junit.runner.RunWith
import org.xpect.expectation.IStringExpectation
import org.xpect.expectation.StringExpectation
import org.xpect.runner.Xpect
import org.xpect.runner.XpectRunner
import org.xpect.runner.XpectTestFiles
import org.xpect.setup.XpectSetup
import org.xpect.xtext.lib.setup.ThisModel
import org.xpect.xtext.lib.setup.XtextStandaloneSetup
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup
import org.xpect.xtext.lib.util.EObjectFormatter

@RunWith(typeof(XpectRunner))
@XpectSetup(#[typeof(XtextStandaloneSetup), typeof(XtextWorkspaceSetup)])
@XpectTestFiles(fileExtensions="xt")
class ParserTest {

	@Xpect
	def void ast(@StringExpectation IStringExpectation expectation, @ThisModel EObject model) {
		val actual = new EObjectFormatter().resolveCrossReferences().format(model);
		expectation.assertEquals(actual);
	}

	@Test
	def void test() {
		// workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=381963
	}

}
