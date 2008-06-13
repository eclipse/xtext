/*
Generated with Xtext
*/
package org.eclipse.xtext.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextGrammarTestMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getXtextTestEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	protected static final String XTEXTTEST_NS_URI = "http://www.eclipse.org/2008/Test/XtextTest";
	protected static final String XTEXTTEST_CP_URI = "org/eclipse/xtext/XtextTest.ecore";
	
	protected EPackage getXtextTestEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(XTEXTTEST_NS_URI)) {
			EPackage p = loadEcoreFile(XtextGrammarTestMetamodelAccess.class.getClassLoader(),XTEXTTEST_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(XTEXTTEST_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(XTEXTTEST_NS_URI);
	}
	
}
