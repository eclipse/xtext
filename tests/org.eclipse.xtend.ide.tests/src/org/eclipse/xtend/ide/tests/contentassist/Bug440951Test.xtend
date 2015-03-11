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
class Bug440951Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class C {
				def void m() throws AsEr<|> {
				}
			}
		''')
			.assertProposalAtCursor('AssertionError')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.withDirtyState.append('''
			class C {
				def void m() throws MDT<|> {
				}
			}
			class MyDirtyThrowable extends Throwable {}
		''')
			.assertProposalAtCursor('MyDirtyThrowable')
	}
	
	// if no subtype of Throwable is available, propose all types
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class C {
				def void m() throws RetentPoli<|> {
				}
			}
		''')
			.assertProposalAtCursor('java.lang.annotation.RetentionPolicy')
	}
}