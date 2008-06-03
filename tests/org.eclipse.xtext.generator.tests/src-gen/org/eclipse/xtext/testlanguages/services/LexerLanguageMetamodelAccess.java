package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.service.*;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LexerLanguageMetamodelAccess  extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getLexerLangEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String LEXERLANG_NS_URI = "http://www.eclipse.org/2008/xtext/LexerLang";
	public static final String LEXERLANG_CP_URI = "org/eclipse/xtext/testlanguages/LexerLang.ecore";
	
	public static EPackage getLexerLangEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(LEXERLANG_NS_URI)) {
			EPackage p = loadEcoreFile(LexerLanguageMetamodelAccess.class.getClassLoader(),LEXERLANG_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(LEXERLANG_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(LEXERLANG_NS_URI);
	}
	
	
	public String getModelFileExtension() {
		return "lexerlanguage";
	}
   
}
