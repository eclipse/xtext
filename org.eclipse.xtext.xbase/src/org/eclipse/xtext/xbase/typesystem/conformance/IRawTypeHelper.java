/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.conformance;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.RawTypeHelper;

import com.google.inject.ImplementedBy;

/**
 * The {@link IRawTypeHelper} allows to compute the raw types for a given reference.
 * 
 * Semantically the raw type for a reference is considered to be
 * <ul>
 *   <li>The primary type for a parameterized type, e.g. {@code List<String>} produces {@code List}</li>
 *   <li>The constraints in case the type is a type paramater, e.g. {@code CharSequence} is the raw type of
 *       a type parameter {@code T extends CharSequence}</li>
 *   <li>Wildcard references determine the raw type from their upper bound</li>
 *   <li>Multi-types return all the raw types of all of their components.</li>
 *   <li>Synonyms return the raw type of the synonym since the primary type is only used to track the origin. That 
 *       means, a type {@code int | Integer} has the raw type {@code Integer}</li>.
 * </ul>
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(RawTypeHelper.class)
public interface IRawTypeHelper {
	
	List<JvmType> getAllRawTypes(LightweightTypeReference reference, ResourceSet resourceSet);
	
	LightweightTypeReference getRawTypeReference(LightweightTypeReference reference, ResourceSet resourceSet);
	
}
