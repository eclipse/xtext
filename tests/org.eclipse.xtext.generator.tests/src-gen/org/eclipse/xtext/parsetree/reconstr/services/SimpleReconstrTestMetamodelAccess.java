/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleReconstrTestMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getSimplerewritetestEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String SIMPLEREWRITETEST_NS_URI = "http://simple/rewrite/test";
	public static final String SIMPLEREWRITETEST_CP_URI = "org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore";
	
	public static EPackage getSimplerewritetestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEREWRITETEST_NS_URI)) {
			EPackage p = loadEcoreFile(SimpleReconstrTestMetamodelAccess.class.getClassLoader(),SIMPLEREWRITETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLEREWRITETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEREWRITETEST_NS_URI);
	}
	
}
