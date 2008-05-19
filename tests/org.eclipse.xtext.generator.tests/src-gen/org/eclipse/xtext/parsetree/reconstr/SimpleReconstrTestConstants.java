package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class SimpleReconstrTestConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String SIMPLERECONSTRTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/parsetree/reconstr/SimpleReconstrTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getSimpleReconstrTestGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleReconstrTestConstants.class.getClassLoader(),SIMPLERECONSTRTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String SIMPLEREWRITETEST_NS_URI = "http://simple/rewrite/test";
	public static final String SIMPLEREWRITETEST_CP_URI = "org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore";
	
	public static EPackage getsimplerewritetestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEREWRITETEST_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleReconstrTestConstants.class.getClassLoader(),SIMPLEREWRITETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLEREWRITETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEREWRITETEST_NS_URI);
	}
	

}
