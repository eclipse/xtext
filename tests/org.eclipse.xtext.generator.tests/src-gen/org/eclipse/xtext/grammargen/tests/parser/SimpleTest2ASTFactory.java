package org.eclipse.xtext.grammargen.tests.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.LanguageFacadeFactory;

public class SimpleTest2ASTFactory extends org.eclipse.xtext.parser.AbstractEcoreElementFactory {
	
	protected EPackage[] getEPackages(String alias) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/grammargen/tests/SimpleTest2").getGeneratedEPackages();
	}
}
