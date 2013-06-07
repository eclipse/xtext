package org.eclipse.xtext.example.arithmetics.xpect.tests.interpreter;

import java.math.BigDecimal;

import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.junit.runner.RunWith;
import org.xpect.expectation.IStringExpectation;
import org.xpect.expectation.StringExpectation;
import org.xpect.runner.Xpect;
import org.xpect.runner.XpectRunner;
import org.xpect.setup.XpectSetup;
import org.xpect.xtext.lib.setup.ThisOffset;
import org.xpect.xtext.lib.setup.XtextStandaloneSetup;

@RunWith(XpectRunner.class)
@XpectSetup(XtextStandaloneSetup.class)
public class InterpreterTest {

	@Xpect
	public void eval(@StringExpectation IStringExpectation expectation, @ThisOffset Expression expr) {
		BigDecimal actual = new Calculator().evaluate(expr);
		expectation.assertEquals(actual);
	}

}
