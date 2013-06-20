/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping.featurecalls;

import static com.google.common.collect.Sets.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public abstract class AbstractJvmFeatureScopeProviderTest extends AbstractXbaseTestCase {

	@Inject
	protected IJvmTypeProvider.Factory typeProviderFactory;
	
	@Inject
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE;

	@Inject
	protected OperatorMapping opMapping = new OperatorMapping();
	
	@Inject
	protected JvmFeatureScopeProvider featureScopeProvider; 
	
	@Inject
	protected ResourceSet resourceSet;

	protected JvmFeatureScopeProvider getFeatureProvider() {
		return featureScopeProvider;
	}
	
	protected Set<String> getSignatures(JvmFeatureScope scope) {
		final Function<IValidatedEObjectDescription, String> function = new Function<IValidatedEObjectDescription, String>() {
			public String apply(IValidatedEObjectDescription from) {
				return from.getKey();
			}
		};
		final Iterable<String> transformed = Iterables.transform(scope.getJvmFeatureDescriptions(), function);
		return newHashSet(transformed);
	}
	
	protected List<IJvmFeatureScopeProvider.FeatureScopeDescription> createScopeDescriptions(
			JvmTypeReference reference,
			List<? extends IJvmFeatureDescriptionProvider> providers) {
		List<IJvmFeatureScopeProvider.FeatureScopeDescription> result = Lists.newArrayList();
		for(int i = providers.size() - 1; i >= 0; i--) {
			result.add(new IJvmFeatureScopeProvider.FeatureScopeDescription(
					reference, 
					Functions.<TypeArgumentContext>constant(null), 
					providers.get(i)));
		}
		return result;
	}

	protected int numberOfScopes(JvmFeatureScope scope) {
		int i = 1;
		while (scope.getParent() != IScope.NULLSCOPE) {
			i++;
			scope = (JvmFeatureScope) scope.getParent();
		}
		return i;
	}
	
	protected JvmTypeReference getTypeRef(String name) {
		IJvmTypeProvider typeProvider = typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		JvmType type = typeProvider.findTypeByName(name);
		JvmParameterizedTypeReference reference = typesFactory.createJvmParameterizedTypeReference();
		reference.setType(type);
		return reference;
	}

	protected void assertSetsEqual(Set<String> expected, Set<String> actual) {
		for (String string : expected) {
			assertTrue("Expected '" + string + "' not contained in " + actual, actual.contains(string));
		}
		if (expected.size() < actual.size()) {
			for (String string : actual) {
				assertTrue("Unexpected '" + string + "' found.", expected.contains(string));
			}
		}
	}
	
	@Inject Provider<XFeatureCallSugarDescriptionProvider> featureSugarProvider;
	@Inject Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureProvider;

	protected XFeatureCallSugarDescriptionProvider createXFeatureCallSugaringJvmFeatureDescriptionProvider() {
		return featureSugarProvider.get();
	}

	protected DefaultJvmFeatureDescriptionProvider createDefaultJvmFeatureDescriptionProvider() {
		return defaultFeatureProvider.get();
	}
}
