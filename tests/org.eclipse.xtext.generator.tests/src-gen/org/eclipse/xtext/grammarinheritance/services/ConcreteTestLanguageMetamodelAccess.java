/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ConcreteTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	private EPackage[] generated = new EPackage[] {
		
		getFooEPackage()
		
		};

	public EPackage[] getGeneratedEPackages() {
		return generated;
	}

	private EPackage[] referenced = new EPackage[] {
		
		};
	public EPackage[] getReferencedEPackages() {
		return referenced;
	}
	
	private EPackage[] all = new EPackage[] {
	    getFooEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String FOO_NS_URI = "http://holla";
	
	protected EPackage getFooEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(FOO_NS_URI);
	}
	
}
