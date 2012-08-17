/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Function;

/**
 * The strategy interface passed to instances of {@link IJvmFeatureScopeProvider}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated
public interface IJvmFeatureDescriptionProvider {

	@Override
	String toString();
	
	void setPriority(int priority);
	
	int getPriority();

	Iterable<IEObjectDescription> getDescriptionsByName(
			String name, 
			IFeaturesForTypeProvider featureProvider, 
			JvmTypeReference typeReference,
			Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> genericContextFactory,
			ITypeArgumentContext rawTypeContext, 
			Iterable<JvmTypeReference> hierarchy);

	Iterable<IEObjectDescription> getAllDescriptions(
			IFeaturesForTypeProvider featureProvider,
			JvmTypeReference typeReference, 
			Function<? super JvmFeatureDescription, ? extends ITypeArgumentContext> genericContextFactory,
			ITypeArgumentContext rawTypeContext, 
			Iterable<JvmTypeReference> hierarchy);
	
}