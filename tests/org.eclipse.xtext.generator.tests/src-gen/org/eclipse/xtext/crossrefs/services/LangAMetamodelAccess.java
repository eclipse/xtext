/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LangAMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(LANGA_NS_URI))
			EPackage.Registry.INSTANCE.put(LANGA_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/crossrefs/langA.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getLangAEPackage()
		
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
	    getLangAEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String LANGA_NS_URI = "http://eclipse.org/xtext/langA";
	
	protected EPackage getLangAEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(LANGA_NS_URI);
	}
	
}
