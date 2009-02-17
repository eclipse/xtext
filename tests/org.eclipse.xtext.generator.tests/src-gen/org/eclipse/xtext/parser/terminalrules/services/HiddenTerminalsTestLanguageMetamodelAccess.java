/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class HiddenTerminalsTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String HIDDENTERMINALSTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/HiddenTerminalsTest";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(HIDDENTERMINALSTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(HIDDENTERMINALSTESTLANGUAGE_NS_URI, loadEcoreFile(HiddenTerminalsTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parser/terminalrules/HiddenTerminalsTestLanguage.ecore"));
	}

	static {
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getHiddenTerminalsTestLanguageEPackage()
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
	    getHiddenTerminalsTestLanguageEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getHiddenTerminalsTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(HIDDENTERMINALSTESTLANGUAGE_NS_URI);
	}
	
}
