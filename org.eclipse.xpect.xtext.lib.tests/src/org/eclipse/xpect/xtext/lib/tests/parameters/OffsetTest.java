package org.eclipse.xpect.xtext.lib.tests.parameters;

import org.junit.runner.RunWith;
import org.xpect.expectation.IStringExpectation;
import org.xpect.lib.XpectTestResultTest;
import org.xpect.parameter.OffsetRegion;
import org.xpect.parameter.ParameterParser;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.text.IRegion;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.xpect.xtext.lib.setup.XtextWorkspaceSetup;

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
