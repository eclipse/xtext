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
class MemberFeatureCallProposalsTest extends AbstractXtendContentAssistBugTest {
	
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class C {
			  def static void main() {
			    val list = #[]
			    list.em
			  }
			}
		''')
			.assertTextAtCursorPosition('em', 2, 'empty')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			class C {
			  def static void main() {
			    val it = #[]
			    em
			  }
			}
		''')
			.assertTextAtCursorPosition('em', 2, 'empty', 'emptyList', 'emptyMap', 'emptySet')
	}
	
}