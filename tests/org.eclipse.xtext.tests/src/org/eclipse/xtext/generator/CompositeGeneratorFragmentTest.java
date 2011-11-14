/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.Set;

import junit.framework.TestCase;

import org.eclipse.xtext.Grammar;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeGeneratorFragmentTest extends TestCase {
	
	public void testFinalBindingsPersist() throws Exception {
		CompositeGeneratorFragment fragment = new CompositeGeneratorFragment();
		fragment.addFragment(new DefaultGeneratorFragment() {
				@Override
				public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
					BindFactory bindFactory = new BindFactory();
					bindFactory
						.addfinalTypeToType("FOO", 
								"BAR");
					return bindFactory.getBindings();
				}
		});
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory
				.addTypeToType("FOO", 
						"FOO");
				return bindFactory.getBindings();
			}
		});
		Set<Binding> bindings = fragment.getGuiceBindingsRt(null);
		assertEquals(1, bindings.size());
		assertEquals("BAR", bindings.iterator().next().getValue().getTypeName());
	}
	
	public void testNonFinalBindingsOverride() throws Exception {
		CompositeGeneratorFragment fragment = new CompositeGeneratorFragment();
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory
				.addTypeToType("FOO", 
						"BAR");
				return bindFactory.getBindings();
			}
		});
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory
				.addTypeToType("FOO", 
						"FOO");
				return bindFactory.getBindings();
			}
		});
		Set<Binding> bindings = fragment.getGuiceBindingsRt(null);
		assertEquals(1, bindings.size());
		assertEquals("FOO", bindings.iterator().next().getValue().getTypeName());
	}
	
	public void testFinalBindingsConflict() throws Exception {
		CompositeGeneratorFragment fragment = new CompositeGeneratorFragment();
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory
				.addfinalTypeToType("FOO", 
						"BAR");
				return bindFactory.getBindings();
			}
		});
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory
				.addfinalTypeToType("FOO", 
						"FOO");
				return bindFactory.getBindings();
			}
		});
		try {
			fragment.getGuiceBindingsRt(null);
			fail("exception expected");
		} catch (IllegalStateException e) {
			System.out.println(e);
			// expected
		}
	}
}
