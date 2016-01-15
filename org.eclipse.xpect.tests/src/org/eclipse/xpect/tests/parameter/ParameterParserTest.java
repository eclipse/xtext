package org.eclipse.xpect.tests.parameter;

import org.eclipse.xpect.expectation.IStringExpectation;
import org.eclipse.xpect.lib.XpectTestResultTest;
import org.eclipse.xpect.parameter.OffsetRegion;
import org.eclipse.xpect.parameter.ParameterParser;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.runner.XpectSuiteClasses;
import org.eclipse.xpect.text.IRegion;
import org.junit.runner.RunWith;

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
