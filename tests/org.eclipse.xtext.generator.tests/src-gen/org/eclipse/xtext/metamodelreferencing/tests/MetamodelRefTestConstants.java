package org.eclipse.xtext.metamodelreferencing.tests;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Grammar;

public class MetamodelRefTestConstants extends org.eclipse.xtext.core.parser.BaseEPackageAccess {
	public static final String METAMODELREFTEST_GRAMMAR_CP_URI = "org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest.xmi";
	private static Grammar GRAMMAR = null;
	
	public static Grammar getMetamodelRefTestGrammar() {	
		if (GRAMMAR==null) {
			GRAMMAR = (Grammar) loadGrammarFile(MetamodelRefTestConstants.class.getClassLoader(),METAMODELREFTEST_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	

	
	public static final String SIMPLETEST_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest";
	public static final String SIMPLETEST_CP_URI = "org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore";
	
	public static EPackage getSimpleTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST_NS_URI)) {
			EPackage p = loadEcoreFile(MetamodelRefTestConstants.class.getClassLoader(),SIMPLETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST_NS_URI);
	}
	

}
