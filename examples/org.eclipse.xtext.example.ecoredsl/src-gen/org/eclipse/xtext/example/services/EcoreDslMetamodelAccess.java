/*
Generated with Xtext
*/
package org.eclipse.xtext.example.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class EcoreDslMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(ECOREDSL_NS_URI))
			EPackage.Registry.INSTANCE.put(ECOREDSL_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/example/ecoredsl.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getEcoredslEPackage()
		
		};

	public EPackage[] getGeneratedEPackages() {
		return generated;
	}

	private EPackage[] referenced = new EPackage[] {
		
		BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
		
		};
	public EPackage[] getReferencedEPackages() {
		return referenced;
	}
	
	private EPackage[] all = new EPackage[] {
	    getEcoredslEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String ECOREDSL_NS_URI = "http://example.xtext.org/EcoreDsl";
	
	protected EPackage getEcoredslEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(ECOREDSL_NS_URI);
	}
	
}
