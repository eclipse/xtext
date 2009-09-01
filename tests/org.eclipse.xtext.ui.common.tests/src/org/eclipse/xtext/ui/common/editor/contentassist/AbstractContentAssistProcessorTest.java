/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestPackage;
import org.eclipse.xtext.ui.common.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.XtextContentAssistProcessor;

import com.google.common.collect.Sets;

/**
 * Unit test for class <code>DefaultContentAssistProcessor</code>. Reused by Xtend implementation.
 *
 * @author Michael Clay - Initial contribution and API
 * @author Jan Koehnlein
 * @see org.eclipse.xtext.ui.common.editor.contentassist.impl.DefaultContentAssistProcessor
 */
public abstract class AbstractContentAssistProcessorTest extends AbstractXtextTests {

	protected IContentAssistProcessorTestSetup setup;
	
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
			.append(",k2 ").assertText(",",")")
		;
	}
	
	public void testComputeCompletionProposalsText_02() throws Exception {
		newBuilder(setup.getRefGrammarSetup()).
			append("spielplatz 1 \"Beschreibung\" { " +
					"erwachsener ( e1 1 ) " +
					"erwachsener (e2 0) " +
					"kind ( k1 1 ) " +
					"kind (k2 0) " +
					"familie ( keyword e1 e2 k1, k2 ").assertText(",",")")
		;
	}
	
	public void testComputeCompletionProposalsText_03() throws Exception {
		newBuilder(setup.getRefGrammarSetup()).
			append("spielplatz 1 \"Beschreibung\" { " +
					"erwachsener ( e1 1 ) " +
					"erwachsener (e2 0) " +
					"kind ( k1 1 ) " +
					"kind (k2 0) " +
					"familie ( keyword e1 e2 k1 k2 ").assertText() // parse error, cannot propose something
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
    
    public void testCompleteReturnsKeyword_01() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .append("MyRule r").assertText(
                                "returns"
                );
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
        .assertTextAtCursorPosition("generate", 3,
        		"generate",
        		":" // as 'gen' is a parser rule, 'hidden' and 'returns' would conflict with rulename
        		);
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    public void testCompletionOnDatatypeReference_01() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 2, "org.eclipse.xtext.common.Terminals", ",");
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    public void testCompletionOnDatatypeReference_02() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 5, "org.eclipse.xtext.common.Terminals", ",");
    }
    
    public void testCompletionOnDatatypeReference_03() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 4, "org.eclipse.xtext.common.Terminals");
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
        		"{",
        		"|")
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
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .append("generate name ")
        .assertCount(EPackage.Registry.INSTANCE.size());
    }
    
    public void testCompleteAfterGenerateName_02() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .append("generate name \"")
        .assertCount(EPackage.Registry.INSTANCE.size());
    }
    
    public void testCompleteCrossReference_01() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns ")
        .assertText("RuleA", "RuleB", "alias");
    }
    
    public void testCompleteCrossReference_02() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns a")
        .assertText(
        		"alias",
        		"::",
        		":",
        		"a" // has already been infered as type in metamodelA
        );
    }
    
    public void testCompleteCrossReference_03() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns alias")
        .assertText("alias", "::", ":");
    }
    
    public void testCompleteCrossReference_04() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns alias:")
        .assertText(
        		"::",
        		":",
        		"Feature",
        		"\"Value\"",
        		"RuleA",
        		"RuleB",
        		"ID",
        		"STRING",
        		"INT",
        		"SL_COMMENT",
        		"WS",
        		"ML_COMMENT",
        		"ANY_OTHER",
        		"(",
        		"{");
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
		newBuilder(setup.getKeywordsLangSetup()).assertText(
				"foo\\bar", "foo\\", "\\bar", "\\",
				"\"a\"", "'b'", "'c'", "\"d\"");
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
    
    public void testBug276742_01() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	        .assertText("A1", "B1");
    }
    
    public void testBug276742_02() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
    		.append("A1")
	        .assertText("A1");
    }
    
    public void testBug276742_03() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 ")
	    	.assertText("A1", "A2", "Name");
    }
    
    public void testBug276742_04() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A")
	    	.assertText("A1");
    }
    
    public void testBug276742_05() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 A1")
	    	.assertText("A1");
    }
    
    public void testBug276742_06() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 A")
	    	.assertText(/* "A", */ "A1", "A2");
    }
    
    public void testBug276742_07() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 A A2")
	    	.assertText("A2");
    }
    
    public void testBug276742_08() throws Exception {
    	newBuilder(setup.getCrossReferenceProposalTestLanguageSetup())
	    	.append("Foo {}")
	    	.assertText("Foo", "Name", "}");
    }
    
    public void testBug276742_08b() throws Exception {
    	String modelAsString = "Foo {}";
		ContentAssistProcessorTestBuilder builder = newBuilder(setup.getCrossReferenceProposalTestLanguageSetup());
    	XtextContentAssistProcessor processor = get(XtextContentAssistProcessor.class);
    	XtextResource resource = getResourceFromString(modelAsString);
    	
    	ITextViewer viewer = builder.getTextViewer(modelAsString, builder.getDocument(resource, modelAsString));
    	ContentAssistContext[] contexts = processor.getContextFactory().create(viewer, modelAsString.length(), resource);
    	assertEquals(2, contexts.length);
    	Set<EClass> contextTypes = Sets.newHashSet(
    			CrossReferenceProposalTestPackage.Literals.MODEL,
    			CrossReferenceProposalTestPackage.Literals.CLASS
    	);
    	CrossReferenceProposalTestLanguageGrammarAccess grammarAccess = get(CrossReferenceProposalTestLanguageGrammarAccess.class);
    	for(ContentAssistContext context: contexts) {
    		EObject model = context.getCurrentModel();
    		assertTrue(contextTypes.remove(model.eClass()));
    		if (context.getFirstSetGrammarElements().contains(grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3())) {
    			assertEquals(CrossReferenceProposalTestPackage.Literals.CLASS, model.eClass());
    		} else {
    			assertEquals(CrossReferenceProposalTestPackage.Literals.MODEL, model.eClass());
    		}
    	}
    }
    
    public void testBug276742_09() throws Exception {
    	newBuilder(setup.getCrossReferenceProposalTestLanguageSetup())
	    	.append("Foo {}")
	    	.assertTextAtCursorPosition(0, "Foo", "Name");
    }
    
    public void testBug276742_09b() throws Exception {
    	String modelAsString = "Foo {}";
		ContentAssistProcessorTestBuilder builder = newBuilder(setup.getCrossReferenceProposalTestLanguageSetup());
    	XtextContentAssistProcessor processor = get(XtextContentAssistProcessor.class);
    	XtextResource resource = getResourceFromString(modelAsString);
    	
    	ITextViewer viewer = builder.getTextViewer(modelAsString, builder.getDocument(resource, modelAsString));
    	ContentAssistContext[] contexts = processor.getContextFactory().create(viewer, 0, resource);
    	assertEquals(1, contexts.length);
    	for(ContentAssistContext context: contexts) {
   			assertEquals(CrossReferenceProposalTestPackage.Literals.MODEL, context.getCurrentModel().eClass());
    	}
    }
    
    public void testBug276742_10() throws Exception {
    	newBuilder(setup.getCrossReferenceProposalTestLanguageSetup())
	    	.assertText("Name");
    }
    
    public void testBug281198_01() throws Exception {
    	newBuilder(setup.getDatatypeRuleTestLanguageSetup())
    		.append("Types\n" +
    				"Type StringType;\n" +
    				"Composite error base ")
    		.assertText("StringType", "error");
    }
    
    public void testBug282031_01() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("( values1 ")
    		.assertText("=", ")", "Value", "Name");
    }
    
    public void testBug282031_02() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("(")
    		.assertText("(", ")", "Value", "Name");
    }
    
    public void testBug282031_03() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("( ")
    		.assertText(")", "Value", "Name");
    }
    
    public void testBug282031_04() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("( values1")
    		.assertText("=", ")");
    }
    
    public void testBug282031_05() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("[ values1 ")
    		.assertText("]", "Value", "Name");
    }
    
    public void testBug282031_06() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("[")
    		.assertText("[", "Value");
    }
    
    public void testBug282031_07() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("[ ")
    		.assertText("Value");
    }
    
    public void testBug282031_08() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("[ values1")
    		.assertText("]");
    }
    
    public void testBug282031_09() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("< values1 ")
    		.assertText("=", "Value", "Name");
    }
    
    public void testBug282031_10() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("<")
    		.assertText("<", "Value", "Name");
    }
    
    public void testBug282031_11() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("< ")
    		.assertText("Value", "Name");
    }
    
    public void testBug282031_12() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("< values1")
    		.assertText("=");
    }
    
    public void testBug282031_13() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("{ values1 ")
    		.assertText("Value", "Name");
    }
    
    public void testBug282031_14() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("{")
    		.assertText("{", "Value");
    }
    
    public void testBug282031_15() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("{ ")
    		.assertText("Value");
    }
    
    public void testBug282031_16() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("{ values1")
    		.assertText();
    }
    
    public void testBug286935_01() throws Exception {
    	newBuilder(setup.getBug286935TestLanguageSetup())
    		.append("init cond")
    		.assertText("cond", "\"Label\"");
    }
    
    public void testBug286935_02() throws Exception {
    	newBuilder(setup.getBug286935TestLanguageSetup())
    		.append("init cond ")
    		.assertText("state", 
    				"stateName", 
    				"\"Label\"", 
    				"final");
    }
    
    public void testBug287941_01() throws Exception {
    	newBuilder(setup.getBug287941TestLanguageSetup()).append(
    			"import \"classpath:/org/eclipse/xtext/ui/common/editor/contentassist/Bug287941TestModel.ecore\"\n" + 
    			"select t from Test as t \n" + 
    			"	where t. testAttr like \"\"").assertTextAtCursorPosition("t. testAttr", 3, "testAttr", "testRef");
    }
    
    public void testBug287941_02() throws Exception {
    	newBuilder(setup.getBug287941TestLanguageSetup()).append(
    			"import \"classpath:/org/eclipse/xtext/ui/common/editor/contentassist/Bug287941TestModel.ecore\"\n" + 
    			"select t from Test as t \n" + 
    			"	where t.testAttr like \"\"").assertTextAtCursorPosition("t.testAttr", 2, "testAttr", "testRef", ".");
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