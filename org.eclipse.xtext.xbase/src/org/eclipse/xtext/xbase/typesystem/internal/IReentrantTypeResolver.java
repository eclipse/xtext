/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.CancelIndicator;
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

	IResolvedTypes reentrantResolve(CancelIndicator monitor) throws OperationCanceledError;
	
	IReentrantTypeResolver NULL = new IReentrantTypeResolver() {
		
		@Override
		public IResolvedTypes reentrantResolve(CancelIndicator monitor) {
			return IResolvedTypes.NULL;
		}
		
		@Override
		public void initializeFrom(EObject root) {
			// ignore
		}
	};
	
}
