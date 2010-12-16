/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping.featurecalls;

import static com.google.common.collect.Sets.*;

import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.util.JvmVisibilityService;
import org.eclipse.xtext.common.types.util.SuperTypeCollector;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.common.types.util.TypeArgumentContext.Provider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScopeProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractJvmFeatureScopeProviderTest extends TestCase {

	protected ClasspathTypeProvider typesProvider = new ClasspathTypeProviderFactory(getClass().getClassLoader())
			.createTypeProvider();
	protected TypesFactory typesFactory = TypesFactory.eINSTANCE;

	protected OperatorMapping opMapping = new OperatorMapping();

	protected JvmFeatureScopeProvider getFeatureProvider() {
		Provider provider = new TypeArgumentContext.Provider();
		SuperTypeCollector collector = new SuperTypeCollector(typesFactory);
		JvmFeatureScopeProvider descriptionsProvider = new JvmFeatureScopeProvider();
		descriptionsProvider.setTypeArgumentContextProvider(provider);
		descriptionsProvider.setSuperTypeCollector(collector);
		return descriptionsProvider;
	}
	
	protected Set<String> getSignatures(JvmFeatureScope scope) {
		final Function<JvmFeatureDescription, String> function = new Function<JvmFeatureDescription, String>() {
			public String apply(JvmFeatureDescription from) {
				return from.getKey();
			}
		};
		final Iterable<String> transformed = Iterables.transform(scope.getJvmFeatureDescriptions(), function);
		return newHashSet(transformed);
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
		JvmType type = typesProvider.findTypeByName(name);
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

	protected XFeatureCallSugarDescriptionProvider createXFeatureCallSugaringJvmFeatureDescriptionProvider() {
		final XFeatureCallSugarDescriptionProvider result = new XFeatureCallSugarDescriptionProvider();
		JvmVisibilityService service = createVisibilityService();
		result.setVisibilityService(service);
		result.setOperatorMapping(new OperatorMapping());
		return result;
	}

	protected JvmVisibilityService createVisibilityService() {
		SuperTypeCollector collector = new SuperTypeCollector(TypesFactory.eINSTANCE);
		JvmVisibilityService service = new JvmVisibilityService();
		service.setSuperTypeCollector(collector);
		service.setTypesFactory(TypesFactory.eINSTANCE);
		return service;
	}
	
	protected DefaultJvmFeatureDescriptionProvider createDefaultJvmFeatureDescriptionProvider() {
		final DefaultJvmFeatureDescriptionProvider result = new DefaultJvmFeatureDescriptionProvider();
		JvmVisibilityService service = createVisibilityService();
		result.setVisibilityService(service);
		return result;
	}
}
