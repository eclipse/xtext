package org.eclipse.xtext.grammargen.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class SimpleTestConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String SIMPLETEST_GRAMMAR_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getSimpleTestGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleTestConstants.class.getClassLoader(),SIMPLETEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String SIMPLETEST_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest";
	public static final String SIMPLETEST_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest.ecore";
	
	public static EPackage getSimpleTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleTestConstants.class.getClassLoader(),SIMPLETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST_NS_URI);
	}
	

}
