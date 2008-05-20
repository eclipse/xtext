package org.eclipse.xtext.dummy;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.dummy.parser.*;

public class DummyLanguageLanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/dummy/DummyLanguage";
	public static final String DUMMYLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/dummy/DummyLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(DummyLanguageLanguageFacade.class.getClassLoader(),DUMMYLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new DummyLanguageASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new DummyLanguageParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new DummyLanguageParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getDummyLangEPackage()
		
		};
	}

	
	public static final String DUMMYLANG_NS_URI = "http://www.eclipse.org/2008/xtext/DummyLang";
	public static final String DUMMYLANG_CP_URI = "org/eclipse/xtext/dummy/DummyLang.ecore";
	
	public static EPackage getDummyLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(DUMMYLANG_NS_URI)) {
			EPackage p = loadEcoreFile(DummyLanguageLanguageFacade.class.getClassLoader(),DUMMYLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(DUMMYLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(DUMMYLANG_NS_URI);
	}
	

}
