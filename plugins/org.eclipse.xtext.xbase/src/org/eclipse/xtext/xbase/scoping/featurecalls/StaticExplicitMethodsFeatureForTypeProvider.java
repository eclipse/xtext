/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.Primitives;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StaticExplicitMethodsFeatureForTypeProvider extends AbstractStaticMethodsFeatureForTypeProvider {

	@Inject
	private Primitives primitives;

	private JvmTypeReference currentType;

	public JvmTypeReference getCurrentType() {
		return currentType;
	}

	public void setTypeContext(JvmTypeReference currentType) {
		this.currentType = currentType;
	}

	@Override
	protected Map<JvmTypeReference, Collection<JvmTypeReference>> getVisibleJvmTypesContainingStaticMethods(
			Iterable<JvmTypeReference> hierarchy) {
		Multimap<JvmTypeReference, JvmTypeReference> result = HashMultimap.create();
		if (currentType != null) {
			JvmType type = currentType.getType();
			if (type instanceof JvmGenericType) {
				JvmGenericType genericType = (JvmGenericType) type;
				for (JvmFeature feature : genericType.getAllFeatures()) {
					if (feature instanceof JvmOperation && ((JvmOperation) feature).isStatic()) {
						JvmOperation operation = (JvmOperation) feature;
						result.put(null, currentType);
						if (!operation.getParameters().isEmpty()) {
							JvmTypeReference paramType = operation.getParameters().get(0).getParameterType();
							JvmTypeReference wrapped = primitives.asWrapperTypeIfPrimitive(paramType);
							result.put(wrapped, currentType);
						}
					} else if (feature instanceof JvmField && ((JvmField) feature).isStatic())
						result.put(null, currentType);
				}
			}
		}
		return result.asMap();
	}

}
