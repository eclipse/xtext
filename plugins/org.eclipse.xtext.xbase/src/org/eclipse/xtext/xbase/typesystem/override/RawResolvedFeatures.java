/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.override;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.IMirrorExtension;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RawResolvedFeatures extends AbstractResolvedFeatures implements Adapter, Runnable {

	public static RawResolvedFeatures getResolvedFeatures(JvmType type, CommonTypeComputationServices services) {
		List<Adapter> adapterList = type.eAdapters();
		RawResolvedFeatures adapter = (RawResolvedFeatures) EcoreUtil.getAdapter(adapterList, RawResolvedFeatures.class);
		if (adapter != null) {
			return adapter;
		}
		adapter = new RawResolvedFeatures(type, services);
		requestNotificationOnChange(type, adapter);
		adapterList.add(adapter);
		return adapter;
	}
	
	public void run() {
		featureIndex.clear();
	}
	
	protected static void requestNotificationOnChange(JvmType type, Runnable listener) {
		Resource resource = type.eResource();
		if (resource instanceof TypeResource) {
			IMirror mirror = ((TypeResource) resource).getMirror();
			if (mirror instanceof IMirrorExtension) {
				if (((IMirrorExtension) mirror).isSealed())
					return;
			}
		}
		Notifier notifier = type;
		if (resource != null) {
			if (resource.getResourceSet() != null)
				notifier = resource.getResourceSet();
			else
				notifier = resource;
		}
		JvmTypeChangeDispatcher dispatcher = JvmTypeChangeDispatcher.findResourceChangeDispatcher(notifier);
		dispatcher.requestNotificationOnChange(type, listener);
	}
	
	protected static LightweightTypeReference createTypeReference(JvmType type, CommonTypeComputationServices services) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, type);
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, type);
		if (type instanceof JvmGenericType) {
			for(JvmTypeParameter typeParameter: ((JvmGenericType) type).getTypeParameters()) {
				result.addTypeArgument(new ParameterizedTypeReference(owner, typeParameter));
			}
		}
		return result;
	}
	
	private final Map<String, List<JvmFeature>> featureIndex;
	
	public RawResolvedFeatures(JvmType type, CommonTypeComputationServices services) {
		this(createTypeReference(type, services), new OverrideTester());
	}
	
	public RawResolvedFeatures(LightweightTypeReference type, OverrideTester overrideTester) {
		super(type, overrideTester);
		this.featureIndex = Maps.newHashMapWithExpectedSize(4);
	}
	
	public ParameterizedResolvedFeatures getParameterizedView(LightweightTypeReference concrete) {
		return new ParameterizedResolvedFeatures(concrete, this);
	}
	
	public List<JvmFeature> getAllFeatures(String simpleName) {
		List<JvmFeature> result = featureIndex.get(simpleName);
		if (result == null) {
			featureIndex.put(simpleName, result = computeAllFeatures(simpleName));
		}
		return result;
	}

	protected List<JvmFeature> computeAllFeatures(String simpleName) {
		JvmType rawType = getRawType();
		if (!(rawType instanceof JvmDeclaredType)) {
			return Collections.emptyList();
		}
		List<JvmFeature> result = Lists.newArrayList();
		Multimap<String, AbstractResolvedOperation> processed = HashMultimap.create();
		Set<String> processedFields = Sets.newHashSetWithExpectedSize(5);
		computeAllFeatures((JvmDeclaredType)rawType, simpleName, processed, processedFields, result);
		return Collections.unmodifiableList(result);
	}
	
	protected void computeAllFeatures(
			JvmDeclaredType type,
			String name,
			Multimap<String, AbstractResolvedOperation> processedOperations,
			Set<String> processedFields,
			List<JvmFeature> result) {
		Iterable<JvmFeature> features = type.findAllFeaturesByName(name);
		for(JvmFeature feature: features) {
			if (feature instanceof JvmOperation) {
				JvmOperation operation = (JvmOperation) feature;
				String simpleName = operation.getSimpleName();
				if (processedOperations.containsKey(simpleName)) {
					if (isOverridden(operation, processedOperations.get(simpleName))) {
						continue;
					}
				}
				BottomResolvedOperation resolvedOperation = createResolvedOperation(operation);
				processedOperations.put(simpleName, resolvedOperation);
				result.add(operation);	
			} else if (feature instanceof JvmField && processedFields.add(feature.getSimpleName())) {
				result.add(feature);
			}
		}
	}

	public void notifyChanged(Notification notification) {
	}

	public Notifier getTarget() {
		return null;
	}

	public void setTarget(Notifier newTarget) {
	}

	public boolean isAdapterForType(Object type) {
		return RawResolvedFeatures.class.equals(type);
	}
}
