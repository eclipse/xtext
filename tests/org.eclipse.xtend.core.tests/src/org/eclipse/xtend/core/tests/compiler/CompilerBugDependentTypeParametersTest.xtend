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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBugDependentTypeParametersTest extends AbstractXtendCompilerTest {
	
	@Test def void test_01() {
		assertCompilesTo('''
			class C {
				def <I extends Iterable<?>> nonEmpty(I i) {
					i
				}
				
				def m(java.util.Collection<String> c) {
					c.nonEmpty
				}
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <I extends Iterable<?>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public Collection<String> m(final Collection<String> c) {
			    return this.<Collection<String>>nonEmpty(c);
			  }
			}
		''')
	}
	
	@Test def void test_02() {
		assertCompilesTo('''
			class C {
				def <E, I extends Iterable<E>> nonEmpty(I i) {
					i
				}
				def m(java.util.Collection<String> c) {
					c.nonEmpty
				}
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <E extends Object, I extends Iterable<E>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public Collection<String> m(final Collection<String> c) {
			    return this.<String, Collection<String>>nonEmpty(c);
			  }
			}
		''')
	}
	
	@Test def void test_03() {
		assertCompilesTo('''
			class C {
				def <K, V, M extends java.util.Map<K, V>> nonEmpty(M m) {
					m
				}
				def m(java.util.Map<String, Integer> m) {
					m.nonEmpty
				}
			}
		''', '''
			import java.util.Map;
			
			@SuppressWarnings("all")
			public class C {
			  public <K extends Object, V extends Object, M extends Map<K,V>> M nonEmpty(final M m) {
			    return m;
			  }
			  
			  public Map<String,Integer> m(final Map<String,Integer> m) {
			    return this.<String, Integer, Map<String,Integer>>nonEmpty(m);
			  }
			}
		''')
	}
	
	@Test def void test_04() {
		assertCompilesTo('''
			class C {
				def <K, V extends K, M extends java.util.Map<K, V>> nonEmpty(M m) {
					m
				}
				def m() {
					val m = newHashMap
					m.put('', null)
					m.nonEmpty
				}
			}
		''', '''
			import java.util.HashMap;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public <K extends Object, V extends K, M extends Map<K,V>> M nonEmpty(final M m) {
			    return m;
			  }
			  
			  public HashMap<String,String> m() {
			    HashMap<String,String> _xblockexpression = null;
			    {
			      final HashMap<String,String> m = CollectionLiterals.<String, String>newHashMap();
			      m.put("", null);
			      _xblockexpression = this.<String, String, HashMap<String,String>>nonEmpty(m);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void test_05() {
		assertCompilesTo('''
			class C {
				def <K, V extends K, M extends java.util.Map<K, V>> nonEmpty(M m) {
					m
				}
				def m() {
					val m = newHashMap
					m.put(null, '')
					m.nonEmpty
				}
			}
		''', '''
			import java.util.HashMap;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public <K extends Object, V extends K, M extends Map<K,V>> M nonEmpty(final M m) {
			    return m;
			  }
			  
			  public HashMap<String,String> m() {
			    HashMap<String,String> _xblockexpression = null;
			    {
			      final HashMap<String,String> m = CollectionLiterals.<String, String>newHashMap();
			      m.put(null, "");
			      _xblockexpression = this.<String, String, HashMap<String,String>>nonEmpty(m);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void test_06() {
		assertCompilesTo('''
			class C {
				def <K, V extends K, M extends java.util.Map<? extends K, ? extends V>> nonEmpty(M m) {
					m
				}
				def m() {
					val m = newHashMap
					m.put(null, '')
					m.nonEmpty
				}
			}
		''', '''
			import java.util.HashMap;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public <K extends Object, V extends K, M extends Map<? extends K,? extends V>> M nonEmpty(final M m) {
			    return m;
			  }
			  
			  public HashMap<String,String> m() {
			    HashMap<String,String> _xblockexpression = null;
			    {
			      final HashMap<String,String> m = CollectionLiterals.<String, String>newHashMap();
			      m.put(null, "");
			      _xblockexpression = this.<String, String, HashMap<String,String>>nonEmpty(m);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def void test_07() {
		assertCompilesTo('''
			class C {
				def <E, I extends Iterable<? extends E>> nonEmpty(I i) {
					i
				}
				def m(java.util.Collection<? extends String> c) {
					c.nonEmpty
				}
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <E extends Object, I extends Iterable<? extends E>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public Collection<? extends String> m(final Collection<? extends String> c) {
			    return this.<String, Collection<? extends String>>nonEmpty(c);
			  }
			}
		''')
	}
	
	@Test def void test_08() {
		assertCompilesTo('''
			class C {
				def <E, I extends Iterable<? extends E>> nonEmpty(I i) {
					i
				}
				def m(java.util.Collection<? super String> c) {
					c.nonEmpty
				}
			}
		''', '''
			import java.util.Collection;
			
			@SuppressWarnings("all")
			public class C {
			  public <E extends Object, I extends Iterable<? extends E>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public Collection<? super String> m(final Collection<? super String> c) {
			    return this.<Object, Collection<? super String>>nonEmpty(c);
			  }
			}
		''')
	}
	
	@Test def void test_09() {
		assertCompilesTo('''
			class C {
				def <E, I extends Iterable<E>> nonEmpty(I i) {
					i
				}
				def nonEmpty(String s) {
					s
				}
				def m(java.util.List<Iterable<?>> o) {
					nonEmpty(o)
				}
			}
		''', '''
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  public <E extends Object, I extends Iterable<E>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public String nonEmpty(final String s) {
			    return s;
			  }
			  
			  public List<Iterable<?>> m(final List<Iterable<?>> o) {
			    return this.<Iterable<?>, List<Iterable<?>>>nonEmpty(o);
			  }
			}
		''')
	}
	
	@Test def void test_10() {
		assertCompilesTo('''
			class C {
				def <E, I extends Iterable<E>> nonEmpty(I i) {
					i
				}
				def nonEmpty(String s) {
					s
				}
				def <T> m(Iterable<? extends T> o) {
					nonEmpty(o)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public <E extends Object, I extends Iterable<E>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public String nonEmpty(final String s) {
			    return s;
			  }
			  
			  public <T extends Object> Iterable<? extends T> m(final Iterable<? extends T> o) {
			    return this.nonEmpty(o);
			  }
			}
		''')
	}
	
	@Test def void test_11() {
		assertCompilesTo('''
			class C {
				def <I extends Iterable<?>> nonEmpty(I i) {
					i
				}
				def m(Object[] o) {
					(o as java.util.List<Object>).nonEmpty
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public <I extends Iterable<?>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public List<Object> m(final Object[] o) {
			    return this.<List<Object>>nonEmpty(((List<Object>) Conversions.doWrapArray(o)));
			  }
			}
		''')
	}
	
	@Test def void test_12() {
		assertCompilesTo('''
			class C {
				def <I extends Iterable<?>> nonEmpty(I i) {
					i
				}
				def m(CharSequence[] o) {
					(o as java.util.Collection<String>).nonEmpty
				}
			}
		''', '''
			import java.util.Collection;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class C {
			  public <I extends Iterable<?>> I nonEmpty(final I i) {
			    return i;
			  }
			  
			  public Collection<String> m(final CharSequence[] o) {
			    return this.<Collection<String>>nonEmpty(((Collection<String>) Conversions.doWrapArray(o)));
			  }
			}
		''')
	}
	
}
