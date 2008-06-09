/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class OptionalEmptyLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getOptionalEmptyEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String OPTIONALEMPTY_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/OptionalEmpty";
	public static final String OPTIONALEMPTY_CP_URI = "org/eclipse/xtext/testlanguages/OptionalEmpty.ecore";
	
	public static EPackage getOptionalEmptyEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(OPTIONALEMPTY_NS_URI)) {
			EPackage p = loadEcoreFile(OptionalEmptyLanguageMetamodelAccess.class.getClassLoader(),OPTIONALEMPTY_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(OPTIONALEMPTY_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(OPTIONALEMPTY_NS_URI);
	}
	
}
