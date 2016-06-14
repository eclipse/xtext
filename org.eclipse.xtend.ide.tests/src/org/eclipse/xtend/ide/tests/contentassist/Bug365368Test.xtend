/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
class Bug365368Test extends AbstractXtendContentAssistBugTest {

	@Test def void testEscapedIdentifierNoPrefix() throws Exception {
		newBuilder().append("class C {
			def void ^as() {}
			def void aa() {}
			def void bb() {}
			def void m() { this.").assertText(
				'^as', 'aa', 'bb', 'm',
				'class', 'clone', 'equals()', 'finalize', 'hashCode', 'identityEquals()', 'notify', 'notifyAll', 'toString', 'wait', 'wait()', 'wait()');
	}
	
	@Test def void testEscapedIdentifierEscapeCharPrefix() throws Exception {
		newBuilder().append("class C {
			def void ^as() {}
			def void aa() {}
			def void bb() {}
			def void m() { this.^").assertText('^as');
	}
	
	@Test def void testEscapedIdentifierFirstCharPrefix() throws Exception {
		newBuilder().append("class C {
			def void ^as() {}
			def void aa() {}
			def void bb() {}
			def void m() { this.a").assertText('^as', 'aa');
	}
	
	@Test def void testEscapedIdentifierFirstCharPrefixApplied() throws Exception {
		newBuilder()
			.append("class C {
				def void ^as() {}
				def void aa() {}
				def void bb() {}
				def void m() { this.a")
			.assertText('^as', 'aa')
			.applyProposal('^as')
			.expectContent("class C {
				def void ^as() {}
				def void aa() {}
				def void bb() {}
				def void m() { this.^as")
	}
	
	@Test def void testEscapedIdentifierTwoCharsPrefix() throws Exception {
		newBuilder().append("class C {
			def void ^as() {}
			def void aa() {}
			def void bb() {}
			def void m() { this.as").assertText('^as');
	}
	
	@Test def void testEscapedIdentifierTwoCharPrefixApplied() throws Exception {
		newBuilder()
			.append("class C {
				def void ^as() {}
				def void aa() {}
				def void bb() {}
				def void m() { this.as")
			.applyProposal()
			.expectContent("class C {
				def void ^as() {}
				def void aa() {}
				def void bb() {}
				def void m() { this.^as");
	}
	
	
}