/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IJavaSchemeUriResolver;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmTypeReferenceImplCustom extends JvmTypeReferenceImpl {

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
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitTypeReference(this, parameter);
		return result;
	}
	
	@Override
	public String getIdentifier() {
		JvmType type = getType();
		if (type != null)
			return type.getIdentifier();
		return null;
	}
	
	@Override
	public String getSimpleName() {
		JvmType type = getType();
		if (type != null)
			return type.getSimpleName();
		return null;
	}
	
	@Override
	public String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmType type = getType();
		if (type != null)
			return type.getQualifiedName(innerClassDelimiter);
		return null;
	}
	
}
