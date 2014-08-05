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

import com.google.inject.ImplementedBy;

/**
 * <p>
 * Model inference is done after a resource has been loaded. It is used to map you language's constructs to the elements
 * defined in {@link org.eclipse.xtext.common.types.TypesPackage}. Those elements closely reflect the Java type model.
 * </p>
 * <p>
 * For example if you have a language representing state machines with its states, transitions and actions, one way to
 * map them to the types model would be to create a single class per state machine, an {@link Enum} for the different states,
 * methods for the various actions and one method which contains the state machine logic. You would do that mapping in
 * your language's implementation of this interface.
 * </p>
 * <p>
 * The inferred Jvm type model is used to compute how scoping is done and how the language compiles to Java. That is having a 
 * proper implementation of this interface is often the only thing you need to do to make your language executable on the JVM.
 * </p>
 * <p>
 * Implementers should use the {@link JvmTypesBuilder} API to create a model of Jvm elements in a convenient way. 
 * </p>
 * <p>
 * Implementors have to traverse the given source object in {@link #infer(EObject, IJvmDeclaredTypeAcceptor) infer(..)} and decide which types to
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
	 * <p>
	 * This method is called to compute the JvmTypes inferred from a model.
	 * It is critical that only the creation of types and computation of their names is done directly
	 * when called. All further computation should be done in runnables that are passed to {@link IJvmDeclaredTypeAcceptor}.
	 * </p>
	 * <p>
	 * The framework will execute them after the indexing phase.
	 * </p>
	 * <p>
	 * You must only infer Jvm elements which directly result from elements contained in the current resource!
	 * </p>
	 * 
	 * @param e
	 *            the root element from the parse result
	 * @param acceptor
	 *            an acceptor awaiting derived root {@link JvmDeclaredType}s
	 */
	void infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor);

	/**
	 * A null-implementation.
	 */
	public static class NullImpl implements IJvmModelInferrer {

		public void infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor) {
		}

	}

}
