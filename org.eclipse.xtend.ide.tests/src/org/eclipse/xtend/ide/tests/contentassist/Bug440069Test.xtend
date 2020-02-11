/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test
import org.eclipse.xtext.testing.Flaky

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug440069Test extends AbstractXtendContentAssistBugTest {
	
	@Flaky
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class MyExtension {
				def String getXyzManager() {
					return ''
				}
			}
			class MyTest {
				extension MyExtension = new MyExtension
				def test() {
					xyzManage<|>
				}
			}
		''')
			.assertProposalAtCursor('xyzManager')
	}
	
	@Test def void test_AfterDef() throws Exception {
		newBuilder.append('''
			class MyTest {
				def <|> test() {
				}
			}
		''')
			.assertProposalAtCursor('String')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			import static extension MyExtension.*
			class MyExtension {
				def static String getXyzManager() {
					return ''
				}
			}
			class MyTest {
				def test() {
					getXyzManage<|>
				}
			}
		''')
			.assertProposalAtCursor('xyzManager')
	}
	
	@Flaky
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class MyExtension {
				def String getXyzManager(Object o) {
					return ''
				}
			}
			class MyTest {
				extension MyExtension = new MyExtension
				def test() {
					xyzManage<|>
				}
			}
		''')
			.assertProposalAtCursor('xyzManager')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			import static extension MyExtension.*
			class MyExtension {
				def static String getXyzManager(Object o) {
					return ''
				}
			}
			class MyTest {
				def test() {
					getXyzManage<|>
				}
			}
		''')
			.assertProposalAtCursor('xyzManager')
	}
	
}