/**
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.resource.XbaseResourceDescriptionStrategy;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

public class XbaseResourceDescriptionStrategyTest extends AbstractXbaseImportedNamesTest {
	@Inject
	private XbaseResourceDescriptionStrategy descriptionStrategy;

	@Inject
	private IResourceDescription.Manager resourceDescriptionManager;

	@Test
	public void testInterfaceDescription_01() {
		JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		interfaceType.setInterface(true);
		interfaceType.setPackageName("foo");
		interfaceType.setSimpleName("MyType");
		List<IEObjectDescription> list = new ArrayList<>();
		descriptionStrategy.createEObjectDescriptions(interfaceType, it -> list.add(it));
		Assert.assertTrue(
				list.stream().anyMatch(it -> "true".equals(it.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE))));
	}

	@Test
	public void testInterfaceDescription_02() {
		JvmGenericType interfaceType = TypesFactory.eINSTANCE.createJvmGenericType();
		interfaceType.setInterface(false);
		interfaceType.setPackageName("foo");
		interfaceType.setSimpleName("MyType");
		List<IEObjectDescription> list = new ArrayList<>();
		descriptionStrategy.createEObjectDescriptions(interfaceType, it -> list.add(it));
		Assert.assertFalse(list.stream().anyMatch(
				it -> "true".equals(it.getUserData(JvmTypesResourceDescriptionStrategy.IS_INTERFACE))));
	}

	@Test
	public void testNoReferenceDescriptionsForPackageFragments() throws Exception {
		XExpression expression = expression("java::lang::String::valueOf(\"\")");
		Resource resource = expression.eResource();
		IResourceDescription description = resourceDescriptionManager.getResourceDescription(resource);
		Set<String> referenceDescriptions = IterableExtensions
				.toSet(IterableExtensions.map(description.getReferenceDescriptions(), it -> it.getTargetEObjectUri().toString()));
		Assert.assertEquals(2, referenceDescriptions.size());
		Set<String> expectation = Sets.newHashSet("java:/Objects/java.lang.String#java.lang.String",
				"java:/Objects/java.lang.String#java.lang.String.valueOf(java.lang.Object)");
		Assert.assertEquals(expectation, referenceDescriptions);
	}
}
