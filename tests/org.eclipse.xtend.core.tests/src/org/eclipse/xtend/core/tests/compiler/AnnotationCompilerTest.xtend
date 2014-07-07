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
			  private final static int a = 4;
			  
			  @Click({ TestXtend.a, TestXtend.a })
			  public Object meth() {
			    return null;
			  }
			}
		''')
	}	 
}