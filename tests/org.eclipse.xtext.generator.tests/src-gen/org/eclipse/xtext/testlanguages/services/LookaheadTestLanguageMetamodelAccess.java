/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LookaheadTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String LOOKAHEADLANG_NS_URI = "http://www.eclipse.org/2008/xtext/LookaheadLang";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(LOOKAHEADLANG_NS_URI))
			EPackage.Registry.INSTANCE.put(LOOKAHEADLANG_NS_URI, loadEcoreFile(LookaheadTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/LookaheadLang.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getLookaheadLangEPackage()
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
	    getLookaheadLangEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getLookaheadLangEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(LOOKAHEADLANG_NS_URI);
	}
	
}
