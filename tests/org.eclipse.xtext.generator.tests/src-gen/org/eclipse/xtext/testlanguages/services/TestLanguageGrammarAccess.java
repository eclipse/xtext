/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String TESTLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/TestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(TestLanguageGrammarAccess.class.getClassLoader(),TESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return TESTLANGUAGE_GRAMMAR_CP_URI;
	}
	
	
   
}
