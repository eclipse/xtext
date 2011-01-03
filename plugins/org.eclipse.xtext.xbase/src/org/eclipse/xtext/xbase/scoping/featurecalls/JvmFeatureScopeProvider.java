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
import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
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
	private TypeArgumentContext.Provider typeArgumentContextProvider;

	@Inject
	private SuperTypeCollector superTypeCollector;

	public void setTypeArgumentContextProvider(TypeArgumentContext.Provider typeArgumentContextProvider) {
		this.typeArgumentContextProvider = typeArgumentContextProvider;
	}

	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
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
	public JvmFeatureScope createFeatureScopeForTypeRef(JvmTypeReference jvmTypeRef, IJvmFeatureDescriptionProvider... jvmFeatureDescriptionProviders) {
		TypeArgumentContext context = typeArgumentContextProvider.get(jvmTypeRef);
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
		JvmDeclaredType declType = (JvmDeclaredType) type.getType();
		Iterable<JvmFeature> features = filter(filter(declType.getMembers(), JvmFeature.class),
				new Predicate<JvmFeature>() {

					public boolean apply(JvmFeature input) {
						return !(input instanceof JvmConstructor);
					}
				});
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
		return new JvmFeatureDescriptions(jvmFeatureDescriptionProvider.getText()+" " + type.getCanonicalName(), descriptions);
	}

	/**
	 * @return an iterable containing the given type and all its super types in a deterministic order. The order is more
	 *         specific types come first.
	 */
	public Iterable<JvmTypeReference> linearizeTypeHierarchy(JvmTypeReference typeRef) {
		return concat(singleton(typeRef), superTypeCollector.collectSuperTypes(typeRef));
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
