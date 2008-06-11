/*
Generated with Xtext
*/

package org.eclipse.xtext.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String XTEXT_GRAMMAR_CP_URI = "org/eclipse/xtext/Xtext.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(XtextGrammarAccess.class.getClassLoader(),XTEXT_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return XTEXT_GRAMMAR_CP_URI;
	}
   
}
