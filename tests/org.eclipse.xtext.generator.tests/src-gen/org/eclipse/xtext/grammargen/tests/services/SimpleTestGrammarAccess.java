/*
Generated with Xtext
*/

package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String SIMPLETEST_GRAMMAR_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleTestGrammarAccess.class.getClassLoader(),SIMPLETEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return SIMPLETEST_GRAMMAR_CP_URI;
	}
   
}
