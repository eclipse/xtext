/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @deprecated use the {@link IndexingLightweightTypeReferenceFactory} instead. 
 */
@Deprecated
class IndexingOwnedConverter extends IndexingLightweightTypeReferenceFactory {

	new(ITypeReferenceOwner owner) {
		super(owner)
	}

	new(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		super(owner, keepUnboundWildcards)
	}

}