package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class XtextGrammarTestConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String XTEXTGRAMMARTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/XtextGrammarTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getXtextGrammarTestGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(XtextGrammarTestConstants.class.getClassLoader(),XTEXTGRAMMARTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String XTEXTTEST_NS_URI = "http://www.eclipse.org/2008/Test/XtextTest";
	public static final String XTEXTTEST_CP_URI = "org/eclipse/xtext/XtextTest.ecore";
	
	public static EPackage getXtextTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXTTEST_NS_URI)) {
			EPackage p = loadEcoreFile(XtextGrammarTestConstants.class.getClassLoader(),XTEXTTEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(XTEXTTEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(XTEXTTEST_NS_URI);
	}
	

}
