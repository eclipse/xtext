/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug418364Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def m(R r, String[] args) {
					r.setInput(args)
				}
			}
			class G<E,I> {
				def void setInput(I i) {}
			}
			class R extends G {}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final R r, final String[] args) {
			    r.setInput(args);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def m(R r) {
					r.setInput(#[])
				}
			}
			class G<E,I> {
				def void setInput(I i) {}
			}
			class R extends G {}
		''', '''
			import com.google.common.collect.Lists;
			import java.util.Collections;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final R r) {
			    r.setInput(Collections.<Object>unmodifiableList(Lists.<Object>newArrayList()));
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def m(R r) {
					r.setInput(#[])
				}
			}
			class G<E,I extends String> {
				def void setInput(Iterable<I> i) {}
			}
			class R extends G {}
		''', '''
			import com.google.common.collect.Lists;
			import java.util.Collections;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final R r) {
			    r.setInput(Collections.<String>unmodifiableList(Lists.<String>newArrayList()));
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def m(R r) {
					r.setInput(#[])
				}
			}
			class G<E,I> {
				def void setInput(Iterable<I> i) {}
			}
			class G2<T extends Number> extends G<String, T> {}
			class R extends G2 {}
		''', '''
			import com.google.common.collect.Lists;
			import java.util.Collections;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final R r) {
			    r.setInput(Collections.<Number>unmodifiableList(Lists.<Number>newArrayList()));
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				def m(R r) {
					r.setInput(#[])
				}
			}
			class G<E,I> {
				def void setInput(I i) {}
			}
			class G2<T extends Number> extends G<String, Iterable<T>> {}
			class R extends G2 {}
		''', '''
			import com.google.common.collect.Lists;
			import java.util.Collections;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final R r) {
			    r.setInput(Collections.<Number>unmodifiableList(Lists.<Number>newArrayList()));
			  }
			}
		''')
	}
}