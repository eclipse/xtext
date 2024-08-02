/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.eclipse.xtend.core.tests.SingletonGeneratorConfigRuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.junit.Test

/**
 * Tests for <a href="https://github.com/eclipse/xtext-xtend/issues/484">https://github.com/eclipse/xtext-xtend/issues/484</a>
 * 
 * @author Michael Keppler - Initial contribution and API
 */
@InjectWith(SingletonGeneratorConfigRuntimeInjectorProvider)
class CompilerBugDispatchWithOverrideTest extends AbstractXtendCompilerTest {
	
	@Test def void testDispatchWithOverrideJava6HasAnnotation() {
		assertCompilesTo(
			'''
			class Something extends AbstractSomething {
				override dispatch void m(String x) {}
			}

			class AbstractSomething {
				protected def dispatch void m(String x) {}
				protected def dispatch void m(Integer x) {}
			}
			''',
			'''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class Something extends AbstractSomething {
			  @Override
			  protected void _m(final String x) {
			  }
			
			  @Override
			  public void m(final Object x) {
			    if (x instanceof Integer) {
			      _m((Integer)x);
			      return;
			    } else if (x instanceof String) {
			      _m((String)x);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(x).toString());
			    }
			  }
			}
			'''
		)
	}
	
	@Test def void testDispatchWithOverrideJava5HasNoAnnotation() {
		assertCompilesTo(
			'''
			class Something extends AbstractSomething {
				override dispatch void m(String x) {}
			}

			class AbstractSomething {
				protected def dispatch void m(String x) {}
				protected def dispatch void m(Integer x) {}
			}
			''',
			'''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class Something extends AbstractSomething {
			  @Override
			  protected void _m(final String x) {
			  }
			
			  @Override
			  public void m(final Object x) {
			    if (x instanceof Integer) {
			      _m((Integer)x);
			      return;
			    } else if (x instanceof String) {
			      _m((String)x);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(x).toString());
			    }
			  }
			}
			'''
		)
	}
}