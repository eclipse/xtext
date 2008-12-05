package org.eclipse.xtext.builtin;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextBuiltinGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public final static XtextBuiltinGrammarAccess INSTANCE = new XtextBuiltinGrammarAccess();
	
	private static final String XTEXT_BUILTIN_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/builtin/XtextBuiltin.xmi";
	private static Grammar GRAMMAR = null;
	
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			GRAMMAR = (Grammar) loadGrammarFile(XtextBuiltinGrammarAccess.class.getClassLoader(),XTEXT_BUILTIN_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	public IGrammarAccess getSuperGrammar() {
		return null;
	}

}
