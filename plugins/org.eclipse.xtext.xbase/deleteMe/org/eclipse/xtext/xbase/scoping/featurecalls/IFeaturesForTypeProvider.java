/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
@ImplementedBy(DefaultFeaturesForTypeProvider.class)
public interface IFeaturesForTypeProvider {
	
	@Override
	String toString();
	
	boolean isExtensionProvider();

	// TODO use a specialized IJvmTypeHierarchy instance that allows to obtain more information
	// e.g. constant time lookup of prepared synonym types
	Iterable<JvmFeature> getFeaturesByName(
			String name, 
			JvmTypeReference declarator, 
			Iterable<JvmTypeReference> hierarchy);

	// TODO use a specialized IJvmTypeHierarchy instance that allows to obtain more information
	// e.g. constant time lookup of prepared synonym types
	Iterable<JvmFeature> getAllFeatures(
			JvmTypeReference typeReference,
			Iterable<JvmTypeReference> hierarchy);
}
