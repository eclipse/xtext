/*
Generated with Xtext
*/
package org.eclipse.xtext.generator.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class LowerCaseNamedTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(LOWERCASENAMEDTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(LOWERCASENAMEDTESTLANGUAGE_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getLowerCaseNamedTestLanguageEPackage()
		
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
	    getLowerCaseNamedTestLanguageEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String LOWERCASENAMEDTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2009/tmf/xtext/lowerCaseNamedTestLanguage";
	
	protected EPackage getLowerCaseNamedTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(LOWERCASENAMEDTESTLANGUAGE_NS_URI);
	}
	
}
