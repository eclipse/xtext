package org.eclipse.xtext.xtend2.tests.compiler;

import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

public class Xtend2CompilerTest extends AbstractXtend2TestCase {
	
	public void testSimple() throws Exception {
		final String input = "package foo\n" +
				"class Bar {\n" +
				"  Integer doStuff(String x) x.length\n" +
				"}\n";
		final String expected = "package foo;\n" + 
				"\n" + 
				"public class Bar {\n" + 
				"  public java.lang.Integer doStuff(java.lang.String x) {\n" + 
				"    java.lang.Integer length = x.length();\n" + 
				"    return length;\n" + 
				"  }\n" + 
				"}";
		assertCompilesTo(expected, input);
	}
	
	

	protected void assertFunctionCompilesTo(final String expected, final String input) throws Exception {
//		assertCompilesTo("public class X {\n"+expected+"", input)
	}
	protected void assertCompilesTo(final String expected, final String input) throws Exception {
		XtendFile file = file(input);
		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		final IAppendable.StringBuilderBasedAppendable appendable = new IAppendable.StringBuilderBasedAppendable();
		compiler.compile(file, appendable);
		assertEquals(expected,appendable.toString());
	}
}
