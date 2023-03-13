/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*

/**
 * @author Eva Poell - Initial contribution
 */
class ValidationIssue719Test extends AbstractXtendTestCase {
	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<XtendFile>

	@Test
	def void namedAndDeclaredAbstract() {
		'''
			abstract class AbstractC {
			}
		'''.parse.assertNoIssues
	}

	@Test
	def void namedAndNotDeclaredAbstract() {
		'''
			class AbstractC {
			}
		'''.warn()
	}

	@Test
	def void namedAndNotDeclaredAbstractPackage() {
		'''
			package class AbstractC {
			}
		'''.warn()
	}

	@Test
	def void namedAndNotDeclaredAbstractFinal() {
		'''
			final class AbstractC {
			}
		'''.warn()
	}
	
	@Test
	def void namedAndNotDeclaredAbstractAnnotation() {
		'''
			@Depreciated
			class AbstractX{
			}
		'''.warn()
	}
	
	@Test
	def void namedAndNotDeclaredAbstractJavaDoc() {
		'''
			/**
			 * This is a doc for this abstract class.
			 * It even has two lines.
			 */
			class AbstractX{
			}
		'''.warn()
	}
	
	def private warn(CharSequence input) {
		input.parse.assertWarning(XTEND_CLASS, MODIFIER_DOES_NOT_MATCH_TYPENAME, "not declared abstract")
	}
}
