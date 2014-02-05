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
class CompilerBug405825Test extends AbstractXtendCompilerTest {
	
	@Test
	def testBug405825_01() {
		assertCompilesTo('''
			class Test {
			    def static void test(Bound<?> b) {
			    }
			    def static void main() {
			        test [
			        ]
			    }
			}
			interface Bound<T extends Number> {
			    def void method(T t);
			}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public static void test(final Bound<?> b) {
			  }
			  
			  public static void main() {
			    final Bound<Number> _function = new Bound<Number>() {
			      public void method(final Number it) {
			      }
			    };
			    Test.test(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug405825_02() {
		assertCompilesTo('''
			class Test {
			    def static void test(Bound<? extends Integer> b) {
			    }
			    def static void main() {
			        test [
			        ]
			    }
			}
			interface Bound<T extends Number> {
			    def void method(T t);
			}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public static void test(final Bound<? extends Integer> b) {
			  }
			  
			  public static void main() {
			    final Bound<Integer> _function = new Bound<Integer>() {
			      public void method(final Integer it) {
			      }
			    };
			    Test.test(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug405825_03() {
		assertCompilesTo('''
			class Test {
			    def static void test(Sub<?> b) {
			    }
			    def static void main() {
			        test [
			        ]
			    }
			}
			interface Bound<T extends Number> {
			    def void method(T t);
			}
			interface Sub<X extends Number> extends Bound<X> {}
		''', '''
			@SuppressWarnings("all")
			public class Test {
			  public static void test(final Sub<?> b) {
			  }
			  
			  public static void main() {
			    final Sub<Number> _function = new Sub<Number>() {
			      public void method(final Number it) {
			      }
			    };
			    Test.test(_function);
			  }
			}
		''')
	}
	
}
