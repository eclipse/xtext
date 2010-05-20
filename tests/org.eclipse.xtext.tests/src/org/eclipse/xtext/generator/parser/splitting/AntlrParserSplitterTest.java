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

import org.eclipse.xtext.generator.parser.AbstractAntlrSplitterTest;
import org.eclipse.xtext.generator.parser.antlr.splitting.AntlrParserSplitter;
import org.eclipse.xtext.generator.parser.antlr.splitting.AntlrParserSplitter.ExtractedClass;


/**
 *
 * @author Heiko Behrens - Initial contribution and API
 */
public class AntlrParserSplitterTest extends AbstractAntlrSplitterTest {

	String DECLARATIONS = "\n" +
		"\n" +
		"	public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});	\n" +
		"	public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});	\n" +
		"   \n";
	
	String REFERENCES = "\n" +
		"{ \n" +
		"before(grammarAccess.getModelRule());\n" + 
		"pushFollow(FOLLOW_ruleModel_in_entryRuleModel60, FOLLOW_ruleModel_in_entryRuleModel60);\n" +
		"ruleModel();\n" +
		"_fsp--;\n" +
		"\n" +
		"after(grammarAccess.getModelRule());\n" + 
		"match(input,EOF,FOLLOW_EOF_in_entryRuleModel67);\n" + 
		"\n" +
		"}\n";
	
	String DECL_AND_REF = DECLARATIONS + REFERENCES;
	
	public void testDeclaration() throws Exception {
		
		Matcher m = AntlrParserSplitter.DECLARATION_PATTERN.matcher(DECL_AND_REF);
		assertTrue(m.find());
		assertEquals("FOLLOW_ruleModel_in_entryRuleModel60", m.group(1));
		assertEquals("public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});", m.group());
		assertTrue(m.find());
		assertEquals("FOLLOW_EOF_in_entryRuleModel67", m.group(1));
		assertEquals("public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});", m.group());
		assertFalse(m.find());
	}
	
	public void testReference() throws Exception {
		Matcher m = AntlrParserSplitter.REFERENCE_PATTERN.matcher(DECL_AND_REF);
		assertTrue(m.find());
		assertEquals("FOLLOW_ruleModel_in_entryRuleModel60", m.group(1));
		assertEquals(315, m.end());
		assertTrue(m.find());
		assertEquals("FOLLOW_ruleModel_in_entryRuleModel60", m.group(1));
		assertEquals(353, m.end());
		assertTrue(m.find());
		assertEquals("FOLLOW_EOF_in_entryRuleModel67", m.group(1));
		assertEquals(461, m.end());
		assertFalse(m.find());
	}
	
	public void testTransformer() throws Exception {
		AntlrParserSplitter splitter = new AntlrParserSplitter(REFERENCES + DECLARATIONS);
		String actual = splitter.transform();
		assertNotNull(actual);
//		System.out.println(actual);
		assertEquals(1, splitter.getExtractedClasses().size());
		ExtractedClass ec = splitter.getExtractedClasses().get(0);
		assertEquals("FollowSets000", ec.getName());
//		System.out.println(ec.getContent());
	}
	
	public void testRealworld() throws Exception {
		String _class = readFileIntoString("org/eclipse/xtext/generator/parser/InternalParserExample.java.txt");
		AntlrParserSplitter splitter = new AntlrParserSplitter(_class);
		String newClass = splitter.transform();
		assertNotNull(newClass);
//		System.out.println(newClass);
		assertEquals(1, splitter.getExtractedClasses().size());
		ExtractedClass ec = splitter.getExtractedClasses().get(0);
		assertNotNull(ec);
//		System.out.println(ec.getContent());
	}
	
}
