package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.ReferencedMetamodel;
import org.eclipse.xtext.XtextFactory;

public class XtextBuiltinGrammarAccess implements IGrammarAccess {
	private Grammar g;
	{
		XtextFactory f = XtextFactory.eINSTANCE;
		g = f.createGrammar();
		g.getIdElements().add(IXtextBuiltin.ID);
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

}
