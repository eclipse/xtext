/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static java.util.Collections.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ScopeTest extends Assert {

	@Test public void testShadowing() throws Exception {
		IEObjectDescription a = EObjectDescription.create(QualifiedName.create("foo"),
				EcorePackage.Literals.EANNOTATION);
		IEObjectDescription b = EObjectDescription
				.create(QualifiedName.create("foo"), EcorePackage.Literals.EATTRIBUTE);
		IEObjectDescription c = EObjectDescription.create(QualifiedName.create("foo"), EcorePackage.Literals.EBYTE);
		SimpleScope outer = new SimpleScope(singleton(a), false);
		SimpleScope middle = new SimpleScope(outer, singleton(b));
		SimpleScope inner = new SimpleScope(middle, singleton(c));
		assertNull(inner.getSingleElement(EcorePackage.Literals.EANNOTATION));
	}

	@Test public void testLaziness() throws Exception {
		LazinessTestScope c = new LazinessTestScope("c");
		LazinessTestScope b = new LazinessTestScope("b", c);
		LazinessTestScope a = new LazinessTestScope("a", b);
		assertEquals(0, a.numberOfCalls);
		assertEquals(0, b.numberOfCalls);
		assertEquals(0, c.numberOfCalls);
		Iterable<IEObjectDescription> elements = a.getAllElements();
		Iterator<IEObjectDescription> iterator = elements.iterator();
		assertEquals(0, a.numberOfCalls);
		assertEquals(0, b.numberOfCalls);
		assertEquals(0, c.numberOfCalls);
		iterator.next();
		assertEquals(1, a.numberOfCalls);
		assertEquals(0, b.numberOfCalls);
		assertEquals(0, c.numberOfCalls);
		iterator.next();
		assertEquals(2, a.numberOfCalls);
		assertEquals(1, b.numberOfCalls);
		assertEquals(0, c.numberOfCalls);
		iterator.next();
		assertEquals(3, a.numberOfCalls);
		assertEquals(2, b.numberOfCalls);
		assertEquals(1, c.numberOfCalls);
		assertFalse(iterator.hasNext());
	}

	static class LazinessTestScope extends AbstractScope {

		private String name;

		public LazinessTestScope(String name) {
			this(name, IScope.NULLSCOPE);
		}

		public LazinessTestScope(String name, IScope parent) {
			super(parent, false);
			this.name = name;
		}

		int numberOfCalls = 0;

		@Override
		protected Iterable<IEObjectDescription> getAllLocalElements() {
			return new Iterable<IEObjectDescription>() {
				@Override
				public Iterator<IEObjectDescription> iterator() {
					numberOfCalls++;
					return singleton(
							(IEObjectDescription) new EObjectDescription(QualifiedName.create(name),
									EcorePackage.Literals.EATTRIBUTE, null)).iterator();
				}

				@Override
				public String toString() {
					try {
						return Iterables.toString(this);
					} finally {
						numberOfCalls--;
					}
				}
			};
		}
	}
}
