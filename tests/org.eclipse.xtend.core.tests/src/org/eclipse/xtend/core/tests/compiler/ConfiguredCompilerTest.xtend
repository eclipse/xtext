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
class ConfiguredCompilerTest extends AbstractXtendCompilerTest {
	
//	@Test XXX Annotations are now generated in the JVM model inferrer, which is not affected by the locally created configuration!
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
	
//	@Test XXX Annotations are now generated in the JVM model inferrer, which is not affected by the locally created configuration!
	def testAnnotationWithValueArray_01() {
		val generatorConfig = generatorConfigProvider.get(null)
		generatorConfig.setGenerateSyntheticSuppressWarnings(false)
		assertCompilesTo('''
			@SuppressWarnings(#[ 'abc', 'efg' ])
			class C {
			}
		''', '''
			@SuppressWarnings({ "abc", "efg" })
			public class C {
			}
		''', generatorConfig)
	}
	
//	@Test XXX Annotations are now generated in the JVM model inferrer, which is not affected by the locally created configuration!
	def testAnnotationWithValueArray_02() {
		val generatorConfig = generatorConfigProvider.get(null)
		generatorConfig.setGenerateSyntheticSuppressWarnings(false)
		assertCompilesTo('''
			@SuppressWarnings('abc', 'efg')
			class C {
			}
		''', '''
			@SuppressWarnings({ "abc", "efg" })
			public class C {
			}
		''', generatorConfig)
	}
	
	@Test
	def compileWithConfiguration_2(){
		val generatorConfig = generatorConfigProvider.get(null)
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
				@SuppressWarnings("unused")
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
				@SuppressWarnings("unused")
				public class Bar {
				  public int foo() {
				    throw new UnsupportedOperationException("foo is not implemented");
				  }
				}
			''', generatorConfig)
	}
	
}