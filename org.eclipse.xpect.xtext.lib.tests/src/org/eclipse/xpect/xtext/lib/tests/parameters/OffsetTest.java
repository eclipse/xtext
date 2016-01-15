package org.eclipse.xpect.xtext.lib.tests.parameters;

import org.eclipse.xpect.expectation.IStringExpectation;
import org.eclipse.xpect.lib.XpectTestResultTest;
import org.eclipse.xpect.parameter.OffsetRegion;
import org.eclipse.xpect.parameter.ParameterParser;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.runner.XpectSuiteClasses;
import org.eclipse.xpect.text.IRegion;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.eclipse.xpect.xtext.lib.setup.XtextWorkspaceSetup;
import org.junit.runner.RunWith;

@RunWith(XpectRunner.class)
@XpectSuiteClasses({ XpectTestResultTest.class, XtextWorkspaceSetup.class, XtextStandaloneSetup.class })
public class OffsetTest {

	@Xpect
	@ParameterParser(syntax = "('at' arg1=OFFSET)?")
	public void intOffset(IStringExpectation exp, int offset) {
		exp.assertEquals(offset);
	}

	@Xpect
	@ParameterParser(syntax = "('at' arg1=OFFSET)?")
	public void regionOffset(IStringExpectation exp, OffsetRegion offset) {
		IRegion match = offset.getMatchedRegion();
		if (match != null) {
			int rel = offset.getMatchedOffset() - match.getOffset();
			String text = "Offset " + rel + " in " + match.getRegionText();
			exp.assertEquals(text);
		} else {
			exp.assertEquals("(not matched)");
		}
	}

}
