/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.impl;

import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.JvmWildcardTypeReference;
import org.eclipse.xtext.common.types.TypesPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmTypeConstraintImplCustom extends JvmTypeConstraintImpl {

	@Override
	public String getIdentifier() {
		if (typeReference != null) {
			return getTypeReference().getIdentifier();
		}
		return null;
	}
	
	@Override
	public final String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (typeReference != null) {
			return getTypeReference().getQualifiedName(innerClassDelimiter);
		}
		return null;
	}
	
	@Override
	public String getSimpleName() {
		if (typeReference != null) {
			return getTypeReference().getSimpleName();
		}
		return null;
	}
	
	@Override
	public void setTypeReference(JvmTypeReference newTypeReference) {
		if (newTypeReference instanceof JvmWildcardTypeReference)
			throw new IllegalArgumentException("wildcard type references are not supported as constraint bounds");
		if (!isLikelyAValidConstraintBound(newTypeReference))
			throw new IllegalArgumentException("primitive type references are not supported as constraint bounds");
		super.setTypeReference(newTypeReference);
	}
	
	public void internalSetTypeReference(JvmTypeReference newTypeReference) {
		super.setTypeReference(newTypeReference);
	}

	/**
	 * Constraint bounds are definitely invalid if they are <code>not null</code> and point to a primitive type.
	 * {@link JvmSpecializedTypeReference} will not be resolved by this check thus they may lead to finally 
	 * invalid constraint bounds.
	 * 
	 * @param constraintBound the reference that shall be come the new constraint.
	 * @return <code>false</code> if the given constraint is definitely invalid. 
	 */
	protected boolean isLikelyAValidConstraintBound(JvmTypeReference constraintBound) {
		if (constraintBound == null)
			return true;
		if (constraintBound instanceof JvmSpecializedTypeReference) {
			JvmTypeReference equivalent = (JvmTypeReference) constraintBound.eGet(TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT, false);
			if (equivalent != null) {
				return isLikelyAValidConstraintBound(equivalent);
			}
			return true;
		}
		boolean invalid = (constraintBound.getType() instanceof JvmPrimitiveType 
					|| (constraintBound.getType() instanceof JvmVoid && !constraintBound.getType().eIsProxy()));
		return !invalid;
	}
	
	@Override
	public String toString() {
		if (typeReference != null) {
			return getTypeReference().toString();
		}
		return super.toString();
	}

} 
