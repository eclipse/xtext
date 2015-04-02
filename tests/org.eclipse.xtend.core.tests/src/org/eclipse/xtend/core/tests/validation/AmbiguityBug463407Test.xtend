/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AmbiguityBug463407Test extends AmbiguityValidationTest {
	
	@Test
	def void testUnambiguousMethod_01() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter(#["", ""])
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_02() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter(#[''])
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_03() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter(#[])
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_04() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter(newArrayList(''))
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_05() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter(newArrayList)
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_06() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    #["", ""].aSetter
			  }
			  def void aSetter(List<? extends Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_07() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter[]
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testUnambiguousMethod_08() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter[|]
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertUnambiguous()
	}
	
	@Test
	def void testAmbiguousMethod_01() {
		'''
			import org.eclipse.xtext.xbase.lib.Functions.Function0
			import java.util.List
			
			class A {
			  def m() {
			    aSetter(null)
			  }
			  def void aSetter(List<Object> c) {}
			  def void aSetter(Function0<List<Object>> c) {}
			}
		'''.assertAmbiguous('''
			Ambiguous feature call.
			The methods
				aSetter(List<Object>) in A and
				aSetter(Function0<List<Object>>) in A
			both match.''')
	}
	
}