package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class ActionTestLanguageConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String ACTIONTESTLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getActionTestLanguageGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ActionTestLanguageConstants.class.getClassLoader(),ACTIONTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String ACTIONLANG_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/ActionLang";
	public static final String ACTIONLANG_CP_URI = "org/eclipse/xtext/testlanguages/ActionLang.ecore";
	
	public static EPackage getActionLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(ACTIONLANG_NS_URI)) {
			EPackage p = loadEcoreFile(ActionTestLanguageConstants.class.getClassLoader(),ACTIONLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(ACTIONLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(ACTIONLANG_NS_URI);
	}
	

}
