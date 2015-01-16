/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug406425Test extends org.eclipse.xtend.core.tests.compiler.CompilerBug406425Test {
	
	@Test override testBug406425_01() {
		'''
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
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			import org.hamcrest.Matcher;
			import org.hamcrest.core.Is;
			import org.junit.Assert;
			
			@SuppressWarnings("all")
			public class Test {
			  public MyEntity test() {
			    MyEntity _myEntity = new MyEntity();
			    final Procedure1<MyEntity> _function = (MyEntity it) -> {
			      Matcher<MyEntity> _nullValue = Test.<MyEntity>nullValue();
			      Assert.<MyEntity>assertThat(it, _nullValue);
			      String _name = it.getName();
			      Matcher<String> _is = Is.<String>is("");
			      Assert.<String>assertThat(_name, _is);
			    };
			    return ObjectExtensions.<MyEntity>operator_doubleArrow(_myEntity, _function);
			  }
			  
			  public static <T extends Object> Matcher<T> nullValue() {
			    return null;
			  }
			}
		''')
	}
	
	@Test override testBug406425_02() {
		'''
			class Test<T> {
			    def m(T a, T b){}
			
			    static def m() {
			        new StringBuilder => [
			            new Test().m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public static StringBuilder m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    final Procedure1<StringBuilder> _function = (StringBuilder it) -> {
			      Test<Serializable> _test = new Test<Serializable>();
			      Long _long = new Long(0);
			      _test.m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_03() {
		'''
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilder => [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public StringBuilder m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    final Procedure1<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      this.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_04() {
		'''
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilder => [
			            it.m(new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public StringBuilder m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    final Procedure1<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      this.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_05() {
		'''
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilder => [
			            m(new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public StringBuilder m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    final Procedure1<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      this.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_06() {
		'''
			class Test {
			    def <T> m(T a, T b){}
			
			    def m() {
			        newArrayList(new StringBuilder).forEach [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public void m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    ArrayList<StringBuilder> _newArrayList = CollectionLiterals.<StringBuilder>newArrayList(_stringBuilder);
			    final Consumer<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      this.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    _newArrayList.forEach(_function);
			  }
			}
		''')
	}

	@Test override testBug406425_07() {
		'''
			class Test {
			    def static <T> m(T a, T b){}
			
			    def m() {
			        new StringBuilder => [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public static <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public StringBuilder m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    final Procedure1<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      Test.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_08() {
		'''
			class Test {
			    def static <T> m(T a, T b){}
			
			    def static m() {
			        new StringBuilder => [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test {
			  public static <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public static StringBuilder m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    final Procedure1<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      Test.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_09() {
		'''
			class Test {
			    def <T> m(T a, T b){}
			
			    static def m() {
			        newArrayList(new StringBuilder).forEach [
			            new Test().m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public static void m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    ArrayList<StringBuilder> _newArrayList = CollectionLiterals.<StringBuilder>newArrayList(_stringBuilder);
			    final Consumer<StringBuilder> _function = (StringBuilder it) -> {
			      Test _test = new Test();
			      Long _long = new Long(0);
			      _test.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    _newArrayList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_10() {
		'''
			class Test<T> {
			    def m(T a, T b){}
			
			    static def m() {
			        newArrayList(new StringBuilder).forEach [
			            new Test().m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public static void m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    ArrayList<StringBuilder> _newArrayList = CollectionLiterals.<StringBuilder>newArrayList(_stringBuilder);
			    final Consumer<StringBuilder> _function = (StringBuilder it) -> {
			      Test<Serializable> _test = new Test<Serializable>();
			      Long _long = new Long(0);
			      _test.m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    _newArrayList.forEach(_function);
			  }
			}
		''')
	}
	
	@Test override testBug406425_11() {
		'''
			class Test {
			    static def <T> m(T a, T b){}
			
			    static def m() {
			        newArrayList(new StringBuilder).forEach [
			            m(it, new Long(0))
			            println(length)
			        ]
			    }
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public static <T extends Object> Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public static void m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    ArrayList<StringBuilder> _newArrayList = CollectionLiterals.<StringBuilder>newArrayList(_stringBuilder);
			    final Consumer<StringBuilder> _function = (StringBuilder it) -> {
			      Long _long = new Long(0);
			      Test.<Serializable>m(it, _long);
			      int _length = it.length();
			      InputOutput.<Integer>println(Integer.valueOf(_length));
			    };
			    _newArrayList.forEach(_function);
			  }
			}
		''')
	}
	
}

