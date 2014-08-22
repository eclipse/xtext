package org.eclipse.xtext.example.arithmetics.xpect.tests;

import org.eclipse.xtext.example.arithmetics.xpect.tests.interpreter.InterpreterTest;
import org.eclipse.xtext.example.arithmetics.xpect.tests.suite.ArithmeticsXtextTests;
import org.junit.runner.RunWith;
import org.xpect.runner.XpectRunner;
import org.xpect.runner.XpectSuiteClasses;

@RunWith(XpectRunner.class)
@XpectSuiteClasses({ InterpreterTest.class, ArithmeticsXtextTests.class })
public class AllArithmeticsTests {

}
