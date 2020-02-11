/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Christian DIetrich - Initial contribution and API
 */
class Bug448483Test extends AbstractXtendContentAssistBugTest {
	
	@Test
	def void testBug448483() {
		newBuilder.append('''
			class Test {
				
				def -() {
					DoubleExtensions.<|>
				}
			
			}
		''')
			.assertProposalDisplayedAtCursor("toString : String - Class.toString()")
	}
	
}