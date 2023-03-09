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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitor;
import org.eclipse.xtext.common.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmCompoundTypeReferenceImplCustom extends JvmCompoundTypeReferenceImpl {

	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitCompoundTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitCompoundTypeReference(this, parameter);
		return result;
	}
	
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
		if (references != null && !references.isEmpty()) {
			if (references.size() == 1) {
				return references.get(0).getType();
			}
			if (type == null) {
				JvmGenericType objectType = TypesFactory.eINSTANCE.createJvmGenericType();
				String objectClassName = Object.class.getName();
				((InternalEObject) objectType).eSetProxyURI(URIHelperConstants.OBJECTS_URI.appendSegment(objectClassName).appendFragment(objectClassName));
				type = objectType;
			}
		}
		return super.getType();
	}
	
	/**
	 * The identifier of a {@link org.eclipse.xtext.common.types.JvmCompoundTypeReference JvmCompoundTypeReference} 
	 * is the concatenated identifier of its {@link #getReferences() components}. The {@link #getDelimiter() delimiter} 
	 * is specified in concrete sub-types.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		if (references != null && !references.isEmpty()) {
			StringBuilder result = new StringBuilder();
			for(JvmTypeReference reference: references) {
				if (result.length() > 0) {
					result.append(getDelimiter());
				}
				result.append(reference.getIdentifier());
			}
			return result.toString();
		}
		return super.getIdentifier();
	}

	protected String getDelimiter() {
		throw new UnsupportedOperationException("Subclasses of JvmCompoundTypeReferenceImplCustom must override #getDelimiter");
	}
	
	/**
	 * The simple name of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated simple name of its {@link #getReferences() components}. The delimiter is the <code>&amp;</code>.
	 */
	@Override
	public String getSimpleName() {
		if (references != null && !references.isEmpty()) {
			StringBuilder result = new StringBuilder();
			for(JvmTypeReference reference: references) {
				if (result.length() > 0) {
					result.append(getDelimiter());
				}
				result.append(reference.getSimpleName());
			}
			return result.toString();
		}
		return super.getIdentifier();
	}
	
	/**
	 * The qualified name of a {@link org.eclipse.xtext.common.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated qualified name of its {@link #getReferences() components}. The delimiter is the <code>&amp;</code>.
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (references != null && !references.isEmpty()) {
			StringBuilder result = new StringBuilder();
			for(JvmTypeReference reference: references) {
				if (result.length() > 0) {
					result.append(getDelimiter());
				}
				result.append(reference.getQualifiedName(innerClassDelimiter));
			}
			return result.toString();
		}
		return super.getIdentifier();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (references != null && !references.isEmpty()) {
			boolean first = true;
			for(JvmTypeReference reference: references) {
				if (!first)
					result.append(getDelimiter());
				first = false;
				result.append(reference.toString());
			}
		} else {
			result.append(" ./. ");
		}
		return result.toString();
	}
	
}
