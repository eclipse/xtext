/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.jdt;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.IMethodBinding;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmVoid;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.IMirror;
import org.eclipse.xtext.common.types.access.TypeResource;
import org.eclipse.xtext.common.types.access.impl.PrimitiveMirror;
import org.eclipse.xtext.common.types.access.impl.URIHelperConstants;
import org.eclipse.xtext.common.types.testSetups.AbstractMethods;
import org.eclipse.xtext.common.types.testSetups.Bug347739ThreeTypeParamsSuperSuper;
import org.eclipse.xtext.common.types.util.jdt.JavaElementFinder;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtTypeProviderTest extends AbstractJdtTypeProviderTest {

	private ResourceSet resourceSet;
	private JdtTypeProvider typeProvider;
	private MockJavaProjectProvider projectProvider;
	private JavaElementFinder elementFinder;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		resourceSet = new ResourceSetImpl();
		projectProvider = new MockJavaProjectProvider();
		typeProvider = new JdtTypeProvider(projectProvider.getJavaProject(resourceSet), resourceSet);
		elementFinder = new JavaElementFinder();
		elementFinder.setProjectProvider(projectProvider);
	}
	
	@After
	public void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
	}

	@Override
	protected IJvmTypeProvider getTypeProvider() {
		return typeProvider;
	}

	@Test public void testSetup_01() {
		Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap();
		assertSame(typeProvider, map.get(URIHelperConstants.PROTOCOL));
	}

	@Test public void testCreateResource_01() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = typeProvider.createResource(primitivesURI);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}

	@Test public void testCreateResource_02() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = (TypeResource) resourceSet.createResource(primitivesURI);
		assertNotNull(resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}

	@Test public void testGetResource_01() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, true);
		assertNotNull(resource);
		assertTrue(resource.isLoaded());
		assertEquals(9, resource.getContents().size());
	}

	@Test public void testGetResource_02() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, false);
		assertNull(resource);
	}

	@Test public void testGetResource_03() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource createdResource = (TypeResource) resourceSet.createResource(primitivesURI);
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, false);
		assertSame(createdResource, resource);
		assertFalse(resource.isLoaded());
		assertTrue(resource.getContents().isEmpty());
	}

	@Test public void testGetResource_04() {
		URI primitivesURI = URI.createURI("java:/Primitives");
		TypeResource createdResource = (TypeResource) resourceSet.createResource(primitivesURI);
		TypeResource resource = (TypeResource) resourceSet.getResource(primitivesURI, true);
		assertSame(createdResource, resource);
		assertTrue(resource.isLoaded());
		assertEquals(9, resource.getContents().size());
	}

	@Test public void testCreateMirror_01() {
		URI uri = URI.createURI("java:/Objects/java.util.Map");
		IMirror mirror = typeProvider.createMirror(uri);
		assertNotNull(mirror);
		assertTrue(mirror instanceof JdtTypeMirror);
		assertEquals("java.util.Map", ((JdtTypeMirror) mirror).getMirroredType().getFullyQualifiedName());
	}

	@Test public void testCreateMirror_02() {
		URI uri = URI.createURI("java:/Primitives");
		IMirror mirror = typeProvider.createMirror(uri);
		assertNotNull(mirror);
		assertTrue(mirror instanceof PrimitiveMirror);
	}

	@Test public void testCreateMirror_03() {
		URI uri = URI.createURI("java:/Something");
		try {
			typeProvider.createMirror(uri);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}

	@Test public void testCreateMirror_04() {
		URI uri = URI.createURI("java:/Primitives").appendFragment("int");
		try {
			typeProvider.createMirror(uri);
			fail("Expected IllegalArgumentException");
		} catch (IllegalArgumentException ex) {
			// ok
		}
	}

	@Test public void testCreateMirror_05() {
		URI uri = URI.createURI("java:/Objects/java.lang.does.not.exist");
		assertNull(typeProvider.createMirror(uri));
	}

	@Test public void testCreateMirror_06() {
		URI uri = URI.createURI("java:/Objects/java.lang.does.not.exist");
		assertNull(typeProvider.createMirror(uri));
	}

	@Test public void testBug300216() {
		JvmDeclaredType type = (JvmDeclaredType) getTypeProvider().findTypeByName("java.lang.Object");
		assertTrue(type.getSuperTypes().isEmpty());
		URI unresolveableType = URI.createURI("java:/Objects/Something#Something");
		JvmVoid proxy = TypesFactory.eINSTANCE.createJvmVoid();
		JvmParameterizedTypeReference typeReference = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
		typeReference.setType(proxy);
		((InternalEObject) proxy).eSetProxyURI(unresolveableType);
		type.getSuperTypes().add(typeReference);
		assertTrue(type.getSuperTypes().get(0).getType().eIsProxy());
		assertEquals(2, type.eResource().getResourceSet().getResources().size());
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=319993
	 */
	@Test public void testBug319993() {
		assertNull(getTypeProvider().findTypeByName("interface myAggregation"));
	}

	@Override
	protected String getCollectionParamName() {
		return "c";
	}
	
	@Override
	protected JvmOperation getMethodFromParameterizedMethods(String method) {
		JvmOperation result = super.getMethodFromParameterizedMethods(method);
		if (result != null) {
			IJavaElement found = elementFinder.findElementFor(result);
			assertEquals(IJavaElement.METHOD, found.getElementType());
			assertEquals(result.getSimpleName(), found.getElementName());
			IMethod foundMethod = (IMethod) found;
			assertEquals(result.getParameters().size(), foundMethod.getNumberOfParameters());
		}
		return result;
	}
	
	@Override
	protected JvmOperation getMethodFromType(EObject context, Class<?> type, String method) {
		JvmOperation result = super.getMethodFromType(context, type, method);
		if (result != null) {
			IJavaElement found = elementFinder.findElementFor(result);
			assertEquals(IJavaElement.METHOD, found.getElementType());
			assertEquals(result.getSimpleName(), found.getElementName());
			IMethod foundMethod = (IMethod) found;
			assertEquals(result.getParameters().size(), foundMethod.getNumberOfParameters());
		}		
		return result;
	}
	
	@Override
	protected JvmConstructor getConstructorFromType(EObject context, Class<?> type, String constructor) {
		JvmConstructor result = super.getConstructorFromType(context, type, constructor);
		if (result != null) {
			IJavaElement found = elementFinder.findElementFor(result);
			assertEquals(IJavaElement.METHOD, found.getElementType());
			assertEquals(result.getSimpleName(), found.getElementName());
			IMethod foundMethod = (IMethod) found;
			assertEquals(result.getParameters().size(), foundMethod.getNumberOfParameters());
		}
		return result;
	}
	
	@Override
	@Test
	@Ignore("TODO This one fails due to a bug in JDT for binary types")
	public void testFindTypeByName_$StartsWithDollar_01() {
		super.testFindTypeByName_$StartsWithDollar_01();
	}
	
	@Override
	protected void doTestInnerType_WrappedIterator_02(JvmGenericType wrappedIterator) {
		assertNotNull(wrappedIterator);
	}
	
	@Override
	protected void doTestInnerType_WrappedIterator_03(JvmGenericType wrappedIterator) {
		// TODO This one fails due to a bug in JDT for parameter annotations of binary, inner constructor
		assertNotNull(wrappedIterator);
	}

	// tests for the presence of the bug above
	@Override
	@Test
	public void testFindTypeByName_$StartsWithDollar_02() {
		String typeName = "org.eclipse.xtext.common.types.testSetups.$StartsWithDollar";
		JvmGenericType type = (JvmGenericType) getTypeProvider().findTypeByName(typeName);
		assertNull(type);
	}
	
	@Override
	@Test public void testEnum_05() throws Exception {
		if (isParameterNamesAvailable()) {
			super.testEnum_05();
		}
	}
	
	@Test public void testEnum_06() throws Exception {
		if (!isParameterNamesAvailable()) {
			doTestEnum_05("arg2");
		}
	}

	@SuppressWarnings("deprecation")
	private boolean isParameterNamesAvailable() throws Exception {
		ASTParser parser = ASTParser.newParser(AST.JLS3);
		parser.setIgnoreMethodBodies(true);
		IJavaProject javaProject = projectProvider.getJavaProject(resourceSet);
		parser.setProject(javaProject);
		IType type = javaProject.findType("org.eclipse.xtext.common.types.testSetups.TestEnum");
		IBinding[] bindings = parser.createBindings(new IJavaElement[] { type }, null);
		ITypeBinding typeBinding = (ITypeBinding) bindings[0];
		IMethodBinding[] methods = typeBinding.getDeclaredMethods();
		for(IMethodBinding method: methods) {
			if (method.isConstructor()) {
				IMethod element = (IMethod) method.getJavaElement();
				if (element.exists()) {
					String[] parameterNames = element.getParameterNames();
					if (parameterNames.length == 1 && parameterNames[0].equals("string")) {
						return true;
					}
				} else {
					return false;
				}
			}
		}
		return false;
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
}
