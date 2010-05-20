/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.splitting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.generator.parser.AbstractAntlrSplitterTest;
import org.eclipse.xtext.generator.parser.antlr.splitting.AntlrLexerSplitter;
import org.eclipse.xtext.generator.parser.antlr.splitting.AntlrLexerSplitter.ExtractedMethod;


/**
 *
 * @author Heiko Behrens - Initial contribution and API
 */
public class AntlrLexerSplitterTest extends AbstractAntlrSplitterTest {

	public void testMethodSignaturePattern() throws Exception {
		Pattern p = AntlrLexerSplitter.METHOD_SIGNATURE_PATTERN;
		assertFalse(p.matcher("    public final void mRULE_ANY_OTHER() throws RecognitionException {").find());
		assertTrue(p.matcher("    public void mTokens() throws RecognitionException {").find());
	}
	
	public void testAssignmentPattern() throws Exception {
		Pattern p = AntlrLexerSplitter.ASSIGNMENT_PATTERN;
		assertFalse(p.matcher("    string foo").find());
		Matcher m = p.matcher("        int alt12=16;");
		assertTrue(m.find());
		assertEquals("alt12", m.group(1));
	}
	
	public void testIndentLevelPattern() throws Exception {
		Pattern p = AntlrLexerSplitter.INDENT_LEVEL_PATTERN;
		assertFalse(p.matcher("").matches());
		assertFalse(p.matcher("a                  b").matches());
		assertFalse(p.matcher("        if ( (LA12_0=='i') ) {").find());
		assertTrue(p.matcher("            int LA12_1 = input.LA(2);").find());
		assertTrue(p.matcher("            if ( (LA12_1=='m') ) {").find());
		
	}
	
	public void testTransform() throws Exception {
		String content = readFileIntoString("org/eclipse/xtext/generator/parser/InternalLexerExample.java.txt"); 
		AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
		String actual = splitter.transform();
		assertNotNull(actual);
//		System.out.println(actual);
		assertTrue(!actual.equals(content));
	}
	
	public void testDFAPattern() throws Exception {
		Pattern p = AntlrLexerSplitter.DFA_ASSIGNMENT_PATTERN;
		assertTrue(p.matcher("        alt12 = dfa12.predict(input);").find());
		assertFalse(p.matcher("        int LA12_0 = input.LA(1);").find());
	}
	
	public void testNoDFATransform() throws Exception {
		String content = readFileIntoString("org/eclipse/xtext/generator/parser/InternalLexerExample2.java.txt"); 
		AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
		String actual = splitter.transform();
		assertNotNull(actual);
		assertTrue(actual.equals(content));
	}
	
	public void testOuterBraceInIfCascadePattern() throws Exception {
		Pattern p = AntlrLexerSplitter.OUTER_BRACE_IN_IF_CASCADE_PATTERN;
		Matcher m = p.matcher("            alt13=62;}  ");
		assertTrue(m.find());
		assertEquals("            alt13=62;", m.group(1));
		assertFalse(p.matcher("            alt13=62; ").find());
		assertFalse(p.matcher("            } ").find());
	}
	public void testIfCascadeWithOneLineElse() throws Exception {
		String content = 
		    "    public void mTokens() throws RecognitionException {\n" +
		    "        // ../org.eclipse.xtext.example.domainmodel.ui/src-gen/org/eclipse/xtext/example/contentassist/antlr/internal/InternalDomainmodel.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )\n" +
		    "        int alt13=27;\n" +
		    "        int LA12_0 = input.LA(1);\n" +
			"        \n" +
		    "        if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||LA13_0=='!'||(LA13_0>='#' && LA13_0<='&')||(LA13_0>='*' && LA13_0<='+')||LA13_0==':'||(LA13_0>='<' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||LA13_0=='|'||(LA13_0>='~' && LA13_0<='\uFFFE')) ) {\n" +
	        "            alt13=67;\n" +
	        "        }\n" +
	        "        else {\n" +
	        "            alt13=62;}\n" +
	        "        switch (alt13) {\n" +
	        "            case 1 :\n" + 
	        "                {\n" + 
	        "                foo();\n" +
	        "                break;\n" +
	        "                }\n" + 
	        "        }\n" + 
	        "    }\n";
		AntlrLexerSplitter splitter = new AntlrLexerSplitter(content);
		String actual = splitter.transform();
		assertNotNull(actual);
	}

	public void testExtractedLine() throws Exception {
		ExtractedMethod m = new ExtractedMethod("myVar", 1);
		assertEquals("mTokensHelper001", m.getName());
		assertEquals("  foo();", m.getAsExtractedLine("  foo();"));
		assertEquals("  myVar();", m.getAsExtractedLine("  myVar();"));
		assertEquals("  return 123;", m.getAsExtractedLine("  myVar=123;"));
		assertEquals("  return 123;}", m.getAsExtractedLine("  myVar=123;}"));
	}
	
	public void testExtectedMethodSimple() throws Exception {
		ExtractedMethod m = new ExtractedMethod("myVar", 1);
		m.addLine("            if ( someComplexExpression ) {");
		m.addLine("                myVar=1;");
		m.addLine("            }");
		m.addLine("            else {");
		m.addLine("                myVar=2;}");

		StringBuilder sb = new StringBuilder();
		m.writeTo(sb);
		
		String expected = "    private int mTokensHelper001() throws RecognitionException {\n" +
			"        if ( someComplexExpression ) {\n" +
			"            return 1;\n" +
			"        }\n" +
			"        else {\n" +
			"            return 2;}\n" +
			"    }\n";
		assertEquals(expected, sb.toString());
	}
	
	public void testExtectedMethodRemoveBreaks() throws Exception {
		ExtractedMethod m = new ExtractedMethod("alt12", 1);
		m.addLine("            switch ( input.LA(2) ) {");
		m.addLine("            case '*':");
		m.addLine("                {");
		m.addLine("                alt12=13;");
		m.addLine("                }");
		m.addLine("                break;");
		m.addLine("            case '/':");
		m.addLine("                {");
		m.addLine("                alt12=14;");
		m.addLine("                }");
		m.addLine("                break;");
		m.addLine("            default:");
		m.addLine("                alt12=16;}");
		
		StringBuilder sb = new StringBuilder();
		m.writeTo(sb);
		
		String expected = "    private int mTokensHelper001() throws RecognitionException {\n" +
		"        switch ( input.LA(2) ) {\n" +
		"        case '*':\n" +
		"            {\n" +
		"            return 13;\n" +
		"            }\n" +
		"        case '/':\n" +
		"            {\n" +
		"            return 14;\n" +
		"            }\n" +
		"        default:\n" +
		"            return 16;}\n" +
		"    }\n";
		assertEquals(expected, sb.toString());
	}

}
