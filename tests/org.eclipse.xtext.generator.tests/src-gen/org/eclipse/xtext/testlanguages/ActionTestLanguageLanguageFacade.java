package org.eclipse.xtext.testlanguages;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.testlanguages.parser.*;

public class ActionTestLanguageLanguageFacade extends org.eclipse.xtext.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/testlanguages/ActionTestLanguage";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String ACTIONTESTLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/ActionTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ActionTestLanguageLanguageFacade.class.getClassLoader(),ACTIONTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new ActionTestLanguageASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new ActionTestLanguageParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new ActionTestLanguageParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getActionLangEPackage()
		
		};
	}

	
	public static final String ACTIONLANG_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/ActionLang";
	public static final String ACTIONLANG_CP_URI = "org/eclipse/xtext/testlanguages/ActionLang.ecore";
	
	public static EPackage getActionLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(ACTIONLANG_NS_URI)) {
			EPackage p = loadEcoreFile(ActionTestLanguageLanguageFacade.class.getClassLoader(),ACTIONLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(ACTIONLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(ACTIONLANG_NS_URI);
	}
	

	private Resource.Factory resourceFactory = new ActionTestLanguageResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "actiontestlanguage";
	}
}
