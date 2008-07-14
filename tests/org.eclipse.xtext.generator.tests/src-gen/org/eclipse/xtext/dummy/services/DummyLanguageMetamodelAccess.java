/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class DummyLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	private EPackage[] generated = new EPackage[] {
		
		getDummyLangEPackage()
		
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
	    getDummyLangEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String DUMMYLANG_NS_URI = "http://www.eclipse.org/2008/xtext/DummyLang";
	
	protected EPackage getDummyLangEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(DUMMYLANG_NS_URI);
	}
	
}
