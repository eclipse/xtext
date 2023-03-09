/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnboundTypeReferenceResolver extends AbstractReentrantTypeReferenceProvider {
	private UnboundTypeReference unboundTypeReference;

	public UnboundTypeReferenceResolver(UnboundTypeReference unboundTypeReference) {
		this.unboundTypeReference = unboundTypeReference;
	}

	@Override
	protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
		LightweightTypeReference resolvedTo = unboundTypeReference.resolve();
		return resolvedTo.toTypeReference();
	}
	
	public UnboundTypeReference getUnboundTypeReference() {
		return unboundTypeReference;
	}
}