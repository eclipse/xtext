/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ComplexReconstrTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String COMPLEXRECONSTRTEST_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ComplexReconstrTestGrammarAccess.class.getClassLoader(),COMPLEXRECONSTRTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return COMPLEXRECONSTRTEST_GRAMMAR_CP_URI;
	}
	
	
	public ParserRule pr_Op() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.0"),true); 
	}

	public ParserRule pr_Term() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.1"),true); 
	}

	public ParserRule pr_Atom() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.2"),true); 
	}

	public ParserRule pr_Parens() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi#//@parserRules.3"),true); 
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

	public LexerRule lr_LEXER_BODY() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.6"),true); 
	}

	public LexerRule lr_ANY_OTHER() {
		return (LexerRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi#//@lexerRules.7"),true); 
	}

   
}
