/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * The strategy interface passed to instances of {@link IJvmFeatureScopeProvider}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IJvmFeatureDescriptionProvider {
	
	/**
	 * Used to name scopes created using this provider
	 */
	String getText();

	Iterable<IEObjectDescription> getDescriptionsByName(
			String name, IFeaturesForTypeProvider featureProvider, JvmTypeReference typeReference,
			TypeArgumentContext context, Iterable<JvmTypeReference> hierarchy);

	Iterable<IEObjectDescription> getAllDescriptions(IFeaturesForTypeProvider featureProvider,
			JvmTypeReference typeReference, TypeArgumentContext context, Iterable<JvmTypeReference> hierarchy);
	
}