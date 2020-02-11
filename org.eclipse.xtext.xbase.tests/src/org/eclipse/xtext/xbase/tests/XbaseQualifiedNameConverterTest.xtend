/** 
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests

import javax.inject.Inject
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.XbaseQualifiedNameConverter
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith

import static org.junit.Assert.*

/**
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XbaseInjectorProvider)
class XbaseQualifiedNameConverterTest {
	@Inject XbaseQualifiedNameConverter converter

	@Rule
	public ExpectedException thrown = ExpectedException.none()

	@Test
	def void test_toQualifiedName() {
		val testdata = #{
			// default qnconverter
			#["foo"] -> "foo",
			#["foo", "bar"] -> "foo.bar"// now the specific ones
			,
			#[".."] -> "..",
			#["..<"] -> "..<",
			#[">.."] -> ">.."
		}

		testdata.entrySet.forEach [
			assertEquals(QualifiedName.create(key), converter.toQualifiedName(value))
		]
	}

	@Test
	def void test_toQualifiedName_null() {
		thrown.expect(IllegalArgumentException)
		thrown.expectMessage("Qualified name cannot be null")
		
		converter.toQualifiedName(null)
	}

	@Test
	def void test_toQualifiedName_empty() {
		thrown.expect(IllegalArgumentException)
		thrown.expectMessage("Qualified name cannot be empty")
		
		converter.toQualifiedName("")
	}
}
