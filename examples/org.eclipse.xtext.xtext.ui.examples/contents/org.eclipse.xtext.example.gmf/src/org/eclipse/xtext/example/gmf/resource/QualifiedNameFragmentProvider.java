/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.gmf.resource;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IFragmentProvider;

import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class QualifiedNameFragmentProvider implements IFragmentProvider {

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	public String getFragment(EObject obj, Fallback fallback) {
		String qualifiedName = qualifiedNameProvider.getQualifiedName(obj);
		return qualifiedName != null ? qualifiedName : fallback.getFragment(obj);
	}

	public EObject getEObject(Resource resource, String fragment,
			Fallback fallback) {
		if (fragment != null) {
			for (Iterator<EObject> i = EcoreUtil.getAllContents(resource, false); i.hasNext();) {
				EObject eObject = i.next();
				String candidateFragment = (eObject.eIsProxy()) ? ((InternalEObject) eObject).eProxyURI().fragment()
						: getFragment(eObject, fallback);
				if (fragment.equals(candidateFragment)) {
					return eObject;
				}
			}
		}
		return fallback.getEObject(fragment);
	}

}
