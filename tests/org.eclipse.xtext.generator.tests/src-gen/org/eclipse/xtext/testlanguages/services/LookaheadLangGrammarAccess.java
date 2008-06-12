/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LookaheadLangGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String LOOKAHEADLANG_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/LookaheadLang.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LookaheadLangGrammarAccess.class.getClassLoader(),LOOKAHEADLANG_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return LOOKAHEADLANG_GRAMMAR_CP_URI;
	}
   
}
