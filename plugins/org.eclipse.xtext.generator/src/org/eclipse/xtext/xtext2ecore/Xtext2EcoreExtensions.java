package org.eclipse.xtext.xtext2ecore;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EcorePackage;

public class Xtext2EcoreExtensions {

	public static void setETypeEInt(EAttribute attribute) {
		attribute.setEType(EcorePackage.Literals.EINT);
	}

	public static void setETypeEString(EAttribute attribute) {
		attribute.setEType(EcorePackage.Literals.ESTRING);
	}

	public static void setETypeEBoolean(EAttribute attribute) {
		attribute.setEType(EcorePackage.Literals.EBOOLEAN);
	}

}
