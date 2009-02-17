/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class SimpleExpressionsTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String SIMPLEEXPRESSIONS_NS_URI = "http://www.eclipse.org/xtext/test/simpleExpressions";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(SIMPLEEXPRESSIONS_NS_URI))
			EPackage.Registry.INSTANCE.put(SIMPLEEXPRESSIONS_NS_URI, loadEcoreFile(SimpleExpressionsTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/testlanguages/simpleExpressions.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getSimpleExpressionsEPackage()
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
	    getSimpleExpressionsEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getSimpleExpressionsEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(SIMPLEEXPRESSIONS_NS_URI);
	}
	
}
