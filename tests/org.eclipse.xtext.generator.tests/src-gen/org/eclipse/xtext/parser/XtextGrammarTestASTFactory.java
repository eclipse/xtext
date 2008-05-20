package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.LanguageFacadeFactory;

public class XtextGrammarTestASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	
	protected EPackage[] getEPackages(String alias) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/XtextGrammarTest").getGeneratedEPackages();
	}
}
