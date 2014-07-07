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
 * @see CompilerBugTest#testBug404051_01 and friends
 */
class CompilerBug404051Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def m(Iterable<String> iterable) {
					iterable.flatMap[].sortBy [ hashCode ]
				}
				def <A,B> Iterable<? super B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<? super Object> m(final Iterable<String> iterable) {
			    final Function1<String, Object> _function = new Function1<String, Object>() {
			      public Object apply(final String it) {
			        return null;
			      }
			    };
			    Iterable<? super Object> _flatMap = this.<String, Object>flatMap(iterable, _function);
			    final Function1<Object, Integer> _function_1 = new Function1<Object, Integer>() {
			      public Integer apply(final Object it) {
			        return Integer.valueOf(it.hashCode());
			      }
			    };
			    return IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends Object, B extends Object> Iterable<? super B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def m(Iterable<String> iterable) {
					iterable.flatMap[].sortBy [ hashCode ]
				}
				def <A,B extends Number> Iterable<? super B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<? super Number> m(final Iterable<String> iterable) {
			    final Function1<String, Number> _function = new Function1<String, Number>() {
			      public Number apply(final String it) {
			        return null;
			      }
			    };
			    Iterable<? super Number> _flatMap = this.<String, Number>flatMap(iterable, _function);
			    final Function1<Object, Integer> _function_1 = new Function1<Object, Integer>() {
			      public Integer apply(final Object it) {
			        return Integer.valueOf(it.hashCode());
			      }
			    };
			    return IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends Object, B extends Number> Iterable<? super B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def m(Iterable<String> iterable) {
					iterable.flatMap[].sortBy [ intValue ]
				}
				def <A,B extends Number> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<? extends Number> m(final Iterable<String> iterable) {
			    final Function1<String, Number> _function = new Function1<String, Number>() {
			      public Number apply(final String it) {
			        return null;
			      }
			    };
			    Iterable<? extends Number> _flatMap = this.<String, Number>flatMap(iterable, _function);
			    final Function1<Number, Integer> _function_1 = new Function1<Number, Integer>() {
			      public Integer apply(final Number it) {
			        return Integer.valueOf(it.intValue());
			      }
			    };
			    return IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends Object, B extends Number> Iterable<? extends B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def m() {
					#[].flatMap[ length ].sortBy [ intValue ]
				}
				def <A extends String,B extends Number> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<? extends Integer> m() {
			    final Function1<String, Integer> _function = new Function1<String, Integer>() {
			      public Integer apply(final String it) {
			        return Integer.valueOf(it.length());
			      }
			    };
			    Iterable<? extends Integer> _flatMap = this.<String, Integer>flatMap(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), _function);
			    final Function1<Integer, Integer> _function_1 = new Function1<Integer, Integer>() {
			      public Integer apply(final Integer it) {
			        return Integer.valueOf(it.intValue());
			      }
			    };
			    return IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends String, B extends Number> Iterable<? extends B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				def m() {
					#[].flatMap[].sortBy [ intValue ]
				}
				def <A extends String,B extends Number> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<? extends Number> m() {
			    final Function1<String, Number> _function = new Function1<String, Number>() {
			      public Number apply(final String it) {
			        return null;
			      }
			    };
			    Iterable<? extends Number> _flatMap = this.<String, Number>flatMap(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), _function);
			    final Function1<Number, Integer> _function_1 = new Function1<Number, Integer>() {
			      public Integer apply(final Number it) {
			        return Integer.valueOf(it.intValue());
			      }
			    };
			    return IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends String, B extends Number> Iterable<? extends B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			class C {
				def m(Iterable<String> iterable) {
					iterable.flatMap[].sortBy [ length ]
				}
				def <A,B extends A> Iterable<? extends B> flatMap(Iterable<? extends A> iterable, (A)=>B map) {
					return null
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<? extends String> m(final Iterable<String> iterable) {
			    final Function1<String, String> _function = new Function1<String, String>() {
			      public String apply(final String it) {
			        return null;
			      }
			    };
			    Iterable<? extends String> _flatMap = this.<String, String>flatMap(iterable, _function);
			    final Function1<String, Integer> _function_1 = new Function1<String, Integer>() {
			      public Integer apply(final String it) {
			        return Integer.valueOf(it.length());
			      }
			    };
			    return IterableExtensions.sortBy(_flatMap, _function_1);
			  }
			  
			  public <A extends Object, B extends A> Iterable<? extends B> flatMap(final Iterable<? extends A> iterable, final Function1<? super A, ? extends B> map) {
			    return null;
			  }
			}
		''')
	}
	
	
}