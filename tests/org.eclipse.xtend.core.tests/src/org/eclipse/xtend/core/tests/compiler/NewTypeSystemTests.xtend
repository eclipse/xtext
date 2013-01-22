/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.eclipse.xtend.core.tests.NewTypeSystemRuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.junit.runner.RunWith
import org.junit.Test
import org.junit.Ignore
import org.eclipse.xtext.xbase.lib.Functions$Function1

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class CompilerTest2 extends AbstractCompilerTest {
	@Test
	override testBug343096_01() throws Exception {
		compileJavaCode("x.Y",
				"package x class Y {" +
				"def <T> bug343096() {\n" + 
				"  [T t|switch t {\n" + 
				"    case t : bug343096\n" + 
				"  }]" + 
				"}}");
	}
	
	@Test
	override testBug343096_02() throws Exception {
		invokeAndExpect2(
				typeof(Functions$Function1).canonicalName,
				"def <T> bug343096() {
				  [T t|switch t { 
				    case t : bug343096 
				  }].getClass.interfaces.head.canonicalName 
				}", "bug343096");
	}
	
	@Test
	override testBug343096_03() throws Exception {
		invokeAndExpect2(
				typeof(Object).canonicalName,
				"def <T> String bug343096() {
				  [T t|switch t { 
				    case t : bug343096 
				  }].getClass.superclass.canonicalName 
				}", "bug343096");
	}
	
	@Test
	@Ignore("TODO deferred typing of local vars which are currently 'any'")
	override testBug_350932_13() throws Exception {
		super.testBug_350932_13()
	}
	
	@Test
	@Ignore("TODO deferred typing of local vars which are currently 'any'")
	override testBug_350932_14() throws Exception {
		super.testBug_350932_14()
	}
	
	@Test
	@Ignore("TODO use the type expectation to bind type arguments")
	override testBug_352849_02() throws Exception {
		super.testBug_352849_02()
	}
	
	@Test
	@Ignore("TODO Currently there is no way to refer to computed types in the jvm model inferer")
	override testData_03() throws Exception {
		super.testData_03()
	}
	
	// overridden variant eliminates recursion
	@Test
	override testEscapeCharacterForReservedNames() throws Exception {
		val code = 'package x class Z {
			  def Object create(Object x) {
			    create(x)
			  }
			}'
		val javaCode = compileToJavaCode(code)
		javaCompiler.compileToClass("x.Z", javaCode)
	}
	
	@Test
	def void testEscapeCharacterForReservedNames_02() throws Exception {
		val code = 'package x class Z {
			  def create(Object x) {
			    create(x)
			  }
			}'
		val javaCode = compileToJavaCode(code)
		javaCompiler.compileToClass("x.Z", javaCode)
	}
	
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class XtendCompilerTest2 extends AbstractXtendCompilerTest {
	
	@Test
	override testReturnType_02() {
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
	@Ignore("TODO implement better expectation computation for unresolved type parameters")
	override testRichStringAutoConversionToString_02() {
		fail("TODO implement better expectation computation for unresolved type parameters")
	}
	
	@Test
	@Ignore("TODO implement better expectation computation for unresolved type parameters")
	override testRichStringNoAutoConversionToString_03() {
		fail("TODO implement better expectation computation for unresolved type parameters")
	}
	
	@Test 
	override testBug380062_01() {
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
	
	@Test
	override testExplicitBoxingUnboxing() {
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
	
	@Test override testThreeDataClassesExtendingEachOther() {
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
			    Class<? extends Node> _class = this.getClass();«/* super impl asserts Class<? extends Object> */»
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
	
	@Test override testSwitchOverNull() {
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
	
	// TODO elvis should evaluate the right side lazy
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
			          final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
			              public Boolean apply(final T it) {
			                boolean _notEquals = ObjectExtensions.operator_notEquals(it, null);
			                return Boolean.valueOf(_notEquals);
			              }
			            };
			          T _findFirst = IteratorExtensions.<T>findFirst(iter, _function);
			          T _endOfData = this.endOfData();
			          T _elvis = ObjectExtensions.<T>operator_elvis(_findFirst, _endOfData);
			          return _elvis;
			        }
			      };
			    final AbstractIterator<T> result = _function;
			    return result;
			  }
			}
		''')
	}
	
	// TODO elvis should evaluate the right side lazy
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
				          final Function1<T,Boolean> _function = new Function1<T,Boolean>() {
				              public Boolean apply(final T it) {
				                boolean _notEquals = ObjectExtensions.operator_notEquals(it, null);
				                return Boolean.valueOf(_notEquals);
				              }
				            };
				          T _findFirst = IteratorExtensions.<T>findFirst(it, _function);
				          T _endOfData = this.endOfData();
				          T _elvis = ObjectExtensions.<T>operator_elvis(_findFirst, _endOfData);
				          return _elvis;
				        }
				      };
				    final AbstractIterator<T> result = _function;
				    return result;
				  }
				}
			''')
	}
}

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(NewTypeSystemRuntimeInjectorProvider))
class XtendCompilerErrorHandlingTest2 extends XtendCompilerErrorHandlingTest {
	
	@Test
	@Ignore("TODO")
	override testUnresolvedReturnType() {
		super.testUnresolvedReturnType()
	}
	
	@Test
	@Ignore("TODO")
	override testFieldInitializerTypeError() {
		super.testFieldInitializerTypeError()
	}
	
	@Test
	@Ignore("TODO")
	override testFieldInitializerLinkError() {
		super.testFieldInitializerLinkError()
	}
	
	@Test
	@Ignore("TODO")
	override testMethodBodyTypeError() {
		super.testMethodBodyTypeError()
	}
	
	@Test
	@Ignore("TODO")
	override testMethodBodyLinkError() {
		super.testMethodBodyLinkError()
	}
	
}