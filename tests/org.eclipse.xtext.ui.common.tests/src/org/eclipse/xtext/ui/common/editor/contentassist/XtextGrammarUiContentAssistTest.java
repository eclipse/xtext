/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextGrammarUiTestLanguageStandaloneSetup;
import org.eclipse.xtext.XtextGrammarUiTestLanguageUiModule;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;
import org.eclipse.xtext.ui.junit.editor.contentassist.AbstractContentAssistProcessorTest;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextGrammarUiContentAssistTest extends AbstractContentAssistProcessorTest {

	public ISetup getXtextGrammarTestSetup() {
		return new XtextGrammarUiTestLanguageStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextGrammarUiTestLanguageUiModule(), new UIPluginModule(Activator.getInstance()));
			}
		};
	}

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
					"\"Value\"",
					"(",
					"[",
					"+=" // current node is always a suggestion
			);
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
                                "Name", "terminal", "enum"
                );
    }
    
    public void testCompleteParserRule_02() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
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
        newBuilder(getXtextGrammarTestSetup())
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
        newBuilder(getXtextGrammarTestSetup())
                .appendNl("grammar foo")
                .append("MyRule r").assertText(
                                "returns"
                );
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
        newBuilder(getXtextGrammarTestSetup())
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
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269649
     */
    public void testCompletionOnGenerateKeyword() throws Exception {
        newBuilder(getXtextGrammarTestSetup())
        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
        .appendNl("generate meta \"url\"")
        .appendNl("Rule: name=ID;")
        .assertTextAtCursorPosition("generate", 3,
        		"generate",
        		":" // as 'gen' is a parser rule, 'hidden' and 'returns' would conflict with rulename
        		);
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
}
