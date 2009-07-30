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
package org.eclipse.xtext;

import org.eclipse.emf.mwe.core.WorkflowFacade;
import org.eclipse.xtext.dummy.DummyTestLanguage;
import org.eclipse.xtext.grammarinheritance.AbstractTestLanguage;
import org.eclipse.xtext.grammarinheritance.BaseInheritanceTestLanguage;
import org.eclipse.xtext.grammarinheritance.ConcreteTestLanguage;
import org.eclipse.xtext.grammarinheritance.InheritanceTestLanguage;
import org.eclipse.xtext.linking.ImportUriTestLanguage;
import org.eclipse.xtext.linking.LangATestLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.MetamodelRefTestLanguage;
import org.eclipse.xtext.metamodelreferencing.tests.MultiGenMMTestLanguage;
import org.eclipse.xtext.parser.datatyperules.DatatypeRulesTestLanguage;
import org.eclipse.xtext.parser.epatch.EpatchTestLanguage;
import org.eclipse.xtext.parser.keywords.KeywordsTestLanguage;
import org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage;
import org.eclipse.xtext.parser.terminalrules.TerminalRulesTestLanguage;
import org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguage;
import org.eclipse.xtext.parsetree.formatter.FormatterTestLanguage;
import org.eclipse.xtext.parsetree.reconstr.ComplexReconstrTestLanguage;
import org.eclipse.xtext.parsetree.reconstr.SimpleReconstrTestLanguage;
import org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest;
import org.eclipse.xtext.testlanguages.ActionTestLanguage;
import org.eclipse.xtext.testlanguages.ContentAssistTestLanguage;
import org.eclipse.xtext.testlanguages.FowlerDslTestLanguage;
import org.eclipse.xtext.testlanguages.LexerTestLanguage;
import org.eclipse.xtext.testlanguages.LookaheadTestLanguage;
import org.eclipse.xtext.testlanguages.OptionalEmptyTestLanguage;
import org.eclipse.xtext.testlanguages.PartialParserTestLanguage;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguage;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguage;
import org.eclipse.xtext.testlanguages.TestLanguage;
import org.eclipse.xtext.testlanguages.TreeTestLanguage;
import org.eclipse.xtext.valueconverter.Bug250313;
import org.eclipse.xtext.xtext.ecoreInference.MultiValueFeatureTestLanguage;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class GenerateAllTestGrammars {

	public static void main(String... args) {
		try {
			new WorkflowFacade("org/eclipse/xtext/GenerateAllTestLanguages.mwe").run();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
	
	public static Class<?>[] getTestGrammarClasses() { return new Class[] {
			LangATestLanguage.class,
			AbstractTestLanguage.class,
			ConcreteTestLanguage.class,
			XtextGrammarTestLanguage.class,
			MetamodelRefTestLanguage.class,
			MultiGenMMTestLanguage.class,
			DummyTestLanguage.class,
			TestLanguage.class,
			SimpleReconstrTestLanguage.class,
			ComplexReconstrTestLanguage.class,
			LexerTestLanguage.class,
			SimpleExpressionsTestLanguage.class,
			ActionTestLanguage.class,
			OptionalEmptyTestLanguage.class,
			ReferenceGrammarTestLanguage.class,
			LookaheadTestLanguage.class,
			Bug250313.class,
			FowlerDslTestLanguage.class,
			TreeTestLanguage.class,
			ImportUriTestLanguage.class,
			PartialParserTestLanguage.class,
			ContentAssistTestLanguage.class,
			TransientValuesTest.class,
			FormatterTestLanguage.class,
			DatatypeRulesTestLanguage.class,
			MultiValueFeatureTestLanguage.class,
			TerminalRulesTestLanguage.class,
			XtextTerminalsTestLanguage.class,
			HiddenTerminalsTestLanguage.class,
			EpatchTestLanguage.class,
			KeywordsTestLanguage.class,
			BaseInheritanceTestLanguage.class,
			InheritanceTestLanguage.class
		};
	}

	/**
	 * @param param
	 * @return
	 */
	public static String getGrammarFileName(Class<?> param) {
		return param.getName().replace('.', '/')+".xtext";
	}

}
