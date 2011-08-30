/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static com.google.common.collect.Iterables.*;
import junit.framework.TestCase;

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

import com.google.common.base.Predicate;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmVisibilityServiceTest extends TestCase {
	private ClasspathTypeProvider typesProvider = new ClasspathTypeProviderFactory(getClass().getClassLoader())
			.createTypeProvider();
	private TypesFactory typesFactory = TypesFactory.eINSTANCE;
	private JvmDeclaredType superRef;
	private JvmDeclaredType subRef;
	private JvmField privateField;
	private JvmField protectedField;
	private JvmField publicField;
	private VisibilityService provider;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		superRef = (JvmDeclaredType) getTypeRef(VisibilitySuperClass.class.getCanonicalName()).getType();
		subRef = (JvmDeclaredType) getTypeRef(VisibilitySubClass.class.getCanonicalName()).getType();

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

		provider = new VisibilityService();
		provider.setSuperTypeCollector(new SuperTypeCollector(TypesFactory.eINSTANCE));
		provider.setTypesFactory(TypesFactory.eINSTANCE);
	}

	public void testNoContext() throws Exception {
		assertFalse(provider.isVisible(privateField, null));
		assertFalse(provider.isVisible(protectedField, null));
		assertTrue(provider.isVisible(publicField, null));
	}

	public void testSubClassContext() throws Exception {
		assertFalse(provider.isVisible(privateField, subRef));
		assertTrue(provider.isVisible(protectedField, subRef));
		assertTrue(provider.isVisible(publicField, subRef));
	}

	public void testDirectContext() throws Exception {
		assertTrue(provider.isVisible(privateField, superRef));
		assertTrue(provider.isVisible(protectedField, superRef));
		assertTrue(provider.isVisible(publicField, superRef));
	}

	protected JvmTypeReference getTypeRef(String name) {
		JvmType type = typesProvider.findTypeByName(name);
		JvmParameterizedTypeReference reference = typesFactory.createJvmParameterizedTypeReference();
		reference.setType(type);
		return reference;
	}
}
