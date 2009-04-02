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
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.XtextUiModule;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageRuntimeModule;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageStandaloneSetup;
import org.eclipse.xtext.enumrules.EnumRulesTestLanguageUiModule;
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
public class DefaultContentAssistProcessorTest extends AbstractXtextTests {

	private ISetup getRefGrammarSetup() {
		return new ReferenceGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new ReferenceGrammarTestLanguageRuntimeModule(), new ReferenceGrammarTestLanguageUiModule());
			}
		};
	}

	private ISetup getXtextGrammarTestSetup() {
		return new XtextGrammarTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextGrammarTestLanguageRuntimeModule(), new XtextGrammarTestLanguageUiModule());
			}
		};
	}
	
	private ISetup getXtextSetup() {
		return new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextRuntimeModule(), new XtextUiModule());
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
	
	private ISetup getEnumsLangSetup() {
		return new EnumRulesTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new EnumRulesTestLanguageRuntimeModule(), new EnumRulesTestLanguageUiModule());
			}
		};
	}

	public void testComputePrefix() throws Exception {
		String model = "spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(e1 0) erwachsener(e2 0) ";
		newBuilder(getRefGrammarSetup())
		.append(model+" familie( dfv(").assertMatchString("(").reset()
		.append(model+" familie( dfv").assertMatchString("dfv").reset()
		.append(model+" familie( dfv_").assertMatchString("dfv_").reset()
		.append(model+" familie( dfv_ ").assertMatchString("").reset()
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

	public void testBetweenContext() throws Exception {
		newBuilder(getRefGrammarSetup())
		.append("spielplatz 1 \"1\" {kind")
		.assertTextAtCursorPosition(18,"kind","erwachsener","spielzeug","familie","}");
	}

	public void testComputeCompletionProposalsIgnoreCase() throws Exception {
		ContentAssistProcessorTestBuilder builder = newBuilder(getRefGrammarSetup());
		builder = builder.append("spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(e1 0) erwachsener(e2 0) ");
		builder.append(" KI").assertText("kind");
		builder.append(" ER").assertText("erwachsener");
		builder.append(" SP").assertText("spielzeug");
		builder.append(" FA").assertText("familie");
		builder.append(" familie ( KEY").assertText("keyword","e1","e2");
		builder.append(" familie ( K").assertText("keyword","e1","e2");
		builder.append(" familie ( keyword E").assertText("e1", "e2");
		builder.append(" familie ( keyword e1 E").assertText("e1", "e2","k1","k2");
		builder.append(" familie ( keyword e1 e2 K").assertText("k1", "k2", ",", ")");
		builder.append(" familie ( keyword e1 e2 k1,K").assertText("k1", "k2",",", ")");
		builder.append(" familie ( keyword e1 e2 k1,k2").assertText(",", ")");
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
		newBuilder(getXtextGrammarTestSetup())
			.appendNl("grammar foo")
			.appendNl("generate foo \"foo\"")
			.appendNl("R1 : (attr+=R2)*;")
			.appendNl("R2 : (attr=INT)? prop=R3;")
			.append("R3: attr+=").assertText(
					"R1",
					"R2",
					"R3",
					"\"Keyword_Value\"",
					"(",
					"["
			);
	}
	
	public void testCompleteAbstractRuleCall() throws Exception {
		newBuilder(getContentAssistGrammarSetup())
			.appendNl("abstract rules")
			.appendNl("R1 ();")
			.append("R2 rule :").assertText(
					"R1",
					"R2"
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
    public void testCompleteParserRule_01() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("MyRule : 'foo' name=ID; ").assertText(
                                "ParserRule_Name", "terminal"
                );
    }
    
    public void testCompleteParserRule_02() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("")
                .appendNl("MyRule : 'foo' name=ID; ")
                .assertTextAtCursorPosition("MyRule",
                		"ParserRule_Name",
                		"terminal",
                		"as",
                        "generate",
                        "import");
    }
    
    public void testCompleteParserRule_03() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("")
                .appendNl(" MyRule : 'foo' name=ID; ")
                .assertTextAtCursorPosition(" MyRule",
                		"ParserRule_Name", 
                		"terminal",
                		"as",
                        "generate",
                        "import");
    }
    
    public void _testCompleteGenerateKeyword() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("")
                .appendNl("MyRule : 'foo' name=ID; ")
                .assertTextAtCursorPosition("generate", 3,
                		"generate");
    }

    public void testCompleteImportAndGenerateRule() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
        .appendNl("grammar foo")
        .appendNl("generate foo \"foo\"")
        .appendNl("")
        .appendNl("R1 : (attr+=R2)*;")
        .appendNl("R2 : (attr=INT)? prop=R3;")
        .assertTextAtCursorPosition("R1",
                        "ParserRule_Name",
                        "as",
                        "generate",
                        "import",
                        "terminal"
        );
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269593
     */
    public void testCompleteRuleCallWithSpace() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
        .appendNl("grammar foo")
        .appendNl("generate foo \"foo\"")
        .appendNl("R1 : (attr+=R2)*;")
        .appendNl("R2 : (attr=INT)? prop=R3;")
        .append("R3: attr+= ").assertText(
                        "R1",
                        "R2",
                        "R3",
                        "\"Keyword_Value\"",
                        "(",
                        "["
        );
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269593
     */
    public void testCompleteAbstractRuleCallWithSpace() throws Exception {
        newBuilder(getContentAssistGrammarSetup())
        .appendNl("abstract rules")
        .appendNl("R1 ();")
        .append("R2 rule : ").assertText(
                        "R1",
                        "R2"
        );
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269649
     */
    public void testCompletionOnGenerateKeyword() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
        .appendNl("generate meta \"url\"")
        .appendNl("Rule: name=ID;")
        .assertTextAtCursorPosition("generate", 3,"generate");
    }

    /**
     * regression test for:
     *
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=260825
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=262313
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=267582
     */
    public void testCompleteAssignmentWithBacktracking() throws Exception {
    	newBuilder(getXtextGrammarTestSetup())
        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
        .appendNl("generate foo \"foo\"")
        .append("MyRule : 'foo' name").assertText("\"Keyword_Value\"", "(", "*", "+", "+=", ";", "=", "?", "?=",
        		"Assignment_Feature", "MyRule",  "{")
        .appendNl(";")
        .append("terminal Other_Id").assertText(":","returns");

    }
//TODO    /**
//     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=270116
//     * @throws Exception
//     */
//    public void testCompleteTypeRefReturnForEnumRule() throws Exception {
//        doTestCompleteTypeRefSetup()
//                .appendNl("enum NewEnum returns ").assertText(
//                                "Class", "Import","Model","NewEnum"
//                );
//    }
//    /**
//     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=270116
//     * @throws Exception
//     */
//	public void testCompleteTypeRefReturnForParserRule() throws Exception {
//        doTestCompleteTypeRefSetup()
//                .appendNl("NewType returns ").assertText(
//                                "Class", "Import","Model","NewType"
//                );
//    }
//    /**
//     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=270116
//     * @throws Exception
//     */
//    public void testCompleteTypeRefReturnForTerminalRule() throws Exception {
//        doTestCompleteTypeRefSetup()
//                .appendNl("terminal NewType returns ").assertText(
//                                "Class", "Import","Model"
//                );
//    }

    public void testKeywordWithBackslashes() throws Exception {
		newBuilder(getKeywordsLangSetup()).assertText("foo\\bar", "foo\\", "\\bar", "\\");
	}
    
    public void testEnumCompletion_01() throws Exception {
    	newBuilder(getEnumsLangSetup()).assertText("existing", "generated");
    }
    
    public void testEnumCompletion_02() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("exi").assertText("existing");
    }
    
    public void testEnumCompletion_03() throws Exception {
    	newBuilder(getEnumsLangSetup()).append(" ").assertText("existing", "generated");
    }
    
    public void testEnumCompletion_04() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("existing").assertText("SameName", "DifferentLiteral", "overridden");
    }
    
    public void testEnumCompletion_05() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("existing ").assertText("SameName", "DifferentLiteral", "overridden");
    }
    
    public void testEnumCompletion_06() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("existing Same").assertText("SameName");
    }
    
    public void testEnumCompletion_07() throws Exception {
    	newBuilder(getEnumsLangSetup()).append("generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    public void testEnumCompletion_08() throws Exception {
    	newBuilder(getEnumsLangSetup()).append(" generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    public void testEnumCompletion_09() throws Exception {
    	newBuilder(getEnumsLangSetup()).append(" generated SameName").assertTextAtCursorPosition(2, "generated");
    }
    
	protected ContentAssistProcessorTestBuilder newBuilder(ISetup standAloneSetup) throws Exception {
		with(standAloneSetup);
		return new ContentAssistProcessorTestBuilder(standAloneSetup, this);
	}

	private ContentAssistProcessorTestBuilder doTestCompleteTypeRefSetup() throws Exception {
		return newBuilder(getXtextSetup())
        .appendNl("grammar org.xtext.example.MyDsl1 with org.eclipse.xtext.common.Terminals")
        .appendNl("import \"http://www.eclipse.org/emf/2003/Change\"")
        .appendNl("generate myDsl1 \"http://www.xtext.org/example/MyDsl1\"")
        .appendNl("Model :")
        .appendNl("(imports+=Import)*")
        .appendNl("(elements+=Class)*;")
        .appendNl("Import :")
        .appendNl("'import' importURI=STRING;")
        .appendNl("Class :")
        .appendNl("'class' name=ID ('extends' references=[Class])?;");
}

}