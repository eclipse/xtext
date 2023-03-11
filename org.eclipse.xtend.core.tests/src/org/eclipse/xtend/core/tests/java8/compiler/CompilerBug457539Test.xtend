/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
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
			    void add(final T t);
			
			    T get();
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
			    void add(final T t);
			
			    T get();
			  }
			
			  public void m() {
			    final C.MyIterable<CharSequence> list = C.<CharSequence>newIterable();
			    list.get().toString();
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
			    void add(final T t);
			
			    T get();
			  }
			
			  public void m() {
			    final C.MyIterable<CharSequence> list = C.<CharSequence>newIterable();
			    list.get().toString();
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
			    void add(final T t);
			
			    T get();
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
			    void add(final T t);
			
			    T get();
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
			import org.eclipse.xtend.core.tests.java8.compiler.StringBuilderLike
			class C {
				def m()	{
					newIterable(new StringBuilderLike).forEach2 [
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
			import org.eclipse.xtend.core.tests.java8.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public interface MyIterable<T extends Object> extends Iterable<T> {
			    void forEach2(final Procedure1<? super T> f);
			  }
			
			  public void m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Procedure1<StringBuilderLike> _function = (StringBuilderLike it) -> {
			      Long _long = new Long(0);
			      this.<Serializable>m(it, _long);
			      InputOutput.<Integer>println(Integer.valueOf(it.length()));
			    };
			    C.<StringBuilderLike>newIterable(_stringBuilderLike).forEach2(_function);
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
			    void forEach2(final Procedure1<? super T> f);
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