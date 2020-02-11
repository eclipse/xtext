/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnyTypeReferenceImplCustom extends JvmAnyTypeReferenceImpl {

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the value of the 'Type' reference. If there is no type set, 
	 * a reference to <code>java.lang.Object</code> is assumed.
	 */
	@Override
	public JvmType getType() {
		if (type == null) {
			JvmGenericType objectType = TypesFactory.eINSTANCE.createJvmGenericType();
			String objectClassName = Object.class.getName();
			((InternalEObject) objectType).eSetProxyURI(URIHelperConstants.OBJECTS_URI.appendSegment(objectClassName).appendFragment(objectClassName));
			setType(objectType);
		}
		return super.getType();
	}
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitAnyTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitAnyTypeReference(this, parameter);
		return result;
	}
	
	/**
	 * The identifier of a {@link org.eclipse.xtext.common.types.JvmAnyTypeReference JvmAnyTypeReference} 
	 * is always "<code>null</code>".
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		return "null";
	}
	
	/**
	 * The simple name of a {@link org.eclipse.xtext.common.types.JvmAnyTypeReference JvmAnyTypeReference} 
	 * is always "<code>null</code>".
	 */
	@Override
	public String getSimpleName() {
		return "null";
	}
	
	/**
	 * The qualified name of a {@link org.eclipse.xtext.common.types.JvmAnyTypeReference JvmAnyTypeReference} 
	 * is always "<code>null</code>".
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return "null";
	}
	
	@Override
	public String toString() {
		return eClass().getName();
	}
	
}
