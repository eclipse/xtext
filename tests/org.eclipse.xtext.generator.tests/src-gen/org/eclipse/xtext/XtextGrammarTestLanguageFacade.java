package org.eclipse.xtext;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parser.*;

public class XtextGrammarTestLanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/XtextGrammarTest";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String XTEXTGRAMMARTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/XtextGrammarTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(XtextGrammarTestLanguageFacade.class.getClassLoader(),XTEXTGRAMMARTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new XtextGrammarTestASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new XtextGrammarTestParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new XtextGrammarTestParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getXtextTestEPackage()
		
		};
	}

	
	public static final String XTEXTTEST_NS_URI = "http://www.eclipse.org/2008/Test/XtextTest";
	public static final String XTEXTTEST_CP_URI = "org/eclipse/xtext/XtextTest.ecore";
	
	public static EPackage getXtextTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXTTEST_NS_URI)) {
			EPackage p = loadEcoreFile(XtextGrammarTestLanguageFacade.class.getClassLoader(),XTEXTTEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(XTEXTTEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(XTEXTTEST_NS_URI);
	}
	

	private Resource.Factory resourceFactory = new XtextGrammarTestResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "xtextgrammartest";
	}
}
