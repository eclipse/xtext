/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.common.types.JvmType

import static org.eclipse.xtext.common.types.TypesPackage.Literals.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class IndexingOwnedConverter extends OwnedConverter {

	new(ITypeReferenceOwner owner) {
		super(owner)
	}

	new(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		super(owner, keepUnboundWildcards)
	}

	override protected getType(JvmParameterizedTypeReference it) {
		switch proxy : eGet(JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, false) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				return eResource.resourceSet.getEObject(uri, true) as JvmType
			}
			JvmType: {
				proxy
			}
		}
	}

}
