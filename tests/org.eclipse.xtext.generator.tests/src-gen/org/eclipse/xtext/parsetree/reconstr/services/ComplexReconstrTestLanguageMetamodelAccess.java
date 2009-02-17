/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ComplexReconstrTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String COMPLEXREWRITETEST_NS_URI = "http://complex/rewrite/test";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(COMPLEXREWRITETEST_NS_URI))
			EPackage.Registry.INSTANCE.put(COMPLEXREWRITETEST_NS_URI, loadEcoreFile(ComplexReconstrTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parsetree/reconstr/complexrewritetest.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

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
	
	protected EPackage getComplexrewritetestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(COMPLEXREWRITETEST_NS_URI);
	}
	
}
