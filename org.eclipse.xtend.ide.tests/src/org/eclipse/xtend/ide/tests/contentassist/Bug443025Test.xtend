/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class Bug443025Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			import java.util.List
			import ArLi<|>
			
			class C {}
		''')
			.assertProposalAtCursor('java.util.ArrayList')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			import java.util.List
			import <|>
			
			class C {}
		''')
			.assertProposalAtCursor('java.util.ArrayList')
	}
	
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			import java.util.List
			import static ArLi<|>
			
			class C {}
		''')
			.assertProposalAtCursor('java.util.ArrayList')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			import java.util.List
			import static <|>
			
			class C {}
		''')
			.assertProposalAtCursor('java.util.ArrayList')
	}
	
}