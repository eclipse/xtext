/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated
public abstract class AbstractStaticMethodsFeatureForTypeProvider extends AbstractFeaturesForTypeProvider {

	@Inject
	protected IResourceScopeCache cache;
	
	protected Resource context;

	public Iterable<JvmFeature> getFeaturesByName(String name, JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		Set<JvmFeature> result = Sets.newLinkedHashSet();
		if (declarator != null) {
			collectFeatures(name, hierarchy, result);	
		} else {
			collectFeatures(name, null, result);
		}
		return result;
	}
	
	public final Iterable<JvmFeature> getAllFeatures(JvmTypeReference declarator,
			Iterable<JvmTypeReference> hierarchy) {
		Set<JvmFeature> result = Sets.newLinkedHashSet();
		if (declarator != null) {
			collectFeatures(null, hierarchy, result);	
		} else {
			collectFeatures(null, null, result);
		}
		return result;
	}

	protected void collectFeatures(String name, Iterable<JvmTypeReference> hierarchy, Collection<JvmFeature> result) {
		final Map<JvmTypeReference, Collection<JvmTypeReference>> staticTypeNames = getVisibleJvmTypesContainingStaticMethods(hierarchy);
		for (final Map.Entry<JvmTypeReference, Collection<JvmTypeReference>> e : staticTypeNames.entrySet()) {
			for(final JvmTypeReference staticType: e.getValue()) {
				List<JvmType> rawTypes = getRawTypeHelper().getAllRawTypes(staticType, context);
				for(JvmType rawType: rawTypes) {
					if (rawType instanceof JvmDeclaredType) {
						Iterable<JvmFeature> features = name != null ? ((JvmDeclaredType) rawType).findAllFeaturesByName(name) : ((JvmDeclaredType) rawType).getAllFeatures();
						for(JvmFeature feature: features) {
							if (feature instanceof JvmOperation) {
								if (isMatchingExtension(e.getKey(), (JvmOperation) feature)) {
									result.add(feature);
								}
							} else if (feature instanceof JvmField) {
								if (((JvmField) feature).isStatic() && e.getKey() == null)
									result.add(feature);
							}
						}
					}
				}
			}
		}
	}
	
	protected boolean isMatchingExtension(JvmTypeReference expectedParameterTypeReference, JvmOperation operation) {
		if (operation.isStatic()) {
			if (expectedParameterTypeReference == null)
				return true;
			if (operation.getParameters().size() > 0) {
				JvmFormalParameter firstParam = operation.getParameters().get(0);
				return super.isSameTypeOrAssignableToUpperBound(expectedParameterTypeReference, firstParam.getParameterType());
			}
		}
		return false;
	}

	protected Map<JvmTypeReference, Collection<JvmTypeReference>> getVisibleJvmTypesContainingStaticMethods(
			Iterable<JvmTypeReference> hierarchy) {
		Multimap<JvmTypeReference, JvmTypeReference> result = LinkedListMultimap.create();
		final Map<JvmTypeReference, Collection<String>> staticTypeNames = getVisibleTypesContainingStaticMethods(hierarchy);
		for (final Map.Entry<JvmTypeReference, Collection<String>> e : staticTypeNames.entrySet()) {
			for (final String staticTypeName : e.getValue()) {
				JvmTypeReference staticType = cache.get(Tuples.create(this, staticTypeName), context,
						new Provider<JvmTypeReference>() {
							public JvmTypeReference get() {
								return getTypeReferences().getTypeForName(staticTypeName, context);
							}
						});
				if (staticType != null)
					result.put(e.getKey(), staticType);
			}
		}
		return result.asMap();
	}
	
	protected abstract Map<JvmTypeReference, Collection<String>> getVisibleTypesContainingStaticMethods(
			Iterable<JvmTypeReference> hierarchy);

	public void setResourceContext(Resource context) {
		this.context = context;
	}
	
	protected Resource getContext() {
		return context;
	}
	
	private boolean isExtensionProvider = false;
	
	public boolean isExtensionProvider() {
		return isExtensionProvider;
	}
	
	public void setExtensionProvider(boolean isExtensionProvider) {
		this.isExtensionProvider = isExtensionProvider;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [context=" + getContextURI() + ", isExtensionProvider="
				+ isExtensionProvider + "]";
	}
	
	protected String getContextURI() {
		return context == null ? "" : String.valueOf(context.getURI().lastSegment());
	}

}
