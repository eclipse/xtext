/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ContentAssistTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String CONTENTASSISTTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/xtext/tests/ContentAssist";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(CONTENTASSISTTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(CONTENTASSISTTESTLANGUAGE_NS_URI, loadEcoreFile(ContentAssistTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/contentAssistTestLanguage.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getContentAssistTestLanguageEPackage()
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
	    getContentAssistTestLanguageEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getContentAssistTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(CONTENTASSISTTESTLANGUAGE_NS_URI);
	}
	
}
