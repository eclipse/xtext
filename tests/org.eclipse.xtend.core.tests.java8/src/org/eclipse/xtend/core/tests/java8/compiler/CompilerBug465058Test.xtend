/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug465058Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug465058Test {
	
	@Test override test_01() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.<String>head]
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return IterableExtensions.<String>head(this.list);
			    };
			    this.foo(_function);
			  }
			}
		''')
	}
	
	@Test override test_02() {
		'''
			abstract class Bug {
				val list = newArrayList('a', 'b')
				def void foo(=>Object f)
				def bar() {
					foo[ list.<String>head ]
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final ArrayList<String> list = CollectionLiterals.<String>newArrayList("a", "b");
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return IterableExtensions.<String>head(this.list);
			    };
			    this.foo(_function);
			  }
			}
		''')
	}
	
	@Test override test_03() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.head]
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return IterableExtensions.<String>head(this.list);
			    };
			    this.foo(_function);
			  }
			}
		''')
	}
	
	@Test override test_04() {
		'''
			abstract class Bug {
				val list = newArrayList('a', 'b')
				def void foo(=>Object f)
				def bar() {
					foo[ list.head ]
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final ArrayList<String> list = CollectionLiterals.<String>newArrayList("a", "b");
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return IterableExtensions.<String>head(this.list);
			    };
			    this.foo(_function);
			  }
			}
		''')
	}
	
	@Test override test_05() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.head2]
				}
				def <T> T head2(Iterable<T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(this.list);
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Object> T head2(final Iterable<T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_06() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.head2]
				}
				def <T> T head2(Iterable<? extends T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(this.list);
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Object> T head2(final Iterable<? extends T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_07() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.head2]
				}
				def <T> T head2(T[] iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(((String[])Conversions.unwrapArray(this.list, String.class)));
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Object> T head2(final T[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_08() {
		'''
			abstract class Bug {
				def void foo(=>Object f)
				def bar() {
					foo[head2(#["one", "two", "three"])]
				}
				def <T> T head2(T[] iterable) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(new String[] { "one", "two", "three" });
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Object> T head2(final T[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_09() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[head2(list)]
				}
				def <T> T head2(Iterable<T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(this.list);
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Object> T head2(final Iterable<T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_10() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.head2]
				}
				def <T extends CharSequence> T head2(Iterable<T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(this.list);
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends CharSequence> T head2(final Iterable<T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_11() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.head2]
				}
				def <T extends CharSequence> T head2(Iterable<? extends T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(this.list);
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends CharSequence> T head2(final Iterable<? extends T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_12() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[list.head2]
				}
				def <T extends CharSequence> T head2(T[] iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(((String[])Conversions.unwrapArray(this.list, String.class)));
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends CharSequence> T head2(final T[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_13() {
		'''
			abstract class Bug {
				def void foo(=>Object f)
				def bar() {
					foo[head2(#["one", "two", "three"])]
				}
				def <T extends CharSequence> T head2(T[] iterable) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(new String[] { "one", "two", "three" });
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends CharSequence> T head2(final T[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_14() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void foo(=>Object f)
				def bar() {
					foo[head2(list)]
				}
				def <T extends CharSequence> T head2(Iterable<T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(this.list);
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends CharSequence> T head2(final Iterable<T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_15() {
		'''
			abstract class Bug {
				val list = #["one", "two", "three"]
				def void bar() {
					var =>Object x = [head2(list)]
					x.apply
				}
				def <T extends CharSequence> T head2(Iterable<T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  private final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three"));
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(this.list);
			    };
			    Function0<?> x = _function;
			    x.apply();
			  }
			  
			  public <T extends CharSequence> T head2(final Iterable<T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_16() {
		'''
			abstract class Bug {
				def bar() {
					var =>Object x = [head2(#["one", "two", "three"])]
					x.apply
				}
				def <T extends CharSequence> T head2(Iterable<T> iterable) {}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public Object bar() {
			    Object _xblockexpression = null;
			    {
			      final Function0<Object> _function = () -> {
			        return this.<String>head2(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("one", "two", "three")));
			      };
			      Function0<?> x = _function;
			      _xblockexpression = x.apply();
			    }
			    return _xblockexpression;
			  }
			  
			  public <T extends CharSequence> T head2(final Iterable<T> iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_17() {
		'''
			abstract class Bug {
				def bar() {
					var =>Object x = [head2(#["one", "two", "three"])]
					x.apply()
				}
				def <T extends CharSequence> T head2(T[] iterable) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public Object bar() {
			    Object _xblockexpression = null;
			    {
			      final Function0<Object> _function = () -> {
			        return this.<String>head2(new String[] { "one", "two", "three" });
			      };
			      Function0<?> x = _function;
			      _xblockexpression = x.apply();
			    }
			    return _xblockexpression;
			  }
			  
			  public <T extends CharSequence> T head2(final T[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_18() {
		'''
			abstract class Bug {
				def void foo(=>Object f)
				def bar() {
					foo[head2(#[1, 1.0])]
				}
				def <T> T head2(T[] iterable) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return ((Number)this.<Number>head2(new Number[] { Integer.valueOf(1), Double.valueOf(1.0) }));
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Object> T head2(final T[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_19() {
		'''
			abstract class Bug {
				def void foo(=>Object f)
				def bar() {
					foo[head2(#['', ''])]
				}
				def <T> T head2(Comparable<T>[] iterable) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return this.<String>head2(new Comparable[] { "", "" });
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Object> T head2(final Comparable<T>[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_20() {
		'''
			abstract class Bug {
				def void foo(=>Object f)
				def bar() {
					foo[head2(#[null as Integer, null as Double])]
				}
				def <T extends Number> T head2(Comparable<? extends T>[] iterable) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return ((Number)this.<Number>head2(new Comparable[] { ((Integer) null), ((Double) null) }));
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Number> T head2(final Comparable<? extends T>[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_21() {
		'''
			abstract class Bug {
				def void foo(=>Object f)
				def bar() {
					foo[head2(#[1, 1.0])]
				}
				def <T extends Number> T head2(Comparable<? extends T>[] iterable) {}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract void foo(final Function0<?> f);
			  
			  public void bar() {
			    final Function0<Object> _function = () -> {
			      return ((Number)this.<Number>head2(new Comparable[] { Integer.valueOf(1), Double.valueOf(1.0) }));
			    };
			    this.foo(_function);
			  }
			  
			  public <T extends Number> T head2(final Comparable<? extends T>[] iterable) {
			    return null;
			  }
			}
		''')
	}
	
}