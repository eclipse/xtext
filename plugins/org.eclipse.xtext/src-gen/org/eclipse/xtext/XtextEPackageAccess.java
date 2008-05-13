package org.eclipse.xtext;

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

public class XtextEPackageAccess extends org.eclipse.xtext.core.parser.BaseEPackageAccess {

	static {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
				"ecore", new XMIResourceFactoryImpl());
	}

	
	public static final String XTEXT_NS_URI = "http://www.eclipse.org/2008/Xtext";
	
	public static EPackage getxtextEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXT_NS_URI)) {
			EPackage p = loadEcoreFile(XtextEPackageAccess.class.getClassLoader(),"org/eclipse/xtext/xtext.ecore");
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(XTEXT_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(XTEXT_NS_URI);
	}
	
	

}
