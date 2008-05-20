package org.eclipse.xtext.parsetree.reconstr;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class ComplexReconstrTestConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String COMPLEXRECONSTRTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getComplexReconstrTestGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ComplexReconstrTestConstants.class.getClassLoader(),COMPLEXRECONSTRTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String COMPLEXREWRITETEST_NS_URI = "http://complex/rewrite/test";
	public static final String COMPLEXREWRITETEST_CP_URI = "org/eclipse/xtext/parsetree/reconstr/complexrewritetest.ecore";
	
	public static EPackage getcomplexrewritetestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(COMPLEXREWRITETEST_NS_URI)) {
			EPackage p = loadEcoreFile(ComplexReconstrTestConstants.class.getClassLoader(),COMPLEXREWRITETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(COMPLEXREWRITETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(COMPLEXREWRITETEST_NS_URI);
	}
	

}
