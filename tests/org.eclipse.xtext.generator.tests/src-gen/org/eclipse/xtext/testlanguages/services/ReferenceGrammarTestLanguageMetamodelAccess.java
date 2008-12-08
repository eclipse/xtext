/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ReferenceGrammarTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(REFERENCEGRAMMAR_NS_URI))
			EPackage.Registry.INSTANCE.put(REFERENCEGRAMMAR_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/ReferenceGrammar.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getReferenceGrammarEPackage()
		
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
	    getReferenceGrammarEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String REFERENCEGRAMMAR_NS_URI = "http://eclipse.org/xtext/reference/ReferenceGrammar";
	
	protected EPackage getReferenceGrammarEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(REFERENCEGRAMMAR_NS_URI);
	}
	
}
