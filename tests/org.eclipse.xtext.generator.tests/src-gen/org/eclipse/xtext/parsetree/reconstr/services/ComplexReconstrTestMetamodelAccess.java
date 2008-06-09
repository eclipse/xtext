/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ComplexReconstrTestMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getComplexrewritetestEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String COMPLEXREWRITETEST_NS_URI = "http://complex/rewrite/test";
	public static final String COMPLEXREWRITETEST_CP_URI = "org/eclipse/xtext/parsetree/reconstr/complexrewritetest.ecore";
	
	public static EPackage getComplexrewritetestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(COMPLEXREWRITETEST_NS_URI)) {
			EPackage p = loadEcoreFile(ComplexReconstrTestMetamodelAccess.class.getClassLoader(),COMPLEXREWRITETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(COMPLEXREWRITETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(COMPLEXREWRITETEST_NS_URI);
	}
	
}
