/*
Generated with Xtext
*/

package org.eclipse.xtext.dummy.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class DummyLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String DUMMYLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/dummy/DummyLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(DummyLanguageGrammarAccess.class.getClassLoader(),DUMMYLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return DUMMYLANGUAGE_GRAMMAR_CP_URI;
	}
	
	
   
}
