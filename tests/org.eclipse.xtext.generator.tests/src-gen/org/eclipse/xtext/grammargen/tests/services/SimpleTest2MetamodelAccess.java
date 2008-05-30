package org.eclipse.xtext.grammargen.tests.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.service.*;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleTest2MetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getSimpleTest2EPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String SIMPLETEST2_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest2";
	public static final String SIMPLETEST2_CP_URI = "org/eclipse/xtext/grammargen/tests/SimpleTest2.ecore";
	
	public static EPackage getSimpleTest2EPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST2_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleTest2MetamodelAccess.class.getClassLoader(),SIMPLETEST2_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST2_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST2_NS_URI);
	}
	

	
	public String getModelFileExtension() {
		return "simpletest2";
	}
   
}
