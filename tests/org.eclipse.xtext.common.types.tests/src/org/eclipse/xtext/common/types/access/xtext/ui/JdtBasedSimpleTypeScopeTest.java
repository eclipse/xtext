/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.xtext.ui;

import java.util.List;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.eclipse.xtext.common.types.access.xtext.AbstractTypeScopeTest;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JdtBasedSimpleTypeScopeTest extends AbstractTypeScopeTest {

	private MockJavaProjectProvider projectProvider;
	private JdtTypeProviderFactory factory;
	private ResourceSet resourceSet;
	private JdtBasedSimpleTypeScope typeScope;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		projectProvider = new MockJavaProjectProvider();
		factory = new JdtTypeProviderFactory(projectProvider);
		resourceSet = new ResourceSetImpl();
		typeScope = new JdtBasedSimpleTypeScope(factory.createTypeProvider(resourceSet));
	}
	
	public void testGetContents_01() {
		Iterable<IScopedElement> contents = typeScope.getContents();
		assertTrue(Iterables.any(contents, new Predicate<IScopedElement>() {
			public boolean apply(IScopedElement input) {
				return List.class.getName().equals(input.name());
			}
		}));
	}
	
	public void testGetContents_02() {
		Iterable<IScopedElement> contents = typeScope.getContents();
		assertTrue(Iterables.any(contents, new Predicate<IScopedElement>() {
			public boolean apply(IScopedElement input) {
				return "int".equals(input.name());
			}
		}));
	}

	@Override
	protected IScope getTypeScope() {
		return typeScope;
	}
}
