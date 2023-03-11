/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug406425Test extends AbstractXtendCompilerTest {
	
	@Test
	def testBug406425_01() {
		assertCompilesTo('''
			import static org.hamcrest.core.Is.*
			import static org.junit.Assert.*
			import org.hamcrest.Matcher
			class Test {
			   def test() {
			       new MyEntity => [
			           assertThat(it, nullValue)
			           assertThat(it.name, is(""))
			       ]
			   }
			   def static <T> Matcher<T> nullValue() {}
			}
			class MyEntity {
			   @Property String name
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			import org.hamcrest.Matcher;
			import org.hamcrest.core.Is;
			import org.junit.Assert;
			
			@SuppressWarnings("all")
			public class Test {
			  public MyEntity test() {
			    MyEntity _myEntity = new MyEntity();
			    final Procedure1<MyEntity> _function = new Procedure1<MyEntity>() {
			      public void apply(final MyEntity it) {
			        Assert.<MyEntity>assertThat(it, Test.<MyEntity>nullValue());
			        Assert.<String>assertThat(it.getName(), Is.<String>is(""));
			      }
			    };
			    return ObjectExtensions.<MyEntity>operator_doubleArrow(_myEntity, _function);
			  }
			
			  public static <T extends Object> Matcher<T> nullValue() {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_02() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test<T> {
			    def m(T a, T b){}
			
			    static def m() {
			        new StringBuilderLike => [
			            new Test().m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T a, final T b) {
			    return null;
			  }
			
			  public static StringBuilderLike m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Procedure1<StringBuilderLike> _function = new Procedure1<StringBuilderLike>() {
			      public void apply(final StringBuilderLike it) {
			        Test<Serializable> _test = new Test<Serializable>();
			        Long _long = new Long(0);
			        _test.m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    return ObjectExtensions.<StringBuilderLike>operator_doubleArrow(_stringBuilderLike, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_03() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilderLike => [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public StringBuilderLike m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Procedure1<StringBuilderLike> _function = new Procedure1<StringBuilderLike>() {
			      public void apply(final StringBuilderLike it) {
			        Long _long = new Long(0);
			        Test.this.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    return ObjectExtensions.<StringBuilderLike>operator_doubleArrow(_stringBuilderLike, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_04() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilderLike => [
			            it.m(new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public StringBuilderLike m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Procedure1<StringBuilderLike> _function = new Procedure1<StringBuilderLike>() {
			      public void apply(final StringBuilderLike it) {
			        Long _long = new Long(0);
			        Test.this.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    return ObjectExtensions.<StringBuilderLike>operator_doubleArrow(_stringBuilderLike, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_05() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilderLike => [
			            m(new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public StringBuilderLike m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Procedure1<StringBuilderLike> _function = new Procedure1<StringBuilderLike>() {
			      public void apply(final StringBuilderLike it) {
			        Long _long = new Long(0);
			        Test.this.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    return ObjectExtensions.<StringBuilderLike>operator_doubleArrow(_stringBuilderLike, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_06() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        newArrayList(new StringBuilderLike).forEach [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import java.util.function.Consumer;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public void m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Consumer<StringBuilderLike> _function = new Consumer<StringBuilderLike>() {
			      public void accept(final StringBuilderLike it) {
			        Long _long = new Long(0);
			        Test.this.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    CollectionLiterals.<StringBuilderLike>newArrayList(_stringBuilderLike).forEach(_function);
			  }
			}
		''')
	}

	@Test
	def testBug406425_07() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    def static <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilderLike => [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public static <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public StringBuilderLike m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Procedure1<StringBuilderLike> _function = new Procedure1<StringBuilderLike>() {
			      public void apply(final StringBuilderLike it) {
			        Long _long = new Long(0);
			        Test.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    return ObjectExtensions.<StringBuilderLike>operator_doubleArrow(_stringBuilderLike, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_08() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    def static <T> m(T a, T b){}
			
			    def static m() {
			        new StringBuilderLike => [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public static <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public static StringBuilderLike m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Procedure1<StringBuilderLike> _function = new Procedure1<StringBuilderLike>() {
			      public void apply(final StringBuilderLike it) {
			        Long _long = new Long(0);
			        Test.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    return ObjectExtensions.<StringBuilderLike>operator_doubleArrow(_stringBuilderLike, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_09() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    def <T> m(T a, T b){}
			
			    static def m() {
			        newArrayList(new StringBuilderLike).forEach [
			            new Test().m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import java.util.function.Consumer;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public static void m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Consumer<StringBuilderLike> _function = new Consumer<StringBuilderLike>() {
			      public void accept(final StringBuilderLike it) {
			        Test _test = new Test();
			        Long _long = new Long(0);
			        _test.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    CollectionLiterals.<StringBuilderLike>newArrayList(_stringBuilderLike).forEach(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_10() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test<T> {
			    def m(T a, T b){}
			
			    static def m() {
			        newArrayList(new StringBuilderLike).forEach [
			            new Test().m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import java.util.function.Consumer;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T a, final T b) {
			    return null;
			  }
			
			  public static void m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Consumer<StringBuilderLike> _function = new Consumer<StringBuilderLike>() {
			      public void accept(final StringBuilderLike it) {
			        Test<Serializable> _test = new Test<Serializable>();
			        Long _long = new Long(0);
			        _test.m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    CollectionLiterals.<StringBuilderLike>newArrayList(_stringBuilderLike).forEach(_function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406425_11() {
		assertCompilesTo('''
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike
			class Test {
			    static def <T> m(T a, T b){}
			
			    static def m() {
			        newArrayList(new StringBuilderLike).forEach [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		''', '''
			import java.io.Serializable;
			import java.util.function.Consumer;
			import org.eclipse.xtend.core.tests.compiler.StringBuilderLike;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public static <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			
			  public static void m() {
			    StringBuilderLike _stringBuilderLike = new StringBuilderLike();
			    final Consumer<StringBuilderLike> _function = new Consumer<StringBuilderLike>() {
			      public void accept(final StringBuilderLike it) {
			        Long _long = new Long(0);
			        Test.<Serializable>m(it, _long);
			        InputOutput.<Integer>println(Integer.valueOf(it.length()));
			      }
			    };
			    CollectionLiterals.<StringBuilderLike>newArrayList(_stringBuilderLike).forEach(_function);
			  }
			}
		''')
	}
	
}

