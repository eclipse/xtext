/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.HashSet;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.util.TypeArgumentContext.Provider;

import com.google.common.collect.Sets;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MethodOverrideServiceTest extends TestCase {
	
	private ClasspathTypeProvider typeProvider;
	private JvmTypeReferences typeRefs;
	private MethodOverrideService service;
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
		service = new MethodOverrideService(new SuperTypeCollector(TypesFactory.eINSTANCE));
	}
	
	@Override
	protected void tearDown() throws Exception {
		typeProvider = null;
		typeRefs = null;
		super.tearDown();
	}
	
	public void testSimple() throws Exception {
		JvmTypeReference reference = typeRefs.typeReference("java.util.ArrayList").wildCardExtends("java.lang.CharSequence").create();
		TypeArgumentContext context = typeArgCtxProvider.get(reference);
		Iterable<JvmOperation> iterable = service.getAllMethods((JvmDeclaredType) reference.getType(), context);
		HashSet<JvmOperation> set = Sets.newHashSet(iterable);
		
		assertFalse(set.contains(findOperation("java.util.AbstractList","add(int,E)")));
		assertFalse(set.contains(findOperation("java.util.List","add(int,E)")));
		assertTrue(set.contains(findOperation("java.util.ArrayList","add(int,E)")));
		assertTrue(set.contains(findOperation("java.util.AbstractList","iterator()")));
		assertFalse(set.contains(findOperation("java.util.List","iterator()")));
	}
	
	protected JvmOperation findOperation(String typeName, String methodSignature) {
		JvmType type = typeProvider.findTypeByName(typeName);
		return (JvmOperation) type.eResource().getEObject(typeName+"."+methodSignature);
	}

	
}
