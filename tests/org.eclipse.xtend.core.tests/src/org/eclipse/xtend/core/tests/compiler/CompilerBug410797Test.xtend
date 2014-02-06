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
class CompilerBug410797Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_410797_01() {
		assertCompilesTo('''
			class C {
				def Iterable<D> m() {
					val list = <E>newArrayList
					val g = new G
			
					list.map[e|e.m].flatten.map[d(g)]
				}
				def d(F f, G g) {
					new D
				}
			}
			class D {
			}
			class E {
				def m() {
					<F>newArrayList
				}
			}
			
			class G {	
			}
			class F {
				
			}
		''', '''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<D> m() {
			    Iterable<D> _xblockexpression = null;
			    {
			      final ArrayList<E> list = CollectionLiterals.<E>newArrayList();
			      final G g = new G();
			      final Function1<E,ArrayList<F>> _function = new Function1<E,ArrayList<F>>() {
			        public ArrayList<F> apply(final E e) {
			          return e.m();
			        }
			      };
			      List<ArrayList<F>> _map = ListExtensions.<E, ArrayList<F>>map(list, _function);
			      Iterable<F> _flatten = Iterables.<F>concat(_map);
			      final Function1<F,D> _function_1 = new Function1<F,D>() {
			        public D apply(final F it) {
			          return C.this.d(it, g);
			        }
			      };
			      _xblockexpression = IterableExtensions.<F, D>map(_flatten, _function_1);
			    }
			    return _xblockexpression;
			  }
			  
			  public D d(final F f, final G g) {
			    return new D();
			  }
			}
		''')
	}
	
	@Test def void testBug_410797_02() {
		assertCompilesTo('''
			class C {
				def Iterable<D> m() {
					val g = new G();
					<E>newArrayList.map[e|e.m].flatten.map[d(g)]
				}
				def d(F f, G g) {
					new D
				}
			}
			class D {
			}
			class E {
				def m() {
					<F>newArrayList
				}
			}
			
			class G {	
			}
			class F {
				
			}
		''', '''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<D> m() {
			    Iterable<D> _xblockexpression = null;
			    {
			      final G g = new G();
			      ArrayList<E> _newArrayList = CollectionLiterals.<E>newArrayList();
			      final Function1<E,ArrayList<F>> _function = new Function1<E,ArrayList<F>>() {
			        public ArrayList<F> apply(final E e) {
			          return e.m();
			        }
			      };
			      List<ArrayList<F>> _map = ListExtensions.<E, ArrayList<F>>map(_newArrayList, _function);
			      Iterable<F> _flatten = Iterables.<F>concat(_map);
			      final Function1<F,D> _function_1 = new Function1<F,D>() {
			        public D apply(final F it) {
			          return C.this.d(it, g);
			        }
			      };
			      _xblockexpression = IterableExtensions.<F, D>map(_flatten, _function_1);
			    }
			    return _xblockexpression;
			  }
			  
			  public D d(final F f, final G g) {
			    return new D();
			  }
			}
		''')
	}
	
	@Test def void testBug_410797_03() {
		assertCompilesTo('''
			class C {
				def Iterable<D> m() {
					<E>newArrayList.map[e|e.m].flatten.map[d(new G)]
				}
				def d(F f, G g) {
					new D
				}
			}
			class D {
			}
			class E {
				def m() {
					<F>newArrayList
				}
			}
			
			class G {	
			}
			class F {
				
			}
		''', '''
			import com.google.common.collect.Iterables;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<D> m() {
			    ArrayList<E> _newArrayList = CollectionLiterals.<E>newArrayList();
			    final Function1<E,ArrayList<F>> _function = new Function1<E,ArrayList<F>>() {
			      public ArrayList<F> apply(final E e) {
			        return e.m();
			      }
			    };
			    List<ArrayList<F>> _map = ListExtensions.<E, ArrayList<F>>map(_newArrayList, _function);
			    Iterable<F> _flatten = Iterables.<F>concat(_map);
			    final Function1<F,D> _function_1 = new Function1<F,D>() {
			      public D apply(final F it) {
			        G _g = new G();
			        return C.this.d(it, _g);
			      }
			    };
			    return IterableExtensions.<F, D>map(_flatten, _function_1);
			  }
			  
			  public D d(final F f, final G g) {
			    return new D();
			  }
			}
		''')
	}
	
}