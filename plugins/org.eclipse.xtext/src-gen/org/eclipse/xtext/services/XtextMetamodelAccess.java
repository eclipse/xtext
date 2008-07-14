/*
Generated with Xtext
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getXtextEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	protected static final String XTEXT_NS_URI = "http://www.eclipse.org/2008/Xtext";
	
	protected EPackage getXtextEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(XTEXT_NS_URI);
	}

	public EPackage[] getAllEPackages() {
		return getGeneratedEPackages();
	}
	
}
