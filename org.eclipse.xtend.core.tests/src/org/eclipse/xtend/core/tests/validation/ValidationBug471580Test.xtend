/*******************************************************************************
 * Copyright (c) 2016, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test
import com.google.inject.Inject

/**
 * @author dietrich - Initial contribution and API
 */
class ValidationBug471580Test extends AbstractXtendTestCase {

	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<XtendFile>

	@Test	
	def void testBug471580() {
		val file = '''
		import java.util.Vector
		class Foo {
			def m(Vector<?> items) {
			 	m(#['a'])
			}
		}
		'''.parse
		file.assertError(
			XbasePackage.Literals.XLIST_LITERAL,
			IssueCodes.INCOMPATIBLE_TYPES,
			'Type mismatch: cannot convert from List<Object> to Vector<?>'
		)
	}

}