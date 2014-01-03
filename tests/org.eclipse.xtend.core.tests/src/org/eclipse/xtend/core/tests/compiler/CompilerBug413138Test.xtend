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
class CompilerBug413138Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				StringRepository repository
				def m()	{
					var string = repository.findByStringId(1L)
					repository.save(string)
				}
			}
			public interface StringRepository extends GraphRepository<String> {
				def String findByStringId(Long id);
			}
			interface GraphRepository<T> {
				def <U extends T> U save(U entity);
			    def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private StringRepository repository;
			  
			  public String m() {
			    String _xblockexpression = null;
			    {
			      String string = this.repository.findByStringId(Long.valueOf(1L));
			      _xblockexpression = (this.repository.<String>save(string));
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				StringRepository repository
				def m()	{
					repository.save(#[])
				}
			}
			public interface StringRepository extends GraphRepository<String> {
				def String findByStringId(Long id);
			}
			interface GraphRepository<T> {
				def <U extends T> U save(U entity);
			    def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		''', '''
			import com.google.common.collect.Lists;
			import java.util.Collections;
			
			@SuppressWarnings("all")
			public class C {
			  private StringRepository repository;
			  
			  public Iterable<String> m() {
			    return this.repository.<String>save(Collections.<String>unmodifiableList(Lists.<String>newArrayList()));
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				CharSeqRepository repository
				def m()	{
					repository.<String>save(newArrayList)
				}
			}
			public interface CharSeqRepository extends GraphRepository<CharSequence> {
			}
			interface GraphRepository<T> {
				def <U extends T> U save(U entity);
			    def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		''', '''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  private CharSeqRepository repository;
			  
			  public Iterable<String> m() {
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
			    return this.repository.<String>save(_newArrayList);
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				CharSeqRepository repository
				def m()	{
					repository.save(#['a'])
				}
			}
			public interface CharSeqRepository extends GraphRepository<CharSequence> {
			}
			interface GraphRepository<T> {
				def <U extends T> U save(U entity);
			    def <U extends T> Iterable<U> save(Iterable<U> entities);
			}
		''', '''
			import com.google.common.collect.Lists;
			import java.util.Collections;
			
			@SuppressWarnings("all")
			public class C {
			  private CharSeqRepository repository;
			  
			  public Iterable<String> m() {
			    return this.repository.<String>save(Collections.<String>unmodifiableList(Lists.<String>newArrayList("a")));
			  }
			}
		''')
	}
	
	
}