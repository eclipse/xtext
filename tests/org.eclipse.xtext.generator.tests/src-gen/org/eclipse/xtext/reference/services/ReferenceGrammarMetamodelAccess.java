package org.eclipse.xtext.reference.services;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.service.*;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.IMetamodelAccess;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parser.BaseEPackageAccess;

public class ReferenceGrammarMetamodelAccess  extends BaseEPackageAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[] {
		
		getReferenceGrammarEPackage()
		
		};
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[] {
		
		};
	}

	
	public static final String REFERENCEGRAMMAR_NS_URI = "http://eclipse.org/xtext/reference/ReferenceGrammar";
	public static final String REFERENCEGRAMMAR_CP_URI = "org/eclipse/xtext/reference/ReferenceGrammar.ecore";
	
	public static EPackage getReferenceGrammarEPackage() {	
		if (!EPackage.Registry.INSTANCE.containsKey(REFERENCEGRAMMAR_NS_URI)) {
			EPackage p = loadEcoreFile(ReferenceGrammarMetamodelAccess.class.getClassLoader(),REFERENCEGRAMMAR_CP_URI);
			if (p!=null) {
				EPackage.Registry.INSTANCE.put(REFERENCEGRAMMAR_NS_URI,p);
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(REFERENCEGRAMMAR_NS_URI);
	}
	
}
