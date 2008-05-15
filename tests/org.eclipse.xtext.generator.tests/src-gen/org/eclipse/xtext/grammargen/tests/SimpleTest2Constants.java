package org.eclipse.xtext.grammargen.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class SimpleTest2Constants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String SIMPLETEST2_GRAMMAR_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest2.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getSimpleTest2Grammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleTest2Constants.class.getClassLoader(),SIMPLETEST2_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String SIMPLETEST2_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest2";
	public static final String SIMPLETEST2_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest2.ecore";
	
	public static EPackage getSimpleTest2EPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST2_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleTest2Constants.class.getClassLoader(),SIMPLETEST2_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST2_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST2_NS_URI);
	}
	

}
