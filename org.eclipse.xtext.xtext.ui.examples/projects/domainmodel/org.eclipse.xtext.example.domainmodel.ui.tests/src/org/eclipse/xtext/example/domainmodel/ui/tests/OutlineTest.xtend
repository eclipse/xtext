/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractOutlineTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class OutlineTest extends AbstractOutlineTest {

	@Test def void testOutline() throws Exception {
		'''
			entity Foo {
				name : String
				op doStuff(String x) : String {
					return x + ' ' + this.name
				}
			}
		'''.assertAllLabels(
			'''
				Foo
				  name : String
				  doStuff(String) : String
			'''
		)
	}

	@Test def void testOutlineWithPackage() throws Exception {
		'''
			package mypackage {
				entity Foo {
					name : String
					op doStuff(String x) : String {
						return x + ' ' + this.name
					}
				}
			}
		'''.assertAllLabels(
			'''
				mypackage
				  Foo
				    name : String
				    doStuff(String) : String
			'''
		)
	}

	@Test def void testOutlineWithInheritance() throws Exception {
		'''
			entity A {}
			entity B extends A {}
		'''.assertAllLabels('''
			A
			B extends A
		''')
	}
}
