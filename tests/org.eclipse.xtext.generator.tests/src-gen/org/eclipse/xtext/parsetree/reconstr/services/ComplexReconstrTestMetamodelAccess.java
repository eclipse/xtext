/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ComplexReconstrTestMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	private EPackage[] generated = new EPackage[] {
		
		getComplexrewritetestEPackage()
		
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
	    getComplexrewritetestEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String COMPLEXREWRITETEST_NS_URI = "http://complex/rewrite/test";
	
	protected EPackage getComplexrewritetestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(COMPLEXREWRITETEST_NS_URI);
	}
	
}
