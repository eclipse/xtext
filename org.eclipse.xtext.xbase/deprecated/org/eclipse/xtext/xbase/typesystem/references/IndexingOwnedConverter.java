/*******************************************************************************
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @deprecated use the {@link IndexingLightweightTypeReferenceFactory} instead. 
 */
@Deprecated
public class IndexingOwnedConverter extends IndexingLightweightTypeReferenceFactory {

	public IndexingOwnedConverter(ITypeReferenceOwner owner) {
		super(owner);
	}

	public IndexingOwnedConverter(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		super(owner, keepUnboundWildcards);
	}

}