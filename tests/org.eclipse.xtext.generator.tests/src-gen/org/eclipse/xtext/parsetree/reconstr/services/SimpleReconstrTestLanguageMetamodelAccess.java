/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleReconstrTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String SIMPLEREWRITETEST_NS_URI = "http://simple/rewrite/test";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEREWRITETEST_NS_URI))
			EPackage.Registry.INSTANCE.put(SIMPLEREWRITETEST_NS_URI, loadEcoreFile(SimpleReconstrTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parsetree/reconstr/simplerewritetest.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
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
	
	protected EPackage getSimplerewritetestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEREWRITETEST_NS_URI);
	}
	
}
