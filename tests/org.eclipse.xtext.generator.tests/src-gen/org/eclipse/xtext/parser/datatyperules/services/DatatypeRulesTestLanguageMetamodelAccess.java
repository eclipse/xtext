/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class DatatypeRulesTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(DATATYPERULESTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(DATATYPERULESTESTLANGUAGE_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/parser/datatyperules/DatatypeRulesTestLanguage.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getDatatypeRulesTestLanguageEPackage()
		
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
	    getDatatypeRulesTestLanguageEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String DATATYPERULESTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/DatatypeRulesTest";
	
	protected EPackage getDatatypeRulesTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(DATATYPERULESTESTLANGUAGE_NS_URI);
	}
	
}
