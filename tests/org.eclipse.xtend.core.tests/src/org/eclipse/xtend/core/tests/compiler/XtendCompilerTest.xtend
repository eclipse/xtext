/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.xbase.compiler.DisableCodeGenerationAdapter
import org.eclipse.xtext.xbase.compiler.GeneratorConfig
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import org.junit.Test
import org.junit.Ignore

class XtendCompilerTest extends AbstractXtendTestCase {
	
	@Inject JvmModelGenerator generator
	@Inject IGeneratorConfigProvider generatorConfigProvider
	
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
	
	/**
	 * Do not throw an exception for inherited dispatch methods.
	 */
	@Test
	def testInheritedDispatchMethods_01() {
		assertCompilesTo('''
			class C {
				def dispatch testFunction1(String s) {
					s.length
				}
				def dispatch testFunction1(Integer i) {
					i.intValue
				}
			}
			class D extends C {
				def dispatch testFunction1(Double d) {
					d.intValue
				}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected int _testFunction1(final String s) {
			    int _length = s.length();
			    return _length;
			  }
			  
			  protected int _testFunction1(final Integer i) {
			    int _intValue = i.intValue();
			    return _intValue;
			  }
			  
			  public int testFunction1(final Object i) {
			    if (i instanceof Integer) {
			      return _testFunction1((Integer)i);
			    } else if (i instanceof String) {
			      return _testFunction1((String)i);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(i).toString());
			    }
			  }
			}
		''')
	}
	
	@Ignore("TODO")
	@Test
	def testInheritedDispatchMethods_02() {
		assertCompilesTo('''
			class D extends C {
				def dispatch testFunction1(Double d) {
					d.intValue
				}
			}
			class C {
				def dispatch testFunction1(String s) {
					s.length
				}
				def dispatch testFunction1(Integer i) {
					i.intValue
				}
			}
		''', '''
			TODO
		''')
	}
	
	@Ignore("TODO")
	@Test
	def testInheritedDispatchMethods_03() {
		assertCompilesTo('''
			class D extends C {
				def dispatch testFunction1(Double d) {
					d.intValue
				}
				def dispatch testFunction1(Number n) {
					n.intValue
				}
			}
			class C {
				def dispatch testFunction1(String s) {
					s.length
				}
				def dispatch testFunction1(Integer i) {
					i.intValue
				}
			}
		''', '''
			TODO
		''')
	}
	
	@Test def void testExtensionForArrayOfT_01() {
		'''
			class C {
				def m1() {
					val String[] chars = newArrayList('foo','bar')
					chars.at(2)
				}
				def m2() {
					newArrayList('foo','bar').at(2)
				}
				def m3() {
					newArrayList('foo','bar') => [ at(2) ]
				}
				def <T> T at(T[] obj, int index) {
					return obj.get(index)
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public String m1() {
			    String _xblockexpression = null;
			    {
			      final String[] chars = ((String[])Conversions.unwrapArray(CollectionLiterals.<String>newArrayList("foo", "bar"), String.class));
			      String _at = this.<String>at(chars, 2);
			      _xblockexpression = (_at);
			    }
			    return _xblockexpression;
			  }
			  
			  public String m2() {
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar");
			    String _at = this.<String>at(((String[])Conversions.unwrapArray(_newArrayList, String.class)), 2);
			    return _at;
			  }
			  
			  public ArrayList<String> m3() {
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("foo", "bar");
			    final Procedure1<ArrayList<String>> _function = new Procedure1<ArrayList<String>>() {
			        public void apply(final ArrayList<String> it) {
			          C.this.<String>at(((String[])Conversions.unwrapArray(it, String.class)), 2);
			        }
			      };
			    ArrayList<String> _doubleArrow = ObjectExtensions.<ArrayList<String>>operator_doubleArrow(_newArrayList, _function);
			    return _doubleArrow;
			  }
			  
			  public <T extends Object> T at(final T[] obj, final int index) {
			    return obj[index];
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
			  public <A extends Object> Map<A,Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A,List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final ArrayList<Long> arrayList) {
			    String _xblockexpression = null;
			    {
			      final Map<Long,List<Long>> plainInvocation = this.<Long>then(arrayList);
			      plainInvocation.toString();
			      final Map<Long,List<Long>> extensionInvocation = this.<Long>then(arrayList);
			      String _string = extensionInvocation.toString();
			      _xblockexpression = (_string);
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
			  public <A extends Object> Map<A,Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A,List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final Iterable<Long> iterable) {
			    String _xblockexpression = null;
			    {
			      final Map<Long,Iterable<Long>> plainInvocation = this.<Long>then(iterable);
			      plainInvocation.toString();
			      final Map<Long,Iterable<Long>> extensionInvocation = this.<Long>then(iterable);
			      String _string = extensionInvocation.toString();
			      _xblockexpression = (_string);
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
			  public <A extends Object> Map<A,Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A,List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final LinkedList<String> linkedList) {
			    String _xblockexpression = null;
			    {
			      final Map<String,Iterable<String>> plainInvocation = this.<String>then(linkedList);
			      plainInvocation.toString();
			      final Map<String,Iterable<String>> extensionInvocation = this.<String>then(linkedList);
			      String _string = extensionInvocation.toString();
			      _xblockexpression = (_string);
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
			  public <A extends Object> Map<A,Iterable<A>> then(final Iterable<A> iter) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A,List<A>> then(final List<A> expr) {
			    return null;
			  }
			  
			  public String client(final Set<Integer> set) {
			    String _xblockexpression = null;
			    {
			      final Map<Integer,Iterable<Integer>> plainInvocation = this.<Integer>then(set);
			      plainInvocation.toString();
			      final Map<Integer,Iterable<Integer>> extensionInvocation = this.<Integer>then(set);
			      String _string = extensionInvocation.toString();
			      _xblockexpression = (_string);
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
			  public <A extends Object> Map<A,Expression<A>> then(final Expression<A> expr) {
			    return null;
			  }
			  
			  public <A extends Number & Comparable<?>> Map<A,NumberExpression<A>> then(final NumberExpression<A> expr) {
			    return null;
			  }
			  
			  public void m() {
			    final NumberPath<Long> count = null;
			    final Map<Long,NumberExpression<Long>> y = this.<Long>then(count);
			    InputOutput.<Map<Long,NumberExpression<Long>>>println(y);
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
			    int _minus = Foo.operator_minus(this, this);
			    return _minus;
			  }
			  
			  public static int operator_minus(final Foo x, final Foo y) {
			    return 1;
			  }
			}
		''')
	}
	
	@Test def void testBug380058_01() {
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
			      Amount<Length> _println = InputOutput.<Amount<Length>>println(perim);
			      _xblockexpression = (_println);
			    }
			    return _xblockexpression;
			  }
			}
		''')
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
			  public C<? extends Object> m() {
			    C<? extends Object> _xblockexpression = null;
			    {
			      final C<?> c = this;
			      _xblockexpression = (c);
			    }
			    return _xblockexpression;
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
			    final Function1<T,T> _function = new Function1<T,T>() {
			        public T apply(final T x) {
			          return x;
			        }
			      };
			    T _apply = _function.apply(null);
			    return _apply;
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
			    final Function1<T,T> _function = new Function1<T,T>() {
			        public T apply(final T x) {
			          return x;
			        }
			      };
			    T _apply = _function.apply(null);
			    return _apply;
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
			            _and = (_add && _remove);
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
			            _and = (_add && _remove);
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
			    Test<P> _test = new Test<P>(arg);
			    return _test;
			  }
			}
		''')
	}
	
	@Test def void testForLoopWithTypeParameter_01() {
		'''
			class C<T extends CharSequence> {
				def void m(Iterable<T> iter) {
					for(x: iter) {
						x.charAt(1)
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C<T extends CharSequence> {
			  public void m(final Iterable<T> iter) {
			    for (final T x : iter) {
			      x.charAt(1);
			    }
			  }
			}
		''')
	}
	
	@Test def void testForLoopWithTypeParameter_02() {
		'''
			class C {
				def <T extends CharSequence> void m(Iterable<T> iter) {
					for(x: iter) {
						x.charAt(1)
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public <T extends CharSequence> void m(final Iterable<T> iter) {
			    for (final T x : iter) {
			      x.charAt(1);
			    }
			  }
			}
		''')
	}
	
	@Test def void testForLoopWithTypeParameter_03() {
		'''
			class C<T extends CharSequence> {
				def <L extends Iterable<T>> void m(L iter) {
					for(x: iter) {
						x.charAt(1)
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C<T extends CharSequence> {
			  public <L extends Iterable<T>> void m(final L iter) {
			    for (final T x : iter) {
			      x.charAt(1);
			    }
			  }
			}
		''')
	}
	
	@Test def void testForLoopWithTypeParameter_04() {
		'''
			abstract class C<T extends CharSequence> implements Iterable<T> {
				def void m() {
					for(x: this) {
						x.charAt(1)
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public abstract class C<T extends CharSequence> implements Iterable<T> {
			  public void m() {
			    for (final T x : this) {
			      x.charAt(1);
			    }
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
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class XList<T extends XType> {
			  private final LinkedList<XItem<T>> items = new Function0<LinkedList<XItem<T>>>() {
			    public LinkedList<XItem<T>> apply() {
			      LinkedList<XItem<T>> _linkedList = new LinkedList<XItem<T>>();
			      return _linkedList;
			    }
			  }.apply();
			  
			  public boolean add(final T item) {
			    boolean _xblockexpression = false;
			    {
			      XItem<T> _xItem = new XItem<T>(this, item);
			      final XItem<T> result = _xItem;
			      boolean _add = this.items.add(result);
			      _xblockexpression = (_add);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_01() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def String m(Pair<String, String> in) {
			    	(''->'').m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final Pair<String,String> in) {
			    Pair<String,String> _mappedTo = Pair.<String, String>of("", "");
			    String _m = this.m(_mappedTo);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_02() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def String m(Pair<String, String> in) {
			    	(null->null).m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final Pair<String,String> in) {
			    Pair<String,String> _mappedTo = Pair.<String, String>of(null, null);
			    String _m = this.m(_mappedTo);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_03() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def String m(Pair<String, String> in) {
			    	in.m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final Pair<String,String> in) {
			    String _m = this.m(in);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_04() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def <T> T m(Pair<T, T> in) {
			    	in.m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> T m(final Pair<T,T> in) {
			    T _m = this.<T>m(in);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_05() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def <T> T m(Pair<T, T> in) {
			    	(null->null).m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> T m(final Pair<T,T> in) {
			    Pair<T,T> _mappedTo = Pair.<T, T>of(null, null);
			    T _m = this.<T>m(_mappedTo);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_06() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def <T> String m(Pair<T, T> in) {
			    	(''->'').m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> String m(final Pair<T,T> in) {
			    Pair<String,String> _mappedTo = Pair.<String, String>of("", "");
			    String _m = this.<String>m(_mappedTo);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_07() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def <T extends CharSequence> T m(Pair<T, T> in) {
			    	in.m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends CharSequence> T m(final Pair<T,T> in) {
			    T _m = this.<T>m(in);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_08() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def <T extends CharSequence> T m(Pair<T, T> in) {
			    	(null->null).m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends CharSequence> T m(final Pair<T,T> in) {
			    Pair<T,T> _mappedTo = Pair.<T, T>of(null, null);
			    T _m = this.<T>m(_mappedTo);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_09() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def String m(Pair<String, String> in) {
			    	(""->«"''''''"»).m
				}
			}
		''', '''
			import org.eclipse.xtend2.lib.StringConcatenation;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final Pair<String,String> in) {
			    StringConcatenation _builder = new StringConcatenation();
			    Pair<String,String> _mappedTo = Pair.<String, String>of("", _builder.toString());
			    String _m = this.m(_mappedTo);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_10() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def <T> String m(Pair<T, T> it) {
			    	m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> String m(final Pair<T,T> it) {
			    String _m = this.<T>m(it);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testLocalExtensionForPairStringString_11() {
		assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Pair
			public class C  {
			    def <T> String m(Pair<T, T> it) {
			    	(key->value).m
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public <T extends Object> String m(final Pair<T,T> it) {
			    T _key = it.getKey();
			    T _value = it.getValue();
			    Pair<T,T> _mappedTo = Pair.<T, T>of(_key, _value);
			    String _m = this.<T>m(_mappedTo);
			    return _m;
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoid() {
		assertCompilesTo('''
			public class C  {
			    def m() {
			    	if (false) while(true) ''.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    if (false) {
			      boolean _while = true;
			      while (_while) {
			        "".toString();
			        _while = true;
			      }
			    }
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoidButNonVoidExpectation() {
		assertCompilesTo('''
			public class C  {
			    def m() {
			    	val x = if (false) return;
			    	x
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    Object _xblockexpression = null;
			    {
			      Object _xifexpression = null;
			      if (false) {
			        return;
			      }
			      final Object x = _xifexpression;
			      _xblockexpression = (x);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void testWorkWithArrays_01() {
		assertCompilesTo('''
			public class Foo  {
			    def void doStuff() {
			    	val strings = newArrayOfSize(2)
			    	strings.set(0, 'world')
			    	strings.set(1, 'hello')
			    	println(strings.get(1) + ' ' + strings.get(0))
			    }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void doStuff() {
			    final String[] strings = new String[2];
			    strings[0] = "world";
			    strings[1] = "hello";
			    String _get = strings[1];
			    String _plus = (_get + " ");
			    String _get_1 = strings[0];
			    String _plus_1 = (_plus + _get_1);
			    InputOutput.<String>println(_plus_1);
			  }
			}
		''')
	}
	
	@Test def void testWorkWithArrays_02() {
		assertCompilesTo('''
			public class Foo  {
			    def void doStuff() {
			    	val numbers = newIntArrayOfSize(2)
			    	numbers.set(0, 42)
			    	numbers.set(1, 44)
			    	println(numbers.get(1) + ' ' + numbers.get(0) + ' length : ' + numbers.length)
			    }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void doStuff() {
			    final int[] numbers = new int[2];
			    numbers[0] = 42;
			    numbers[1] = 44;
			    int _get = numbers[1];
			    String _plus = (Integer.valueOf(_get) + " ");
			    int _get_1 = numbers[0];
			    String _plus_1 = (_plus + Integer.valueOf(_get_1));
			    String _plus_2 = (_plus_1 + " length : ");
			    int _length = numbers.length;
			    String _plus_3 = (_plus_2 + Integer.valueOf(_length));
			    InputOutput.<String>println(_plus_3);
			  }
			}
		''')
	}
	
	@Test def void testAbstractIterator_01() {
		assertCompilesTo('''
			import java.util.Iterator
			import com.google.common.collect.AbstractIterator
			public class Foo  {
			    def <T> Iterator<T> skipNulls(Iterator<T> iter) {
			    	val AbstractIterator<T> result = [|
			    		while(iter.hasNext) {
			    			val elem = iter.next
			    			if (elem != null)
			    				return elem
			    		}
			    		return self.endOfData
			    	]
			    	return result
			    }
			}
		''', '''
			import com.google.common.collect.AbstractIterator;
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> iter) {
			    final AbstractIterator<T> _function = new AbstractIterator<T>() {
			        @Override
			        protected T computeNext() {
			          boolean _hasNext = iter.hasNext();
			          boolean _while = _hasNext;
			          while (_while) {
			            {
			              final T elem = iter.next();
			              boolean _notEquals = ObjectExtensions.operator_notEquals(elem, null);
			              if (_notEquals) {
			                return elem;
			              }
			            }
			            boolean _hasNext_1 = iter.hasNext();
			            _while = _hasNext_1;
			          }
			          return this.endOfData();
			        }
			      };
			    final AbstractIterator<T> result = _function;
			    return result;
			  }
			}
		''')
	}
	
	@Test def void testAbstractIterator_02() {
		assertCompilesTo('''
			import com.google.common.collect.AbstractIterator
			public class Foo  {
			    def skipNulls() {
			    	val AbstractIterator<String> result = [|
			    		toString
			    		super.toString
			    		self.toString
			    	]
			    	return result
			    }
			}
		''', '''
			import com.google.common.collect.AbstractIterator;
			
			@SuppressWarnings("all")
			public class Foo {
			  public AbstractIterator<String> skipNulls() {
			    final AbstractIterator<String> _function = new AbstractIterator<String>() {
			        @Override
			        protected String computeNext() {
			          String _xblockexpression = null;
			          {
			            Foo.this.toString();
			            Foo.super.toString();
			            String _string = this.toString();
			            _xblockexpression = (_string);
			          }
			          return _xblockexpression;
			        }
			      };
			    final AbstractIterator<String> result = _function;
			    return result;
			  }
			}
		''')
	}
	
	@Test def void testAbstractIterator_03() {
		assertCompilesTo('''
			import java.util.Iterator
			import com.google.common.collect.AbstractIterator
			public class Foo  {
				def <T> Iterator<T> skipNulls(Iterator<T> iter) {
					val AbstractIterator<T> result = [|
						iter.findFirst [ it != null ] ?: self.endOfData
					]
					return result
				}
			}
		''', '''
			import com.google.common.collect.AbstractIterator;
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IteratorExtensions;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> iter) {
			    final AbstractIterator<T> _function = new AbstractIterator<T>() {
			        @Override
			        protected T computeNext() {
			          T _elvis = null;
			          final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
			              public Boolean apply(final T it) {
			                boolean _notEquals = ObjectExtensions.operator_notEquals(it, null);
			                return Boolean.valueOf(_notEquals);
			              }
			            };
			          T _findFirst = IteratorExtensions.<T>findFirst(iter, _function);
			          if (_findFirst != null) {
			            _elvis = _findFirst;
			          } else {
			            T _endOfData = this.endOfData();
			            _elvis = ObjectExtensions.<T>operator_elvis(_findFirst, _endOfData);
			          }
			          return _elvis;
			        }
			      };
			    final AbstractIterator<T> result = _function;
			    return result;
			  }
			}
		''')
	}
	
	@Test
	def testAbstractIterator_04() { 
		assertCompilesTo(
			'''
				import java.util.Iterator
				import com.google.common.collect.AbstractIterator
				class FindFirstOnIt {

					def <T> Iterator<T> skipNulls(Iterator<T> it) {
						val AbstractIterator<T> result = [|
							findFirst [ it != null ] ?: self.endOfData
						]
						return result
					}
				}
			''', '''
				import com.google.common.collect.AbstractIterator;
				import java.util.Iterator;
				import org.eclipse.xtext.xbase.lib.Functions.Function1;
				import org.eclipse.xtext.xbase.lib.IteratorExtensions;
				import org.eclipse.xtext.xbase.lib.ObjectExtensions;
				
				@SuppressWarnings("all")
				public class FindFirstOnIt {
				  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> it) {
				    final AbstractIterator<T> _function = new AbstractIterator<T>() {
				        @Override
				        protected T computeNext() {
				          T _elvis = null;
				          final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
				              public Boolean apply(final T it) {
				                boolean _notEquals = ObjectExtensions.operator_notEquals(it, null);
				                return Boolean.valueOf(_notEquals);
				              }
				            };
				          T _findFirst = IteratorExtensions.<T>findFirst(it, _function);
				          if (_findFirst != null) {
				            _elvis = _findFirst;
				          } else {
				            T _endOfData = this.endOfData();
				            _elvis = ObjectExtensions.<T>operator_elvis(_findFirst, _endOfData);
				          }
				          return _elvis;
				        }
				      };
				    final AbstractIterator<T> result = _function;
				    return result;
				  }
				}
			''')
	}
	
	@Test def testVoidMethod_01() throws Exception {
		'''
			class A {
				def m() {
					System::out.println('')
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class A {
			  public void m() {
			    System.out.println("");
			  }
			}
		''')
	}
	
	@Test def testVoidMethod_02() throws Exception {
		'''
			class A {
				def m() {
					[ | System::out.println('') ]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

			@SuppressWarnings("all")
			public class A {
			  public Procedure0 m() {
			    final Procedure0 _function = new Procedure0() {
			        public void apply() {
			          System.out.println("");
			        }
			      };
			    return _function;
			  }
			}
		''')
	}
	
	@Test def testVoidMethod_03() throws Exception {
		'''
			class A {
				def m() {
					[ | println('') ]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class A {
			  public Function0<String> m() {
			    final Function0<String> _function = new Function0<String>() {
			        public String apply() {
			          String _println = InputOutput.<String>println("");
			          return _println;
			        }
			      };
			    return _function;
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
			  public void m(final Class<? extends Object>[] c) {
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
			  public void m(final Class<? extends Object>[] c) {
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
			  public void m(final Class<? extends Object>... c) {
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
			  public void m(final Class<? extends Object>... c) {
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
			  
			  private HeaderAccess<? extends Object> unboundedMockHeaderAccess;
			  
			  public void test() {
			    final Object header = this.unboundedMockHeaderAccess.getHeader();
			    final IExpectationSetters<Object> exp1 = Y.<Object>expect(header);
			    Object _header = this.unboundedMockHeaderAccess.getHeader();
			    final IExpectationSetters<Object> exp2 = Y.<Object>expect(_header);
			  }
			}
		''')
	}
	
	@Test def testThrowablesPropagate_01() throws Exception {
		'''
			import static extension Throwables.*
			import java.net.URI
			
			class Throwables {
				def static <T> T propagate(()=>T proc, (Exception)=>Exception handler) {
					try {
						proc.apply
					} catch(Exception e) {
						throw handler.apply(e)
					}
				}
			}
			class Client {
				val uri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
				
				def foo (){
					uri.toString
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Throwables {
			  public static <T extends Object> T propagate(final Function0<? extends T> proc, final Function1<? super Exception,? extends Exception> handler) {
			    try {
			      T _xtrycatchfinallyexpression = null;
			      try {
			        T _apply = proc.apply();
			        _xtrycatchfinallyexpression = _apply;
			      } catch (final Throwable _t) {
			        if (_t instanceof Exception) {
			          final Exception e = (Exception)_t;
			          throw handler.apply(e);
			        } else {
			          throw Exceptions.sneakyThrow(_t);
			        }
			      }
			      return _xtrycatchfinallyexpression;
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test def testThrowablesPropagate_02() throws Exception {
		'''
			import static extension Throwables.*
			import java.net.URI
			
			class Client {
				val uri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
			}
			class Throwables {
				def static <T> T propagate(()=>T proc, (Exception)=>Exception handler) {
					try {
						proc.apply
					} catch(Exception e) {
						throw handler.apply(e)
					}
				}
			}
		'''.assertCompilesTo('''
			import java.net.URI;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Client {
			  private final URI uri = new Function0<URI>() {
			    public URI apply() {
			      final Function0<URI> _function = new Function0<URI>() {
			          public URI apply() {
			            try {
			              URI _uRI = new URI("");
			              return _uRI;
			            } catch (Throwable _e) {
			              throw Exceptions.sneakyThrow(_e);
			            }
			          }
			        };
			      final Function1<Exception,IllegalArgumentException> _function_1 = new Function1<Exception,IllegalArgumentException>() {
			          public IllegalArgumentException apply(final Exception it) {
			            IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(it);
			            return _illegalArgumentException;
			          }
			        };
			      URI _propagate = Throwables.<URI>propagate(_function, _function_1);
			      return _propagate;
			    }
			  }.apply();
			}
		''')
	}
	
	@Test def testAnnotationWithIntArray() throws Exception {
		'''
			class TestXtend {
				val static int a = 4
				
				@Click(#[ a, a ])
				def meth() {}
			}
			
			annotation Click {
				int[] value
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class TestXtend {
			  private final static int a = 4;
			  
			  @Click({TestXtend.a, TestXtend.a})
			  public Object meth() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def testInterface() {
		'''
			interface Foo {
				def int foo()
				int bar=42
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public interface Foo {
			  public abstract int foo();
			  
			  public final static int bar = 42;
			}
		''')
	}
	
	@Test def testEnum() {
		'''
			enum Foo {
				FOO, BAR, BAZ
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public enum Foo {
			  FOO,
			  
			  BAR,
			  
			  BAZ;
			}
		''')
	}
	
	@Test def testSneakyThrowable() {
		'''
			class MyClass {
				def void throwsSomething() {
					throw new Throwable
				}
			}
			
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class MyClass {
			  public void throwsSomething() {
			    try {
			      Throwable _throwable = new Throwable();
			      throw _throwable;
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test def testThreeDataClassesExtendingEachOther() {
		'''
			import java.util.ArrayList
			
			@Data class Node {
				ArrayList<Node> contents = newArrayList
				def String tagName() {
					getClass.simpleName.toLowerCase
				}
			}
			
			@Data class ContentNode extends Node {}
			@Data class Body extends ContentNode {}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Node {
			  private final ArrayList<Node> _contents = new Function0<ArrayList<Node>>() {
			    public ArrayList<Node> apply() {
			      ArrayList<Node> _newArrayList = CollectionLiterals.<Node>newArrayList();
			      return _newArrayList;
			    }
			  }.apply();
			  
			  public ArrayList<Node> getContents() {
			    return this._contents;
			  }
			  
			  public String tagName() {
			    Class<? extends Node> _class = this.getClass();
			    String _simpleName = _class.getSimpleName();
			    String _lowerCase = _simpleName.toLowerCase();
			    return _lowerCase;
			  }
			  
			  public Node() {
			    super();
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_contents== null) ? 0 : _contents.hashCode());
			    return result;
			  }
			  
			  @Override
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Node other = (Node) obj;
			    if (_contents == null) {
			      if (other._contents != null)
			        return false;
			    } else if (!_contents.equals(other._contents))
			      return false;
			    return true;
			  }
			  
			  @Override
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			}
		''')
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=395043
	 */
	@Test def testOverriddenVarArgs() {
		'''
			class B extends A {
				override foo(String x, String...args) {
					return x
				}
			}
			abstract class A {
				def String foo(String x, String...args)
			}
			
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B extends A {
			  public String foo(final String x, final String... args) {
			    return x;
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
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class UsesExtension {
			  private final String __string;
			  
			  public String get_string() {
			    return this.__string;
			  }
			  
			  public UsesExtension(final String _string) {
			    super();
			    this.__string = _string;
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((__string== null) ? 0 : __string.hashCode());
			    return result;
			  }
			  
			  @Override
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    UsesExtension other = (UsesExtension) obj;
			    if (__string == null) {
			      if (other.__string != null)
			        return false;
			    } else if (!__string.equals(other.__string))
			      return false;
			    return true;
			  }
			  
			  @Override
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
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
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final static String staticField;
			  
			  public Foo() {
			    super();
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    return result;
			  }
			  
			  @Override
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
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final static String staticField;
			  
			  private final String _nonStaticField;
			  
			  public String getNonStaticField() {
			    return this._nonStaticField;
			  }
			  
			  public Foo(final String nonStaticField) {
			    super();
			    this._nonStaticField = nonStaticField;
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_nonStaticField== null) ? 0 : _nonStaticField.hashCode());
			    return result;
			  }
			  
			  @Override
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (_nonStaticField == null) {
			      if (other._nonStaticField != null)
			        return false;
			    } else if (!_nonStaticField.equals(other._nonStaticField))
			      return false;
			    return true;
			  }
			  
			  @Override
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			}
		''')
	}
	
	@Test def testItShadowing_01() {
		assertCompilesTo('''
			class Foo<T> {
				def grammar(String it) {
					for (it : it.toCharArray) {
						println(it)
					}
				}
			}
		''','''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public void grammar(final String it) {
			    char[] _charArray = it.toCharArray();
			    for (final char it_1 : _charArray) {
			      InputOutput.<Character>println(Character.valueOf(it_1));
			    }
			  }
			}
		''')
	}
	
	@Test def testItShadowing_02() {
		val tquotes = "'''"
		val lt = '«'
		val rt = '»'
		assertCompilesTo('''
			class Foo<T> {
				def grammar(String it) «tquotes»
					«lt»FOR it: it.toCharArray«rt»
						«lt»it«rt»
					«lt»ENDFOR«rt»
				«tquotes»
			}
		''','''
			import org.eclipse.xtend2.lib.StringConcatenation;
			
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public CharSequence grammar(final String it) {
			    StringConcatenation _builder = new StringConcatenation();
			    {
			      char[] _charArray = it.toCharArray();
			      for(final char it_1 : _charArray) {
			        _builder.append(it_1, "");
			        _builder.newLineIfNotEmpty();
			      }
			    }
			    return _builder;
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
			    Object _foo = this.foo(new_);
			    return _foo;
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
			    Object _foo = this.foo(new_);
			    return _foo;
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
	
	@Test
	def testDataClasses_01() { 
		assertCompilesTo('''
			@Data class Foo {
				String name
				boolean myFlag
				java.lang.Iterable<? extends Foo> references
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name;
			  
			  public String getName() {
			    return this._name;
			  }
			  
			  private final boolean _myFlag;
			  
			  public boolean isMyFlag() {
			    return this._myFlag;
			  }
			  
			  private final Iterable<? extends Foo> _references;
			  
			  public Iterable<? extends Foo> getReferences() {
			    return this._references;
			  }
			  
			  public Foo(final String name, final boolean myFlag, final Iterable<? extends Foo> references) {
			    super();
			    this._name = name;
			    this._myFlag = myFlag;
			    this._references = references;
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
			    result = prime * result + (_myFlag ? 1231 : 1237);
			    result = prime * result + ((_references== null) ? 0 : _references.hashCode());
			    return result;
			  }
			  
			  @Override
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (_name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!_name.equals(other._name))
			      return false;
			    if (other._myFlag != _myFlag)
			      return false;
			    if (_references == null) {
			      if (other._references != null)
			        return false;
			    } else if (!_references.equals(other._references))
			      return false;
			    return true;
			  }
			  
			  @Override
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
			  }
			}
		''')
	}
	@Test
	def testDataClasses_02() { 
		assertCompilesTo('''
			@Data class Foo {
				String name = 'foo'
			}
		''', '''
			import org.eclipse.xtend.lib.Data;
			import org.eclipse.xtext.xbase.lib.util.ToStringHelper;
			
			@Data
			@SuppressWarnings("all")
			public class Foo {
			  private final String _name = "foo";
			  
			  public String getName() {
			    return this._name;
			  }
			  
			  public Foo() {
			    super();
			  }
			  
			  @Override
			  public int hashCode() {
			    final int prime = 31;
			    int result = 1;
			    result = prime * result + ((_name== null) ? 0 : _name.hashCode());
			    return result;
			  }
			  
			  @Override
			  public boolean equals(final Object obj) {
			    if (this == obj)
			      return true;
			    if (obj == null)
			      return false;
			    if (getClass() != obj.getClass())
			      return false;
			    Foo other = (Foo) obj;
			    if (_name == null) {
			      if (other._name != null)
			        return false;
			    } else if (!_name.equals(other._name))
			      return false;
			    return true;
			  }
			  
			  @Override
			  public String toString() {
			    String result = new ToStringHelper().toString(this);
			    return result;
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
			    String _switchResult = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (e instanceof String) {
			        final String _string = (String)e;
			        _matched=true;
			        return "";
			      }
			    }
			    if (!_matched) {
			      _switchResult = null;
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testJavaLangReflectImport() { 
		assertCompilesTo('''
			package foo
			class Bar {
				def void doStuff(java.lang.reflect.Method m) {}
			}
		''', '''
			package foo;

			import java.lang.reflect.Method;
			
			@SuppressWarnings("all")
			public class Bar {
			  public void doStuff(final Method m) {
			  }
			}
		''')
	}
	
	@Test def void testSwitchAsVoid() {
		assertCompilesTo('''
			public class C  {
			    def m(Object a) {
			    	switch a {
			    		case 'b': while(true) ''.toString
			    		case 'c': if (true) return
			    		case 'd': for(i: 1..1) i.toString
			    	}
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.lib.IntegerRange;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final Object a) {
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(a,"b")) {
			        _matched=true;
			        boolean _while = true;
			        while (_while) {
			          "".toString();
			          _while = true;
			        }
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a,"c")) {
			        _matched=true;
			        if (true) {
			          return;
			        }
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a,"d")) {
			        _matched=true;
			        IntegerRange _upTo = new IntegerRange(1, 1);
			        for (final Integer i : _upTo) {
			          i.toString();
			        }
			      }
			    }
			  }
			}
		''')
	}
	
	@Test def void testSwitchWithNonVoidReturn() {
		assertCompilesTo('''
			public class C  {
			    def m(Object a) {
			    	switch a {
			    		case 'b': while(true) ''.toString
			    		case 'c': if (true) return 'a'
			    		case 'd': for(i: 1..1) i.toString
			    	}
				}
			}
		''', '''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.lib.IntegerRange;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final Object a) {
			    String _switchResult = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(a,"b")) {
			        _matched=true;
			        boolean _while = true;
			        while (_while) {
			          "".toString();
			          _while = true;
			        }
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a,"c")) {
			        _matched=true;
			        String _xifexpression = null;
			        if (true) {
			          return "a";
			        }
			        _switchResult = _xifexpression;
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a,"d")) {
			        _matched=true;
			        IntegerRange _upTo = new IntegerRange(1, 1);
			        for (final Integer i : _upTo) {
			          i.toString();
			        }
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchOverNull() {
		assertCompilesTo('''
			public class Foo  {
			    def foo() {
			        switch null {
			            case null : [Object it|it]
			            case null : [Integer it|it]
			        }
			    }    
			}
		''', '''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Function1<? super Integer,? extends Object> foo() {
			    Function1<? super Integer,? extends Object> _switchResult = null;
			    final Object _switchValue = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(_switchValue,null)) {
			        _matched=true;
			        final Function1<Object,Object> _function = new Function1<Object,Object>() {
			            public Object apply(final Object it) {
			              return it;
			            }
			          };
			        _switchResult = _function;
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(_switchValue,null)) {
			        _matched=true;
			        final Function1<Integer,Integer> _function_1 = new Function1<Integer,Integer>() {
			            public Integer apply(final Integer it) {
			              return it;
			            }
			          };
			        _switchResult = _function_1;
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testTryCatch() { 
		assertCompilesTo('''
			package foo
			class Bar {
				def void doStuff(java.lang.reflect.Method m) {
					try {
						// do nothing
					} catch (java.io.IOException e) {
						throw e
					} catch (Exception e) {
						throw e
					} finally {
						// do nothing
					}
				}
			}
		''', '''
			package foo;
			
			import java.io.IOException;
			import java.lang.reflect.Method;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Bar {
			  public void doStuff(final Method m) {
			    try {
			      try {
			      } catch (final Throwable _t) {
			        if (_t instanceof IOException) {
			          final IOException e = (IOException)_t;
			          throw e;
			        } else if (_t instanceof Exception) {
			          final Exception e_1 = (Exception)_t;
			          throw e_1;
			        } else {
			          throw Exceptions.sneakyThrow(_t);
			        }
			      } finally {
			      }
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}

	@Test	
	def testClosureSneakyThrow() {
		assertCompilesTo('''
			import java.io.File
			import java.io.IOException
			import java.util.Collections
			
			class Foo {
			   def bar() {
			       try {
			           newArrayList("file1.ext").map(f| new File(f).canonicalFile)
			       } catch(IOException o) {
			           Collections::<File>emptyList
			       }
			   }
			}
		''','''
			import java.io.File;
			import java.io.IOException;
			import java.util.ArrayList;
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public List<File> bar() {
			    List<File> _xtrycatchfinallyexpression = null;
			    try {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("file1.ext");
			      final Function1<String,File> _function = new Function1<String,File>() {
			          public File apply(final String f) {
			            try {
			              File _file = new File(f);
			              File _canonicalFile = _file.getCanonicalFile();
			              return _canonicalFile;
			            } catch (Throwable _e) {
			              throw Exceptions.sneakyThrow(_e);
			            }
			          }
			        };
			      List<File> _map = ListExtensions.<String, File>map(_newArrayList, _function);
			      _xtrycatchfinallyexpression = _map;
			    } catch (final Throwable _t) {
			      if (_t instanceof IOException) {
			        final IOException o = (IOException)_t;
			        List<File> _emptyList = Collections.<File>emptyList();
			        _xtrycatchfinallyexpression = _emptyList;
			      } else {
			        throw Exceptions.sneakyThrow(_t);
			      }
			    }
			    return _xtrycatchfinallyexpression;
			  }
			}
		''')
	}
	
	@Test
	def testClosureSneakyThrow_02() throws Exception {
		'''
			abstract class Foo {
			 def Object getFoo(String x) throws Exception
			 def bar() {
			   <String>newArrayList.toMap[foo]
			 }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public abstract class Foo {
			  public abstract Object getFoo(final String x) throws Exception;
			  
			  public Map<Object,String> bar() {
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
			    final Function1<String,Object> _function = new Function1<String,Object>() {
			        public Object apply(final String it) {
			          try {
			            Object _foo = Foo.this.getFoo(it);
			            return _foo;
			          } catch (Throwable _e) {
			            throw Exceptions.sneakyThrow(_e);
			          }
			        }
			      };
			    Map<Object,String> _map = IterableExtensions.<Object, String>toMap(_newArrayList, _function);
			    return _map;
			  }
			}
		''')
	}
	
	@Test
	def testFieldInitialization_01() { 
		assertCompilesTo('''
			package foo
			class Bar {
				String s1 = null
				protected String s2 = ''
				public String s3 = s2
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  private String s1 = null;
			  
			  protected String s2 = "";
			  
			  public String s3 = this.s2;
			}
		''')
	}
	
	@Test
	def testFieldInitialization_02() { 
		assertCompilesTo('''
			package foo
			class Bar {
				String s0 = s1
				static String s1 = null
				protected static String s2 = ''
				public static String s3 = s2
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  private String s0 = Bar.s1;
			  
			  private static String s1 = null;
			  
			  protected static String s2 = "";
			  
			  public static String s3 = Bar.s2;
			}
		''')
	}
	
	@Test
	def testFieldInitialization_03() { 
		assertCompilesTo('''
			package foo
			class Bar {
				String s = newArrayList.toString
			}
		''', '''
			package foo;
			
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Bar {
			  private String s = new Function0<String>() {
			    public String apply() {
			      ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			      String _string = _newArrayList.toString();
			      return _string;
			    }
			  }.apply();
			}
		''')
	}
	
	@Test
	def testFieldInitialization_04() { 
		assertCompilesTo('''
			package foo
			class Bar {
				String s = toString + super.toString
			}
		''', '''
			package foo;

			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public class Bar {
			  private String s = new Function0<String>() {
			    public String apply() {
			      String _string = Bar.this.toString();
			      String _string_1 = Bar.super.toString();
			      String _plus = (_string + _string_1);
			      return _plus;
			    }
			  }.apply();
			}
		''')
	}
	
	@Test
	def testConstructorDeclaration_01() { 
		assertCompilesTo('''
			package foo
			class Bar {
				new() {
					super()
				}
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  public Bar() {
			    super();
			  }
			}
		''')
	}
	
	@Test
	def testConstructorDeclaration_02() { 
		assertCompilesTo('''
			package foo
			class Bar {
				new() {
					this(123)
				}
				new(int a) {
					super()
				}
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  public Bar() {
			    this(123);
			  }
			  
			  public Bar(final int a) {
			    super();
			  }
			}
		''')
	}
	
	@Test
	def testConstructorDeclaration_03() { 
		assertCompilesTo('''
			package foo
			class Bar {
				new() {
					this(123.toString)
				}
				new(String s) {}
			}
		''', '''
			package foo;
			
			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public class Bar {
			  public Bar() {
			    this(new Function0<String>() {
			      public String apply() {
			        String _string = Integer.valueOf(123).toString();
			        return _string;
			      }
			    }.apply());
			  }
			  
			  public Bar(final String s) {
			  }
			}
		''')
	}
	
	@Test
	def testSneakyThrow() { 
		assertCompilesTo('''
			package foo
			class Bar {
				def void doStuff() {
					throw new java.io.IOException()
				}
			}
		''', '''
			package foo;

			import java.io.IOException;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Bar {
			  public void doStuff() {
			    try {
			      IOException _iOException = new IOException();
			      throw _iOException;
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test
	def testSneakyThrow_01() { 
		assertCompilesTo('''
			package foo
			
			import java.io.IOException
			
			class Bar {
				def void doStuff() throws IOException {
					throw new IOException()
				}
			}
		''', '''
			package foo;

			import java.io.IOException;
			
			@SuppressWarnings("all")
			public class Bar {
			  public void doStuff() throws IOException {
			    IOException _iOException = new IOException();
			    throw _iOException;
			  }
			}
		''')
	}

	@Test
	def testSimple() { 
		assertCompilesTo('''
			package foo
			class Bar {
				def Integer doStuff(String x) {x.length}
			}
		''', '''
			package foo;
			
			@SuppressWarnings("all")
			public class Bar {
			  public Integer doStuff(final String x) {
			    int _length = x.length();
			    return Integer.valueOf(_length);
			  }
			}
		''')
	}

	@Test
	def testConstructor() { 
		assertCompilesTo('''
			package foo
			class Bar {
				def foo() {new String()}
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  public String foo() {
			    String _string = new String();
			    return _string;
			  }
			}
		''')
	}

	@Test
	def testExtends() {
		assertCompilesTo('''
			package foo
			class Bar extends Thread {
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar extends Thread {
			}
		''')
	}

	@Test
	def testExtendsException() {
		assertCompilesTo('''
			package foo
			
			class NoSuchElementException extends java.util.NoSuchElementException {
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class NoSuchElementException extends java.util.NoSuchElementException {
			}
		''')
	}

	@Test
	def testVisibilityOfDispatchMethods() {
		assertCompilesTo('''
			package foo
			class NoSuchElementException {
				def dispatch void foo(String s) {}
				def dispatch void foo(Object s) {}
			}
		''', '''
			package foo;

			import java.util.Arrays;

			@SuppressWarnings("all")
			public class NoSuchElementException {
			  protected void _foo(final String s) {
			  }
			  
			  protected void _foo(final Object s) {
			  }
			  
			  public void foo(final Object s) {
			    if (s instanceof String) {
			      _foo((String)s);
			      return;
			    } else if (s != null) {
			      _foo(s);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(s).toString());
			    }
			  }
			}
		''')
	}
	
	@Test
	def testParenthesisInDispatchMethodsGuards() {
		assertCompilesTo('''
			package foo
			class MyType {
				def dispatch void foo(String s, CharSequence other) {}
				def dispatch void foo(String s, Void other) {}
				def dispatch void foo(Object s, Object other) {}
			}
		''', '''
			package foo;

			import java.util.Arrays;

			@SuppressWarnings("all")
			public class MyType {
			  protected void _foo(final String s, final CharSequence other) {
			  }
			  
			  protected void _foo(final String s, final Void other) {
			  }
			  
			  protected void _foo(final Object s, final Object other) {
			  }
			  
			  public void foo(final Object s, final Object other) {
			    if (s instanceof String
			         && other instanceof CharSequence) {
			      _foo((String)s, (CharSequence)other);
			      return;
			    } else if (s instanceof String
			         && other == null) {
			      _foo((String)s, (Void)null);
			      return;
			    } else if (s != null
			         && other != null) {
			      _foo(s, other);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(s, other).toString());
			    }
			  }
			}
		''')
	}
	
	@Test
	def testParenthesisInDispatchMethodsGuards_reordered() {
		assertCompilesTo('''
			package foo
			class MyType {
				def dispatch void foo(Object s, Object other) {}
				def dispatch void foo(String s, Void other) {}
				def dispatch void foo(String s, CharSequence other) {}
			}
		''', '''
			package foo;

			import java.util.Arrays;

			@SuppressWarnings("all")
			public class MyType {
			  protected void _foo(final Object s, final Object other) {
			  }
			  
			  protected void _foo(final String s, final Void other) {
			  }
			  
			  protected void _foo(final String s, final CharSequence other) {
			  }
			  
			  public void foo(final Object s, final Object other) {
			    if (s instanceof String
			         && other instanceof CharSequence) {
			      _foo((String)s, (CharSequence)other);
			      return;
			    } else if (s instanceof String
			         && other == null) {
			      _foo((String)s, (Void)null);
			      return;
			    } else if (s != null
			         && other != null) {
			      _foo(s, other);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(s, other).toString());
			    }
			  }
			}
		''')
	}

	@Test
	def testNoUnnecessaryCastInDispatchMethods() {
		assertCompilesTo('''
			package foo
			class MyType {
				def dispatch void foo(StringBuilder s, boolean b, String other) {}
				def dispatch void foo(StringBuffer s, boolean b, String other) {}
			}
		''', '''
			package foo;
			
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class MyType {
			  protected void _foo(final StringBuilder s, final boolean b, final String other) {
			  }
			  
			  protected void _foo(final StringBuffer s, final boolean b, final String other) {
			  }
			  
			  public void foo(final Object s, final boolean b, final String other) {
			    if (s instanceof StringBuffer) {
			      _foo((StringBuffer)s, b, other);
			      return;
			    } else if (s instanceof StringBuilder) {
			      _foo((StringBuilder)s, b, other);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(s, b, other).toString());
			    }
			  }
			}
		''')
	}

	@Test
	def testExtendsArrayList_01()  {
		assertCompilesTo('''
			package foo
			class MyList<T> extends java.util.ArrayList<T> {}
		''', '''
			package foo;
			
			import java.util.ArrayList;
			
			@SuppressWarnings("all")
			public class MyList<T extends Object> extends ArrayList<T> {
			}
		''')
	}

	@Test
	def testExtendsArrayList_02() {
		assertCompilesTo('''
			package foo
			class StringList extends java.util.ArrayList<String> {
			}
		''', '''
			package foo;
			
			import java.util.ArrayList;
			
			@SuppressWarnings("all")
			public class StringList extends ArrayList<String> {
			}
		''')
	}

	@Test
	def testImplements() {
		assertCompilesTo('''
			package foo
			class Bar implements Cloneable, java.io.Serializable {
			}
		''', '''
			package foo;

			import java.io.Serializable;
			
			@SuppressWarnings("all")
			public class Bar implements Cloneable, Serializable {
			}
		''')
	}

	@Test
	def testConstructor_2() {
		assertCompilesTo('''
			package foo
			class Bar {
				def foo() {new java.util.HashMap<String,java.io.Serializable>()}
			}
		''', '''
			package foo;

			import java.io.Serializable;
			import java.util.HashMap;

			@SuppressWarnings("all")
			public class Bar {
			  public HashMap<String,Serializable> foo() {
			    HashMap<String,Serializable> _hashMap = new HashMap<String,Serializable>();
			    return _hashMap;
			  }
			}
		''')
	}

	@Test
	def testAnnotation() {
		assertCompilesTo('''
			package foo
			class Bar {
				@com.google.inject.Inject String string
			}
		''', '''
			package foo;

			import com.google.inject.Inject;

			@SuppressWarnings("all")
			public class Bar {
			  @Inject
			  private String string;
			}
		''')
	}
	
	@Test
	def testAnnotationOnAnnotation() {
		assertCompilesTo('''
			package foo
			@java.lang.annotation.Documented
			annotation Bar {
			    @com.google.inject.Inject String string
			}
		''', '''
			package foo;
			
			import com.google.inject.Inject;
			import java.lang.annotation.Documented;
			
			@Documented
			public @interface Bar {
			  @Inject
			  public String string();
			}
		''')
	}
	
	@Test
	def testSuperCall_01() {
		assertCompilesTo('''
			package x class Y extends Object {
				override boolean equals(Object p){
					if ('foo' == p)
						return true
					else
						super.equals(p) 
				} 
			}
		''', '''
			package x;

			import org.eclipse.xtext.xbase.lib.ObjectExtensions;

			@SuppressWarnings("all")
			public class Y {
			  public boolean equals(final Object p) {
			    boolean _xifexpression = false;
			    boolean _equals = ObjectExtensions.operator_equals("foo", p);
			    if (_equals) {
			      return true;
			    } else {
			      boolean _equals_1 = super.equals(p);
			      _xifexpression = _equals_1;
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test
	def testSuperCall_02() {
		assertCompilesTo('''
			package x
			class A {
				def String getThing() {
					this.getThing('')
					''.getThing
					this.thing
					''.thing
					thing
					getThing('')
				}
				def protected String getThing(String s) {
					return s
				}
			}
			class B extends A {
				override getThing() {
					if (true)
						return super.getThing
					return getThing('')
				}
			}
		''', '''
			package x;
			
			@SuppressWarnings("all")
			public class A {
			  public String getThing() {
			    String _xblockexpression = null;
			    {
			      this.getThing("");
			      this.getThing("");
			      this.getThing();
			      this.getThing("");
			      this.getThing();
			      String _thing = this.getThing("");
			      _xblockexpression = (_thing);
			    }
			    return _xblockexpression;
			  }
			  
			  protected String getThing(final String s) {
			    return s;
			  }
			}
		''')
	}
	
	@Test
	def testSuperCall_03() {
		assertCompilesTo('''
			package x
			class B extends A {
				override getThing() {
					this.getThing('')
					''.getThing
					this.thing
					''.thing
					thing
					getThing('')
					super.getThing('')
					super.thing
					super.getThing
					super.getThing()
				}
			}
			class A {
				def String getThing() {
					getThing('')
				}
				def protected String getThing(String s) {
					return s
				}
			}
		''', '''
			package x;
			
			import x.A;
			
			@SuppressWarnings("all")
			public class B extends A {
			  public String getThing() {
			    String _xblockexpression = null;
			    {
			      this.getThing("");
			      this.getThing("");
			      this.getThing();
			      this.getThing("");
			      this.getThing();
			      this.getThing("");
			      super.getThing("");
			      super.getThing();
			      super.getThing();
			      String _thing = super.getThing();
			      _xblockexpression = (_thing);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def testCreateExtension() {
		assertCompilesTo('''
			package foo
			class Bar {
				def create result: new StringBuilder() aBuilder(String x) {
					result.append(x)
				}
			}
		''', '''
			package foo;

			import java.util.ArrayList;
			import java.util.HashMap;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Bar {
			  public StringBuilder aBuilder(final String x) {
			    final ArrayList<?>_cacheKey = CollectionLiterals.newArrayList(x);
			    final StringBuilder _result;
			    synchronized (_createCache_aBuilder) {
			      if (_createCache_aBuilder.containsKey(_cacheKey)) {
			        return _createCache_aBuilder.get(_cacheKey);
			      }
			      StringBuilder _stringBuilder = new StringBuilder();
			      _result = _stringBuilder;
			      _createCache_aBuilder.put(_cacheKey, _result);
			    }
			    _init_aBuilder(_result, x);
			    return _result;
			  }
			  
			  private final HashMap<ArrayList<? extends Object>,StringBuilder> _createCache_aBuilder = CollectionLiterals.newHashMap();
			  
			  private void _init_aBuilder(final StringBuilder result, final String x) {
			    result.append(x);
			  }
			}
		''');
	}

	@Test
	def testJavaDocs() {
		assertCompilesTo('''
			package foo
			/**
			 * I am Bar
			 */
			class Bar {
				/**
				 */
				def foo() {}
				
				/**
				 * I am bar,
				 * really!
				 */
				int bar
			}
		''', '''
			package foo;

			/**
			 * I am Bar
			 */
			@SuppressWarnings("all")
			public class Bar {
			  public Object foo() {
			    return null;
			  }
			  
			  /**
			   * I am bar,
			   * really!
			   */
			  private int bar;
			}
			''');
	}
	
	@Test
	def testJavaDocs_2() {
		assertCompilesTo('''
			package foo

			class Bar {
				/**
				 * @param string
				 */
				def foo(String string) {}

			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  /**
			   * @param string
			   */
			  public Object foo(final String string) {
			    return null;
			  }
			}
			''');
	}

	@Test
	def testJavaDocs_3() {
		assertCompilesTo('''
			package foo

			class Bar {
				/**
				 * {@link java.lang.String @see Integer}
				 */
				def foo(String string) {}

			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  /**
			   * {@link java.lang.String @see Integer}
			   */
			  public Object foo(final String string) {
			    return null;
			  }
			}
			''');
	}

	@Test
	def testJavaDocs_4() {
		assertCompilesTo('''
			package foo

			class Bar {
				/**
				 * {@link java.lang.String @see Integer}
				 */
				def foo(String string) {}

			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  /**
			   * {@link java.lang.String @see Integer}
			   */
			  public Object foo(final String string) {
			    return null;
			  }
			}
			''');
	}

	@Test
	def testJavaDocs_5() {
		assertCompilesTo('''
			package foo

			class Bar {
				/**
				 * {@link java.lang.String
				 * @param string - stuff
				 * @param string2
				 */
				def foo(String string, String string2) {}

			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  /**
			   * {@link java.lang.String
			   * @param string - stuff
			   * @param string2
			   */
			  public Object foo(final String string, final String string2) {
			    return null;
			  }
			}
			''');
	}

	@Test
	def testStaticMethod() {
		assertCompilesTo('''
			package foo
			class Bar {
				def static foo() { 42 }
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  public static int foo() {
			    return 42;
			  }
			}
			''');
	}
	
	@Test
	def testStaticMethod_02() {
		assertCompilesTo('''
			package foo
			class Bar<T extends CharSequence> {
				static def factory() { new Bar }
				static def concreteFactory() { new Bar<StringBuilder> }
				static def <X extends String> parameterizedFactory() { new Bar<X> }
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar<T extends CharSequence> {
			  public static Bar<CharSequence> factory() {
			    Bar<CharSequence> _bar = new Bar<CharSequence>();
			    return _bar;
			  }
			  
			  public static Bar<StringBuilder> concreteFactory() {
			    Bar<StringBuilder> _bar = new Bar<StringBuilder>();
			    return _bar;
			  }
			  
			  public static <X extends String> Bar<X> parameterizedFactory() {
			    Bar<X> _bar = new Bar<X>();
			    return _bar;
			  }
			}
		''');
	}
	
	@Test
	def testInstanceMethod() {
		assertCompilesTo('''
			package foo
			class Bar<T extends CharSequence> {
				def factory() { new Bar }
				def concreteFactory() { new Bar<String> }
				def parameterizedFactory() { new Bar<T> }
				def <X extends T> concreteParameterizedFactory() { new Bar<X> }
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar<T extends CharSequence> {
			  public Bar<CharSequence> factory() {
			    Bar<CharSequence> _bar = new Bar<CharSequence>();
			    return _bar;
			  }
			  
			  public Bar<String> concreteFactory() {
			    Bar<String> _bar = new Bar<String>();
			    return _bar;
			  }
			  
			  public Bar<T> parameterizedFactory() {
			    Bar<T> _bar = new Bar<T>();
			    return _bar;
			  }
			  
			  public <X extends T> Bar<X> concreteParameterizedFactory() {
			    Bar<X> _bar = new Bar<X>();
			    return _bar;
			  }
			}
		''');
	}
	
	@Test
	def testStaticField() {
		assertCompilesTo('''
			package foo
			class Bar {
				static int foo
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class Bar {
			  private static int foo;
			}
			''');
	}
	
	@Test
	def testNestedClosureWithIt() {
		assertCompilesTo('''
			class X {
				def foo() {
					val (String)=>String function = [ [String it | it].apply(it) ]
					function.apply('foo')
				}
			}
		''','''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class X {
			  public String foo() {
			    String _xblockexpression = null;
			    {
			      final Function1<String,String> _function = new Function1<String,String>() {
			          public String apply(final String it) {
			            final Function1<String,String> _function = new Function1<String,String>() {
			                public String apply(final String it) {
			                  return it;
			                }
			              };
			            String _apply = _function.apply(it);
			            return _apply;
			          }
			        };
			      final Function1<? super String,? extends String> function = _function;
			      String _apply = function.apply("foo");
			      _xblockexpression = (_apply);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def testNestedClosureSuperCall() {
		assertCompilesTo('''
			class X {
				def foo() {
					[| [| super.toString ].apply ].apply
				}
			}
		''','''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class X {
			  public String foo() {
			    final Function0<String> _function = new Function0<String>() {
			        public String apply() {
			          final Function0<String> _function = new Function0<String>() {
			              public String apply() {
			                String _string = X.super.toString();
			                return _string;
			              }
			            };
			          String _apply = _function.apply();
			          return _apply;
			        }
			      };
			    String _apply = _function.apply();
			    return _apply;
			  }
			}
		''')
	}

	@Test
	def testExplicitBoxingUnboxing_01() {
		assertCompilesTo('''
			class X {
				def foo(int p0, Integer p1) {
					foo(p1,p0)
				}
			}
		''','''
			@SuppressWarnings("all")
			public class X {
			  public Object foo(final int p0, final Integer p1) {
			    Object _foo = this.foo((p1).intValue(), Integer.valueOf(p0));
			    return _foo;
			  }
			}
		''')
	}
	
	@Test def testExplicitBoxingUnboxing_02() {
		assertCompilesTo('''
			class X {
				def Object foo(int p0, Integer p1) {
					foo(p1,p0)
				}
			}
		''','''
			@SuppressWarnings("all")
			public class X {
			  public Object foo(final int p0, final Integer p1) {
			    Object _foo = this.foo((p1).intValue(), Integer.valueOf(p0));
			    return _foo;
			  }
			}
		''')
	}
	
	@Test
	def testOptionalSemicola() {
		assertCompilesTo('''
			package foo;
			
			import java.io.File;
			
			public class Foo {
				private int bar;
				
				private File baz;
			}
		''', '''
			package foo;
			
			import java.io.File;
			
			@SuppressWarnings("all")
			public class Foo {
			  private int bar;
			  
			  private File baz;
			}
		''')
	}
	
	@Test
	def testNoDeclarationForFeatureCalls() {
		assertCompilesTo('''
			package foo;
			
			public class Foo {
				private static String FOO = "Holla";
				
				private String baz = FOO;
			}
		''', '''
			package foo;
			
			@SuppressWarnings("all")
			public class Foo {
			  private static String FOO = "Holla";
			  
			  private String baz = Foo.FOO;
			}
		''')
	}
	
	@Test
	def testNoDeclarationForFeatureCalls_02() {
		assertCompilesTo('''
			package foo;
			
			public class Foo {
				private static String FOO = "Holla";
				private String foo = "Holla";
				
				def void test(String x, String y, int integer) {
					new Foo().test(foo, FOO, Integer::MAX_VALUE)
				}
			}
		''', '''
			package foo;
			
			@SuppressWarnings("all")
			public class Foo {
			  private static String FOO = "Holla";
			  
			  private String foo = "Holla";
			  
			  public void test(final String x, final String y, final int integer) {
			    Foo _foo = new Foo();
			    _foo.test(this.foo, Foo.FOO, Integer.MAX_VALUE);
			  }
			}
		''')
	}
	
	@Test
	def testStringExtensionInlined_01() {
		assertCompilesTo('''
			package foo;
			
			public class Foo {
				def String returnString(String x, String y) {
					x + '' + y
				}
			}
		''', '''
			package foo;
			
			@SuppressWarnings("all")
			public class Foo {
			  public String returnString(final String x, final String y) {
			    String _plus = (x + "");
			    String _plus_1 = (_plus + y);
			    return _plus_1;
			  }
			}
		''')
	}
	
	@Test
	def testNoVarForReturnExpression() {
		assertCompilesTo('''
			package foo;
			
			public class Foo {
				def String returnString(String x, String y) {
					return x + '' + y
				}
			}
		''', '''
			package foo;
			
			@SuppressWarnings("all")
			public class Foo {
			  public String returnString(final String x, final String y) {
			    String _plus = (x + "");
			    return (_plus + y);
			  }
			}
		''')
	}
	
	@Test
	def testNoVarForRightHandSideOfVarDecl() {
		assertCompilesTo('''
			package foo;
			
			public class Foo {
				def String returnString(String x, String y) {
					val z = x + '' + y
					return z
				}
			}
		''', '''
			package foo;
			
			@SuppressWarnings("all")
			public class Foo {
			  public String returnString(final String x, final String y) {
			    String _plus = (x + "");
			    final String z = (_plus + y);
			    return z;
			  }
			}
		''')
	}
	@Test
	def testJavaKeywordsUsed() {
		assertCompilesTo('''
			package foo;
			
			public class Foo {
				def void someMethod(String assert) {
					val synchronized = newArrayList('foo')
					for (volatile : synchronized) {
						switch continue : volatile {
							case continue.length > 2 : synchronized.forEach(break | (break + continue).toString)
						}
					}
				}
			}
		''', '''
			package foo;
			
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void someMethod(final String assert_) {
			    final ArrayList<String> synchronized_ = CollectionLiterals.<String>newArrayList("foo");
			    for (final String volatile_ : synchronized_) {
			      final String continue_ = volatile_;
			      boolean _matched = false;
			      if (!_matched) {
			        int _length = continue_.length();
			        boolean _greaterThan = (_length > 2);
			        if (_greaterThan) {
			          _matched=true;
			          final Procedure1<String> _function = new Procedure1<String>() {
			              public void apply(final String break_) {
			                String _plus = (break_ + continue_);
			                _plus.toString();
			              }
			            };
			          IterableExtensions.<String>forEach(synchronized_, _function);
			        }
			      }
			    }
			  }
			}
		''')
	}
	
	@Test
	def testExtensionField() { 
		assertCompilesTo(
			'''
				class NoNPE {
					extension String
					def useExtension() {
						_string.toString
					}
				}
			''', '''
				@SuppressWarnings("all")
				public class NoNPE {
				  private String _string;
				  
				  public String useExtension() {
				    String _string = this._string.toString();
				    return _string;
				  }
				}
			''')
	}
	
	@Test
	def testFindFirstOnIt_01() { 
		assertCompilesTo(
			'''
				class FindFirstOnIt {
					def <T> useExtension(Iterable<T> it) {
						findFirst [ it != null ]
					}
				}
			''', '''
				import org.eclipse.xtext.xbase.lib.Functions.Function1;
				import org.eclipse.xtext.xbase.lib.IterableExtensions;
				import org.eclipse.xtext.xbase.lib.ObjectExtensions;
				
				@SuppressWarnings("all")
				public class FindFirstOnIt {
				  public <T extends Object> T useExtension(final Iterable<T> it) {
				    final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
				        public Boolean apply(final T it) {
				          boolean _notEquals = ObjectExtensions.operator_notEquals(it, null);
				          return Boolean.valueOf(_notEquals);
				        }
				      };
				    T _findFirst = IterableExtensions.<T>findFirst(it, _function);
				    return _findFirst;
				  }
				}
			''')
	}
	
	@Test
	def testReturnType() {
		assertCompilesTo(
			'''
				import test.ReturnTypeUsesTypeParameter
				class MyClass implements ReturnTypeUsesTypeParameter {
				
					override <LocalName extends CharSequence> accept(LocalName param) {
						null
					}
				}
			''', '''
				import test.ReturnTypeUsesTypeParameter;
				import test.ReturnTypeUsesTypeParameter.Inner;
				
				@SuppressWarnings("all")
				public class MyClass implements ReturnTypeUsesTypeParameter {
				  public <LocalName extends CharSequence> Inner<LocalName> accept(final LocalName param) {
				    return null;
				  }
				}
			''')
		
	}
	
	@Test
	def testReturnType_02() {
		assertCompilesTo(
			'''
				import test.ReturnTypeUsesTypeParameter
				class MyClass implements ReturnTypeUsesTypeParameter {
				
					override <LocalName extends CharSequence> accept(LocalName param) {
						[ if (true) it?.apply(param) ] 
					}
				}
			''', '''
				import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
				import test.ReturnTypeUsesTypeParameter;
				import test.ReturnTypeUsesTypeParameter.Inner;
				
				@SuppressWarnings("all")
				public class MyClass implements ReturnTypeUsesTypeParameter {
				  public <LocalName extends CharSequence> Inner<LocalName> accept(final LocalName param) {
				    final Inner<LocalName> _function = new Inner<LocalName>() {
				        public void useProcedure(final Procedure1<? super LocalName> it) {
				          if (true) {
				            if (it!=null) it.apply(param);
				          }
				        }
				      };
				    return _function;
				  }
				}
			''')
	}
	
	@Test 
	def void testReturnType_03() {
		'''
			import java.util.LinkedList
			
			class B extends A {
				def String client(CharSequence c) {
					client(m)
				}
				override m() {
					''
				}
			}
			
			abstract class A {
				def CharSequence m() 
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B extends A {
			  public String client(final CharSequence c) {
			    CharSequence _m = this.m();
			    String _client = this.client(_m);
			    return _client;
			  }
			  
			  public CharSequence m() {
			    return "";
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
	
	@Test
	def testAnnotationSupport() {
		assertCompilesTo(
			'''
				class X {
					@Property val String x = 'hello'
				}
			''', '''
				@SuppressWarnings("all")
				public class X {
				  private final String _x = "hello";
				  
				  public String getX() {
				    return this._x;
				  }
				}
			''')
	}

	@Test
	def testRichStringAutoConversionToString_01(){
		assertCompilesTo(
			"class Foo { def String test() '''SomeString''' }",
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				
				@SuppressWarnings("all")
				public class Foo {
				  public String test() {
				    StringConcatenation _builder = new StringConcatenation();
				    _builder.append("SomeString");
				    return _builder.toString();
				  }
				}
			''')
	}
	
	@Test
	def testRichStringAutoConversionToString_02(){
		assertCompilesTo(
			"class Foo { def String test() { println('''SomeString''') } }",
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				import org.eclipse.xtext.xbase.lib.InputOutput;
				
				@SuppressWarnings("all")
				public class Foo {
				  public String test() {
				    StringConcatenation _builder = new StringConcatenation();
				    _builder.append("SomeString");
				    String _println = InputOutput.<String>println(_builder.toString());
				    return _println;
				  }
				}
			''')
	}
	
	@Test
	def testRichStringAutoConversionToString_03(){
		assertCompilesTo(
			"class Foo { def String test() { val x = println('''SomeString''') x } }",
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				import org.eclipse.xtext.xbase.lib.InputOutput;
				
				@SuppressWarnings("all")
				public class Foo {
				  public String test() {
				    String _xblockexpression = null;
				    {
				      StringConcatenation _builder = new StringConcatenation();
				      _builder.append("SomeString");
				      final String x = InputOutput.<String>println(_builder.toString());
				      _xblockexpression = (x);
				    }
				    return _xblockexpression;
				  }
				}
			''')
	}
	
	@Test
	def testRichStringAutoConversionToString_04(){
		assertCompilesTo(
			"class Foo { def String test() { val x = '''SomeString''' x } }",
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				
				@SuppressWarnings("all")
				public class Foo {
				  public String test() {
				    String _xblockexpression = null;
				    {
				      StringConcatenation _builder = new StringConcatenation();
				      _builder.append("SomeString");
				      final String x = _builder.toString();
				      _xblockexpression = (x);
				    }
				    return _xblockexpression;
				  }
				}
			''')
	}
	
	@Test
	def testRichStringAutoConversionToString_05(){
		assertCompilesTo(
			"class Foo { def String test() { '''SomeString'''.toString } }",
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				
				@SuppressWarnings("all")
				public class Foo {
				  public String test() {
				    StringConcatenation _builder = new StringConcatenation();
				    _builder.append("SomeString");
				    String _string = _builder.toString();
				    return _string;
				  }
				}
			''')
	}

	@Test
	def testRichStringNoAutoConversionToString_01(){
		assertCompilesTo(
			"class Foo { def test() '''SomeString''' }",
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				
				@SuppressWarnings("all")
				public class Foo {
				  public CharSequence test() {
				    StringConcatenation _builder = new StringConcatenation();
				    _builder.append("SomeString");
				    return _builder;
				  }
				}
			''')
	}
	
	@Test
	def testRichStringAutoConversionDueToUnboundTypeParam_01(){
		assertCompilesTo(
			"class Foo { def test() { println('''SomeString''') } }",
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				import org.eclipse.xtext.xbase.lib.InputOutput;
				
				@SuppressWarnings("all")
				public class Foo {
				  public String test() {
				    StringConcatenation _builder = new StringConcatenation();
				    _builder.append("SomeString");
				    String _println = InputOutput.<String>println(_builder.toString());
				    return _println;
				  }
				}
			''')
	}
	
	@Test
	def testRichStringNoAutoConversionToString_02(){
		assertCompilesTo(
			"class Foo { def test(){ System::out.println('''SomeString''') } }", 
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				
				@SuppressWarnings("all")
				public class Foo {
				  public void test() {
				    StringConcatenation _builder = new StringConcatenation();
				    _builder.append("SomeString");
				    System.out.println(_builder);
				  }
				}
			''')
	}
	
	@Test
	def testRichStringAutoConversionDueToUnboundTypeParam_02(){
		assertCompilesTo(
			"class Foo { def test(){ System::out.println(println('''SomeString''')) } }", 
			'''
				import org.eclipse.xtend2.lib.StringConcatenation;
				import org.eclipse.xtext.xbase.lib.InputOutput;
				
				@SuppressWarnings("all")
				public class Foo {
				  public void test() {
				    StringConcatenation _builder = new StringConcatenation();
				    _builder.append("SomeString");
				    String _println = InputOutput.<String>println(_builder.toString());
				    System.out.println(_println);
				  }
				}
			''')
	}

	@Test
	def testAnnotationType_1(){
		assertCompilesTo(
		'''
			annotation MyAnnotation { 
				String x;
				int y;
				Class<?>[] value;
			}
		''','''
			public @interface MyAnnotation {
			  public String x();
			  public int y();
			  public Class<? extends Object>[] value();
			}
		''')
	}
	
	@Test
	def testAnnotationType_2(){
		assertCompilesTo(
		'''
			annotation MyAnnotation { 
				String x = 'foo'
				int y = 42
				Class<?> value = typeof(String)
				boolean flag = true
			}
		''','''
			public @interface MyAnnotation {
			  public String x() default "foo";
			  public int y() default 42;
			  public Class<? extends Object> value() default String.class;
			  public boolean flag() default true;
			}
		''')
	}
	
	@Test
	def testAnnotationType_3(){
		assertCompilesTo(
		'''
			annotation annotation { 
				String annotation = 'foo'
				val inferred = 'bar'
				val inferredClass = typeof(StringBuilder)
			}
		''','''
			public @interface annotation {
			  public String annotation() default "foo";
			  public String inferred() default "bar";
			  public Class<StringBuilder> inferredClass() default StringBuilder.class;
			}
		''')
	}
	
	@Test
	def compileAnnotationWithFileHeader(){
		assertCompilesTo(
		''' 
			/**
			 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
			 * All rights reserved. This program and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 */
			package foo
			
			annotation bar { 
			    String name = 'foobar'
			}
		''',
		'''
			/**
			 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
			 * All rights reserved. This program and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 */
			package foo;
			
			public @interface bar {
			  public String name() default "foobar";
			}
		''')
	}
	
	@Test
	def compileClassWithFileHeader(){
		assertCompilesTo(
		''' 
			/**
			 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
			 * All rights reserved. This program and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 */
			package foo
			
			class bar { 
			    String name = 'foobar'
			}
		''',
		'''
			/**
			 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
			 * All rights reserved. This program and the accompanying materials
			 * are made available under the terms of the Eclipse Public License v1.0
			 * which accompanies this distribution, and is available at
			 * http://www.eclipse.org/legal/epl-v10.html
			 */
			package foo;
			
			@SuppressWarnings("all")
			public class bar {
			  private String name = "foobar";
			}
		''')
	}
	
	@Test
	def compileClassInDefaultPackageWithFileHeader(){
		assertCompilesTo(''' 
			/**
			 * Xtend can't decide whether this is a header or a javadoc
			 */
			
			class bar { 
			}
		''',
		'''
			/**
			 * Xtend can't decide whether this is a header or a javadoc
			 */
			/**
			 * Xtend can't decide whether this is a header or a javadoc
			 */
			@SuppressWarnings("all")
			public class bar {
			}
		''')
	}
	
	@Test
	def compileClassInDefaultPackageWithFileHeaderAndJavaDoc(){
		assertCompilesTo(''' 
			/**
			 * header
			 */

			/**
			 * javadoc
			 */
			class bar { 
			}
		''',
		'''
			/**
			 * header
			 */
			/**
			 * javadoc
			 */
			@SuppressWarnings("all")
			public class bar {
			}
		''')
	}
	
	@Test
	def compileClassInDefaultPackageWithFileHeaderAndImport(){
		assertCompilesTo(
		''' 
			/**
			 * header
			 */
			 
			import java.util.Date
			
			class bar {
				Date d
			}
		''',
		'''
			/**
			 * header
			 */
			import java.util.Date;
			
			@SuppressWarnings("all")
			public class bar {
			  private Date d;
			}
		''')
	}
	
	@Test
	def compileClassInDefaultPackageWithJavadDocAndImport(){
		assertCompilesTo(''' 
			import java.util.Date
			
			/**
			 * javadoc
			 */
			class bar {
				Date d
			}
		''',
		'''
			import java.util.Date;
			
			/**
			 * javadoc
			 */
			@SuppressWarnings("all")
			public class bar {
			  private Date d;
			}
        ''')
    }

    @Test
    def compileAllClassesWithTheSameFileHeader(){
        val input = '''
            /**
             * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
             * All rights reserved. This program and the accompanying materials
             * are made available under the terms of the Eclipse Public License v1.0
             * which accompanies this distribution, and is available at
             * http://www.eclipse.org/legal/epl-v10.html
             */
            package foo

            class bar {
                String name = 'foobar'
            }

            class baz {
                String name = 'foobaz'
            }
        '''
        val expectedBarClass = '''
            /**
             * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
             * All rights reserved. This program and the accompanying materials
             * are made available under the terms of the Eclipse Public License v1.0
             * which accompanies this distribution, and is available at
             * http://www.eclipse.org/legal/epl-v10.html
             */
            package foo;

            @SuppressWarnings("all")
            public class bar {
              private String name = "foobar";
            }
        '''
        val expectedBazClass = '''
            /**
             * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
             * All rights reserved. This program and the accompanying materials
             * are made available under the terms of the Eclipse Public License v1.0
             * which accompanies this distribution, and is available at
             * http://www.eclipse.org/legal/epl-v10.html
             */
            package foo;

            @SuppressWarnings("all")
            public class baz {
              private String name = "foobaz";
            }
		'''
		val file = file(input.toString(), true)
		val barType = file.eResource.contents.filter(typeof(JvmDeclaredType)).head
		val bazType = file.eResource.contents.filter(typeof(JvmDeclaredType)).last
		val generatorConfig =  generatorConfigProvider.get(barType)
		val barJavaCode = generator.generateType(barType, generatorConfig);
		val bazJavaCode = generator.generateType(bazType, generatorConfig);
		XtendCompilerTest::assertEquals(expectedBarClass.toString, barJavaCode.toString);
		XtendCompilerTest::assertEquals(expectedBazClass.toString, bazJavaCode.toString);
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
	
	@Test
	def compileWithConfiguration(){
		val generatorConfig = generatorConfigProvider.get(null)
		generatorConfig.setGenerateSyntheticSuppressWarnings(false)
		generatorConfig.setGenerateExpressions(false)
		assertCompilesTo(
			'''
				package foo

				/**
				 * javadoc
				 */
				class Bar {
					def foo(){
						1 + 1
					}
				}
			''',
			'''
				package foo;

				/**
				 * javadoc
				 */
				public class Bar {
				  public int foo() {
				    throw new UnsupportedOperationException("foo is not implemented");
				  }
				}
			''', generatorConfig)
	}
	@Test
	def compileWithConfiguration_2(){
		val generatorConfig = generatorConfigProvider.get(null)
		generatorConfig.setGenerateSyntheticSuppressWarnings(true)
		generatorConfig.setGenerateExpressions(false)
		assertCompilesTo(
			'''
				package foo

				/**
				 * javadoc
				 */
				@SuppressWarnings("unused")
				class Bar {
					def foo(){
						1 + 1
					}
				}
			''',
			'''
				package foo;

				/**
				 * javadoc
				 */
				@SuppressWarnings("all")
				public class Bar {
				  public int foo() {
				    throw new UnsupportedOperationException("foo is not implemented");
				  }
				}
			''', generatorConfig)
	}

	@Test
	def compileWithConfiguration_3(){
		val generatorConfig = generatorConfigProvider.get(null)
		generatorConfig.setGenerateSyntheticSuppressWarnings(true)
		generatorConfig.setGenerateExpressions(false)
		assertCompilesTo(
			'''
				package foo

				/**
				 * javadoc
				 */
				@Deprecated
				@SuppressWarnings("unused")
				class Bar {
					def foo(){
						1 + 1
					}
				}
			''',
			'''
				package foo;

				/**
				 * javadoc
				 */
				@Deprecated
				@SuppressWarnings("all")
				public class Bar {
				  public int foo() {
				    throw new UnsupportedOperationException("foo is not implemented");
				  }
				}
			''', generatorConfig)
	}

	@Test
	def compileImportForTypeRefInJavaDoc(){
		assertCompilesTo(
			'''
				package foo
				import java.util.List
				import java.util.ArrayList

				/**
				 *
				 * {@link List}
				 */
				class Foo {
					/**
					 *
					 * @see ArrayList
					 */
					def doStuff(){}

				}
			''',
			'''
				package foo;

				import java.util.ArrayList;
				import java.util.List;

				/**
				 * {@link List}
				 */
				@SuppressWarnings("all")
				public class Foo {
				  /**
				   * @see ArrayList
				   */
				  public Object doStuff() {
				    return null;
				  }
				}
			''')
	}

	@Test
	def compileImportForTypeRefInJavaDoc_2(){
		assertCompilesTo(
			'''
				package foo
				import java.util.List
				import java.util.ArrayList

				/**
				 *
				 * {@link List}
				 */
				class Foo {
					/**
					 * @see ArrayList
					 */
					def doStuff(ArrayList l){}

				}
			''',
			'''
				package foo;

				import java.util.ArrayList;
				import java.util.List;

				/**
				 * {@link List}
				 */
				@SuppressWarnings("all")
				public class Foo {
				  /**
				   * @see ArrayList
				   */
				  public Object doStuff(final ArrayList l) {
				    return null;
				  }
				}
			''')
	}

	@Test
	def compileImportForTypeRefInJavaDoc_3(){
		assertCompilesTo(
			'''
				package foo
				import java.util.List
				import java.util.ArrayList

				class Foo {
					/**
					 * @see ArrayList
					 */
					List<String> list = null

				}
			''',
			'''
				package foo;

				import java.util.ArrayList;
				import java.util.List;

				@SuppressWarnings("all")
				public class Foo {
				  /**
				   * @see ArrayList
				   */
				  private List<String> list = null;
				}
			''')
	}

	@Test
	def compileImportForTypeRefInJavaDoc_Same_Package(){
		assertCompilesTo(
			'''
				package foo

				/**
				 *
				 * {@link Bar}
				 */
				class Foo {
				}
				class Bar{}
			''',
			'''
				package foo;

				/**
				 * {@link Bar}
				 */
				@SuppressWarnings("all")
				public class Foo {
				}
			''')
	}

	@Test
	def compileProperty() {
		val generatorConfig = generatorConfigProvider.get(null)
		assertCompilesTo(
			'''
				package foo

				class Bar {
					@Property
					boolean generateExpressions = true
				}
			''',
			'''
				package foo;
				
				@SuppressWarnings("all")
				public class Bar {
				  private boolean _generateExpressions = true;
				  
				  public boolean isGenerateExpressions() {
				    return this._generateExpressions;
				  }
				  
				  public void setGenerateExpressions(final boolean generateExpressions) {
				    this._generateExpressions = generateExpressions;
				  }
				}
			''', generatorConfig)
	}

	def assertCompilesTo(CharSequence input, CharSequence expected){
		assertCompilesTo(input, expected, generatorConfigProvider.get(null))
	}

	def assertCompilesTo(CharSequence input, CharSequence expected, GeneratorConfig config) {
		val file = file(input.toString(), true)
		val inferredType = file.eResource.contents.filter(typeof(JvmDeclaredType)).head
		assertFalse(DisableCodeGenerationAdapter::isDisabled(inferredType))
		val javaCode = generator.generateType(inferredType, config);
		XtendCompilerTest::assertEquals(expected.toString, javaCode.toString);
	}
}

//class XtendCompilerTest extends AbstractXtendCompilerTest {
//	
//	/*
//	 * Refined questionable expectation.
//	 */
//	@Test
//	override testRichStringNoAutoConversionToString_03(){
//		assertCompilesTo(
//			"class Foo { def test(){ System::out.println('''SomeString''') } }", 
//			'''
//				import org.eclipse.xtend2.lib.StringConcatenation;
//				
//				@SuppressWarnings("all")
//				public class Foo {
//				  public void test() {
//				    StringConcatenation _builder = new StringConcatenation();
//				    _builder.append("SomeString");
//				    System.out.println(_builder.toString());
//				  }
//				}
//			''')
//	}
//	
//	/*
//	 * Refined questionable expectation.
//	 */
//	@Test
//	override testRichStringNoAutoConversionToString_04(){
//		assertCompilesTo(
//			"class Foo { def test(){ System::out.println(println('''SomeString''')) } }", 
//			'''
//				import org.eclipse.xtend2.lib.StringConcatenation;
//				import org.eclipse.xtext.xbase.lib.InputOutput;
//				
//				@SuppressWarnings("all")
//				public class Foo {
//				  public void test() {
//				    StringConcatenation _builder = new StringConcatenation();
//				    _builder.append("SomeString");
//				    String _println = InputOutput.<String>println(_builder.toString());
//				    System.out.println(_println);
//				  }
//				}
//			''')
//	}
//	
//}