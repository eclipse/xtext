/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug455317Test extends AbstractXtendCompilerTest {
	@Test
	def test_01() {
		assertCompilesTo('''
			class Outer {
				interface I {}
				interface I0 extends I {}
				interface I1 extends I {}
				static class C {}
				static class C0 extends C implements I0 {}
				static class C1 extends C implements I1 {}
			    
			    val x = #{ C0, C1 }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface I {
			  }
			  
			  public interface I0 extends Outer.I {
			  }
			  
			  public interface I1 extends Outer.I {
			  }
			  
			  public static class C {
			  }
			  
			  public static class C0 extends Outer.C implements Outer.I0 {
			  }
			  
			  public static class C1 extends Outer.C implements Outer.I1 {
			  }
			  
			  private final Set<? extends Class<? extends Outer.C>> x = Collections.<Class<? extends Outer.C>>unmodifiableSet(CollectionLiterals.<Class<? extends Outer.C>>newHashSet(Outer.C0.class, Outer.C1.class));
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class Outer {
				interface I {}
				interface I0 extends I {}
				interface I1 extends I {}
				static class C {}
				static class C0 extends C implements I0 {}
				static class C1 extends C implements I1 {}
			    
			    val x = #[ C0, C1 ]
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface I {
			  }
			  
			  public interface I0 extends Outer.I {
			  }
			  
			  public interface I1 extends Outer.I {
			  }
			  
			  public static class C {
			  }
			  
			  public static class C0 extends Outer.C implements Outer.I0 {
			  }
			  
			  public static class C1 extends Outer.C implements Outer.I1 {
			  }
			  
			  private final List<? extends Class<? extends Outer.C>> x = Collections.<Class<? extends Outer.C>>unmodifiableList(CollectionLiterals.<Class<? extends Outer.C>>newArrayList(Outer.C0.class, Outer.C1.class));
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				interface I {}
				interface I0 extends I {}
				interface I1 extends I {}
				static class C implements I {}
				static class C0 extends C implements I0 {}
				static class C1 extends C implements I1 {}
			    
			    val Set<? extends Class<? extends I>> w = #{ C0, C1 }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface I {
			  }
			  
			  public interface I0 extends Outer.I {
			  }
			  
			  public interface I1 extends Outer.I {
			  }
			  
			  public static class C implements Outer.I {
			  }
			  
			  public static class C0 extends Outer.C implements Outer.I0 {
			  }
			  
			  public static class C1 extends Outer.C implements Outer.I1 {
			  }
			  
			  private final Set<? extends Class<? extends Outer.I>> w = Collections.<Class<? extends Outer.I>>unmodifiableSet(CollectionLiterals.<Class<? extends Outer.I>>newHashSet(Outer.C0.class, Outer.C1.class));
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				interface I {}
				interface I0 extends I {}
				interface I1 extends I {}
				static class C implements I {}
				static class C0 extends C implements I0 {}
				static class C1 extends C implements I1 {}
			    
			    val Set<Class<? extends I>> w = #{ C0, C1 }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface I {
			  }
			  
			  public interface I0 extends Outer.I {
			  }
			  
			  public interface I1 extends Outer.I {
			  }
			  
			  public static class C implements Outer.I {
			  }
			  
			  public static class C0 extends Outer.C implements Outer.I0 {
			  }
			  
			  public static class C1 extends Outer.C implements Outer.I1 {
			  }
			  
			  private final Set<Class<? extends Outer.I>> w = Collections.<Class<? extends Outer.I>>unmodifiableSet(CollectionLiterals.<Class<? extends Outer.I>>newHashSet(Outer.C0.class, Outer.C1.class));
			}
		''')
	}
	
	@Test
	@Ignore
	def test_05() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				interface I {}
				interface I0 extends I {}
				interface I1 extends I {}
				static class C {}
				static class C0 extends C implements I0 {}
				static class C1 extends C implements I1 {}
			    
			    val Set<? extends Class<? extends I>> w = #{ C0, C1 }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface I {
			  }
			  
			  public interface I0 extends Outer.I {
			  }
			  
			  public interface I1 extends Outer.I {
			  }
			  
			  public static class C {
			  }
			  
			  public static class C0 extends Outer.C implements Outer.I0 {
			  }
			  
			  public static class C1 extends Outer.C implements Outer.I1 {
			  }
			  
			  private final Set<? extends Class<? extends Outer.I>> w = Collections.<Class<? extends Outer.C>>unmodifiableSet(CollectionLiterals.<Class<? extends Outer.C>>newHashSet(Outer.C0.class, Outer.C1.class));
			}
		''')
	}
	
	@Test
	@Ignore
	def test_06() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				interface I {}
				interface I0 extends I {}
				interface I1 extends I {}
				static class C {}
				static class C0 extends C implements I0 {}
				static class C1 extends C implements I1 {}
			    
			    val Set<Class<? extends I>> w = #{ C0, C1 }
			}
		''', '''
			import java.util.Collections;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Outer {
			  public interface I {
			  }
			  
			  public interface I0 extends Outer.I {
			  }
			  
			  public interface I1 extends Outer.I {
			  }
			  
			  public static class C {
			  }
			  
			  public static class C0 extends Outer.C implements Outer.I0 {
			  }
			  
			  public static class C1 extends Outer.C implements Outer.I1 {
			  }
			  
			  private final Set<Class<? extends Outer.I>> w = Collections.<Class<? extends Outer.I>>unmodifiableSet(CollectionLiterals.<Class<? extends Outer.I>>newHashSet(Outer.C0.class, Outer.C1.class));
			}
		''')
	}
	
	@Test
	@Ignore
	def test_000() {
		assertCompilesTo('''
			import java.util.Set
			class Outer {
				interface I {}
				interface I0 extends I {}
				interface I1 extends I {}
				static class C {}
				static class C0 extends C implements I0 {}
				static class C1 extends C implements I1 {}
			    
			    val Class<? extends C> x1 = C0
			    val Class<? extends I> x2 = C0
			    val x = #{ C0, C1 }
			    val Set<? extends Class<? extends C>> y = #{ C0, C1 }
			    val Set<Class<? extends C>> z0 = #{ C0 }
			    val Set<Class<? extends C>> z = #{ C0, C1 }
			    val Set<? extends Class<? extends I>> w0 = #{ C0 }
			    val Set<? extends Class<? extends I>> w = #{ C0, C1 }
			    val Set<Class<? extends I>> v0 = #{ C0 }
			    val Set<Class<? extends I>> v = #{ C0, C1 }
			}
		''', '''
			IGNORED
		''')
	}
	
}