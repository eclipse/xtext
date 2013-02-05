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
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;
import org.junit.Ignore;
import org.junit.Test;

import testdata.FieldAccess;
import testdata.FieldAccessSub;
import testdata.SugarConflict;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
@Ignore("This class tests obsolete implementation details")
@SuppressWarnings("deprecation")
public class JvmFeatureScopeProviderTest extends AbstractJvmFeatureScopeProviderTest {

	@Inject 
	private XFeatureCallSugarDescriptionProvider sugarDescriptionProvider;
	
	@Test public void testPublicFieldShadowed_01() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(IScope.NULLSCOPE, 
				createScopeDescriptions(reference,
						Collections.singletonList(defaultFeatureProvider.get())));
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
	
	@Test public void testPublicFieldShadowed_02() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(IScope.NULLSCOPE, 
				createScopeDescriptions(reference,
						Collections.singletonList(defaultFeatureProvider.get())));
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

	@Test public void testPrivateMemberDescriptions() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(IScope.NULLSCOPE, 
				createScopeDescriptions(reference,
						Collections.singletonList(defaultFeatureProvider.get())));
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
	
	@Test public void testInheritedDescriptions() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(IScope.NULLSCOPE, 
				createScopeDescriptions(reference,
						Collections.singletonList(defaultFeatureProvider.get())));
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

	@Test public void testTypeHierarchyLinearization() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		Iterator<JvmTypeReference> hierarchy = getFeatureProvider().linearizeTypeHierarchy(reference).iterator();
		assertEquals(FieldAccessSub.class.getCanonicalName(), hierarchy.next().getType().getIdentifier());
		assertEquals(FieldAccess.class.getCanonicalName(), hierarchy.next().getType().getIdentifier());
		assertEquals(Object.class.getCanonicalName(), hierarchy.next().getType().getIdentifier());
		assertFalse(hierarchy.hasNext());
	}
	
	@Test public void testSugarConflict_01() throws Exception {
		JvmTypeReference reference = getTypeRef(SugarConflict.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(IScope.NULLSCOPE, 
				createScopeDescriptions(reference,
						Collections.singletonList(sugarDescriptionProvider)));
		assertSimpleNameFeatureSelected(scope, "foo");
		assertSimpleNameFeatureSelected(scope, "bar");
	}
	
	@Test public void testSugarConflict_02() throws Exception {
		JvmTypeReference reference = getTypeRef(SugarConflict.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(IScope.NULLSCOPE, 
				createScopeDescriptions(reference,
						Collections.singletonList(sugarDescriptionProvider)));
		assertSelectedFeature(scope, "fooBar", "getFooBar");
		assertSelectedFeature(scope, "zonk", "getZonk");
	}
	
	@Test public void testSugarConflict_03() throws Exception {
		JvmTypeReference reference = getTypeRef(SugarConflict.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(IScope.NULLSCOPE, 
				createScopeDescriptions(reference,
						Collections.singletonList(sugarDescriptionProvider)));
		assertSelectedFeature(scope, "baz", "baz");
	}

	protected void assertSelectedFeature(JvmFeatureScope scope, String lookup, String expectedSimpleName) {
		Iterator<IEObjectDescription> elements = scope.getElements(QualifiedName.create(lookup)).iterator();
		assertTrue(elements.hasNext());
		while(elements.hasNext()) {
			IEObjectDescription element = elements.next();
			assertTrue(element instanceof JvmFeatureDescription);
			JvmFeature feature = ((JvmFeatureDescription)element).getJvmFeature();
			String featureName = feature.getSimpleName();
			assertEquals(expectedSimpleName, featureName);
			assertFalse(elements.hasNext());
		}
	}
	
	protected void assertSimpleNameFeatureSelected(JvmFeatureScope scope, String feature) {
		Iterator<IEObjectDescription> elements = scope.getElements(QualifiedName.create(feature)).iterator();
		assertTrue(elements.hasNext());
		IEObjectDescription element = elements.next();
		assertTrue(element instanceof JvmFeatureDescription);
		assertEquals(feature, ((JvmFeatureDescription)element).getJvmFeature().getSimpleName());
		assertFalse(elements.hasNext());
	}
}
