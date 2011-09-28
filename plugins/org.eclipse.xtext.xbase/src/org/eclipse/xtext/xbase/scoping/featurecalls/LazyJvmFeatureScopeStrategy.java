/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LazyJvmFeatureScopeStrategy {

	private final IJvmFeatureDescriptionProvider jvmFeatureDescriptionProvider;
	private final JvmTypeReference typeReference;
	private final ITypeArgumentContext context;
	private final Iterable<JvmTypeReference> hierarchy;
	private final IFeaturesForTypeProvider featureProvider;

	public LazyJvmFeatureScopeStrategy(IJvmFeatureDescriptionProvider jvmFeatureDescriptionProvider,
			IFeaturesForTypeProvider featureProvider, JvmTypeReference typeReference, 
			ITypeArgumentContext context, Iterable<JvmTypeReference> hierarchy) {
		if (typeReference != null && typeReference.getType() == null)
			throw new NullPointerException("typeReference#type");
		this.jvmFeatureDescriptionProvider = jvmFeatureDescriptionProvider;
		this.featureProvider = featureProvider;
		this.typeReference = typeReference;
		this.context = context;
		this.hierarchy = hierarchy;
	}

	public Iterable<IEObjectDescription> getDescriptionsByName(QualifiedName name) {
		return jvmFeatureDescriptionProvider.getDescriptionsByName(name.toString(), featureProvider, typeReference, context, hierarchy);
	}

	public Iterable<IEObjectDescription> getAllDescriptions() {
		return jvmFeatureDescriptionProvider.getAllDescriptions(featureProvider, typeReference, context, hierarchy);
	}

}
