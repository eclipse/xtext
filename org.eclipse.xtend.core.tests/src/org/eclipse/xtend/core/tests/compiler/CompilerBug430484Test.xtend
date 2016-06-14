/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug430484Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class TestDummy {
				def static <T extends Enum<T>> void enumeration(Class<T> enumClass) {
					for(t : enumClass.getEnumConstants()) {
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class TestDummy {
			  public static <T extends Enum<T>> void enumeration(final Class<T> enumClass) {
			    T[] _enumConstants = enumClass.getEnumConstants();
			    for (final T t : _enumConstants) {
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class TestDummy {
				def static <T extends Enum<T>> void enumeration(Class<T> enumClass) {
					for(T t : enumClass.getEnumConstants()) {
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class TestDummy {
			  public static <T extends Enum<T>> void enumeration(final Class<T> enumClass) {
			    T[] _enumConstants = enumClass.getEnumConstants();
			    for (final T t : _enumConstants) {
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class TestDummy {
				def static <T extends Enum<T>, V extends T> void enumeration(Class<T> enumClass) {
					for(T t : enumClass.getEnumConstants() as V[]) {
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class TestDummy {
			  public static <T extends Enum<T>, V extends T> void enumeration(final Class<T> enumClass) {
			    T[] _enumConstants = enumClass.getEnumConstants();
			    for (final T t : ((V[]) _enumConstants)) {
			    }
			  }
			}
		''')
	}
	
}