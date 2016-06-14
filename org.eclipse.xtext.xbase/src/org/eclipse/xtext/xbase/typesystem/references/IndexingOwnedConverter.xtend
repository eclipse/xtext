/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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