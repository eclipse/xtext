/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug472602Test extends AbstractXtendCompilerTest {
	
	@Ignore
	@Test def test_01() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map() {
					[|
						val A a = get
						null
					]
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public abstract class C<A extends Object> {
			  public abstract A get();
			  
			  public <B extends Object> C<B> map() {
			    final C<B> _function = new C<B>() {
			      @Override
			      public B get() {
			        Object _xblockexpression = null;
			        {
			          final A a = C.this.get();
			          _xblockexpression = null;
			        }
			        return ((B)_xblockexpression);
			      }
			    };
			    return _function;
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map() {
					val A a = this.get
					null
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public abstract class C<A extends Object> {
			  public abstract A get();
			  
			  public <B extends Object> C<B> map() {
			    Object _xblockexpression = null;
			    {
			      final A a = this.get();
			      _xblockexpression = null;
			    }
			    return ((C<B>)_xblockexpression);
			  }
			}
		''')
	}
	
	@Ignore
	@Test def test_03() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map(Function<A, B> f) {
					[|
						val A a = get
						val B b = f.apply(a)
						return b
					]
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Function;
			
			@SuppressWarnings("all")
			public abstract class C<A extends Object> {
			  public abstract A get();
			  
			  public <B extends Object> C<B> map(final Function<A, B> f) {
			    final C<B> _function = new C<B>() {
			      @Override
			      public B get() {
			        final A a = C.this.get();
			        final B b = f.apply(a);
			        return b;
			      }
			    };
			    return _function;
			  }
			}
		''')
	}
	
	@Ignore
	@Test def test_04() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map(Function<A, B> f) {
					[|
						get // must compile to C.this.gt
						return self.get // must compile to this.get
					]
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Function;
			
			@SuppressWarnings("all")
			public abstract class C<A extends Object> {
			  public abstract A get();
			  
			  public <B extends Object> C<B> map(final Function<A, B> f) {
			    final C<B> _function = new C<B>() {
			      @Override
			      public B get() {
			      	C.this.get();
			        return this.get();
			      }
			    };
			    return _function;
			  }
			}
		''')
	}
	
	@Ignore
	@Test def test_05() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map(Function<A, B> f) {
					new C<B>() {
						override get() {
							val A a = C.this.get
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
			    final C<B> _function = new C<B>() {
			      @Override
			      public B get() {
			        final A a = C.this.get();
			        final B b = f.apply(a);
			        B _elvis = null;
			        if (b != null) {
			          _elvis = b;
			        } else {
			          B _get = C.this.get();
			          _elvis = _get;
			        }
			        return _elvis;
			      }
			    };
			    return _function;
			  }
			}
		''')
	}
	
	@Test def test_06() {
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
	
	@Test def test_07() {
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
	
	@Test def test_08() {
		'''
			import com.google.common.base.Function
			
			abstract class C<A> {
				def A get();
				
				def <B> C<B> map(Function<A, B> f) {
					val thiz = this
					return [
						val A a = thiz.get
						val B b = f.apply(a)
						return b
					]
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Function;
			
			@SuppressWarnings("all")
			public abstract class C<A extends Object> {
			  public abstract A get();
			  
			  public <B extends Object> C<B> map(final Function<A, B> f) {
			    final C<A> thiz = this;
			    final C<B> _function = new C<B>() {
			      @Override
			      public B get() {
			        final A a = thiz.get();
			        final B b = f.apply(a);
			        return b;
			      }
			    };
			    return _function;
			  }
			}
		''')
	}
}