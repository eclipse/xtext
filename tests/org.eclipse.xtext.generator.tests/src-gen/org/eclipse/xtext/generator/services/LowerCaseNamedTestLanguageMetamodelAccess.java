/*
Generated with Xtext
*/
package org.eclipse.xtext.generator.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LowerCaseNamedTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String LOWERCASENAMEDTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2009/tmf/xtext/lowerCaseNamedTestLanguage";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(LOWERCASENAMEDTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(LOWERCASENAMEDTESTLANGUAGE_NS_URI, loadEcoreFile(LowerCaseNamedTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getLowerCaseNamedTestLanguageEPackage()
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
	    getLowerCaseNamedTestLanguageEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getLowerCaseNamedTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(LOWERCASENAMEDTESTLANGUAGE_NS_URI);
	}
	
}
