/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleReconstrTestMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEREWRITETEST_NS_URI))
			EPackage.Registry.INSTANCE.put(SIMPLEREWRITETEST_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getSimplerewritetestEPackage()
		
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
	    getSimplerewritetestEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String SIMPLEREWRITETEST_NS_URI = "http://simple/rewrite/test";
	
	protected EPackage getSimplerewritetestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEREWRITETEST_NS_URI);
	}
	
}
