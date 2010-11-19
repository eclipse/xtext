/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static java.util.Collections.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import junit.framework.TestCase;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AbstractScopeTest extends TestCase {

	public void testLaziness() throws Exception {
		LazinessTestScope c = new LazinessTestScope("c");
		LazinessTestScope b = new LazinessTestScope("b",c);
		LazinessTestScope a = new LazinessTestScope("a",b);
		assertEquals(0,a.numberOfCalls);
		assertEquals(0,b.numberOfCalls);
		assertEquals(0,c.numberOfCalls);
		Iterable<IEObjectDescription> elements = a.getElements(ISelector.SELECT_ALL);
		Iterator<IEObjectDescription> iterator = elements.iterator();
		assertEquals(0,a.numberOfCalls);
		assertEquals(0,b.numberOfCalls);
		assertEquals(0,c.numberOfCalls);
		iterator.next();
		assertEquals(1,a.numberOfCalls);
		assertEquals(0,b.numberOfCalls);
		assertEquals(0,c.numberOfCalls);
		iterator.next();
		assertEquals(1,a.numberOfCalls);
		assertEquals(1,b.numberOfCalls);
		assertEquals(0,c.numberOfCalls);
		iterator.next();
		assertEquals(1,a.numberOfCalls);
		assertEquals(1,b.numberOfCalls);
		assertEquals(1,c.numberOfCalls);
		assertFalse(iterator.hasNext());
	}
	
	static class LazinessTestScope extends AbstractScope {
		
		private String name;

		public LazinessTestScope(String name) {
			this(name,IScope.NULLSCOPE);
		}
		
		public LazinessTestScope(String name,IScope parent) {
			super(parent);
			this.name = name;
		}
		
		int numberOfCalls = 0;

		@Override
		public Iterable<IEObjectDescription> getLocalElements(final ISelector selector) {
			return new Iterable<IEObjectDescription>() {
				public Iterator<IEObjectDescription> iterator() {
					numberOfCalls++;
					return singleton((IEObjectDescription)new EObjectDescription(QualifiedName.create(name), EcorePackage.Literals.EATTRIBUTE, null, false)).iterator();
				}
			};
		}
		
	}
}


