package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.testlanguages.parser.*;

public class LexerLanguageLanguageFacade extends BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/testlanguages/LexerLanguage";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String LEXERLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/LexerLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
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

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
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
	

	private Resource.Factory resourceFactory = new LexerLanguageResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "lexerlanguage";
	}
}
