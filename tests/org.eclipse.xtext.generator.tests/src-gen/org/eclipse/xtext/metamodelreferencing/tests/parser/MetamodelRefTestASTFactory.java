package org.eclipse.xtext.metamodelreferencing.tests.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.LanguageFacadeFactory;

public class MetamodelRefTestASTFactory extends org.eclipse.xtext.parser.AbstractEcoreElementFactory {
	
	protected EPackage[] getEPackages(String alias) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTest").getGeneratedEPackages();
	}
}
