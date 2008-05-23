package org.eclipse.xtext.grammargen.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.IElementFactory;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.grammargen.tests.parser.*;

public class SimpleTestLanguageFacade extends BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/grammargen/tests/SimpleTest";
    public String getLanguageId() {
    	return LANGUAGE_ID;
    }
    
	public static final String SIMPLETEST_GRAMMAR_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest.xmi";
	private static Grammar GRAMMAR = null;
	
	@SuppressWarnings("unused")
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(SimpleTestLanguageFacade.class.getClassLoader(),SIMPLETEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new SimpleTestASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new SimpleTestParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new SimpleTestParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getSimpleTestEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String SIMPLETEST_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest";
	public static final String SIMPLETEST_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest.ecore";
	
	public static EPackage getSimpleTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleTestLanguageFacade.class.getClassLoader(),SIMPLETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST_NS_URI);
	}
	

	private Resource.Factory resourceFactory = new SimpleTestResourceFactory(this);
	public Resource.Factory getResourceFactory() {
		return resourceFactory;
	}
	
	public String getModelFileExtension() {
		return "simpletest";
	}
}
