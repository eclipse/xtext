/*
Generated with Xtext
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String XTEXT_NS_URI = "http://www.eclipse.org/2008/Xtext";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXT_NS_URI))
			EPackage.Registry.INSTANCE.put(XTEXT_NS_URI, loadEcoreFile(XtextMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/xtext.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getXtextEPackage()
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
	    getXtextEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getXtextEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(XTEXT_NS_URI);
	}
	
}
