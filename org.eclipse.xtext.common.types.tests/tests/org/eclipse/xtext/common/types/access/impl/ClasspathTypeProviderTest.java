/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.binary.BinaryClassMirror;
import org.eclipse.xtext.common.types.testSetups.AbstractMethods;
import org.eclipse.xtext.common.types.testSetups.Bug347739ThreeTypeParamsSuperSuper;
import org.eclipse.xtext.common.types.testSetups.ClassWithVarArgs;
import org.eclipse.xtext.common.types.xtext.ui.tests.RefactoringTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RefactoringTestLanguageInjectorProvider.class)
public class ClasspathTypeProviderTest extends AbstractTypeProviderTest {

	@Inject
	private ResourceSet resourceSet;

	@Inject
	private IndexedJvmTypeAccess indexedJvmTypeAccess;

	private ClasspathTypeProvider typeProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		typeProvider = createTypeProvider();
	}

	protected ClasspathTypeProvider createTypeProvider() {
		return new ClasspathTypeProvider(getClass().getClassLoader(), resourceSet, indexedJvmTypeAccess, null);
	}

	protected ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	protected IndexedJvmTypeAccess getIndexedJvmTypeAccess() {
		return indexedJvmTypeAccess;
	}

	@After
	public void tearDown() throws Exception {
		typeProvider = null;
	}

	@Test
	public void testSetup_01() {
		Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap();
		assertSame(getTypeProvider(), map.get(URIHelperConstants.PROTOCOL));
	}

	@Test
	public void testCreateResource_01() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = getTypeProvider().createResource(primitivesURI);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}

	@Test
	public void testCreateResource_02() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = (TypeResource) resourceSet.createResource(primitivesURI);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}

	@Test
	public void testGetResource_01() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, true);
		assertNotNull(resource);
		assertTrue(resource.isLoaded());
		assertEquals(9, resource.getContents().size());
	}

	@Test
	public void testGetResource_02() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, false);
		assertNull(resource);
	}

	@Test
	public void testGetResource_03() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource createdResource = (TypeResource) resourceSet.createResource(primitivesURI);
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, false);
		assertSame(createdResource, resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}

	@Test
	public void testGetResource_04() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource createdResource = (TypeResource) resourceSet.createResource(primitivesURI);
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, true);
		assertSame(createdResource, resource);
		assertTrue(resource.isLoaded());
		assertEquals(9, resource.getContents().size());
	}

	@Test
	public void testCreateMirror_01() {
		URI uri = URI.createURI("java:/Objects/java.util.Map");
		IMirror mirror = getTypeProvider().createMirror(uri);
		assertNotNull(mirror);
		assertTrue(mirror instanceof BinaryClassMirror);
		assertEquals("java.util.Map", ((BinaryClassMirror) mirror).getMirroredClass().getName());
	}

	@Test
	public void testCreateMirror_02() {
		URI uri = URI.createURI("java:/Primitives");
		IMirror mirror = getTypeProvider().createMirror(uri);
		assertNotNull(mirror);
		assertTrue(mirror instanceof PrimitiveMirror);
	}

	@Test
	public void testCreateMirror_03() {
		URI uri = URI.createURI("java:/Something");
		try {
			getTypeProvider().createMirror(uri);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}

	@Test
	public void testCreateMirror_04() {
		URI uri = URI.createURI("java:/Primitives").appendFragment("int");
		try {
			getTypeProvider().createMirror(uri);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}

	@Test
	public void testCreateMirror_05() {
		URI uri = URI.createURI("java:/Objects/java.lang.does.not.exist");
		assertNull(getTypeProvider().createMirror(uri));
	}

	@Test
	public void testBug337307() {
		String typeName = "ClassWithDefaultPackage";
		JvmType type = getTypeProvider().findTypeByName(typeName);
		assertNotNull(type);
		assertTrue(type instanceof JvmGenericType);
		assertEquals(typeName, type.getIdentifier());
		assertEquals(typeName, type.getQualifiedName());
		assertEquals(typeName, type.getSimpleName());
		assertNull(((JvmDeclaredType) type).getPackageName());
		diagnose(type);
		Resource resource = type.eResource();
		getAndResolveAllFragments(resource);
		recomputeAndCheckIdentifiers(resource);
	}

	@Test
	public void testJvmTypeSimple() {
		Resource resource = resourceSet.createResource(URI.createURI("foo.typesRefactoring"));
		JvmGenericType expected = TypesFactory.eINSTANCE.createJvmGenericType();
		expected.setSimpleName("SimpleName");
		expected.setPackageName("package.name");
		resource.getContents().add(expected);
		JvmType actual = getTypeProvider().findTypeByName("package.name.SimpleName");
		assertEquals(expected, actual);
	}

	@Test
	public void testJvmTypeNoPackage() {
		Resource resource = resourceSet.createResource(URI.createURI("foo.typesRefactoring"));
		JvmGenericType expected = TypesFactory.eINSTANCE.createJvmGenericType();
		expected.setSimpleName("SimpleName");
		resource.getContents().add(expected);
		JvmType actual = getTypeProvider().findTypeByName("SimpleName");
		assertEquals(expected, actual);
	}

	@Test
	public void testJvmTypeNestedClass() {
		Resource resource = resourceSet.createResource(URI.createURI("foo.typesRefactoring"));
		JvmGenericType container = TypesFactory.eINSTANCE.createJvmGenericType();
		container.setSimpleName("SimpleName");
		container.setPackageName("package.name");
		JvmGenericType expected = TypesFactory.eINSTANCE.createJvmGenericType();
		expected.setSimpleName("Child");
		container.getMembers().add(expected);
		resource.getContents().add(container);
		JvmType actual = getTypeProvider().findTypeByName("package.name.SimpleName$Child");
		assertEquals(expected, actual);
	}

	@Test
	public void testJvmTypeNestedClassWithDot_01() {
		Resource resource = resourceSet.createResource(URI.createURI("foo.typesRefactoring"));
		JvmGenericType container = TypesFactory.eINSTANCE.createJvmGenericType();
		container.setSimpleName("SimpleName");
		container.setPackageName("package.name");
		JvmGenericType expected = TypesFactory.eINSTANCE.createJvmGenericType();
		expected.setSimpleName("Child");
		container.getMembers().add(expected);
		resource.getContents().add(container);
		JvmType actual = getTypeProvider().findTypeByName("package.name.SimpleName.Child", false);
		assertEquals(expected, actual);
	}

	@Test
	public void testJvmTypeNestedClassWithDot_02() {
		Resource resource = resourceSet.createResource(URI.createURI("foo.typesRefactoring"));
		JvmGenericType container = TypesFactory.eINSTANCE.createJvmGenericType();
		container.setSimpleName("SimpleName");
		container.setPackageName("package.name");
		JvmGenericType expected = TypesFactory.eINSTANCE.createJvmGenericType();
		expected.setSimpleName("Child");
		container.getMembers().add(expected);
		resource.getContents().add(container);
		JvmType actual = getTypeProvider().findTypeByName("package.name.SimpleName.Child", true);
		assertNull(actual);
	}

	@Test
	public void testJvmTypeArray() {
		Resource resource = resourceSet.createResource(URI.createURI("foo.typesRefactoring"));
		JvmGenericType expected = TypesFactory.eINSTANCE.createJvmGenericType();
		expected.setSimpleName("SimpleName");
		expected.setPackageName("package.name");
		resource.getContents().add(expected);
		JvmType actual = getTypeProvider().findTypeByName("package.name.SimpleName[]");
		assertTrue(actual instanceof JvmArrayType);
		assertEquals(expected, ((JvmArrayType) actual).getComponentType());
	}

	@Override
	public ClasspathTypeProvider getTypeProvider() {
		return typeProvider;
	}

	@Override
	protected String getCollectionParamName() {
		return "arg0";
	}

	@Override
	@Test
	public void testFindTypeByName_AbstractMultimap_02() {
		String typeName = "com.google.common.collect.AbstractMultimap";
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmOperation containsValue = (JvmOperation) Iterables.getOnlyElement(type.findAllFeaturesByName("containsValue"));
		assertNotNull(containsValue);
		JvmFormalParameter firstParam = containsValue.getParameters().get(0);
		assertEquals(0, firstParam.getAnnotations().size());
	}
	
	@Override
	@Test
	public void testParameterNames_01() {
		doTestParameterName(Bug347739ThreeTypeParamsSuperSuper.class, "getToken(A)", "arg0");
	}
	@Override
	@Test
	public void testParameterNames_02() {
		doTestParameterName(AbstractMethods.class, "abstractMethodWithParameter(java.lang.String)", "arg0");
	}
	@Override
	@Test
	public void testParameterNames_03() {
		doTestParameterName(ClassWithVarArgs.class, "method(java.lang.String[])", "arg0");
	}
	
	@Test
	public void testJvmTypeSimple_Issue145() {
		Resource resource = resourceSet.createResource(URI.createURI("foo.typesRefactoring"));
		JvmGenericType expected = TypesFactory.eINSTANCE.createJvmGenericType();
		expected.setSimpleName("SimpleName");
		expected.setPackageName("package.name");
		resource.getContents().add(expected);
		JvmType actual = getTypeProvider().findTypeByName("package.name.SimpleName");
		assertEquals(expected, actual);
		resource.getContents().remove(expected);
		((InternalEObject)expected).eSetProxyURI(EcoreUtil.getURI(expected));
		JvmGenericType expected2 = TypesFactory.eINSTANCE.createJvmGenericType();
		expected2.setSimpleName("SimpleName");
		expected2.setPackageName("package.name");
		resource.getContents().add(expected2);
		JvmType actual2 = getTypeProvider().findTypeByName("package.name.SimpleName");
		assertEquals(expected2, actual2);
	}
}
