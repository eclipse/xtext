/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.AbstractTypeProviderFactory;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.MockJavaProjectProvider;
import org.junit.After;
import org.junit.Before;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class JdtSuperTypeCollectorTest extends AbstractSuperTypeCollectorTest {

	private ResourceSet resourceSet;
	private JdtTypeProvider typeProvider;
	private MockJavaProjectProvider projectProvider;
	private Provider<SuperTypeCollector> collectorProvider;

	@Before
	public void setUp() throws Exception {
		resourceSet = new ResourceSetImpl();
		projectProvider = new MockJavaProjectProvider();
		typeProvider = new JdtTypeProvider(projectProvider.getJavaProject(resourceSet), resourceSet);
		Injector injector = Guice.createInjector(new AbstractModule() {
			@Override
			protected void configure() {
				bind(IJvmTypeProvider.Factory.class).toInstance(new AbstractTypeProviderFactory() {
					public IJvmTypeProvider createTypeProvider(ResourceSet resourceSet) {
						return typeProvider;
					}
				});
				bind(TypesFactory.class).toInstance(TypesFactory.eINSTANCE);
			}
		});
		collectorProvider = injector.getProvider(SuperTypeCollector.class);
	}
	
	@After
	public void tearDown() throws Exception {
		resourceSet = null;
		typeProvider = null;
	}
	
	@Override
	protected JdtTypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	@Override
	protected SuperTypeCollector getCollector() {
		return collectorProvider.get();
	}
}
