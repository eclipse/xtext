/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmSpecializedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.ITypeArgumentContext;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.typing.SynonymTypesProvider;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * Provides a feature scope for a type, based on the type hierarchy.
 * It also allows to add additional secondary elements, it sorts 
 * invalid elements out and adds it to the end of the scope hierarchy,
 * and it allows to apply lower prioritized, sugared versions of the
 * {@link JvmFeatureDescription}s contained in the provided Scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Deprecated
public class JvmFeatureScopeProvider implements IJvmFeatureScopeProvider {

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private IFeaturesForTypeProvider featuresProvider;
	
	@Inject
	private SynonymTypesProvider synonymTypeProvider;

	public void setTypeArgumentContextProvider(TypeArgumentContextProvider typeArgumentContextProvider) {
		this.typeArgumentContextProvider = typeArgumentContextProvider;
	}

	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
	}
	
	public JvmFeatureScope createFeatureScope(IScope parent, List<FeatureScopeDescription> featureScopeDescriptions) {
		IScope result = parent;
		List<LazyJvmFeatureScope> lazyScopes = Lists.newArrayListWithCapacity(featureScopeDescriptions.size());
		for(IJvmFeatureScopeProvider.FeatureScopeDescription description: featureScopeDescriptions) {
			LazyJvmFeatureScope lazyScope = createFeatureScopeForTypeRef(description);
			lazyScopes.add(lazyScope);
			result = new FilteredDelegatingScope(result, lazyScope, false);
		}
		for(LazyJvmFeatureScope lazyScope: lazyScopes) {
			result = new FilteredDelegatingScope(result, lazyScope, true);
		}
		if (!(result instanceof JvmFeatureScope)) {
			return new JvmFeatureScope(parent, "Empty feature scope", Collections.<IValidatedEObjectDescription>emptyList());
		}
		return (JvmFeatureScope) result;
	}
	
	/*
	 * TODO update Javadoc if necessary 
	 */
	/**
	 * <p>
	 * Provides the feature scope for a given {@link JvmTypeReference}, using the given {@link IJvmFeatureDescriptionProvider}.
	 * </p><p>
	 * The default implementation traverses the type hierarchy of the given {@link JvmTypeReference} and asks the
	 * {@link IJvmFeatureDescriptionProvider} to create any number of {@link JvmFeatureDescription} for each {@link org.eclipse.xtext.common.types.JvmFeature}.
	 * </p><p>
	 * In a second traversal the {@link XFeatureCallSugarDescriptionProvider} is asked to add additional sugar for each {@link JvmFeatureDescription} which gets less
	 * priority than all the descriptions from the first traversal (i.e. sugar is contained in parent scopes).
	 * </p><p>
	 * {@link JvmFeatureDescription}s marked as invalid {@link JvmFeatureDescription#isValid()}, will be sorted last (even after sugar). This ensures that
	 * it is shadowed by valid elements and can be filtered out if not needed.
	 * </p>
	 */
	protected LazyJvmFeatureScope createFeatureScopeForTypeRef(FeatureScopeDescription featureScopeDescription) {
		JvmTypeReference receiverType = featureScopeDescription.getReceiverType();
		ITypeArgumentContext context = typeArgumentContextProvider.getTypeArgumentContext(
				new TypeArgumentContextProvider.ReceiverRequest(receiverType));
		IJvmFeatureDescriptionProvider featureDescriptionProvider = featureScopeDescription.getDescriptionProvider();
		
		Iterable<JvmTypeReference> hierarchy = linearizeTypeHierarchy(receiverType);
		IFeaturesForTypeProvider featureProvider = featuresProvider;
		if (featureDescriptionProvider instanceof IFeaturesForTypeProvider)
			featureProvider = (IFeaturesForTypeProvider) featureDescriptionProvider;
		LazyJvmFeatureScopeStrategy strategy = new LazyJvmFeatureScopeStrategy(
				featureDescriptionProvider, featureProvider, receiverType, 
				featureScopeDescription.getContextFactory(), context, hierarchy);
		LazyJvmFeatureScope result = new LazyJvmFeatureScope(featureDescriptionProvider.toString(), strategy);
		return result;
	}
	
	protected boolean isValidFeature(JvmFeature input) {
		return input!=null && input.getSimpleName()!=null && input.getDeclaringType()!=null && !(input instanceof JvmConstructor);
	}

	/**
	 * @return an iterable containing the given type and all its super types in a deterministic order. The order is more
	 *         specific types come first. This method also adds any convertable types e.g. wrapper types for primitives
	 */
	public Iterable<JvmTypeReference> linearizeTypeHierarchy(JvmTypeReference typeRef) {
		if (typeRef == null)
			return Collections.emptyList();
		final Map<JvmTypeReference, Integer> result = Maps.newLinkedHashMap();
		final Wrapper<Integer> addOn = Wrapper.wrap(Integer.valueOf(0));
		final Map<JvmType, JvmTypeReference> visited = Maps.newHashMap();
		if (!(typeRef instanceof JvmSpecializedTypeReference) && !(typeRef.getType() instanceof JvmTypeParameter)) {
			result.put(typeRef, -1);
			visited.put(typeRef.getType(), typeRef);
		}
		SuperTypeCollector.SuperTypeAcceptor acceptor = new SuperTypeCollector.SuperTypeAcceptor() {
			
			public boolean accept(JvmTypeReference superType, int distance) {
				JvmTypeReference existing = visited.get(superType.getType());
				if (existing == null) {
					visited.put(superType.getType(), superType);
					result.put(superType, distance + addOn.get().intValue());
					return true;
				} else {
					Integer previousDistance = result.get(existing);
					if (previousDistance > addOn.get().intValue() && distance > previousDistance) {
						visited.put(superType.getType(), superType);
						result.remove(existing);
						result.put(superType, distance + addOn.get().intValue());
						return true;
					}
				}
				return false;
			}
			
		};
		superTypeCollector.collectSuperTypes(typeRef, acceptor);
		for(JvmTypeReference synonym: synonymTypeProvider.getSynonymTypes(typeRef, false)) {
			if (!visited.containsKey(synonym.getType())) {
				result.put(synonym, result.size());
				visited.put(synonym.getType(), synonym);
				addOn.set(result.size());
				superTypeCollector.collectSuperTypes(synonym, acceptor);
			}
		}
		List<Entry<JvmTypeReference,Integer>> sortable = Lists.newArrayList(Iterables.filter(result.entrySet(), new Predicate<Entry<JvmTypeReference,Integer>>(){
			public boolean apply(Entry<JvmTypeReference, Integer> entry) {
				JvmType type = entry.getKey().getType();
				return  type != null && !type.eIsProxy();
			}
		}));
		Collections.sort(sortable, new Comparator<Entry<JvmTypeReference,Integer>>() {

			public int compare(Entry<JvmTypeReference, Integer> o1, Entry<JvmTypeReference, Integer> o2) {
				if (o1.getValue().equals(o2.getValue())) {
					JvmTypeReference ref1 = o1.getKey();
					JvmTypeReference ref2 = o2.getKey();
					if (ref1.getType() instanceof JvmGenericType && ref2.getType() instanceof JvmGenericType) {
						if (((JvmGenericType) ref1.getType()).isInterface()) {
							if (!((JvmGenericType) ref2.getType()).isInterface()) {
								return 1;
							}
						} else if (((JvmGenericType) ref2.getType()).isInterface()) {
							return -1;
						}
					}
					return o1.getKey().getQualifiedName().compareTo(o2.getKey().getQualifiedName());
				}
				return o1.getValue().compareTo(o2.getValue());
			}
			
		});
		
		return Lists.newArrayList(Lists.transform(sortable, new Function<Entry<JvmTypeReference,Integer>, JvmTypeReference>() {
			public JvmTypeReference apply(Entry<JvmTypeReference, Integer> from) {
				return from.getKey();
			}
		}));
	}
}
