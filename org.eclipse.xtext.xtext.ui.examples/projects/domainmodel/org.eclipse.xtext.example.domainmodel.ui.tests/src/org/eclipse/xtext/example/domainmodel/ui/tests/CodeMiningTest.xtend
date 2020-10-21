/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractCodeMiningTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class CodeMiningTest extends AbstractCodeMiningTest {

	@Test def implicit_return_type_is_presented_as_code_mining() {
		'''
			entity E {
				s: String
				op getS() { s }
			}
		'''.testCodeMining('''
			1 property | 1 operation
			entity E {
				s: String
				op getS() : String { s }
			}
		''')
	}

	@Test def explicit_return_type_is_not_presented_as_code_mining() {
		'''
			entity E {
				s: String
				op getS() : String { s }
			}
		'''.testCodeMining('''
			1 property | 1 operation
			entity E {
				s: String
				op getS() : String { s }
			}
		''')
	}

	@Test def several_entities_001() {
		'''
			entity E1 {
			}
			entity E2 {
			}
		'''.testCodeMining('''
			0 properties | 0 operations
			entity E1 {
			}
			0 properties | 0 operations
			entity E2 {
			}
		''')
	}

	@Test def several_entities_002() {
		'''
			entity E1 {
			}
			
			entity E2 {
			}
		'''.testCodeMining('''
			0 properties | 0 operations
			entity E1 {
			}
			
			0 properties | 0 operations
			entity E2 {
			}
		''')
	}
}