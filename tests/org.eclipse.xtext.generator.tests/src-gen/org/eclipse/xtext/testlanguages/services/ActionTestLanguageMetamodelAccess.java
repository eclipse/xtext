/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ActionTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(ACTIONLANG_NS_URI))
			EPackage.Registry.INSTANCE.put(ACTIONLANG_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/ActionLang.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getActionLangEPackage()
		
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
	    getActionLangEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String ACTIONLANG_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/ActionLang";
	
	protected EPackage getActionLangEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(ACTIONLANG_NS_URI);
	}
	
}
