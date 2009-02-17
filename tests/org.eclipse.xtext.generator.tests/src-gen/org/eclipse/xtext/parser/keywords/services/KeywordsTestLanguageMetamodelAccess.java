/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.keywords.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class KeywordsTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String KEYWORDSTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2009/tmf/xtext/KeywordsTestLanguage";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(KEYWORDSTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(KEYWORDSTESTLANGUAGE_NS_URI, loadEcoreFile(KeywordsTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getKeywordsTestLanguageEPackage()
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
	    getKeywordsTestLanguageEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getKeywordsTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(KEYWORDSTESTLANGUAGE_NS_URI);
	}
	
}
