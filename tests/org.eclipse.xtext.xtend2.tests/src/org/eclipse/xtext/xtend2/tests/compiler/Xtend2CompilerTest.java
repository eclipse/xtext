package org.eclipse.xtext.xtend2.tests.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xtend2.Xtend2StandaloneSetup;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;

public class Xtend2CompilerTest extends AbstractXtextTests {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new Xtend2StandaloneSetup());
	}
	
	public void testSimple() throws Exception {
		final String input = "package foo\n" +
				"import java.lang.*\n" +
				"class Bar {\n" +
				"  Integer doStuff(String x) x.length\n" +
				"}\n";
		final String expected = "package foo;\n" +
				"\n" +
				"public class Bar {\n" +
				"\n" +
				"public java.lang.Integer doStuff(java.lang.String x) {\n" +
				"return x.length();\n" +
				"}\n" +
				"\n}";
		assertCompilesTo(expected, input);
	}
	
	

	protected void assertFunctionCompilesTo(final String expected, final String input) throws Exception {
//		assertCompilesTo("public class X {\n"+expected+"", input)
	}
	protected void assertCompilesTo(final String expected, final String input) throws Exception {
		EObject model = getModel(input);

		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		final IAppendable.StringBuilderBasedAppendable appendable = new IAppendable.StringBuilderBasedAppendable();
		compiler.compile(model, appendable);
		assertEquals(expected,appendable.toString());
	}
}
