/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping.featurecalls;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;

import testdata.FieldAccess;
import testdata.FieldAccessSub;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class JvmFeatureScopeProviderTest extends AbstractJvmFeatureScopeProviderTest {

	public void testPublicFieldShadowed_01() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(IScope.NULLSCOPE, reference,
				Collections.<IJvmFeatureDescriptionProvider>singletonList(defaultFeatureProvider.get()));
		Iterable<IEObjectDescription> descriptions = scope.getElements(QualifiedName.create("stringField"));
		Set<String> expected = Sets.newHashSet("stringField", "stringField()");
		for(IEObjectDescription description: descriptions) {
			JvmFeature feature = (JvmFeature) description.getEObjectOrProxy();
			// inherited public field 'stringField' is shadowed
			assertEquals(FieldAccessSub.class.getName(), feature.getDeclaringType().getIdentifier());
			JvmFeatureDescription castedDescription = (JvmFeatureDescription) description;
			assertTrue(castedDescription.getKey(), expected.remove(castedDescription.getKey()));
			assertTrue(castedDescription.getKey(), castedDescription.isValid());
		}
		assertTrue(expected.toString(), expected.isEmpty());
	}
	
	public void testPublicFieldShadowed_02() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(IScope.NULLSCOPE, reference,
				Collections.<IJvmFeatureDescriptionProvider>singletonList(defaultFeatureProvider.get()));
		Iterable<IEObjectDescription> descriptions = scope.getElements(QualifiedName.create("shadowedByPrivateField"));
		Set<String> expected = Sets.newHashSet("shadowedByPrivateField");
		for(IEObjectDescription description: descriptions) {
			JvmFeature feature = (JvmFeature) description.getEObjectOrProxy();
			// inherited public field 'shadowedByPrivateField' is shadowed
			assertEquals(FieldAccessSub.class.getName(), feature.getDeclaringType().getIdentifier());
			JvmFeatureDescription castedDescription = (JvmFeatureDescription) description;
			assertTrue(castedDescription.getKey(), expected.remove(castedDescription.getKey()));
			assertFalse(castedDescription.getKey(), castedDescription.isValid());
		}
		assertTrue(expected.toString(), expected.isEmpty());
	}

	public void testPrivateMemberDescriptions() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(IScope.NULLSCOPE, reference,
				Collections.<IJvmFeatureDescriptionProvider>singletonList(defaultFeatureProvider.get()));
		Iterable<IEObjectDescription> descriptions = scope.getElements(QualifiedName.create("privateField"));
		Set<String> expected = Sets.newHashSet("privateField()", "privateField");
		for(IEObjectDescription description: descriptions) {
			JvmFeature feature = (JvmFeature) description.getEObjectOrProxy();
			assertEquals(FieldAccessSub.class.getName(), feature.getDeclaringType().getIdentifier());
			JvmFeatureDescription castedDescription = (JvmFeatureDescription) description;
			assertTrue(castedDescription.getKey(), expected.remove(castedDescription.getKey()));
			assertTrue(castedDescription.getKey(), castedDescription.isValid() == castedDescription.getEObjectOrProxy() instanceof JvmOperation);
		}
		assertTrue(expected.toString(), expected.isEmpty());
	}
	
	public void testInheritedDescriptions() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(IScope.NULLSCOPE, reference,
				Collections.<IJvmFeatureDescriptionProvider>singletonList(defaultFeatureProvider.get()));
		Iterable<IEObjectDescription> descriptions = scope.getAllElements();
		Set<String> expected = Sets.newHashSet("finalField", "staticField");
		for(IEObjectDescription description: descriptions) {
			JvmFeature feature = (JvmFeature) description.getEObjectOrProxy();
			if (FieldAccess.class.getName().equals(feature.getDeclaringType().getIdentifier())) {
				JvmFeatureDescription castedDescription = (JvmFeatureDescription) description;
				assertTrue(castedDescription.getKey(), expected.remove(castedDescription.getKey()));
				assertTrue(castedDescription.getKey(), castedDescription.isValid());
			}
		}
		assertTrue(expected.toString(), expected.isEmpty());
	}

	public void testTypeHierarchyLinearization() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		Iterator<JvmTypeReference> hierarchy = getFeatureProvider().linearizeTypeHierarchy(reference).iterator();
		assertEquals(FieldAccessSub.class.getCanonicalName(), hierarchy.next().getType().getIdentifier());
		assertEquals(FieldAccess.class.getCanonicalName(), hierarchy.next().getType().getIdentifier());
		assertEquals(Object.class.getCanonicalName(), hierarchy.next().getType().getIdentifier());
		assertFalse(hierarchy.hasNext());
	}
	
}
