/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ReferenceGrammarMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(REFERENCEGRAMMAR_NS_URI))
			EPackage.Registry.INSTANCE.put(REFERENCEGRAMMAR_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/reference/ReferenceGrammar.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getReferenceGrammarEPackage()
		
		};

	public EPackage[] getGeneratedEPackages() {
		return generated;
	}

	private EPackage[] referenced = new EPackage[] {
		
		BaseEPackageAccess.getEPackageFromRegistry("http://eclipse.org/xtext/reference/ReferenceModel")
		
		};
	public EPackage[] getReferencedEPackages() {
		return referenced;
	}
	
	private EPackage[] all = new EPackage[] {
	    BaseEPackageAccess.getEPackageFromRegistry("http://eclipse.org/xtext/reference/ReferenceModel"),getReferenceGrammarEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String REFERENCEGRAMMAR_NS_URI = "http://eclipse.org/xtext/reference/ReferenceGrammar";
	
	protected EPackage getReferenceGrammarEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(REFERENCEGRAMMAR_NS_URI);
	}
	
}
