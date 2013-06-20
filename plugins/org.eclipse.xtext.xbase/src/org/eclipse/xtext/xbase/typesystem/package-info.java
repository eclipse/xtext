/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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