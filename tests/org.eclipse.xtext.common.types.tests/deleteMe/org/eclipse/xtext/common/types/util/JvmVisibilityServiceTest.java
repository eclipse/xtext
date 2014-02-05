/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Iterables.*;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.eclipse.xtext.common.types.visibility.VisibilitySubClass;
import org.eclipse.xtext.common.types.visibility.VisibilitySuperClass;
import org.eclipse.xtext.common.types.visibility.sub.VisibilitySubClassOtherPackage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class JvmVisibilityServiceTest extends Assert {
	private ClasspathTypeProvider typesProvider = new ClasspathTypeProviderFactory(getClass().getClassLoader())
			.createTypeProvider();
	private TypesFactory typesFactory = TypesFactory.eINSTANCE;
	private JvmDeclaredType superRef;
	private JvmDeclaredType subRef;
	private JvmDeclaredType subRefOtherPackage;
	private JvmField privateField;
	private JvmField protectedField;
	private JvmField publicField;
	private JvmField packagePrivateField;
	private VisibilityService provider;

	@Before
	public void setUp() throws Exception {
		superRef = (JvmDeclaredType) getTypeRef(VisibilitySuperClass.class.getCanonicalName()).getType();
		subRef = (JvmDeclaredType) getTypeRef(VisibilitySubClass.class.getCanonicalName()).getType();
		subRefOtherPackage = (JvmDeclaredType) getTypeRef(VisibilitySubClassOtherPackage.class.getCanonicalName()).getType();

		Iterable<JvmField> fields = superRef.getDeclaredFields();
		privateField = find(fields, new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return input.getSimpleName().equals("privateField");
			}
		});
		protectedField = find(fields, new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return input.getSimpleName().equals("protectedField");
			}
		});
		publicField = find(fields, new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return input.getSimpleName().equals("publicField");
			}
		});

		packagePrivateField = find(fields, new Predicate<JvmField>() {
			public boolean apply(JvmField input) {
				return input.getSimpleName().equals("packagePrivateField");
			}
		});

		provider = createVisibilityService();
		provider.setSuperTypeCollector(new SuperTypeCollector());
		provider.setTypesFactory(TypesFactory.eINSTANCE);
	}

	protected VisibilityService createVisibilityService() {
		return new VisibilityService();
	}
	
	@Test public void testSetup() {
		assertNotNull(superRef);
		assertNotNull(subRef);
		assertNotNull(subRefOtherPackage);
		assertNotNull(privateField);
		assertNotNull(protectedField);
		assertNotNull(publicField);
		assertNotNull(packagePrivateField);
	}
	
	@Test public void testNoContext() throws Exception {
		assertFalse(provider.isVisible(privateField, null));
		assertFalse(provider.isVisible(protectedField, null));
		assertTrue(provider.isVisible(publicField, null));
		assertFalse(provider.isVisible(packagePrivateField, null));
	}

	@Test public void testSubClassContext() throws Exception {
		assertFalse(provider.isVisible(privateField, subRef));
		assertTrue(provider.isVisible(protectedField, subRef));
		assertTrue(provider.isVisible(publicField, subRef));
		assertTrue(provider.isVisible(packagePrivateField, subRef));
	}

	@Test public void testSubClassContextOtherPackage() throws Exception {
		assertFalse(provider.isVisible(privateField, subRefOtherPackage));
		assertTrue(provider.isVisible(protectedField, subRefOtherPackage));
		assertTrue(provider.isVisible(publicField, subRefOtherPackage));
		assertFalse(provider.isVisible(packagePrivateField, subRefOtherPackage));
	}

	@Test public void testDirectContext() throws Exception {
		assertTrue(provider.isVisible(privateField, superRef));
		assertTrue(provider.isVisible(protectedField, superRef));
		assertTrue(provider.isVisible(publicField, superRef));
		assertTrue(provider.isVisible(packagePrivateField, superRef));
	}

	protected JvmTypeReference getTypeRef(String name) {
		JvmType type = typesProvider.findTypeByName(name);
		JvmParameterizedTypeReference reference = typesFactory.createJvmParameterizedTypeReference();
		reference.setType(type);
		return reference;
	}
}
