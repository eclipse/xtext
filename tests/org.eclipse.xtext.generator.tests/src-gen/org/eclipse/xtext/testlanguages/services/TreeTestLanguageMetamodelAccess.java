/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TreeTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String TREETESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/TreeTestLanguage";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(TREETESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(TREETESTLANGUAGE_NS_URI, loadEcoreFile(TreeTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/TreeTestLanguage.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getTreeTestLanguageEPackage()
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
	    getTreeTestLanguageEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getTreeTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(TREETESTLANGUAGE_NS_URI);
	}
	
}
