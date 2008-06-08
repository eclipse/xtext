/*
Generated using Xtext at Sun Jun 08 11:15:27 CEST 2008
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ActionTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getActionLangEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String ACTIONLANG_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/ActionLang";
	public static final String ACTIONLANG_CP_URI = "org/eclipse/xtext/testlanguages/ActionLang.ecore";
	
	public static EPackage getActionLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(ACTIONLANG_NS_URI)) {
			EPackage p = loadEcoreFile(ActionTestLanguageMetamodelAccess.class.getClassLoader(),ACTIONLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(ACTIONLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(ACTIONLANG_NS_URI);
	}
	
}
