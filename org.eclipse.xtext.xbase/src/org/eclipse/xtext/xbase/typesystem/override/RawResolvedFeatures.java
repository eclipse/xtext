/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.IMirrorExtension;
import org.eclipse.xtext.common.types.access.JvmTypeChangeDispatcher;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

/**
 * The {@link RawResolvedFeatures} allow to obtain the actual API of a {@link JvmType}.
 * This means, it properly applies shadowing semantics and override resolution, especially
 * if type parameters and type arguments are present.
 * 
 * Concrete instances of {@link RawResolvedFeatures} are obtained via 
 * {@link #getResolvedFeatures(JvmDeclaredType, CommonTypeComputationServices)}
 * and are cached per {@link JvmType}. They will invalidate themselves on change.
 * 
 * Instances of this class are not expected to be used concurrently. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RawResolvedFeatures extends AbstractResolvedFeatures implements Adapter, IResolvedFeatures {

	/**
	 * Returns an existing instance of {@link RawResolvedFeatures} or creates a new one that
	 * will be cached on the type. It will not add itself as {@link EContentAdapter} but use
	 * the {@link JvmTypeChangeDispatcher} instead.
	 */
	static RawResolvedFeatures getResolvedFeatures(JvmDeclaredType type, CommonTypeComputationServices services) {
		final List<Adapter> adapterList = type.eAdapters();
		RawResolvedFeatures adapter = (RawResolvedFeatures) EcoreUtil.getAdapter(adapterList, RawResolvedFeatures.class);
		if (adapter != null) {
			return adapter;
		}
		final RawResolvedFeatures newAdapter = new RawResolvedFeatures(type, services);
		requestNotificationOnChange(type, new Runnable() {
			@Override
			public void run() {
				newAdapter.clear();
				adapterList.remove(newAdapter);
			}
		});
		adapterList.add(newAdapter);
		return newAdapter;
	}
	
	/**
	 * Registers the given listener to be notified on type changes, if (and only if) the type
	 * if expected to be changeable.
	 * 
	 * @see IMirrorExtension#isSealed()
	 */
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
	
	/**
	 * Static helper method that is used from within the super call in the constructor of
	 * {@link RawResolvedFeatures}.
	 */
	private static LightweightTypeReference createTypeReference(JvmDeclaredType type, CommonTypeComputationServices services) {
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, type);
		return owner.newParameterizedTypeReference(type);
	}
	
	/**
	 * The list of reachable features indexed by simple name.
	 * The contained lists are unmodifiable.
	 */
	private final Map<String, List<JvmFeature>> featureIndex;
	
	private boolean allFeaturesComputed = false;
	
	protected RawResolvedFeatures(JvmDeclaredType type, CommonTypeComputationServices services) {
		this(createTypeReference(type, services), new OverrideTester());
	}
	
	protected RawResolvedFeatures(LightweightTypeReference type, OverrideTester overrideTester) {
		super(type, overrideTester);
		this.featureIndex = Maps.newHashMapWithExpectedSize(4);
	}
	
	@Override
	public IResolvedFeatures getParameterizedView(LightweightTypeReference concrete) {
		return new ParameterizedResolvedFeatures(concrete, this);
	}
	
	@Override
	public List<JvmFeature> getAllFeatures(String simpleName) {
		List<JvmFeature> result = featureIndex.get(simpleName);
		if (result == null) {
			featureIndex.put(simpleName, result = computeAllFeatures(simpleName));
		}
		return result;
	}
	
	@Override
	public List<JvmFeature> getAllFeatures() {
		if (!allFeaturesComputed) {
			ListMultimap<String, JvmFeature> featureIndex = computeAllFeatures();
			for(String simpleName: featureIndex.keySet()) {
				this.featureIndex.put(simpleName, Lists.newArrayList(featureIndex.get(simpleName)));
			}
			allFeaturesComputed = true;
		}
		List<JvmFeature> result = Lists.newArrayList();
		for(List<JvmFeature> list: featureIndex.values()) {
			result.addAll(list);
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
	
	protected ListMultimap<String, JvmFeature> computeAllFeatures() {
		JvmType rawType = getRawType();
		if (!(rawType instanceof JvmDeclaredType)) {
			return ArrayListMultimap.create();
		}
		ListMultimap<String, JvmFeature> result = ArrayListMultimap.create();
		Multimap<String, AbstractResolvedOperation> processed = HashMultimap.create();
		Set<String> processedFields = Sets.newHashSetWithExpectedSize(5);
		computeAllFeatures((JvmDeclaredType)rawType, processed, processedFields, result, featureIndex.keySet());
		return Multimaps.unmodifiableListMultimap(result);
	}
	
	protected void computeAllFeatures(
			JvmDeclaredType type,
			Multimap<String, AbstractResolvedOperation> processedOperations,
			Set<String> processedFields,
			ListMultimap<String, JvmFeature> result,
			Set<String> seenNames) {
		Iterable<JvmFeature> features = type.getAllFeatures();
		for(JvmFeature feature: features) {
			if (!seenNames.contains(feature.getSimpleName())) {
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
					result.put(simpleName, operation);	
				} else if (feature instanceof JvmField && processedFields.add(feature.getSimpleName())) {
					result.put(feature.getSimpleName(), feature);
				}
			}
		}
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

	@Override
	public void notifyChanged(/* @Nullable */ Notification notification) {
	}

	/* @Nullable */
	@Override
	public Notifier getTarget() {
		return null;
	}

	@Override
	public void setTarget(/* @Nullable */ Notifier newTarget) {
	}

	@Override
	public boolean isAdapterForType(/* @Nullable */ Object type) {
		return RawResolvedFeatures.class.equals(type);
	}

	private void clear() {
		featureIndex.clear();
		allFeaturesComputed = false;
	}

}
