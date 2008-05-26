package org.eclipse.xtext.parser.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.XtextTokenTypes;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.ITokenTypes;
import org.eclipse.xtext.parser.ParseException;
import org.eclipse.xtext.parsetree.AbstractNode;

public class XtextTokenTypeResolver {

	public static LexerRule getLexerRule(AbstractNode context, int antlrTokenType) {
		switch(antlrTokenType) {		
		


		case 8:
			// RULE_INT
			return BuiltinRules.BUILTIN_INT;




		case 7:
			// RULE_ML_COMMENT
			return BuiltinRules.BUILTIN_ML_COMMENT;



		case 9:
			// RULE_SL_COMMENT
			return BuiltinRules.BUILTIN_SL_COMMENT;



		case 6:
			// RULE_LEXER_BODY
			return BuiltinRules.BUILTIN_LEXER_BODY;




		case 4:
			// RULE_ID
			return BuiltinRules.BUILTIN_ID;



		case 11:
			// RULE_ANY_OTHER
			return BuiltinRules.BUILTIN_ANY_OTHER;









		case 10:
			// RULE_WS
			return BuiltinRules.BUILTIN_WS;

		case 5:
			// RULE_STRING
			return BuiltinRules.BUILTIN_STRING;

		default:
			return null;
		}	
	}
	
	@SuppressWarnings("unused")
	private static EObject getGrammarElement(String id) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/Xtext").getGrammar().eResource().getEObject(id);
	}
	
}
