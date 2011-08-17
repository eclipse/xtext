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
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.typing.SynonymTypesProvider;

import com.google.common.base.Function;
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
	public JvmFeatureScope createFeatureScopeForTypeRef(
			IScope parent, 
			JvmTypeReference typeReference, 
			List<IJvmFeatureDescriptionProvider> jvmFeatureDescriptionProviders) {
		TypeArgumentContext context = typeArgumentContextProvider.getReceiverContext(typeReference);
		Iterable<JvmTypeReference> hierarchy = linearizeTypeHierarchy(typeReference);
		IScope result = parent;
		for(int i = jvmFeatureDescriptionProviders.size() - 1; i >= 0; i--) {
			IJvmFeatureDescriptionProvider descriptionProvider = jvmFeatureDescriptionProviders.get(i);
			IFeaturesForTypeProvider featureProvider = featuresProvider;
			if (descriptionProvider instanceof IFeaturesForTypeProvider)
				featureProvider = (IFeaturesForTypeProvider) descriptionProvider;
			LazyJvmFeatureScopeStrategy configuration = new LazyJvmFeatureScopeStrategy(descriptionProvider, featureProvider, typeReference, context, hierarchy);
			result = new LazyJvmFeatureScope(result, descriptionProvider.getText(), configuration, false);
		}

		for(int i = jvmFeatureDescriptionProviders.size() - 1; i >= 0; i--) {
			IJvmFeatureDescriptionProvider descriptionProvider = jvmFeatureDescriptionProviders.get(i);
			IFeaturesForTypeProvider featureProvider = featuresProvider;
			if (descriptionProvider instanceof IFeaturesForTypeProvider)
				featureProvider = (IFeaturesForTypeProvider) descriptionProvider;
			LazyJvmFeatureScopeStrategy configuration = new LazyJvmFeatureScopeStrategy(descriptionProvider, featureProvider, typeReference, context, hierarchy);
			result = new LazyJvmFeatureScope(result, descriptionProvider.getText(), configuration, true);
		}
		if (result == null || parent == result)
			return new JvmFeatureScope(parent, "No features for type "+typeReference, Collections.<IValidatedEObjectDescription>emptyList());
		return (JvmFeatureScope) result;
		
//		// standard features
//		final List<JvmFeatureDescriptionList> descriptions = newArrayList();
//		for (IJvmFeatureDescriptionProvider provider : jvmFeatureDescriptionProviders) {
//			final List<JvmFeatureDescriptionList> descriptionList = createFeatureScopes(hierarchy, context, provider);
//			descriptions.addAll(descriptionList);
//		}
//
//		// create a view for the visible elements
//		Iterable<JvmFeatureDescriptionList> visibleElements = transform(descriptions,
//				new Function<JvmFeatureDescriptionList, JvmFeatureDescriptionList>() {
//					public JvmFeatureDescriptionList apply(JvmFeatureDescriptionList from) {
//						return new JvmFeatureDescriptionList(from.getText(), filter(from.getDescriptions(),new Predicate<JvmFeatureDescription>() {
//							public boolean apply(JvmFeatureDescription input) {
//								return input.isValid();
//							}
//						}));
//					}
//				});
//		// create a view for the invisible elements
//		Iterable<JvmFeatureDescriptionList> invisibleElements = transform(descriptions,
//				new Function<JvmFeatureDescriptionList, JvmFeatureDescriptionList>() {
//					public JvmFeatureDescriptionList apply(JvmFeatureDescriptionList from) {
//						return new JvmFeatureDescriptionList("[invalid] "+from.getText(), filter(from.getDescriptions(),new Predicate<JvmFeatureDescription>() {
//							public boolean apply(JvmFeatureDescription input) {
//								return !input.isValid();
//							}
//						}));
//					}
//				});
//
//		// concat valid and invalid scopes
//		final ArrayList<JvmFeatureDescriptionList> newArrayList = newArrayList(concat(visibleElements, invisibleElements));
//
//		// transform iterables to scope hierarchy in reverse order
//		IScope current = parent;
//		for (JvmFeatureDescriptionList featureDescs : reverse(newArrayList)) {
//			if (featureDescs != null && !isEmpty(featureDescs.getDescriptions())) {
//				if (current == null) 
//					current = IScope.NULLSCOPE;
//				current = createJvmFeatureScope(current, featureDescs);
//			}
//		}
//		if (current == null || parent == current)
//			return new JvmFeatureScope(parent, "No features for type "+typeReference, Collections.<IValidatedEObjectDescription>emptyList());
//		return (JvmFeatureScope) current;
	}

//	protected JvmFeatureScope createJvmFeatureScope(IScope current, JvmFeatureDescriptionList featureDescs) {
//		return new JvmFeatureScope(current, featureDescs.getText(), featureDescs.getDescriptions());
//	}

//	protected List<JvmFeatureDescriptionList> createFeatureScopes(Iterable<JvmTypeReference> hierarchy, TypeArgumentContext context, IJvmFeatureDescriptionProvider jvmFeatureDescriptionProvider) {
//		List<JvmFeatureDescriptionList> result = newArrayList();
//		boolean wasEmpty = true;
//		for (JvmTypeReference type : hierarchy) {
//			wasEmpty = false;
//			final JvmFeatureDescriptionList featureDescriptions = createFeatureScope(type, context, jvmFeatureDescriptionProvider);
//			if (featureDescriptions!=null)
//				result.add(featureDescriptions);
//		}
//		// try again without a typeReference <- TODO why is that?
//		if (wasEmpty) {
//			final JvmFeatureDescriptionList featureDescriptions = createFeatureScope(null, context, jvmFeatureDescriptionProvider);
//			if (featureDescriptions!=null)
//				result.add(featureDescriptions);
//		}
//		return result;
//	}

//	protected JvmFeatureDescriptionList createFeatureScope(
//			final JvmTypeReference type, 
//			final TypeArgumentContext context, 
//			final IJvmFeatureDescriptionProvider jvmFeatureDescriptionProvider) {
//		
//		Iterable<? extends JvmFeature> features = getFeaturesForType(type, jvmFeatureDescriptionProvider);
//		if (!features.iterator().hasNext())
//			return null;
//		final List<JvmFeatureDescription> descriptions = Lists.newArrayList();
//		IAcceptor<JvmFeatureDescription> acceptor = new IAcceptor<JvmFeatureDescription>() {
//			public void accept(JvmFeatureDescription t) {
//				descriptions.add(t);
//			}
//		};
//		for (JvmFeature jvmFeature : features) {
//			jvmFeatureDescriptionProvider.addFeatureDescriptions(jvmFeature, context, acceptor);
//		}
//		String identifier = type != null ? type.getIdentifier() : "[static features]";
//		return new JvmFeatureDescriptionList(jvmFeatureDescriptionProvider.getText()+" " + identifier, descriptions);
//	}

//	protected Iterable<? extends JvmFeature> getFeaturesForType(JvmTypeReference type, IJvmFeatureDescriptionProvider descriptionProvider) {
//		final Predicate<JvmFeature> predicate = new Predicate<JvmFeature>() {
//			public boolean apply(JvmFeature input) {
//				return isValidFeature(input);
//			}
//		};
//		if (descriptionProvider instanceof IFeaturesForTypeProvider) {
//			return filter(((IFeaturesForTypeProvider)descriptionProvider).getFeaturesForType(type), predicate);
//		}
//		return featuresProvider.getFeaturesForType(type);
//	}
	
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
		result.put(typeRef, -1);
		final Wrapper<Integer> addOn = Wrapper.wrap(Integer.valueOf(0));
		final Map<JvmType, JvmTypeReference> visited = Maps.newHashMap();
		visited.put(typeRef.getType(), typeRef);
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
		for(JvmTypeReference synonym: synonymTypeProvider.getSynonymTypes(typeRef)) {
			if (!visited.containsKey(synonym.getType())) {
				result.put(synonym, result.size());
				visited.put(synonym.getType(), synonym);
				addOn.set(result.size());
				superTypeCollector.collectSuperTypes(synonym, acceptor);
			}
		}
		List<Entry<JvmTypeReference,Integer>> sortable = Lists.newArrayList(result.entrySet());
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
	
//	protected static class JvmFeatureDescriptionList {
//		private String text;
//		private Iterable<JvmFeatureDescription> descriptions;
//
//		public JvmFeatureDescriptionList(String text, Iterable<JvmFeatureDescription> descriptions) {
//			super();
//			this.text = text;
//			this.descriptions = descriptions;
//		}
//
//		public Iterable<JvmFeatureDescription> getDescriptions() {
//			return descriptions;
//		}
//
//		public String getText() {
//			return text;
//		}
//		
//		@Override
//		public String toString() {
//			return getText()+(isEmpty(getDescriptions())?"[EMPTY]":"");
//		}
//	}

}
