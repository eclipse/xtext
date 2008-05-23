package org.eclipse.xtext.dummy.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.LanguageFacadeFactory;

public class DummyLanguageASTFactory extends org.eclipse.xtext.parser.AbstractEcoreElementFactory {
	
	protected EPackage[] getEPackages(String alias) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/dummy/DummyLanguage").getGeneratedEPackages();
	}
}
