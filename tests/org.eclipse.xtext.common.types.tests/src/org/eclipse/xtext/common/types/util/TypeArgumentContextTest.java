/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.util.TypeArgumentContext.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeArgumentContextTest extends TestCase {

	private ClasspathTypeProvider typeProvider;
	private JvmTypeReferences typeRefs;
	private Provider typeArgCtxProvider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource syntheticResource = new XMLResourceImpl(URI.createURI("http://synthetic.resource"));
		resourceSet.getResources().add(syntheticResource);
		typeProvider = new ClasspathTypeProvider(getClass().getClassLoader(), resourceSet);
		typeRefs = new JvmTypeReferences(TypesFactory.eINSTANCE, typeProvider);
		typeArgCtxProvider = new TypeArgumentContext.Provider();
	}
	
	@Override
	protected void tearDown() throws Exception {
		typeProvider = null;
		typeRefs = null;
		super.tearDown();
	}
	
	public void testSimple() throws Exception {
		JvmTypeReference reference = typeRefs.typeReference("java.util.List").wildCardExtends("java.lang.CharSequence").create();
		TypeArgumentContext typeArgumentContext = typeArgCtxProvider.get(reference);
		JvmTypeReference argument = typeArgumentContext.getBoundArgument(((JvmGenericType)reference.getType()).getTypeParameters().get(0));
		assertTrue(EcoreUtil.equals(((JvmParameterizedTypeReference)reference).getArguments().get(0), argument));
	}
	
	public void testNotRecursive() throws Exception {
		JvmTypeReference reference = typeRefs.typeReference("java.util.List").wildCardExtends("java.lang.CharSequence").create();
		
		JvmGenericType collType = (JvmGenericType) typeProvider.findTypeByName(Collection.class.getCanonicalName());
		JvmTypeReference collArgument = typeArgCtxProvider.get(reference).getBoundArgument(collType.getTypeParameters().get(0));
		
		JvmGenericType listType = (JvmGenericType) typeProvider.findTypeByName(List.class.getCanonicalName());
		JvmTypeReference listArgument = ((JvmParameterizedTypeReference)listType.getSuperTypes().get(0)).getArguments().get(0);
		
		assertTrue(EcoreUtil.equals(listArgument, collArgument));
	}
	
	public void testResolve_0() throws Exception {
		JvmTypeReference reference = typeRefs.typeReference("java.util.ArrayList").wildCardExtends("java.lang.CharSequence").create();
		TypeArgumentContext context = typeArgCtxProvider.get(reference);
		JvmOperation jvmOperation = findOperation("java.util.List", "add(E)");
		
		assertEquals("? extends java.lang.CharSequence",context.resolve(jvmOperation.getParameters().get(0).getParameterType()).getCanonicalName());
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("? extends java.lang.CharSequence",context.resolve(get.getReturnType()).getCanonicalName());
	}
	
	public void testResolve_WithUnResolved() throws Exception {
		JvmTypeReference reference = typeRefs.typeReference("java.util.ArrayList").create();
		TypeArgumentContext context = typeArgCtxProvider.get(reference);
		JvmOperation jvmOperation = findOperation("java.util.List", "add(E)");
		
		JvmTypeParameter parameter = ((JvmGenericType)reference.getType()).getTypeParameters().get(0);
		
		assertSame(parameter,context.resolve(jvmOperation.getParameters().get(0).getParameterType()).getType());
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals(parameter,context.resolve(get.getReturnType()).getType());
	}
	
	public void testResolveDeeplyNested() throws Exception {
		JvmTypeReference reference = typeRefs
			.typeReference("java.util.ArrayList")
				.wildCardExtends("java.util.Map")
					.wildCardSuper("java.lang.String").x()
					.wildCardExtends("java.lang.Number").x()
				.create();
		TypeArgumentContext context = typeArgCtxProvider.get(reference);
		
		JvmOperation get = findOperation("java.util.List", "get(int)");
		assertEquals("? extends java.util.Map<? super java.lang.String,? extends java.lang.Number>",context.resolve(get.getReturnType()).getCanonicalName());
	}
	
	protected JvmOperation findOperation(String typeName, String methodSignature) {
		JvmType type = typeProvider.findTypeByName(typeName);
		return (JvmOperation) type.eResource().getEObject(typeName+"."+methodSignature);
	}

}
