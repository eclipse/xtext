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
import org.eclipse.xtext.xbase.scoping.featurecalls.StaticExplicitMethodsFeatureForTypeProvider;

import testdata.StaticVisibilitySubClass;
import testdata.StaticVisibilitySuperType;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ExplicitStaticFeaturesTypeProviderTest extends AbstractJvmFeatureScopeProviderTest {

	@Inject
	private Provider<DefaultJvmFeatureDescriptionProvider> defaultFeatureDescProvider;

	@Inject
	private Provider<StaticExplicitMethodsFeatureForTypeProvider> explicitStaticFeatures;

	//	@Inject
	//	private Provider<XFeatureCallSugarDescriptionProvider> sugarFeatureDescProvider;

	protected JvmFeatureScope createScope(Resource resource, JvmTypeReference reference) {
		StaticExplicitMethodsFeatureForTypeProvider explicitMethodsProvider = explicitStaticFeatures.get();
		explicitMethodsProvider.setResourceContext(resource);
		explicitMethodsProvider.setTypeContext(reference);
		DefaultJvmFeatureDescriptionProvider defaultProvider = defaultFeatureDescProvider.get();
		defaultProvider.setContextType((JvmDeclaredType) reference.getType());
		defaultProvider.setFeaturesForTypeProvider(explicitMethodsProvider);
		defaultProvider.setImplicitReceiver(null);
		defaultProvider.setImplicitArgument(null);
		defaultProvider.setPreferStatics(true);

		//		XFeatureCallSugarDescriptionProvider sugarProvider = sugarFeatureDescProvider.get();
		//		sugarProvider.setContextType((JvmDeclaredType) reference.getType());
		//		sugarProvider.setFeaturesForTypeProvider(explicitMethodsProvider);
		//		sugarProvider.setImplicitReceiver(null);
		//		sugarProvider.setImplicitArgument(null);
		//		sugarProvider.setPreferStatics(true);

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

	public void testVisibilitySubType() throws Exception {
		JvmTypeReference reference = getTypeRef(StaticVisibilitySubClass.class.getCanonicalName());
		JvmFeatureScope scope = createScope(reference.eResource(), reference);
		String actual = formatScope(scope);

		StringBuilder expectation = new StringBuilder();
		expectation.append("getProtectedProperty()\n");
		expectation.append("getPublicProperty()\n");
		expectation.append("protectedField\n");
		expectation.append("protectedMethod()\n");
		expectation.append("publicField\n");
		expectation.append("publicMethod()\n");
		expectation.append("setProtectedProperty(java.lang.String)\n");
		expectation.append("setPublicProperty(java.lang.String)\n");
		expectation.append("parent = {\n");
		expectation.append("  getPrivateProperty()\n");
		expectation.append("  privateField\n");
		expectation.append("  privateMethod()\n");
		expectation.append("  registerNatives()\n");
		expectation.append("  setPrivateProperty(java.lang.String)\n");
		expectation.append("}");
		assertEquals(expectation.toString(), actual);
	}

	public void testVisibilitySuperType() throws Exception {
		JvmTypeReference reference = getTypeRef(StaticVisibilitySuperType.class.getCanonicalName());
		JvmFeatureScope scope = createScope(reference.eResource(), reference);
		String actual = formatScope(scope);

		StringBuilder expectation = new StringBuilder();
		expectation.append("getPrivateProperty()\n");
		expectation.append("getProtectedProperty()\n");
		expectation.append("getPublicProperty()\n");
		expectation.append("privateField\n");
		expectation.append("privateMethod()\n");
		expectation.append("protectedField\n");
		expectation.append("protectedMethod()\n");
		expectation.append("publicField\n");
		expectation.append("publicMethod()\n");
		expectation.append("setPrivateProperty(java.lang.String)\n");
		expectation.append("setProtectedProperty(java.lang.String)\n");
		expectation.append("setPublicProperty(java.lang.String)\n");
		expectation.append("parent = {\n");
		expectation.append("  registerNatives()\n");
		expectation.append("}");
		assertEquals(expectation.toString(), actual);
	}

}
