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
class CompilerBug412894Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						switch it {
							String: list.add(it)
						}
					]
				}
			}
		''', '''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<String> list = CollectionLiterals.<String>newArrayList();
			    final Procedure1<String> _function = new Procedure1<String>() {
			      public void apply(final String it) {
			        boolean _matched = false;
			        if (it instanceof String) {
			          _matched=true;
			          list.add(it);
			        }
			      }
			    };
			    IterableExtensions.<String>forEach(list, _function);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						switch it {
							String: list.add(it)
							Number: list.add(it)
						}
					]
				}
			}
		''', '''
			import java.io.Serializable;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<Serializable> list = CollectionLiterals.<Serializable>newArrayList();
			    final Procedure1<Serializable> _function = new Procedure1<Serializable>() {
			      public void apply(final Serializable it) {
			        boolean _matched = false;
			        if (it instanceof String) {
			          _matched=true;
			          list.add(it);
			        }
			        if (!_matched) {
			          if (it instanceof Number) {
			            _matched=true;
			            list.add(it);
			          }
			        }
			      }
			    };
			    IterableExtensions.<Serializable>forEach(list, _function);
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						switch it {
							Number: list.add(it.toString)
						}
					]
				}
			}
		''', '''
			import java.io.Serializable;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<Serializable> list = CollectionLiterals.<Serializable>newArrayList();
			    final Procedure1<Serializable> _function = new Procedure1<Serializable>() {
			      public void apply(final Serializable it) {
			        boolean _matched = false;
			        if (it instanceof Number) {
			          _matched=true;
			          String _string = ((Number)it).toString();
			          list.add(_string);
			        }
			      }
			    };
			    IterableExtensions.<Serializable>forEach(list, _function);
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						if (it instanceof String) list.add(it)
					]
				}
			}
		''', '''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<Object> list = CollectionLiterals.<Object>newArrayList();
			    final Procedure1<Object> _function = new Procedure1<Object>() {
			      public void apply(final Object it) {
			        if ((it instanceof String)) {
			          list.add(it);
			        }
			      }
			    };
			    IterableExtensions.<Object>forEach(list, _function);
			  }
			}
		''')
	}
	
}