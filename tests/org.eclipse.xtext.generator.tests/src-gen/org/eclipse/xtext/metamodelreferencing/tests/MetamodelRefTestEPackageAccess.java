package org.eclipse.xtext.metamodelreferencing.tests;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class MetamodelRefTestEPackageAccess extends org.eclipse.xtext.core.parser.BaseEPackageAccess {

	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
	}

	
	public static final String SIMPLETEST_NS_URI = "http://eclipse.org/xtext/tests/SimpleTest";
	
	public static EPackage getSimpleTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLETEST_NS_URI)) {
			EPackage p = loadEcoreFile(MetamodelRefTestEPackageAccess.class.getClassLoader(),"org/eclipse/xtext/metamodelreferencing/tests/SimpleTest.ecore");
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(SIMPLETEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLETEST_NS_URI);
	}
	
	

}
