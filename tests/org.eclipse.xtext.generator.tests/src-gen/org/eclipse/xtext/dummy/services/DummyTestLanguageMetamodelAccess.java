/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class DummyTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String DUMMYLANG_NS_URI = "http://www.eclipse.org/2008/xtext/DummyLang";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(DUMMYLANG_NS_URI))
			EPackage.Registry.INSTANCE.put(DUMMYLANG_NS_URI, loadEcoreFile(DummyTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/dummy/DummyLang.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getDummyLangEPackage()
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
	    getDummyLangEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getDummyLangEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(DUMMYLANG_NS_URI);
	}
	
}
