package org.eclipse.xtext.example.arithmetics.xpect.tests;

import org.eclipse.xtext.example.arithmetics.xpect.tests.interpreter.InterpreterTest;
import org.eclipse.xtext.example.arithmetics.xpect.tests.suite.ArithmeticsXtextTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ InterpreterTest.class, ArithmeticsXtextTest.class })
public class AllArithmeticsTests {

}
