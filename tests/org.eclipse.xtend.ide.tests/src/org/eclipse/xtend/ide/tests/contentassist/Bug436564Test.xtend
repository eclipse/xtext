/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug436564Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	toS<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	String s
			  	<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	String s
			  	toS<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_05() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	String s
			  	<|>
			  	String s2
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_06() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	String s
			  	toS<|>
			  	String s2
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_07() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	def s() {}
			  	<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_08() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	def s() {}
			  	toS<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_09() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	def s1() {}
			  	<|>
			  	def s2() {}
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_10() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	def s1() {}
			  	toS<|>
			  	def s2() {}
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_11() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	override toString() {}
			  }
			  <|>
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_12() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	override toString() {}
			  }
			  toS<|>
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_13() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_14() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	toS<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_15() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	String s
			  	<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_16() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	String s
			  	toS<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_17() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	String s
			  	<|>
			  	String s2
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_18() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	String s
			  	toS<|>
			  	String s2
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_19() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	def s() {}
			  	<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_20() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	def s() {}
			  	toS<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_21() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	def s1() {}
			  	<|>
			  	def s2() {}
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_22() throws Exception {
		newBuilder.append('''
			class C {
			  static class C2 {
			  	def s1() {}
			  	toS<|>
			  	def s2() {}
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_23() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	val s = new Object () {
			  		override toString() {}
			  	}
			  	<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
	
	@Test def void test_24() throws Exception {
		newBuilder.append('''
			class C {
			  val o = new Object() {
			  	val s = new Object () {
			  		override toString() {}
			  	}
			  	toS<|>
			  }
			  override toString() {}
			}
		''')
			.assertProposalDisplayedAtCursor('toString() - Override method from Object')
	}
}