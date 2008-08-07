package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.crossref.IFragmentProvider;

public class XtextBuiltinFragmentProvider implements IFragmentProvider {

	public String getFragment(EObject obj) {
		EClass eclass = obj.eClass();
		EList<EAttribute> attributes = eclass.getEAllAttributes();
		for (EAttribute a : attributes) {
			if (a.getName().equals("name")) {
				Object name = obj.eGet(a);
				if (name instanceof String)
					return (String) name;
			}
		}
		return null;
	}

}
