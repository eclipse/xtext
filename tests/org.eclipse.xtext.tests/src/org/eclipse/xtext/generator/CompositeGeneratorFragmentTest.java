/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xpand2.XpandExecutionContext;
import org.eclipse.xtext.Grammar;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompositeGeneratorFragmentTest extends Assert {

	@Test
	public void testFinalBindingsPersist() throws Exception {
		CompositeGeneratorFragment fragment = new CompositeGeneratorFragment();
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory.addfinalTypeToType("FOO", "BAR");
				return bindFactory.getBindings();
			}
		});
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory.addTypeToType("FOO", "FOO");
				return bindFactory.getBindings();
			}
		});
		Set<Binding> bindings = fragment.getGuiceBindingsRt(null);
		assertEquals(1, bindings.size());
		assertEquals("BAR", bindings.iterator().next().getValue().getTypeName());
	}

	@Test
	public void testNonFinalBindingsOverride() throws Exception {
		CompositeGeneratorFragment fragment = new CompositeGeneratorFragment();
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory.addTypeToType("FOO", "BAR");
				return bindFactory.getBindings();
			}
		});
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory.addTypeToType("FOO", "FOO");
				return bindFactory.getBindings();
			}
		});
		Set<Binding> bindings = fragment.getGuiceBindingsRt(null);
		assertEquals(1, bindings.size());
		assertEquals("FOO", bindings.iterator().next().getValue().getTypeName());
	}

	@Test
	public void testFinalBindingsConflict() throws Exception {
		CompositeGeneratorFragment fragment = new CompositeGeneratorFragment();
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory.addfinalTypeToType("FOO", "BAR");
				return bindFactory.getBindings();
			}
		});
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public Set<Binding> getGuiceBindingsRt(Grammar grammar) {
				BindFactory bindFactory = new BindFactory();
				bindFactory.addfinalTypeToType("FOO", "FOO");
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

	@Test
	public void testCompositeGeneratorExceptionThrown() throws Exception {
		CompositeGeneratorFragment fragment = new CompositeGeneratorFragment();
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public void generate(Grammar grammar, XpandExecutionContext ctx) {
				throw new WrappedException(new FileNotFoundException("1"));
			}
		});
		fragment.addFragment(new DefaultGeneratorFragment() {
			@Override
			public void generate(Grammar grammar, XpandExecutionContext ctx) {
				throw new WrappedException(new FileNotFoundException("2"));
			}
		});

		try {
			fragment.generate(null, null);
			fail("CompositeGeneratorException was not thrown");
		} catch (CompositeGeneratorException e) {
			Iterable<Exception> exceptions = e.getExceptions();
			assertEquals("Two exceptions catched and re thrown", 2, Iterables.size(exceptions));

			for (Exception exception : exceptions) {
				if (exception instanceof WrappedException) {
					Exception cause = ((WrappedException) exception).exception();
					assertTrue("FNF Exception not thrown", cause instanceof FileNotFoundException);
				} else {
					fail("Not a WrappedException thrown");
				}
			}

			Iterator<Exception> iterator = exceptions.iterator();

			assertEquals("Wrong Exception order", "1", ((WrappedException) iterator.next()).exception().getMessage());
			assertEquals("Wrong Exception order", "2", ((WrappedException) iterator.next()).exception().getMessage());
		}

	}

}
