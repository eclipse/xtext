/*
Generated using Xtext at Fri Jun 06 17:58:59 CEST 2008
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LexerLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String LEXERLANGUAGE_GRAMMAR_CP_URI = "./src-gen/org/eclipse/xtext/testlanguages/LexerLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LexerLanguageGrammarAccess.class.getClassLoader(),LEXERLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return LEXERLANGUAGE_GRAMMAR_CP_URI;
	}
   
}
