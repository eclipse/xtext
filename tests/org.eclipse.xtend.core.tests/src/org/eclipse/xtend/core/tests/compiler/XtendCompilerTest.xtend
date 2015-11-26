/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.generator.IFilePostProcessor
import org.junit.Test

class XtendCompilerTest extends AbstractXtendCompilerTest {

	@Inject protected IFilePostProcessor postProcessor

	@Test
	def testClosureNoArgs() {
		assertCompilesTo('''
			class Foo {
			   val thread = new Thread []
			}
		''','''
			@SuppressWarnings("all")
			public class Foo {
			  private final Thread thread = new Thread(new Runnable() {
			    public void run() {
			    }
			  });
			}
		''')
	}
	
	@Test
	def testClosureTwoArgs() {
		assertCompilesTo('''
			class Foo {
				def void m(java.util.List<String> list) {
					java.util.Collections.sort(list) [ return 0 ]
				}
			}
		''','''
			import java.util.Collections;
			import java.util.Comparator;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void m(final List<String> list) {
			    final Comparator<String> _function = new Comparator<String>() {
			      public int compare(final String $0, final String $1) {
			        return 0;
			      }
			    };
			    Collections.<String>sort(list, _function);
			  }
			}
		''')
	}

	@Test def testInnerTypeImports() {
		assertCompilesTo('''
			class Foo extends types.SomeClassWithNestedInterface implements types.SomeClassWithNestedInterface.NestedInterface {}
		''', '''
			import types.SomeClassWithNestedInterface;
			
			@SuppressWarnings("all")
			public class Foo extends SomeClassWithNestedInterface implements SomeClassWithNestedInterface.NestedInterface {
			}
		''')
	}
	
	@Test def testInnerTypeImports_1() {
		assertCompilesTo('''
			class Foo extends types.SomeClassWithNestedInterface {
				override types.SomeClassWithNestedInterface.String convert(java.lang.String s) {
					return null;
				}
			}
		''', '''
			import types.SomeClassWithNestedInterface;
			
			@SuppressWarnings("all")
			public class Foo extends SomeClassWithNestedInterface {
			  public SomeClassWithNestedInterface.String convert(final java.lang.String s) {
			    return null;
			  }
			}
		''')
	}
	
	@Test def testBug424839() {
		'''
			class Foo {
				val a = bug424839.Bug424839
				val b = bug424839.sub.Bug424839.Inner
			}
		'''.assertCompilesTo(
			'''
				import bug424839.Bug424839;
				
				@SuppressWarnings("all")
				public class Foo {
				  private final Class<Bug424839> a = Bug424839.class;
				  
				  private final Class<bug424839.sub.Bug424839.Inner> b = bug424839.sub.Bug424839.Inner.class;
				}
			'''
		)
	}
	
	@Test def testBug424839_2() {
		'''
			class Foo {
				val b = bug424839.sub.Bug424839.Inner
				val a = bug424839.Bug424839
			}
		'''.assertCompilesTo(
			'''
				import bug424839.sub.Bug424839;
				
				@SuppressWarnings("all")
				public class Foo {
				  private final Class<Bug424839.Inner> b = Bug424839.Inner.class;
				  
				  private final Class<bug424839.Bug424839> a = bug424839.Bug424839.class;
				}
			'''
		)
	}

	@Test
	def testBug411861() {
		assertCompilesTo('''
			public class Test {
			  // does not work, Java error
			  def <T, R> nonWorkingExample((T)=>R... functionList) {
			    var value = 0
			    for (function : functionList)
			    {
			      value = value + 1
			    }
			    return value
			  }
			  
			  // does not work, Java error
			  def <T> nonWorkingExample2(T... list) {
			    var value = 0
			    for (loc_item : list) {
			      value = value + 1
			    }
			    return value
			  }
			  
			  // does not work, Java error
			  def <T> nonWorkingExample3(T[] list) {
			    var value = 0
			    for (loc_item : list) {
			      value = value + 1
			    }
			    return value
			  }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object, R extends Object> int nonWorkingExample(final Function1<? super T, ? extends R>... functionList) {
			    int value = 0;
			    for (final Function1<? super T, ? extends R> function : functionList) {
			      value = (value + 1);
			    }
			    return value;
			  }
			  
			  public <T extends Object> int nonWorkingExample2(final T... list) {
			    int value = 0;
			    for (final T loc_item : list) {
			      value = (value + 1);
			    }
			    return value;
			  }
			  
			  public <T extends Object> int nonWorkingExample3(final T[] list) {
			    int value = 0;
			    for (final T loc_item : list) {
			      value = (value + 1);
			    }
			    return value;
			  }
			}
		''')
	}
	
	@Test
	def testClassAndLocalVarConflict() {
		assertCompilesTo('''
			
			class A {
				
				def java.util.Set<String> doStuff(String Collections) {
					java::util::Collections::emptySet
				}
			
			}
		''', '''
			import java.util.Set;
			
			@SuppressWarnings("all")
			public class A {
			  public Set<String> doStuff(final String Collections) {
			    return java.util.Collections.<String>emptySet();
			  }
			}
		''')
	}
	@Test
	def testExpectationFromTypeParameter() {
		assertCompilesTo('''
			import java.util.Set
			import org.eclipse.xtext.common.types.JvmTypeParameter
			import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
			import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor
			import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
			
			class C extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
				
				new(ITypeReferenceOwner owner) {
					super(null, owner)
				}
				
				override substitute(LightweightTypeReference original) {
					original.accept(this, newHashSet)
				}
			
				override protected createVisiting() {
					return newHashSet
				}
			}
		''', '''
			import java.util.HashSet;
			import java.util.Set;
			import org.eclipse.xtext.common.types.JvmTypeParameter;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
			import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
			import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
			
			@SuppressWarnings("all")
			public class C extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
			  public C(final ITypeReferenceOwner owner) {
			    super(null, owner);
			  }
			  
			  public LightweightTypeReference substitute(final LightweightTypeReference original) {
			    HashSet<JvmTypeParameter> _newHashSet = CollectionLiterals.<JvmTypeParameter>newHashSet();
			    return original.<Set<JvmTypeParameter>, LightweightTypeReference>accept(this, _newHashSet);
			  }
			  
			  protected Set<JvmTypeParameter> createVisiting() {
			    return CollectionLiterals.<JvmTypeParameter>newHashSet();
			  }
			}
		''')
	}
	
	@Test
	def testNonExplicitDispatchCases() {
		assertCompilesTo('''
			class C {
				def dispatch testFunction1(CharSequence i) {
					42
				}
				protected def _testFunction1(String s) {
					s.length
				}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected int _testFunction1(final CharSequence i) {
			    return 42;
			  }
			  
			  protected int _testFunction1(final String s) {
			    return s.length();
			  }
			  
			  public int testFunction1(final CharSequence s) {
			    if (s instanceof String) {
			      return _testFunction1((String)s);
			    } else if (s != null) {
			      return _testFunction1(s);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(s).toString());
			    }
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
			    return s.length();
			  }
			  
			  protected int _testFunction1(final Integer i) {
			    return i.intValue();
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
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class D extends C {
			  protected int _testFunction1(final Double d) {
			    return d.intValue();
			  }
			  
			  public int testFunction1(final Object d) {
			    if (d instanceof Double) {
			      return _testFunction1((Double)d);
			    } else if (d instanceof Integer) {
			      return _testFunction1((Integer)d);
			    } else if (d instanceof String) {
			      return _testFunction1((String)d);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(d).toString());
			    }
			  }
			}
		''')
	}
	
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
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class D extends C {
			  protected int _testFunction1(final Double d) {
			    return d.intValue();
			  }
			  
			  protected int _testFunction1(final Number n) {
			    return n.intValue();
			  }
			  
			  public int testFunction1(final Object d) {
			    if (d instanceof Double) {
			      return _testFunction1((Double)d);
			    } else if (d instanceof Integer) {
			      return _testFunction1((Integer)d);
			    } else if (d instanceof Number) {
			      return _testFunction1((Number)d);
			    } else if (d instanceof String) {
			      return _testFunction1((String)d);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(d).toString());
			    }
			  }
			}
		''')
	}
	
	@Test
	def testInheritedDispatchMethods_04() {
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
				def dispatch testFunction1(Number n) {
					n.intValue
				}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected int _testFunction1(final String s) {
			    return s.length();
			  }
			  
			  protected int _testFunction1(final Integer i) {
			    return i.intValue();
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
			      while (true) {
			        "".toString();
			      }
			    }
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoidButNonVoidExpectation_01() {
		assertCompilesTo('''
			public class C  {
				def m() {
					val x = if (false) return '';
					x
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public String m() {
			    Object _xblockexpression = null;
			    {
			      Object _xifexpression = null;
			      if (false) {
			        return "";
			      }
			      final Object x = _xifexpression;
			      _xblockexpression = x;
			    }
			    return ((String)_xblockexpression);
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoidButNonVoidExpectation_02() {
		assertCompilesTo('''
			public class C  {
				def void m() {
					val Object x = if (false) return;
					x.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    Object _xifexpression = null;
			    if (false) {
			      return;
			    }
			    final Object x = _xifexpression;
			    x.toString();
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoidButNonVoidExpectation_03() {
		assertCompilesTo('''
			public class C  {
				def m() {
					val x = if (false) return;
					voidFunction(x)
				}
				def void voidFunction(Object o) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    Object _xifexpression = null;
			    if (false) {
			      return;
			    }
			    final Object x = _xifexpression;
			    this.voidFunction(x);
			  }
			  
			  public void voidFunction(final Object o) {
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoidButNonVoidExpectation_04() {
		assertCompilesTo('''
			public class C  {
				def m(Object x) {
					val r = switch x { String: return '' };
					r
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public String m(final Object x) {
			    Object _xblockexpression = null;
			    {
			      Object _switchResult = null;
			      boolean _matched = false;
			      if (!_matched) {
			        if (x instanceof String) {
			          _matched=true;
			          return "";
			        }
			      }
			      final Object r = _switchResult;
			      _xblockexpression = r;
			    }
			    return ((String)_xblockexpression);
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoidButNonVoidExpectation_05() {
		assertCompilesTo('''
			public class C  {
				def void m(Object o) {
					val Object x = switch o { String: return };
					x.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final Object o) {
			    Object _switchResult = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        return;
			      }
			    }
			    final Object x = _switchResult;
			    x.toString();
			  }
			}
		''')
	}
	
	@Test def void testIfWithVoidButNonVoidExpectation_06() {
		assertCompilesTo('''
			public class C  {
				def m(Object o) {
					val x = switch o { String: return };
					voidFunction(x)
				}
				def void voidFunction(Object o) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final Object o) {
			    Object _switchResult = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        return;
			      }
			    }
			    final Object x = _switchResult;
			    this.voidFunction(x);
			  }
			  
			  public void voidFunction(final Object o) {
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
	
	@Test def void testRecursiveLambda_01() {
		assertCompilesTo('''
			public class Foo  {
			    def void foo((String)=>String func) {
			    	foo[self.apply(it)]
			    }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final Function1<? super String, ? extends String> func) {
			    final Function1<String, String> _function = new Function1<String, String>() {
			      public String apply(final String it) {
			        return this.apply(it);
			      }
			    };
			    this.foo(_function);
			  }
			}
		''')
	}
	
	@Test def void testRecursiveLambda_02() {
		assertCompilesTo('''
			public class Foo  {
			    def void foo(()=>void func) {
			    	foo[|self.apply()]
			    }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final Procedure0 func) {
			    final Procedure0 _function = new Procedure0() {
			      public void apply() {
			        this.apply();
			      }
			    };
			    this.foo(_function);
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
			import com.google.common.base.Objects;
			import com.google.common.collect.AbstractIterator;
			import java.util.Iterator;
			
			@SuppressWarnings("all")
			public class Foo {
			  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> iter) {
			    final AbstractIterator<T> _function = new AbstractIterator<T>() {
			      @Override
			      protected T computeNext() {
			        while (iter.hasNext()) {
			          {
			            final T elem = iter.next();
			            boolean _notEquals = (!Objects.equal(elem, null));
			            if (_notEquals) {
			              return elem;
			            }
			          }
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
			          _xblockexpression = this.toString();
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
						iter.findFirst [ it !== null ] ?: self.endOfData
					]
					return result
				}
			}
		''', '''
			import com.google.common.collect.AbstractIterator;
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IteratorExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> iter) {
			    final AbstractIterator<T> _function = new AbstractIterator<T>() {
			      @Override
			      protected T computeNext() {
			        T _elvis = null;
			        final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
			          public Boolean apply(final T it) {
			            return Boolean.valueOf((it != null));
			          }
			        };
			        T _findFirst = IteratorExtensions.<T>findFirst(iter, _function);
			        if (_findFirst != null) {
			          _elvis = _findFirst;
			        } else {
			          T _endOfData = this.endOfData();
			          _elvis = _endOfData;
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
				import com.google.common.base.Objects;
				import com.google.common.collect.AbstractIterator;
				import java.util.Iterator;
				import org.eclipse.xtext.xbase.lib.Functions.Function1;
				import org.eclipse.xtext.xbase.lib.IteratorExtensions;
				
				@SuppressWarnings("all")
				public class FindFirstOnIt {
				  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> it) {
				    final AbstractIterator<T> _function = new AbstractIterator<T>() {
				      @Override
				      protected T computeNext() {
				        T _elvis = null;
				        final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
				          public Boolean apply(final T it) {
				            return Boolean.valueOf((!Objects.equal(it, null)));
				          }
				        };
				        T _findFirst = IteratorExtensions.<T>findFirst(it, _function);
				        if (_findFirst != null) {
				          _elvis = _findFirst;
				        } else {
				          T _endOfData = this.endOfData();
				          _elvis = _endOfData;
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
			        return InputOutput.<String>println("");
			      }
			    };
			    return _function;
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
			  public static <T extends Object> T propagate(final Function0<? extends T> proc, final Function1<? super Exception, ? extends Exception> handler) {
			    try {
			      T _xtrycatchfinallyexpression = null;
			      try {
			        _xtrycatchfinallyexpression = proc.apply();
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
			  private final URI uri = Throwables.<URI>propagate(new Function0<URI>() {
			    public URI apply() {
			      try {
			        return new URI("");
			      } catch (Throwable _e) {
			        throw Exceptions.sneakyThrow(_e);
			      }
			    }
			  }, new Function1<Exception, Exception>() {
			    public Exception apply(final Exception it) {
			      return new IllegalArgumentException(it);
			    }
			  });
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
	
	@Test def testEnumBug428707() {
		'''
			enum E {
				AFTER, BEFORE
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public enum E {
			  AFTER,
			  
			  BEFORE;
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
			      throw new Throwable();
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
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
			      if (Objects.equal(a, "b")) {
			        _matched=true;
			        while (true) {
			          "".toString();
			        }
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a, "c")) {
			        _matched=true;
			        if (true) {
			          return;
			        }
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a, "d")) {
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
	
	@Test def void testSwitchWithNonVoidReturn_01() {
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
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(a, "b")) {
			        _matched=true;
			        while (true) {
			          "".toString();
			        }
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a, "c")) {
			        _matched=true;
			        if (true) {
			          return "a";
			        }
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a, "d")) {
			        _matched=true;
			        IntegerRange _upTo = new IntegerRange(1, 1);
			        for (final Integer i : _upTo) {
			          i.toString();
			        }
			      }
			    }
			    return null;
			  }
			}
		''')
	}
	
	@Test def void testSwitchWithNonVoidReturn_02() {
		assertCompilesTo('''
			public class C  {
			    def m(Object a, boolean b) {
			    	val String s = switch a {
			    		case 'a': { while(b) ''.toString '' }
			    		case 'b': if (true) return 'a'
			    	}
				}
			}
		''', '''
			import com.google.common.base.Objects;
			
			@SuppressWarnings("all")
			public class C {
			  public String m(final Object a, final boolean b) {
			    String _switchResult = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(a, "a")) {
			        _matched=true;
			        String _xblockexpression = null;
			        {
			          while (b) {
			            "".toString();
			          }
			          _xblockexpression = "";
			        }
			        _switchResult = _xblockexpression;
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(a, "b")) {
			        _matched=true;
			        if (true) {
			          return "a";
			        }
			      }
			    }
			    final String s = _switchResult;
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchWithBooleanExpression() {
		'''
		class Foo {
			def foo(int x) {
				switch x {
					case x == 1 || x == 2 || x == 3: true
					default: false
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo(final int x) {
		    boolean _switchResult = false;
		    boolean _matched = false;
		    if (!_matched) {
		      if ((((x == 1) || (x == 2)) || (x == 3))) {
		        _matched=true;
		        _switchResult = true;
		      }
		    }
		    if (!_matched) {
		      _switchResult = false;
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithBooleanExpression_2() {
		'''
		class Foo {
			def foo(int x) {
				switch x {
					case x == 1 || try { x == 2 } finally { }: true
					default: false
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo(final int x) {
		    boolean _switchResult = false;
		    boolean _matched = false;
		    if (!_matched) {
		      boolean _or = false;
		      if ((x == 1)) {
		        _or = true;
		      } else {
		        boolean _xtrycatchfinallyexpression = false;
		        try {
		          _xtrycatchfinallyexpression = (x == 2);
		        } finally {
		        }
		        _or = _xtrycatchfinallyexpression;
		      }
		      if (_or) {
		        _matched=true;
		        _switchResult = true;
		      }
		    }
		    if (!_matched) {
		      _switchResult = false;
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithBooleanExpression_3() {
		'''
		class Foo {
			def foo(int x) {
				switch x {
					case [|1 == x].apply || x == 2: true
					default: false
				}
			}
		}
		'''.assertCompilesTo(
		'''
		import org.eclipse.xtext.xbase.lib.Functions.Function0;
		
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo(final int x) {
		    boolean _switchResult = false;
		    boolean _matched = false;
		    if (!_matched) {
		      boolean _or = false;
		      final Function0<Boolean> _function = new Function0<Boolean>() {
		        public Boolean apply() {
		          return Boolean.valueOf((1 == x));
		        }
		      };
		      Boolean _apply = _function.apply();
		      if ((_apply).booleanValue()) {
		        _or = true;
		      } else {
		        _or = (x == 2);
		      }
		      if (_or) {
		        _matched=true;
		        _switchResult = true;
		      }
		    }
		    if (!_matched) {
		      _switchResult = false;
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
			  public Function1<? super Integer, ?> foo() {
			    Function1<? super Integer, ?> _switchResult = null;
			    final Object _switchValue = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(_switchValue, null)) {
			        _matched=true;
			        final Function1<Object, Object> _function = new Function1<Object, Object>() {
			          public Object apply(final Object it) {
			            return it;
			          }
			        };
			        _switchResult = _function;
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(_switchValue, null)) {
			        _matched=true;
			        final Function1<Integer, Integer> _function_1 = new Function1<Integer, Integer>() {
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
	def testSwitchWithConstantExpressions() {
		'''
		class Foo {
			def foo() {
				switch x : 1 + 2 {
					case 1: 1
					case 2: 2
					case 3: 3
					default: 4
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public int foo() {
		    int _switchResult = (int) 0;
		    final int x = (1 + 2);
		    switch (x) {
		      case 1:
		        _switchResult = 1;
		        break;
		      case 2:
		        _switchResult = 2;
		        break;
		      case 3:
		        _switchResult = 3;
		        break;
		      default:
		        _switchResult = 4;
		        break;
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_2() {
		'''
		class Foo {
			def foo() {
				switch x : 1d + 2 {
					case 1: 1
					default: 2
				}
			}
		}
		'''.assertCompilesTo(
		'''
		import com.google.common.base.Objects;

		@SuppressWarnings("all")
		public class Foo {
		  public int foo() {
		    int _switchResult = (int) 0;
		    final double x = (1d + 2);
		    boolean _matched = false;
		    if (!_matched) {
		      if (Objects.equal(x, 1)) {
		        _matched=true;
		        _switchResult = 1;
		      }
		    }
		    if (!_matched) {
		      _switchResult = 2;
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_3() {
		'''
		class Foo {
			def foo() {
				switch x : 1 {
					case 1d: 1
					default: 2
				}
			}
		}
		'''.assertCompilesTo(
		'''
		import com.google.common.base.Objects;
		
		@SuppressWarnings("all")
		public class Foo {
		  public int foo() {
		    int _switchResult = (int) 0;
		    final int x = 1;
		    boolean _matched = false;
		    if (!_matched) {
		      if (Objects.equal(x, 1d)) {
		        _matched=true;
		        _switchResult = 1;
		      }
		    }
		    if (!_matched) {
		      _switchResult = 2;
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_4() {
		'''
		class Foo {
			def foo() {
				val char c = 'a'
				switch c {
					case c: true
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _xblockexpression = false;
		    {
		      final char c = 'a';
		      boolean _switchResult = false;
		      switch (c) {
		        case c:
		          _switchResult = true;
		          break;
		      }
		      _xblockexpression = _switchResult;
		    }
		    return _xblockexpression;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_5() {
		'''
		class Foo {
			def foo() {
				val char c = 'a'
				switch x : 1 {
					case c: true
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _xblockexpression = false;
		    {
		      final char c = 'a';
		      boolean _switchResult = false;
		      final int x = 1;
		      switch (x) {
		        case c:
		          _switchResult = true;
		          break;
		      }
		      _xblockexpression = _switchResult;
		    }
		    return _xblockexpression;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_6() {
		'''
		class Foo {
			def foo() {
				switch x : [|1].apply {
					case 1: true
				}
			}
		}
		'''.assertCompilesTo(
		'''
		import org.eclipse.xtext.xbase.lib.Functions.Function0;
		
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _switchResult = false;
		    final Function0<Integer> _function = new Function0<Integer>() {
		      public Integer apply() {
		        return Integer.valueOf(1);
		      }
		    };
		    Integer _apply = _function.apply();
		    final Integer x = _apply;
		    if (x != null) {
		      switch (x) {
		        case 1:
		          _switchResult = true;
		          break;
		      }
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_7() {
		'''
		class Foo {
			def foo() {
				switch x : 1 {
					case [|1].apply: true
				}
			}
		}
		'''.assertCompilesTo(
		'''
		import com.google.common.base.Objects;
		import org.eclipse.xtext.xbase.lib.Functions.Function0;
		
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _switchResult = false;
		    final int x = 1;
		    boolean _matched = false;
		    if (!_matched) {
		      final Function0<Integer> _function = new Function0<Integer>() {
		        public Integer apply() {
		          return Integer.valueOf(1);
		        }
		      };
		      Integer _apply = _function.apply();
		      if (Objects.equal(x, _apply)) {
		        _matched=true;
		        _switchResult = true;
		      }
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_8() {
		'''
		class Foo {
			def foo() {
				switch x : Thread.State.NEW {
					case Thread.State.NEW: true
					case Thread.State.RUNNABLE: false
					case BLOCKED: true
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _switchResult = false;
		    final Thread.State x = Thread.State.NEW;
		    if (x != null) {
		      switch (x) {
		        case NEW:
		          _switchResult = true;
		          break;
		        case RUNNABLE:
		          _switchResult = false;
		          break;
		        case BLOCKED:
		          _switchResult = true;
		          break;
		        default:
		          break;
		      }
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_9() {
		'''
		class Foo {
			def foo() {
				switch x : 1 {
					case 1: return true
					default: {
						if (x == 2) {
							return true;
						}
						return x == 3;
					}
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    final int x = 1;
		    switch (x) {
		      case 1:
		        return true;
		      default:
		        {
		          if ((x == 2)) {
		            return true;
		          }
		          return (x == 3);
		        }
		    }
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_10() {
		'''
		class Foo {
			def foo() {
				switch x : 1 {
					case 1:
						if (x == 2) {
							return true
						}
					default:
						if (x == 2) {
							return true
						}
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    final int x = 1;
		    switch (x) {
		      case 1:
		        if ((x == 2)) {
		          return true;
		        }
		        break;
		      default:
		        if ((x == 2)) {
		          return true;
		        }
		        break;
		    }
		    return false;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_11() {
		'''
		class Foo {
			def foo() {
				val y = try { 3 } finally {}
				val z = if (y == true) { 1 } else { 2 }
				switch x : 1 {
					case z: true
				}
			}
		}
		'''.assertCompilesTo(
		'''
		import com.google.common.base.Objects;
		
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _xblockexpression = false;
		    {
		      int _xtrycatchfinallyexpression = (int) 0;
		      try {
		        _xtrycatchfinallyexpression = 3;
		      } finally {
		      }
		      final int y = _xtrycatchfinallyexpression;
		      int _xifexpression = (int) 0;
		      boolean _equals = Objects.equal(Integer.valueOf(y), Boolean.valueOf(true));
		      if (_equals) {
		        _xifexpression = 1;
		      } else {
		        _xifexpression = 2;
		      }
		      final int z = _xifexpression;
		      boolean _switchResult = false;
		      final int x = 1;
		      boolean _matched = false;
		      if (!_matched) {
		        if (Objects.equal(x, z)) {
		          _matched=true;
		          _switchResult = true;
		        }
		      }
		      _xblockexpression = _switchResult;
		    }
		    return _xblockexpression;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_12() {
		'''
		class Foo {
			def foo() {
				val state = Thread.State.NEW
				switch x : Thread.State.NEW {
					case state: true
				}
			}
		}
		'''.assertCompilesTo(
		'''
		import com.google.common.base.Objects;
		
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _xblockexpression = false;
		    {
		      final Thread.State state = Thread.State.NEW;
		      boolean _switchResult = false;
		      final Thread.State x = Thread.State.NEW;
		      boolean _matched = false;
		      if (!_matched) {
		        if (Objects.equal(x, state)) {
		          _matched=true;
		          _switchResult = true;
		        }
		      }
		      _xblockexpression = _switchResult;
		    }
		    return _xblockexpression;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_13() {
		'''
		class Foo {
			def foo() {
				switch x : Integer.valueOf('1') {
					case 1:
						if (x == 2) {
							return true
						}
					default:
						if (x == 2) {
							return true
						}
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    Integer _valueOf = Integer.valueOf("1");
		    final Integer x = _valueOf;
		    if (x != null) {
		      switch (x) {
		        case 1:
		          if (((x).intValue() == 2)) {
		            return true;
		          }
		          break;
		        default:
		          if (((x).intValue() == 2)) {
		            return true;
		          }
		          break;
		      }
		    } else {
		      if (((x).intValue() == 2)) {
		        return true;
		      }
		    }
		    return false;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_14() {
		'''
		class Foo {
			def foo() {
				switch x : Thread.State.NEW {
					case NEW: true
					default: false
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public boolean foo() {
		    boolean _switchResult = false;
		    final Thread.State x = Thread.State.NEW;
		    if (x != null) {
		      switch (x) {
		        case NEW:
		          _switchResult = true;
		          break;
		        default:
		          _switchResult = false;
		          break;
		      }
		    } else {
		      _switchResult = false;
		    }
		    return _switchResult;
		  }
		}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_15() {
		'''
		class Foo {
			def foo() {
				switch x : new Integer(42) {
					case 32:
						'foo'
					default:
						if ('x'.length == 1) {
							'bar'
						}
				}
			}
		}
		'''.assertCompilesTo(
		'''
		@SuppressWarnings("all")
		public class Foo {
		  public String foo() {
		    String _switchResult = null;
		    Integer _integer = new Integer(42);
		    final Integer x = _integer;
		    if (x != null) {
		      switch (x) {
		        case 32:
		          _switchResult = "foo";
		          break;
		        default:
		          String _xifexpression = null;
		          int _length = "x".length();
		          boolean _equals = (_length == 1);
		          if (_equals) {
		            _xifexpression = "bar";
		          }
		          _switchResult = _xifexpression;
		          break;
		      }
		    } else {
		      String _xifexpression = null;
		      int _length = "x".length();
		      boolean _equals = (_length == 1);
		      if (_equals) {
		        _xifexpression = "bar";
		      }
		      _switchResult = _xifexpression;
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
	def testTryCatch_01() {
		assertCompilesTo('''
			package foo
			class Bar {
				def doStuff() {
					try {
						'foo'
					} catch (java.io.IOException e) {
						println("sideeffect")
						null
					}
				}
			}
		''', '''
			package foo;
			
			import java.io.IOException;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Bar {
			  public String doStuff() {
			    String _xtrycatchfinallyexpression = null;
			    try {
			      _xtrycatchfinallyexpression = "foo";
			    } catch (final Throwable _t) {
			      if (_t instanceof IOException) {
			        final IOException e = (IOException)_t;
			        Object _xblockexpression = null;
			        {
			          InputOutput.<String>println("sideeffect");
			          _xblockexpression = null;
			        }
			        _xtrycatchfinallyexpression = ((String)_xblockexpression);
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
	def testTryCatch_02() {
		assertCompilesTo('''
			package foo
			class Bar {
				def doStuff() {
					try {
						'foo'
					} catch (java.io.IOException e) {
						null
					}
				}
			}
		''', '''
			package foo;
			
			import java.io.IOException;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Bar {
			  public String doStuff() {
			    String _xtrycatchfinallyexpression = null;
			    try {
			      _xtrycatchfinallyexpression = "foo";
			    } catch (final Throwable _t) {
			      if (_t instanceof IOException) {
			        final IOException e = (IOException)_t;
			        _xtrycatchfinallyexpression = null;
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
			      final Function1<String, File> _function = new Function1<String, File>() {
			        public File apply(final String f) {
			          try {
			            File _file = new File(f);
			            return _file.getCanonicalFile();
			          } catch (Throwable _e) {
			            throw Exceptions.sneakyThrow(_e);
			          }
			        }
			      };
			      _xtrycatchfinallyexpression = ListExtensions.<String, File>map(_newArrayList, _function);
			    } catch (final Throwable _t) {
			      if (_t instanceof IOException) {
			        final IOException o = (IOException)_t;
			        _xtrycatchfinallyexpression = Collections.<File>emptyList();
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
			  
			  public Map<Object, String> bar() {
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
			    final Function1<String, Object> _function = new Function1<String, Object>() {
			      public Object apply(final String it) {
			        try {
			          return Foo.this.getFoo(it);
			        } catch (Throwable _e) {
			          throw Exceptions.sneakyThrow(_e);
			        }
			      }
			    };
			    return IterableExtensions.<Object, String>toMap(_newArrayList, _function);
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
			
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Bar {
			  private String s = CollectionLiterals.<Object>newArrayList().toString();
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

			@SuppressWarnings("all")
			public class Bar {
			  private String s = (this.toString() + super.toString());
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
			
			@SuppressWarnings("all")
			public class Bar {
			  public Bar() {
			    this(Integer.valueOf(123).toString());
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
			      throw new IOException();
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
			    throw new IOException();
			  }
			}
		''')
	}
	@Test
	def testSneakyThrow_02() {
		assertCompilesTo('''
			package foo
			
			import java.io.IOException
			
			class Bar {
				def void doStuff(java.io.File file) {
					throw new IllegalStateException(file.canonicalPath)
				}
			}
		''', '''
			package foo;
			
			import java.io.File;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Bar {
			  public void doStuff(final File file) {
			    try {
			      String _canonicalPath = file.getCanonicalPath();
			      throw new IllegalStateException(_canonicalPath);
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	@Test
	def testSneakyThrow_04() {
		assertCompilesTo('''
			package foo
			
			import java.io.IOException
			
			class Bar {
				def Object doStuff(java.io.File file) {
					return new IllegalStateException(file.canonicalPath)
				}
			}
		''', '''
			package foo;
			
			import java.io.File;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Bar {
			  public Object doStuff(final File file) {
			    try {
			      String _canonicalPath = file.getCanonicalPath();
			      return new IllegalStateException(_canonicalPath);
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	@Test
	def testSneakyThrow_03() {
		assertCompilesTo('''
			package foo
			
			import java.io.IOException
			
			class Bar {
				def void doStuff(java.io.File file) throws IOException {
					throw new IllegalStateException(file.canonicalPath)
				}
			}
		''', '''
			package foo;
			
			import java.io.File;
			import java.io.IOException;
			
			@SuppressWarnings("all")
			public class Bar {
			  public void doStuff(final File file) throws IOException {
			    String _canonicalPath = file.getCanonicalPath();
			    throw new IllegalStateException(_canonicalPath);
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
			    return Integer.valueOf(x.length());
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
			    return new String();
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
				def foo() {new java.util.HashMap<String, java.io.Serializable>()}
			}
		''', '''
			package foo;

			import java.io.Serializable;
			import java.util.HashMap;

			@SuppressWarnings("all")
			public class Bar {
			  public HashMap<String, Serializable> foo() {
			    return new HashMap<String, Serializable>();
			  }
			}
		''')
	}

	@Test
	def testConstructor_3() {
		assertCompilesTo('''
			class C<X extends java.io.IOException> {
				new () throws X {
				}
				def m() {
					new C
				}
			}
		''', '''
			import java.io.IOException;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C<X extends IOException> {
			  public C() throws X {
			  }
			  
			  public C<IOException> m() {
			    try {
			      return new C<IOException>();
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}

	@Test
	def testConstructor_4() {
		assertCompilesTo('''
			class C<X extends java.io.IOException> {
				new () throws X {
				}
				def void m() {
					new C
				}
			}
		''', '''
			import java.io.IOException;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C<X extends IOException> {
			  public C() throws X {
			  }
			  
			  public void m() {
			    try {
			      new C<IOException>();
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test
	def testConstructor_5() {
		'''
			class Foo {
			
				new () {
					super()
					foo
				}
			
				def foo() throws Exception {
				}
			
			}
		'''.assertCompilesTo(
			'''
				import org.eclipse.xtext.xbase.lib.Exceptions;
				
				@SuppressWarnings("all")
				public class Foo {
				  public Foo() {
				    super();
				    try {
				      this.foo();
				    } catch (Throwable _e) {
				      throw Exceptions.sneakyThrow(_e);
				    }
				  }
				  
				  public Object foo() throws Exception {
				    return null;
				  }
				}
			'''
		)
	}
	
	@Test
	def testConstructor_6() {
		'''
			class Foo {
			
				new () throws Exception {
					this('Hello world!')
				}
			
				new (String foo) throws Exception {
				}
			
			}
		'''.assertCompilesTo(
			'''
				@SuppressWarnings("all")
				public class Foo {
				  public Foo() throws Exception {
				    this("Hello world!");
				  }
				  
				  public Foo(final String foo) throws Exception {
				  }
				}
			'''
		)
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

			import com.google.common.base.Objects;

			@SuppressWarnings("all")
			public class Y {
			  public boolean equals(final Object p) {
			    boolean _xifexpression = false;
			    boolean _equals = Objects.equal("foo", p);
			    if (_equals) {
			      return true;
			    } else {
			      _xifexpression = super.equals(p);
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
			      _xblockexpression = this.getThing("");
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
			      _xblockexpression = super.getThing();
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
			    final ArrayList<?> _cacheKey = CollectionLiterals.newArrayList(x);
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
			  
			  private final HashMap<ArrayList<?>, StringBuilder> _createCache_aBuilder = CollectionLiterals.newHashMap();
			  
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
			    return new Bar<CharSequence>();
			  }
			  
			  public static Bar<StringBuilder> concreteFactory() {
			    return new Bar<StringBuilder>();
			  }
			  
			  public static <X extends String> Bar<X> parameterizedFactory() {
			    return new Bar<X>();
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
			    return new Bar<CharSequence>();
			  }
			  
			  public Bar<String> concreteFactory() {
			    return new Bar<String>();
			  }
			  
			  public Bar<T> parameterizedFactory() {
			    return new Bar<T>();
			  }
			  
			  public <X extends T> Bar<X> concreteParameterizedFactory() {
			    return new Bar<X>();
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
			      final Function1<String, String> _function = new Function1<String, String>() {
			        public String apply(final String it) {
			          final Function1<String, String> _function = new Function1<String, String>() {
			            public String apply(final String it) {
			              return it;
			            }
			          };
			          return _function.apply(it);
			        }
			      };
			      final Function1<? super String, ? extends String> function = _function;
			      _xblockexpression = function.apply("foo");
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
			            return X.super.toString();
			          }
			        };
			        return _function.apply();
			      }
			    };
			    return _function.apply();
			  }
			}
		''')
	}

	@Test
	def testExplicitBoxingUnboxing_01() {
		assertCompilesTo('''
			class X {
				def foo(int p0, Integer p1) {
					foo(p1, p0)
				}
			}
		''','''
			@SuppressWarnings("all")
			public class X {
			  public Object foo(final int p0, final Integer p1) {
			    return this.foo((p1).intValue(), Integer.valueOf(p0));
			  }
			}
		''')
	}
	
	@Test def testExplicitBoxingUnboxing_02() {
		assertCompilesTo('''
			class X {
				def Object foo(int p0, Integer p1) {
					foo(p1, p0)
				}
			}
		''','''
			@SuppressWarnings("all")
			public class X {
			  public Object foo(final int p0, final Integer p1) {
			    return this.foo((p1).intValue(), Integer.valueOf(p0));
			  }
			}
		''')
	}
	
	@Test def testExplicitBoxingUnboxing_03() {
		assertCompilesTo('''
			class X {
				def foo(Object o) {
					if (o instanceof Long) {
						o.bar
					}
				}
				
				def bar(long o) {
					
				}
			}
		''','''
			@SuppressWarnings("all")
			public class X {
			  public Object foo(final Object o) {
			    Object _xifexpression = null;
			    if ((o instanceof Long)) {
			      _xifexpression = this.bar(((Long) o).longValue());
			    }
			    return _xifexpression;
			  }
			  
			  public Object bar(final long o) {
			    return null;
			  }
			}
		''')
	}
	
	@Test def testExplicitBoxingUnboxing_04() {
		assertCompilesTo('''
			class X {
				def foo(Object o) {
					switch o {
						Long: o.bar
					}
				}
				
				def bar(long o) {
					
				}
			}
		''','''
			@SuppressWarnings("all")
			public class X {
			  public Object foo(final Object o) {
			    Object _switchResult = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (o instanceof Long) {
			        _matched=true;
			        _switchResult = this.bar(((Long) o).longValue());
			      }
			    }
			    return _switchResult;
			  }
			  
			  public Object bar(final long o) {
			    return null;
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
			    return ((x + "") + y);
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
			    final String z = ((x + "") + y);
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
			              (break_ + continue_).toString();
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
	def testFindFirstOnIt_01() {
		assertCompilesTo(
			'''
				class FindFirstOnIt {
					def <T> useExtension(Iterable<T> it) {
						findFirst [ it !== null ]
					}
				}
			''', '''
				import org.eclipse.xtext.xbase.lib.Functions.Function1;
				import org.eclipse.xtext.xbase.lib.IterableExtensions;
				
				@SuppressWarnings("all")
				public class FindFirstOnIt {
				  public <T extends Object> T useExtension(final Iterable<T> it) {
				    final Function1<T, Boolean> _function = new Function1<T, Boolean>() {
				      public Boolean apply(final T it) {
				        return Boolean.valueOf((it != null));
				      }
				    };
				    return IterableExtensions.<T>findFirst(it, _function);
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
				
				@SuppressWarnings("all")
				public class MyClass implements ReturnTypeUsesTypeParameter {
				  public <LocalName extends CharSequence> ReturnTypeUsesTypeParameter.Inner<LocalName> accept(final LocalName param) {
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
				
				@SuppressWarnings("all")
				public class MyClass implements ReturnTypeUsesTypeParameter {
				  public <LocalName extends CharSequence> ReturnTypeUsesTypeParameter.Inner<LocalName> accept(final LocalName param) {
				    final ReturnTypeUsesTypeParameter.Inner<LocalName> _function = new ReturnTypeUsesTypeParameter.Inner<LocalName>() {
				      public void useProcedure(final Procedure1<? super LocalName> it) {
				        if (true) {
				          if (it!=null) {
				            it.apply(param);
				          }
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
			    return this.client(_m);
			  }
			  
			  public CharSequence m() {
			    return "";
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
				    return InputOutput.<String>println(_builder.toString());
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
				      _xblockexpression = x;
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
				      _xblockexpression = x;
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
				    return _builder.toString();
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
				    return InputOutput.<String>println(_builder.toString());
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
			 * This comment is ambiguous because it could be both a file header and a
			 * class comment. In any case it should be generated only once.
			 */
			
			class bar {
			}
		''',
		'''
			/**
			 * This comment is ambiguous because it could be both a file header and a
			 * class comment. In any case it should be generated only once.
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
		var barJavaCode = generator.generateType(barType, generatorConfig);
		barJavaCode = postProcessor.postProcess(null, barJavaCode);
		var bazJavaCode = generator.generateType(bazType, generatorConfig);
		bazJavaCode = postProcessor.postProcess(null, bazJavaCode);
		XtendCompilerTest::assertEquals(expectedBarClass.toString, barJavaCode.toString);
		XtendCompilerTest::assertEquals(expectedBazClass.toString, bazJavaCode.toString);
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
	def compilePackagePrivateClass() {
		assertCompilesTo('''
			package class Foo {
			}
		''', '''
			@SuppressWarnings("all")
			class Foo {
			}
		''')
	}

	@Test
	def compilePackagePrivateInterface() {
		assertCompilesTo('''
			package interface Foo {
			}
		''', '''
			@SuppressWarnings("all")
			interface Foo {
			}
		''')
	}

	@Test
	def compilePackagePrivateEnum() {
		assertCompilesTo('''
			package enum Foo {
			}
		''', '''
			@SuppressWarnings("all")
			enum Foo {
			}
		''')
	}

	@Test
	def compilePackagePrivateAnnotationType() {
		assertCompilesTo('''
			package annotation Foo {
			}
		''', '''
			@interface Foo {
			}
		''')
	}
	
	@Test def testNullSafeFeatureCall_07() {
		assertCompilesTo(
				'''
					class Foo {
						extension org.eclipse.xtext.xbase.lib.util.ReflectExtensions
						def bar() throws Throwable {
							new String().get('toString')?.get('substring')
						}
					}
				''', '''
					import org.eclipse.xtext.xbase.lib.Extension;
					import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
					
					@SuppressWarnings("all")
					public class Foo {
					  @Extension
					  private ReflectExtensions _reflectExtensions;
					  
					  public Object bar() throws Throwable {
					    String _string = new String();
					    Object _get = this._reflectExtensions.<Object>get(_string, "toString");
					    Object _get_1 = null;
					    if (_get!=null) {
					      _get_1=this._reflectExtensions.<Object>get(_get, "substring");
					    }
					    return _get_1;
					  }
					}
				''');
	}
	
	@Test def testNullSafeFeatureCall_08() {
		assertCompilesTo(
				'''
					class Foo {
						String field
						def bar(String str) {
							new Foo().field?.toString?.substring(1) ?: ''
						}
					}
				''', '''
					@SuppressWarnings("all")
					public class Foo {
					  private String field;
					  
					  public String bar(final String str) {
					    String _elvis = null;
					    Foo _foo = new Foo();
					    String _field = _foo.field;
					    String _string = null;
					    if (_field!=null) {
					      _string=_field.toString();
					    }
					    String _substring = null;
					    if (_string!=null) {
					      _substring=_string.substring(1);
					    }
					    if (_substring != null) {
					      _elvis = _substring;
					    } else {
					      _elvis = "";
					    }
					    return _elvis;
					  }
					}
				''');
	}
	
	@Test def testNullSafeFeatureCall_09() {
		assertCompilesTo(
				'''
					class BlockExpression {
					   def foo(String source) {
					        val x = { "" }?.toString
					        val y = {{{ "" }}}?.toString
					        val z = {{{ var i = 1; "" + i }}}?.toString
					   }
					}
				''', '''
					@SuppressWarnings("all")
					public class BlockExpression {
					  public void foo(final String source) {
					    String _string = null;
					    if (""!=null) {
					      _string="".toString();
					    }
					    final String x = _string;
					    String _string_1 = null;
					    if (""!=null) {
					      _string_1="".toString();
					    }
					    final String y = _string_1;
					    String _xblockexpression = null;
					    {
					      int i = 1;
					      _xblockexpression = ("" + Integer.valueOf(i));
					    }
					    String _string_2 = null;
					    if (_xblockexpression!=null) {
					      _string_2=_xblockexpression.toString();
					    }
					    final String z = _string_2;
					  }
					}
				''');
	}
	
	@Test def testNullSafeFeatureCall_10() {
		assertCompilesTo(
				'''
					class StrangeBug {
					    def getAnzuwendendeModi(String source) {
						    {
						        if (true)
						            <String>newArrayList()
						        else {
						            <String>newHashSet()
						        }
						    }?.toList
					    }
					}
				''', '''
					import java.util.AbstractCollection;
					import java.util.List;
					import org.eclipse.xtext.xbase.lib.CollectionLiterals;
					import org.eclipse.xtext.xbase.lib.IterableExtensions;
					
					@SuppressWarnings("all")
					public class StrangeBug {
					  public List<String> getAnzuwendendeModi(final String source) {
					    AbstractCollection<String> _xifexpression = null;
					    if (true) {
					      _xifexpression = CollectionLiterals.<String>newArrayList();
					    } else {
					      _xifexpression = CollectionLiterals.<String>newHashSet();
					    }
					    List<String> _list = null;
					    if (_xifexpression!=null) {
					      _list=IterableExtensions.<String>toList(_xifexpression);
					    }
					    return _list;
					  }
					}
				''');
	}
	
	@Test def void testBug412642_01() throws Exception {
		'''
			package org.xtext.example.mydsl

			class Bug412642 {
			
				val pairField = "Orange" -> 3
			
				def bar() {
					val pair = "Apple" -> 1
					val _pair = pair;
					val map = #{
						pair,
						_pair,
						"Banana" -> 2,
						Bug412642_2.staticPair,
						pairField,
						Bug412642_2.methodStaticPair,
						1 + 2
					}
					
					val set = #{
						1 * 2,
						"Banana" -> 2
					}
				}
				
				def Pair<Object, Object> operator_plus(int operant, int operand2) {
					
				}
			
			}
			
			class Bug412642_2 {
			
				val public static staticPair = "Mango" -> 4
				
				def static methodStaticPair () {
					staticPair
				}
			
			}
		'''.assertCompilesTo('''
			package org.xtext.example.mydsl;
			
			import java.io.Serializable;
			import java.util.Collections;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pair;
			import org.xtext.example.mydsl.Bug412642_2;
			
			@SuppressWarnings("all")
			public class Bug412642 {
			  private final Pair<String, Integer> pairField = Pair.<String, Integer>of("Orange", Integer.valueOf(3));
			  
			  public void bar() {
			    final Pair<String, Integer> pair = Pair.<String, Integer>of("Apple", Integer.valueOf(1));
			    final Pair<String, Integer> _pair = pair;
			    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("Banana", Integer.valueOf(2));
			    Pair<String, Integer> _methodStaticPair = Bug412642_2.methodStaticPair();
			    Pair<Object, Object> _plus = this.operator_plus(
			      1, 2);
			    final Map<Object, Object> map = Collections.<Object, Object>unmodifiableMap(CollectionLiterals.<Object, Object>newHashMap(pair, _pair, _mappedTo, Bug412642_2.staticPair, this.pairField, _methodStaticPair, _plus));
			    Pair<String, Integer> _mappedTo_1 = Pair.<String, Integer>of("Banana", Integer.valueOf(2));
			    final Set<? extends Serializable> set = Collections.<Serializable>unmodifiableSet(CollectionLiterals.<Serializable>newHashSet(Integer.valueOf((1 * 2)), _mappedTo_1));
			  }
			  
			  public Pair<Object, Object> operator_plus(final int operant, final int operand2) {
			    return null;
			  }
			}
		''')
	}
	
	@Test def void testBug412642_02() throws Exception {
		'''
			package org.xtext.example.mydsl

			class Bug412642 {
			
				val pairField = "Orange" -> 3
				def bar() {
					val pair = "Apple" -> 1
					val _pair = pair;
					val map = #{
						pair,
						_pair,
						"Banana" -> 2,
						Bug412642_2.staticPair,
						pairField,
						Bug412642_2.methodStaticPair,
						1 + 2
					}
					val set = #{
						1 * 2,
						"Banana" -> 2
					}
				}
				def Pair<Object, Object> +(int operant, int operand2) {
				}
			
			}
			
			class Bug412642_2 {
			
				val public static staticPair = "Mango" -> 4
				def static methodStaticPair () {
					staticPair
				}
			
			}
		'''.assertCompilesTo('''
			package org.xtext.example.mydsl;
			
			import java.io.Serializable;
			import java.util.Collections;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pair;
			import org.xtext.example.mydsl.Bug412642_2;
			
			@SuppressWarnings("all")
			public class Bug412642 {
			  private final Pair<String, Integer> pairField = Pair.<String, Integer>of("Orange", Integer.valueOf(3));
			  
			  public void bar() {
			    final Pair<String, Integer> pair = Pair.<String, Integer>of("Apple", Integer.valueOf(1));
			    final Pair<String, Integer> _pair = pair;
			    Pair<String, Integer> _mappedTo = Pair.<String, Integer>of("Banana", Integer.valueOf(2));
			    Pair<String, Integer> _methodStaticPair = Bug412642_2.methodStaticPair();
			    Pair<Object, Object> _plus = this.operator_plus(
			      1, 2);
			    final Map<Object, Object> map = Collections.<Object, Object>unmodifiableMap(CollectionLiterals.<Object, Object>newHashMap(pair, _pair, _mappedTo, Bug412642_2.staticPair, this.pairField, _methodStaticPair, _plus));
			    Pair<String, Integer> _mappedTo_1 = Pair.<String, Integer>of("Banana", Integer.valueOf(2));
			    final Set<? extends Serializable> set = Collections.<Serializable>unmodifiableSet(CollectionLiterals.<Serializable>newHashSet(Integer.valueOf((1 * 2)), _mappedTo_1));
			  }
			  
			  public Pair<Object, Object> operator_plus(final int operant, final int operand2) {
			    return null;
			  }
			}
		''')
	}
	
	@Test(timeout = 20000)
	def void testBug412853 () {
		'''
			class Bug {
				def dispatch bug(A a) { 1 }
				def dispatch bug(B b) { 1 }
			}
			
			interface Element<T> {}
			class AbstractElement<T> implements Element<T> {}
			class A extends AbstractElement<A> implements Element<A> {}
			class B implements Element<B> {}
		'''.assertCompilesTo('''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class Bug {
			  protected int _bug(final A a) {
			    return 1;
			  }
			  
			  protected int _bug(final B b) {
			    return 1;
			  }
			  
			  public int bug(final Element<?> a) {
			    if (a instanceof A) {
			      return _bug((A)a);
			    } else if (a instanceof B) {
			      return _bug((B)a);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(a).toString());
			    }
			  }
			}
		''')
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=412363
	 */
	@Test
	def void testEmptyCollectionLiterals() {
		'''
			import java.util.List
			import java.util.Set
			
			class EmptyCollections {
			  
			  def emptyList() {
			    val List<String> result = #[];  // Erroneous type error here
			    result;
			  }
			  
			  def List<String> emptyList2 () {
			    #[]  // Erroneous type error here
			  }
			  
			  def emptySet() {
			    val Set<String> result = #{};  // Erroneous type error here
			    result;
			  }
			  
			  def Set<String> emptySet2 () {
			    #{} // Erroneous type error here
			  }
			  
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class EmptyCollections {
			  public List<String> emptyList() {
			    List<String> _xblockexpression = null;
			    {
			      final List<String> result = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
			      _xblockexpression = result;
			    }
			    return _xblockexpression;
			  }
			  
			  public List<String> emptyList2() {
			    return Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
			  }
			  
			  public Set<String> emptySet() {
			    Set<String> _xblockexpression = null;
			    {
			      final Set<String> result = Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
			      _xblockexpression = result;
			    }
			    return _xblockexpression;
			  }
			  
			  public Set<String> emptySet2() {
			    return Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet());
			  }
			}
		''')
	}
	
	@Test def void whileLoopWithReturnStatement() {
		'''
			class Foo {
				def foo() {
					val x = new StringBuilder
					while (x instanceof CharSequence) {
						return x.toString
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public String foo() {
			    final StringBuilder x = new StringBuilder();
			    while ((x instanceof CharSequence)) {
			      return x.toString();
			    }
			    return null;
			  }
			}
		''')
	}
	
	@Test def void basicForLoopWithReturnStatement() {
		'''
			class Foo {
				def foo() {
					for (val x = new StringBuilder; x instanceof CharSequence;) {
						return x.toString
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public String foo() {
			    for (final StringBuilder x = new StringBuilder(); (x instanceof CharSequence);) {
			      return x.toString();
			    }
			    return null;
			  }
			}
		''')
	}
	
	@Test def void basicForLoopWithDuplicateSyntheticVariables() {
		'''
			class Foo {
				def foo() {
					if ('a' == 'b') {
					}
					for (;;) {
						if ('b' == 'c') {
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;

			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    boolean _equals = Objects.equal("a", "b");
			    if (_equals) {
			    }
			    for (;;) {
			      boolean _equals_1 = Objects.equal("b", "c");
			      if (_equals_1) {
			      }
			    }
			  }
			}
		''')
	}
	 
	 
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=405142
	 */
	@Test def void testBug405142() {
		'''
			class Foo {
				def test() {
					var a = null
					Integer::valueOf(a)
					println(a)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Object test() {
			    Object _xblockexpression = null;
			    {
			      Object a = null;
			      Integer.valueOf(((String)a));
			      _xblockexpression = InputOutput.<Object>println(a);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	 
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=437027
	 */
	@Test def void testBug437027() {
		'''
			class Foo {
				def m() {
			      val x =
			            if(false) {
			               return ''
			            }
			      intExpectation(x)
			      return x
			   }
			   def void intExpectation(Integer s) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public String m() {
			    Object _xifexpression = null;
			    if (false) {
			      return "";
			    }
			    final Object x = _xifexpression;
			    this.intExpectation(((Integer)x));
			    return ((String)x);
			  }
			  
			  public void intExpectation(final Integer s) {
			  }
			}
		''')
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=437027
	 */
	@Test def void testBug437027_2() {
		'''
			class Foo {
			   def m() {
			      val x =
			         identity(
			            if(false) {
			               return ''
			            }
			         )
			      return x
			   }
			   
			   def <T> T identity(T t) {
			      return t
			   }
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public Object m() {
			    Object _xifexpression = null;
			    if (false) {
			      return "";
			    }
			    final Object x = this.<Object>identity(_xifexpression);
			    return x;
			  }
			  
			  public <T extends Object> T identity(final T t) {
			    return t;
			  }
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_01() {
		'''
			class Foo implements ()=>void {
			
				override apply() {
					
				}
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
			
			@SuppressWarnings("all")
			public class Foo implements Procedure0 {
			  public void apply() {
			  }
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_02() {
		'''
			interface Foo extends ()=>void {
			
				override void apply();
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
			
			@SuppressWarnings("all")
			public interface Foo extends Procedure0 {
			  public abstract void apply();
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_03() {
		'''
			class Foo implements (String)=>void {
			
				override apply(String value) {
					
				}
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public class Foo implements Procedure1<String> {
			  public void apply(final String value) {
			  }
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_04() {
		'''
			interface Foo extends (String)=>void {
			
				override void apply(String value);
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public interface Foo extends Procedure1<String> {
			  public abstract void apply(final String value);
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_05() {
		'''
			class Foo implements ((String)=>void)=>void {
			
				override apply((String)=>void procedure) {
					
				}
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public class Foo implements Procedure1<Procedure1<? super String>> {
			  public void apply(final Procedure1<? super String> procedure) {
			  }
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_06() {
		'''
			interface Foo extends ((String)=>void)=>void {
			
				override void apply((String)=>void procedure);
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public interface Foo extends Procedure1<Procedure1<? super String>> {
			  public abstract void apply(final Procedure1<? super String> procedure);
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_07() {
		'''
			class Foo implements ()=>String {
			
				override apply() {
					
				}
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo implements Function0<String> {
			  public String apply() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_08() {
		'''
			interface Foo extends ()=>String {
			
				override String apply();
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public interface Foo extends Function0<String> {
			  public abstract String apply();
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_09() {
		'''
			class Foo implements ()=>(String)=>void {
			
				override apply() {
					
				}
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Foo implements Function0<Procedure1<? super String>> {
			  public Procedure1<? super String> apply() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def void testXFunctionTypeRefAsSuperType_10() {
		'''
			interface Foo extends ()=>(String)=>void {
			
				override (String)=>void apply();
			
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public interface Foo extends Function0<Procedure1<? super String>> {
			  public abstract Procedure1<? super String> apply();
			}
		''')
	}
	
	@Test def void testBug463050() {
		'''
			class Foo {
				def String foo(java.util.Collection input) {
					switch input {
						java.util.ArrayList,
						java.util.LinkedList,
						java.util.Vector:
							return 'list'
						java.util.Map,
						java.util.Dictionary:
							return 'map'
						default :
							return null
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.Collection;
			import java.util.Dictionary;
			import java.util.LinkedList;
			import java.util.Map;
			import java.util.Vector;
			
			@SuppressWarnings("all")
			public class Foo {
			  public String foo(final Collection input) {
			    boolean _matched = false;
			    if (!_matched) {
			      if (input instanceof ArrayList) {
			        _matched=true;
			      }
			      if (!_matched) {
			        if (input instanceof LinkedList) {
			          _matched=true;
			        }
			      }
			      if (!_matched) {
			        if (input instanceof Vector) {
			          _matched=true;
			        }
			      }
			      if (_matched) {
			        return "list";
			      }
			    }
			    if (!_matched) {
			      if (input instanceof Map) {
			        _matched=true;
			      }
			      if (!_matched) {
			        if (input instanceof Dictionary) {
			          _matched=true;
			        }
			      }
			      if (_matched) {
			        return "map";
			      }
			    }
			    return null;
			  }
			}
		''')
	}
	
	@Test def void testSynchronized() {
		'''
			class Foo {
				def Object getLock() {
					return this
				}
				def void doStuff() {
					synchronized(getLock()) {
						println("hello")
						println("hello")
					}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Object getLock() {
			    return this;
			  }
			  
			  public void doStuff() {
			    synchronized (this.getLock()) {
			      InputOutput.<String>println("hello");
			      InputOutput.<String>println("hello");
			    }
			  }
			}
		''')
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
