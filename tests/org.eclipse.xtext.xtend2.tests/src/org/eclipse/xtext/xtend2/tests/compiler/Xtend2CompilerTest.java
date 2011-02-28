package org.eclipse.xtext.xtend2.tests.compiler;

import java.io.StringWriter;

import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

public class Xtend2CompilerTest extends AbstractXtend2TestCase {

	public void testSimple() throws Exception {
		final String input = "package foo\n" +
				"class Bar {\n" +
				"  Integer doStuff(String x) {x.length}\n" +
				"}\n";
		final String expected = "package foo;\n" + 
				"\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" + 
				"public class Bar {\n" +
				"  private final Bar _this = this;\n" + 
				"  \n" +
				"  public Integer doStuff(final String x) {\n" + 
				"    int _length = x.length();\n" + 
				"    return ((Integer)_length);\n" + 
				"  }\n" + 
				"}";
		assertCompilesTo(expected, input);
	}
	
	public void testConstructor() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar {\n" +
		"  foo() {new String()}\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar {\n" +
		"  private final Bar _this = this;\n" + 
		"  \n" + 
		"  public String foo() {\n" + 
		"    return new String();\n" + 
		"  }\n" + 
		"}";
		assertCompilesTo(expected, input);
	}

	public void testExtends() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar extends Object {\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar extends Object {\n" +
		"  private final Bar _this = this;\n" + 
		"}";
		assertCompilesTo(expected, input);
	}

	public void testImplements() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar implements Cloneable, java.io.Serializable {\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"import java.io.Serializable;\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar implements Cloneable, Serializable {\n" +
		"  private final Bar _this = this;\n" + 
		"}";
		assertCompilesTo(expected, input);
	}
	
	public void testConstructor_2() throws Exception {
		final String input = 
			"package foo\n" +
			"class Bar {\n" +
			"  foo() {new java.util.HashMap<String,java.io.Serializable>()}" +
			"}\n";
		final String expected =  
			"package foo;\n" +
			"\n" + 
			"import java.io.Serializable;\n" + 
			"import java.util.HashMap;\n" + 
			"\n" +
			"@SuppressWarnings(\"all\")\n" +
			"public class Bar {\n" +
			"  private final Bar _this = this;\n" +
			"  \n" +
			"  public HashMap<String,Serializable> foo() {\n" +
			"    return new HashMap<String,Serializable>();\n" +
			"  }\n" + 
			"}";
		assertCompilesTo(expected, input);
	}

	protected void assertCompilesTo(final String expected, final String input) throws Exception {
		XtendFile file = file(input,true);
		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		StringWriter appendable = new StringWriter();
		compiler.compile(file, appendable);
		assertEquals(expected,appendable.toString());
	}
	
}
