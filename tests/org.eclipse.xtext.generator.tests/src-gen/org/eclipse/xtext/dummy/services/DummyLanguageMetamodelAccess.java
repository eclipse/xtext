package org.eclipse.xtext.dummy.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.service.*;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class DummyLanguageMetamodelAccess  extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getDummyLangEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String DUMMYLANG_NS_URI = "http://www.eclipse.org/2008/xtext/DummyLang";
	public static final String DUMMYLANG_CP_URI = "org/eclipse/xtext/dummy/DummyLang.ecore";
	
	public static EPackage getDummyLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(DUMMYLANG_NS_URI)) {
			EPackage p = loadEcoreFile(DummyLanguageMetamodelAccess.class.getClassLoader(),DUMMYLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(DUMMYLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(DUMMYLANG_NS_URI);
	}
	
}
