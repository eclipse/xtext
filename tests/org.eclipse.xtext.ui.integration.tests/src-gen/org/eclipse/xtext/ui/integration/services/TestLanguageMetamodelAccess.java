/*
Generated with Xtext
*/
package org.eclipse.xtext.ui.integration.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String FOO_NS_URI = "http://foo";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(FOO_NS_URI))
			EPackage.Registry.INSTANCE.put(FOO_NS_URI, loadEcoreFile(TestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/ui/integration/foo.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

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
	
	protected EPackage getFooEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(FOO_NS_URI);
	}
	
}
