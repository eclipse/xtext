/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.junit.Test

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class AnonymousClassCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def void testLocalVar() {'''
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
	def void testNestedTypeScoping_01() {'''
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
	def void testNestedTypeScoping_02() {'''
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
	def void testNestedTypeScoping_03() {'''
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
			import com.google.common.collect.Sets;
			import java.util.AbstractMap;
			import java.util.Collections;
			import java.util.Map;
			import java.util.Set;
			
			@SuppressWarnings("all")
			public class C {
			  public AbstractMap<String, String> newMap() {
			    return new AbstractMap<String, String>() {
			      public Set<Map.Entry<String, String>> entrySet() {
			        Set<Map.Entry<String, String>> _xblockexpression = null;
			        {
			          Map.Entry.class.getDeclaredMethods();
			          _xblockexpression = Collections.<Map.Entry<String, String>>unmodifiableSet(Sets.<Map.Entry<String, String>>newHashSet());
			        }
			        return _xblockexpression;
			      }
			    };
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_01() {'''
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
			    @SuppressWarnings("all")
			    final class __C_1 extends D {
			      public D m() {
			        return this;
			      }
			    }
			    
			    return new __C_1();
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_02() {'''
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
			    @SuppressWarnings("all")
			    final class __C_1 extends D {
			      public String m() {
			        return this.toString();
			      }
			    }
			    
			    return new __C_1();
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_03() {'''
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
			    @SuppressWarnings("all")
			    final class __C_1 extends D {
			      public void m() {
			        C.this.m2();
			      }
			    }
			    
			    return new __C_1();
			  }
			  
			  public void m2() {
			  }
			}
		''')
	}
	
	@Test
	def void testThisScoping_04() {'''
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
			    @SuppressWarnings("all")
			    final class __C_1 extends D {
			      public void m() {
			        C.this.m();
			      }
			    }
			    
			    return new __C_1();
			  }
			  
			  public void m() {
			  }
			}
		''')
	}
	
	@Test
	def void testSuperScoping_01() {'''
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
	def void testSuperScoping_02() {'''
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
	def void testLocalVar_AdditionalMember() {'''
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
			    @SuppressWarnings("all")
			    final class __Foo_1 implements Runnable {
			      public void run() {
			      }
			      
			      private int baz;
			    }
			    
			    final __Foo_1 bar = new __Foo_1();
			  }
			}
		''')
	}
	
	@Test
	def void testLocalVar_AdditionalMember_Return() {'''
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
			    @SuppressWarnings("all")
			    final class __Foo_1 implements Runnable {
			      public void run() {
			      }
			      
			      private int baz;
			    }
			    
			    return new __Foo_1();
			  }
			}
		''')
	}
	
	@Test
	def void testLocalVarInArray_01() {'''
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
	def void testLocalVarInArray_02() {'''
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
			import com.google.common.collect.Lists;
			import java.util.Collections;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void foo() {
			    final List<Runnable> bar = Collections.<Runnable>unmodifiableList(Lists.<Runnable>newArrayList(new Runnable() {
			      public void run() {
			      }
			    }));
			  }
			}
		''')
	}
	
	@Test
	def void testField() {'''
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
	def void testField_AdditionalMember() {'''
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
			      @SuppressWarnings("all")
			      final class __Foo_1 implements Runnable {
			        private int baz;
			        
			        public void run() {
			        }
			      }
			      
			      __Foo_1 ___Foo_1 = new __Foo_1();
			      return ___Foo_1;
			    }
			  }.apply();
			}
		''')
	}

	@Test
	def void testGeneric() {'''
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
	def void testGeneric1() {'''
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
	def void testGeneric2() {'''
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
	def void testGeneric3() {'''
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
	def void testGeneric4() {'''
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
	def void testGeneric5() {'''
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
			    @SuppressWarnings("all")
			    final class __C_1 {
			      public <T extends Object> T m2() {
			        return null;
			      }
			    }
			    
			    return new __C_1();
			  }
			}
		''')
	}
	
}
