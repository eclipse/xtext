/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug458612Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import java.util.List
			import static extension C.E.*
			class C {
			    def void doit (List<B> list) {
			        list.ext
			    } 
				static class B {
				}
				static class E {
				    static def void ext(B[] arr) {
				    }
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public static class B {
			  }
			  
			  public static class E {
			    public static void ext(final C.B[] arr) {
			    }
			  }
			  
			  public void doit(final List<C.B> list) {
			    C.E.ext(((C.B[])Conversions.unwrapArray(list, C.B.class)));
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import static extension Test.Foo.*
			class Test {
			    def void doit (B[] arr) {
			        arr.ext
			    } 
				static class B {
				}
				static class Foo {
				    static def void ext(Iterable<B> iter) {
				    }
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class Test {
			  public static class B {
			  }
			  
			  public static class Foo {
			    public static void ext(final Iterable<Test.B> iter) {
			    }
			  }
			  
			  public void doit(final Test.B[] arr) {
			    Test.Foo.ext(((Iterable<Test.B>)Conversions.doWrapArray(arr)));
			  }
			}
		''')
	}
	
}