/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class MetamodelRefTestMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getSimpleTestEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/2008/Xtext")
		
		};
	}

	
	protected static final String SIMPLETEST_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest";
	protected static final String SIMPLETEST_CP_URI = "org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore";
	
	protected EPackage getSimpleTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST_NS_URI)) {
			EPackage p = loadEcoreFile(MetamodelRefTestMetamodelAccess.class.getClassLoader(),SIMPLETEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST_NS_URI);
	}
	
}
