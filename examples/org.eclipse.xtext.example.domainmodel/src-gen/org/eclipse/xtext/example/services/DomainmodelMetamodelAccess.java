/*
Generated with Xtext
*/
package org.eclipse.xtext.example.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class DomainmodelMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String DOMAINMODEL_NS_URI = "http://www.example.xtext/Domainmodel";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(DOMAINMODEL_NS_URI))
			EPackage.Registry.INSTANCE.put(DOMAINMODEL_NS_URI, loadEcoreFile(DomainmodelMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/example/domainmodel.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getDomainmodelEPackage()
	};

	public EPackage[] getGeneratedEPackages() {
		return generated;
	}

	private EPackage[] referenced = new EPackage[] {
		BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
	};
	
	public EPackage[] getReferencedEPackages() {
		return referenced;
	}
	
	private EPackage[] all = new EPackage[] {
	    getDomainmodelEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getDomainmodelEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(DOMAINMODEL_NS_URI);
	}
	
}
