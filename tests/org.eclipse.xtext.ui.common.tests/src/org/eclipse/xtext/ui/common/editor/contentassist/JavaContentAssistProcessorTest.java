/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.contentassist.crossReferenceProposalTest.CrossReferenceProposalTestPackage;
import org.eclipse.xtext.ui.core.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.core.editor.contentassist.XtextContentAssistProcessor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaContentAssistProcessorTest extends AbstractContentAssistProcessorTest {

	@Override
	protected JavaContentAssistProcessorTestSetup createSetup() {
		return new JavaContentAssistProcessorTestSetup();
	}
	
	/**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269649
     */
    @Override
	public void testCompletionOnGenerateKeyword() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
        .appendNl("generate meta \"url\"")
        .appendNl("Rule: name=ID;")
        .assertTextAtCursorPosition("generate", 3,
        		"generate"
//        		":"
        		);
    }
	
	@Override
	public void testComputeCompletionProposalsText_03() throws Exception {
		newBuilder(setup.getRefGrammarSetup()).
			append("spielplatz 1 \"Beschreibung\" { " +
					"erwachsener ( e1 1 ) " +
					"erwachsener (e2 0) " +
					"kind ( k1 1 ) " +
					"kind (k2 0) " +
					"familie ( keyword e1 e2 k1 k2 ").assertText(",",")") // minor parse errors can be handled
		;
	}
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    @Override
	public void testCompletionOnDatatypeReference_01() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 2, "org.eclipse.xtext.common.Terminals" /*, "," */); // lookahead has not been taken into account
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    @Override
	public void testCompletionOnDatatypeReference_02() throws Exception {
        newBuilder(setup.getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 5, "org.eclipse.xtext.common.Terminals" /*, "," */); // lookahead has not been taken into account
    }
    
    @Override
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
        		"{"
//        		"|" // lookahead cannot be computed correctly
        		)
        .appendNl(";")
        .append("terminal Other_Id").assertText(":");
    }
    
    @Override
	public void testCompleteReturnsKeyword_01() throws Exception {
        newBuilder(setup.getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .append("MyRule r").assertText(
                                "returns",
                                // expect to many proposals due to lookahead issues
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
                        		"|"
                );
    }
    
    @Override
	public void testBug276742_03() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 ")
//	    	.assertText("A1", "A2", "Name")
	    ;
    }
    
    @Override
	public void testBug276742_05() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 A1")
//	    	.assertText("A1");
	    ;
    }
    
    @Override
	public void testBug276742_06() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 A")
//	    	.assertText(/* "A", */ "A1", "A2")
	    ;
    }
    
    @Override
	public void testBug276742_07() throws Exception {
    	newBuilder(setup.getContentAssistContextTestLanguageSetup())
	    	.append("A1 A A2")
//	    	.assertText("A2")
	    ;
    }
    
    @Override
	public void testBug276742_08b() throws Exception {
    	String modelAsString = "Foo {}";
		ContentAssistProcessorTestBuilder builder = newBuilder(setup.getCrossReferenceProposalTestLanguageSetup());
    	XtextContentAssistProcessor processor = get(XtextContentAssistProcessor.class);
    	XtextResource resource = getResourceFromString(modelAsString);
    	
    	ITextViewer viewer = builder.getTextViewer(modelAsString, builder.getDocument(resource, modelAsString));
    	ContentAssistContext[] contexts = processor.getContextFactory().create(viewer, modelAsString.length(), resource);
    	assertEquals(2, contexts.length);
    	for(ContentAssistContext context: contexts) {
    		EObject model = context.getCurrentModel();
    		// CLASS is current model in any case
			assertEquals(CrossReferenceProposalTestPackage.Literals.CLASS, model.eClass());
    	}
    }
    
    @Override
	public void testCompleteCrossReference_02() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns a")
        .assertText(
        		"alias",
//        		"::",
        		":",
        		"a" // has already been infered as type in metamodelA
        );
    }
    
    @Override
	public void testCompleteCrossReference_03() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns alias")
        .assertText("alias", /* "::", */ ":");
    }
    
    @Override
	public void testCompleteCrossReference_04() throws Exception {
    	newBuilder(setup.getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns alias:")
        .assertText(
//        		"::",
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
    
    @Override
	public void testBug282031_01() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("( values1 ")
    		.assertText("="
    				// , ")", "Value", "Name"
    		);
    }
    
    @Override
	public void testBug282031_04() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("( values1")
    		.assertText("="
    				// , ")"
    		);
    }
    
    @Override
	public void testBug282031_05() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("[ values1 ")
    		.assertText(//"]", 
    				"Value"
    				//, "Name"
    		);
    }
    
    @Override
	public void testBug282031_08() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("[ values1")
    		.assertText(//"]"
    				);
    }
    
    @Override
	public void testBug282031_09() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("< values1 ")
    		.assertText("="
    				//, "Value", "Name"
    			);
    }
    
    @Override
	public void testBug282031_13() throws Exception {
    	newBuilder(setup.getLookAheadContentAssistTestLanguageSetup())
    		.append("{ values1 ")
    		.assertText("Value"
    				//, "Name"
    		);
    }
    
    @Override
	public void testBug286935_01() throws Exception {
    	newBuilder(setup.getBug286935TestLanguageSetup())
    		.append("init cond")
    		.assertText("cond"); // "\"Label\"" will not be proposed
    }
    
    @Override
	public void testBug286935_02() throws Exception {
    	newBuilder(setup.getBug286935TestLanguageSetup())
    		.append("init cond ")
    		.assertText("state", 
    				"stateName", 
    				"\"Label\""); // "final" will not be proposed
    }
    
    @Override
	public void testBug287941_01() throws Exception {
    	newBuilder(setup.getBug287941TestLanguageSetup()).append(
    			"import \"classpath:/org/eclipse/xtext/ui/common/editor/contentassist/Bug287941TestModel.ecore\"\n" + 
    			"select t from Test as t \n" + 
    			"	where t. testAttr like \"\"").assertTextAtCursorPosition("t. testAttr", 3, "testAttr");
    }
    
    @Override
	public void testBug287941_02() throws Exception {
    	newBuilder(setup.getBug287941TestLanguageSetup()).append(
    			"import \"classpath:/org/eclipse/xtext/ui/common/editor/contentassist/Bug287941TestModel.ecore\"\n" + 
    			"select t from Test as t \n" + 
    			"	where t.testAttr like \"\"").assertTextAtCursorPosition("t.testAttr", 2, "testAttr", ".");
    }
    
    @Override
	public void testBug288734_03() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("constant ").assertText();
    }
    
    @Override
	public void testBug288734_09() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc ").assertText();
    }
    
    @Override
	public void testBug288734_10() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc 'Name' ").assertText();
    }
    
    @Override
	public void testBug288734_11() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc 'Name' @desc").assertText();
    }
    
    @Override
	public void testBug288734_12() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc 'Name' @desc ").assertText();
    }
    
    @Override
	public void testBug288734_13() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc 'Name' constant").assertText();
    }
    
    @Override
	public void testBug288734_14() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc 'Name' constant ").assertText();
    }
    
    @Override
	public void testBug288734_15() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc 'Name' @desc 'Name' constant").assertText();
    }
    
    @Override
	public void testBug288734_16() throws Exception {
    	newBuilder(setup.getBug288734TestLanguageSetup()).append("@desc 'Name' @desc 'Name' constant ").assertText();
    }
}
