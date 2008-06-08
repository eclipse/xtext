/*
Generated using Xtext at Sun Jun 08 11:15:27 CEST 2008
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ActionTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String ACTIONTESTLANGUAGE_GRAMMAR_CP_URI = "./src-gen/org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ActionTestLanguageGrammarAccess.class.getClassLoader(),ACTIONTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return ACTIONTESTLANGUAGE_GRAMMAR_CP_URI;
	}
   
}
