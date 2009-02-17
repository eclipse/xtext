/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LexerTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String LEXERLANG_NS_URI = "http://www.eclipse.org/2008/xtext/LexerLang";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(LEXERLANG_NS_URI))
			EPackage.Registry.INSTANCE.put(LEXERLANG_NS_URI, loadEcoreFile(LexerTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/LexerLang.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getLexerLangEPackage()
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
	    getLexerLangEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getLexerLangEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(LEXERLANG_NS_URI);
	}
	
}
