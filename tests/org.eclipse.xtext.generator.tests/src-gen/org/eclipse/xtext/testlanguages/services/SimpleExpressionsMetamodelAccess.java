package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.service.*;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleExpressionsMetamodelAccess  extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getSimpleExpressionsEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String SIMPLEEXPRESSIONS_NS_URI = "http://www.eclipse.org/xtext/test/simpleExpressions";
	public static final String SIMPLEEXPRESSIONS_CP_URI = "org/eclipse/xtext/testlanguages/simpleExpressions.ecore";
	
	public static EPackage getSimpleExpressionsEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEEXPRESSIONS_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleExpressionsMetamodelAccess.class.getClassLoader(),SIMPLEEXPRESSIONS_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLEEXPRESSIONS_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEEXPRESSIONS_NS_URI);
	}
	
}
