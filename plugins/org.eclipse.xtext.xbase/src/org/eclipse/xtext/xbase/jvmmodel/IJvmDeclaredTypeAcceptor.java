/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.jvmmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.xbase.lib.Procedures;

/**
 * The acceptor is part of the {@link IJvmModelInferrer} API.
 * It's passed into {@link IJvmModelInferrer#infer(EObject, IJvmDeclaredTypeAcceptor) infer(..)} to accept 
 * created {@link JvmDeclaredType}. They will be added
 * to the {@link EObject}'s {@link org.eclipse.emf.ecore.resource.Resource} of the {@link EObject}.
 * 
 * @noextend This interface is not intended to be extended by clients.
 * 
 * @author Sven Efftinge - initial API
 */
public interface IJvmDeclaredTypeAcceptor {
	
	/**
	 * Accepts a {@link JvmDeclaredType} with no container, to be added to the contents list of a {@link org.eclipse.emf.ecore.resource.Resource}.
	 * @return a {@link IPostIndexingInitializing} to provide a post-indexing initialization of the given type.
	 */
	<T extends JvmDeclaredType> IJvmDeclaredTypeAcceptor.IPostIndexingInitializing<T> accept(T type);
	
	/**
	 * Code that should be executed to complete the model inference and adds information not necessary for indexing.
	 * Also only code executed in runnable might resolve some cross references, but not resolve any XExpressions as they require the full
	 * JvmTypes to be computed.
	 */
	void runAfterIndexing(Runnable runnable);
	
	interface IPostIndexingInitializing<T extends JvmDeclaredType> {
		
		/**
		 * The passed procedure will be executed in the post-indexing phase, and it is executed after all {@link JvmDeclaredType} are created
		 * and attached to the {@link org.eclipse.emf.ecore.resource.Resource}.
		 */
		void initializeLater(Procedures.Procedure1<? super T> lateInitialization);
	}
}