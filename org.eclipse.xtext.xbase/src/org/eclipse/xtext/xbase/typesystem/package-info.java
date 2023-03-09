/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
/**
 * This package is the entry point for clients of the Xbase type inference.
 * The main service is the {@link org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver batch type resolver}
 * which allows to retrieve {@link org.eclipse.xtext.xbase.typesystem.IResolvedTypes resolved types} 
 * for a given {@link org.eclipse.emf.ecore.EObject context}.
 * 
 * The second important service is the {@link org.eclipse.xtext.xbase.typesystem.InferredTypeIndicator indicator}
 * for inferred types on the level of {@link org.eclipse.xtext.common.types.JvmTypeReference type references}
 * in the model EMF model itself.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
package org.eclipse.xtext.xbase.typesystem;