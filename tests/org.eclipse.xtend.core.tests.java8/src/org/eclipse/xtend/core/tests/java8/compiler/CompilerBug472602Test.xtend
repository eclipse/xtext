/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug472602Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug472602Test {
	
	@Test override test_06() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map(Function<A, B> f) {
					new MapResult(this, f)
				}
				static class MapResult<A, B> extends C<B> {
					C<A> in
					Function<A, B> f
					new (C<A> in, Function<A, B> f) {
						this.in = in
						this.f = f
					}
					override get() {
						val A a = in.get
						val B b = f.apply(a)
						return b
					}
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Function;
			
			@SuppressWarnings("all")
			public abstract class C<A extends Object> {
			  public static class MapResult<A extends Object, B extends Object> extends C<B> {
			    private C<A> in;
			    
			    private Function<A, B> f;
			    
			    public MapResult(final C<A> in, final Function<A, B> f) {
			      this.in = in;
			      this.f = f;
			    }
			    
			    @Override
			    public B get() {
			      final A a = this.in.get();
			      final B b = this.f.apply(a);
			      return b;
			    }
			  }
			  
			  public abstract A get();
			  
			  public <B extends Object> C<B> map(final Function<A, B> f) {
			    return new C.MapResult<A, B>(this, f);
			  }
			}
		''')
	}
	
	@Test override test_07() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map(Function<A, B> f) {
					val thiz = this
					new C<B>() {
						override get() {
							val A a = thiz.get
							val B b = f.apply(a)
							return b
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Function;
			
			@SuppressWarnings("all")
			public abstract class C<A extends Object> {
			  public abstract A get();
			  
			  public <B extends Object> C<B> map(final Function<A, B> f) {
			    C<B> _xblockexpression = null;
			    {
			      final C<A> thiz = this;
			      _xblockexpression = new C<B>() {
			        @Override
			        public B get() {
			          final A a = thiz.get();
			          final B b = f.apply(a);
			          return b;
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
}