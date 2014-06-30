/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;

import com.google.inject.ImplementedBy;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * TODO JavaDoc, toString
 */
@ImplementedBy(AbstractRootedReentrantTypeResolver.class)
public interface IReentrantTypeResolver {

	void initializeFrom(EObject root);

	IResolvedTypes reentrantResolve();
	
	IReentrantTypeResolver NULL = new IReentrantTypeResolver() {
		
		public IResolvedTypes reentrantResolve() {
			return IResolvedTypes.NULL;
		}
		
		public void initializeFrom(EObject root) {
			// ignore
		}
	};
	
}
