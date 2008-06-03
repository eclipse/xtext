package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextFactory;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;

public class XtextBuiltinLanguageFacade implements ILanguageFacade {
	public static final String ID = "XtextBuiltIn";
	private Grammar g;

	public IElementFactory getElementFactory() {
		return null;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] { EcorePackage.eINSTANCE };
	}
	
	{
		XtextFactory f = XtextFactory.eINSTANCE;
		g = f.createGrammar();
		g.getIdElements().add(ID);
		ReferencedMetamodel ecoremm = f.createReferencedMetamodel();
		ecoremm.setAlias("ecore");
		ecoremm.setUri("'"+EcorePackage.eNS_URI+"'");//TODO remove the single quotes 
		g.getMetamodelDeclarations().add(ecoremm);
		
		LexerRule l = null;
		
		l = f.createLexerRule();
		l.setName("ID");
		l.setBody("('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*");
		g.getLexerRules().add(l);
		l = f.createLexerRule();
		l.setName("INT");
		l.setBody("('0'..'9')+");
		g.getLexerRules().add(l);
		l = f.createLexerRule();
		l.setName("STRING");
		l.setBody("'\"' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\"') )* '\"' | "+
		          "'\\'' ( '\\\\' ('b'|'t'|'n'|'f'|'r'|'\\\"'|'\\''|'\\\\') | ~('\\\\'|'\\'') )* '\\''");
		g.getLexerRules().add(l);
		l = f.createLexerRule();
		l.setName("ML_COMMENT");
		l.setBody("'/*' ( options {greedy=false;} : . )* '*/' {$channel=HIDDEN;}");
		g.getLexerRules().add(l);
		l = f.createLexerRule();
		l.setName("SL_COMMENT");
		l.setBody("'//' ~('\\n'|'\\r')* '\\r'? '\\n' {$channel=HIDDEN;}");
		g.getLexerRules().add(l);
		l = f.createLexerRule();
		l.setName("WS");
		l.setBody("(' '|'\\t'|'\\r'|'\\n')+ {$channel=HIDDEN;}");
		g.getLexerRules().add(l);
		l = f.createLexerRule();
		l.setName("LEXER_BODY");
		l.setBody("'<#' '.'* '#>'");
		g.getLexerRules().add(l);
		l = f.createLexerRule();
		l.setName("ANY_OTHER");
		l.setBody(".");
		g.getLexerRules().add(l);
	}

	public Grammar getGrammar() {
		return g;
	}

	public String getLanguageId() {
		return ID;
	}

	public String getModelFileExtension() {
		return null;
	}

	public IParser getParser() {
		return null;
	}

	public IParseTreeConstructor getParsetreeConstructor() {
		return null;
	}

	public Factory getResourceFactory() {
		return null;
	}

}
