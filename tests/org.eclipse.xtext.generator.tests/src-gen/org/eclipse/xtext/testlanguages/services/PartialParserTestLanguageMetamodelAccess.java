/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class PartialParserTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(PARTIALPARSERTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(PARTIALPARSERTESTLANGUAGE_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/partialParserTestLanguage.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getPartialParserTestLanguageEPackage()
		
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
	    getPartialParserTestLanguageEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String PARTIALPARSERTESTLANGUAGE_NS_URI = "http://example.xtext.org/PartialParserTestLanguage";
	
	protected EPackage getPartialParserTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(PARTIALPARSERTESTLANGUAGE_NS_URI);
	}
	
}
