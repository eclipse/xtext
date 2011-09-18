/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.util.IAcceptor;

import com.google.inject.ImplementedBy;

/**
 * <p>
 * The model inferrer adapts a given source object with a {@link JvmDeclaredType} that mimics the interface of the
 * source object and its children.
 * </p>
 * <p>
 * Implementors have to traverse the given source object in {@link #inferJvmModel(EObject)} and decide which types to
 * create according to the state of the model.
 * </p>
 * 
 * @see IJvmModelAssociations
 * @see IJvmModelAssociator
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 */
@ImplementedBy(IJvmModelInferrer.NullImpl.class)
public interface IJvmModelInferrer {

	/**
	 * is called for the root element of a resource just once.
	 * 
	 * @param e
	 *            - the root element from the parse result
	 * @param acceptor
	 *            - an acceptor awaiting derived {@link JvmDeclaredType}s
	 * @param prelinkingPhase
	 *            -  whether the call is done in a pre-linking phase. During this phase clients may not do linking which
	 *            relies on indexed information, because the index might not be fully computed yet.
	 */
	void infer(EObject e, IAcceptor<JvmDeclaredType> acceptor, boolean prelinkingPhase);

	/**
	 * A null-implementation.
	 */
	public static class NullImpl implements IJvmModelInferrer {

		public void infer(EObject e, IAcceptor<JvmDeclaredType> acceptor, boolean prelinkingPhase) {}

	}

}
