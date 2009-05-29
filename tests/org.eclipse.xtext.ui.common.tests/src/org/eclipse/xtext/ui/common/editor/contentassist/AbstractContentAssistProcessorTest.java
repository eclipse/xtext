/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit.AbstractXtextTests;

/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>. Reused by Xtend implementation.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Jan Koehnlein
 * @see org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor
 */
public abstract class AbstractContentAssistProcessorTest extends AbstractXtextTests {

	private IContentAssistProcessorTestSetup setup;
	
	private static final Logger logger = Logger.getLogger(AbstractContentAssistProcessorTest.class);
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		setup = createSetup();
	}

	protected abstract IContentAssistProcessorTestSetup createSetup();
	
	@Override
	protected void tearDown() throws Exception {
		setup = null;
		super.tearDown();
	}
	
	public void testComputePrefix() throws Exception {
		try {
			// .... nasty evil hack
			newBuilder(setup.getRefGrammarSetup());
		} catch(Throwable t) {
			logger.error(t.getMessage(), t);
		}
		
		String model = "spielplatz 1 \"SpielplatzBeschreibung\" { kind(k1 0) kind(k2 0) erwachsener(e1 0) erwachsener(e2 0) ";
		newBuilder(setup.getRefGrammarSetup())
		.append(model+" familie( dfv(").assertMatchString("(").reset()
		.append(model+" familie( dfv").assertMatchString("dfv").reset()
		.append(model+" familie( dfv_").assertMatchString("dfv_").reset()
		.append(model+" familie( dfv_ ").assertMatchString("").reset()
		.append("").assertMatchString("");
	}

	public void testComputeCompletionProposalsCount() throws Exception {
		newBuilder(setup.getRefGrammarSetup()).assertCount(1)
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
		newBuilder(setup.getRefGrammarSetup()).assertText("spielplatz")
			.applyText().assertText("1")
			.applyText().assertText("\"Beschreibung\"", "{")
			.applyText().assertText("{")
			.applyText().assertText("erwachsener", "familie", "spielzeug", "kind", "}")
			.append("erwachsener ").assertText("(")
			.applyText().assertText("Name")
			.append("e1 ").assertText("1")
			.applyText().assertText(")")
			.applyText().append("erwachsener (e2 0) kind ").assertText("(")
			.applyText().assertText("Name")
			.append("k1 ").assertText("1")
			.applyText().assertText(")")
			.applyText().append("kind (k2 0) familie ").assertText("(")
			.applyText().assertText("keyword", "\"Name\"", "Name")
			.append("keyword ").assertText("e1","e2")
			.applyText().assertText("e1","e2")
			.append("e2 ").assertText("k1","k2")
			.append("k").assertText("k1","k2",",",")")
			.append("1 ").assertText(",",")")
			.append("k2 ").assertText(",",")")
		;
	}

	public void testBetweenContext() throws Exception {
		newBuilder(setup.getRefGrammarSetup())
		.append("spielplatz 1 \"1\" {kind")
		.assertTextAtCursorPosition(18,"kind","erwachsener","spielzeug","familie","{", "}");
	}

	public void testComputeCompletionProposalsIgnoreCase() throws Exception {
		ContentAssistProcessorTestBuilder builder = newBuilder(setup.getRefGrammarSetup());
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
		builder.append(" familie ( keyword e1 e2 k1,K").assertText("k1", "k2",",", ")");
		builder.append(" familie ( keyword e1 e2 k1,k2").assertText("k2", ",", ")");
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
		newBuilder(setup.getXtextGrammarTestSetup())
			.appendNl("grammar foo")
			.appendNl("generate foo \"foo\"")
			.appendNl("R1 : (attr+=R2)*;")
			.appendNl("R2 : (attr=INT)? prop=R3;")
			.append("R3: attr+=").assertText(
					"R1",
					"R2",
					"R3",
					"\"Value\"",
					"(",
					"[",
					"+=" // current node is always a suggestion
			);
	}
	
	public void testCompleteAbstractRuleCall() throws Exception {
		newBuilder(setup.getContentAssistGrammarSetup())
			.appendNl("abstract rules")
			.appendNl("R1 ();")
			.append("R2 rule :").assertText(
					"R1",
					"R2",
					":" // current is always a suggestion
			);
	}

	public void testDefaultRule() throws Exception {
		ContentAssistProcessorTestBuilder builder = newBuilder(setup.getRefGrammarSetup());
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
        newBuilder(setup.getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("MyRule : 'foo' name=ID; ").assertText(
                                "Name", "terminal", "enum"
                );
    }
    
    public void testCompleteParserRule_02() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("")
                .appendNl("MyRule : 'foo' name=ID; ")
                .assertTextAtCursorPosition("MyRule",
                		"Name",
                		"terminal",
                		"enum",
                		"as",
                        "generate",
                        "import");
    }
    
    public void testCompleteParserRule_03() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("")
                .appendNl(" MyRule : 'foo' name=ID; ")
                .assertTextAtCursorPosition(" MyRule",
                		"Name",
                		"terminal",
                		"enum",
                		"as",
                        "generate",
                        "import");
    }
    
    public void _testCompleteGenerateKeyword() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .appendNl("generate foo \"foo\"")
                .appendNl("")
                .appendNl("MyRule : 'foo' name=ID; ")
                .assertTextAtCursorPosition("generate", 3,
                		"generate");
    }

    public void testCompleteImportAndGenerateRule() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
        .appendNl("grammar foo")
        .appendNl("generate foo \"foo\"")
        .appendNl("")
        .appendNl("R1 : (attr+=R2)*;")
        .appendNl("R2 : (attr=INT)? prop=R3;")
        .assertTextAtCursorPosition("R1",
                        "Name",
                        "as",
                        "generate",
                        "import",
                        "terminal",
                        "enum"
        );
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269593
     */
    public void testCompleteRuleCallWithSpace() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
        .appendNl("grammar foo")
        .appendNl("generate foo \"foo\"")
        .appendNl("R1 : (attr+=R2)*;")
        .appendNl("R2 : (attr=INT)? prop=R3;")
        .append("R3: attr+= ").assertText(
                        "R1",
                        "R2",
                        "R3",
                        "\"Value\"",
                        "(",
                        "["
        );
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269593
     */
    public void testCompleteAbstractRuleCallWithSpace() throws Exception {
        newBuilder(setup.getContentAssistGrammarSetup())
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
        newBuilder(setup.getXtextGrammarTestSetup())
        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
        .appendNl("generate meta \"url\"")
        .appendNl("Rule: name=ID;")
        .assertTextAtCursorPosition("generate", 3,"generate");
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    public void testCompletionOnDatatypeReference_01() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 2, "org.eclipse.xtext.common.Terminals");
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    public void testCompletionOnDatatypeReference_02() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 5, "org.eclipse.xtext.common.Terminals");
    }
    
    public void testCompletionOnSyntaxError_01() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate foo 'bar'")
	        .appendNl("grammarA: child=Rule;")
	        .appendNl("Rule: call=grammar")
	        .assertTextAtCursorPosition("=grammar", "=grammar".length(), "grammarA");
    }
    
    public void testCompletionOnSyntaxError_02() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate foo 'bar'")
	        .appendNl("grammarA: child=Rule;")
	        .append("Rule: call=grammar")
	        .assertText("grammarA");
    }
    
    public void testCompletionOnSyntaxError_03() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate foo 'bar'")
	        .appendNl("grammarA: child=Rule;")
	        .appendNl("Rule: call=grammar;")
	        .assertTextAtCursorPosition("grammar;", "grammar".length(), "grammarA");
    }

    /**
     * regression test for:
     *
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=260825
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=262313
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=267582
     */
    public void testCompleteAssignmentWithBacktracking() throws Exception {
    	newBuilder(setup.getXtextGrammarTestSetup())
        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
        .appendNl("generate foo \"foo\"")
        .append("MyRule : 'foo' name").assertText(
        		"\"Value\"",
        		"(",
        		"*",
        		"+",
        		"+=",
        		";",
        		"=",
        		"?",
        		"?=",
        		"{")
        .appendNl(";")
        .append("terminal Other_Id").assertText(":");

    }
    
    public void testCompleteGrammarName_01() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .append("grammar ")
        .assertCount(0);
    }
    
    public void testCompleteAfterGrammarName_01() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .append("grammar org.foo.bar")
        .assertCount(0);
    }
    
    public void testCompleteAfterGrammarName_02() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .append("grammar org.foo.bar ")
        .assertText("with", "Name", "enum", "terminal", "hidden", "generate", "import");
    }
    
    public void testCompleteAfterGenerateName_01() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.common.Terminals")
        .append("generate name ")
        .assertCount(EPackage.Registry.INSTANCE.size());
    }
    
    public void testCompleteAfterGenerateName_02() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.common.Terminals")
        .append("generate name \"")
        .assertCount(EPackage.Registry.INSTANCE.size());
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=270116
     * @throws Exception
     */
    public void testCompleteTypeRefReturnForEnumRule() throws Exception {
        doTestCompleteTypeRefSetup()
                .appendNl("enum NewEnum returns").assertText(
                                "Class", "Import","Model","NewEnum"
                );
    }
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=270116
     * @throws Exception
     */
	public void testCompleteTypeRefReturnForParserRule() throws Exception {
        doTestCompleteTypeRefSetup()
                .appendNl("NewType returns").assertText(
                                "Class", "Import","Model","NewType"
                );
    }
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=270116
     * @throws Exception
     */
    public void testCompleteTypeRefReturnForTerminalRule() throws Exception {
        doTestCompleteTypeRefSetup()
                .appendNl("terminal NewType returns").assertText(
                                "Class", "Import","Model"
                );
    }

    public void testKeywordWithBackslashes() throws Exception {
		newBuilder(setup.getKeywordsLangSetup()).assertText("foo\\bar", "foo\\", "\\bar", "\\");
	}
    
    public void testEnumCompletion_01() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).assertText("existing", "generated");
    }
    
    public void testEnumCompletion_02() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append("exi").assertText("existing");
    }
    
    public void testEnumCompletion_03() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append(" ").assertText("existing", "generated");
    }
    
    public void testEnumCompletion_04() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append("existing").assertText("existing");
    }
    
    public void testEnumCompletion_05() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append("existing ").assertText("SameName", "DifferentLiteral", "overridden");
    }
    
    public void testEnumCompletion_06() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append("existing Same").assertText("SameName");
    }
    
    public void testEnumCompletion_07() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append("generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    public void testEnumCompletion_08() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append(" generated SameName").assertTextAtCursorPosition(0, "existing", "generated");
    }
    
    public void testEnumCompletion_09() throws Exception {
    	newBuilder(setup.getEnumsLangSetup()).append(" generated SameName").assertTextAtCursorPosition(2, "generated");
    }
    
    public void testEnumCompletion_10() throws Exception {
    	newBuilder(setup.getXtextSetup())
    		.appendNl("grammar org.xtext.example.MyDsl1 with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate myDsl1 \"http://www.xtext.org/example/MyDsl1\"")
	        .appendNl("import 'classpath:/org/eclipse/xtext/enumrules/enums.ecore'")
	        .appendNl("enum ExistingEnum:")
	        .assertText("SameName", "DifferentName", "OverriddenLiteral");
    }
    
	protected ContentAssistProcessorTestBuilder newBuilder(ISetup standAloneSetup) throws Exception {
		with(standAloneSetup);
		return new ContentAssistProcessorTestBuilder(standAloneSetup, this);
	}

	private ContentAssistProcessorTestBuilder doTestCompleteTypeRefSetup() throws Exception {
		return newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.xtext.example.MyDsl1 with org.eclipse.xtext.common.Terminals")
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