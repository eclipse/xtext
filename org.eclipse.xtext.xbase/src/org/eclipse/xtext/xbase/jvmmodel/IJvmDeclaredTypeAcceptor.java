/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.Procedures;

/**
 * The acceptor is part of the {@link IJvmModelInferrer} API.
 * It's passed into {@link IJvmModelInferrer#infer(EObject, IJvmDeclaredTypeAcceptor, boolean) infer(..)} to accept 
 * created {@link JvmDeclaredType}. They will be added
 * to the {@link EObject}'s {@link org.eclipse.emf.ecore.resource.Resource} of the {@link EObject}.
 * 
 * @author Sven Efftinge - initial API
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 * 
 * @since 2.7
 */
public interface IJvmDeclaredTypeAcceptor {
	
	/**
	 * Accepts a {@link JvmDeclaredType} with no container, to be added to the contents list of a {@link org.eclipse.emf.ecore.resource.Resource}.
	 * @return don't reference. the return type is deprecated
	 */
	<T extends JvmDeclaredType> IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<T> accept(T type);
	
	/**
	 * Accepts a {@link JvmDeclaredType} with no container, to be added to the contents list of a {@link org.eclipse.emf.ecore.resource.Resource}.
	 * The second parameter is a lazy initializer that is never executed during <i>preIndexingPhase</i>. 
	 * 
	 * @see IJvmModelInferrer#infer(EObject, IJvmDeclaredTypeAcceptor, boolean)
	 * 
	 * @param type the type to
	 * @param lateInitialization the initializer
	 */
	<T extends JvmDeclaredType> void accept(T type, Procedures.Procedure1<? super T> lateInitialization);
	
	/**
	 * @deprecated use {@link #accept(JvmDeclaredType, org.eclipse.xtext.xbase.lib.Procedures.Procedure1)} instead
	 */
	@Deprecated
	interface IPostIndexingInitializing<T extends JvmDeclaredType> {
		/**
		 * The passed procedure will be executed only if in post-indexing phase, and it is executed after all {@link JvmDeclaredType} are created
		 * and attached to the {@link org.eclipse.emf.ecore.resource.Resource}.
		 * 
		 * @deprecated use {@link #accept(JvmDeclaredType, org.eclipse.xtext.xbase.lib.Procedures.Procedure1)} instead
		 */
		@Deprecated
		void initializeLater(Procedures.Procedure1<? super T> lateInitialization);
	}
}