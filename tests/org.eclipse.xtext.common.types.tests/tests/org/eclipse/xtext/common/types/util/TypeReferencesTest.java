/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.io.Serializable;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.tests.ClasspathBasedModule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class TypeReferencesTest extends Assert {

    private IJvmTypeProvider typeProvider;
    @Inject
    private TypeReferences typeRefs;

    @Before
    public void setUp() throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        Resource syntheticResource = new XMLResourceImpl(URI.createURI("http://synthetic.resource"));
        resourceSet.getResources().add(syntheticResource);
        Injector injector = Guice.createInjector(new ClasspathBasedModule());
        injector.injectMembers(this);
        typeProvider = injector.getInstance(IJvmTypeProvider.Factory.class).findOrCreateTypeProvider(resourceSet);
    }
	
	@Test public void testIsEqualOrSubtypeOf_00() throws Exception {
		JvmType objectType = typeProvider.findTypeByName(Object.class.getName());
		JvmTypeReference reference = typeRefs.createTypeRef(objectType);
		assertTrue(typeRefs.isInstanceOf(reference, Object.class));
		assertFalse(typeRefs.isInstanceOf(reference, List.class));
	}
	
	@Test public void testIsEqualOrSubtypeOf_01() throws Exception {
		JvmType objectType = typeProvider.findTypeByName(String.class.getName());
		JvmTypeReference reference = typeRefs.createTypeRef(objectType);
		assertTrue(typeRefs.isInstanceOf(reference, Object.class));
		assertTrue(typeRefs.isInstanceOf(reference, Comparable.class));
		assertTrue(typeRefs.isInstanceOf(reference, Serializable.class));
		
		assertTrue(typeRefs.isInstanceOf(reference, String.class));
		
		assertFalse(typeRefs.isInstanceOf(reference, List.class));
	}
}
