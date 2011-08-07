/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtype.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClassURIHelper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XSynonymTypeReferenceImplCustom extends XSynonymTypeReferenceImpl {

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
		if (synonymes != null && !synonymes.isEmpty()) {
			if (synonymes.size() >= 1) {
				return synonymes.get(0).getType();
			}
			if (type == null) {
				JvmGenericType objectType = TypesFactory.eINSTANCE.createJvmGenericType();
				((InternalEObject) objectType).eSetProxyURI(new ClassURIHelper().getFullURI(Object.class));
				setType(objectType);
			}
		}
		return super.getType();
	}
	
	/**
	 * The identifier of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated identifier of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		if (synonymes != null && !synonymes.isEmpty()) {
			StringBuilder result = new StringBuilder();
			result.append("(");
			for(JvmTypeReference synonym: synonymes) {
				if (result.length() > 1) {
					result.append(" | ");
				}
				result.append(synonym.getIdentifier());
			}
			result.append(")");
			return result.toString();
		}
		return super.getIdentifier();
	}
	
	/**
	 * The simple name of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated simple name of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 */
	@Override
	public String getSimpleName() {
		if (synonymes != null && !synonymes.isEmpty()) {
			StringBuilder result = new StringBuilder();
			result.append("(");
			for(JvmTypeReference reference: synonymes) {
				if (result.length() > 1) {
					result.append(" | ");
				}
				result.append(reference.getSimpleName());
			}
			result.append(")");
			return result.toString();
		}
		return super.getIdentifier();
	}
	
	/**
	 * The qualified name of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated qualified name of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (synonymes != null && !synonymes.isEmpty()) {
			StringBuilder result = new StringBuilder();
			result.append("(");
			for(JvmTypeReference reference: synonymes) {
				if (result.length() > 1) {
					result.append(" | ");
				}
				result.append(reference.getQualifiedName(innerClassDelimiter));
			}
			result.append(")");
			return result.toString();
		}
		return super.getIdentifier();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (synonymes != null && !synonymes.isEmpty()) {
			boolean first = true;
			result.append("(");
			for(JvmTypeReference reference: synonymes) {
				if (!first)
					result.append(" | ");
				first = false;
				result.append(reference.toString());
			}
			result.append(")");
		} else {
			result.append(" ./. ");
		}
		return result.toString();
	}
	
}
