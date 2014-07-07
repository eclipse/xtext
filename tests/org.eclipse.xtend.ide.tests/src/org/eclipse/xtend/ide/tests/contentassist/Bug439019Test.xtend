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
class Bug439019Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class C {
				@A(NA<|>)
				String s1
			}
			annotation A {
				E[] value
			}
			enum E {
				NAME
			}
		''')
			.assertProposalAtCursor('NAME')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			class C {
				@A(NAME, NA<|>)
				String s1
			}
			annotation A {
				E[] value
			}
			enum E {
				NAME
			}
		''')
			.assertProposalAtCursor('NAME')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class C {
				@A(#[NA<|>])
				String s3
			}
			annotation A {
				E[] value
			}
			enum E {
				NAME
			}
		''')
			.assertProposalAtCursor('NAME')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			class C {
				@A(value=NA<|>)
				String s4
				@A(value=#[NAME])
				String s5
			}
			annotation A {
				E[] value
			}
			enum E {
				NAME
			}
		''')
			.assertProposalAtCursor('NAME')
	}
	
	@Test def void test_05() throws Exception {
		newBuilder.append('''
			class C {
				@A(value=#[NAME, NA<|>])
				String s5
			}
			annotation A {
				E[] value
			}
			enum E {
				NAME
			}
		''')
			.assertProposalAtCursor('NAME')
	}
}