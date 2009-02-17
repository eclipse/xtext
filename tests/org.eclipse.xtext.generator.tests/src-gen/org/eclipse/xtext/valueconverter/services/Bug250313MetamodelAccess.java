/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class Bug250313MetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String BUG250313_NS_URI = "http://org.eclipse.xtext.valueconverter.Bug250313";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(BUG250313_NS_URI))
			EPackage.Registry.INSTANCE.put(BUG250313_NS_URI, loadEcoreFile(Bug250313MetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/valueconverter/bug250313.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getBug250313EPackage()
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
	    getBug250313EPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getBug250313EPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(BUG250313_NS_URI);
	}
	
}
