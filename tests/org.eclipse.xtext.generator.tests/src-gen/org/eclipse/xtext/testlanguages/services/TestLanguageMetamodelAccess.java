package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.service.*;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TestLanguageMetamodelAccess  extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getTestLangEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String TESTLANG_NS_URI = "http://www.eclipse.org/2008/xtext/TestLang";
	public static final String TESTLANG_CP_URI = "org/eclipse/xtext/testlanguages/TestLang.ecore";
	
	public static EPackage getTestLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(TESTLANG_NS_URI)) {
			EPackage p = loadEcoreFile(TestLanguageMetamodelAccess.class.getClassLoader(),TESTLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(TESTLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(TESTLANG_NS_URI);
	}
	
	
	public String getModelFileExtension() {
		return "testlanguage";
	}
   
}
