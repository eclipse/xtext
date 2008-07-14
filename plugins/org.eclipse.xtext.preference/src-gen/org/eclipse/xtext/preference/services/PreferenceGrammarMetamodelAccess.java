/*
Generated with Xtext
*/
package org.eclipse.xtext.preference.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class PreferenceGrammarMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	private EPackage[] generated = new EPackage[] {
		
		getPrefEPackage()
		
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
	    getPrefEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String PREF_NS_URI = "http://www.eclipse.org/xtext/preference";
	
	protected EPackage getPrefEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(PREF_NS_URI);
	}
	
}
