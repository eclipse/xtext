/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class OptionalEmptyLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String OPTIONALEMPTYLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(OptionalEmptyLanguageGrammarAccess.class.getClassLoader(),OPTIONALEMPTYLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return OPTIONALEMPTYLANGUAGE_GRAMMAR_CP_URI;
	}
	
	
   
}
