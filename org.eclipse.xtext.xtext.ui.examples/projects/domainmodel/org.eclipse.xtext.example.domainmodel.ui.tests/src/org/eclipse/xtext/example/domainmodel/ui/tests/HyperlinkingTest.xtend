/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractHyperlinkingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class HyperlinkingTest extends AbstractHyperlinkingTest {

	@Before def void setup() throws Exception {
		/*
		 * Xbase-based languages require java project
		 */
		projectName.createJavaProject
	}

	@Test def hyperlink_on_java_import_statement() {
		'''
			import «c»java.util.Date«c»
			
			entity Foo {
				date : Date
			}
		'''.hasHyperlinkTo("java.util.Date")
	}

	@Test def hyperlink_on_java_member_type() {
		'''
			import java.util.Date
			
			entity Foo {
				date : «c»Date«c»
			}
		'''.hasHyperlinkTo("java.util.Date")
	}

	@Test def hyperlink_on_entity_import_statement() {
		'''
			import «c»foopackage.Foo«c»
			
			package foopackage {
				entity Foo {}
			}
			
			entity Bar {
				foo : Foo
			}
		'''.hasHyperlinkTo("foopackage.Foo")
	}

	@Test def hyperlink_javadoc_link_to_java_type() {
		'''
			import java.util.Date
			
			/**
			 * {@link «c»Date«c»}
			 */
			entity Foo {
				date : Date
			}
		'''.hasHyperlinkTo("java.util.Date")
	}

	@Test def hyperlink_on_entity_member_type() {
		'''
			entity Foo {}
			
			entity Bar {
				foo : «c»Foo«c»
			}
		'''.hasHyperlinkTo("Foo")
	}

	@Test def hyperlink_on_entity_member_type_in_package() {
		'''
			import foopackage.Foo
			
			package foopackage {
				entity Foo {}
			}
			
			entity Bar {
				foo : «c»foopackage.Foo«c»
			}
		'''.hasHyperlinkTo("foopackage.Foo")
	}

	@Test def hyperlink_javadoc_link_to_entity_type() {
		'''
			import java.util.Date
			
			/**
			 * {@link «c»Foo«c»}
			 */
			entity Foo {
				date : Date
			}
		'''.hasHyperlinkTo("Foo")
	}
}