/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug440906Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def m() {
					[ Object a, Object b | 1 ]
				}
				
				def m2() {
					#[].sortWith(m)
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.Comparator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Function2<Object, Object, Integer> m() {
			    final Function2<Object, Object, Integer> _function = new Function2<Object, Object, Integer>() {
			      public Integer apply(final Object a, final Object b) {
			        return Integer.valueOf(1);
			      }
			    };
			    return _function;
			  }
			
			  public List<Object> m2() {
			    return IterableExtensions.<Object>sortWith(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()), new Comparator<Object>() {
			        public int compare(Object arg0, Object arg1) {
			          return C.this.m().apply(arg0, arg1);
			        }
			    });
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def m() {
					[ Object a, Object b | 1 ]
				}
				
				def m2() {
					#[].sortWith({toString m})
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.Comparator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Function2<Object, Object, Integer> m() {
			    final Function2<Object, Object, Integer> _function = new Function2<Object, Object, Integer>() {
			      public Integer apply(final Object a, final Object b) {
			        return Integer.valueOf(1);
			      }
			    };
			    return _function;
			  }
			
			  public List<Object> m2() {
			    Function2<Object, Object, Integer> _xblockexpression = null;
			    {
			      this.toString();
			      _xblockexpression = this.m();
			    }
			    final Function2<Object, Object, Integer> _final_xblockexpression = _xblockexpression;
			    return IterableExtensions.<Object>sortWith(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()), new Comparator<Object>() {
			        public int compare(Object arg0, Object arg1) {
			          return _final_xblockexpression.apply(arg0, arg1);
			        }
			    });
			  }
			}
		''')
	}
	
}