/*
Generated with Xtext
*/
package org.eclipse.xtext.example.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class FowlerDslMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(FOWLERDSL_NS_URI))
			EPackage.Registry.INSTANCE.put(FOWLERDSL_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/example/fowlerdsl.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getFowlerdslEPackage()
		
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
	    getFowlerdslEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String FOWLERDSL_NS_URI = "http://example.xtext.org/FowlerDsl";
	
	protected EPackage getFowlerdslEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(FOWLERDSL_NS_URI);
	}
	
}
