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
class Bug453271Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				def void m() {
					getThi<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				def void m() {
					thin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				def void m() {
					C.getThin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				def void m() {
					C.thin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_05() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				static def void m() {
					getThi<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_06() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				static def void m() {
					thin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_07() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				static def void m() {
					C.getThin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_08() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				static def void m() {
					C.thin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_09() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				static def void m() {
					C::getThin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_10() throws Exception {
		newBuilder.append('''
			class C {
				static def String getThingyDingy() {
					''
				}
				static def void m() {
					C::thin<|>
				}
			}
		''')
			.assertProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_11() throws Exception {
		newBuilder.append('''
			class C {
				def String getThingyDingy() {
					''
				}
				static def void m() {
					getThi<|>
				}
			}
		''')
			.assertNoProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_12() throws Exception {
		newBuilder.append('''
			class C {
				def String getThingyDingy() {
					''
				}
				static def void m() {
					thin<|>
				}
			}
		''')
			.assertNoProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_13() throws Exception {
		newBuilder.append('''
			class C {
				def String getThingyDingy() {
					''
				}
				static def void m() {
					C.getThin<|>
				}
			}
		''')
			.assertNoProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_14() throws Exception {
		newBuilder.append('''
			class C {
				def String getThingyDingy() {
					''
				}
				static def void m() {
					C.thin<|>
				}
			}
		''')
			.assertNoProposalAtCursor('thingyDingy')
	}
	
	@Test def void test_15() throws Exception {
		newBuilder.append('''
			class C {
				def void m() {
					C.thi<|>
				}
			}
		''')
			.assertProposalAtCursor('this')
	}
	
	@Test def void test_16() throws Exception {
		newBuilder.append('''
			class C {
				def void m() {
					C.sup<|>
				}
			}
		''')
			.assertProposalAtCursor('super')
	}
	
	@Test def void test_17() throws Exception {
		newBuilder.append('''
			class C {
				def void m() {
					C::thi<|>
				}
			}
		''')
			.assertNoProposalAtCursor('this')
	}
	
	@Test def void test_18() throws Exception {
		newBuilder.append('''
			class C {
				def void m() {
					C::sup<|>
				}
			}
		''')
			.assertNoProposalAtCursor('super')
	}
	
	@Test def void test_19() throws Exception {
		newBuilder.append('''
			class C {
				static def void m() {
					C.thi<|>
				}
			}
		''')
			.assertNoProposalAtCursor('this')
	}
	
	@Test def void test_20() throws Exception {
		newBuilder.append('''
			class C {
				static def void m() {
					C.sup<|>
				}
			}
		''')
			.assertNoProposalAtCursor('super')
	}
	
}