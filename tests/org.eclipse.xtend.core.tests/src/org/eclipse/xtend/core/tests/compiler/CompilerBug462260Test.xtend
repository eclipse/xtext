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
class CompilerBug462260Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import java.util.Set
			import java.util.Map
			import java.util.List
			
			abstract class Bug {
				def <E> Map<E, E> graph(Set<E> vertices, Map<E, List<E>> edges)
				def test() {
					graph(#{"a"}, #{"a" -> #["b"]})
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract <E extends Object> Map<E, E> graph(final Set<E> vertices, final Map<E, List<E>> edges);
			  
			  public Map<String, String> test() {
			    Pair<String, List<String>> _mappedTo = Pair.<String, List<String>>of("a", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b")));
			    return this.<String>graph(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("a")), Collections.<String, List<String>>unmodifiableMap(CollectionLiterals.<String, List<String>>newHashMap(_mappedTo)));
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import java.util.Set
			import java.util.Map
			import java.util.List
			
			abstract class Bug {
				def <E> Map<E, E> graph(Set<E> vertices, Map<E, List<E>> edges)
				def test() {
					graph(#{}, #{})
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract <E extends Object> Map<E, E> graph(final Set<E> vertices, final Map<E, List<E>> edges);
			  
			  public Map<Object, Object> test() {
			    return this.<Object>graph(Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet()), Collections.<Object, List<Object>>unmodifiableMap(CollectionLiterals.<Object, List<Object>>newHashMap()));
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			import java.util.Set
			import java.util.Map
			import java.util.List
			
			abstract class Bug {
				def <E, M extends Map<E, List<E>>> Map<E, E> graph(Set<E> vertices, M edges)
				def test() {
					graph(#{"a"}, #{"a" -> #["b"]})
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract <E extends Object, M extends Map<E, List<E>>> Map<E, E> graph(final Set<E> vertices, final M edges);
			  
			  public Map<String, String> test() {
			    Pair<String, List<String>> _mappedTo = Pair.<String, List<String>>of("a", Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("b")));
			    return this.<String, Map<String, List<String>>>graph(Collections.<String>unmodifiableSet(CollectionLiterals.<String>newHashSet("a")), Collections.<String, List<String>>unmodifiableMap(CollectionLiterals.<String, List<String>>newHashMap(_mappedTo)));
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			import java.util.Set
			import java.util.Map
			import java.util.List
			
			abstract class Bug {
				def <E, M extends Map<E, List<E>>> Map<E, E> graph(Set<E> vertices, M edges)
				def test() {
					graph(#{}, #{})
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.List;
			import java.util.Map;
			import java.util.Set;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract <E extends Object, M extends Map<E, List<E>>> Map<E, E> graph(final Set<E> vertices, final M edges);
			  
			  public Map<Object, Object> test() {
			    return this.<Object, Map<Object, List<Object>>>graph(Collections.<Object>unmodifiableSet(CollectionLiterals.<Object>newHashSet()), Collections.<Object, List<Object>>unmodifiableMap(CollectionLiterals.<Object, List<Object>>newHashMap()));
			  }
			}
		''')
	}
	
	@Test def test_05() {
		'''
			import java.util.Set
			import java.util.Map
			import java.util.List
			
			abstract class Bug {
				def <E> void graph(E e1, E e2)
				def test() {
					graph(newHashMap, #{})
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.HashMap;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public abstract class Bug {
			  public abstract <E extends Object> void graph(final E e1, final E e2);
			  
			  public void test() {
			    HashMap<Object, Object> _newHashMap = CollectionLiterals.<Object, Object>newHashMap();
			    this.<Map<Object, Object>>graph(_newHashMap, Collections.<Object, Object>unmodifiableMap(CollectionLiterals.<Object, Object>newHashMap()));
			  }
			}
		''')
	}
	
}