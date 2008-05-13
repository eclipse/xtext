package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EPackage;

public class XtextFactory extends org.eclipse.xtext.core.parser.AbstractEcoreElementFactory {
	private EPackage[] ePackages = new EPackage[] {
	
		org.eclipse.xtext.XtextEPackageAccess.getxtextEPackage()
	
	};
	protected EPackage[] getEPackages(String alias) {
		return ePackages;
	}
}
