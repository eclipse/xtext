/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.crossref.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.crossref.IFragmentProvider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese
 */
public class XtextBuiltinFragmentProvider implements IFragmentProvider {

	public String getFragment(EObject obj) {
		EClass eclass = obj.eClass();
		
		EStructuralFeature structuralFeature = eclass.getEStructuralFeature("name");
		if (structuralFeature != null) {
			if (structuralFeature instanceof EAttribute) {
				EAttribute attribute = (EAttribute) structuralFeature;
				Object name = obj.eGet(attribute);
				if (name instanceof String) {
					return (String) name;
				}
			}
		}
		return null;
	}

}
