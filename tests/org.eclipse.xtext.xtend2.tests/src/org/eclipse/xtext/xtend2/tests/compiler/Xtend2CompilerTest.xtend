package org.eclipse.xtext.xtend2.tests.compiler

import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator
import com.google.inject.Inject
import org.eclipse.xtext.xtend2.jvmmodel.IXtend2JvmAssociations

class Xtend2CompilerTest extends AbstractXtend2TestCase {
	
	@Inject JvmModelGenerator generator
	
	@Inject extension IXtend2JvmAssociations 
	
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
			    } catch (Exception _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
//	see  
//	def testClosureSneakyThrow() {
//		assertCompilesTo('''
//		import java.io.File
//		import java.io.IOException
//		import java.util.Collections
//		
//		class Foo  {     
//		   def bar() {               
//		       try {       
//		           newArrayList("file1.ext").map(f| new File(f).canonicalFile) 
//		       } catch(IOException o) {  
//		           Collections::<File>emptyList
//		       } 
//		   }
//		}
//		''','''
//		''')
//	}
	
	
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
			      ArrayList _newArrayList = CollectionLiterals.<Object>newArrayList();
			      String _string = _newArrayList.toString();
			      return _string;
			    }
			  }.apply();
			}
		''')
	}
	
	def testFieldInitialization_04() { 
		assertCompilesTo('''
			package foo
			class Bar {
				String s = toString + super.toString
			}
		''', '''
			package foo;

			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.StringExtensions;

			@SuppressWarnings("all")
			public class Bar {
			  private String s = new Function0<String>() {
			    public String apply() {
			      String _string = Bar.this.toString();
			      String _string_1 = Bar.super.toString();
			      String _operator_plus = StringExtensions.operator_plus(_string, _string_1);
			      return _operator_plus;
			    }
			  }.apply();
			}
		''')
	}
	
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
			        String _string = ((Integer)123).toString();
			        return _string;
			      }
			    }.apply());
			  }
			  
			  public Bar(final String s) {
			  }
			}
		''')
	}
	
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
			    } catch (Exception _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
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
			    return ((Integer)_length);
			  }
			}
		''')
	}

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

	def testVisibilityOfDispatchMethods() {
		assertCompilesTo('''
			package foo
			class NoSuchElementException {
				def dispatch void foo(String s) {}
				def dispatch void foo(Object s) {}
			}
		''', '''
			package foo;

			@SuppressWarnings("all")
			public class NoSuchElementException {
			  protected void _foo(final String s) {
			  }
			  
			  protected void _foo(final Object s) {
			  }
			  
			  public void foo(final Object s) {
			    if (s instanceof String) {
			      _foo((String)s);
			    } else {
			      _foo(s);
			    }
			  }
			}
		''')
	}
	
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

			@SuppressWarnings("all")
			public class MyType {
			  protected void _foo(final String s, final CharSequence other) {
			  }
			  
			  protected void _foo(final String s, final Void other) {
			  }
			  
			  protected void _foo(final Object s, final Object other) {
			  }
			  
			  public void foo(final Object s, final Object other) {
			    if ((s instanceof String)
			         && (other instanceof CharSequence)) {
			      _foo((String)s, (CharSequence)other);
			    } else if ((s instanceof String)
			         && (other == null)) {
			      _foo((String)s, (Void)null);
			    } else {
			      _foo(s, other);
			    }
			  }
			}
		''')
	}
	
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

			@SuppressWarnings("all")
			public class MyType {
			  protected void _foo(final Object s, final Object other) {
			  }
			  
			  protected void _foo(final String s, final Void other) {
			  }
			  
			  protected void _foo(final String s, final CharSequence other) {
			  }
			  
			  public void foo(final Object s, final Object other) {
			    if ((s instanceof String)
			         && (other instanceof CharSequence)) {
			      _foo((String)s, (CharSequence)other);
			    } else if ((s instanceof String)
			         && (other == null)) {
			      _foo((String)s, (Void)null);
			    } else {
			      _foo(s, other);
			    }
			  }
			}
		''')
	}

	def testNoUncessaryCastInDispatchMethods() {
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
			    } else if (s instanceof StringBuilder) {
			      _foo((StringBuilder)s, b, other);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(s, b, other).toString());
			    }
			  }
			}
		''')
	}

//	def testExtendsArrayList_01()  {
//		assertCompilesTo('''
//			package foo
//			class MyList<T> extends java.util.ArrayList<T> {}
//		''', '''
//			package foo;
//			
//			import java.util.ArrayList;
//			
//			@SuppressWarnings("all")
//			public class MyList<T> extends ArrayList<T> {
//			}
//		''')
//	}
//
//	def testExtendsArrayList_02() {
//		assertCompilesTo('''
//			package foo
//			class StringList extends java.util.ArrayList<String> {
//			}
//		''', '''
//			package foo;
//			
//			import java.util.ArrayList;
//			
//			@SuppressWarnings("all")
//			public class StringList<T> extends ArrayList<String> {
//			}
//		''')
//	}

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
	
	def testSuperCall() {
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
			    boolean _operator_equals = ObjectExtensions.operator_equals("foo", p);
			    if (_operator_equals) {
			      return true;
			    } else {
			      boolean _equals = super.equals(p);
			      _xifexpression = _equals;
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
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
			  
			  private final HashMap<ArrayList<?>,StringBuilder> _createCache_aBuilder = CollectionLiterals.newHashMap();
			  
			  private void _init_aBuilder(final StringBuilder result, final String x) {
			    result.append(x);
			  }
			}
		''');
	}

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

	def assertCompilesTo(CharSequence input, CharSequence expected) {
		val file = file(input.toString(), true)
		val inferredType = file.xtendClass.inferredType
		val javaCode = generator.generateType(inferredType);
		Xtend2CompilerTest::assertEquals(expected.toString, javaCode.toString);
	}
	
}