/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.XtextUiModule;
import org.eclipse.xtext.ui.common.service.UIPluginModule;
import org.eclipse.xtext.ui.common.tests.Activator;
import org.eclipse.xtext.ui.core.SimpleLabelProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextContentAssistTest extends AbstractContentAssistProcessorTest {
	
	public ISetup getXtextSetup() {
		return new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new XtextUiModule() {
					@Override
					public Class<? extends ILabelProvider> bindILabelProvider() {
						return SimpleLabelProvider.class;
					}
				}, new UIPluginModule(Activator.getInstance()));
			}
		};
	}
	
	/**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    public void testCompletionOnDatatypeReference_01() throws Exception {
        newBuilder(getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 2, "org.eclipse.xtext.common.Terminals", ",");
    }
    
    /**
     * https://bugs.eclipse.org/bugs/show_bug.cgi?id=269680
     */
    public void testCompletionOnDatatypeReference_02() throws Exception {
        newBuilder(getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 5, "org.eclipse.xtext.common.Terminals", ",");
    }
    
    public void testCompletionOnDatatypeReference_03() throws Exception {
        newBuilder(getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate meta \"url\"")
	        .appendNl("Rule: name=ID;")
	        .assertTextAtCursorPosition("org.eclipse.xtext", 4, "org.eclipse.xtext.common.Terminals");
    }
    
    public void testCompletionOnSyntaxError_01() throws Exception {
        newBuilder(getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate foo 'bar'")
	        .appendNl("grammarA: child=Rule;")
	        .appendNl("Rule: call=grammar")
	        .assertTextAtCursorPosition("=grammar", "=grammar".length(), "grammarA");
    }
    
    public void testCompletionOnSyntaxError_02() throws Exception {
        newBuilder(getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate foo 'bar'")
	        .appendNl("grammarA: child=Rule;")
	        .append("Rule: call=grammar")
	        .assertText("grammarA");
    }
    
    public void testCompletionOnSyntaxError_03() throws Exception {
        newBuilder(getXtextSetup())
	        .appendNl("grammar foo with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate foo 'bar'")
	        .appendNl("grammarA: child=Rule;")
	        .appendNl("Rule: call=grammar;")
	        .assertTextAtCursorPosition("grammar;", "grammar".length(), "grammarA");
    }

    public void testCompleteGrammarName_01() throws Exception {
    	newBuilder(getXtextSetup())
        .append("grammar ")
        .assertCount(0);
    }
    
    public void testCompleteAfterGrammarName_01() throws Exception {
    	newBuilder(getXtextSetup())
        .append("grammar org.foo.bar")
        .assertCount(0);
    }
    
    public void testCompleteAfterGrammarName_02() throws Exception {
    	newBuilder(getXtextSetup())
        .append("grammar org.foo.bar ")
        .assertText("with", "Name", "enum", "terminal", "hidden", "generate", "import");
    }
    
    public void testCompleteAfterGenerateName_01() throws Exception {
    	newBuilder(getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .append("generate name ")
        .assertCount(EPackage.Registry.INSTANCE.size());
    }
    
    public void testCompleteAfterGenerateName_02() throws Exception {
    	newBuilder(getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .append("generate name \"")
        .assertCount(EPackage.Registry.INSTANCE.size());
    }
    
    public void testCompleteCrossReference_01() throws Exception {
    	newBuilder(getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns ")
        .assertText("RuleA", "RuleB", "alias");
    }
    
    public void testCompleteCrossReference_02() throws Exception {
    	newBuilder(getXtextSetup())
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
    	newBuilder(getXtextSetup())
        .appendNl("grammar org.foo.bar with org.eclipse.xtext.common.Terminals")
        .appendNl("generate metamodelA 'http://foo.bar/A' as alias")
        .appendNl("generate metamodelB 'http://foo.bar/B'")
        .appendNl("RuleA: name=ID;")
        .append("RuleB returns alias")
        .assertText("alias", "::", ":");
    }
    
    public void testCompleteCrossReference_04() throws Exception {
    	newBuilder(getXtextSetup())
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
    
    public void testEnumCompletion_10() throws Exception {
    	newBuilder(getXtextSetup())
    		.appendNl("grammar org.xtext.example.MyDsl1 with org.eclipse.xtext.common.Terminals")
	        .appendNl("generate myDsl1 \"http://www.xtext.org/example/MyDsl1\"")
	        .appendNl("import 'classpath:/org/eclipse/xtext/enumrules/enumsUi.ecore'")
	        .appendNl("enum ExistingEnum:")
	        .assertText("SameName", "DifferentName", "OverriddenLiteral");
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
    
    private ContentAssistProcessorTestBuilder doTestCompleteTypeRefSetup() throws Exception {
		return newBuilder(getXtextSetup())
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
