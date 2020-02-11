/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.util;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typing.IJvmTypeReferenceProvider;
import org.eclipse.xtext.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractReentrantTypeReferenceProvider implements IJvmTypeReferenceProvider {

	private boolean computing = false;

	@Override
	public final JvmTypeReference getTypeReference(/* @NonNull */ XComputedTypeReferenceImplCustom context) {
		if (computing)
			return handleReentrantInvocation(context);
		try {
			computing = true;
			return doGetTypeReference(context);
		} finally {
			computing = false;
		}
	}
	
	protected void markComputing() {
		this.computing = true;
	}
	
	protected void unmarkComputing() {
		this.computing = false;
	}
	
	public boolean isComputing() {
		return computing;
	}
	
	/**
	 * Allows to deal with reentrant invocation for the given context.
	 * @param context the reference that is part of a recursive call graph..
	 */
	protected JvmTypeReference handleReentrantInvocation(/* @NonNull */ XComputedTypeReferenceImplCustom context) {
		return null;
	}

	protected abstract JvmTypeReference doGetTypeReference(/* @NonNull */ XComputedTypeReferenceImplCustom context);
	
	@Override
	public String toString() {
		return String.format("%s[computing=%s]", getClass().getSimpleName(), computing);
	}
}
