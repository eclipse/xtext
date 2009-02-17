/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class TransientValuesTestMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String TRANSIENTVALUESTEST_NS_URI = "http://simple/transientvaluestest";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(TRANSIENTVALUESTEST_NS_URI))
			EPackage.Registry.INSTANCE.put(TRANSIENTVALUESTEST_NS_URI, loadEcoreFile(TransientValuesTestMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parsetree/transientvalues/transientvaluestest.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getTransientvaluestestEPackage()
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
	    getTransientvaluestestEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getTransientvaluestestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(TRANSIENTVALUESTEST_NS_URI);
	}
	
}
