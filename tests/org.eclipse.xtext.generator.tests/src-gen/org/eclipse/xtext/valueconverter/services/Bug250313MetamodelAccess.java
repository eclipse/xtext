/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class Bug250313MetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(BUG250313_NS_URI))
			EPackage.Registry.INSTANCE.put(BUG250313_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/valueconverter/bug250313.ecore"));

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

	
	protected static final String BUG250313_NS_URI = "http://org.eclipse.xtext.valueconverter.Bug250313";
	
	protected EPackage getBug250313EPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(BUG250313_NS_URI);
	}
	
}
