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
 */
class ParameterizedTypeCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def testSimpleArgument_01() {
		assertCompilesTo('''
			class MyRef extends java.lang.ref.WeakReference<String> {
				new(String s) { super(s) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			
			@SuppressWarnings("all")
			public class MyRef extends WeakReference<String> {
			  public MyRef(final String s) {
			    super(s);
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_02() {
		assertCompilesTo('''
			class MyRef<U> extends java.lang.ref.WeakReference<U> {
				new() { super(null) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			
			@SuppressWarnings("all")
			public class MyRef<U extends Object> extends WeakReference<U> {
			  public MyRef() {
			    super(null);
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_03() {
		assertCompilesTo('''
			class MyRef<U> extends java.lang.ref.WeakReference<U> {
				new(U u) { super(u) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			
			@SuppressWarnings("all")
			public class MyRef<U extends Object> extends WeakReference<U> {
			  public MyRef(final U u) {
			    super(u);
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_04() {
		assertCompilesTo('''
			class MyRef<U> extends java.lang.ref.WeakReference<U> {
				new(Iterable<U> u) { super(u.head) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class MyRef<U extends Object> extends WeakReference<U> {
			  public MyRef(final Iterable<U> u) {
			    super(new Function0<U>() {
			      public U apply() {
			        U _head = IterableExtensions.<U>head(u);
			        return _head;
			      }
			    }.apply());
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_05() {
		assertCompilesTo('''
			class MyRef<U> extends java.lang.ref.WeakReference<U> {
				new(java.util.List<U> list) { super(list.get(0)) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyRef<U extends Object> extends WeakReference<U> {
			  public MyRef(final List<U> list) {
			    super(new Function0<U>() {
			      public U apply() {
			        U _get = list.get(0);
			        return _get;
			      }
			    }.apply());
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_06() {
		assertCompilesTo('''
			class MyRef<U extends CharSequence> extends java.lang.ref.WeakReference<String> {
				new(U u) { this(u as Object) }
				new(Object o) { super(o.toString()) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyRef<U extends CharSequence> extends WeakReference<String> {
			  public MyRef(final U u) {
			    this(((Object) u));
			  }
			  
			  public MyRef(final Object o) {
			    super(new Function0<String>() {
			      public String apply() {
			        String _string = o.toString();
			        return _string;
			      }
			    }.apply());
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_07() {
		assertCompilesTo('''
			class MyRef<U> extends java.lang.ref.WeakReference<Iterable<U>> {
				new() { super(newArrayList) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyRef<U extends Object> extends WeakReference<Iterable<U>> {
			  public MyRef() {
			    super(new Function0<Iterable<U>>() {
			      public Iterable<U> apply() {
			        ArrayList<U> _newArrayList = CollectionLiterals.<U>newArrayList();
			        return _newArrayList;
			      }
			    }.apply());
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_08() {
		assertCompilesTo('''
			class MyRef<U> extends java.lang.ref.WeakReference<Iterable<U>> {
				new() { super(newArrayList(null)) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyRef<U extends Object> extends WeakReference<Iterable<U>> {
			  public MyRef() {
			    super(new Function0<Iterable<U>>() {
			      public Iterable<U> apply() {
			        ArrayList<U> _newArrayList = CollectionLiterals.<U>newArrayList(null);
			        return _newArrayList;
			      }
			    }.apply());
			  }
			}
		''')
	}
	@Test
	def testSimpleArgument_09() {
		assertCompilesTo('''
			class MyRef<U> extends java.lang.ref.WeakReference<Iterable<U>> {
				new(U u) { super(newArrayList(u)) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyRef<U extends Object> extends WeakReference<Iterable<U>> {
			  public MyRef(final U u) {
			    super(new Function0<Iterable<U>>() {
			      public Iterable<U> apply() {
			        ArrayList<U> _newArrayList = CollectionLiterals.<U>newArrayList(u);
			        return _newArrayList;
			      }
			    }.apply());
			  }
			}
		''')
	}
	
	@Test
	def testTransitiveArgument_01() {
		assertCompilesTo('''
			class MyRef<AAA, AA extends AAA> extends java.lang.ref.WeakReference<AAA> {
				new(AA a) { super(a) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			
			@SuppressWarnings("all")
			public class MyRef<AAA extends Object, AA extends AAA> extends WeakReference<AAA> {
			  public MyRef(final AA a) {
			    super(a);
			  }
			}
		''')
	}
	
	@Test
	def testTransitiveArgument_02() {
		assertCompilesTo('''
			class MyRef<AAA, AA extends AAA> extends java.lang.ref.WeakReference<Iterable<AAA>> {
				new(AA a) { super(<AAA>newArrayList(a)) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyRef<AAA extends Object, AA extends AAA> extends WeakReference<Iterable<AAA>> {
			  public MyRef(final AA a) {
			    super(new Function0<Iterable<AAA>>() {
			      public Iterable<AAA> apply() {
			        ArrayList<AAA> _newArrayList = CollectionLiterals.<AAA>newArrayList(a);
			        return _newArrayList;
			      }
			    }.apply());
			  }
			}
		''')
	}
	
	@Test
	def testTransitiveArgument_03() {
		assertCompilesTo('''
			class MyRef<AAA, AA extends AAA> extends java.lang.ref.WeakReference<Iterable<AA>> {
				new(AAA a) { this(newArrayList(a as AA)) }
				new(Iterable<AA> iter) { super(iter) }
			}
		''', '''
			import java.lang.ref.WeakReference;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyRef<AAA extends Object, AA extends AAA> extends WeakReference<Iterable<AA>> {
			  public MyRef(final AAA a) {
			    this(new Function0<Iterable<AA>>() {
			      public Iterable<AA> apply() {
			        ArrayList<AA> _newArrayList = CollectionLiterals.<AA>newArrayList(((AA) a));
			        return _newArrayList;
			      }
			    }.apply());
			  }
			  
			  public MyRef(final Iterable<AA> iter) {
			    super(iter);
			  }
			}
		''')
	}
	
	@Test
	def testTransitiveArgument_04() {
		assertCompilesTo('''
			class MyList<AAA, AA extends java.util.List<AAA>> extends java.util.ArrayList<AAA> {
				new(AA a) { super(a) }
			}
		''', '''
			import java.util.ArrayList;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class MyList<AAA extends Object, AA extends List<AAA>> extends ArrayList<AAA> {
			  public MyList(final AA a) {
			    super(a);
			  }
			}
		''')
	}
	
	@Test
	def testTransitiveArgument_05() {
		assertCompilesTo('''
			class MyList<T, U extends T> extends java.util.ArrayList<T> {
				new(U u) { super(newArrayList(u)) }
			}
		''', '''
			import java.util.ArrayList;
			import java.util.Collection;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class MyList<T extends Object, U extends T> extends ArrayList<T> {
			  public MyList(final U u) {
			    super(new Function0<Collection<? extends T>>() {
			      public Collection<? extends T> apply() {
			        ArrayList<U> _newArrayList = CollectionLiterals.<U>newArrayList(u);
			        return _newArrayList;
			      }
			    }.apply());
			  }
			}
		''')
	}
	
	@Test
	def testBug403706_01() {
		assertCompilesTo('''
			import java.util.List
			class TestA<T> {
			    new(List<T> list) {}
			    def woot(List<T> list) {}
			}
			class TestB<U> extends TestA<U> {
			    new(List<U> list) {
			        super(list)
			    }
			    
			    override woot(List<U> list) {
			        super.woot(list)
			    }
			}
		''', '''
			import java.util.List;
			
			@SuppressWarnings("all")
			public class TestA<T extends Object> {
			  public TestA(final List<T> list) {
			  }
			  
			  public Object woot(final List<T> list) {
			    return null;
			  }
			}
		''')
	}
	@Test
	def testBug403706_02() {
		assertCompilesTo('''
			import java.util.List
			class TestB<U> extends TestA<U> {
			    new(List<U> list) {
			        super(list)
			    }
			    
			    override woot(List<U> list) {
			        super.woot(list)
			    }
			}
			class TestA<T> {
			    new(List<T> list) {}
			    def woot(List<T> list) {}
			}
		''', '''
			import java.util.List;
			
			@SuppressWarnings("all")
			public class TestB<U extends Object> extends TestA<U> {
			  public TestB(final List<U> list) {
			    super(list);
			  }
			  
			  public Object woot(final List<U> list) {
			    Object _woot = super.woot(list);
			    return _woot;
			  }
			}
		''')
	}
}