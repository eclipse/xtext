/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class BaseInheritanceTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(BASEINHERITANCETEST_NS_URI))
			EPackage.Registry.INSTANCE.put(BASEINHERITANCETEST_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/grammarinheritance/baseInheritanceTest.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getBaseInheritanceTestEPackage()
		
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
	    getBaseInheritanceTestEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String BASEINHERITANCETEST_NS_URI = "http://www.eclipse.org/2009/tmf/xtext/BaseInheritanceTestLanguage";
	
	protected EPackage getBaseInheritanceTestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(BASEINHERITANCETEST_NS_URI);
	}
	
}
