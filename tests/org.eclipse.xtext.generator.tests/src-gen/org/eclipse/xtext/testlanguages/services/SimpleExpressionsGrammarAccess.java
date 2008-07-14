/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleExpressionsGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String SIMPLEEXPRESSIONS_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleExpressionsGrammarAccess.class.getClassLoader(),SIMPLEEXPRESSIONS_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	
	public ParserRule pr_Sequence() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.0"),true); 
	}

	public ParserRule pr_Addition() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.1"),true); 
	}

	public ParserRule pr_Multiplication() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.2"),true); 
	}

	public ParserRule pr_Term() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.3"),true); 
	}

	public ParserRule pr_Atom() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.4"),true); 
	}

	public ParserRule pr_Parens() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/testlanguages/SimpleExpressions.xmi#//@parserRules.5"),true); 
	}

	
	public LexerRule lr_ID() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.0"),true); 
	}

	public LexerRule lr_INT() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.1"),true); 
	}

	public LexerRule lr_STRING() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.2"),true); 
	}

	public LexerRule lr_ML_COMMENT() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.3"),true); 
	}

	public LexerRule lr_SL_COMMENT() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.4"),true); 
	}

	public LexerRule lr_WS() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.5"),true); 
	}

	public LexerRule lr_ANY_OTHER() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.6"),true); 
	}

   
}
