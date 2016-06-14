/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ValidationBug447516Test extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val file = parser.parse('''
			import org.eclipse.xtext.util.concurrent.IReadAccess
			class C {
				public val IReadAccess<CharSequence> stateAccess = [ return "" ]
			}
		''')
		file.assertError(XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from String to T")
	}
	
	@Test def void test_02() {
		val file = parser.parse('''
			import org.eclipse.xtext.util.concurrent.IReadAccess
			class C {
				public val IReadAccess<CharSequence> stateAccess = [ return it.exec("") ]
			}
		''')
		file.assertNoIssues
	}
	
}