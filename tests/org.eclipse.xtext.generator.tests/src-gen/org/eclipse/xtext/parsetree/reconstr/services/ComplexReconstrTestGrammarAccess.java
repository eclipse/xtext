package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.xtext.service.*;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ComplexReconstrTestGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {

	private static final String COMPLEXRECONSTRTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ComplexReconstrTestGrammarAccess.class.getClassLoader(),COMPLEXRECONSTRTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public String getGrammarClasspathURI() {
		return COMPLEXRECONSTRTEST_GRAMMAR_CP_URI;
	}
   
}
