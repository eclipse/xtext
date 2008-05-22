package org.eclipse.xtext.dummy.parser.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.dummy.DummyLanguageTokenTypes;
import org.eclipse.xtext.*;
import org.eclipse.xtext.core.parser.ITokenTypes;
import org.eclipse.xtext.core.parser.ParseException;
import org.eclipse.xtext.core.parsetree.AbstractNode;

public class DummyLanguageTokenTypeResolver {

	public static LexerRule getLexerRule(AbstractNode context, int antlrTokenType) {
		switch(antlrTokenType) {		
		

		case 4:
			// RULE_ID
			return BuiltinRules.BUILTIN_ID;

		case 9:
			// RULE_INT
			return BuiltinRules.BUILTIN_INT;

		case 8:
			// RULE_WS
			return BuiltinRules.BUILTIN_WS;

		case 6:
			// RULE_SL_COMMENT
			return BuiltinRules.BUILTIN_SL_COMMENT;

		case 11:
			// RULE_ANY_OTHER
			return BuiltinRules.BUILTIN_ANY_OTHER;


		case 7:
			// RULE_LEXER_BODY
			return BuiltinRules.BUILTIN_LEXER_BODY;

		case 10:
			// RULE_ML_COMMENT
			return BuiltinRules.BUILTIN_ML_COMMENT;


		case 5:
			// RULE_STRING
			return BuiltinRules.BUILTIN_STRING;

		default:
			return null;
		}	
	}
	
	@SuppressWarnings("unused")
	private static EObject getGrammarElement(String id) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/dummy/DummyLanguage").getGrammar().eResource().getEObject(id);
	}
	
}
