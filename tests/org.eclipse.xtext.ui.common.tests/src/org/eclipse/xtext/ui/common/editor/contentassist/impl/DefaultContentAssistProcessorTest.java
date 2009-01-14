/*******************************************************************************
 * __  ___            _   
 * \ \/ / |_ _____  __ |_
 *  \  /| __/ _ \ \/ / __|
 *  /  \| |_  __/>  <| |_
 * /_/\_\\__\___/_/\_\\__|
 * 
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.impl;

import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.XtextGrammarTestLanguageUiConfig;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageUiConfig;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUiConfig;
import org.eclipse.xtext.ui.common.AbstractUiTest;


/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 * @see org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor
 */
public class DefaultContentAssistProcessorTest extends AbstractUiTest 
{

    private ContentAssistProcessorTestBuilder contentAssistProcessorTestBuilder;
    
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		withUi(XtextGrammarTestLanguageStandaloneSetup.class, XtextGrammarTestLanguageUiConfig.class);
		withUi(ContentAssistTestLanguageStandaloneSetup.class, ContentAssistTestLanguageUiConfig.class);
		withUi(ReferenceGrammarTestLanguageStandaloneSetup.class,ReferenceGrammarTestLanguageUiConfig.class);
		contentAssistProcessorTestBuilder = new ContentAssistProcessorTestBuilder(getCurrentServiceScope(),new DefaultContentAssistProcessor());
	}
	
	public void testComputeCompletionProposalsCount() throws Exception {
		contentAssistProcessorTestBuilder.assertCount(1)
			.append("spielplatz ").assertCount(1)
			.append("1 ").assertCount(2)
			.append("\"JUNIT\" ").assertCount(1)
			.append("{ ").assertCount(5)
			.append("kind ").assertCount(1)
			.append("(k1 0) erwachsener(e1 0) erwachsener(e2 0) familie( f1 ").assertCount(2)
			.append("e1 ").assertCount(2)
			.append("e2").assertCount(1);
	}
	
	public void testComputeCompletionProposalsText() throws Exception {
		contentAssistProcessorTestBuilder.assertText("spielplatz")
			.applyText().assertText("1")
			.applyText().assertText("\"SpielplatzBeschreibung\"","{")
			.applyText().assertText("{")
			.applyText().assertText("erwachsener", "familie", "spielzeug", "kind", "}")
			.append("erwachsener ").assertText("(")
			.applyText().assertText("ErwachsenerName")
			.append("e1 ").assertText("1")
			.applyText().assertText(")")
			.applyText().append("erwachsener (e2 0) kind ").assertText("(")
			.applyText().assertText("KindName")
			.append("k1 ").assertText("1")
			.applyText().assertText(")")
			.applyText().append("kind (k2 0) familie ").assertText("(")
			.applyText().assertText("keyword")
			.append("keyword ").assertText("e1","e2")
			.applyText().assertText("e1","e2")
			.append("e2 ").assertText("k1","k2")
			.append("k").assertText("k1","k2",",",")")
			.append("1 ").assertText(",",")")
			.append("k2 ").assertText(",",")")
		;
		
		
	}
	
	public void testComputeCompletionProposalsIgnoreCase() throws Exception {
		ContentAssistProcessorTestBuilder builder = contentAssistProcessorTestBuilder.append("spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(e1 0) erwachsener(e2 0) ");
		builder.append(" KI").assertText("kind");
		builder.append(" ER").assertText("erwachsener");
		builder.append(" SP").assertText("spielzeug");
		builder.append(" FA").assertText("familie");
		builder.append(" familie ( KEY").assertText("keyword");
		builder.append(" familie ( K").assertText("keyword");
		builder.append(" familie ( keyword E").assertText("e1", "e2");
		builder.append(" familie ( keyword e1 E").assertText("e1", "e2");
		builder.append(" familie ( keyword e1 e2 K").assertText("k1", "k2", ",", ")");
		builder.append(" familie ( keyword e1 e2 k1,K").assertText("k1", "k2", ",", ")");
		builder.append(" familie ( keyword e1 e2 k1,k2").assertText("k2", ",", ")");
		;
	}
	
	public void testCompleteRuleCall() throws Exception {
		newBuilder(XtextGrammarTestLanguageStandaloneSetup.class, XtextGrammarTestLanguageUiConfig.class)
			.appendNl("language foo")
			.appendNl("generate foo \"foo\"")
			.appendNl("R1 : (attr+=R2)*;")
			.appendNl("R2 : (attr=INT)? prop=R3;")
			.append("R3: attr+=").assertText(
					"R1", 
					"R2",
					"R3",
					"\"KeywordValue\"", 
					"(", 
					"[", 
					"+=" // TODO: Why does this proposal come up?
			);
	}
	
	public void testCompleteAbstractRuleCall() throws Exception {
		newBuilder(ContentAssistTestLanguageStandaloneSetup.class, ContentAssistTestLanguageUiConfig.class)
			.appendNl("abstract rules")
			.appendNl("R1 ();")
			.append("R2 rule :").assertText(
					"R1", 
					"R2",
					":" // TODO: Why does this proposal come up?
			);
	}
	
	
	public void testDefaultRule() throws Exception {
		contentAssistProcessorTestBuilder.assertText("spielplatz");
		contentAssistProcessorTestBuilder.append(" spielplatz 1 \"SpielplatzBeschreibung\" { } ")
			.assertTextAtCursorPosition(1, "spielplatz");
	}
	
	private ContentAssistProcessorTestBuilder newBuilder(Class<?> standAloneSetup, Class<?> uiConfig) throws Exception {
		withUi(standAloneSetup, uiConfig);
		return new ContentAssistProcessorTestBuilder(getCurrentServiceScope(), new DefaultContentAssistProcessor());
	}
	
	
	public void testComputePrefix() throws Exception {
		assertEquals("", prefix("foo fvdf dfv("));
		assertEquals("dfv", prefix("foo fvdf dfv"));
		assertEquals("dfv_", prefix("foo fvdf dfv_"));
		assertEquals("", prefix("foo fvdf dfv_ "));
		assertEquals("", prefix(""));
		assertEquals("", prefix(null));
	}

	private String prefix(String s) {
		return DefaultContentAssistProcessor.computePrefix(s);
	}
	
}