/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class OptionalEmptyLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(OPTIONALEMPTY_NS_URI))
			EPackage.Registry.INSTANCE.put(OPTIONALEMPTY_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/OptionalEmpty.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getOptionalEmptyEPackage()
		
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
	    getOptionalEmptyEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String OPTIONALEMPTY_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/OptionalEmpty";
	
	protected EPackage getOptionalEmptyEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(OPTIONALEMPTY_NS_URI);
	}
	
}
