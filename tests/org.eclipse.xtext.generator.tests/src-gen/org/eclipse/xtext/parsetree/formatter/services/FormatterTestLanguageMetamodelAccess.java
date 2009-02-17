/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.formatter.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class FormatterTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

	protected static final String FORMATTERTESTLANGUAGE_NS_URI = "http://simple/formattertestlanguage";
	
	
	public static void init() {
		if (!EPackage.Registry.INSTANCE.containsKey(FORMATTERTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(FORMATTERTESTLANGUAGE_NS_URI, loadEcoreFile(FormatterTestLanguageMetamodelAccess.class.getClassLoader(), "classpath:/org/eclipse/xtext/parsetree/formatter/formattertestlanguage.ecore"));
	}

	static {
		org.eclipse.xtext.builtin.services.XtextBuiltinMetamodelAccess.init();
		init();
	}

	private EPackage[] generated = new EPackage[] {
		getFormattertestlanguageEPackage()
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
	    getFormattertestlanguageEPackage()
	};
	
	public EPackage[] getAllEPackages() {
		return all;
	}
	
	protected EPackage getFormattertestlanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(FORMATTERTESTLANGUAGE_NS_URI);
	}
	
}
