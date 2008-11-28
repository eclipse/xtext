/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ImportUriTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(IMPORTEDURI_NS_URI))
			EPackage.Registry.INSTANCE.put(IMPORTEDURI_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/crossrefs/importedURI.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getImportedURIEPackage()
		
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
	    getImportedURIEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String IMPORTEDURI_NS_URI = "http://eclipse.org/xtext/importUriTestLanguage";
	
	protected EPackage getImportedURIEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(IMPORTEDURI_NS_URI);
	}
	
}
