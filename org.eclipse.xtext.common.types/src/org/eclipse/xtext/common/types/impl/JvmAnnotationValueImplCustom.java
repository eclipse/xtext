/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver;

public abstract class JvmAnnotationValueImplCustom extends JvmAnnotationValueImpl {
	
	@Override
	public EObject eResolveProxy(InternalEObject proxy) {
		Resource resource = eResource();
		if (resource instanceof IJavaSchemeUriResolver) {
			EObject result = ((IJavaSchemeUriResolver) resource).resolveJavaObjectURIProxy(proxy, this);
			if (result != null)
				return result;
		}
		return super.eResolveProxy(proxy);
	}
	
	@Override
	public String getValueName() {
		JvmOperation operation = getOperation();
		if (operation == null || operation.eIsProxy())
			return null;
		return operation.getSimpleName();
	}

}
