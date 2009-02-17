/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class InheritanceTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String INHERITANCETEST_NS_URI = "http://www.eclipse.org/2009/tmf/xtext/InheritanceTestLanguage";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(INHERITANCETEST_NS_URI))
			EPackage.Registry.INSTANCE.put(INHERITANCETEST_NS_URI, loadEcoreFile(InheritanceTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/grammarinheritance/inheritanceTest.ecore"));
	}

	static {
		org.eclipse.xtext.grammarinheritance.services.BaseInheritanceTestLanguageMetamodelAccess.init();
		init();
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
	
	protected EPackage getInheritanceTestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(INHERITANCETEST_NS_URI);
	}
	
}
