/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.reflect;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.AbstractRuntimeJvmTypeProvider;
import org.eclipse.xtext.common.types.access.impl.AbstractTypeProviderTest;
import org.eclipse.xtext.common.types.access.impl.ClassMirror;
import org.eclipse.xtext.common.types.access.impl.IndexedJvmTypeAccess;
import org.eclipse.xtext.common.types.access.impl.PrimitiveMirror;
import org.eclipse.xtext.common.types.access.impl.TypeResourceServices;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.testSetups.AbstractMethods;
import org.eclipse.xtext.common.types.testSetups.Bug347739ThreeTypeParamsSuperSuper;
import org.eclipse.xtext.common.types.testSetups.ClassWithVarArgs;
import org.eclipse.xtext.common.types.testSetups.DeprecatedMembers;
import org.eclipse.xtext.common.types.testSetups.TestConstants;
import org.eclipse.xtext.common.types.xtext.ui.RefactoringTestLanguageInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@RunWith(XtextRunner.class)
@InjectWith(RefactoringTestLanguageInjectorProvider.class)
public class ReflectionTypeProviderTest extends AbstractTypeProviderTest {

	@Inject
	protected ResourceSet resourceSet;

	@Inject
	protected IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	@Inject
	protected TypeResourceServices services;

	private AbstractRuntimeJvmTypeProvider typeProvider;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		typeProvider = createTypeProvider();
	}

	protected AbstractRuntimeJvmTypeProvider createTypeProvider() {
		return new ReflectionTypeProvider(getClass().getClassLoader(), resourceSet, indexedJvmTypeAccess, services);
	}

	protected ResourceSet getResourceSet() {
		return resourceSet;
	}

	@After
	public void tearDown() throws Exception {
		typeProvider = null;
	}

	@Override
	protected boolean isDefaultValueSupported() {
		return false;
	}
	
	@Override
	protected void checkDeprecatedBitSet(JvmMember member) {
		assertFalse(member.isSetDeprecated());
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
		assertTrue(mirror instanceof ClassMirror);
		assertEquals("java.util.Map", ((ClassMirror) mirror).getMirroredClass().getName());
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
	public AbstractRuntimeJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}

	@Override
	protected String getCollectionParamName() {
		return "arg0";
	}

	@Override
	@Test
	public void testConstantValue_01() {
		doTestConstantValue("stringConstant", TestConstants.stringConstant);
	}

	@Override
	protected JvmField doTestConstantValue(String fieldName, Object fieldValue) {
		String typeName = "org.eclipse.xtext.common.types.testSetups.TestConstants";
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		JvmField field = getFieldFromType(type, TestConstants.class, fieldName);
		assertFalse(field.isSetConstant());
		assertNull(field.getConstantValue());
		return field;
	}

	@Override
	@Test
	public void testConstantValue_02() {
		doTestConstantValue("longConstant", TestConstants.longConstant);
	}

	@Override
	@Test
	public void testConstantValue_03() {
		doTestConstantValue("intConstant", TestConstants.intConstant);
	}

	@Override
	@Test
	public void testConstantValue_04() {
		doTestConstantValue("shortConstant", TestConstants.shortConstant);
	}

	@Override
	@Test
	public void testConstantValue_05() {
		doTestConstantValue("charConstant", TestConstants.charConstant);
	}

	@Override
	@Test
	public void testConstantValue_06() {
		doTestConstantValue("byteConstant", TestConstants.byteConstant);
	}

	@Override
	@Test
	public void testConstantValue_07() {
		doTestConstantValue("doubleConstant", TestConstants.doubleConstant);
	}
	
	@Override
	@Test
	public void testConstantValue_07a() {
		doTestConstantValue("doubleConstantNaN", TestConstants.doubleConstant);
	}
	
	@Override
	@Test
	public void testConstantValue_07b() {
		doTestConstantValue("doubleConstantPosInf", TestConstants.doubleConstant);
	}
	
	@Override
	@Test
	public void testConstantValue_07c() {
		doTestConstantValue("doubleConstantNegInf", TestConstants.doubleConstant);
	}

	@Override
	@Test
	public void testConstantValue_08() {
		doTestConstantValue("floatConstant", TestConstants.floatConstant);
	}

	@Override
	@Test
	public void testConstantValue_08a() {
		doTestConstantValue("floatConstantNaN", TestConstants.floatConstant);
	}
	
	@Override
	@Test
	public void testConstantValue_08b() {
		doTestConstantValue("floatConstantPosInf", TestConstants.floatConstant);
	}
	
	@Override
	@Test
	public void testConstantValue_08c() {
		doTestConstantValue("floatConstantNegInf", TestConstants.floatConstant);
	}
	
	@Override
	@Test
	public void testConstantValue_09() {
		doTestConstantValue("booleanConstant", TestConstants.booleanConstant);
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
	
	@Override
	protected JvmTypeAnnotationValue getClassArrayAnnotationValue(JvmAnnotationReference annotationReference) {
		for(JvmAnnotationValue candidate: annotationReference.getExplicitValues()) {
			if (candidate instanceof JvmTypeAnnotationValue && candidate.getValueName().equals("classArray")) {
				return (JvmTypeAnnotationValue) candidate;
			}
		}
		fail("Cannot find annotation value 'classArray'");
		return null;
	}

	@Override
	@Test
	public void testDeprecatedBit_01() {
		String typeName = org.eclipse.xtext.common.types.testSetups.DeprecatedClass.class.getName();
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		assertFalse(type.isSetDeprecated());
		
		for(JvmMember member: type.getMembers()) {
			assertFalse(member.isSetDeprecated());
		}
	}
	
	@Override
	@Test
	public void testDeprecatedBit_02() {
		String typeName = DeprecatedMembers.class.getName();
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName(typeName);
		assertFalse(type.isSetDeprecated());
		
		for(JvmMember member: type.getMembers()) {
			assertFalse(member.isSetDeprecated());
		}
	}
}
