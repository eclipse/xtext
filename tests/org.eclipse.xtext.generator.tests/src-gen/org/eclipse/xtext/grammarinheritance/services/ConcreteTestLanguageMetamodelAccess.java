/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ConcreteTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getFooEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	protected static final String FOO_NS_URI = "http://holla";
	protected static final String FOO_CP_URI = "org/eclipse/xtext/grammarinheritance/foo.ecore";
	
	protected EPackage getFooEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(FOO_NS_URI)) {
			EPackage p = loadEcoreFile(ConcreteTestLanguageMetamodelAccess.class.getClassLoader(),FOO_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(FOO_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(FOO_NS_URI);
	}
	
}
