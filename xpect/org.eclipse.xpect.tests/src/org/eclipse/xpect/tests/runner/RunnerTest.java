package org.eclipse.xpect.tests.runner;

import org.eclipse.xpect.expectation.IStringExpectation;
import org.eclipse.xpect.expectation.StringExpectation;
import org.eclipse.xpect.lib.XpectTestResultTest;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.runner.XpectSuiteClasses;
import org.junit.runner.RunWith;

@RunWith(XpectRunner.class)
@XpectSuiteClasses(XpectTestResultTest.class)
public class RunnerTest {
	@Xpect
	public void expectedExpectation(@StringExpectation IStringExpectation expectation) {
		expectation.assertEquals("expectedExpectation");
	}
}
