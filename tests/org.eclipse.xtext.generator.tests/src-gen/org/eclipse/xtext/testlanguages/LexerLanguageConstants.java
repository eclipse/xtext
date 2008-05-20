package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;

public class LexerLanguageConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String LEXERLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/LexerLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getLexerLanguageGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LexerLanguageConstants.class.getClassLoader(),LEXERLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String TESTLANG_NS_URI = "http://www.eclipse.org/2008/xtext/LexerLang";
	public static final String TESTLANG_CP_URI = "org/eclipse/xtext/testlanguages/TestLang.ecore";
	
	public static EPackage getTestLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(TESTLANG_NS_URI)) {
			EPackage p = loadEcoreFile(LexerLanguageConstants.class.getClassLoader(),TESTLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(TESTLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(TESTLANG_NS_URI);
	}
	

}
