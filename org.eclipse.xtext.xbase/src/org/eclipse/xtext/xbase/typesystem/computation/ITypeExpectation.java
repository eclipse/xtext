/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeExpectation {

	void acceptActualType(LightweightTypeReference type, ConformanceHint... hints);
	
	void acceptActualType(LightweightTypeReference type, EnumSet<ConformanceHint> hints);
	
	void acceptActualType(LightweightTypeReference type, int flags);

	ITypeReferenceOwner getReferenceOwner();
	
	/**
	 * Create a new, managed {@link UnboundTypeReference} for the given type parameter which was
	 * first encountered for the given expression.
	 * @param expression the expression that used / referenced the type parameter
	 * @param typeParameter the type parameter
	 */
	UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter);
	
	ITypeExpectation copyInto(ITypeReferenceOwner referenceOwner);
	
	boolean isOwnedBy(ITypeReferenceOwner referenceOwner);
	
	/**
	 * Returns the expected type. The expected type may be not too concrete thus {@link #getExpectedType()} may return
	 * <code>null</code> or some sort of unresolved, specialized reference. If <code>null</code> is returned, clients
	 * may want to check {@link #isNoTypeExpectation()} or {@link #isVoidTypeAllowed()}.
	 * @return the expected type. This may be <code>null</code>. 
	 */
	/* @Nullable */
	LightweightTypeReference getExpectedType();
	
	/**
	 * Returns <code>true</code> if anything is allowed and no constraints are expected.
	 * @return <code>true</code> if anything is allowed and no constraints are expected.
	 */
	boolean isNoTypeExpectation();
	
	/**
	 * Returns <code>true</code> if {@link Void#TYPE} is a valid type. It may be the only valid type
	 * or there may exist others.
	 * @return <code>true</code> if primitive <code>void</code> is allowed.
	 */
	boolean isVoidTypeAllowed();
	
}
