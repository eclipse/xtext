/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class EclipseIssue219Test extends AbstractXtendContentAssistBugTest {
	
	@Test def void testIssue219() {
		newBuilder.append('''
			package test
			class Test {
				
		''').applyProposal("def - public method").expectContent('''
		package test
		class Test {
			
		def name(params) {
			
		}''')
	}
	
}