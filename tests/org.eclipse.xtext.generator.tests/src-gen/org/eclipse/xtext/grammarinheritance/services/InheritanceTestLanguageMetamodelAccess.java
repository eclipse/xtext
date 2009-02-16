/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class InheritanceTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(INHERITANCETEST_NS_URI))
			EPackage.Registry.INSTANCE.put(INHERITANCETEST_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/grammarinheritance/inheritanceTest.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getInheritanceTestEPackage()
		
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
	    getInheritanceTestEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String INHERITANCETEST_NS_URI = "http://www.eclipse.org/2009/tmf/xtext/InheritanceTestLanguage";
	
	protected EPackage getInheritanceTestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(INHERITANCETEST_NS_URI);
	}
	
}
