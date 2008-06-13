/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LookaheadLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String LOOKAHEADLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/LookaheadLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LookaheadLanguageGrammarAccess.class.getClassLoader(),LOOKAHEADLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return LOOKAHEADLANGUAGE_GRAMMAR_CP_URI;
	}
   
}
