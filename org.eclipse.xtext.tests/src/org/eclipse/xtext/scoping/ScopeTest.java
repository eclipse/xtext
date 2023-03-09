/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.impl.AbstractScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill - Contribution to Bug 309764
 */
public class ScopeTest extends Assert {

	private AbstractScope scope;

	@Before
	public void setUp() throws Exception {
		scope = getEcoreClassifiersScope();
	}

	@Test public void testContentByEObject_existent() throws Exception {
		assertNotNull(scope.getSingleElement(EcorePackage.eINSTANCE.getEAnnotation()));
	}

	@Test public void testContentByEObject_nonExistent() throws Exception {
		assertNull(scope.getSingleElement(EcorePackage.eINSTANCE.getEAnnotation_Contents()));
	}

	@Test public void testContentByEObject_withProxy() throws Exception {
		EClass eClass = EcoreFactory.eINSTANCE.createEClass();
		((InternalEObject) eClass).eSetProxyURI(EcoreUtil.getURI(EcorePackage.eINSTANCE.getEAnnotation()));
		assertNotNull(scope.getSingleElement(eClass));
	}

	@Test public void testContentByName_existent() throws Exception {
		QualifiedName qualifiedName = QualifiedName.create(EcorePackage.eINSTANCE.getEAnnotation().getName());
		assertEquals(qualifiedName, scope.getSingleElement(qualifiedName).getName());
	}

	@Test public void testContentByName_nonExistent() throws Exception {
		assertNull(scope.getSingleElement(QualifiedName.create("unknown_name")));
	}

	private AbstractScope getEcoreClassifiersScope() {
		return new SimpleScope(getEcoreClassesScope(),Scopes.scopedElementsFor(Iterables.filter(EcorePackage.eINSTANCE.getEClassifiers(),
						EDataType.class)));
	}

	private AbstractScope getEcoreClassesScope() {
		return new SimpleScope(IScope.NULLSCOPE,Scopes.scopedElementsFor(Iterables
						.filter(EcorePackage.eINSTANCE.getEClassifiers(), EClass.class)));
	}

}
