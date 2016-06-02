package org.eclipse.xtext.example.arithmetics.xpect.tests.interpreter;

import java.math.BigDecimal;

import org.eclipse.xpect.expectation.IStringExpectation;
import org.eclipse.xpect.expectation.StringExpectation;
import org.eclipse.xpect.runner.Xpect;
import org.eclipse.xpect.runner.XpectRunner;
import org.eclipse.xpect.runner.XpectTestFiles;
import org.eclipse.xpect.runner.XpectTestFiles.FileRoot;
import org.eclipse.xpect.setup.XpectSetup;
import org.eclipse.xpect.xtext.lib.setup.ThisOffset;
import org.eclipse.xpect.xtext.lib.setup.XtextStandaloneSetup;
import org.eclipse.xpect.xtext.lib.setup.XtextWorkspaceSetup;
import org.eclipse.xtext.example.arithmetics.arithmetics.Expression;
import org.eclipse.xtext.example.arithmetics.interpreter.Calculator;
import org.junit.runner.RunWith;

@RunWith(XpectRunner.class)
@XpectSetup({ XtextStandaloneSetup.class, XtextWorkspaceSetup.class })
@XpectTestFiles(relativeTo = FileRoot.SOURCE, files = "org/eclipse/xtext/example/arithmetics/xpect/tests/interpreter/test.calc.xt")
public class InterpreterTest {

	@Xpect
	public void eval(@StringExpectation IStringExpectation expectation, @ThisOffset Expression expr) {
		BigDecimal actual = new Calculator().evaluate(expr);
		expectation.assertEquals(actual);
	}

}
