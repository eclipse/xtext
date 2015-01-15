/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug440906Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def m() {
					[ Object a, Object b | 1 ]
				}
				
				def m2() {
					#[].sortWith(m)
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Comparator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Function2<Object, Object, Integer> m() {
			    final Function2<Object, Object, Integer> _function = (Object a, Object b) -> {
			      return Integer.valueOf(1);
			    };
			    return _function;
			  }
			  
			  public List<Object> m2() {
			    Function2<Object, Object, Integer> _m = this.m();
			    final Function2<Object, Object, Integer> _final_m = _m;
			    return IterableExtensions.<Object>sortWith(Collections.<Object>unmodifiableList(CollectionLiterals.<Object>newArrayList()), new Comparator<Object>() {
			        public int compare(Object arg0, Object arg1) {
			          return _final_m.apply(arg0, arg1);
			        }
			    });
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		'''
			class C {
				def m() {
					[ Object a, Object b | 1 ]
				}
				
				def m2() {
					#[].sortWith({toString m})
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Comparator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Function2<Object, Object, Integer> m() {
			    final Function2<Object, Object, Integer> _function = (Object a, Object b) -> {
			      return Integer.valueOf(1);
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