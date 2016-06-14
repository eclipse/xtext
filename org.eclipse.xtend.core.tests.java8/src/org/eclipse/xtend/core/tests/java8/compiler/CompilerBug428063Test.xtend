/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug428063Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_428063_01() {
		'''
			class C {
				def static void main() {
					m[Integer it| ]
				}
				def static <T extends Number> m((T)=>void block) {
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public static void main() {
			    final Procedure1<Integer> _function = (Integer it) -> {
			    };
			    C.<Integer>m(_function);
			  }
			  
			  public static <T extends Number> Object m(final Procedure1<? super T> block) {
			    return null;
			  }
			}
		''')
	}
	
	@Test def void testBug_428063_02() {
		'''
			class C {
				def static void main() {
					m[int it| ]
				}
				def static <T extends Number> m((T)=>void block) {
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public static void main() {
			    final Procedure1<Integer> _function = (Integer it) -> {
			    };
			    C.<Integer>m(_function);
			  }
			  
			  public static <T extends Number> Object m(final Procedure1<? super T> block) {
			    return null;
			  }
			}
		''')
	}
	
}