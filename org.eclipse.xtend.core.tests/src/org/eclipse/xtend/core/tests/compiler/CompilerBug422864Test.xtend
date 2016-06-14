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
class CompilerBug422864Test extends AbstractXtendCompilerTest {
	
	@Test
	def testBug422864_00() {
		assertCompilesTo('''
			class C {
				def Pair<Pair<Integer, Double>, String> test(L<Pair<Pair<Integer, Double>, String>> l) {
					return l.maximum(O.doubleO.c[it| it.key.value])
				}
			}
			class L<A> {
				new(A a) {}
				def A maximum(O<A> o) {}
			}
			class O<A> {
				static def O<Double> doubleO() {}
				def <B> O<B> c((B)=>A f) {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public Pair<Pair<Integer, Double>, String> test(final L<Pair<Pair<Integer, Double>, String>> l) {
			    O<Double> _doubleO = O.doubleO();
			    final Function1<Pair<Pair<Integer, Double>, String>, Double> _function = new Function1<Pair<Pair<Integer, Double>, String>, Double>() {
			      public Double apply(final Pair<Pair<Integer, Double>, String> it) {
			        Pair<Integer, Double> _key = it.getKey();
			        return _key.getValue();
			      }
			    };
			    O<Pair<Pair<Integer, Double>, String>> _c = _doubleO.<Pair<Pair<Integer, Double>, String>>c(_function);
			    return l.maximum(_c);
			  }
			}
		''')
	}
	
	@Ignore
	@Test
	def testBug422864_01() {
		assertCompilesTo('''
			class C {
				def Pair<Pair<Integer, Double>, String> test(L<Pair<Pair<Integer, Double>, String>> l) {
					return l.maximum(println(O.doubleO.c[it| it.key.value]))
				}
			}
			class L<A> {
				new(A a) {}
				def A maximum(O<A> o) {}
			}
			class O<A> {
				static def O<Double> doubleO() {}
				def <B> O<B> c((B)=>A f) {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class C {
			  public Pair<Pair<Integer, Double>, String> test(final L<Pair<Pair<Integer, Double>, String>> l) {
			    O<Double> _doubleO = O.doubleO();
			    final Function1<Pair<Pair<Integer, Double>, String>, Double> _function = new Function1<Pair<Pair<Integer, Double>, String>, Double>() {
			      public Double apply(final Pair<Pair<Integer, Double>, String> it) {
			        Pair<Integer, Double> _key = it.getKey();
			        return _key.getValue();
			      }
			    };
			    O<Pair<Pair<Integer, Double>, String>> _c = _doubleO.<Pair<Pair<Integer, Double>, String>>c(_function);
			    O<Pair<Pair<Integer, Double>, String>> _println = InputOutput.<O<Pair<Pair<Integer, Double>, String>>>println(_c);
			    return l.maximum(_println);
			  }
			}
		''')
	}
	
	@Ignore
	@Test
	def testBug422864_02() {
		assertCompilesTo('''
			class C {
				def Pair<Pair<Integer, Double>, String> test(L<Pair<Pair<Integer, Double>, String>> l) {
					return l.maximum(O.doubleO.c[it| it.key.value].or(null))
				}
				static def <A> O<A> or(O<A> one, O<A> two) {
					null
				}
			}
			class L<A> {
				new(A a) {}
				def A maximum(O<A> o) {}
			}
			class O<A> {
				static def O<Double> doubleO() {}
				def <B> O<B> c((B)=>A f) {}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final A a) {
			    return null;
			  }
			  
			  protected Object _m(final B b) {
			    return null;
			  }
			  
			  public Object m(final A a) {
			    if (a instanceof B) {
			      return _m((B)a);
			    } else if (a != null) {
			      return _m(a);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(a).toString());
			    }
			  }
			}
		''')
	}
	
	@Ignore
	@Test
	def testBug422864_03() {
		assertCompilesTo('''
			class C {
				def Pair<Pair<Integer, Double>, String> test(L<Pair<Pair<Integer, Double>, String>> l) {
					return l.maximum(or(O.doubleO.c[it| it.key.value], null))
				}
				static def <B> O<B> or(O<B> one, O<B> two) {
					null
				}
			}
			class L<A> {
				new(A a) {}
				def A maximum(O<A> o) {}
			}
			class O<A> {
				static def O<Double> doubleO() {}
				def <R> O<R> c((R)=>A f) {}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final A a) {
			    return null;
			  }
			  
			  protected Object _m(final B b) {
			    return null;
			  }
			  
			  public Object m(final A a) {
			    if (a instanceof B) {
			      return _m((B)a);
			    } else if (a != null) {
			      return _m(a);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(a).toString());
			    }
			  }
			}
		''')
	}
	
	@Ignore
	@Test
	def testBug422864_04() {
		assertCompilesTo('''
			class C {
				def Pair<Pair<Integer, Double>, String> test(L<Pair<Pair<Integer, Double>, String>> l) {
					return l.maximum(O.doubleO.c[it| it.key.value].or(null))
				}
				def <A> A maximum(Iterable<A> iterable) {
					
				} 
				static def <A> O<A> or(O<A> one, O<A> two) {
					null
				}
			}
			class L<A> {
				new(A a) {}
				def A maximum(O<A> o) {}
			}
			class O<A> {
				static def O<Double> doubleO() {}
				def <B> O<B> c((B)=>A f) {}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final A a) {
			    return null;
			  }
			  
			  protected Object _m(final B b) {
			    return null;
			  }
			  
			  public Object m(final A a) {
			    if (a instanceof B) {
			      return _m((B)a);
			    } else if (a != null) {
			      return _m(a);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(a).toString());
			    }
			  }
			}
		''')
	}
	
	@Ignore
	@Test
	def testBug422864_05() {
		assertCompilesTo('''
			class Bug3 {
				
				def void test() {
					
					val p = 1 -> 1.0 -> "a"
					
					val l = new L(p)
					
					val l2 = l.maximum(O.doubleO.c[key.value].or(O.doubleO.c[key.value]))
					l2.toString
				}
				
				def <A> A maximum(Iterable<A> iterable) {
					
				} 
				
				static def <A> O<A> or(O<A> one, O<A> two) {
					null
				}
			}
			class L<A> {
				new(A a) {}
				def A maximum(O<A> o) {}
			}
			class O<A> {
				static def O<Double> doubleO() {}
				def <B> O<B> c((B)=>A f) {}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final A a) {
			    return null;
			  }
			  
			  protected Object _m(final B b) {
			    return null;
			  }
			  
			  public Object m(final A a) {
			    if (a instanceof B) {
			      return _m((B)a);
			    } else if (a != null) {
			      return _m(a);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(a).toString());
			    }
			  }
			}
		''')
	}
	
}

