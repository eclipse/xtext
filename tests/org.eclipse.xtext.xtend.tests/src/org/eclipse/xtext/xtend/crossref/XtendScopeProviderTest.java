/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtend.crossref;

import java.util.Iterator;

import junit.framework.TestCase;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.internal.xtend.type.impl.java.JavaBeansMetaModel;
import org.eclipse.xtend.expression.ExecutionContext;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.crossref.IScope;
import org.eclipse.xtext.crossref.IScopedElement;
import org.eclipse.xtext.xtend.ExecutionContextAware;
import org.eclipse.xtext.xtend.scoping.XtendScopeProvider;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class XtendScopeProviderTest extends TestCase {
	
	private XtendScopeProvider scopeProvider;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		scopeProvider = new XtendScopeProvider(getClass().getName().replace(".","::"),null);
		scopeProvider.setExecutionContextAware(new ExecutionContextAware(new Provider<ExecutionContext>(){

			public ExecutionContext get() {
				ExecutionContextImpl impl = new ExecutionContextImpl();
				impl.registerMetaModel(new JavaBeansMetaModel());
				return impl;
			}
			
		}));
	}

	public void testSimple() throws Exception {
		
		EcorePackage p = EcorePackage.eINSTANCE;
		EReference reference = p.getEClass_EAllSuperTypes();
		IScope scope = scopeProvider.getScope(p, reference);
		Iterator<IScopedElement> iterator = scope.getAllContents().iterator();
		int i = 0;
		while(iterator.hasNext()) {
			i++;
			IScopedElement next = iterator.next();
			assertTrue(p.getEClassifiers().contains(next.element()));
			assertEquals(((EClass)next.element()).getName(),next.name());
		}
		assertEquals(i, EcoreUtil2.typeSelect(p.getEClassifiers(), EClass.class).size());
	}
	
	public void testSimple2() throws Exception {
		EcorePackage p = EcorePackage.eINSTANCE;
		EReference reference = p.getEClass_EAllSuperTypes();
		IScope scope = scopeProvider.getScope(reference, reference);
		Iterator<IScopedElement> iterator = scope.getAllContents().iterator();
		IScopedElement element = iterator.next();
		assertFalse(iterator.hasNext());
		assertEquals(reference.eContainer(),element.element());
	}
}
