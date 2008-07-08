/*
Generated with Xtext
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class PreferenceMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getPrefEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	protected static final String PREF_NS_URI = "http://www.eclipse.org/xtext/preference";
	protected static final String PREF_CP_URI = "org/eclipse/xtext/pref.ecore";
	
	protected EPackage getPrefEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(PREF_NS_URI)) {
			EPackage p = loadEcoreFile(PreferenceMetamodelAccess.class.getClassLoader(),PREF_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(PREF_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(PREF_NS_URI);
	}
	
}
