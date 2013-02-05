/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping.featurecalls;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.scoping.featurecalls.DefaultJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.IJvmFeatureDescriptionProvider;
import org.eclipse.xtext.xbase.scoping.featurecalls.JvmFeatureScope;
import org.junit.Ignore;
import org.junit.Test;

import testdata.StaticVisibilitySubClass;
import testdata.StaticVisibilitySuperType;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Ignore("This class tests obsolete implementation details")
@SuppressWarnings("deprecation")
public class ExplicitStaticFeaturesTypeProviderTest extends AbstractJvmFeatureScopeProviderTest {

	@Inject
	private Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureDescProvider;

	protected JvmFeatureScope createScope(Resource resource, JvmTypeReference reference) {
		DefaultJvmFeatureDescriptionProvider defaultProvider = defaultFeatureDescProvider.get();
		defaultProvider.setContextType((JvmDeclaredType) reference.getType());
		defaultProvider.setImplicitReceiver(null);
		defaultProvider.setImplicitArgument(null);
		defaultProvider.setPreferStatics(true);

		JvmFeatureScope scope = getFeatureProvider().createFeatureScope(
				IScope.NULLSCOPE,
				createScopeDescriptions(reference,
						Lists.<IJvmFeatureDescriptionProvider> newArrayList(defaultProvider /*, sugarProvider */)));

		return scope;
	}

	protected String formatScope(JvmFeatureScope scope) {
		ArrayList<String> ids = Lists.newArrayList(getSignatures(scope));
		Collections.sort(ids);
		String result = Joiner.on('\n').join(ids);
		if (scope.getParent() instanceof JvmFeatureScope) {
			String parent = formatScope((JvmFeatureScope) scope.getParent());
			return result + "\nparent = {\n  " + parent.replace("\n", "\n  ") + "\n}";
		}
		return result;
	}

	@Test public void testVisibilitySubType() throws Exception {
		JvmTypeReference reference = getTypeRef(StaticVisibilitySubClass.class.getCanonicalName());
		JvmFeatureScope scope = createScope(reference.eResource(), reference);
		String actual = formatScope(scope);

		StringBuilder expectation = new StringBuilder();
		expectation.append("setStaticProtectedProperty(java.lang.String)\n");
		expectation.append("setStaticPublicProperty(java.lang.String)\n");
		expectation.append("staticProtectedField\n");
		expectation.append("staticProtectedMethod()\n");
		expectation.append("staticPublicField\n");
		expectation.append("staticPublicMethod()\n");
		expectation.append("parent = {\n");
		expectation.append("  clone()\n");
		expectation.append("  equals(java.lang.Object)\n");
		expectation.append("  finalize()\n");
		expectation.append("  getClass()\n");
		expectation.append("  getSubPrivateProperty()\n");
		expectation.append("  hashCode()\n");
		expectation.append("  notify()\n");
		expectation.append("  notifyAll()\n");
		expectation.append("  privateField\n");
		expectation.append("  privateMethod()\n");
		expectation.append("  protectedField\n");
		expectation.append("  protectedMethod()\n");
		expectation.append("  publicField\n");
		expectation.append("  publicMethod()\n");
		expectation.append("  registerNatives()\n");
		expectation.append("  setPrivateProperty(java.lang.String)\n");
		expectation.append("  setProtectedProperty(java.lang.String)\n");
		expectation.append("  setPublicProperty(java.lang.String)\n");
		expectation.append("  setStaticPrivateProperty(java.lang.String)\n");
		expectation.append("  staticPrivateField\n");
		expectation.append("  staticPrivateMethod()\n");
		expectation.append("  toString()\n");
		expectation.append("  wait()\n");
		expectation.append("  wait(long)\n");
		expectation.append("  wait(long,int)\n");
		expectation.append("}");
		assertEquals(expectation.toString(), actual);
	}

	@Test public void testVisibilitySuperType() throws Exception {
		JvmTypeReference reference = getTypeRef(StaticVisibilitySuperType.class.getCanonicalName());
		JvmFeatureScope scope = createScope(reference.eResource(), reference);
		String actual = formatScope(scope);

		StringBuilder expectation = new StringBuilder();
		expectation.append("setStaticPrivateProperty(java.lang.String)\n");
		expectation.append("setStaticProtectedProperty(java.lang.String)\n");
		expectation.append("setStaticPublicProperty(java.lang.String)\n");
		expectation.append("staticPrivateField\n");
		expectation.append("staticPrivateMethod()\n");
		expectation.append("staticProtectedField\n");
		expectation.append("staticProtectedMethod()\n");
		expectation.append("staticPublicField\n");
		expectation.append("staticPublicMethod()\n");
		expectation.append("parent = {\n");
		expectation.append("  clone()\n");
		expectation.append("  equals(java.lang.Object)\n");
		expectation.append("  finalize()\n");
		expectation.append("  getClass()\n");
		expectation.append("  hashCode()\n");
		expectation.append("  notify()\n");
		expectation.append("  notifyAll()\n");
		expectation.append("  privateField\n");
		expectation.append("  privateMethod()\n");
		expectation.append("  protectedField\n");
		expectation.append("  protectedMethod()\n");
		expectation.append("  publicField\n");
		expectation.append("  publicMethod()\n");
		expectation.append("  registerNatives()\n");
		expectation.append("  setPrivateProperty(java.lang.String)\n");
		expectation.append("  setProtectedProperty(java.lang.String)\n");
		expectation.append("  setPublicProperty(java.lang.String)\n");
		expectation.append("  toString()\n");
		expectation.append("  wait()\n");
		expectation.append("  wait(long)\n");
		expectation.append("  wait(long,int)\n");
		expectation.append("}");
		assertEquals(expectation.toString(), actual);
	}

}
