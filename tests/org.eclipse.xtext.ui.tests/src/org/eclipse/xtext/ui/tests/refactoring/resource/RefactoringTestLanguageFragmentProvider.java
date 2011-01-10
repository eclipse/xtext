/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.refactoring.resource;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.eclipse.xtext.ui.tests.refactoring.refactoring.Element;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringTestLanguageFragmentProvider implements IFragmentProvider {

	public String getFragment(EObject obj, Fallback fallback) {
		if (obj instanceof Element)
			return ((Element) obj).getName();
		else
			return fallback.getFragment(obj);
	}

	public EObject getEObject(Resource resource, String fragment, Fallback fallback) {
		for (TreeIterator<EObject> i = resource.getAllContents(); i.hasNext();) {
			EObject obj = i.next();
			if (obj instanceof Element && fragment.equals(((Element) obj).getName()))
				return obj;
		}
		return fallback.getEObject(fragment);
	}

}
