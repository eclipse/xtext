/*
Generated using Xtext at Fri Jun 06 17:58:54 CEST 2008
*/

package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleTest2GrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String SIMPLETEST2_GRAMMAR_CP_URI = "./src-gen/org/eclipse/xtext/grammargen/tests/SimpleTest2.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleTest2GrammarAccess.class.getClassLoader(),SIMPLETEST2_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return SIMPLETEST2_GRAMMAR_CP_URI;
	}
   
}
