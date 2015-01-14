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
class CompilerBug457346Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import com.google.common.collect.Ordering
			class C {
				def m() {
					#['a', 'aa', 'aaa'].sort(Ordering.natural.onResultOf [ String s| s.length ].onResultOf[])
				}
			}
		''', '''
			import com.google.common.base.Function;
			import com.google.common.collect.Ordering;
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public List<String> m() {
			    Ordering<Integer> _natural = Ordering.<Integer>natural();
			    final Function<String, Integer> _function = new Function<String, Integer>() {
			      public Integer apply(final String s) {
			        return Integer.valueOf(s.length());
			      }
			    };
			    Ordering<String> _onResultOf = _natural.<String>onResultOf(_function);
			    final Function<String, String> _function_1 = new Function<String, String>() {
			      public String apply(final String it) {
			        return null;
			      }
			    };
			    Ordering<String> _onResultOf_1 = _onResultOf.<String>onResultOf(_function_1);
			    return IterableExtensions.<String>sortWith(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("a", "aa", "aaa")), _onResultOf_1);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import com.google.common.collect.Ordering
			class C {
				def m(Sortable<String> sortMe) {
					sortMe.sort(Ordering.natural.onResultOf [ String s| s.length ].onResultOf[])
				}
				
				interface Sortable<T> extends Iterable<T> {
					def void sort(java.util.Comparator<? super T> c)
				}
			}
		''', '''
			import com.google.common.base.Function;
			import com.google.common.collect.Ordering;
			import java.util.Comparator;
			
			@SuppressWarnings("all")
			public class C {
			  public interface Sortable<T extends Object> extends Iterable<T> {
			    public abstract void sort(final Comparator<? super T> c);
			  }
			  
			  public void m(final C.Sortable<String> sortMe) {
			    Ordering<Integer> _natural = Ordering.<Integer>natural();
			    final Function<String, Integer> _function = new Function<String, Integer>() {
			      public Integer apply(final String s) {
			        return Integer.valueOf(s.length());
			      }
			    };
			    Ordering<String> _onResultOf = _natural.<String>onResultOf(_function);
			    final Function<String, String> _function_1 = new Function<String, String>() {
			      public String apply(final String it) {
			        return null;
			      }
			    };
			    Ordering<String> _onResultOf_1 = _onResultOf.<String>onResultOf(_function_1);
			    sortMe.sort(_onResultOf_1);
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import java.util.Comparator
			class C {
				def m(Sortable<String> sortMe) {
					sortMe.sort(MyComparator.comparingInt [String s| s.length].thenComparing[String s | s])
				}
				
				interface Sortable<T> extends Iterable<T> {
					def void sort(java.util.Comparator<? super T> c)
				}
				static abstract class MyComparator<T> implements Comparator<T> {
					def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}
					def <U extends Comparable<? super U>> MyComparator<T> thenComparing((T)=>U f) {}
				}
				interface ToIntFunction<T> {
					def int apply(T t)
				}
			}
		''', '''
			import java.util.Comparator;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface Sortable<T extends Object> extends Iterable<T> {
			    public abstract void sort(final Comparator<? super T> c);
			  }
			  
			  public static abstract class MyComparator<T extends Object> implements Comparator<T> {
			    public static <T extends Object> C.MyComparator<T> comparingInt(final C.ToIntFunction<? super T> fun) {
			      return null;
			    }
			    
			    public <U extends Comparable<? super U>> C.MyComparator<T> thenComparing(final Function1<? super T, ? extends U> f) {
			      return null;
			    }
			  }
			  
			  public interface ToIntFunction<T extends Object> {
			    public abstract int apply(final T t);
			  }
			  
			  public void m(final C.Sortable<String> sortMe) {
			    final C.ToIntFunction<String> _function = new C.ToIntFunction<String>() {
			      public int apply(final String s) {
			        return s.length();
			      }
			    };
			    C.MyComparator<String> _comparingInt = C.MyComparator.<String>comparingInt(_function);
			    final Function1<String, String> _function_1 = new Function1<String, String>() {
			      public String apply(final String s) {
			        return s;
			      }
			    };
			    C.MyComparator<String> _thenComparing = _comparingInt.<String>thenComparing(_function_1);
			    sortMe.sort(_thenComparing);
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			import java.util.Comparator
			class C {
				def m(Sortable<String> sortMe) {
					sortMe.sort(MyComparator.comparingInt [String s| s.length].thenComparing[toUpperCase])
				}
				
				interface Sortable<T> extends Iterable<T> {
					def void sort(java.util.Comparator<? super T> c)
				}
				static abstract class MyComparator<T> implements Comparator<T> {
					def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}
					def <U extends Comparable<? super U>> MyComparator<T> thenComparing((T)=>U f) {}
				}
				interface ToIntFunction<T> {
					def int apply(T t)
				}
			}
		''', '''
			import java.util.Comparator;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface Sortable<T extends Object> extends Iterable<T> {
			    public abstract void sort(final Comparator<? super T> c);
			  }
			  
			  public static abstract class MyComparator<T extends Object> implements Comparator<T> {
			    public static <T extends Object> C.MyComparator<T> comparingInt(final C.ToIntFunction<? super T> fun) {
			      return null;
			    }
			    
			    public <U extends Comparable<? super U>> C.MyComparator<T> thenComparing(final Function1<? super T, ? extends U> f) {
			      return null;
			    }
			  }
			  
			  public interface ToIntFunction<T extends Object> {
			    public abstract int apply(final T t);
			  }
			  
			  public void m(final C.Sortable<String> sortMe) {
			    final C.ToIntFunction<String> _function = new C.ToIntFunction<String>() {
			      public int apply(final String s) {
			        return s.length();
			      }
			    };
			    C.MyComparator<String> _comparingInt = C.MyComparator.<String>comparingInt(_function);
			    final Function1<String, String> _function_1 = new Function1<String, String>() {
			      public String apply(final String it) {
			        return it.toUpperCase();
			      }
			    };
			    C.MyComparator<String> _thenComparing = _comparingInt.<String>thenComparing(_function_1);
			    sortMe.sort(_thenComparing);
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			import java.util.Comparator
			class C {
				def m(Sortable<String> sortMe) {
					sortMe.sort(MyComparator.comparingInt [String s| s.length].thenComparing[it])
				}
				
				interface Sortable<T> extends Iterable<T> {
					def void sort(java.util.Comparator<? super T> c)
				}
				static abstract class MyComparator<T> implements Comparator<T> {
					def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}
					def <U extends Comparable<? super U>> MyComparator<T> thenComparing((T)=>U f) {}
				}
				interface ToIntFunction<T> {
					def int apply(T t)
				}
			}
		''', '''
			import java.util.Comparator;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface Sortable<T extends Object> extends Iterable<T> {
			    public abstract void sort(final Comparator<? super T> c);
			  }
			  
			  public static abstract class MyComparator<T extends Object> implements Comparator<T> {
			    public static <T extends Object> C.MyComparator<T> comparingInt(final C.ToIntFunction<? super T> fun) {
			      return null;
			    }
			    
			    public <U extends Comparable<? super U>> C.MyComparator<T> thenComparing(final Function1<? super T, ? extends U> f) {
			      return null;
			    }
			  }
			  
			  public interface ToIntFunction<T extends Object> {
			    public abstract int apply(final T t);
			  }
			  
			  public void m(final C.Sortable<String> sortMe) {
			    final C.ToIntFunction<String> _function = new C.ToIntFunction<String>() {
			      public int apply(final String s) {
			        return s.length();
			      }
			    };
			    C.MyComparator<String> _comparingInt = C.MyComparator.<String>comparingInt(_function);
			    final Function1<String, String> _function_1 = new Function1<String, String>() {
			      public String apply(final String it) {
			        return it;
			      }
			    };
			    C.MyComparator<String> _thenComparing = _comparingInt.<String>thenComparing(_function_1);
			    sortMe.sort(_thenComparing);
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			class C {
				def m() {
					MyComparator.comparingInt [String s| s.length].thenComparing[it]
				}
				
				static abstract class MyComparator<T> {
					def static <T> MyComparator<T> comparingInt(ToIntFunction<? super T> fun) {}
					def <U extends Comparable<? super U>> MyComparator<T> thenComparing(
						Function<? super T, ? extends U> keyExtractor,
						MyComparator<? super U> keyComparator)
					def MyComparator<T> thenComparing(MyComparator<? super T> other)
					def <U extends Comparable<? super U>> MyComparator<T> thenComparing(
						Function<? super T, ? extends U> keyExtractor)
				}
				interface ToIntFunction<T> {
					def int apply(T t)
				}
				interface Function<T, R> {
					def R apply(T t)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public static abstract class MyComparator<T extends Object> {
			    public static <T extends Object> C.MyComparator<T> comparingInt(final C.ToIntFunction<? super T> fun) {
			      return null;
			    }
			    
			    public abstract <U extends Comparable<? super U>> C.MyComparator<T> thenComparing(final C.Function<? super T, ? extends U> keyExtractor, final C.MyComparator<? super U> keyComparator);
			    
			    public abstract C.MyComparator<T> thenComparing(final C.MyComparator<? super T> other);
			    
			    public abstract <U extends Comparable<? super U>> C.MyComparator<T> thenComparing(final C.Function<? super T, ? extends U> keyExtractor);
			  }
			  
			  public interface ToIntFunction<T extends Object> {
			    public abstract int apply(final T t);
			  }
			  
			  public interface Function<T extends Object, R extends Object> {
			    public abstract R apply(final T t);
			  }
			  
			  public C.MyComparator<String> m() {
			    final C.ToIntFunction<String> _function = new C.ToIntFunction<String>() {
			      public int apply(final String s) {
			        return s.length();
			      }
			    };
			    C.MyComparator<String> _comparingInt = C.MyComparator.<String>comparingInt(_function);
			    final C.Function<String, String> _function_1 = new C.Function<String, String>() {
			      public String apply(final String it) {
			        return it;
			      }
			    };
			    return _comparingInt.<String>thenComparing(_function_1);
			  }
			}
		''')
	}
	
}