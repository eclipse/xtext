/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class XtextTerminalsTestLanguageMetamodelAccess extends BaseEPackageAccess implements IMetamodelAccess {

{

		if (!EPackage.Registry.INSTANCE.containsKey(XTEXTTERMINALSTESTLANGUAGE_NS_URI))
			EPackage.Registry.INSTANCE.put(XTEXTTERMINALSTESTLANGUAGE_NS_URI, loadEcoreFile(getClass().getClassLoader(), "classpath:/org/eclipse/xtext/parser/terminalrules/XtextTerminalsTestLanguage.ecore"));

}

	private EPackage[] generated = new EPackage[] {
		
		getXtextTerminalsTestLanguageEPackage()
		
		};

	public EPackage[] getGeneratedEPackages() {
		return generated;
	}

	private EPackage[] referenced = new EPackage[] {
		
		BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
		
		};
	public EPackage[] getReferencedEPackages() {
		return referenced;
	}
	
	private EPackage[] all = new EPackage[] {
	    getXtextTerminalsTestLanguageEPackage(),BaseEPackageAccess.getEPackageFromRegistry("http://www.eclipse.org/emf/2002/Ecore")
		};
	
	public EPackage[] getAllEPackages() {
		return all;
	}

	
	protected static final String XTEXTTERMINALSTESTLANGUAGE_NS_URI = "http://www.eclipse.org/2008/tmf/xtext/XtextTerminalsTestLanguage";
	
	protected EPackage getXtextTerminalsTestLanguageEPackage() {	
		return EPackage.Registry.INSTANCE.getEPackage(XTEXTTERMINALSTESTLANGUAGE_NS_URI);
	}
	
}
