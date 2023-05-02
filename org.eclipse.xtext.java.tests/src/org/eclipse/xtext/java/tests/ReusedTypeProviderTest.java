/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.java.tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProviderTest;
import org.eclipse.xtext.common.types.testSetups.AbstractMethods;
import org.eclipse.xtext.common.types.testSetups.Bug347739ThreeTypeParamsSuperSuper;
import org.eclipse.xtext.common.types.testSetups.ClassWithVarArgs;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

@RunWith(XtextRunner.class)
@InjectWith(JavaInjectorProvider.class)
public class ReusedTypeProviderTest extends AbstractTypeProviderTest {
	@Inject
	private IncrementalBuilder builder;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	private static IJvmTypeProvider typeProvider;

	public static List<String> readResource(String name) throws Exception {
		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(ReusedTypeProviderTest.class.getResourceAsStream(name)))) {
			String line = null;
			List<String> result = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
			return result;
		}
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		if (ReusedTypeProviderTest.typeProvider == null) {
			String pathToSources = "/org/eclipse/xtext/common/types/testSetups";
			List<String> files = ReusedTypeProviderTest.readResource(pathToSources + "/files.list");
			ResourceDescriptionsData part = new ResourceDescriptionsData(Collections.emptySet());
			XtextResourceSet resourceSet = resourceSetProvider.get();
			ProjectDescription projectDesc = new ProjectDescription();
			projectDesc.setName("my-test-project");
			projectDesc.attachToEmfObject(resourceSet);
			ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(Collections.emptyMap(), resourceSet);
			index.setContainer(projectDesc.getName(), part);
			resourceSet.setClasspathURIContext(ReusedTypeProviderTest.class.getClassLoader());

			typeProviderFactory.createTypeProvider(resourceSet);
			BuildRequest buildRequest = new BuildRequest();
			for (String file : files) {
				if (file != null) {
					String fullPath = pathToSources + "/" + file;
					URL url = ReusedTypeProviderTest.class.getResource(fullPath);
					buildRequest.getDirtyFiles().add(URI.createURI(url.toExternalForm()));
				}
			}
			buildRequest.setResourceSet(resourceSet);
			buildRequest.setState(new IndexState(part, new Source2GeneratedMapping()));
			builder.build(buildRequest, (URI it) -> {
				return resourceServiceProviderRegistry.getResourceServiceProvider(it);
			});
			ReusedTypeProviderTest.typeProvider = typeProviderFactory.findTypeProvider(resourceSet);
		}
	}

	@Override
	protected IJvmTypeProvider getTypeProvider() {
		return ReusedTypeProviderTest.typeProvider;
	}

	@Override
	protected String getCollectionParamName() {
		return "arg0";
	}

	@Test
	@Override
	public void testFindTypeByName_AbstractMultimap_02() {
		String typeName = "com.google.common.collect.AbstractMultimap";
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation containsValue = (JvmOperation) Iterables
				.getOnlyElement(type.findAllFeaturesByName("containsValue"));
		Assert.assertNotNull(containsValue);
		JvmFormalParameter firstParam = containsValue.getParameters().get(0);
		assertEquals(1, firstParam.getAnnotations().size());
		JvmAnnotationReference annotationReference = firstParam.getAnnotations().get(0);
		JvmAnnotationType annotationType = annotationReference.getAnnotation();
		assertEquals("java:/Objects/javax.annotation.CheckForNull", EcoreUtil.getURI(annotationType).trimFragment().toString());
	}

	@Test
	@Override
	public void testParameterNames_01() {
		doTestParameterName(Bug347739ThreeTypeParamsSuperSuper.class, "getToken(A)", "arg0");
	}

	@Test
	@Override
	public void testParameterNames_02() {
		doTestParameterName(AbstractMethods.class, "abstractMethodWithParameter(java.lang.String)", "arg0");
	}

	@Test
	@Override
	public void testParameterNames_03() {
		doTestParameterName(ClassWithVarArgs.class, "method(java.lang.String[])", "arg0");
	}

	@Ignore
	@Test
	@Override
	public void testFindTypeByName_NestedTypeQualifiedWithSubType_02() {
		super.testFindTypeByName_NestedTypeQualifiedWithSubType_02();
	}
}
