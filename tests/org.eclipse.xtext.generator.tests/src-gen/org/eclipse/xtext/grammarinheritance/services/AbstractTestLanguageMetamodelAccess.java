/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class AbstractTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

}

	private EPackage[] generated = new EPackage[] {
		
		};

	public EPackage[] getGeneratedEPackages() {
		return generated;
	}

	private EPackage[] referenced = new EPackage[] {
		
		BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/xtext/tests/grammarinheritance")
		,
		BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
		
		};
	public EPackage[] getReferencedEPackages() {
		return referenced;
	}
	
	private EPackage[] all = new EPackage[] {
	    BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore"),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/xtext/tests/grammarinheritance")
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
}
