package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class SimpleExpressionsConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String SIMPLEEXPRESSIONS_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/SimpleExpressions.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getSimpleExpressionsGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleExpressionsConstants.class.getClassLoader(),SIMPLEEXPRESSIONS_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String SIMPLEEXPRESSIONS_NS_URI = "http://www.eclipse.org/xtext/test/simpleExpressions";
	public static final String SIMPLEEXPRESSIONS_CP_URI = "org/eclipse/xtext/testlanguages/simpleExpressions.ecore";
	
	public static EPackage getsimpleExpressionsEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEEXPRESSIONS_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleExpressionsConstants.class.getClassLoader(),SIMPLEEXPRESSIONS_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLEEXPRESSIONS_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEEXPRESSIONS_NS_URI);
	}
	

}
