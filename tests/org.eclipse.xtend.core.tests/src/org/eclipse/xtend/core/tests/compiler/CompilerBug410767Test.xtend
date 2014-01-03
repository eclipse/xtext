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
class CompilerBug410767Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		// actually this is a conformance problem which leads to 
		// Map<?, ?> or Map<? extends C1<? extends C1<?>>, ? extends C1<? extends C1<?>>> would be valid return types
		// 
		// (see capture conversion, https://bugs.eclipse.org/bugs/show_bug.cgi?id=404706)
		assertCompilesTo('''
			class C {
				def m(C1<?> p) {
					p.toMap
				}
			}
			interface C1<A1> extends C2<C1<C1<A1>>> {}
			interface C2<A2> {
				def java.util.Map<A2, A2> toMap()
			}
		''', '''
			import java.util.Map;
			
			@SuppressWarnings("all")
			public class C {
			  public Map<C1<C1<? extends Object>>,C1<C1<? extends Object>>> m(final C1<? extends Object> p) {
			    return p.toMap();
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			abstract class C<T> implements C1<T> {
				def m() {
					toMap
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {
				def java.util.Map<A4, B4> toMap()
			}
		''', '''
			import java.util.Map;
			
			@SuppressWarnings("all")
			public abstract class C<T extends Object> implements C1<T> {
			  public Map<T,C1<T>> m() {
			    return this.toMap();
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			abstract class C<T> implements C1<T> {
				def m(C<? extends String> p) {
					p.toMap
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {
				def java.util.Map<A4, B4> toMap()
			}
		''', '''
			import java.util.Map;
			
			@SuppressWarnings("all")
			public abstract class C<T extends Object> implements C1<T> {
			  public Map<? extends String,? extends C1<? extends String>> m(final C<? extends String> p) {
			    return p.toMap();
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		// actually this is a conformance problem which leads to 
		// Map<? extends Object, ? extends C1<? extends Object>> would be a valid return type
		// 
		// (see capture conversion, https://bugs.eclipse.org/bugs/show_bug.cgi?id=404706)
		assertCompilesTo('''
			class C {
				def m(C1<?> p) {
					p.toMap
				}
			}
			interface C1<A1> extends C2<A1> {}
			interface C2<A2> extends C3<A2, C2<A2>> {}
			interface C3<A3, B3> extends C4<A3, C1<A3>> {}
			interface C4<A4, B4> {
				def java.util.Map<A4, B4> toMap()
			}
		''', '''
			import java.util.Map;
			
			@SuppressWarnings("all")
			public class C {
			  public Map<? extends Object,C1<? extends Object>> m(final C1<? extends Object> p) {
			    return p.toMap();
			  }
			}
		''')
	}
		
}