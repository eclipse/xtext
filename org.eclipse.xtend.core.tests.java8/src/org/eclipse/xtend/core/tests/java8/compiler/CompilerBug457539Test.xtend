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
class CompilerBug457539Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug457539Test {
	
	@Test override test_01() {
		'''
			import java.util.ArrayList
			class C {
				def m()	{
					val list = new ArrayList
					list.forEach [
						if (it instanceof String) list.add(it)
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<Object> list = new ArrayList<Object>();
			    final Consumer<Object> _function = (Object it) -> {
			      if ((it instanceof String)) {
			        list.add(it);
			      }
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test override test_02() {
		'''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						if (it instanceof String) list.add(it)
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<Object> list = CollectionLiterals.<Object>newArrayList();
			    final Consumer<Object> _function = (Object it) -> {
			      if ((it instanceof String)) {
			        list.add(it);
			      }
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test override test_03() {
		'''
			class C {
				def m()	{
					val list = newIterable
					list.forEach [
					]
				}
				def static <T extends CharSequence> MyIterable<T> newIterable(T... initial) {}
				interface MyIterable<T extends CharSequence> extends Iterable<T> {
				}
			}
		'''.assertCompilesTo('''
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends CharSequence> extends Iterable<T> {
			  }
			  
			  public void m() {
			    final C.MyIterable<CharSequence> list = C.<CharSequence>newIterable();
			    final Consumer<CharSequence> _function = (CharSequence it) -> {
			    };
			    list.forEach(_function);
			  }
			  
			  public static <T extends CharSequence> C.MyIterable<T> newIterable(final T... initial) {
			    return null;
			  }
			}
		''')
	}

	@Test override test_04() {
		'''
			class C {
				def m()	{
					val list = newIterable
					list.add('')
					list.forEach [
					]
				}
				def static <T extends CharSequence> MyIterable<T> newIterable(T... initial) {}
				interface MyIterable<T extends CharSequence> extends Iterable<T> {
					def void add(T t)
					def T get()
				}
			}
		'''.assertCompilesTo('''
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends CharSequence> extends Iterable<T> {
			    public abstract void add(final T t);
			    
			    public abstract T get();
			  }
			  
			  public void m() {
			    final C.MyIterable<String> list = C.<String>newIterable();
			    list.add("");
			    final Consumer<String> _function = (String it) -> {
			    };
			    list.forEach(_function);
			  }
			  
			  public static <T extends CharSequence> C.MyIterable<T> newIterable(final T... initial) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_05() {
		'''
			class C {
				def m()	{
					val list = newIterable
					list.get.toString
					list.add('')
					list.forEach [
					]
				}
				def static <T extends CharSequence> MyIterable<T> newIterable(T... initial) {}
				interface MyIterable<T extends CharSequence> extends Iterable<T> {
					def void add(T t)
					def T get()
				}
			}
		'''.assertCompilesTo('''
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends CharSequence> extends Iterable<T> {
			    public abstract void add(final T t);
			    
			    public abstract T get();
			  }
			  
			  public void m() {
			    final C.MyIterable<CharSequence> list = C.<CharSequence>newIterable();
			    CharSequence _get = list.get();
			    _get.toString();
			    list.add("");
			    final Consumer<CharSequence> _function = (CharSequence it) -> {
			    };
			    list.forEach(_function);
			  }
			  
			  public static <T extends CharSequence> C.MyIterable<T> newIterable(final T... initial) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_06() {
		'''
			class C {
				def m()	{
					val list = newIterable
					list.get.toString
					list.forEach [
						if (it instanceof String) list.add(it)
					]
				}
				def static <T extends CharSequence> MyIterable<T> newIterable(T... initial) {}
				interface MyIterable<T> extends Iterable<T> {
					def void add(T t)
					def T get()
				}
			}
		'''.assertCompilesTo('''
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends Object> extends Iterable<T> {
			    public abstract void add(final T t);
			    
			    public abstract T get();
			  }
			  
			  public void m() {
			    final C.MyIterable<CharSequence> list = C.<CharSequence>newIterable();
			    CharSequence _get = list.get();
			    _get.toString();
			    final Consumer<CharSequence> _function = (CharSequence it) -> {
			      if ((it instanceof String)) {
			        list.add(it);
			      }
			    };
			    list.forEach(_function);
			  }
			  
			  public static <T extends CharSequence> C.MyIterable<T> newIterable(final T... initial) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_07() {
		'''
			class C {
				def m()	{
					val list = newIterable
					list.forEach [
						if (it instanceof String) list.add(it)
					]
				}
				def static <T extends CharSequence> MyIterable<T> newIterable(T... initial) {}
				interface MyIterable<T> extends Iterable<T> {
					def void add(T t)
					def T get()
				}
			}
		'''.assertCompilesTo('''
			import java.util.function.Consumer;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends Object> extends Iterable<T> {
			    public abstract void add(final T t);
			    
			    public abstract T get();
			  }
			  
			  public void m() {
			    final C.MyIterable<CharSequence> list = C.<CharSequence>newIterable();
			    final Consumer<CharSequence> _function = (CharSequence it) -> {
			      if ((it instanceof String)) {
			        list.add(it);
			      }
			    };
			    list.forEach(_function);
			  }
			  
			  public static <T extends CharSequence> C.MyIterable<T> newIterable(final T... initial) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_08() {
		'''
			class C {
				def m()	{
					val list = newIterable
					list.forEach [ CharSequence it |
						if (it instanceof String) list.add(it)
					]
				}
				def static <T> MyIterable<T> newIterable(T... initial) {}
				interface MyIterable<T> extends Iterable<T> {
					def void add(T t)
					def T get()
				}
			}
		'''.assertCompilesTo('''
			import java.util.function.Consumer;

			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends Object> extends Iterable<T> {
			    public abstract void add(final T t);
			    
			    public abstract T get();
			  }
			  
			  public void m() {
			    final C.MyIterable<CharSequence> list = C.<CharSequence>newIterable();
			    final Consumer<CharSequence> _function = (CharSequence it) -> {
			      if ((it instanceof String)) {
			        list.add(it);
			      }
			    };
			    list.forEach(_function);
			  }
			  
			  public static <T extends Object> C.MyIterable<T> newIterable(final T... initial) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_09() {
		'''
			class C {
				def m()	{
					newIterable(new StringBuilder).forEach2 [
						m(it, new Long(0))
						println(length)
					]
				}
				def <T> m(T a, T b){}
				def static <T> MyIterable<T> newIterable(T... initial) {}
				interface MyIterable<T> extends Iterable<T> {
					def void forEach2((T)=>void f)
				}
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends Object> extends Iterable<T> {
			    public abstract void forEach2(final Procedure1<? super T> f);
			  }
			  
			  public void m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    C.MyIterable<StringBuilder> _newIterable = C.<StringBuilder>newIterable(_stringBuilder);
			    final Procedure1<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      this.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    _newIterable.forEach2(_function);
			  }
			  
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public static <T extends Object> C.MyIterable<T> newIterable(final T... initial) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override test_10() {
		'''
			class C {
				def <V> m(MyIterable<? super V> list) {
					list.forEach2 []
				}
				interface MyIterable<T> extends Iterable<T> {
					def void forEach2((T)=>void f)
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends Object> extends Iterable<T> {
			    public abstract void forEach2(final Procedure1<? super T> f);
			  }
			  
			  public <V extends Object> void m(final C.MyIterable<? super V> list) {
			    final Procedure1<Object> _function = (Object it) -> {
			    };
			    list.forEach2(_function);
			  }
			}
		''')
	}	
}