/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class PartialParserTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String PARTIALPARSERTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(PartialParserTestLanguageGrammarAccess.class.getClassLoader(),PARTIALPARSERTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	
	public ParserRule pr_Container() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.0"),true); 
	}

	public ParserRule pr_Nested() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.1"),true); 
	}

	public ParserRule pr_Content() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.2"),true); 
	}

	public ParserRule pr_Children() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.3"),true); 
	}

	public ParserRule pr_Child() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.4"),true); 
	}

	public ParserRule pr_AbstractChildren() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.5"),true); 
	}

	public ParserRule pr_AbstractChild() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.6"),true); 
	}

	public ParserRule pr_FirstConcrete() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.7"),true); 
	}

	public ParserRule pr_SecondConcrete() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.8"),true); 
	}

	public ParserRule pr_Named() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/PartialParserTestLanguage.xmi#//@rules.9"),true); 
	}

	
	public LexerRule lr_ID() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@rules.0"),true); 
	}

	public LexerRule lr_INT() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@rules.1"),true); 
	}

	public LexerRule lr_STRING() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@rules.2"),true); 
	}

	public LexerRule lr_ML_COMMENT() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@rules.3"),true); 
	}

	public LexerRule lr_SL_COMMENT() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@rules.4"),true); 
	}

	public LexerRule lr_WS() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@rules.5"),true); 
	}

	public LexerRule lr_ANY_OTHER() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@rules.6"),true); 
	}

   
}
