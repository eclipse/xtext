/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.internal.CachingBatchTypeResolver;

import com.google.inject.ImplementedBy;

/**
 * The {@link IBatchTypeResolver batch type resolver} is the entry point for clients
 * to obtain the expression types within a given context {@link EObject object}.
 * 
 * The context is most likely an {@link XExpression expression} or a 
 * {@link JvmIdentifiableElement logical container} but the interface does not impose
 * any restriction on this one.
 * 
 * The obtained instance of {@link IResolvedTypes resolved types} does not make any promises
 * with respect to eager resolution or laziness, but answers all queries for types
 * that are related to the context that was used to get the resolved types itself.
 * 
 * Generally speaking, all expressions within the very same resource can be used
 * to query the {@link IResolvedTypes types}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(CachingBatchTypeResolver.class)
public interface IBatchTypeResolver {

	/**
	 * Return a handle to resolved types of expressions that are related
	 * to the given {@code object}.
	 * 
	 * @param object the context that describes the expressions that will be used
	 * to query the resolved types.
	 * @return a handle to resolved types of expressions and identifiables.
	 */
	/* @NonNull */
	IResolvedTypes resolveTypes(/* @Nullable */ EObject object);
	
	/**
	 * Return a handle to resolved types of expressions that are related
	 * to the given {@code resource}.
	 * 
	 * @param resource the resource that shall be resolved.
	 * @return a handle to resolved types of expressions and identifiables.
	 */
	/* @NonNull */
	IResolvedTypes resolveTypes(/* @NonNull */ Resource resource);
	
	/**
	 * Return a handle to resolved types of expressions that are related
	 * to the given {@code object}.
	 * 
	 * @param object the context that describes the expressions that will be used
	 * to query the resolved types.
	 * @param monitor used to cancel type resolution, e.g. by the reconciler.
	 * @return a handle to resolved types of expressions and identifiables.
	 * @since 2.7
	 */
	/* @NonNull */
	IResolvedTypes resolveTypes(/* @Nullable */ EObject object, CancelIndicator monitor);
	
	/**
	 * Return a handle to resolved types of expressions that are related
	 * to the given {@code resource}.
	 * 
	 * @param resource the resource that shall be resolved.
	 * @param monitor used to cancel type resolution, e.g. by the reconciler.
	 * @return a handle to resolved types of expressions and identifiables.
	 * @since 2.7
	 */
	/* @NonNull */
	IResolvedTypes resolveTypes(/* @NonNull */ Resource resource, CancelIndicator monitor);
}
