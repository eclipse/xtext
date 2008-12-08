/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LangATestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(LANGATESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(LANGATESTLANGUAGE_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/crossrefs/langATestLanguage.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getLangATestLanguageEPackage()
		
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
	    getLangATestLanguageEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String LANGATESTLANGUAGE_NS_URI = "http://eclipse.org/xtext/langATestLanguage";
	
	protected EPackage getLangATestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(LANGATESTLANGUAGE_NS_URI);
	}
	
}
