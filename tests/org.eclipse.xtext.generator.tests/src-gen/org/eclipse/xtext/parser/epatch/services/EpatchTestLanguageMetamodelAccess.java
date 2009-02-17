/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class EpatchTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String EPATCHTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/EpatchTestLanguage";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(EPATCHTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(EPATCHTESTLANGUAGE_NS_URI, loadEcoreFile(EpatchTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getEpatchTestLanguageEPackage()
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
	    getEpatchTestLanguageEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getEpatchTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(EPATCHTESTLANGUAGE_NS_URI);
	}
	
}
