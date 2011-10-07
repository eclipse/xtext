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

			import java.util.NoSuchElementException;

			@SuppressWarnings("all")
			public class NoSuchElementException extends NoSuchElementException {
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
					if ((s instanceof String)) {
					  _foo((String)s);
					} else {
					  _foo((Object)s);
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

	def assertCompilesTo(CharSequence input, CharSequence expected) {
		val file = file(input.toString(), true)
		val inferredType = file.xtendClass.inferredType
		val javaCode = generator.generateType(inferredType);
		Xtend2CompilerTest::assertEquals(expected.toString, javaCode.toString);
	}
	
}