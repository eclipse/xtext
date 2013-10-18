/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test
import org.junit.Ignore

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Java8OverloadCompilerTest extends AbstractXtendCompilerTest {
	
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


