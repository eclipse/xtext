/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

/**
 * Functional interface that is used to initialize newly created type references
 * from {@link ITypeReferenceOwner#newReferenceTo(Class, TypeReferenceInitializer)}.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface TypeReferenceInitializer<Ref extends LightweightTypeReference> {

	/**
	 * Enhance the given reference and return itself or a wrapper around it, e.g.
	 * a newly created wildcard.
	 */
	LightweightTypeReference enhance(Ref reference);
	
}
