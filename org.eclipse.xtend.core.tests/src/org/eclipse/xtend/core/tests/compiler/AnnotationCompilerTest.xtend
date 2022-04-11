/*******************************************************************************
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AnnotationCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def testAnnotationWithEnumValue_01() {
		assertCompilesTo('''
			class C {
				@A(NAME)
				String s1
				@A(value=NAME)
				String s2
			}
			annotation A {
				E value
			}
			enum E {
				NAME
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  @A(E.NAME)
			  private String s1;
			
			  @A(value = E.NAME)
			  private String s2;
			}
		''')
	}
	
	@Test
	def testAnnotationWithEnumValue_02() {
		assertCompilesTo('''
			class C {
				@A(NAME)
				String s1
				@A(NAME, NAME)
				String s2
				@A(#[NAME])
				String s3
				@A(value=NAME)
				String s4
				@A(value=#[NAME])
				String s5
			}
			annotation A {
				E[] value
			}
			enum E {
				NAME
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  @A(E.NAME)
			  private String s1;
			
			  @A({ E.NAME, E.NAME })
			  private String s2;
			
			  @A({ E.NAME })
			  private String s3;
			
			  @A(value = E.NAME)
			  private String s4;
			
			  @A(value = { E.NAME })
			  private String s5;
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
	def testAnnotationWithoutDefaultStringArray() {
		assertCompilesTo('''
			annotation DependsOn {
				String[] value
			}
		''', '''
			@SuppressWarnings("all")
			public @interface DependsOn {
			  public String[] value();
			}
		''')
	}
		
	@Test
	def testAnnotationWithDefaultEmptyStringArray() {
		assertCompilesTo('''
			annotation DependsOn {
				String[] value = #[]
			}
		''', '''
			@SuppressWarnings("all")
			public @interface DependsOn {
			  public String[] value() default {};
			}
		''')
	}
	
	@Test
	def testAnnotationWithDefaultStringArray() {
		assertCompilesTo('''
			annotation DependsOn {
				String[] value = #[ 'abc', 'efg' ]
			}
		''', '''
			@SuppressWarnings("all")
			public @interface DependsOn {
			  public String[] value() default { "abc", "efg" };
			}
		''')
	}
	
	@Test
	def testAnnotationWithDefaultIntArray() {
		assertCompilesTo('''
			annotation DependsOn {
				int[] value = #[ 1, 2 ]
			}
		''', '''
			@SuppressWarnings("all")
			public @interface DependsOn {
			  public int[] value() default { 1, 2 };
			}
		''')
	}
	
	@Test
	def testAnnotationWithDefaultBooleanArray() {
		assertCompilesTo('''
			annotation DependsOn {
				boolean[] value = #[ true, true ]
			}
		''', '''
			@SuppressWarnings("all")
			public @interface DependsOn {
			  public boolean[] value() default { true, true };
			}
		''')
	}
	
	@Test
	def testAnnotationWithDefaultLongArray() {
		assertCompilesTo('''
			annotation DependsOn {
				long[] value = #[ 1l, 2l ]
			}
		''', '''
			@SuppressWarnings("all")
			public @interface DependsOn {
			  public long[] value() default { 1l, 2l };
			}
		''')
	}
	
	@Test
	def testAnnotationWithClassArray() {
		assertCompilesTo('''
			annotation DependsOn {
				Class<?>[] value = #[ typeof(String), typeof(CharSequence) ]
			}
		''', '''
			@SuppressWarnings("all")
			public @interface DependsOn {
			  public Class<?>[] value() default { String.class, CharSequence.class };
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
			@SuppressWarnings("all")
			public @interface Bar {
			  @Inject
			  public String string();
			}
		''')
	}
	
	@Test
	def compileAnnotationWithFileHeader(){
		assertCompilesTo(
		''' 
			/**
			 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
			 * This program and the accompanying materials are made available under the
			 * terms of the Eclipse Public License 2.0 which is available at
			 * http://www.eclipse.org/legal/epl-2.0.
			 * 
			 * SPDX-License-Identifier: EPL-2.0
			 */
			package foo
			
			annotation bar { 
			    String name = 'foobar'
			}
		''',
		'''
			/**
			 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
			 * This program and the accompanying materials are made available under the
			 * terms of the Eclipse Public License 2.0 which is available at
			 * http://www.eclipse.org/legal/epl-2.0.
			 * 
			 * SPDX-License-Identifier: EPL-2.0
			 */
			package foo;
			
			@SuppressWarnings("all")
			public @interface bar {
			  public String name() default "foobar";
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
			@SuppressWarnings("all")
			public @interface MyAnnotation {
			  public String x();
			  public int y();
			  public Class<?>[] value();
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
			@SuppressWarnings("all")
			public @interface MyAnnotation {
			  public String x() default "foo";
			  public int y() default 42;
			  public Class<?> value() default String.class;
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
			@SuppressWarnings("all")
			public @interface annotation {
			  public String annotation() default "foo";
			  public String inferred() default "bar";
			  public Class<StringBuilder> inferredClass() default StringBuilder.class;
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
			  private static final int a = 4;
			
			  @Click({ TestXtend.a, TestXtend.a })
			  public Object meth() {
			    return null;
			  }
			}
		''')
	}
	
	@Test def testAnnotationWithIntArrayAndComputation() throws Exception {
		'''
			class TestXtend {
				val static int a = 4
				
				@Click(#[ a, a.bitwiseAnd(3) << 1 ])
				def meth() {}
			}
			
			annotation Click {
				int[] value
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class TestXtend {
			  private static final int a = 4;
			
			  @Click({ TestXtend.a, ((TestXtend.a & 3) << 1) })
			  public Object meth() {
			    return null;
			  }
			}
		''')
	}
	
	/// @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=448564
	@Test def testInnerEnum() {
		'''
			annotation A {
			    enum B { C }
				B b
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public @interface A {
			  public enum B {
			    C;
			  }
			  public A.B b();
			}
		''')
	}
	
	@Test
	def void testInterfaceExtendsAnnotation() {
		'''
		import java.lang.annotation.Annotation
		annotation MyAnno {
			static interface MyIf extends MyAnno {
			}
			static class MyClass implements MyIf {
				override Class<? extends Annotation> annotationType() {
					return null;
				}
			}
			static class MyClass2 implements MyAnno {
				override Class<? extends Annotation> annotationType() {
					return null;
				}
			}
		}
		'''.assertCompilesTo('''
		import java.lang.annotation.Annotation;
		
		@SuppressWarnings("all")
		public @interface MyAnno {
		  public interface MyIf extends MyAnno {
		  }
		  public static class MyClass implements MyAnno.MyIf {
		    public Class<? extends Annotation> annotationType() {
		      return null;
		    }
		  }
		  public static class MyClass2 implements MyAnno {
		    public Class<? extends Annotation> annotationType() {
		      return null;
		    }
		  }
		}
		''')
	}
}