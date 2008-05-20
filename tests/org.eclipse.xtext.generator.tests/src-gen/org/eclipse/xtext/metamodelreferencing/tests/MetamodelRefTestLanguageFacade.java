package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ILanguageFacade;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.core.parser.IElementFactory;
import org.eclipse.xtext.core.parser.IParser;
import org.eclipse.xtext.core.parsetree.IParseTreeConstructor;
import org.eclipse.xtext.metamodelreferencing.tests.parser.*;

public class MetamodelRefTestLanguageFacade extends org.eclipse.xtext.core.parser.BaseEPackageAccess implements ILanguageFacade {
    public static final String LANGUAGE_ID = "org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest";
	public static final String METAMODELREFTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(MetamodelRefTestLanguageFacade.class.getClassLoader(),METAMODELREFTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	private IElementFactory factory = new MetamodelRefTestASTFactory();
	public IElementFactory getElementFactory() {
		return factory;
	}
	private IParser parser = new MetamodelRefTestParser();
	public IParser getParser() {
		return parser;
	}
	
	private IParseTreeConstructor constructor = new MetamodelRefTestParseTreeConstructor();
	public IParseTreeConstructor getParsetreeConstructor() {
		return constructor;
	}

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getSimpleTestEPackage()
		
		};
	}

	
	public static final String SIMPLETEST_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest";
	public static final String SIMPLETEST_CP_URI = "org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore";
	
	public static EPackage getSimpleTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST_NS_URI)) {
			EPackage p = loadEcoreFile(MetamodelRefTestLanguageFacade.class.getClassLoader(),SIMPLETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST_NS_URI);
	}
	

}
