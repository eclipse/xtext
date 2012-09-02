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
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ForwardingObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class ForwardingResolvedTypes extends ForwardingObject implements IResolvedTypes {

	@Override
	protected abstract IResolvedTypes delegate();
	
	@Nullable
	public LightweightTypeReference getActualType(XExpression expression) {
		return delegate().getActualType(expression);
	}
	
	@Nullable
	public LightweightTypeReference getReturnType(XExpression expression) {
		return delegate().getReturnType(expression);
	}

	@Nullable
	public LightweightTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return delegate().getActualType(identifiable);
	}

	@Nullable
	public LightweightTypeReference getExpectedType(XExpression expression) {
		return delegate().getExpectedType(expression);
	}

	public List<LightweightTypeReference> getActualTypeArguments(XExpression expression) {
		return delegate().getActualTypeArguments(expression);
	}

	public List<Diagnostic> getQueuedDiagnostics() {
		return delegate().getQueuedDiagnostics();
	}

}
