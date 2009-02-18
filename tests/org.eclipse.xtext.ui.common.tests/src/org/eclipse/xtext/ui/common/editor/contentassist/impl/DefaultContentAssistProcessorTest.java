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


import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextGrammarTestLanguageRuntimeModule;
import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.XtextGrammarTestLanguageUiModule;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageRuntimeModule;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguageUiModule;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageRuntimeModule;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageUiModule;

import com.google.inject.Guice;
import com.google.inject.Injector;


/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>. Reused by Xtend implementation.
 * 
 * @author Michael Clay - Initial contribution and API
 * @author Jan Koehnlein
 * @see org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor
 */
public class DefaultContentAssistProcessorTest extends AbstractXtextTests 
{
	
	private ISetup getRefGrammarSetup() {
		return new ReferenceGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ReferenceGrammarTestLanguageRuntimeModule(), new ReferenceGrammarTestLanguageUiModule());
			}
		};
	}
	
	private ISetup getXtextGrammarSetup() {
		return new XtextGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextGrammarTestLanguageRuntimeModule(), new XtextGrammarTestLanguageUiModule());
			}
		};
	}
	
	private ISetup getContentAssistGrammarSetup() {
		return new ContentAssistTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ContentAssistTestLanguageRuntimeModule(), new ContentAssistTestLanguageUiModule());
			}
		};
	}
	
	private ISetup getKeywordsLangSetup() {
		return new KeywordsTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new KeywordsTestLanguageRuntimeModule(), new KeywordsTestLanguageUiModule());
			}
		};
	}
	
	public void testComputePrefix() throws Exception {
		newBuilder(getRefGrammarSetup())
		.append("foo fvdf dfv(").assertMatchString("(").reset()
		.append("foo fvdf dfv").assertMatchString("dfv").reset()
		.append("foo fvdf dfv_").assertMatchString("dfv_").reset()
		.append("foo fvdf dfv_ ").assertMatchString("").reset()
		.append("").assertMatchString("");
	}
	
	public void testComputeCompletionProposalsCount() throws Exception {
		newBuilder(getRefGrammarSetup()).assertCount(1)
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
		newBuilder(getRefGrammarSetup()).assertText("spielplatz")
			.applyText().assertText("1")
			.applyText().assertText("\"Spielplatz_Beschreibung\"","{")
			.applyText().assertText("{")
			.applyText().assertText("erwachsener", "familie", "spielzeug", "kind", "}")
			.append("erwachsener ").assertText("(")
			.applyText().assertText("Erwachsener_Name")
			.append("e1 ").assertText("1")
			.applyText().assertText(")")
			.applyText().append("erwachsener (e2 0) kind ").assertText("(")
			.applyText().assertText("Kind_Name")
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
		ContentAssistProcessorTestBuilder builder = newBuilder(getRefGrammarSetup());
		builder = builder.append("spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(e1 0) erwachsener(e2 0) ");
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
	
	/**
	 * 
	 * <p>
	 * Tests proposals sample domain language.
	 * </p>
	 * 
	 * <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=260688">Bug 260688 </a>
	 * 
//	 */
//	public void testDomainLanguage() throws Exception {
//		newBuilder(DomainModel)
//		.assertCount(4)
//		.append("d").assertCount(1)
//		.append("a").assertCount(1)
//		.append("t").assertCount(1)
//		.append("a").assertCount(1)
//		.reset().assertCount(4)
//		.append("e").assertCount(1)
//		.append("n").assertCount(1)
//		.append("t").assertCount(1)
//		.append("i").assertCount(1)
//		.reset().assertCount(4)
//		.append("i").assertCount(1)
//		.append("m").assertCount(1)
//		.append("p").assertCount(1)
//		.append("o").assertCount(1)
//		.reset().assertCount(4)
//		.append("p").assertCount(1)
//		.append("a").assertCount(1)
//		.append("c").assertCount(1)
//		.append("k").assertCount(1);
//	}
	
	
	public void testCompleteRuleCall() throws Exception {
		newBuilder(getXtextGrammarSetup())
			.appendNl("language foo")
			.appendNl("generate foo \"foo\"")
			.appendNl("R1 : (attr+=R2)*;")
			.appendNl("R2 : (attr=INT)? prop=R3;")
			.append("R3: attr+=").assertText(
					"R1", 
					"R2",
					"R3",
					"\"Keyword_Value\"", 
					"(", 
					"[", 
					"+=" // TODO: Why does this proposal come up?
			);
	}
	
	public void testCompleteAbstractRuleCall() throws Exception {
		newBuilder(getContentAssistGrammarSetup())
			.appendNl("abstract rules")
			.appendNl("R1 ();")
			.append("R2 rule :").assertText(
					"R1", 
					"R2",
					":" // TODO: Why does this proposal come up?
			);
	}
	
	public void testDefaultRule() throws Exception {
		ContentAssistProcessorTestBuilder builder = newBuilder(getRefGrammarSetup());
		builder.assertText("spielplatz");
		builder.append(" spielplatz 1 \"SpielplatzBeschreibung\" { } ")
			.assertTextAtCursorPosition(1, "spielplatz");
	}
	/**
     * regression test for:
     *
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=260825
     */
    public void testCompleteParserRule() throws Exception {
            newBuilder(getXtextGrammarSetup())
                    .appendNl("language foo")
                    .appendNl("generate foo \"foo\"")
                    .appendNl("MyRule : 'foo' name=ID; ").assertText(
                                    "ParserRule_Name", "lexer", "native", "terminal"
                    );

    }
    /**
     * regression test for:
     *
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=260825
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=262313
     */
    public void testCompleteAssignmentWithBacktracking() throws Exception {
    	newBuilder(getXtextGrammarSetup())
                    .appendNl("language foo")
                    .appendNl("generate foo \"foo\"")
                    .append("MyRule : 'foo' name").assertText(
                                    "*", "+", "+=", ";", "=", "?", "?="
                    );
	
    }
    
    public void testKeywordWithBackslashes() throws Exception {
		newBuilder(getKeywordsLangSetup())
			.assertText("foo\\bar", "foo\\", "\\bar", "\\");
	}
	
	protected ContentAssistProcessorTestBuilder newBuilder(ISetup standAloneSetup) throws Exception {
		with(standAloneSetup);
		return new ContentAssistProcessorTestBuilder(standAloneSetup);
	}
	
}