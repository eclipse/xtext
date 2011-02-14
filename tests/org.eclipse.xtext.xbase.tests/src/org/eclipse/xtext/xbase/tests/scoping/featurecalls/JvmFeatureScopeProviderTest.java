/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping.featurecalls;

import static com.google.common.collect.Lists.*;
import static com.google.common.collect.Sets.*;

import java.util.Iterator;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.common.types.util.TypeArgumentContext;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;

import testdata.FieldAccess;
import testdata.FieldAccessSub;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmFeatureScopeProviderTest extends AbstractJvmFeatureScopeProviderTest {

	public void testNoSugarNoFilterNoInvalids() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(reference,
				newArrayList(new DefaultJvmFeatureDescriptionProvider() {
					@Override
					protected boolean isValid(JvmFeature feature) {
						return true;
					}
				}));
		assertEquals(3, numberOfScopes(scope));

		assertSetsEqual(newHashSet("privateField", "privateField()", "stringField", "stringField()"),
				getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("finalField", "stringField", "staticField"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(
				newHashSet("registerNatives()", "wait(long)", "clone()", "toString()", "getClass()", "hashCode()",
						"notify()", "wait(long,int)", "equals(java.lang.Object)", "wait()", "notifyAll()", "finalize()"),
				getSignatures(scope));
		assertSame(IScope.NULLSCOPE, scope.getParent());
	}

	public void testNoSugarNoFilterWithInvalids() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(reference,
				newArrayList(new DefaultJvmFeatureDescriptionProvider() {
					@Override
					protected boolean isValid(JvmFeature feature) {
						return ((JvmMember) feature).getVisibility() != JvmVisibility.PRIVATE;
					}
				}));
		assertSetsEqual(newHashSet("privateField()", "stringField", "stringField()"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("finalField", "stringField", "staticField"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(
				newHashSet("wait(long)", "clone()", "toString()", "getClass()", "hashCode()", "notify()",
						"wait(long,int)", "equals(java.lang.Object)", "wait()", "notifyAll()", "finalize()"),
				getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateField"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("registerNatives()"), getSignatures(scope));
		assertSame(IScope.NULLSCOPE, scope.getParent());
	}

	public void testNoSugarwithFilterwithInvalids() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(reference,
				newArrayList(new DefaultJvmFeatureDescriptionProvider() {
					@Override
					public void addFeatureDescriptions(JvmFeature feature, TypeArgumentContext context,
							IAcceptor<JvmFeatureDescription> acceptor) {
						if (((JvmMember) feature).getDeclaringType().getIdentifier().equals("java.lang.Object"))
							return;
						super.addFeatureDescriptions(feature, context, acceptor);
					}

					@Override
					protected boolean isValid(JvmFeature feature) {
						return ((JvmMember) feature).getVisibility() != JvmVisibility.PRIVATE;
					}
				}));
		assertEquals(3, numberOfScopes(scope));

		assertSetsEqual(newHashSet("privateField()", "stringField", "stringField()"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("finalField", "stringField", "staticField"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateField"), getSignatures(scope));
		assertSame(IScope.NULLSCOPE, scope.getParent());
	}

	public void testWithMultipleDescriptionProviders() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		final XFeatureCallSugarDescriptionProvider sugarProvider = new XFeatureCallSugarDescriptionProvider();
		sugarProvider.setOperatorMapping(new OperatorMapping());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(reference,
				newArrayList(new DefaultJvmFeatureDescriptionProvider() {
					@Override
					public void addFeatureDescriptions(JvmFeature feature, TypeArgumentContext context,
							IAcceptor<JvmFeatureDescription> acceptor) {
						if (feature.getSimpleName().equals("hashCode"))
							return;
						super.addFeatureDescriptions(feature, context, acceptor);
					}

					@Override
					protected boolean isValid(JvmFeature feature) {
						return ((JvmMember) feature).getVisibility() != JvmVisibility.PRIVATE;
					}
				},
				new DefaultJvmFeatureDescriptionProvider() {
					@Override
					public void addFeatureDescriptions(JvmFeature feature, TypeArgumentContext context,
							IAcceptor<JvmFeatureDescription> acceptor) {
						if (!feature.getSimpleName().equals("hashCode"))
							return;
						super.addFeatureDescriptions(feature, context, acceptor);
					}

					@Override
					protected boolean isValid(JvmFeature feature) {
						return ((JvmMember) feature).getVisibility() != JvmVisibility.PRIVATE;
					}
				}));
		assertEquals(6, numberOfScopes(scope));

		assertSetsEqual(newHashSet("privateField()", "stringField", "stringField()"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("finalField", "stringField", "staticField"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("wait(long)", "toString()", "getClass()", /*filtered : "hashCode()", */
		"notify()", "wait(long,int)", "equals(java.lang.Object)", "wait()", "notifyAll()", "clone()", "finalize()"),
				getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("hashCode()"),
				getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateField"), getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("registerNatives()"), getSignatures(scope));
		assertSame(IScope.NULLSCOPE, scope.getParent());
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
