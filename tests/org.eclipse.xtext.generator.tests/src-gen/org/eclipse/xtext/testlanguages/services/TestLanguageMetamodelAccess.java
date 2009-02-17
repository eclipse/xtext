/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String TESTLANG_NS_URI = "http://www.eclipse.org/2008/xtext/TestLang";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(TESTLANG_NS_URI))
			EPackage.Registry.INSTANCE.put(TESTLANG_NS_URI, loadEcoreFile(TestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/TestLang.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getTestLangEPackage()
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
	    getTestLangEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getTestLangEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(TESTLANG_NS_URI);
	}
	
}
