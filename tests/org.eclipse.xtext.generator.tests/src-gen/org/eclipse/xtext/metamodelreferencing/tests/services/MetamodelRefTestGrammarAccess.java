/*
Generated with Xtext
*/

package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class MetamodelRefTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String METAMODELREFTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(MetamodelRefTestGrammarAccess.class.getClassLoader(),METAMODELREFTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return METAMODELREFTEST_GRAMMAR_CP_URI;
	}
	
	
   
}
