/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;

import com.google.inject.ImplementedBy;

/**
 * Abstract base implementation for resolvers that work with a single root instance.
 * 
 * Implementation detail: This is not an interface since the declared methods shall be
 * protected.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(DefaultReentrantTypeResolver.class)
public abstract class AbstractRootedReentrantTypeResolver implements IReentrantTypeResolver {

	protected abstract EObject getRoot();
	
	protected abstract boolean isHandled(XExpression expression);
	
	protected abstract boolean isHandled(JvmIdentifiableElement identifiableElement);
	
	protected abstract boolean isHandled(EObject context);
	
	@Override
	public String toString() {
		return String.format("%s[root=%s]", getClass().getSimpleName(), getRoot());
	}
	
}
