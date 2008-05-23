package org.eclipse.xtext.testlanguages.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.LanguageFacadeFactory;

public class ActionTestLanguageASTFactory extends org.eclipse.xtext.parser.AbstractEcoreElementFactory {
	
	protected EPackage[] getEPackages(String alias) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/testlanguages/ActionTestLanguage").getGeneratedEPackages();
	}
}
