/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug439989Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			import static extension java.util.Collections.*
			import java.util.List
			
			class C {
				var List<Integer> aList
				def getDelta() {
					return aList.max - aList.min
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  private List<Integer> aList;
			
			  public int getDelta() {
			    Integer _max = Collections.<Integer>max(this.aList);
			    Integer _min = Collections.<Integer>min(this.aList);
			    return ((_max).intValue() - (_min).intValue());
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			import java.util.List
			
			class C {
				var List<Integer> aList
				def getDelta() {
					return aList.max - aList.min
				}
			}
		''', '''
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  private List<Integer> aList;
			
			  public int getDelta() {
			    Integer _max = IterableExtensions.<Integer>max(this.aList);
			    Integer _min = IterableExtensions.<Integer>min(this.aList);
			    return ((_max).intValue() - (_min).intValue());
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import static extension java.util.Collections.*
			import java.util.List
			
			class C {
				var List<Integer> aList
				def getDelta() {
					return aList.max + 1
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class C {
			  private List<Integer> aList;
			
			  public int getDelta() {
			    Integer _max = Collections.<Integer>max(this.aList);
			    return ((_max).intValue() + 1);
			  }
			}
		''')
	}
	
	
	
}