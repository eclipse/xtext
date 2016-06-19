/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collections;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class DeclarativeScopeProviderTest extends AbstractXtextTests {
	@SuppressWarnings("unused")
	@Test public void testSimple() throws Exception {
		final IScope a = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		AbstractDeclarativeScopeProvider provider = new AbstractDeclarativeScopeProvider() {
			private IScope scope_EClass(EClass clazz, EReference ref) {
				return a;
			}
		};

		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(a, provider.getScope(details, details));
	}

	@SuppressWarnings("unused")
	@Test public void testNested() throws Exception {
		final IScope a = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope b = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());

		AbstractDeclarativeScopeProvider provider = new AbstractDeclarativeScopeProvider() {
			private IScope scope_EClass(EClass clazz, EReference ref) {
				return a;
			}

			private IScope scope_EClass(EReference ctx, EReference ref) {
				return b;
			}
		};

		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(b, provider.getScope(details, details));
		assertEquals(a, provider.getScope(details.getEContainingClass(), details));
	}

	@SuppressWarnings("unused")
	@Test public void testPolymorphic() throws Exception {
		final IScope a = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope b = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope c = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());

		AbstractDeclarativeScopeProvider provider = new AbstractDeclarativeScopeProvider() {
			private IScope scope_EClass(EClassifier clazz, EReference ref) {
				return a;
			}

			private IScope scope_EClass(EClass clazz, EReference ref) {
				return c;
			}

			private IScope scope_EClass(EReference ctx, EReference ref) {
				return b;
			}
		};

		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(b, provider.getScope(details, details));
		assertEquals(c, provider.getScope(details.getEContainingClass(), details));
	}

	@SuppressWarnings("unused")
	@Test public void testScopeByType() throws Exception {
		final IScope a = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope b = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope c = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		AbstractDeclarativeScopeProvider provider = new AbstractDeclarativeScopeProvider() {

			private IScope scope_EClass(EClassifier clazz, EReference ref) {
				return a;
			}

			private IScope scope_EClass(EClass clazz, EReference ref) {
				return b;
			}

			private IScope scope_EClass(EReference ctx, EReference ref) {
				return c;
			}
		};
		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(a, provider.getScope(EcorePackage.eINSTANCE.getEShort(), details));
		assertEquals(b, provider.getScope(details.getEContainingClass(), details));
		assertEquals(c, provider.getScope(details, details));
	}

	@SuppressWarnings("unused")
	@Test public void testScopeByReference() throws Exception {
		final IScope a = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope b = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope c = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		AbstractDeclarativeScopeProvider provider = new AbstractDeclarativeScopeProvider() {
			private IScope scope_EClass_eSuperTypes(EClassifier clazz, EReference ref) {
				return a;
			}

			private IScope scope_EClass(EClass clazz, EReference ref) {
				return c;
			}

			private IScope scope_EClass(EReference ctx, EReference ref) {
				return b;
			}
		};

		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(a, provider.getScope(details, details));
		assertEquals(a, provider.getScope(details.getEContainingClass(), details));
	}

	@SuppressWarnings("unused")
	@Test public void testScopeByType2() throws Exception {
		final IScope a = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope b = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope c = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		AbstractDeclarativeScopeProvider provider = new AbstractDeclarativeScopeProvider() {
			private IScope scope_EClass(EClassifier clazz, EReference ref) {
				return a;
			}

			private IScope scope_EClass(EClass clazz, EReference ref) {
				return c;
			}

			private IScope scope_EClass(EReference ctx, EReference ref) {
				return b;
			}
		};

		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(b, provider.getScope(details, details));
		assertEquals(c, provider.getScope(details.getEContainingClass(), details));
	}

	@SuppressWarnings("unused")
	@Test public void testScopeByReference2() throws Exception {
		final IScope a = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope b = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		final IScope c = new SimpleScope(IScope.NULLSCOPE, Collections.<IEObjectDescription> emptySet());
		AbstractDeclarativeScopeProvider provider = new AbstractDeclarativeScopeProvider() {
			private IScope scope_EClass_eSuperTypes(EClassifier clazz, EReference ref) {
				return a;
			}

			private IScope scope_EClass_eSuperTypes(EClass clazz, EReference ref) {
				return b;
			}

			private IScope scope_EClass_eSuperTypes(EReference ctx, EReference ref) {
				return c;
			}
		};

		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(a, provider.getScope(EcorePackage.eINSTANCE.getEShort(), details));
		assertEquals(b, provider.getScope(details.getEContainingClass(), details));
		assertEquals(c, provider.getScope(details, details));
	}
}
