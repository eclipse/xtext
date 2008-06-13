/*
Generated with Xtext
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getXtextEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String XTEXT_NS_URI = "http://www.eclipse.org/2008/Xtext";
	public static final String XTEXT_CP_URI = "org/eclipse/xtext/xtext.ecore";
	
	public EPackage getXtextEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXT_NS_URI)) {
			EPackage p = loadEcoreFile(XtextMetamodelAccess.class.getClassLoader(),XTEXT_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(XTEXT_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(XTEXT_NS_URI);
	}
	
}
