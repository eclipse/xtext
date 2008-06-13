/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LookaheadLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getLookaheadLangEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	protected static final String LOOKAHEADLANG_NS_URI = "http://www.eclipse.org/2008/xtext/LookaheadLang";
	protected static final String LOOKAHEADLANG_CP_URI = "org/eclipse/xtext/testlanguages/LookaheadLang.ecore";
	
	protected EPackage getLookaheadLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(LOOKAHEADLANG_NS_URI)) {
			EPackage p = loadEcoreFile(LookaheadLanguageMetamodelAccess.class.getClassLoader(),LOOKAHEADLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(LOOKAHEADLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(LOOKAHEADLANG_NS_URI);
	}
	
}
