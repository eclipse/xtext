/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.featurecalls;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.Primitives;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContextProvider;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IAcceptor;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Provides a feature scope for a type, based on the type hierarchy.
 * It also allows to add additional secondary elements, it sorts 
 * invalid elements out and adds it to the end of the scope hierarchy,
 * and it allows to apply lower prioritized, sugared versions of the
 * {@link JvmFeatureDescription}s contained in the provided Scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureScopeProvider implements IJvmFeatureScopeProvider {

	@Inject
	private TypeArgumentContextProvider typeArgumentContextProvider;

	@Inject
	private SuperTypeCollector superTypeCollector;
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private TypesFactory typesFactory = TypesFactory.eINSTANCE;
	
	@Inject
	private TypeReferences typeRefs;
	
	@Inject
	private IFeaturesForTypeProvider featuresProvider;

	public void setTypeArgumentContextProvider(TypeArgumentContextProvider typeArgumentContextProvider) {
		this.typeArgumentContextProvider = typeArgumentContextProvider;
	}

	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
	}
	
	public void setPrimitives(Primitives primitives) {
		this.primitives = primitives;
	}
	

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
	public JvmFeatureScope createFeatureScopeForTypeRef(JvmTypeReference jvmTypeRef, List<? extends IJvmFeatureDescriptionProvider> jvmFeatureDescriptionProviders) {
		TypeArgumentContext context = typeArgumentContextProvider.getReceiverContext(jvmTypeRef);
		Iterable<JvmTypeReference> hierarchy = linearizeTypeHierarchy(jvmTypeRef);

		// standard features
		final List<JvmFeatureDescriptions> descriptions = newArrayList();
		for (IJvmFeatureDescriptionProvider provider : jvmFeatureDescriptionProviders) {
			final List<JvmFeatureDescriptions> descriptionss = createFeatureScopes(hierarchy,context,provider);
			descriptions.addAll(descriptionss);
		}

		// create a view for the visible elements
		Iterable<JvmFeatureDescriptions> visibleElements = transform(descriptions,
				new Function<JvmFeatureDescriptions, JvmFeatureDescriptions>() {
					public JvmFeatureDescriptions apply(JvmFeatureDescriptions from) {
						return new JvmFeatureDescriptions(from.getText(), filter(from.getDescriptions(),new Predicate<JvmFeatureDescription>() {
							public boolean apply(JvmFeatureDescription input) {
								return input.isValid();
							}
						}));
					}
				});
		// create a view for the invisible elements
		Iterable<JvmFeatureDescriptions> invisibleElements = transform(descriptions,
				new Function<JvmFeatureDescriptions, JvmFeatureDescriptions>() {
					public JvmFeatureDescriptions apply(JvmFeatureDescriptions from) {
						return new JvmFeatureDescriptions("[invalid] "+from.getText(), filter(from.getDescriptions(),new Predicate<JvmFeatureDescription>() {
							public boolean apply(JvmFeatureDescription input) {
								return !input.isValid();
							}
						}));
					}
				});

		// concat valid and invalid scopes
		final ArrayList<JvmFeatureDescriptions> newArrayList = newArrayList(concat(visibleElements, invisibleElements));

		// transform iterables to scope hierarchy in reverse order
		IScope current = null;
		for (JvmFeatureDescriptions featureDescs : reverse(newArrayList)) {
			if (featureDescs != null && !isEmpty(featureDescs.getDescriptions())) {
				if (current == null) 
					current = IScope.NULLSCOPE;
				current = createJvmFeatureScope(current, featureDescs);
			}
		}
		if (current == null)
			return new JvmFeatureScope(IScope.NULLSCOPE, "No features for type "+jvmTypeRef, Collections.<JvmFeatureDescription>emptyList());
		return (JvmFeatureScope) current;
	}

	protected JvmFeatureScope createJvmFeatureScope(IScope current, JvmFeatureDescriptions featureDescs) {
		return new JvmFeatureScope(current, featureDescs.getText(), featureDescs.getDescriptions());
	}

	protected List<JvmFeatureDescriptions> createFeatureScopes(Iterable<JvmTypeReference> hierarchy,TypeArgumentContext context,  IJvmFeatureDescriptionProvider jvmFeatureDescriptionProvider) {
		List<JvmFeatureDescriptions> scopes = newArrayList();
		for (JvmTypeReference type : hierarchy) {
			final JvmFeatureDescriptions createStandardFeatureScope = createFeatureScope(type, context, jvmFeatureDescriptionProvider);
			if (createStandardFeatureScope!=null)
				scopes.add(createStandardFeatureScope);
		}
		return scopes;
	}

	protected JvmFeatureDescriptions createFeatureScope(final JvmTypeReference type,final TypeArgumentContext context, final IJvmFeatureDescriptionProvider jvmFeatureDescriptionProvider) {
		if (!(type.getType() instanceof JvmDeclaredType))
			return null;
		Iterable<? extends JvmFeature> features = getFeaturesForType(type,jvmFeatureDescriptionProvider);
		if (!features.iterator().hasNext())
			return null;
		final List<JvmFeatureDescription> descriptions = Lists.newArrayList();
		IAcceptor<JvmFeatureDescription> acceptor = new IAcceptor<JvmFeatureDescription>() {
			public void accept(JvmFeatureDescription t) {
				descriptions.add(t);
			}
		};
		for (JvmFeature jvmFeature : features) {
			jvmFeatureDescriptionProvider.addFeatureDescriptions(jvmFeature, context, acceptor);
		}
		return new JvmFeatureDescriptions(jvmFeatureDescriptionProvider.getText()+" " + type.getIdentifier(), descriptions);
	}

	protected Iterable<? extends JvmFeature> getFeaturesForType(JvmTypeReference type, IJvmFeatureDescriptionProvider descriptionProvider) {
		final Predicate<JvmFeature> predicate = new Predicate<JvmFeature>() {
			public boolean apply(JvmFeature input) {
				return isValidFeature(input);
			}
		};
		if (descriptionProvider instanceof IFeaturesForTypeProvider) {
			return filter(((IFeaturesForTypeProvider)descriptionProvider).getFeaturesForType(type),predicate);
		}
		return featuresProvider.getFeaturesForType(type);
	}
	
	protected boolean isValidFeature(JvmFeature input) {
		return input!=null && input.getSimpleName()!=null && input.getDeclaringType()!=null && !(input instanceof JvmConstructor);
	}

	/**
	 * @return an iterable containing the given type and all its super types in a deterministic order. The order is more
	 *         specific types come first. This method also adds any convertable types e.g. wrapper types for primitives
	 */
	public Iterable<JvmTypeReference> linearizeTypeHierarchy(JvmTypeReference typeRef) {
		final Iterable<JvmTypeReference> result = concat(singleton(typeRef), superTypeCollector.collectSuperTypes(typeRef));
		if (typeRef.getType() instanceof JvmPrimitiveType) {
			JvmType jvmType = primitives.getWrapperType((JvmPrimitiveType) typeRef.getType());
			JvmParameterizedTypeReference wrapperReference = typesFactory.createJvmParameterizedTypeReference();
			wrapperReference.setType(jvmType);
			return concat(result,concat(singleton(wrapperReference), superTypeCollector.collectSuperTypes(wrapperReference)));
		}
		if (typeRef.getType() instanceof JvmArrayType) {
			JvmArrayType arrayType = (JvmArrayType) typeRef.getType();
			JvmTypeReference componentType = arrayType.getComponentType();
			if (primitives.isPrimitive(componentType)) {
				JvmType wrapperType = primitives.getWrapperType((JvmPrimitiveType) componentType.getType());
				componentType = typeRefs.createTypeRef(wrapperType);
			}
			JvmTypeReference iterable = typeRefs.getTypeForName(Iterable.class, getRealComponentType(arrayType), componentType);
			return concat(result,linearizeTypeHierarchy(iterable));
		}
		return result;
	}

	protected JvmType getRealComponentType(JvmArrayType arrayType) {
		final JvmType type = arrayType.getComponentType().getType();
		if (type instanceof JvmArrayType) {
			return getRealComponentType((JvmArrayType) type);
		}
		return type;
	}


	protected static class JvmFeatureDescriptions {
		private String text;
		private Iterable<JvmFeatureDescription> descriptions;

		public JvmFeatureDescriptions(String text, Iterable<JvmFeatureDescription> descriptions) {
			super();
			this.text = text;
			this.descriptions = descriptions;
		}

		public Iterable<JvmFeatureDescription> getDescriptions() {
			return descriptions;
		}

		public String getText() {
			return text;
		}
		
		@Override
		public String toString() {
			return getText()+(isEmpty(getDescriptions())?"[EMPTY]":"");
		}
	}

}
