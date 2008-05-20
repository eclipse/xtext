package org.eclipse.xtext.testlanguages.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.LanguageFacadeFactory;

public class SimpleExpressionsASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	
	protected EPackage[] getEPackages(String alias) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/SimpleExpressions").getGeneratedEPackages();
	}
}
