package org.xpect.tests.parameter;

import org.junit.runner.RunWith;
import org.xpect.expectation.IStringExpectation;
import org.xpect.lib.XpectTestResultTest;
import org.xpect.parameter.OffsetRegion;
import org.xpect.parameter.ParameterParser;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectSuiteClasses;
import org.xpect.text.IRegion;

@RunWith(XpectRunner.class)
@XpectSuiteClasses(XpectTestResultTest.class)
public class ParameterParserTest {

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

	@Xpect
	@ParameterParser(syntax = "'kw'")
	public void mandatoryKeyword() {
	}

	@Xpect
	public void mandatoryParameter(int x) {
	}
}
