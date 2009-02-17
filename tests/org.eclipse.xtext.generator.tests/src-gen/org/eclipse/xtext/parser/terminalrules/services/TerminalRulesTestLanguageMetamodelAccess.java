/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TerminalRulesTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String TERMINALRULESTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/TerminalRulesTest";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(TERMINALRULESTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(TERMINALRULESTESTLANGUAGE_NS_URI, loadEcoreFile(TerminalRulesTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parser/terminalrules/TerminalRulesTestLanguage.ecore"));
	}

	static {
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getTerminalRulesTestLanguageEPackage()
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
	    getTerminalRulesTestLanguageEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getTerminalRulesTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(TERMINALRULESTESTLANGUAGE_NS_URI);
	}
	
}
