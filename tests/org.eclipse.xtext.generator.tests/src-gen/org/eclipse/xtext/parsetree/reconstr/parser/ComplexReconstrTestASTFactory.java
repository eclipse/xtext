package org.eclipse.xtext.parsetree.reconstr.parser;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.LanguageFacadeFactory;

public class ComplexReconstrTestASTFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	
	protected EPackage[] getEPackages(String alias) {
		return LanguageFacadeFactory.getFacade("org/eclipse/xtext/parsetree/reconstr/ComplexReconstrTest").getGeneratedEPackages();
	}
}
