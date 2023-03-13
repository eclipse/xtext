/*******************************************************************************
 * Copyright (c) 2023 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

class CompilerBug1005Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug516321() {
		assertCompilesTo(
			'''
			package com.acme
			import java.util.function.Consumer
			import static com.acme.Outer.E0.*
			class Outer {
				static class C {
					def m(B<?> it) {
						child(E1.F) [
							c(7)
						]
					}
				}
				enum E0 {
					c
				}
				enum E1 {
					F
				}
				static class A<T> {
				}
				static class B<T> {
					def B<T> c(int i) {
						return this;
					}
					def <C> B<T> child(Consumer<B<C>> consumer) {
						return null;
					}
					def <C> B<T> child(A<C> child) {
						return null;
					}
					def <C> B<T> child(E1 e1, Consumer<B<C>> consumer) {
						return null;
					}
				}
			}
			''',
			'''
			package com.acme;
			
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class Outer {
			  public static class C {
			    public Outer.B<?> m(final Outer.B<?> it) {
			      final Consumer<Outer.B<Outer.C>> _function = new Consumer<Outer.B<Outer.C>>() {
			        public void accept(final Outer.B<Outer.C> it_1) {
			          it_1.c(7);
			        }
			      };
			      return it.<Object>child(Outer.E1.F, _function);
			    }
			  }
			
			  public enum E0 {
			    c;
			  }
			
			  public enum E1 {
			    F;
			  }
			
			  public static class A<T extends Object> {
			  }
			
			  public static class B<T extends Object> {
			    public Outer.B<T> c(final int i) {
			      return this;
			    }
			
			    public <C extends Object> Outer.B<T> child(final Consumer<Outer.B<Outer.C>> consumer) {
			      return null;
			    }
			
			    public <C extends Object> Outer.B<T> child(final Outer.A<Outer.C> child) {
			      return null;
			    }
			
			    public <C extends Object> Outer.B<T> child(final Outer.E1 e1, final Consumer<Outer.B<Outer.C>> consumer) {
			      return null;
			    }
			  }
			}
			'''
		)
	}
	
}