package org.eclipse.xtext.grammargen.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.grammargen.tests.parser.*;

public class SimpleTest2LanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/grammargen/tests/SimpleTest2";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String SIMPLETEST2_GRAMMAR_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest2.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleTest2LanguageFacade.class.getClassLoader(),SIMPLETEST2_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new SimpleTest2ASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new SimpleTest2Parser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new SimpleTest2ParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getSimpleTest2EPackage()
		
		};
	}

	
	public static final String SIMPLETEST2_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest2";
	public static final String SIMPLETEST2_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest2.ecore";
	
	public static EPackage getSimpleTest2EPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST2_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleTest2LanguageFacade.class.getClassLoader(),SIMPLETEST2_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST2_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST2_NS_URI);
	}
	

	private Resource.Factory resourceFactory = new SimpleTest2ResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "simpletest2";
	}
}
