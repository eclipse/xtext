/*
Generated with Xtext
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextGrammarTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String XTEXTTEST_NS_URI = "http://www.eclipse.org/2008/Test/XtextTest";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXTTEST_NS_URI))
			EPackage.Registry.INSTANCE.put(XTEXTTEST_NS_URI, loadEcoreFile(XtextGrammarTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/XtextTest.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getXtextTestEPackage()
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
	    getXtextTestEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getXtextTestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(XTEXTTEST_NS_URI);
	}
	
}
