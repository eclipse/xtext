/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ConcreteTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String FOO_NS_URI = "http://holla";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(FOO_NS_URI))
			EPackage.Registry.INSTANCE.put(FOO_NS_URI, loadEcoreFile(ConcreteTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/grammarinheritance/foo.ecore"));
	}

	static {
		org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getFooEPackage()
	};

	public EPackage[] getGeneratedEPackages() {
		return generated;
	}

	private EPackage[] referenced = new EPackage[] {
		BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/xtext/tests/grammarinheritance")
	};
	
	public EPackage[] getReferencedEPackages() {
		return referenced;
	}
	
	private EPackage[] all = new EPackage[] {
	    getFooEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/xtext/tests/grammarinheritance")
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getFooEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(FOO_NS_URI);
	}
	
}
