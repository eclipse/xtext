package org.eclipse.xtext.dummy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class DummyLanguageConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String DUMMYLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/dummy/DummyLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getDummyLanguageGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(DummyLanguageConstants.class.getClassLoader(),DUMMYLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String DUMMYLANG_NS_URI = "http://www.eclipse.org/2008/xtext/DummyLang";
	public static final String DUMMYLANG_CP_URI = "org/eclipse/xtext/dummy/DummyLang.ecore";
	
	public static EPackage getDummyLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(DUMMYLANG_NS_URI)) {
			EPackage p = loadEcoreFile(DummyLanguageConstants.class.getClassLoader(),DUMMYLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(DUMMYLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(DUMMYLANG_NS_URI);
	}
	

}
