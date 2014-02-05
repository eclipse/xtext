/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/eplv10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import java.util.HashSet;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.testSetups.Concrete;
import org.eclipse.xtext.common.types.testSetups.GenericSuperClass;
import org.eclipse.xtext.common.types.testSetups.SubClass;
import org.eclipse.xtext.common.types.testSetups.SubOfGenericClass;
import org.eclipse.xtext.common.types.testSetups.SuperClass;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * @author Sven Efftinge  Initial contribution and API
 */
@SuppressWarnings("deprecation")
public abstract class AbstractFeatureOverridesServiceTest extends Assert {
    
    private IJvmTypeProvider typeProvider;
    private JvmTypeReferences typeRefs;
	@Inject
    private FeatureOverridesService service;
	
	@BeforeClass public static void createMockJavaProject() throws Exception {
		MockJavaProjectProvider.setUp();
	}

	@Before
    public void setUp() throws Exception {
        ResourceSet resourceSet = new ResourceSetImpl();
        Injector injector = Guice.createInjector(getModule());
        injector.injectMembers(this);
        typeProvider = injector.getInstance(IJvmTypeProvider.Factory.class).findOrCreateTypeProvider(resourceSet);
        typeRefs = new JvmTypeReferences(injector.getInstance(TypesFactory.class), typeProvider);
    }

	protected abstract Module getModule();
    
    @After
    public void tearDown() throws Exception {
        typeProvider = null;
        typeRefs = null;
        service = null;
    }
    
    @Test public void testSimple() throws Exception {
        JvmTypeReference reference = typeRefs.typeReference(Concrete.class.getName()).wildCardExtends("java.lang.CharSequence").create();
        Iterable<JvmFeature> iterable = service.getAllJvmFeatures(reference);
        HashSet<JvmFeature> set = Sets.newHashSet(iterable);
        
        assertFalse(set.contains(findOperation("org.eclipse.xtext.common.types.testSetups.Interface", "overriddenByAll(T)")));
        assertFalse(set.contains(findOperation("org.eclipse.xtext.common.types.testSetups.Abstract", "overriddenByAll(T)")));
        assertTrue(set.contains(findOperation("org.eclipse.xtext.common.types.testSetups.Concrete", "overriddenByAll(T)")));
        assertFalse(set.contains(findOperation("org.eclipse.xtext.common.types.testSetups.Interface", "inherited()")));
        assertTrue(set.contains(findOperation("org.eclipse.xtext.common.types.testSetups.Abstract", "inherited()")));
    }
    
    @Test public void testContainsFields() throws Exception {
        JvmTypeReference reference = typeRefs.typeReference(SubClass.class.getName()).create();
        Iterable<JvmFeature> iterable = service.getAllJvmFeatures(reference);
        HashSet<JvmFeature> set = Sets.newHashSet(iterable);
        
        assertTrue(set.contains(findOperation(SubClass.class.getName(),"privateField")));
        assertTrue(set.contains(findOperation(SubClass.class.getName(),"protectedField")));
        assertTrue(set.contains(findOperation(SubClass.class.getName(),"publicField")));
        
        // #privateField is public and static in the super class
        assertTrue(set.contains(findOperation(SuperClass.class.getName(),"privateField")));
        assertFalse(set.contains(findOperation(SuperClass.class.getName(),"protectedField")));
        assertFalse(set.contains(findOperation(SuperClass.class.getName(),"publicField")));
        
        assertTrue(set.contains(findOperation(SubClass.class.getName(),"publicMethod()")));
        assertFalse(set.contains(findOperation(SuperClass.class.getName(),"publicMethod()")));
        assertFalse(set.contains(findOperation(SubClass.class.getName(),"protectedMethod()")));
        assertTrue(set.contains(findOperation(SuperClass.class.getName(),"protectedMethod()")));
        assertFalse(set.contains(findOperation(SuperClass.class.getName(),"privateMethod(java.lang.Object)")));
        assertFalse(set.contains(findOperation(SuperClass.class.getName(),"privateMethod(java.lang.String)")));
        assertTrue(set.contains(findOperation(SubClass.class.getName(),"privateMethod(java.lang.Object)")));
        assertTrue(set.contains(findOperation(SubClass.class.getName(),"privateMethod(java.lang.String)")));
    }
    
    @Test public void testPrivateFieldShadowsInheritedPublicField() throws Exception {
        JvmTypeReference reference = typeRefs.typeReference(SubClass.class.getName()).create();
        Iterable<JvmFeature> iterable = service.getAllJvmFeatures(reference);
        HashSet<JvmFeature> set = Sets.newHashSet(iterable);
        
        assertTrue(set.contains(findOperation(SubClass.class.getName(),"shadowedByPrivateField")));
        assertFalse(set.contains(findOperation(SuperClass.class.getName(),"shadowedByPrivateField")));
    }
    
    @Test public void testGenerics_00() throws Exception {
        JvmTypeReference reference = typeRefs.typeReference(SubOfGenericClass.class.getName()).arg(String.class.getName()).create();
        Iterable<JvmFeature> iterable = service.getAllJvmFeatures(reference);
        HashSet<JvmFeature> set = Sets.newHashSet(iterable);
        
        assertTrue(set.contains(findOperation(SubOfGenericClass.class.getName(),"myMethod(java.lang.String)")));
        assertFalse(set.contains(findOperation(GenericSuperClass.class.getName(),"myMethod(java.lang.String)")));
        assertFalse(set.contains(findOperation(GenericSuperClass.class.getName(),"myMethod(T)")));
    }
    
    @Test public void testGenerics_01() throws Exception {
        JvmTypeReference reference = typeRefs.typeReference(SubOfGenericClass.class.getName()).arg(Object.class.getName()).create();
        Iterable<JvmFeature> iterable = service.getAllJvmFeatures(reference);
        HashSet<JvmFeature> set = Sets.newHashSet(iterable);
        
        assertTrue(set.contains(findOperation(SubOfGenericClass.class.getName(),"myMethod(java.lang.String)")));
        assertFalse(set.contains(findOperation(GenericSuperClass.class.getName(),"myMethod(java.lang.String)")));
        assertTrue(set.contains(findOperation(GenericSuperClass.class.getName(),"myMethod(T)")));
    }
    
    protected JvmFeature findOperation(String typeName, String methodSignature) {
        JvmType type = typeProvider.findTypeByName(typeName);
        return (JvmFeature) type.eResource().getEObject(typeName+"."+methodSignature);
    }

    
}