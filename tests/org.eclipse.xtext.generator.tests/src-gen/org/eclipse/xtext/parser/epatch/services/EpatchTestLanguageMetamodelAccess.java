/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class EpatchTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(EPATCHTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(EPATCHTESTLANGUAGE_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/parser/epatch/EpatchTestLanguage.ecore"));

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

	
	protected static final String EPATCHTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/EpatchTestLanguage";
	
	protected EPackage getEpatchTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(EPATCHTESTLANGUAGE_NS_URI);
	}
	
}
