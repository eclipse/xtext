/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.computation;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * Allows to bulk-assign types for {@link JvmIdentifiableElement identifiable elements},
 * e.g. assign the types for the parametes of an inferred {@link JvmOperation operation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeAssigner {

	/**
	 * The given element is tagged with the given type. If this type is <code>null</code>,
	 * it is treated like an error type.
	 */
	void assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference actualType);
	
	/**
	 * Returns the forked state that knows about the newly assigned types.
	 */
	ITypeComputationState getForkedState();
	
	/**
	 * Returns the current owner.
	 */
	ITypeReferenceOwner getReferenceOwner();
	
	/**
	 * Can be used to convert {@link JvmTypeReference JvmTypeReferences} in the context of
	 * the newly forked state.
	 * 
	 * @param reference the reference to convert.
	 * @return the converted reference.
	 */
	LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference);
	
}
