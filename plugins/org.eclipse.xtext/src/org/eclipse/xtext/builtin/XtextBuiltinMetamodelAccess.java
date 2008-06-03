package org.eclipse.xtext.builtin;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.IMetamodelAccess;

public class XtextBuiltinMetamodelAccess implements IMetamodelAccess {

	public EPackage[] getGeneratedEPackages() {
		return new EPackage[0];
	}

	public EPackage[] getReferencedEPackages() {
		return new EPackage[]{
				EcorePackage.eINSTANCE
		};
	}

}
