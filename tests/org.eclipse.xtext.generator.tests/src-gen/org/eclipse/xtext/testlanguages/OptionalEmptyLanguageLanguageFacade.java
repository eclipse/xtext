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

public class OptionalEmptyLanguageLanguageFacade extends org.eclipse.xtext.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/testlanguages/OptionalEmptyLanguage";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String OPTIONALEMPTYLANGUAGE_GRAMMAR_CP_URI = "org/eclipse/xtext/testlanguages/OptionalEmptyLanguage.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(OptionalEmptyLanguageLanguageFacade.class.getClassLoader(),OPTIONALEMPTYLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new OptionalEmptyLanguageASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new OptionalEmptyLanguageParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new OptionalEmptyLanguageParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getOptionalEmptyEPackage()
		
		};
	}

	
	public static final String OPTIONALEMPTY_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/OptionalEmpty";
	public static final String OPTIONALEMPTY_CP_URI = "org/eclipse/xtext/testlanguages/OptionalEmpty.ecore";
	
	public static EPackage getOptionalEmptyEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(OPTIONALEMPTY_NS_URI)) {
			EPackage p = loadEcoreFile(OptionalEmptyLanguageLanguageFacade.class.getClassLoader(),OPTIONALEMPTY_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(OPTIONALEMPTY_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(OPTIONALEMPTY_NS_URI);
	}
	

	private Resource.Factory resourceFactory = new OptionalEmptyLanguageResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "optionalemptylanguage";
	}
}
