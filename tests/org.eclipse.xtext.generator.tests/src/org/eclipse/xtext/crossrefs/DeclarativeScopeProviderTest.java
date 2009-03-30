/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.crossrefs;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.impl.DeclarativeScopeProvider;
import org.eclipse.xtext.crossref.impl.SimpleNestedScope;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class DeclarativeScopeProviderTest extends TestCase {
	@SuppressWarnings("unused")
	public void testSimple() throws Exception {
		final IScope a =  new SimpleNestedScope(IScope.NULLSCOPE);
		DeclarativeScopeProvider provider = new DeclarativeScopeProvider() {
			private IScope scope_EClass(EClass clazz, EReference ref) {
				return a;
			}
		};
		
		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(a,provider.getScope(details, details));
	}
	
	@SuppressWarnings("unused")
	public void testNested() throws Exception {
		final IScope a =  new SimpleNestedScope(IScope.NULLSCOPE);
		final IScope b =  new SimpleNestedScope(IScope.NULLSCOPE);
		
		DeclarativeScopeProvider provider = new DeclarativeScopeProvider() {
			private IScope scope_EClass(EClass clazz, EReference ref) {
				return a;
			}
			private IScope scope_EClass(EReference ctx, EReference ref) {
				return b;
			}
		};
		
		EReference details = EcorePackage.eINSTANCE.getEClass_ESuperTypes();
		assertEquals(b,provider.getScope(details, details));
		assertEquals(a,provider.getScope(details.getEContainingClass(), details));
	}
	
	@SuppressWarnings("unused")
	public void testPolymorphic() throws Exception {
		final IScope a =  new SimpleNestedScope(IScope.NULLSCOPE);
		final IScope b =  new SimpleNestedScope(IScope.NULLSCOPE);
		final IScope c =  new SimpleNestedScope(IScope.NULLSCOPE);
		
		DeclarativeScopeProvider provider = new DeclarativeScopeProvider() {
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
		assertEquals(b,provider.getScope(details, details));
		assertEquals(c,provider.getScope(details.getEContainingClass(), details));
	}
}
