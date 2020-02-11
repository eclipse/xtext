/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug458611Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class C {
				static class Bar {
				}
				static class Foo {
				    def sum(Bar[] bars) {
				    }
				}
				extension Foo 
			    def doit(Iterable<Bar> myBars) {
			        myBars.sum<|>
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			import static extension C.Foo.*
			class C {
				static class Bar {
				}
				static class Foo {
				    static def sum(Bar[] bars) {
				    }
				}
			    def doit(Iterable<Bar> myBars) {
			        myBars.sum<|>
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class C {
				static class Bar {
				}
				static class Foo {
				    def sum(Iterable<Bar> bars) {
				    }
				}
				extension Foo 
			    def doit(Bar[] myBars) {
			        myBars.sum<|>
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			import static extension C.Foo.*
			class C {
				static class Bar {
				}
				static class Foo {
				    static def sum(Iterable<Bar> bars) {
				    }
				}
			    def doit(Bar[] myBars) {
			        myBars.sum<|>
			    }
			}
		''')
			.assertProposalAtCursor('sum')
	}
	
	
}