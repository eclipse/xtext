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
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDelegatingResolvedTypes implements IResolvedTypes {

	protected abstract IResolvedTypes getDelegate();

	public List<Diagnostic> getQueuedDiagnostics() {
		return getDelegate().getQueuedDiagnostics();
	}

	public JvmTypeReference getActualType(XExpression expression) {
		return getDelegate().getActualType(expression);
	}

	public JvmTypeReference getActualType(JvmIdentifiableElement identifiable) {
		return getDelegate().getActualType(identifiable);
	}

	public JvmTypeReference getExpectedType(XExpression expression) {
		return getDelegate().getExpectedType(expression);
	}

	public List<JvmTypeReference> getActualTypeArguments(XExpression expression) {
		return getDelegate().getActualTypeArguments(expression);
	}
	
}
