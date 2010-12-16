/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping.featurecalls;

import static com.google.common.collect.Sets.*;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XAssignmentSugarDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.XFeatureCallSugarDescriptionProvider;

import testdata.FieldAccessSub;
import testdata.VisibilitySubClass;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XAssignmentDescriptionProviderTest extends AbstractJvmFeatureScopeProviderTest {
	
	public void testFinalFields() throws Exception {
		JvmTypeReference reference = getTypeRef(FieldAccessSub.class.getCanonicalName());
		final XFeatureCallSugarDescriptionProvider sugarProvider = new XFeatureCallSugarDescriptionProvider();
		sugarProvider.setOperatorMapping(new OperatorMapping());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(reference,
				newXAssignmentDescriptionProvider(),newXAssignmentSugarDescriptionProvider());
		
		assertEquals(4, numberOfScopes(scope));
		
		assertSetsEqual(newHashSet("stringField"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("stringField"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateField"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("finalField"),	getSignatures(scope));
		assertSame(IScope.NULLSCOPE, scope.getParent());
	}
	
	public void testAssignments() throws Exception {
		JvmTypeReference reference = getTypeRef(VisibilitySubClass.class.getCanonicalName());
		final XFeatureCallSugarDescriptionProvider sugarProvider = new XFeatureCallSugarDescriptionProvider();
		sugarProvider.setOperatorMapping(new OperatorMapping());
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(reference,
				newXAssignmentDescriptionProvider(),newXAssignmentSugarDescriptionProvider());
		
		assertEquals(4, numberOfScopes(scope));
		
		assertSetsEqual(newHashSet("publicField"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("publicProperty"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateField","protectedField"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateProperty","protectedProperty"),	getSignatures(scope));
		assertSame(IScope.NULLSCOPE, scope.getParent());
	}
	
	public void testAssignments_01() throws Exception {
		JvmTypeReference reference = getTypeRef(VisibilitySubClass.class.getCanonicalName());
		final XFeatureCallSugarDescriptionProvider sugarProvider = new XFeatureCallSugarDescriptionProvider();
		sugarProvider.setOperatorMapping(new OperatorMapping());
		final XAssignmentDescriptionProvider newXAssignmentDescriptionProvider = newXAssignmentDescriptionProvider();
		final XAssignmentSugarDescriptionProvider newXAssignmentSugarDescriptionProvider = newXAssignmentSugarDescriptionProvider();
		
		newXAssignmentDescriptionProvider.setContextType((JvmDeclaredType) reference.getType());
		newXAssignmentSugarDescriptionProvider.setContextType((JvmDeclaredType) reference.getType());
		
		JvmFeatureScope scope = getFeatureProvider().createFeatureScopeForTypeRef(reference,
				newXAssignmentDescriptionProvider,newXAssignmentSugarDescriptionProvider);
		
		assertEquals(4, numberOfScopes(scope));
		
		assertSetsEqual(newHashSet("publicField","protectedField"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("publicProperty","protectedProperty"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateField"),	getSignatures(scope));
		scope = (JvmFeatureScope) scope.getParent();
		assertSetsEqual(newHashSet("privateProperty"),	getSignatures(scope));
		assertSame(IScope.NULLSCOPE, scope.getParent());
	}

	protected XAssignmentSugarDescriptionProvider newXAssignmentSugarDescriptionProvider() {
		final XAssignmentSugarDescriptionProvider xAssignmentSugarDescriptionProvider = new XAssignmentSugarDescriptionProvider();
		xAssignmentSugarDescriptionProvider.setVisibilityService(createVisibilityService());
		return xAssignmentSugarDescriptionProvider;
	}

	protected XAssignmentDescriptionProvider newXAssignmentDescriptionProvider() {
		final XAssignmentDescriptionProvider xAssignmentDescriptionProvider = new XAssignmentDescriptionProvider();
		xAssignmentDescriptionProvider.setVisibilityService(createVisibilityService());
		return xAssignmentDescriptionProvider;
	}
}
