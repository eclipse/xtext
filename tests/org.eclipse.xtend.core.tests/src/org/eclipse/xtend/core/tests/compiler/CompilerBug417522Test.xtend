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
class CompilerBug417522Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import java.lang.annotation.Annotation
			class Bug {
			    def demo(Instance<Bug> instance) {
			        instance.select(Bug)
			    }
			}
			interface Instance<T> {
				def Instance<T> select(Annotation qualifiers);
			    def <U extends T> Instance<U> select(Class<U> subtype);
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public Instance<Bug> demo(final Instance<Bug> instance) {
			    return instance.<Bug>select(Bug.class);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import java.lang.annotation.Annotation
			class Bug {
			    def demo(Instance<Bug> instance) {
			        instance.select(Sub)
			    }
			}
			class Sub extends Bug {}
			interface Instance<T> {
				def Instance<T> select(Annotation qualifiers);
			    def <U extends T> Instance<U> select(Class<U> subtype);
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public Instance<Sub> demo(final Instance<Bug> instance) {
			    return instance.<Sub>select(Sub.class);
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import java.lang.annotation.Annotation
			class Bug {
			    var Instance<Bug> instance
			    def demo() {
			        instance.select(Bug)
			        instance.select()
			        instance.select(#[])
			        instance.select(Bug, #[])
			    }
			}
			interface Instance<T> {
			    def Instance<T> select(Annotation... qualifiers);
			    def <U extends T> Instance<U> select(Class<U> subtype, Annotation... qualifiers);
			}
		''', '''
			import java.lang.annotation.Annotation;
			
			@SuppressWarnings("all")
			public class Bug {
			  private Instance<Bug> instance;
			  
			  public Instance<Bug> demo() {
			    Instance<Bug> _xblockexpression = null;
			    {
			      this.instance.<Bug>select(Bug.class);
			      this.instance.select();
			      this.instance.select(new Annotation[] {});
			      _xblockexpression = (this.instance.<Bug>select(Bug.class, new Annotation[] {}));
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import java.lang.annotation.Annotation
			class Bug {
			    def demo(Instance<Bug> instance) {
			        instance.select(Sub)
			    }
			}
			interface Sub extends Iterable<Bug> {}
			interface Instance<T> {
				def Instance<T> select(Annotation qualifiers);
			    def <U extends Iterable<T>> Instance<U> select(Class<U> subtype);
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public Instance<Sub> demo(final Instance<Bug> instance) {
			    return instance.<Sub>select(Sub.class);
			  }
			}
		''')
	}
}