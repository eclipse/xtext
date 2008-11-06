/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ReferenceGrammarGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String REFERENCEGRAMMAR_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ReferenceGrammarGrammarAccess.class.getClassLoader(),REFERENCEGRAMMAR_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	
	public ParserRule pr_Spielplatz() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.0"),true); 
	}

	public ParserRule pr_Person() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.1"),true); 
	}

	public ParserRule pr_Kind() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.2"),true); 
	}

	public ParserRule pr_Erwachsener() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.3"),true); 
	}

	public ParserRule pr_Spielzeug() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.4"),true); 
	}

	public ParserRule pr_Farbe() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.5"),true); 
	}

	public ParserRule pr_Familie() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.xmi#//@rules.6"),true); 
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
