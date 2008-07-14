/*
Generated with Xtext
*/

package org.eclipse.xtext.services;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextGrammarTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String XTEXTGRAMMARTEST_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/XtextGrammarTest.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(XtextGrammarTestGrammarAccess.class.getClassLoader(),XTEXTGRAMMARTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	
	public ParserRule pr_Grammar() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.0"),true); 
	}

	public ParserRule pr_AbstractRule() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.1"),true); 
	}

	public ParserRule pr_AbstractMetamodelDeclaration() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.2"),true); 
	}

	public ParserRule pr_GeneratedMetamodel() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.3"),true); 
	}

	public ParserRule pr_ReferencedMetamodel() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.4"),true); 
	}

	public ParserRule pr_LexerRule() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.5"),true); 
	}

	public ParserRule pr_ParserRule() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.6"),true); 
	}

	public ParserRule pr_TypeRef() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.7"),true); 
	}

	public ParserRule pr_Alternatives() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.8"),true); 
	}

	public ParserRule pr_Group() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.9"),true); 
	}

	public ParserRule pr_AbstractToken() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.10"),true); 
	}

	public ParserRule pr_Assignment() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.11"),true); 
	}

	public ParserRule pr_Action() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.12"),true); 
	}

	public ParserRule pr_AbstractTerminal() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.13"),true); 
	}

	public ParserRule pr_ParenthesizedElement() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.14"),true); 
	}

	public ParserRule pr_Keyword() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.15"),true); 
	}

	public ParserRule pr_RuleCall() {
		return (ParserRule) getGrammar().eResource().getResourceSet().getEObject(URI.createURI("classpath:/org/eclipse/xtext/XtextGrammarTest.xmi#//@parserRules.16"),true); 
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
