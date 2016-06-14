/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
class Java8OverloadCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def testBug438461_01() {
		assertCompilesTo('''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ /* Callable /w null */ ]
				}
			}
		''', '''
			import java.util.concurrent.Callable;
			import java.util.concurrent.ExecutorService;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final ExecutorService service) {
			    final Callable<Object> _function = new Callable<Object>() {
			      public Object call() throws Exception {
			        return null;
			      }
			    };
			    service.<Object>submit(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_02() {
		assertCompilesTo('''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ return /* Runnable */ ]
				}
			}
		''', '''
			import java.util.concurrent.ExecutorService;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final ExecutorService service) {
			    final Runnable _function = new Runnable() {
			      public void run() {
			        return;
			      }
			    };
			    service.submit(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_03() {
		assertCompilesTo('''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ return '' /* Callable */ ]
				}
			}
		''', '''
			import java.util.concurrent.Callable;
			import java.util.concurrent.ExecutorService;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final ExecutorService service) {
			    final Callable<String> _function = new Callable<String>() {
			      public String call() throws Exception {
			        return "";
			      }
			    };
			    service.<String>submit(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_04() {
		assertCompilesTo('''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m(ExecutorService service) {
					service.submit [ '' /* Callable */ ]
				}
			}
		''', '''
			import java.util.concurrent.Callable;
			import java.util.concurrent.ExecutorService;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final ExecutorService service) {
			    final Callable<String> _function = new Callable<String>() {
			      public String call() throws Exception {
			        return "";
			      }
			    };
			    service.<String>submit(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_05() {
		assertCompilesTo('''
			import java.util.concurrent.ExecutorService
			class Bug {
				def void m() {}
				def void m(ExecutorService service) {
					service.submit [ m() /* Runnable */ ]
				}
			}
		''', '''
			import java.util.concurrent.ExecutorService;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m() {
			  }
			  
			  public void m(final ExecutorService service) {
			    final Runnable _function = new Runnable() {
			      public void run() {
			        Bug.this.m();
			      }
			    };
			    service.submit(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_06() {
		assertCompilesTo('''
			class Bug {
				def void m(I... i) {}
				def void m(Iterable<I> i) {
					m [ run ]
				}
				interface I {
					def void bind(Runnable r)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public interface I {
			    public abstract void bind(final Runnable r);
			  }
			  
			  public void m(final Bug.I... i) {
			  }
			  
			  public void m(final Iterable<Bug.I> i) {
			    final Bug.I _function = new Bug.I() {
			      public void bind(final Runnable it) {
			        it.run();
			      }
			    };
			    this.m(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_07() {
		assertCompilesTo('''
			class Bug {
				def void m(I i) {}
				def void m(Iterable<I> i) {
					m [ run ]
				}
				interface I {
					def void bind(Runnable r)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public interface I {
			    public abstract void bind(final Runnable r);
			  }
			  
			  public void m(final Bug.I i) {
			  }
			  
			  public void m(final Iterable<Bug.I> i) {
			    final Bug.I _function = new Bug.I() {
			      public void bind(final Runnable it) {
			        it.run();
			      }
			    };
			    this.m(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_08() {
		assertCompilesTo('''
			class Bug {
				def void m(I... i) {}
				def void m(Iterable<I>... i) {
					m [ run ]
				}
				interface I {
					def void bind(Runnable r)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Bug {
			  public interface I {
			    public abstract void bind(final Runnable r);
			  }
			  
			  public void m(final Bug.I... i) {
			  }
			  
			  public void m(final Iterable<Bug.I>... i) {
			    final Bug.I _function = new Bug.I() {
			      public void bind(final Runnable it) {
			        it.run();
			      }
			    };
			    this.m(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_09() {
		assertCompilesTo('''
			class Bug {
				def void m((String, String)=>void f) {}
				def void m(()=>String f) {
					m [ '' ]
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Procedure2<? super String, ? super String> f) {
			  }
			  
			  public void m(final Function0<? extends String> f) {
			    final Function0<String> _function = new Function0<String>() {
			      public String apply() {
			        return "";
			      }
			    };
			    this.m(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_10() {
		assertCompilesTo('''
			class Bug {
				def void m((String, String)=>String f) {}
				def void m(()=>void f) {
					m [ $0 + $1 ]
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Function2<? super String, ? super String, ? extends String> f) {
			  }
			  
			  public void m(final Procedure0 f) {
			    final Function2<String, String, String> _function = new Function2<String, String, String>() {
			      public String apply(final String $0, final String $1) {
			        return ($0 + $1);
			      }
			    };
			    this.m(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_11() {
		assertCompilesTo('''
			class Bug {
				def void m((String, String)=>void f) {}
				def void m(()=>String... f) {
					m [ '' ]
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Procedure2<? super String, ? super String> f) {
			  }
			  
			  public void m(final Function0<? extends String>... f) {
			    final Function0<String> _function = new Function0<String>() {
			      public String apply() {
			        return "";
			      }
			    };
			    this.m(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug438461_12() {
		assertCompilesTo('''
			class Bug {
				def void m((String, String)=>String... f) {}
				def void m(()=>void f) {
					m [ $0 + $1 ]
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
			
			@SuppressWarnings("all")
			public class Bug {
			  public void m(final Function2<? super String, ? super String, ? extends String>... f) {
			  }
			  
			  public void m(final Procedure0 f) {
			    final Function2<String, String, String> _function = new Function2<String, String, String>() {
			      public String apply(final String $0, final String $1) {
			        return ($0 + $1);
			      }
			    };
			    this.m(_function);
			  }
			}
		''')
	}
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList(1));
				}
				def void m(Object o) {}
				def void m(List<Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> _asList = Arrays.<Number>asList(Integer.valueOf(1));
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList(1, 2));
				}
				def void m(Object o) {}
				def void m(List<Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> _asList = Arrays.<Number>asList(Integer.valueOf(1), Integer.valueOf(2));
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<Number> ln) {
			  }
			}
		''')
	}
	
	@Ignore("Improve deferred type parameter resolution")
	@Test
	def test_03() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					var arr = Arrays.asList(1, 2)
					m(arr);
				}
				def void m(Object o) {}
				def void m(List<Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> arr = Arrays.<Number>asList(Integer.valueOf(1), Integer.valueOf(2));
			    this.m(arr);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x(Integer[] ints) {
					m(Arrays.asList(ints));
				}
				def void m(Object o) {}
				def void m(List<Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x(final Integer[] ints) {
			    List<Number> _asList = Arrays.<Number>asList(ints);
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList());
				}
				def void m(Object o) {}
				def void m(List<Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> _asList = Arrays.<Number>asList();
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList(1));
				}
				def void m(Object o) {}
				def void m(List<? extends Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Integer> _asList = Arrays.<Integer>asList(Integer.valueOf(1));
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<? extends Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList(1, 2));
				}
				def void m(Object o) {}
				def void m(List<? extends Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Integer> _asList = Arrays.<Integer>asList(Integer.valueOf(1), Integer.valueOf(2));
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<? extends Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_08() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList());
				}
				def void m(Object o) {}
				def void m(List<? extends Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> _asList = Arrays.<Number>asList();
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<? extends Number> ln) {
			  }
			}
		''')
	}
	@Test
	def test_09() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList(1));
				}
				def void m(Object o) {}
				def void m(List<? super Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> _asList = Arrays.<Number>asList(Integer.valueOf(1));
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<? super Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_10() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList(1, 2));
				}
				def void m(Object o) {}
				def void m(List<? super Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> _asList = Arrays.<Number>asList(Integer.valueOf(1), Integer.valueOf(2));
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<? super Number> ln) {
			  }
			}
		''')
	}
	
	@Test
	def test_11() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					m(Arrays.asList());
				}
				def void m(Object o) {}
				def void m(List<? super Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> _asList = Arrays.<Number>asList();
			    this.m(_asList);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<? super Number> ln) {
			  }
			}
		''')
	}
	
	@Ignore("Improve deferred type parameter resolution")
	@Test
	def test_12() {
		assertCompilesTo('''
			import java.util.List
			import java.util.Arrays
			class C {
				def void x() {
					var arr = Arrays.asList(1)
					m(arr);
				}
				def void m(Object o) {}
				def void m(List<Number> ln) {}
			}
		''', '''
			import java.util.Arrays;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    List<Number> arr = Arrays.<Number>asList(Integer.valueOf(1));
			    this.m(arr);
			  }
			  
			  public void m(final Object o) {
			  }
			  
			  public void m(final List<Number> ln) {
			  }
			}
		''')
	}
		
	@Ignore("TODO implement this properly")
	@Test
	def test_13() {
		assertCompilesTo('''
			class C {
				def void x() {
					val Iterable<Iterable<Number>> l = newArrayList(newArrayList(1))
				}
			}
		''', '''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    ArrayList<Number> _newArrayList = CollectionLiterals.<Number>newArrayList(Integer.valueOf(1));
			    final Iterable<Iterable<Number>> l = CollectionLiterals.<Iterable<Number>>newArrayList(_newArrayList);
			  }
			}
		''')
	}	
		
	@Test
	def test_14() {
		assertCompilesTo('''
			class C {
				def void x() {
					val l = newArrayList
					l.add(1)
					val Iterable<Number> l2 = l
				}
			}
		''', '''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public void x() {
			    final ArrayList<Number> l = CollectionLiterals.<Number>newArrayList();
			    l.add(Integer.valueOf(1));
			    final Iterable<Number> l2 = l;
			  }
			}
		''')
	}	
	
}