package org.eclipse.xtext.test;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.test.parser.*;

public class TestLanguageLanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/test/TestLanguage";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String TESTLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/test/TestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(TestLanguageLanguageFacade.class.getClassLoader(),TESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new TestLanguageASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new TestLanguageParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new TestLanguageParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getTestLangEPackage()
		
		};
	}

	
	public static final String TESTLANG_NS_URI = "http://www.eclipse.org/2008/xtext/TestLang";
	public static final String TESTLANG_CP_URI = "org/eclipse/xtext/test/TestLang.ecore";
	
	public static EPackage getTestLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(TESTLANG_NS_URI)) {
			EPackage p = loadEcoreFile(TestLanguageLanguageFacade.class.getClassLoader(),TESTLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(TESTLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(TESTLANG_NS_URI);
	}
	

}
