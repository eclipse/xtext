/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug405825Test extends AbstractXtendCompilerTest {
	
	@Test def testBug405825_01() {
		'''
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
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public static void test(final Bound<?> b) {
			  }
			  
			  public static void main() {
			    final Bound<Number> _function = (Number it) -> {
			    };
			    Test.test(_function);
			  }
			}
		''')
	}
	
	@Test def testBug405825_02() {
		'''
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
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public static void test(final Bound<? extends Integer> b) {
			  }
			  
			  public static void main() {
			    final Bound<Integer> _function = (Integer it) -> {
			    };
			    Test.test(_function);
			  }
			}
		''')
	}
	
	@Test def testBug405825_03() {
		'''
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
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public static void test(final Sub<?> b) {
			  }
			  
			  public static void main() {
			    final Sub<Number> _function = (Number it) -> {
			    };
			    Test.test(_function);
			  }
			}
		''')
	}
	
}
