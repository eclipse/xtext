/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class AnonymousClassCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def void testPlain() {
		'''
			class C {
				def m() {
					new Runnable() {
						override run() {}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public Runnable m() {
			    return new Runnable() {
			      public void run() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_01() {
		'''
			class Test {
				extension Util
				def getRunnable() {
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
				static class Util {
					def sayHello() {
						'Hello'
					}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Test {
			  public static class Util {
			    public String sayHello() {
			      return "Hello";
			    }
			  }
			  
			  @Extension
			  private Test.Util _util;
			  
			  public Runnable getRunnable() {
			    return new Runnable() {
			      public void run() {
			        Test.this._util.sayHello();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_02() {
		'''
			class Test {
				def getRunnable() {
					val extension Util u = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
				static class Util {
					def sayHello() {
						'Hello'
					}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Test {
			  public static class Util {
			    public String sayHello() {
			      return "Hello";
			    }
			  }
			  
			  public Runnable getRunnable() {
			    Runnable _xblockexpression = null;
			    {
			      @Extension
			      final Test.Util u = null;
			      _xblockexpression = new Runnable() {
			        public void run() {
			          u.sayHello();
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_03() {
		'''
			class Test {
				def getRunnable() {
					val Util it = null
					new Runnable {
						override run() {
							it.sayHello
						}
						def void sayHello(Util u) {}
					}
				}
				static class Util {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public static class Util {
			  }
			  
			  public Runnable getRunnable() {
			    abstract class __Test_1 implements Runnable {
			      public abstract void sayHello(final Test.Util u);
			    }
			    
			    __Test_1 _xblockexpression = null;
			    {
			      final Test.Util it = null;
			      _xblockexpression = new __Test_1() {
			        public void run() {
			          this.sayHello(it);
			        }
			        
			        public void sayHello(final Test.Util u) {
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_04() {
		'''
			class Test {
				extension Util = null
				def getRunnable() {
					val String it = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
				static class Util {
					def void sayHello(String s) {}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Test {
			  public static class Util {
			    public void sayHello(final String s) {
			    }
			  }
			  
			  @Extension
			  private Test.Util _util = null;
			  
			  public Runnable getRunnable() {
			    Runnable _xblockexpression = null;
			    {
			      final String it = null;
			      _xblockexpression = new Runnable() {
			        public void run() {
			          Test.this._util.sayHello(it);
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_05() {
		'''
			import static extension Util.*
			class Test {
				def getRunnable() {
					val String it = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
			}
			class Util {
				static def void sayHello(String s) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public Runnable getRunnable() {
			    Runnable _xblockexpression = null;
			    {
			      final String it = null;
			      _xblockexpression = new Runnable() {
			        public void run() {
			          Util.sayHello(it);
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_06() {
		'''
			import static extension Util.*
			class Test {
				def getRunnable() {
					val String it = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
			}
			class Util {
				static def void sayHello(Runnable r) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public Runnable getRunnable() {
			    Runnable _xblockexpression = null;
			    {
			      final String it = null;
			      _xblockexpression = new Runnable() {
			        public void run() {
			          Util.sayHello(this);
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_07() {
		'''
			import static extension Util.*
			class Test {
				def getRunnable() {
					val String it = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
			}
			class Util {
				static def void sayHello(Test t) {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test {
			  public Runnable getRunnable() {
			    Runnable _xblockexpression = null;
			    {
			      final String it = null;
			      _xblockexpression = new Runnable() {
			        public void run() {
			          Util.sayHello(Test.this);
			        }
			      };
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_08() {
		'''
			class Test {
				extension Util u
				def getRunnable() {
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
				static class Util {
					def void sayHello(Runnable r) {}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Test {
			  public static class Util {
			    public void sayHello(final Runnable r) {
			    }
			  }
			  
			  @Extension
			  private Test.Util u;
			  
			  public Runnable getRunnable() {
			    return new Runnable() {
			      public void run() {
			        Test.this.u.sayHello(this);
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_09() {
		'''
			class Test {
				extension Util u
				def getRunnable() {
					new Runnable {
						override run() {
							Test.this.sayHello
						}
					}
				}
				static class Util {
					def void sayHello(Runnable r) {}
					def void sayHello(Test t) {}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Test {
			  public static class Util {
			    public void sayHello(final Runnable r) {
			    }
			    
			    public void sayHello(final Test t) {
			    }
			  }
			  
			  @Extension
			  private Test.Util u;
			  
			  public Runnable getRunnable() {
			    return new Runnable() {
			      public void run() {
			        Test.this.u.sayHello(Test.this);
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testExtensions_10() {
		'''
			class Test {
				extension Util u
				def getRunnable() {
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
				static class Util {
					def void sayHello(Test t) {}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Test {
			  public static class Util {
			    public void sayHello(final Test t) {
			    }
			  }
			  
			  @Extension
			  private Test.Util u;
			  
			  public Runnable getRunnable() {
			    return new Runnable() {
			      public void run() {
			        Test.this.u.sayHello(Test.this);
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testForwardFieldReference() {
		'''
			class Bar {
				val r = new Runnable() {
					override run() {
						println(x)
					}
				}
				public val x = 1
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Bar {
			  private final Runnable r = new Runnable() {
			    public void run() {
			      InputOutput.<Integer>println(Integer.valueOf(Bar.this.x));
			    }
			  };
			  
			  public final int x = 1;
			}
		''')
	}
	
	@Test
	def void testTypeUsed() {
		'''
			class C {
				def m() {
					val d = new D() {
						/** comment */
						final def op1() {
						}
						public def op2() {
						}
						private def op3() {
						}
						override toString() {
							''
						}
					}
					d.op1
					d
				}
				static class D {
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static class D {
			  }
			  
			  public C.D m() {
			    abstract class __C_1 extends C.D {
			      /**
			       * comment
			       */
			      public abstract Object op1();
			      
			      public abstract Object op2();
			      
			      abstract Object op3();
			    }
			    
			    __C_1 _xblockexpression = null;
			    {
			      final __C_1 d = new __C_1() {
			        /**
			         * comment
			         */
			        public final Object op1() {
			          return null;
			        }
			        
			        public Object op2() {
			          return null;
			        }
			        
			        Object op3() {
			          return null;
			        }
			        
			        public String toString() {
			          return "";
			        }
			      };
			      d.op1();
			      _xblockexpression = d;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testTypeUsedAndConstructor() {
		'''
			class C {
				def m() {
					val d = new D(true, 1) {
						final def op1() {
						}
					}
					d.op1
					d
				}
				static class D {
					new(boolean b, int i) {}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static class D {
			    public D(final boolean b, final int i) {
			    }
			  }
			  
			  public C.D m() {
			    abstract class __C_1 extends C.D {
			      __C_1(final boolean b, final int i) {
			        super(b, i);
			      }
			      
			      public abstract Object op1();
			    }
			    
			    __C_1 _xblockexpression = null;
			    {
			      final __C_1 d = new __C_1(true, 1) {
			        public final Object op1() {
			          return null;
			        }
			      };
			      d.op1();
			      _xblockexpression = d;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testTypeUsed_02() {
		'''
			class C {
				def m() {
					val i = {
						val i2 = new I() {
							public def op() {
							}
						}
						i2
					}
					i.op
				}
				interface I {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public interface I {
			  }
			  
			  public Object m() {
			    abstract class __C_1 implements C.I {
			      public abstract Object op();
			    }
			    
			    Object _xblockexpression = null;
			    {
			      __C_1 _xblockexpression_1 = null;
			      {
			        final __C_1 i2 = new __C_1() {
			          public Object op() {
			            return null;
			          }
			        };
			        _xblockexpression_1 = i2;
			      }
			      final __C_1 i = _xblockexpression_1;
			      _xblockexpression = i.op();
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testTwoClasses() {
		'''
			class C {
				def void m() {
					new Runnable() {
						override run() {}
					}
					new Runnable() {
						override run() {}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    new Runnable() {
			      public void run() {
			      }
			    };
			    new Runnable() {
			      public void run() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testTwoClassesWithMembers() {
		'''
			class C {
				def void m() {
					new Runnable() {
						override run() {}
						def void m() {}
					}
					new Runnable() {
						override run() {}
						def void m() {}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    abstract class __C_1 implements Runnable {
			      public abstract void m();
			    }
			    
			    abstract class __C_2 implements Runnable {
			      public abstract void m();
			    }
			    
			    new __C_1() {
			      public void run() {
			      }
			      
			      public void m() {
			      }
			    };
			    new __C_2() {
			      public void run() {
			      }
			      
			      public void m() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testConstructor() {
		'''
			class C {
				def m() {
					new D(true) {
					}
				}
				static class D {
					new(boolean b) {}
					new(int i) {}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static class D {
			    public D(final boolean b) {
			    }
			    
			    public D(final int i) {
			    }
			  }
			  
			  public C.D m() {
			    return new C.D(true) {
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testConstructorAdditionalMember() {
		'''
			class C {
				def m() {
					new D(true) {
						def void n() {}
					}
				}
				static class D {
					new(boolean b) {}
					new(int i) {}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public static class D {
			    public D(final boolean b) {
			    }
			    
			    public D(final int i) {
			    }
			  }
			  
			  public C.D m() {
			    abstract class __C_1 extends C.D {
			      __C_1(final boolean b) {
			        super(b);
			      }
			      
			      public abstract void n();
			    }
			    
			    return new __C_1(true) {
			      public void n() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testNestedLocalClass_01() {
		'''
			class C {
				def m() {
					return newArrayList(new Runnable() { override run() {} })
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public ArrayList<? extends Runnable> m() {
			    return CollectionLiterals.<Runnable>newArrayList(new Runnable() {
			      public void run() {
			      }
			    });
			  }
			}
		''')
	}
	
	@Test
	def void testNestedLocalClass_02() {
		'''
			class C {
				def Iterable<Runnable> m() {
					return newArrayList(new Runnable() { override run() {} })
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<Runnable> m() {
			    return CollectionLiterals.<Runnable>newArrayList(new Runnable() {
			      public void run() {
			      }
			    });
			  }
			}
		''')
	}
	
	@Test
	def void testNestedLocalClass_03() {
		'''
			class C {
				def m() {
					return newArrayList(
						new Runnable() { override run() {} def void m() {} }
					)
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public ArrayList<? extends Runnable> m() {
			    abstract class __C_1 implements Runnable {
			      public abstract void m();
			    }
			    
			    __C_1 ___C_1 = new __C_1() {
			      public void run() {
			      }
			      
			      public void m() {
			      }
			    };
			    return CollectionLiterals.<__C_1>newArrayList(___C_1);
			  }
			}
		''')
	}
	
	@Test
	def void testNestedLocalClass_04() {
		'''
			class C {
				def m() {
					return newArrayList(
						new Runnable() { override run() {} def void m() {} },
						new Runnable() { override run() {} def void m() {} }
					)
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public ArrayList<Runnable> m() {
			    abstract class __C_1 implements Runnable {
			      public abstract void m();
			    }
			    
			    abstract class __C_2 implements Runnable {
			      public abstract void m();
			    }
			    
			    __C_1 ___C_1 = new __C_1() {
			      public void run() {
			      }
			      
			      public void m() {
			      }
			    };
			    __C_2 ___C_2 = new __C_2() {
			      public void run() {
			      }
			      
			      public void m() {
			      }
			    };
			    return CollectionLiterals.<Runnable>newArrayList(___C_1, ___C_2);
			  }
			}
		''')
	}
	
	@Test
	def void testNestedLocalClass_05() {
		'''
			class C {
				def m() {
					return newArrayList(newArrayList(new Runnable() { override run() {} def void m() {} }))
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public ArrayList<? extends ArrayList<? extends Runnable>> m() {
			    abstract class __C_1 implements Runnable {
			      public abstract void m();
			    }
			    
			    __C_1 ___C_1 = new __C_1() {
			      public void run() {
			      }
			      
			      public void m() {
			      }
			    };
			    ArrayList<__C_1> _newArrayList = CollectionLiterals.<__C_1>newArrayList(___C_1);
			    return CollectionLiterals.<ArrayList<__C_1>>newArrayList(_newArrayList);
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_01() {
		'''
			class Foo {
				def foo() {
					val x = ''
					val bar = new Runnable() {
						override run() { x.toString }
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    final String x = "";
			    final Runnable bar = new Runnable() {
			      public void run() {
			        x.toString();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_02() {
		'''
			class Foo {
				def foo() {
					var x = ''
					val bar = new Runnable() {
						String x
						override run() { x.toString }
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    abstract class __Foo_1 implements Runnable {
			      String x;
			    }
			    
			    String x = "";
			    final __Foo_1 bar = new __Foo_1() {
			      public void run() {
			        this.x.toString();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_03() {
		'''
			class Foo {
				def foo() {
					val x = ''
					val bar = new Runnable() {
						String x
						override run() { x.toString }
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    abstract class __Foo_1 implements Runnable {
			      String x;
			    }
			    
			    final String x = "";
			    final __Foo_1 bar = new __Foo_1() {
			      public void run() {
			        this.x.toString();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_04() {
		'''
			class Foo {
				val x = ''
				def foo() {
					val x = ''
					val bar = new Runnable() {
						String x
						override run() {
							new Object() {
								override toString() {
									x
								}
							}
						}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  private final String x = "";
			  
			  public void foo() {
			    abstract class __Foo_1 implements Runnable {
			      final __Foo_1 _this__Foo_1 = this;
			      
			      String x;
			    }
			    
			    final String x = "";
			    final __Foo_1 bar = new __Foo_1() {
			      public void run() {
			        new Object() {
			          public String toString() {
			            return _this__Foo_1.x;
			          }
			        };
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_05() {
		'''
			class Foo {
				val x = ''
				def foo() {
					val bar = new Runnable() {
						String x
						override run() {
							val String x = ''
							new Object() {
								override toString() {
									x
								}
							}
						}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  private final String x = "";
			  
			  public void foo() {
			    abstract class __Foo_1 implements Runnable {
			      String x;
			    }
			    
			    final __Foo_1 bar = new __Foo_1() {
			      public void run() {
			        final String x = "";
			        new Object() {
			          public String toString() {
			            return x;
			          }
			        };
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_06() {
		'''
			class Foo {
				def foo(String x) {
					val bar = new Runnable() {
						String x
						override run() {
							x.toString
						}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final String x) {
			    abstract class __Foo_1 implements Runnable {
			      String x;
			    }
			    
			    final __Foo_1 bar = new __Foo_1() {
			      public void run() {
			        this.x.toString();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_07() {
		'''
			class Foo {
				def foo() {
					val bar = new Runnable() {
						String x
						override run() {
						}
						def void m(String x) {
							x.toString
						}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    abstract class __Foo_1 implements Runnable {
			      String x;
			      
			      public abstract void m(final String x);
			    }
			    
			    final __Foo_1 bar = new __Foo_1() {
			      public void run() {
			      }
			      
			      public void m(final String x) {
			        x.toString();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_08() {
		'''
			class C {
				Object x
				def m(String x) {
					new Object() {
						override toString() {
							x.substring(1)
						}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  private Object x;
			  
			  public Object m(final String x) {
			    return new Object() {
			      public String toString() {
			        return x.substring(1);
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_09() {
		'''
			package foo
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			class Foo {
				def foo() {
					var String name
					bar(new Function0<String>() {
						String name
						override apply() {
							name
						}
					})
				}
				def bar(()=>String f) {
				}
			}
		'''.assertCompilesTo('''
			package foo;
			
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Object foo() {
			    abstract class __Foo_1 implements Function0<String> {
			      String name;
			    }
			    
			    Object _xblockexpression = null;
			    {
			      String name = null;
			      __Foo_1 ___Foo_1 = new __Foo_1() {
			        public String apply() {
			          return this.name;
			        }
			      };
			      _xblockexpression = this.bar(___Foo_1);
			    }
			    return _xblockexpression;
			  }
			  
			  public Object bar(final Function0<? extends String> f) {
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_10() {
		'''
			class Foo {
				def foo() {
					val CharSequence x = new StringBuilder;
					if (x instanceof Appendable)
						new Runnable() {
							override run() { x.append('hello') }
						}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Runnable foo() {
			    Runnable _xblockexpression = null;
			    {
			      final CharSequence x = new StringBuilder();
			      Runnable _xifexpression = null;
			      if ((x instanceof Appendable)) {
			        _xifexpression = new Runnable() {
			          public void run() {
			            try {
			              ((Appendable)x).append("hello");
			            } catch (Throwable _e) {
			              throw Exceptions.sneakyThrow(_e);
			            }
			          }
			        };
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testCapturedLocalVar_11() {
		'''
			class Foo {
				def foo(CharSequence x) {
					if (x instanceof Appendable)
						new Runnable() {
							override run() { x.append('hello') }
						}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Runnable foo(final CharSequence x) {
			    Runnable _xifexpression = null;
			    if ((x instanceof Appendable)) {
			      _xifexpression = new Runnable() {
			        public void run() {
			          try {
			            ((Appendable)x).append("hello");
			          } catch (Throwable _e) {
			            throw Exceptions.sneakyThrow(_e);
			          }
			        }
			      };
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testLocalVar() {
		'''
			class Foo {
				def foo() {
					val bar = new Runnable() {
						override run() {}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    final Runnable bar = new Runnable() {
			      public void run() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testNestedTypeScoping_01() {
		'''
			class C {
				def newMap() {
					return new java.util.AbstractMap<String, String>() {
						override java.util.Set<Entry<String, String>> entrySet() {
							newHashSet
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.AbstractMap;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public AbstractMap<String, String> newMap() {
			    return new AbstractMap<String, String>() {
			      public Set<Map.Entry<String, String>> entrySet() {
			        return CollectionLiterals.<Map.Entry<String, String>>newHashSet();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testNestedTypeScoping_02() {
		'''
			class C {
				def newMap() {
					return new java.util.AbstractMap<String, String>() {
						override entrySet() {
							<Entry<String, String>>newHashSet
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.AbstractMap;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public AbstractMap<String, String> newMap() {
			    return new AbstractMap<String, String>() {
			      public Set<Map.Entry<String, String>> entrySet() {
			        return CollectionLiterals.<Map.Entry<String, String>>newHashSet();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testNestedTypeScoping_03() {
		'''
			class C {
				def newMap() {
					return new java.util.AbstractMap<String, String>() {
						override entrySet() {
							Entry.declaredMethods // doesn't make much sense
							#{}
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.AbstractMap;
			import java.util.Collections;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public AbstractMap<String, String> newMap() {
			    return new AbstractMap<String, String>() {
			      public Set<Map.Entry<String, String>> entrySet() {
			        Set<Map.Entry<String, String>> _xblockexpression = null;
			        {
			          Map.Entry.class.getDeclaredMethods();
			          _xblockexpression = Collections.<Map.Entry<String, String>>unmodifiableSet(CollectionLiterals.<Map.Entry<String, String>>newHashSet());
			        }
			        return _xblockexpression;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_01() {
		'''
			class C {
				def newD() {
					return new D {
						def m() {
							return this
						}
					}
				}
			}
			class D {}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public D newD() {
			    abstract class __C_1 extends D {
			      public abstract __C_1 m();
			    }
			    
			    return new __C_1() {
			      public __C_1 m() {
			        return this;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_02() {
		'''
			class C {
				def newD() {
					return new D {
						def m() {
							return toString
						}
					}
				}
			}
			class D {}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public D newD() {
			    abstract class __C_1 extends D {
			      public abstract String m();
			    }
			    
			    return new __C_1() {
			      public String m() {
			        return this.toString();
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_03() {
		'''
			class C {
				def newD() {
					return new D {
						def m() {
							m2
						}
					}
				}
				def void m2() {}
			}
			class D {}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public D newD() {
			    abstract class __C_1 extends D {
			      public abstract void m();
			    }
			    
			    return new __C_1() {
			      public void m() {
			        C.this.m2();
			      }
			    };
			  }
			  
			  public void m2() {
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_04() {
		'''
			class C {
				def newD() {
					return new D {
						def m() {
							C.this.m
						}
					}
				}
				def void m() {}
			}
			class D {}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public D newD() {
			    abstract class __C_1 extends D {
			      public abstract void m();
			    }
			    
			    return new __C_1() {
			      public void m() {
			        C.this.m();
			      }
			    };
			  }
			  
			  public void m() {
			  }
			}
		''')
	}
	
	@Test
	def void testSuperScoping_01() {
		'''
			class C extends B {
				def myMethod() {
					return new D {
						override m() {
							super.m
						}
					}
				}
				override m() {}
			}
			class B { def void m() {} }
			class D extends E {}
			class E { def void m() {} }
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C extends B {
			  public D myMethod() {
			    return new D() {
			      public void m() {
			        super.m();
			      }
			    };
			  }
			  
			  public void m() {
			  }
			}
		''')
	}
	
	@Test
	def void testSuperScoping_02() {
		'''
			class C extends B {
				def myMethod() {
					return new D {
						override m() {
							C.super.m
						}
					}
				}
				override m() {}
			}
			class B { def void m() {} }
			class D extends E {}
			class E { def void m() {} }
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C extends B {
			  public D myMethod() {
			    return new D() {
			      public void m() {
			        C.super.m();
			      }
			    };
			  }
			  
			  public void m() {
			  }
			}
		''')
	}
	
	@Test
	def void testLocalVar_AdditionalMember() {
		'''
			class Foo {
				def foo() {
					val bar = new Runnable() {
						override run() {}
						int baz
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    abstract class __Foo_1 implements Runnable {
			      int baz;
			    }
			    
			    final __Foo_1 bar = new __Foo_1() {
			      public void run() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testLocalVar_AdditionalMember_Return() {
		'''
			class Foo {
				def foo() {
					new Runnable() {
						override run() {}
						int baz
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public Runnable foo() {
			    abstract class __Foo_1 implements Runnable {
			      int baz;
			    }
			    
			    return new __Foo_1() {
			      public void run() {
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testLocalVarInArray_01() {
		'''
			class Foo {
				def foo() {
					val Object[] bar = #[ 
						new Runnable() {
							override run() {}
						}
					]
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    final Object[] bar = new Object[] { new Runnable() {
			      public void run() {
			      }
			    } };
			  }
			}
		''')
	}
	
	@Test
	def void testLocalVarInArray_02() {
		'''
			class Foo {
				def foo() {
					val bar = #[ 
						new Runnable() {
							override run() {}
						}
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    final List<Runnable> bar = Collections.<Runnable>unmodifiableList(CollectionLiterals.<Runnable>newArrayList(new Runnable() {
			      public void run() {
			      }
			    }));
			  }
			}
		''')
	}
	
	@Test
	def void testField() {
		'''
			class Foo {
				val bar = new Runnable() {
					override run() {}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  private final Runnable bar = new Runnable() {
			    public void run() {
			    }
			  };
			}
		''')
	}
	
	@Test
	def void testField_AdditionalMember_01() {
		'''
			class Foo {
				val bar = new Runnable() {
					int baz
					override run() {}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final Runnable bar = new Function0<Runnable>() {
			    public Runnable apply() {
			      abstract class __Foo_1 implements Runnable {
			        int baz;
			      }
			      
			      __Foo_1 ___Foo_1 = new __Foo_1() {
			        public void run() {
			        }
			      };
			      return ___Foo_1;
			    }
			  }.apply();
			}
		''')
	}
	
	@Test
	def void testField_AdditionalMember_02() {
		'''
			class C {
				val secondOuterField = 1
				val outerField = new Object() {
					int localField
				} => [ localField = secondOuterField ]
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  private final int secondOuterField = 1;
			  
			  private final Object outerField = new Function0<Object>() {
			    public Object apply() {
			      abstract class __C_1 {
			        int localField;
			      }
			      
			      __C_1 ___C_1 = new __C_1() {
			      };
			      final Procedure1<__C_1> _function = new Procedure1<__C_1>() {
			        public void apply(final __C_1 it) {
			          it.localField = C.this.secondOuterField;
			        }
			      };
			      __C_1 _doubleArrow = ObjectExtensions.<__C_1>operator_doubleArrow(___C_1, _function);
			      return _doubleArrow;
			    }
			  }.apply();
			}
		''')
	}
	
	@Test
	def void testFieldInitializerUsesCapturedLocal_01() {
		'''
			class C {
				def m() {
					val s1 = ''
					val r = new Runnable() {
						val s2 = s1
						override run() {
							s2.toString
						}
					}
					r
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public Runnable m() {
			    abstract class __C_1 implements Runnable {
			      String s2;
			    }
			    
			    __C_1 _xblockexpression = null;
			    {
			      final String s1 = "";
			      final __C_1 r = new __C_1() {
			        {
			          s2 = s1;
			        }
			        public void run() {
			          this.s2.toString();
			        }
			      };
			      _xblockexpression = r;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testFieldInitializerUsesCapturedLocal_02() {
		'''
			class C {
				def m() {
					val s = ''
					val r = new Runnable() {
						val idx = try {
							s.substring(1).length
						} catch(Exception e) {
							-1
						}
						override run() {
							idx.toString
						}
					}
					r
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C {
			  public Runnable m() {
			    abstract class __C_1 implements Runnable {
			      int idx;
			    }
			    
			    __C_1 _xblockexpression = null;
			    {
			      final String s = "";
			      final __C_1 r = new __C_1() {
			        {
			          idx = new Function0<Integer>() {
			            public Integer apply() {
			              int _xtrycatchfinallyexpression = (int) 0;
			              try {
			                String _substring = s.substring(1);
			                _xtrycatchfinallyexpression = _substring.length();
			              } catch (final Throwable _t) {
			                if (_t instanceof Exception) {
			                  final Exception e = (Exception)_t;
			                  _xtrycatchfinallyexpression = (-1);
			                } else {
			                  throw Exceptions.sneakyThrow(_t);
			                }
			              }
			              return _xtrycatchfinallyexpression;
			            }
			          }.apply().intValue();
			        }
			        public void run() {
			          Integer.valueOf(this.idx).toString();
			        }
			      };
			      _xblockexpression = r;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void testAdditionalMemberAccess_01() {
		'''
			class C {
				def m() {
					new Object() {
						public int f
					} => [ f = 1 ]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    abstract class __C_1 {
			      int f;
			    }
			    
			    __C_1 ___C_1 = new __C_1() {
			    };
			    final Procedure1<__C_1> _function = new Procedure1<__C_1>() {
			      public void apply(final __C_1 it) {
			        it.f = 1;
			      }
			    };
			    return ObjectExtensions.<__C_1>operator_doubleArrow(___C_1, _function);
			  }
			}
		''')
	}

	@Test
	def void testGeneric() {
		'''
			class Foo {
				def foo() {
					val bar = new Iterable<String>() {
						override iterator() {
							null
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;

			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    final Iterable<String> bar = new Iterable<String>() {
			      public Iterator<String> iterator() {
			        return null;
			      }
			    };
			  }
			}
		''')
	}

	@Test
	def void testGeneric1() {
		'''
			class Foo  {
				def <T> foo() {
					val bar = new Iterable<T>() {
						override iterator() {
							null
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;

			@SuppressWarnings("all")
			public class Foo {
			  public <T extends Object> void foo() {
			    final Iterable<T> bar = new Iterable<T>() {
			      public Iterator<T> iterator() {
			        return null;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testGeneric2() {
		'''
			import java.util.Iterator
			
			class Foo  {
				def <T> foo() {
					val bar = new Iterable<T>() {
						override Iterator<T> iterator() {
							null
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.Iterator;

			@SuppressWarnings("all")
			public class Foo {
			  public <T extends Object> void foo() {
			    final Iterable<T> bar = new Iterable<T>() {
			      public Iterator<T> iterator() {
			        return null;
			      }
			    };
			  }
			}
		''')
	}

	@Test
	def void testGeneric3() {
		'''
			class Foo<T>  {
				def <U> foo() {
					val bar = new Bar<T,U>() {
						override T bar(U it) {
							null
						}
					}
				}
			}

			interface Bar<V,W> {
				def V bar(W it)
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public <U extends Object> void foo() {
			    final Bar<T, U> bar = new Bar<T, U>() {
			      public T bar(final U it) {
			        return null;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testGeneric4() {
		'''
			class Foo<T>  {
				def foo() {
					val bar = new Bar<T>() {
						override <U> U bar(T it) {
							null
						}
					}
				}
			}

			interface Bar<V> {
				def <W> W bar(V it)
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public void foo() {
			    final Bar<T> bar = new Bar<T>() {
			      public <U extends Object> U bar(final T it) {
			        return null;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testGeneric5() {
		'''
			class C {
				def m() {
					new Object {
						def <T> T m2() {}
					}
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  public Object m() {
			    abstract class __C_1 {
			      public abstract <T extends Object> T m2();
			    }
			    
			    return new __C_1() {
			      public <T extends Object> T m2() {
			        return null;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testGeneric6() {
		'''
			class C {
				def <K> m() {
					new Object {
						def <V> m2() {
							new java.util.AbstractMap<K, V> {
								def Entry<K, V> m() {}
								override entrySet() {}
							}
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import java.util.AbstractMap;
			import java.util.Map;
			import java.util.Set;
			
			@SuppressWarnings("all")
			public class C {
			  public <K extends Object> Object m() {
			    abstract class __C_1 {
			      public abstract <V extends Object> AbstractMap<K, V> m2();
			    }
			    
			    return new __C_1() {
			      public <V extends Object> AbstractMap<K, V> m2() {
			        abstract class ____C_1 extends AbstractMap<K, V> {
			          public abstract Map.Entry<K, V> m();
			        }
			        
			        return new ____C_1() {
			          public Map.Entry<K, V> m() {
			            return null;
			          }
			          
			          public Set<Map.Entry<K, V>> entrySet() {
			            return null;
			          }
			        };
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testGeneric7() {
		'''
			class Foo<T>  {
				def <W extends Foo<W>> foo() {
					val bar = new Bar<W>() {
						override bar() {
							null
						}
					}
				}
				interface Bar<V extends Foo<V>> {
					def V bar()
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo<T extends Object> {
			  public interface Bar<V extends Foo<V>> {
			    public abstract V bar();
			  }
			  
			  public <W extends Foo<W>> void foo() {
			    final Foo.Bar<W> bar = new Foo.Bar<W>() {
			      public W bar() {
			        return null;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testFinalField_01() {
		'''
			class Foo {
				def void foo() {
					val y = 1
					new Object {
						val x = y
						def void bar() {
							println(x)
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    abstract class __Foo_1 {
			      int x;
			      
			      public abstract void bar();
			    }
			    
			    final int y = 1;
			    new __Foo_1() {
			      {
			        x = y;
			      }
			      public void bar() {
			        InputOutput.<Integer>println(Integer.valueOf(this.x));
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testFinalField_02() {
		'''
			class Foo {
				def void foo() {
					val y = 1
					new Object {
						static val x = y
						def void bar() {
							println(x)
						}
					}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    abstract class __Foo_1 {
			      final static int x = 1;
			      
			      public abstract void bar();
			    }
			    
			    final int y = 1;
			    new __Foo_1() {
			      public void bar() {
			        InputOutput.<Integer>println(Integer.valueOf(__Foo_1.x));
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testBug462313() {
		'''
			import test.Visibilities
			class MyXtendClass {
				def void bar() {
					new Visibilities {
						override publicMethod() {
							new Thread {
								override run() {
									protectedMethod
								}
							}
							super.publicMethod
						}
					}
				}	
			}
		'''.assertCompilesTo('''
			import test.Visibilities;
			
			@SuppressWarnings("all")
			public class MyXtendClass {
			  public void bar() {
			    new Visibilities() {
			      public void publicMethod() {
			        new Thread() {
			          public void run() {
			            protectedMethod();
			          }
			        };
			        super.publicMethod();
			      }
			    };
			  }
			}
		''')
	}
	
}
