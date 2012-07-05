/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ForwardingObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class ForwardingResolvedTypes extends ForwardingObject implements LightweightResolvedTypes {

	@Override
	protected abstract LightweightResolvedTypes delegate();
	
	@Nullable
	public JvmTypeReference getActualType(XExpression expression) {
		return delegate().getActualType(expression);
	}

	@Nullable
	public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return delegate().getActualType(identifiable);
	}

	@Nullable
	public JvmTypeReference getExpectedType(XExpression expression) {
		return delegate().getExpectedType(expression);
	}

	public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
		return delegate().getActualTypeArguments(expression);
	}

	public List<Diagnostic> getQueuedDiagnostics() {
		return delegate().getQueuedDiagnostics();
	}

	@Nullable
	public LightweightTypeReference internalGetActualType(XExpression expression) {
		return delegate().internalGetActualType(expression);
	}

	@Nullable
	public LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable) {
		return delegate().internalGetActualType(identifiable);
	}

	@Nullable
	public LightweightTypeReference internalGetExpectedType(XExpression expression) {
		return delegate().internalGetExpectedType(expression);
	}

	public List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression) {
		return delegate().internalGetActualTypeArguments(expression);
	}

}
