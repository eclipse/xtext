/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
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
class Issue624Test extends AbstractXtendContentAssistBugTest {

	@Test def void testMembersOfEnclosingTypeAreProposed() throws Exception {
		newBuilder().append("class Outer {
			int xxxOuter = 1;
			static class StaticInner {
				int xxxStaticInner = 2;
				class Inner {
					int xxxInner = xxx").assertText(
				'xxxInner', 'xxxStaticInner');
	}
	
	@Test def void testNoInstanceMembersProposedInStaticLocalClass() throws Exception {
		newBuilder().append("class Outer {
			static int xxxOuter = 1;
			int xxxInstanceInOuter = 2
			static def m() {
				new Object() {
					int xxxLocal = xxx").assertText(
				'xxxOuter', 'xxxLocal');
	}
	
}