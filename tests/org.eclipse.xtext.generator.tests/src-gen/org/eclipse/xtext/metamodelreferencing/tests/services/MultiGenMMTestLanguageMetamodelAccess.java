/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class MultiGenMMTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST_NS_URI))
			EPackage.Registry.INSTANCE.put(SIMPLETEST_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore"));

		if (!EPackage.Registry.INSTANCE.containsKey(OTHERTEST_NS_URI))
			EPackage.Registry.INSTANCE.put(OTHERTEST_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/metamodelreferencing/tests/OtherTest.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getSimpleTestEPackage()
		,
		getOtherTestEPackage()
		
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
	    getOtherTestEPackage(),getSimpleTestEPackage()
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String SIMPLETEST_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest";
	
	protected EPackage getSimpleTestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST_NS_URI);
	}
	
	protected static final String OTHERTEST_NS_URI = "http://eclipse.org/xtext/tests/OtherTest";
	
	protected EPackage getOtherTestEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(OTHERTEST_NS_URI);
	}
	
}
