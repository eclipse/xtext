/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XDelegateTypeReferenceImplCustom extends XDelegateTypeReferenceImpl {

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the value of the 'Type' reference. If there is no type set, 
	 * a reference to <code>java.lang.Object</code> is assumed as soon as there is more 
	 * than one contained reference.
	 * If there is only one contained reference, its type is returned.
	 */
	@Override
	public JvmType getType() {
		JvmTypeReference delegate = getDelegate();
		if (delegate == null || delegate.eIsProxy())
			return null;
		return delegate.getType();
	}
	
	/**
	 * The identifier of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated identifier of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		JvmTypeReference delegate = getDelegate();
		if (delegate == null || delegate.eIsProxy())
			return null;
		return delegate.getIdentifier();
	}
	
	/**
	 * The simple name of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated simple name of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 */
	@Override
	public String getSimpleName() {
		JvmTypeReference delegate = getDelegate();
		if (delegate == null || delegate.eIsProxy())
			return null;
		return delegate.getSimpleName();
	}
	
	/**
	 * The qualified name of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated qualified name of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmTypeReference delegate = getDelegate();
		if (delegate == null || delegate.eIsProxy())
			return null;
		return delegate.getQualifiedName(innerClassDelimiter);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		JvmTypeReference delegate = getDelegate();
		if (delegate == null || delegate.eIsProxy())
			result.append(" ./. ");
		else
			result.append(delegate.toString());
		return result.toString();
	}
	
}
