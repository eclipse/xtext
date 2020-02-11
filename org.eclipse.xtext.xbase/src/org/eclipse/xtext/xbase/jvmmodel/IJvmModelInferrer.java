/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * Implementors have to traverse the given source object in {@link #infer(EObject, IJvmDeclaredTypeAcceptor, boolean) infer(..)} and decide which types to
 * create according to the state of the model.
 * </p>
 * 
 * @see IJvmModelAssociations
 * @see IJvmModelAssociator
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sven Efftinge
 * 
 * @since 2.7
 * 
 * @noimplement This interface should not be implemented directly. Clients should subclass {@link AbstractModelInferrer} instead.
 */
@ImplementedBy(IJvmModelInferrer.NullImpl.class)
public interface IJvmModelInferrer {

	/**
	 * <p>
	 * This method is called at two different times in a resource's life-cycle, reflected by whether {preIndexingPhase}
	 * is set to <code>true</code> or <code>false</code>. When set to <code>true</code> everything is still in a
	 * pre-indexing phase, that means linking hasn't been done yet. In this phase you just need to create the Jvm-elements
	 * which should be indexed (i.e. found globally). For regular Xbase expressions only the JvmTypes with the correct
	 * qualified name are needed at this point.
	 * </p>
	 * <p>
	 * You must only infer Jvm elements which directly result from elements contained in the current resource!
	 * </p>
	 * <p>
	 * When this method is called with preIndexingPhase set to <code>false</code>, you need to do the full inference
	 * including setting all links. But still you have to it in a particular order. First you need to create the
	 * complete tree structure and make sure you have passed the created JvmTypes to the acceptor. Only pass top level
	 * {@link org.eclipse.xtext.common.types.JvmType}s to the acceptor. Only if the tree structure is created and its
	 * root types have been passed to the acceptor, you are free to resolve any cross references.</li>
	 * </p>
	 * 
	 * @param e
	 *            the root element from the parse result
	 * @param acceptor
	 *            an acceptor awaiting derived root {@link JvmDeclaredType}s
	 * @param preIndexingPhase
	 *            whether the call is done in before indexing. During this phase clients may not rely on any global indexing information 
	 *            and only need to to provide the information needed by the language's {@link org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy}.
	 *            IF not implemented differently this is just the {@link JvmDeclaredType}s with their qualified name, but no members and no other data.
	 */
	void infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase);

	/**
	 * A null-implementation.
	 */
	public static class NullImpl implements IJvmModelInferrer {

		@Override
		public void infer(EObject e, /* @NonNull */ IJvmDeclaredTypeAcceptor acceptor, boolean preIndexingPhase) {
		}

	}

}
