/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class AbstractTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		BaseEPackageAccess.getEPackageFromRegistry("classpath:/org/eclipse/xtext/grammarinheritance/ametamodel.ecore")
		
		};
	}

	
}
