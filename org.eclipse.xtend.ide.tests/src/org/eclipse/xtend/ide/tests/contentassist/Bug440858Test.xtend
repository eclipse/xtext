/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class Bug440858Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			annotation MyTest {
				static class MyInner {
					toSt<|>
				}
			}
		''')
			.assertProposalAtCursor("\n\t\toverride toString() {\n\t\t\tsuper.toString()\n\t\t}\n\t\t")
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			annotation MyTest {
				static class MyInner {
					<|>
				}
			}
		''')
			.assertProposalAtCursor("\n\t\toverride toString() {\n\t\t\tsuper.toString()\n\t\t}\n\t\t")
	}
	
}
