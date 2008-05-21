package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parser.*;

public class LexerLanguageLanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/testlanguages/LexerLanguage";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String LEXERLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/LexerLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LexerLanguageLanguageFacade.class.getClassLoader(),LEXERLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new LexerLanguageASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new LexerLanguageParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new LexerLanguageParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getLexerLangEPackage()
		
		};
	}

	
	public static final String LEXERLANG_NS_URI = "http://www.eclipse.org/2008/xtext/LexerLang";
	public static final String LEXERLANG_CP_URI = "org/eclipse/xtext/testlanguages/LexerLang.ecore";
	
	public static EPackage getLexerLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(LEXERLANG_NS_URI)) {
			EPackage p = loadEcoreFile(LexerLanguageLanguageFacade.class.getClassLoader(),LEXERLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(LEXERLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(LEXERLANG_NS_URI);
	}
	

}
