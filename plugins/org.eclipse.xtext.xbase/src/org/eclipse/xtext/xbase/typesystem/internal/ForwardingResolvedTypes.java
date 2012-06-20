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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.ForwardingObject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class ForwardingResolvedTypes extends ForwardingObject implements LightweightResolvedTypes {

	@Override
	protected abstract LightweightResolvedTypes delegate();
	
	public JvmTypeReference getActualType(XExpression expression) {
		return delegate().getActualType(expression);
	}

	public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return delegate().getActualType(identifiable);
	}

	public JvmTypeReference getExpectedType(XExpression expression) {
		return delegate().getExpectedType(expression);
	}

	public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
		return delegate().getActualTypeArguments(expression);
	}

	public List<Diagnostic> getQueuedDiagnostics() {
		return delegate().getQueuedDiagnostics();
	}

	public LightweightTypeReference internalGetActualType(XExpression expression) {
		return delegate().internalGetActualType(expression);
	}

	public LightweightTypeReference internalGetActualType(JvmIdentifiableElement identifiable) {
		return delegate().internalGetActualType(identifiable);
	}

	public LightweightTypeReference internalGetExpectedType(XExpression expression) {
		return delegate().internalGetExpectedType(expression);
	}

	public List<LightweightTypeReference> internalGetActualTypeArguments(XExpression expression) {
		return delegate().internalGetActualTypeArguments(expression);
	}

}
