/*
Generated with Xtext
*/

package org.eclipse.xtext.builtin;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextBuiltinGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public final static XtextBuiltinGrammarAccess INSTANCE = new XtextBuiltinGrammarAccess();

	private static final String XTEXTBUILTIN_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi";
	private static Grammar GRAMMAR = null;
	private static LexerRule lID;
	private static LexerRule lINT;
	private static LexerRule lSTRING;
	private static LexerRule lML_COMMENT;
	private static LexerRule lSL_COMMENT;
	private static LexerRule lWS;
	private static LexerRule lANY_OTHER;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(XtextBuiltinGrammarAccess.class.getClassLoader(),XTEXTBUILTIN_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public IGrammarAccess getSuperGrammar() {
		return null;		
	}

	
	// lexer ID : "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*" ;
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) getGrammar().eContents().get(1));
	} 

	// lexer INT returns EInt : "(\'0\'..\'9\')+" ;
	public LexerRule lrINT() {
		return (lINT != null) ? lINT : (lINT = (LexerRule) getGrammar().eContents().get(2));
	} 

	// lexer STRING : "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              " ;
	public LexerRule lrSTRING() {
		return (lSTRING != null) ? lSTRING : (lSTRING = (LexerRule) getGrammar().eContents().get(3));
	} 

	// lexer ML_COMMENT : "\'/*\' ( options {greedy=false;} : . )* \'*/\'" ;
	public LexerRule lrML_COMMENT() {
		return (lML_COMMENT != null) ? lML_COMMENT : (lML_COMMENT = (LexerRule) getGrammar().eContents().get(4));
	} 

	// lexer SL_COMMENT : "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?" ;
	public LexerRule lrSL_COMMENT() {
		return (lSL_COMMENT != null) ? lSL_COMMENT : (lSL_COMMENT = (LexerRule) getGrammar().eContents().get(5));
	} 

	// lexer WS : "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+" ;
	public LexerRule lrWS() {
		return (lWS != null) ? lWS : (lWS = (LexerRule) getGrammar().eContents().get(6));
	} 

	// lexer ANY_OTHER : "." ;
	public LexerRule lrANY_OTHER() {
		return (lANY_OTHER != null) ? lANY_OTHER : (lANY_OTHER = (LexerRule) getGrammar().eContents().get(7));
	} 
}
