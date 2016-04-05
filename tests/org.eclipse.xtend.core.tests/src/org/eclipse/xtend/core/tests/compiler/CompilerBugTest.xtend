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
class CompilerBugTest extends AbstractXtendCompilerTest {
	
	@Test def void testCompoundOperatorPrecedence() {
		assertCompilesTo('''
			import java.util.List
			class C {
				def <T> operator_plus(List<T> list, T value) {}
				def m(List<String> items, String s) {
					items += s
				}
			}
		''','''
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> Object operator_plus(final List<T> list, final T value) {
			    return null;
			  }
			  
			  public boolean m(final List<String> items, final String s) {
			    return items.add(s);
			  }
			}
		''')
	}
	
	@Test def void testDeferredTypeArgumentResolution() {
		assertCompilesTo('''
			class C {
				def m() {
					val list = newArrayList
					list.addAll(1, null as String[])
					list
				}
			}
		''','''
			import java.util.ArrayList;
			import java.util.Collection;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public ArrayList<String> m() {
			    ArrayList<String> _xblockexpression = null;
			    {
			      final ArrayList<String> list = CollectionLiterals.<String>newArrayList();
			      list.addAll(1, ((Collection<? extends String>)Conversions.doWrapArray(((String[]) null))));
			      _xblockexpression = list;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void testBug424145_01() {
		assertCompilesTo('''
			class C {
				def m(java.util.List<String[]> arg) { arg.head }
				def n() {
				  m(#[]).get(5)
				}
			}
		''','''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public String[] m(final List<String[]> arg) {
			    return IterableExtensions.<String[]>head(arg);
			  }
			  
			  public String n() {
			    String[] _m = this.m(Collections.<String[]>unmodifiableList(CollectionLiterals.<String[]>newArrayList()));
			    return _m[5];
			  }
			}
		''')
	}
	
	@Test def void testBug424145_02() {
		assertCompilesTo('''
			class C {
				def m(java.util.List<String[]> arg) {}
				def n() {
				  m(#[#['a', 'a']])
				}
			}
		''','''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m(final List<String[]> arg) {
			    return null;
			  }
			  
			  public Object n() {
			    return this.m(Collections.<String[]>unmodifiableList(CollectionLiterals.<String[]>newArrayList(new String[] { "a", "a" })));
			  }
			}
		''')
	}
	
	@Test def void testBug426788_01() {
		assertCompilesTo('''
			class Bug {
				def <T extends Object> void m(T t) {}
				def void m(CharSequence t) {}
				def void n(Iterable<String> it) {
					m(it.iterator.next)
				}
			}
		''','''
			import java.util.Iterator;
			
			@SuppressWarnings("all")
			public class Bug {
			  public <T extends Object> void m(final T t) {
			  }
			  
			  public void m(final CharSequence t) {
			  }
			  
			  public void n(final Iterable<String> it) {
			    Iterator<String> _iterator = it.iterator();
			    String _next = _iterator.next();
			    this.m(_next);
			  }
			}
		''')
	}
	
	@Test def void testBug426788_02() {
		assertCompilesTo('''
			class Bug {
				def <T extends Object> void m(T t) {}
				def void m(CharSequence t) {}
				def void n(Iterable<String> it) {
					m(it.head)
				}
			}
		''','''
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class Bug {
			  public <T extends Object> void m(final T t) {
			  }
			  
			  public void m(final CharSequence t) {
			  }
			  
			  public void n(final Iterable<String> it) {
			    String _head = IterableExtensions.<String>head(it);
			    this.m(_head);
			  }
			}
		''')
	}
	
	@Test def void testReturnExpressionConverted_01() {
		assertCompilesTo('''
			class C {
				def Iterable<?> m() {
					val java.util.List<?> a = null
					val Object[] b = null
					if ('foo'=='bar') {
						return a;
					} else {
						return b;
					}
				}
			}
		''','''
			import com.google.common.base.Objects;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<?> m() {
			    final List<?> a = null;
			    final Object[] b = null;
			    boolean _equals = Objects.equal("foo", "bar");
			    if (_equals) {
			      return a;
			    } else {
			      return (Iterable<?>)Conversions.doWrapArray(b);
			    }
			  }
			}
		''')
	}
	
	@Test def void testReturnExpressionConverted_02() {
		assertCompilesTo('''
			class C {
				def Object[] m() {
					val java.util.List<?> a = null
					val Object[] b = null
					if ('foo'=='bar') {
						return a;
					} else {
						return b;
					}
				}
			}
		''','''
			import com.google.common.base.Objects;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public Object[] m() {
			    final List<?> a = null;
			    final Object[] b = null;
			    boolean _equals = Objects.equal("foo", "bar");
			    if (_equals) {
			      return ((Object[])Conversions.unwrapArray(a, Object.class));
			    } else {
			      return b;
			    }
			  }
			}
		''')
	}
	
	@Test def void testReturnExpressionConverted_03() {
		assertCompilesTo('''
			class C {
				def m() {
					val java.util.List<?> a = null
					val Object[] b = null
					if ('foo'=='bar') {
						return a;
					} else {
						return b;
					}
				}
			}
		''','''
			import com.google.common.base.Objects;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    final List<?> a = null;
			    final Object[] b = null;
			    boolean _equals = Objects.equal("foo", "bar");
			    if (_equals) {
			      return a;
			    } else {
			      return b;
			    }
			  }
			}
		''')
	}
	
	@Test def void testReturnExpressionConverted_04() {
		assertCompilesTo('''
			class C {
				def foo() {
				   if ('foo'==null) {
				      return myGuavaPredicate()
				    } else {
				       return [String s| true]
				    }
				}
				
				def com.google.common.base.Predicate<String> myGuavaPredicate() {
					return null;
				}
			}
		''','''
			import com.google.common.base.Objects;
			import com.google.common.base.Predicate;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public Function1<String, Boolean> foo() {
			    boolean _equals = Objects.equal("foo", null);
			    if (_equals) {
			      return new Function1<String, Boolean>() {
			          public Boolean apply(String arg0) {
			            return C.this.myGuavaPredicate().apply(arg0);
			          }
			      };
			    } else {
			      final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
			        public Boolean apply(final String s) {
			          return Boolean.valueOf(true);
			        }
			      };
			      return _function;
			    }
			  }
			  
			  public Predicate<String> myGuavaPredicate() {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def void testAutocast_01() {
		assertCompilesTo('''
			class C {
				def void m() {
					var A a = null
					if(a instanceof B) {
						a = a.get
					}
				}	
			}
			class A {
			}
			class B extends A {
				def A get() {
					null
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    A a = null;
			    if ((a instanceof B)) {
			      A _get = ((B)a).get();
			      a = _get;
			    }
			  }
			}
		''')
	}
	
	@Test
	def void testAutocast_02() {
		assertCompilesTo('''
			class C {
				def void m() {
					var A a = null
					while(a instanceof B) {
						a = a.get
					}
				}	
			}
			class A {
			}
			class B extends A {
				def A get() {
					null
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    A a = null;
			    while ((a instanceof B)) {
			      A _get = ((B)a).get();
			      a = _get;
			    }
			  }
			}
		''')
	}
	
	@Test
	def void test410794() {
		assertCompilesTo('''
			class BugSwitch {
				var Number n
				def test() {
					switch(n) {
						Integer : this.n = new Double(5)
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugSwitch {
			  private Number n;
			  
			  public Number test() {
			    Number _switchResult = null;
			    final Number n = this.n;
			    boolean _matched = false;
			    if (n instanceof Integer) {
			      _matched=true;
			      Double _double = new Double(5);
			      _switchResult = this.n = _double;
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def void test416617() {
		assertCompilesTo('''
			class TestTypes {
				def foo() {
					var A tmp = null
					switch (tmp) {
						B: {
							tmp = tmp.bar ?: tmp.baz
						}
					}
				}
				def B bar(Object x) {
					return x as B
				}
				def C baz(Object x) {
					return x as C
				}
			}
			class A {}
			class B extends A {}
			class C extends A {}
		''', '''
			@SuppressWarnings("all")
			public class TestTypes {
			  public A foo() {
			    A _xblockexpression = null;
			    {
			      A tmp = null;
			      A _switchResult = null;
			      boolean _matched = false;
			      if (tmp instanceof B) {
			        _matched=true;
			        A _elvis = null;
			        B _bar = this.bar(tmp);
			        if (_bar != null) {
			          _elvis = _bar;
			        } else {
			          C _baz = this.baz(tmp);
			          _elvis = _baz;
			        }
			        _switchResult = tmp = _elvis;
			      }
			      _xblockexpression = _switchResult;
			    }
			    return _xblockexpression;
			  }
			  
			  public B bar(final Object x) {
			    return ((B) x);
			  }
			  
			  public C baz(final Object x) {
			    return ((C) x);
			  }
			}
		''')
	}
	
	@Test
	def void test416516_01() {
		assertCompilesTo('''
			class Bug {
			    def void m(Bug... otherInstances) {
			    }
			    def void m2(Bug other) {
			        this.m(other)
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Bug... otherInstances) {
			  }
			  
			  public void m2(final Bug other) {
			    this.m(other);
			  }
			}
		''')
	}
	
	@Test
	def void test416516_02() {
		assertCompilesTo('''
			class Bug {
			    def void m(Bug... otherInstances) {
			    }
			    def void m2(Bug other) {
			        this.m
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Bug... otherInstances) {
			  }
			  
			  public void m2(final Bug other) {
			    this.m();
			  }
			}
		''')
	}
	
	@Test
	def void test416516_03() {
		assertCompilesTo('''
			class Bug {
			    def void m(Bug... otherInstances) {
			    }
			    def void m2(Bug it) {
			        this.m
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Bug... otherInstances) {
			  }
			  
			  public void m2(final Bug it) {
			    this.m();
			  }
			}
		''')
	}
	
	@Test
	def void test416516_04() {
		assertCompilesTo('''
			class Bug {
			    def void m(Bug... otherInstances) {
			    }
			    def void m2(Bug it) {
			        this.m(it)
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Bug... otherInstances) {
			  }
			  
			  public void m2(final Bug it) {
			    this.m(it);
			  }
			}
		''')
	}
	
	@Test
	def void test416516_05() {
		assertCompilesTo('''
			class Bug {
			    def void m(Bug... otherInstances) {
			    }
			    def void m2(Bug it) {
			        m(it)
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Bug... otherInstances) {
			  }
			  
			  public void m2(final Bug it) {
			    it.m(it);
			  }
			}
		''')
	}
	
	@Test
	def void test416516_06() {
		assertCompilesTo('''
			class Bug {
			    def void m(Bug... otherInstances) {
			    }
			    def void m2(Bug it) {
			        m
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Bug... otherInstances) {
			  }
			  
			  public void m2(final Bug it) {
			    it.m();
			  }
			}
		''')
	}
	
	@Test
	def void test412083() {
		assertCompilesTo('''
			class Bug {
				def bar(extension Foo foo) {
					foo(1)
				}
			}
			
			class Foo {
				def foo(Bug bug, int i) {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Bug {
			  public Object bar(@Extension final Foo foo) {
			    return foo.foo(this, 1);
			  }
			}
		''')
	}
	@Test
	def void test412083_01() {
		assertCompilesTo('''
			class Bug {
				extension Foo foo
				def bar() {
					foo(1)
				}
			}
			
			class Foo {
				def foo(Bug bug, int i) {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Bug {
			  @Extension
			  private Foo foo;
			  
			  public Object bar() {
			    return this.foo.foo(this, 1);
			  }
			}
		''')
	}
	@Test
	def void test412083_02() {
		assertCompilesTo('''
			class Bug {
				
				def bar() {
					foo(1)
				}
				def foo(Bug bug, int i) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public Object bar() {
			    return this.foo(this, 1);
			  }
			  
			  public Object foo(final Bug bug, final int i) {
			    return null;
			  }
			}
		''')
	}
	@Test
	def void test412083_03() {
		assertCompilesTo('''
			class Bug {
				
				def bar() {
					foo(1)
				}
				def foo(Bug bug, int i) {}
				def foo(int i) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public Object bar() {
			    return this.foo(1);
			  }
			  
			  public Object foo(final Bug bug, final int i) {
			    return null;
			  }
			  
			  public Object foo(final int i) {
			    return null;
			  }
			}
		''')
	}
	@Test
	def void test412083_04() {
		assertCompilesTo('''
			class Bug {
				def bar(extension Foo foo) {
					foo(1)
				}
			}
			
			class Foo {
				def foo(Bug bug, int i) {}
				def foo(int i) {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Bug {
			  public Object bar(@Extension final Foo foo) {
			    return foo.foo(1);
			  }
			}
		''')
	}
	@Test
	def void test412083_05() {
		assertCompilesTo('''
			class Bug {
				def bar(extension Foo foo, Bug it) {
					foo(1)
				}
			}
			
			class Foo {
				def foo(Bug bug, int i) {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;

			@SuppressWarnings("all")
			public class Bug {
			  public Object bar(@Extension final Foo foo, final Bug it) {
			    return foo.foo(it, 1);
			  }
			}
		''')
	}
	
	@Test
	def testPreferStaticMethodsOverClassMembers() {
		assertCompilesTo('''
			import javax.xml.parsers.DocumentBuilderFactory
			class C {
				def void m() {
					DocumentBuilderFactory.newInstance
				}
			}
		''', '''
			import javax.xml.parsers.DocumentBuilderFactory;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    DocumentBuilderFactory.newInstance();
			  }
			}
		''')
	}
	
	@Test
	def testPreferlassMembersOverInstanceMethods() {
		assertCompilesTo('''
			class C {
				def void m() {
					C.newInstance
				}
				def void newInstance() {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    try {
			      C.class.newInstance();
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			  
			  public void newInstance() {
			  }
			}
		''')
	}
	
	@Test
	def testBug406416_01() {
		assertCompilesTo('''
			class Factory<T> {
				def <T1, F extends Factory<T1>> T1 buildChild(F fa, (F)=>void configurator) {}
				def <T1, F extends Factory<T1>> T1 buildChild(F fa) {}
				def build(Factory<String> f, T it) {
					buildChild(f)
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Factory<T extends Object> {
			  public <T1 extends Object, F extends Factory<T1>> T1 buildChild(final F fa, final Procedure1<? super F> configurator) {
			    return null;
			  }
			  
			  public <T1 extends Object, F extends Factory<T1>> T1 buildChild(final F fa) {
			    return null;
			  }
			  
			  public String build(final Factory<String> f, final T it) {
			    return this.<String, Factory<String>>buildChild(f);
			  }
			}
		''')
	}
	
	@Test
	def testBug406416_02() {
		assertCompilesTo('''
			class Factory<T> {
				def void fill((T)=>void configurator) {}
				def <T1, F extends Factory<T1>> T1 buildChild(F fa, (F)=>void configurator) {}
				def <T1, F extends Factory<T1>> T1 buildChild(F fa) {}
				def build(Factory<String> f) {
					fill [ buildChild(f) ]
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Factory<T extends Object> {
			  public void fill(final Procedure1<? super T> configurator) {
			  }
			  
			  public <T1 extends Object, F extends Factory<T1>> T1 buildChild(final F fa, final Procedure1<? super F> configurator) {
			    return null;
			  }
			  
			  public <T1 extends Object, F extends Factory<T1>> T1 buildChild(final F fa) {
			    return null;
			  }
			  
			  public void build(final Factory<String> f) {
			    final Procedure1<T> _function = new Procedure1<T>() {
			      public void apply(final T it) {
			        Factory.this.<String, Factory<String>>buildChild(f);
			      }
			    };
			    this.fill(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406370() {
		assertCompilesTo('''
			class C {
			    new() {
			        #[1,2,3].map [ toString ].toString
			    }
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public C() {
			    final Function1<Integer, String> _function = new Function1<Integer, String>() {
			      public String apply(final Integer it) {
			        return it.toString();
			      }
			    };
			    List<String> _map = ListExtensions.<Integer, String>map(Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3))), _function);
			    _map.toString();
			  }
			}
		''')
	}
	
	@Test
	def testBug406360() {
		assertCompilesTo('''
			import org.eclipse.xtext.common.types.JvmTypeReference
			import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
			import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions
			
			class C {
				extension ErrorSafeExtensions
				def void m(Iterable<JvmTypeReference> refs, ITreeAppendable it) {
					forEachSafely(refs, []) [
						it, app |  app.trace(it).append(it.type)
					]
				}
			}
		''', '''
			import org.eclipse.xtext.common.types.JvmType;
			import org.eclipse.xtext.common.types.JvmTypeReference;
			import org.eclipse.xtext.xbase.compiler.ErrorSafeExtensions;
			import org.eclipse.xtext.xbase.compiler.LoopParams;
			import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
			import org.eclipse.xtext.xbase.lib.Extension;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
			
			@SuppressWarnings("all")
			public class C {
			  @Extension
			  private ErrorSafeExtensions _errorSafeExtensions;
			  
			  public void m(final Iterable<JvmTypeReference> refs, final ITreeAppendable it) {
			    final Procedure1<LoopParams> _function = new Procedure1<LoopParams>() {
			      public void apply(final LoopParams it) {
			      }
			    };
			    final Procedure2<JvmTypeReference, ITreeAppendable> _function_1 = new Procedure2<JvmTypeReference, ITreeAppendable>() {
			      public void apply(final JvmTypeReference it, final ITreeAppendable app) {
			        ITreeAppendable _trace = app.trace(it);
			        JvmType _type = it.getType();
			        _trace.append(_type);
			      }
			    };
			    this._errorSafeExtensions.<JvmTypeReference>forEachSafely(it, refs, _function, _function_1);
			  }
			}
		''')
	}
	
	@Test
	def testBug406356_01() {
		assertCompilesTo('''
			class C {
				def <T> T build() {
					println()
					null
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.InputOutput;

			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> T build() {
			    Object _xblockexpression = null;
			    {
			      InputOutput.println();
			      _xblockexpression = null;
			    }
			    return ((T)_xblockexpression);
			  }
			}
		''')
	}
	
	@Test
	def testBug406356_02() {
		assertCompilesTo('''
			class C<T> {
				def T build() {
					println()
					null
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.InputOutput;

			@SuppressWarnings("all")
			public class C<T extends Object> {
			  public T build() {
			    Object _xblockexpression = null;
			    {
			      InputOutput.println();
			      _xblockexpression = null;
			    }
			    return ((T)_xblockexpression);
			  }
			}
		''')
	}
	
	@Test
	def testBug406051() {
		assertCompilesTo('''
			class C {
			    def m() {
					newHashMap("string" -> 5, 5 -> "string")
			    }
			}
		''', '''
			import java.util.HashMap;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public HashMap<Object, Object> m() {
			    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("string", Integer.valueOf(5));
			    Pair<Integer, String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(5), "string");
			    return CollectionLiterals.<Object, Object>newHashMap(_mappedTo, _mappedTo_1);
			  }
			}
		''')
	}
	
	@Test
	def testBug406267_01() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Map
			
			class Bug {
			    List<String> list = newArrayList
			    
			    def doSomething(Map<String, String> mapping) {
			        list = mapping.values.sort
			    }
			}
		''', '''
			import java.util.Collection;
			import java.util.List;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class Bug {
			  private List<String> list = CollectionLiterals.<String>newArrayList();
			  
			  public List<String> doSomething(final Map<String, String> mapping) {
			    Collection<String> _values = mapping.values();
			    List<String> _sort = IterableExtensions.<String>sort(_values);
			    return this.list = _sort;
			  }
			}
		''')
	}
	
	@Test
	def testBug405900_01() {
		assertCompilesTo('''
			import java.util.List
			class C {
				def List<CharSequence> getChildren() {}
				def m() {
					val result = (null as StringBuilder) => [
						children += it
						it.append('')
					]
					result
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public List<CharSequence> getChildren() {
			    return null;
			  }
			  
			  public StringBuilder m() {
			    StringBuilder _xblockexpression = null;
			    {
			      final Procedure1<StringBuilder> _function = new Procedure1<StringBuilder>() {
			        public void apply(final StringBuilder it) {
			          List<CharSequence> _children = C.this.getChildren();
			          _children.add(it);
			          it.append("");
			        }
			      };
			      final StringBuilder result = ObjectExtensions.<StringBuilder>operator_doubleArrow(((StringBuilder) null), _function);
			      _xblockexpression = result;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def testBug405155_01() {
		assertCompilesTo('''
			class Test {
				def <T, F extends Factory<T>> T build(Factory<T> f) {
					return null;
				}
				def test() {
					build(new StringFactory)
				}
			}
			class Factory<T> {}
			class StringFactory extends Factory<String>{}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object, F extends Factory<T>> T build(final Factory<T> f) {
			    return null;
			  }
			  
			  public String test() {
			    StringFactory _stringFactory = new StringFactory();
			    return this.<String, Factory<String>>build(_stringFactory);
			  }
			}
		''')
	}
	
	@Test
	def testBug405155_02() {
		assertCompilesTo('''
			class Test {
				def <T> T build(Factory<? extends T> factory) {
				}
				def test() {
					build(new StringFactory)
				}
			}
			class Factory<T> {}
			class StringFactory extends Factory<String>{}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> T build(final Factory<? extends T> factory) {
			    return null;
			  }
			  
			  public String test() {
			    StringFactory _stringFactory = new StringFactory();
			    return this.<String>build(_stringFactory);
			  }
			}
		''')
	}
	
	@Test
	def testBug405155_03() {
		assertCompilesTo('''
			class Test {
				def <T, F extends Factory<T>> T build(F xfactory) {
				}
				def test() {
					build(new StringFactory)
				}
			}
			class Factory<T> {}
			class StringFactory extends Factory<String>{}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object, F extends Factory<T>> T build(final F xfactory) {
			    return null;
			  }
			  
			  public String test() {
			    StringFactory _stringFactory = new StringFactory();
			    return this.<String, StringFactory>build(_stringFactory);
			  }
			}
		''')
	}
	
	@Test
	def testBug405155_04() {
		assertCompilesTo('''
			class Test {
				def <T> T build(Factory<T> xfactory) {
				}
				def test() {
					build(new StringFactory)
				}
			}
			class Factory<T> {}
			class StringFactory extends Factory<String>{}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> T build(final Factory<T> xfactory) {
			    return null;
			  }
			  
			  public String test() {
			    StringFactory _stringFactory = new StringFactory();
			    return this.<String>build(_stringFactory);
			  }
			}
		''')
	}
	
	@Test
	def testBug405155_05() {
		assertCompilesTo('''
			class Test {
				def <T, F extends Factory<T>> T build(F xfactory) {
				}
				def test() {
					<String, StringFactory>build(new StringFactory)
				}
			}
			class Factory<T> {}
			class StringFactory extends Factory<String>{}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object, F extends Factory<T>> T build(final F xfactory) {
			    return null;
			  }
			  
			  public String test() {
			    StringFactory _stringFactory = new StringFactory();
			    return this.<String, StringFactory>build(_stringFactory);
			  }
			}
		''')
	}
	
	@Test
	def testOverloadBug405952_01() {
		assertCompilesTo('''
			import com.google.inject.Injector
			class C {
				def void m(Injector i) {
				}
				def <T extends Comparable<T>> void m(T t) {
					m('')
				}
			}
		''', '''
			import com.google.inject.Injector;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final Injector i) {
			  }
			  
			  public <T extends Comparable<T>> void m(final T t) {
			    this.<String>m("");
			  }
			}
		''')
	}
	
	@Test
	def testOverloadBug405952_02() {
		assertCompilesTo('''
			import com.google.inject.Injector
			class C {
				def <T extends Comparable<T>, X extends T> void m(T t, X x) {
					m('', '')
				}
				def void m(Injector i, Class<? extends CharSequence> c) {
					''.m('')
				}
			}
		''', '''
			import com.google.inject.Injector;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Comparable<T>, X extends T> void m(final T t, final X x) {
			    this.<String, String>m("", "");
			  }
			  
			  public void m(final Injector i, final Class<? extends CharSequence> c) {
			    this.<String, String>m("", "");
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_01() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def m() {
					val Object o = nullAsCollection(typeof(String))
					o.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public String m() {
			    String _xblockexpression = null;
			    {
			      final Object o = this.<String, Collection<String>>nullAsCollection(String.class);
			      _xblockexpression = o.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_02() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def m() {
					val Iterable<String> i = nullAsCollection(typeof(String))
					i.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public String m() {
			    String _xblockexpression = null;
			    {
			      final Iterable<String> i = this.<String, Collection<String>>nullAsCollection(String.class);
			      _xblockexpression = i.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_03() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def m() {
					val Collection<? extends String> c = nullAsCollection(typeof(String))
					c.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public String m() {
			    String _xblockexpression = null;
			    {
			      final Collection<? extends String> c = this.<String, Collection<String>>nullAsCollection(String.class);
			      _xblockexpression = c.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_04() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def m() {
					val Collection<? super String> c = nullAsCollection(typeof(String))
					c.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public String m() {
			    String _xblockexpression = null;
			    {
			      final Collection<? super String> c = this.<String, Collection<String>>nullAsCollection(String.class);
			      _xblockexpression = c.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_05() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def <T> m(Class<T> c) {
					val Object o = nullAsCollection(c)
					o.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> String m(final Class<T> c) {
			    String _xblockexpression = null;
			    {
			      final Object o = this.<T, Collection<T>>nullAsCollection(c);
			      _xblockexpression = o.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_06() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def <T> m(Class<T> c) {
					val Iterable<T> i = nullAsCollection(c)
					i.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> String m(final Class<T> c) {
			    String _xblockexpression = null;
			    {
			      final Iterable<T> i = this.<T, Collection<T>>nullAsCollection(c);
			      _xblockexpression = i.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_07() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def <T> m(Class<T> c) {
					val Iterable<? extends T> i = nullAsCollection(c)
					i.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> String m(final Class<T> c) {
			    String _xblockexpression = null;
			    {
			      final Iterable<? extends T> i = this.<T, Collection<T>>nullAsCollection(c);
			      _xblockexpression = i.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testTypeArgumentBug406197_08() {
		assertCompilesTo('''
			import java.util.Collection
			class C {
				def <T> m(Class<T> c) {
					val Iterable<? super T> i = nullAsCollection(c)
					i.toString
				}
				def <Type, CollectionType extends Collection<Type>> CollectionType nullAsCollection(Class<Type> clazz) { null }
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> String m(final Class<T> c) {
			    String _xblockexpression = null;
			    {
			      final Iterable<? super T> i = this.<T, Collection<T>>nullAsCollection(c);
			      _xblockexpression = i.toString();
			    }
			    return _xblockexpression;
			  }
			  
			  public <Type extends Object, CollectionType extends Collection<Type>> CollectionType nullAsCollection(final Class<Type> clazz) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testArraySetBug405763() {
		assertCompilesTo('''
			class C {
				def m(CharSequence[] array, String value) {
					array.set(1, value)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public CharSequence m(final CharSequence[] array, final String value) {
			    return array[1] = value;
			  }
			}
		''')
	}
	
	@Test
	def testMethodInvocationOnPrimitiveLong() {
		assertCompilesTo('''
			class C {
				def m(int i, long k, Object o) {
					i + k.intValue + o.hashCode
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public int m(final int i, final long k, final Object o) {
			    int _intValue = Long.valueOf(k).intValue();
			    int _plus = (i + _intValue);
			    int _hashCode = o.hashCode();
			    return (_plus + _hashCode);
			  }
			}
		''')
	}
	
	@Test
	def testBug404051_01() {
		assertCompilesTo('''
			class C {
				def m(Iterable<String> iterable) {
					iterable.flatMap[ null ].sortBy [ hashCode ]
				}
				def <A,B> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<?> m(final Iterable<String> iterable) {
			    final Function1<String, Object> _function = new Function1<String, Object>() {
			      public Object apply(final String it) {
			        return null;
			      }
			    };
			    Iterable<?> _flatMap = this.<String, Object>flatMap(iterable, _function);
			    final Function1<Object, Integer> _function_1 = new Function1<Object, Integer>() {
			      public Integer apply(final Object it) {
			        return Integer.valueOf(it.hashCode());
			      }
			    };
			    return IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends Object, B extends Object> Iterable<? extends B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testBug404051_02() {
		assertCompilesTo('''
			class C {
				def void m(Iterable<String> iterable) {
					iterable.flatMap[ it ].sortBy [ hashCode ]
				}
				def <A,B> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final Iterable<String> iterable) {
			    final Function1<String, String> _function = new Function1<String, String>() {
			      public String apply(final String it) {
			        return it;
			      }
			    };
			    Iterable<? extends String> _flatMap = this.<String, String>flatMap(iterable, _function);
			    final Function1<String, Integer> _function_1 = new Function1<String, Integer>() {
			      public Integer apply(final String it) {
			        return Integer.valueOf(it.hashCode());
			      }
			    };
			    IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends Object, B extends Object> Iterable<? extends B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testBug404051_03() {
		assertCompilesTo('''
			class C {
				def void m(Iterable<String> iterable) {
					iterable.flatMap[ toUpperCase ].sortBy [ length ]
				}
				def <A,B> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final Iterable<String> iterable) {
			    final Function1<String, String> _function = new Function1<String, String>() {
			      public String apply(final String it) {
			        return it.toUpperCase();
			      }
			    };
			    Iterable<? extends String> _flatMap = this.<String, String>flatMap(iterable, _function);
			    final Function1<String, Integer> _function_1 = new Function1<String, Integer>() {
			      public Integer apply(final String it) {
			        return Integer.valueOf(it.length());
			      }
			    };
			    IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends Object, B extends Object> Iterable<? extends B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testBug384313() {
		assertCompilesTo('''
			class MyMap<K, V> extends java.util.HashMap<K, V> {
				override putAll(java.util.Map<? extends K,? extends V> t) {
					t.entrySet.forEach [
						this.put(it.key, it.value)
					]
				}
			}
		''', '''
			import java.util.HashMap;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class MyMap<K extends Object, V extends Object> extends HashMap<K, V> {
			  public void putAll(final Map<? extends K, ? extends V> t) {
			    Set<? extends Map.Entry<? extends K, ? extends V>> _entrySet = t.entrySet();
			    final Procedure1<Map.Entry<? extends K, ? extends V>> _function = new Procedure1<Map.Entry<? extends K, ? extends V>>() {
			      public void apply(final Map.Entry<? extends K, ? extends V> it) {
			        K _key = it.getKey();
			        V _value = it.getValue();
			        MyMap.this.put(_key, _value);
			      }
			    };
			    IterableExtensions.forEach(_entrySet, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug403990() {
		assertCompilesTo('''
			class C {
				def m(Class<?> type) {
					type.enumConstants
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Object[] m(final Class<?> type) {
			    return type.getEnumConstants();
			  }
			}
		''')
	}
	
	@Test
	def testWeightComparable_01() {
		assertCompilesTo('''
			@Data class Weight<T extends Comparable> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight w) {
					this.weight.compareTo(w.weight)
				}
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Weight<T extends Comparable> implements Comparable<Weight<T>> {
			  private final T _weight;
			  
			  public int compareTo(final Weight w) {
			    T _weight = this.getWeight();
			    Comparable _weight_1 = w.getWeight();
			    return _weight.compareTo(_weight_1);
			  }
			  
			  public Weight(final T weight) {
			    super();
			    this._weight = weight;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._weight== null) ? 0 : this._weight.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Weight<?> other = (Weight<?>) obj;
			    if (this._weight == null) {
			      if (other._weight != null)
			        return false;
			    } else if (!this._weight.equals(other._weight))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public T getWeight() {
			    return this._weight;
			  }
			}
		''')
	}
	
	@Test
	def testWeightComparable_02() {
		assertCompilesTo('''
			@Data class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight<T> w) {
					this.weight.compareTo(w.weight)
				}
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Weight<T extends Comparable<T>> implements Comparable<Weight<T>> {
			  private final T _weight;
			  
			  public int compareTo(final Weight<T> w) {
			    T _weight = this.getWeight();
			    T _weight_1 = w.getWeight();
			    return _weight.compareTo(_weight_1);
			  }
			  
			  public Weight(final T weight) {
			    super();
			    this._weight = weight;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._weight== null) ? 0 : this._weight.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Weight<?> other = (Weight<?>) obj;
			    if (this._weight == null) {
			      if (other._weight != null)
			        return false;
			    } else if (!this._weight.equals(other._weight))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public T getWeight() {
			    return this._weight;
			  }
			}
		''')
	}
	
	@Test
	def testWeightComparable_03() {
		assertCompilesTo('''
			@Data class Weight<T extends Comparable> implements Comparable<Weight<T>> {
				T weight
				
				override int compareTo(Weight<T> w) {
					this.weight.compareTo(w.weight)
				}
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Weight<T extends Comparable> implements Comparable<Weight<T>> {
			  private final T _weight;
			  
			  public int compareTo(final Weight<T> w) {
			    T _weight = this.getWeight();
			    T _weight_1 = w.getWeight();
			    return _weight.compareTo(_weight_1);
			  }
			  
			  public Weight(final T weight) {
			    super();
			    this._weight = weight;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._weight== null) ? 0 : this._weight.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Weight<?> other = (Weight<?>) obj;
			    if (this._weight == null) {
			      if (other._weight != null)
			        return false;
			    } else if (!this._weight.equals(other._weight))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public T getWeight() {
			    return this._weight;
			  }
			}
		''')
	}
	
	@Test
	def testWeightComparable_04() {
		assertCompilesTo('''
			@Data class Weight<T extends Comparable> implements Comparable<Weight> {
				T weight
				
				override int compareTo(Weight w) {
					this.weight.compareTo(w.weight)
				}
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Weight<T extends Comparable> implements Comparable<Weight> {
			  private final T _weight;
			  
			  public int compareTo(final Weight w) {
			    T _weight = this.getWeight();
			    Comparable _weight_1 = w.getWeight();
			    return _weight.compareTo(_weight_1);
			  }
			  
			  public Weight(final T weight) {
			    super();
			    this._weight = weight;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._weight== null) ? 0 : this._weight.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Weight<?> other = (Weight<?>) obj;
			    if (this._weight == null) {
			      if (other._weight != null)
			        return false;
			    } else if (!this._weight.equals(other._weight))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public T getWeight() {
			    return this._weight;
			  }
			}
		''')
	}
	
	@Test
	def testListLiteral() {
		assertCompilesTo('''
			class C {
				val String[] f = #["a", "b", 1.toString ] 
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private final String[] f = new String[] { "a", "b", Integer.valueOf(1).toString() };
			}
		''')
	}
	
	@Test
	def testNestedListLiteral() {
		assertCompilesTo('''
			class C {
				val f = #[#["a"], #{} ] 
			}
		''', '''
			import java.util.Collection;
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  private final List<? extends Collection<String>> f = Collections.<Collection<String>>unmodifiableList(CollectionLiterals.<Collection<String>>newArrayList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a")), Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet())));
			}
		''')
	}
	
	@Test
	def testNestedListLiteral_02() {
		assertCompilesTo('''
			class C {
				val Iterable<? extends Iterable<String>> f = #[#["a"], #{} ] 
			}
		''', '''
			import java.util.Collections;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  private final Iterable<? extends Iterable<String>> f = Collections.<Iterable<String>>unmodifiableList(CollectionLiterals.<Iterable<String>>newArrayList(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a")), Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet())));
			}
		''')
	}
	
	@Test
	def testEarlyExitInBranch_01() {
		assertCompilesTo('''
			class C {
				def m() {
					switch 'a' {
						case 'b': 'a'
						case 'c': {
							if (1==2)
								return 'b'
							else
								return 'c'
						}
					}
			    }
			}
		''', '''
			import com.google.common.base.Objects;
			
			@SuppressWarnings("all")
			public class C {
			  public String m() {
			    String _switchResult = null;
			    final String _switchValue = "a";
			    boolean _matched = false;
			    if (Objects.equal(_switchValue, "b")) {
			      _matched=true;
			      _switchResult = "a";
			    }
			    if (!_matched) {
			      if (Objects.equal(_switchValue, "c")) {
			        _matched=true;
			        if ((1 == 2)) {
			          return "b";
			        } else {
			          return "c";
			        }
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testEarlyExitInBranch_02() {
		assertCompilesTo('''
			class C {
				def String m(boolean b) {
					switch 'a' {
						case 'b': 'a'
						case 'c': {
							if (b)
								return 'b'
							else
								return 'c'
						}
					}
			    }
			}
		''', '''
			import com.google.common.base.Objects;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final boolean b) {
			    String _switchResult = null;
			    final String _switchValue = "a";
			    boolean _matched = false;
			    if (Objects.equal(_switchValue, "b")) {
			      _matched=true;
			      _switchResult = "a";
			    }
			    if (!_matched) {
			      if (Objects.equal(_switchValue, "c")) {
			        _matched=true;
			        if (b) {
			          return "b";
			        } else {
			          return "c";
			        }
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testOverloadWithSwitchExpression_01() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable
			class C {
				def void m(ITreeAppendable appendable, Double it) {
					appendable.append(switch it {
						case Double::isNaN(it): 'Double.NaN'
						case Double::POSITIVE_INFINITY: 'Double.POSITIVE_INFINITY'
						default: toString + 'd'
					})
			    }
			}
		''', '''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.compiler.output.ITreeAppendable;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final ITreeAppendable appendable, final Double it) {
			    String _switchResult = null;
			    boolean _matched = false;
			    boolean _isNaN = Double.isNaN((it).doubleValue());
			    if (_isNaN) {
			      _matched=true;
			      _switchResult = "Double.NaN";
			    }
			    if (!_matched) {
			      if (Objects.equal(it, Double.POSITIVE_INFINITY)) {
			        _matched=true;
			        _switchResult = "Double.POSITIVE_INFINITY";
			      }
			    }
			    if (!_matched) {
			      String _string = it.toString();
			      _switchResult = (_string + "d");
			    }
			    appendable.append(_switchResult);
			  }
			}
		''')
	}
	
	@Test
	def testWronglyAppliedSugar_01() {
		assertCompilesTo('''
			class C {
				def void getSomething(String s) {
					s.something()
					s.something
			    }
			    def void something(CharSequence c) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void getSomething(final String s) {
			    this.something(s);
			    this.getSomething(s);
			  }
			  
			  public void something(final CharSequence c) {
			  }
			}
		''')
	}
	
	@Test
	def testBugReturnInLoop_01() {
		assertCompilesTo('''
			class C {
				def String m(String s) {
					while(true) {
						try {
							return "string"
						} catch(Exception e) {
							return "string"
						}
					}
			    }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final String s) {
			    while (true) {
			      try {
			        return "string";
			      } catch (final Throwable _t) {
			        if (_t instanceof Exception) {
			          final Exception e = (Exception)_t;
			          return "string";
			        } else {
			          throw Exceptions.sneakyThrow(_t);
			        }
			      }
			    }
			  }
			}
		''')
	}
	
	@Test
	def testBugReturnInLoop_02() {
		assertCompilesTo('''
			class C {
				def String m(String s) {
					while(true) {
						if(true)
							return "string"
					}
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public String m(final String s) {
			    while (true) {
			      if (true) {
			        return "string";
			      }
			    }
			  }
			}
		''')
	}
	
	@Test
	def testBug386110() {
		assertCompilesTo('''
			import com.google.common.util.concurrent.ListenableFuture
			import com.google.common.util.concurrent.MoreExecutors
			
			class Foo<O> {
				val () => O operation = null
			
				def ListenableFuture<O> run() {
					val result = MoreExecutors::sameThreadExecutor.submit(operation)
					operation.apply
					return result
				}
			}
		''', '''
			import com.google.common.util.concurrent.ListenableFuture;
			import com.google.common.util.concurrent.ListeningExecutorService;
			import com.google.common.util.concurrent.MoreExecutors;
			import java.util.concurrent.Callable;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo<O extends Object> {
			  private final Function0<? extends O> operation = null;
			  
			  public ListenableFuture<O> run() {
			    ListeningExecutorService _sameThreadExecutor = MoreExecutors.sameThreadExecutor();
			    final ListenableFuture<O> result = _sameThreadExecutor.<O>submit(new Callable<O>() {
			        public O call() {
			          return Foo.this.operation.apply();
			        }
			    });
			    this.operation.apply();
			    return result;
			  }
			}
		''')
	}
	
	@Test
	def testBug383551_01() {
		assertCompilesTo('''
			abstract class Option<T> {
			  def <X> Option<X> map((T)=>X f) { switch this {
			    Some<T> : new Some<X>
			    None<T> : new None<X>
			  }}
			}
			class Some<T> extends Option<T> {}
			class None<T> extends Option<T> {}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;

			@SuppressWarnings("all")
			public abstract class Option<T extends Object> {
			  public <X extends Object> Option<X> map(final Function1<? super T, ? extends X> f) {
			    Option<X> _switchResult = null;
			    boolean _matched = false;
			    if (this instanceof Some) {
			      _matched=true;
			      _switchResult = new Some<X>();
			    }
			    if (!_matched) {
			      if (this instanceof None) {
			        _matched=true;
			        _switchResult = new None<X>();
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testBug383551_02() {
		assertCompilesTo('''
			abstract class C<C_T> {
			  def <X> C<X> m() { switch this {
			    E<C_T> : new E<X>
			  }}
			}
			class D<D_T> extends C<D_T> {}
			class E<E_T> extends D<E_T> {}
		''', '''
			@SuppressWarnings("all")
			public abstract class C<C_T extends Object> {
			  public <X extends Object> C<X> m() {
			    E<X> _switchResult = null;
			    boolean _matched = false;
			    if (this instanceof E) {
			      _matched=true;
			      _switchResult = new E<X>();
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test def void testBug362285_01() {
		'''
			public class C<T> {
				def m() {
					[T x|x].apply(null)
				}	
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;

			@SuppressWarnings("all")
			public class C<T extends Object> {
			  public T m() {
			    final Function1<T, T> _function = new Function1<T, T>() {
			      public T apply(final T x) {
			        return x;
			      }
			    };
			    return _function.apply(null);
			  }
			}
		''')
	}
	
	@Test def void testBug362285_02() {
		'''
			public class C {
				def <T> m() {
					[T x|x].apply(null)
				}	
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> T m() {
			    final Function1<T, T> _function = new Function1<T, T>() {
			      public T apply(final T x) {
			        return x;
			      }
			    };
			    return _function.apply(null);
			  }
			}
		''')
	}
	
	@Test def void testBug380525_01() {
		'''
			abstract class L<E> extends java.util.AbstractList<E> {
				protected new() {
					new Object() => [add(it as E) && remove]
				}
			}
		'''.assertCompilesTo('''
			import java.util.AbstractList;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public abstract class L<E extends Object> extends AbstractList<E> {
			  protected L() {
			    Object _object = new Object();
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			        boolean _and = false;
			        boolean _add = L.this.add(((E) it));
			        if (!_add) {
			          _and = false;
			        } else {
			          boolean _remove = L.this.remove(it);
			          _and = _remove;
			        }
			      }
			    };
			    ObjectExtensions.<Object>operator_doubleArrow(_object, _function);
			  }
			}
		''')
	}
	
	@Test def void testBug380525_02() {
		'''
			abstract class L<E> extends java.util.AbstractList<E> {
				protected new(E e) {
					e => [add && remove]
				}
			}
		'''.assertCompilesTo('''
			import java.util.AbstractList;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public abstract class L<E extends Object> extends AbstractList<E> {
			  protected L(final E e) {
			    final Procedure1<E> _function = new Procedure1<E>() {
			      public void apply(final E it) {
			        boolean _and = false;
			        boolean _add = L.this.add(it);
			        if (!_add) {
			          _and = false;
			        } else {
			          boolean _remove = L.this.remove(it);
			          _and = _remove;
			        }
			      }
			    };
			    ObjectExtensions.<E>operator_doubleArrow(e, _function);
			  }
			}
		''')
	}
	
	@Test def void testBug400433_01() {
		'''
			class Test<T> {
				new(()=>T arg) {}
				static def <P> newInstance(()=>P arg) { new Test(arg) }
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Test(final Function0<? extends T> arg) {
			  }
			  
			  public static <P extends Object> Test<P> newInstance(final Function0<? extends P> arg) {
			    return new Test<P>(arg);
			  }
			}
		''')
	}
	
	@Test
	def testBug380060() { 
		assertCompilesTo('''
			class Foo<T> {
			    def static void main(String[] args) {
			        new Foo()
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public static void main(final String[] args) {
			    new Foo<Object>();
			  }
			}
		''')
	}
	
	@Test
	def testBug372864() { 
		assertCompilesTo('''
			class Foo {
				def protected String testSwitch(Object e) {
				    switch e {
				       String : return ""
				       default: null
				    }
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo {
			  protected String testSwitch(final Object e) {
			    Object _switchResult = null;
			    boolean _matched = false;
			    if (e instanceof String) {
			      _matched=true;
			      return "";
			    }
			    if (!_matched) {
			      _switchResult = null;
			    }
			    return ((String)_switchResult);
			  }
			}
		''')
	}
	
	@Test
	def testBug373482() {
		assertCompilesTo(
			'''
				class X {
					def method() «"'''«"»logSomething«"»'''"»
					def void logSomething() {println("zonk")}
				}
			''', '''
				import org.eclipse.xtend2.lib.StringConcatenation;
				import org.eclipse.xtext.xbase.lib.InputOutput;
				
				@SuppressWarnings("all")
				public class X {
				  public CharSequence method() {
				    StringConcatenation _builder = new StringConcatenation();
				    this.logSomething();
				    return _builder;
				  }
				  
				  public void logSomething() {
				    InputOutput.<String>println("zonk");
				  }
				}
			''')
	}
	
	@Test def void testBug380058_01() {
		val wasUseJavaCompiler = useJavaCompiler
		try {
			useJavaCompiler = false
			'''
				import bug380058.Amount
				
				import static bug380058.SI.*
				
				class JScienceTest {
				    def test() { 
				        val w = Amount::valueOf(100, MILLIMETER)
				        val h = Amount::valueOf(50, MILLIMETER)
				        val perim = w.plus(h).times(2)
				        println(perim)
				    }
				}
			'''.assertCompilesTo('''
				import bug380058.Amount;
				import bug380058.Length;
				import bug380058.SI;
				import org.eclipse.xtext.xbase.lib.InputOutput;
				
				@SuppressWarnings("all")
				public class JScienceTest {
				  public Amount<Length> test() {
				    Amount<Length> _xblockexpression = null;
				    {
				      final Amount<Length> w = Amount.<Length>valueOf(100, SI.MILLIMETER);
				      final Amount<Length> h = Amount.<Length>valueOf(50, SI.MILLIMETER);
				      Amount<Length> _plus = w.plus(h);
				      final Amount<Length> perim = _plus.times(2);
				      _xblockexpression = InputOutput.<Amount<Length>>println(perim);
				    }
				    return _xblockexpression;
				  }
				}
			''')
		} finally {
			useJavaCompiler = wasUseJavaCompiler
		}
	}
	
	@Test def void testBug380059_01() {
		'''
			class C<T> {
				def m() {
					val C<?> c = this
					c
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C<T extends Object> {
			  public C<?> m() {
			    C<?> _xblockexpression = null;
			    {
			      final C<?> c = this;
			      _xblockexpression = c;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	/*
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=380062
	 */
	@Test def testBug380062_01() {
		assertCompilesTo('''
			class Foo<T> {
			    def foo(Foo ^new) {
			        foo(^new)
			    }
			}
		''','''
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public Object foo(final Foo new_) {
			    return this.foo(new_);
			  }
			}
		''')
	}
	
	@Test def testBug380062_01_b() {
		assertCompilesTo('''
			class Foo<T> {
			    def Object foo(Foo ^new) {
			        foo(^new)
			    }
			}
		''','''
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public Object foo(final Foo new_) {
			    return this.foo(new_);
			  }
			}
		''')
	}
	
	@Test def testBug380062_02() {
		assertCompilesTo('''
			class Foo<T> {
				val String s
			    new(String ^new) {
			        s = ^new
			    }
			}
		''','''
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  private final String s;
			  
			  public Foo(final String new_) {
			    this.s = new_;
			  }
			}
		''')
	}
	
	@Test def testBug381201_01() {
		'''
			@Data class Foo {
				static String staticField
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private static String staticField;
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			}
		''')
	}
	
	@Test def testBug381201_02() {
		'''
			@Data class Foo {
				static String staticField
				String nonStaticField
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private static String staticField;
			  
			  private final String _nonStaticField;
			  
			  public Foo(final String nonStaticField) {
			    super();
			    this._nonStaticField = nonStaticField;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this._nonStaticField== null) ? 0 : this._nonStaticField.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (this._nonStaticField == null) {
			      if (other._nonStaticField != null)
			        return false;
			    } else if (!this._nonStaticField.equals(other._nonStaticField))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public String getNonStaticField() {
			    return this._nonStaticField;
			  }
			}
		''')
	}
	
	@Test def testBug383568() {
		'''
			@Data class UsesExtension {
			  extension String
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.Extension;
			import org.eclipse.xtext.xbase.lib.Pure;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class UsesExtension {
			  @Extension
			  private final String __string;
			  
			  public UsesExtension(final String _string) {
			    super();
			    this.__string = _string;
			  }
			  
			  @Override
			  @Pure
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((this.__string== null) ? 0 : this.__string.hashCode());
			    return result;
			  }
			  
			  @Override
			  @Pure
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    UsesExtension other = (UsesExtension) obj;
			    if (this.__string == null) {
			      if (other.__string != null)
			        return false;
			    } else if (!this.__string.equals(other.__string))
			      return false;
			    return true;
			  }
			  
			  @Override
			  @Pure
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			  
			  @Pure
			  public String get_string() {
			    return this.__string;
			  }
			}
		''')
	}
	
	/*
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=391077
	 */
	@Test def void testBug391077() {
		assertCompilesTo('''
			class TestError {
			    def Void voidObjectReturned() {
			    }
			    
			    def void sampleMethod() {
			        try {
			            voidObjectReturned
			        } catch (Exception e) {
			            Integer::parseInt('1')
			        }
			    }
			}
		''','''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class TestError {
			  public Void voidObjectReturned() {
			    return null;
			  }
			  
			  public void sampleMethod() {
			    try {
			      this.voidObjectReturned();
			    } catch (final Throwable _t) {
			      if (_t instanceof Exception) {
			        final Exception e = (Exception)_t;
			        Integer.parseInt("1");
			      } else {
			        throw Exceptions.sneakyThrow(_t);
			      }
			    }
			  }
			}
		''')
	}
	
	@Test def testBug399527() throws Exception {
		'''
			class Y {
			 static def <T> IExpectationSetters<T> expect(T value) {
			 }
			 HeaderAccess<?> unboundedMockHeaderAccess
			 def test() {
			   val Object header = unboundedMockHeaderAccess.header
			   val IExpectationSetters<Object> exp1 = expect(header)
			   val IExpectationSetters<Object> exp2 = expect(unboundedMockHeaderAccess.getHeader())
			 }
			}
			interface HeaderAccess<T> {
			   def T getHeader();
			}
			interface IExpectationSetters<T> {}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Y {
			  public static <T extends Object> IExpectationSetters<T> expect(final T value) {
			    return null;
			  }
			  
			  private HeaderAccess<?> unboundedMockHeaderAccess;
			  
			  public void test() {
			    final Object header = this.unboundedMockHeaderAccess.getHeader();
			    final IExpectationSetters<Object> exp1 = Y.<Object>expect(header);
			    Object _header = this.unboundedMockHeaderAccess.getHeader();
			    final IExpectationSetters<Object> exp2 = Y.<Object>expect(_header);
			  }
			}
		''')
	}
	
	@Test def testBug399975_01() throws Exception {
		'''
			class A {
			 def void m(Class<?>[] c) {}
			}
			class B extends A{
			 override m(Class<? extends Object>[] c) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class A {
			  public void m(final Class<?>[] c) {
			  }
			}
		''')
	}
	
	@Test def testBug399975_02() throws Exception {
		'''
			class B extends A{
			 override m(Class<? extends Object>[] c) {}
			}
			class A {
			 def void m(Class<?>[] c) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B extends A {
			  public void m(final Class<?>[] c) {
			  }
			}
		''')
	}
	
	@Test def testBug399975_03() throws Exception {
		'''
			class A {
			 def void m(Class<?>... c) {}
			}
			class B extends A{
			 override m(Class<? extends Object>... c) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class A {
			  public void m(final Class<?>... c) {
			  }
			}
		''')
	}
	
	@Test def testBug399975_04() throws Exception {
		'''
			class B extends A{
			 override m(Class<? extends Object>... c) {}
			}
			class A {
			 def void m(Class<?>... c) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B extends A {
			  public void m(final Class<?>... c) {
			  }
			}
		''')
	}
	
	@Test def void testBug400347_01() {
		'''
			import java.util.LinkedList
			
			interface XType {}
			
			class XItem<T extends XType> {
				XList<T> gen
				T item
				
				new(XList<T> gen, T item) {
					this.gen = gen
					this.item = item
				}
			}
			
			class XList<T extends XType> {
				val items = new LinkedList<XItem<T>>
				
				def add(T item) {
					val result = new XItem<T>(this, item)
					items.add(result)
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public interface XType {
			}
		''')
	}
	
	@Test def void testBug400347_02() {
		'''
			import java.util.LinkedList
			
			class XItem<T extends XType> {
				XList<T> gen
				T item
				
				new(XList<T> gen, T item) {
					this.gen = gen
					this.item = item
				}
			}
			
			interface XType {}
			
			class XList<T extends XType> {
				val items = new LinkedList<XItem<T>>
				
				def add(T item) {
					val result = new XItem<T>(this, item)
					items.add(result)
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class XItem<T extends XType> {
			  private XList<T> gen;
			  
			  private T item;
			  
			  public XItem(final XList<T> gen, final T item) {
			    this.gen = gen;
			    this.item = item;
			  }
			}
		''')
	}
	
	@Test def void testBug400347_03() {
		'''
			import java.util.LinkedList
			
			class XList<T extends XType> {
				val items = new LinkedList<XItem<T>>
				
				def add(T item) {
					val result = new XItem<T>(this, item)
					items.add(result)
				}
			}
			
			interface XType {}
			
			class XItem<T extends XType> {
				XList<T> gen
				T item
				
				new(XList<T> gen, T item) {
					this.gen = gen
					this.item = item
				}
			}
		'''.assertCompilesTo('''
			import java.util.LinkedList;
			
			@SuppressWarnings("all")
			public class XList<T extends XType> {
			  private final LinkedList<XItem<T>> items = new LinkedList<XItem<T>>();
			  
			  public boolean add(final T item) {
			    boolean _xblockexpression = false;
			    {
			      final XItem<T> result = new XItem<T>(this, item);
			      _xblockexpression = this.items.add(result);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

	@Test def void testBug400823_01() {
		'''
			package test.plugin
			import static extension test.plugin.Foo.*
			class Foo {
				def foo() {
					this - this
				}
				def static operator_minus(Foo x, Foo y) {
					1
				}
			}
		'''.assertCompilesTo('''
			package test.plugin;
			
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    return Foo.operator_minus(this, this);
			  }
			  
			  public static int operator_minus(final Foo x, final Foo y) {
			    return 1;
			  }
			}
		''')
	}
	
	@Test def void testBug400823_02() {
		'''
			package test.plugin
			import static extension test.plugin.Foo.*
			class Foo {
				def foo() {
					this - this
				}
				def static -(Foo x, Foo y) {
					1
				}
			}
		'''.assertCompilesTo('''
			package test.plugin;
			
			@SuppressWarnings("all")
			public class Foo {
			  public int foo() {
			    return Foo.operator_minus(this, this);
			  }
			  
			  public static int operator_minus(final Foo x, final Foo y) {
			    return 1;
			  }
			}
		''')
	}

	@Test def void testBug401269_01() {
		'''
			import java.util.Map
			import java.util.List
			import java.util.ArrayList
			class C {
				def <A> Map<A, Iterable<A>> then(Iterable<A> iter) {
					null
				}	
				def <A extends Number & Comparable<?>> Map<A, List<A>> then(List<A> expr) {
					null
				}
				def client(ArrayList<Long> arrayList) {
					val plainInvocation = then(arrayList)
					plainInvocation.toString
					val extensionInvocation = arrayList.then
					extensionInvocation.toString
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.List;
			import java.util.Map;
			
			@SuppressWarnings("all")
			public class C {
			  public <A extends Object> Map<A, Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A, List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final ArrayList<Long> arrayList) {
			    String _xblockexpression = null;
			    {
			      final Map<Long, List<Long>> plainInvocation = this.<Long>then(arrayList);
			      plainInvocation.toString();
			      final Map<Long, List<Long>> extensionInvocation = this.<Long>then(arrayList);
			      _xblockexpression = extensionInvocation.toString();
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void testBug401269_02() {
		'''
			import java.util.Map
			import java.util.List
			class C {
				def <A> Map<A, Iterable<A>> then(Iterable<A> iter) {
					null
				}	
				def <A extends Number & Comparable<?>> Map<A, List<A>> then(List<A> expr) {
					null
				}
				def client(Iterable<Long> iterable) {
					val plainInvocation = then(iterable)
					plainInvocation.toString
					val extensionInvocation = iterable.then
					extensionInvocation.toString
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.Map;
			
			@SuppressWarnings("all")
			public class C {
			  public <A extends Object> Map<A, Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A, List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final Iterable<Long> iterable) {
			    String _xblockexpression = null;
			    {
			      final Map<Long, Iterable<Long>> plainInvocation = this.<Long>then(iterable);
			      plainInvocation.toString();
			      final Map<Long, Iterable<Long>> extensionInvocation = this.<Long>then(iterable);
			      _xblockexpression = extensionInvocation.toString();
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void testBug401269_03() {
		'''
			import java.util.Map
			import java.util.List
			import java.util.LinkedList
			class C {
				def <A> Map<A, Iterable<A>> then(Iterable<A> iter) {
					null
				}	
				def <A extends Number & Comparable<?>> Map<A, List<A>> then(List<A> expr) {
					null
				}
				def client(LinkedList<String> linkedList) {
					val plainInvocation = then(linkedList)
					plainInvocation.toString
					val extensionInvocation = linkedList.then
					extensionInvocation.toString
				}
			}
		'''.assertCompilesTo('''
			import java.util.LinkedList;
			import java.util.List;
			import java.util.Map;
			
			@SuppressWarnings("all")
			public class C {
			  public <A extends Object> Map<A, Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A, List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final LinkedList<String> linkedList) {
			    String _xblockexpression = null;
			    {
			      final Map<String, Iterable<String>> plainInvocation = this.<String>then(linkedList);
			      plainInvocation.toString();
			      final Map<String, Iterable<String>> extensionInvocation = this.<String>then(linkedList);
			      _xblockexpression = extensionInvocation.toString();
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void testBug401269_04() {
		'''
			import java.util.Map
			import java.util.List
			import java.util.Set
			class C {
				def <A> Map<A, Iterable<A>> then(Iterable<A> iter) {
					null
				}	
				def <A extends Number & Comparable<?>> Map<A, List<A>> then(List<A> expr) {
					null
				}
				def client(Set<Integer> set) {
					val plainInvocation = then(set)
					plainInvocation.toString
					val extensionInvocation = set.then
					extensionInvocation.toString
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.Map;
			import java.util.Set;
			
			@SuppressWarnings("all")
			public class C {
			  public <A extends Object> Map<A, Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A, List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final Set<Integer> set) {
			    String _xblockexpression = null;
			    {
			      final Map<Integer, Iterable<Integer>> plainInvocation = this.<Integer>then(set);
			      plainInvocation.toString();
			      final Map<Integer, Iterable<Integer>> extensionInvocation = this.<Integer>then(set);
			      _xblockexpression = extensionInvocation.toString();
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void testBug401269_05() {
		'''
			import java.util.Map
			class C {
				def <A> Map<A, Expression<A>> then(Expression<A> expr) {}
				def <A extends Number & Comparable<?>> Map<A, NumberExpression<A>> then(NumberExpression<A> expr) {}
				
				def void m() {
					val NumberPath<Long> count = null
					val y = then(count)
					println(y)
				}
			}
			
			class NumberPath<T extends Number & Comparable<?>> extends NumberExpression<T> {}
			class NumberExpression<T extends Number & Comparable<?>> extends ComparableExpressionBase<T> {}
			class ComparableExpressionBase<T extends Comparable<?>> extends SimpleExpression<T> {}
			class SimpleExpression<T> extends ExpressionBase<T> {}
			class ExpressionBase<T> implements Expression<T> {}
			interface Expression<T> {}
		'''.assertCompilesTo('''
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class C {
			  public <A extends Object> Map<A, Expression<A>> then(final Expression<A> expr) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A, NumberExpression<A>> then(final NumberExpression<A> expr) {
			    return null;
			  }
			  
			  public void m() {
			    final NumberPath<Long> count = null;
			    final Map<Long, NumberExpression<Long>> y = this.<Long>then(count);
			    InputOutput.<Map<Long, NumberExpression<Long>>>println(y);
			  }
			}
		''')
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=415849
	 */
	@Test def void testBug415849() {
		'''
			public class Bug {
				String text
				def handleEvent(Bug e) {
					e?.text == this?.text
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			
			@SuppressWarnings("all")
			public class Bug {
			  private String text;
			  
			  public boolean handleEvent(final Bug e) {
			    String _text = null;
			    if (e!=null) {
			      _text=e.text;
			    }
			    String _text_1 = null;
			    if (this!=null) {
			      _text_1=this.text;
			    }
			    return Objects.equal(_text, _text_1);
			  }
			}
		''')
	}
	
	@Test def void testBug415849_1() {
		'''
			public class Bug {
				String text
				def handleEvent(Bug e) {
					e?.text
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Bug {
			  private String text;
			  
			  public String handleEvent(final Bug e) {
			    String _text = null;
			    if (e!=null) {
			      _text=e.text;
			    }
			    return _text;
			  }
			}
		''')
	}
	
	@Test
	def testBug410990() {
		assertCompilesTo('''
			class Bug {
				def bug(Foo foo) {}
				def bug(Bar bar) {}
				
				def test() {
					bug [Foo foo | foo.foo(foo)]
					bug [Bar bar | bar.bar(bar)] // closure is typed as Foo instead of Bar
				}
			}
			
			interface Foo {
				def void foo(Foo foo) 
			}
			
			interface Bar {
				def void bar(Bar bar)
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public Object bug(final Foo foo) {
			    return null;
			  }
			  
			  public Object bug(final Bar bar) {
			    return null;
			  }
			  
			  public Object test() {
			    Object _xblockexpression = null;
			    {
			      final Foo _function = new Foo() {
			        public void foo(final Foo foo) {
			          foo.foo(foo);
			        }
			      };
			      this.bug(_function);
			      final Bar _function_1 = new Bar() {
			        public void bar(final Bar bar) {
			          bar.bar(bar);
			        }
			      };
			      _xblockexpression = this.bug(_function_1);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}

}