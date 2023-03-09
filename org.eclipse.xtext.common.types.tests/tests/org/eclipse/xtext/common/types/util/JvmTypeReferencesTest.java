/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.access.impl.ClasspathTypeProvider;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JvmTypeReferencesTest extends Assert {

	private ClasspathTypeProvider typeProvider;

	@Before
	public void setUp() throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource syntheticResource = new XMLResourceImpl(URI.createURI("http://synthetic.resource"));
		resourceSet.getResources().add(syntheticResource);
		typeProvider = new ClasspathTypeProvider(getClass().getClassLoader(), resourceSet, null, null);
	}
	
	@After
	public void tearDown() throws Exception {
		typeProvider = null;
	}
	
	protected ClasspathTypeProvider getTypeProvider() {
		return typeProvider;
	}
	
	protected JvmTypeReferences jvmTypes() {
		return new JvmTypeReferences(TypesFactory.eINSTANCE, getTypeProvider());
	}
	
	@Test public void testReferenceConstruction() throws Exception {
		assertEquals("java.util.List<? extends java.lang.CharSequence>",
				jvmTypes().typeReference("java.util.List")
						  .wildCardExtends("java.lang.CharSequence").create().getIdentifier());
	}
	
	@Test public void testReferenceConstruction_1() throws Exception {
		assertEquals("java.util.Map<? super java.lang.String, ? extends java.util.List<java.lang.Object>>",
				jvmTypes().typeReference("java.util.Map")
						.wildCardSuper("java.lang.String").x()
						.wildCardExtends("java.util.List").arg("java.lang.Object").create().getIdentifier());
	}
	
	@Test public void testReferenceConstruction_2() throws Exception {
		assertEquals("java.util.List",jvmTypes().typeReference("java.util.List").create().getIdentifier());
	}

}
