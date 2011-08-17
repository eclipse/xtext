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
import org.eclipse.xtext.common.types.util.TypeArgumentContext;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(DefaultFeaturesForTypeProvider.class)
public interface IFeaturesForTypeProvider {
	
	boolean isExtensionProvider();

	// TODO use synonymes/synonym hierarchy in addition to hierarchy
	Iterable<JvmFeature> getFeaturesByName(
			String name, JvmTypeReference declarator,
			TypeArgumentContext context, Iterable<JvmTypeReference> hierarchy);

	// TODO use synonymes/synonym hierarchy in addition to hierarchy
	Iterable<JvmFeature> getAllFeatures(JvmTypeReference typeReference, TypeArgumentContext context,
			Iterable<JvmTypeReference> hierarchy);
}
