/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ImportUriTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String IMPORTEDURI_NS_URI = "http://eclipse.org/xtext/importUriTestLanguage";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(IMPORTEDURI_NS_URI))
			EPackage.Registry.INSTANCE.put(IMPORTEDURI_NS_URI, loadEcoreFile(ImportUriTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/crossrefs/importedURI.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
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
	
	protected EPackage getImportedURIEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(IMPORTEDURI_NS_URI);
	}
	
}
