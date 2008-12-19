/*
Generated with Xtext
*/
package org.eclipse.xtext.resource.metamodel.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class MultiValueFeatureTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(MULTIVALUEFEATURETESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(MULTIVALUEFEATURETESTLANGUAGE_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/resource/metamodel/MultiValueFeatureTestLanguage.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getMultiValueFeatureTestLanguageEPackage()
		
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
	    getMultiValueFeatureTestLanguageEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String MULTIVALUEFEATURETESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/xtext/MultiValueFeatureTestLanguage";
	
	protected EPackage getMultiValueFeatureTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(MULTIVALUEFEATURETESTLANGUAGE_NS_URI);
	}
	
}
