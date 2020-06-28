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
			int inOuter = 1;
			static class StaticInner {
				int inStaticInner = 2;
				class Inner {
					int inInner = in").assertText(
				'inInner', 'inStaticInner', 'instanceof - type test and autocast', 'internalArrayEquals()' /* from static import favorites in org.junit.Assert */);
	}
	
	@Test def void testNoInstanceMembersProposedInStaticLocalClass() throws Exception {
		newBuilder().append("class Outer {
			static int inOuter = 1;
			int instanceInOuter = 2
			static def m() {
				new Object() {
					int inLocal = in").assertText(
				'inOuter', 'inLocal', 'instanceof - type test and autocast', 'internalArrayEquals()' /* from static import favorites in org.junit.Assert */);
	}
	
}