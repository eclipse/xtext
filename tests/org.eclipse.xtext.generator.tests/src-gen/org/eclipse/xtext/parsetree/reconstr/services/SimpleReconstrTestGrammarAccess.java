/*
Generated with Xtext
*/

package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleReconstrTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String SIMPLERECONSTRTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleReconstrTestGrammarAccess.class.getClassLoader(),SIMPLERECONSTRTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return SIMPLERECONSTRTEST_GRAMMAR_CP_URI;
	}
	
	
   
}
