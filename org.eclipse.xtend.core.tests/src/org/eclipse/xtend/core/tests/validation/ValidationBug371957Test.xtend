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
 * @author Anton Kosyakov - Initial contribution and API
 */
class ValidationBug371957Test extends AbstractXtendTestCase {
	
	@Inject 
	extension ValidationTestHelper
	
	@Inject 
	extension ParseHelper<XtendFile>
	
	@Test def void whileLoopInvalidReturn_01() {
		'''
			class Foo {
				def void foo() {
					val x = new StringBuilder
					while (x instanceof CharSequence) {
						return x.toString
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN)
	} 
	
	@Test def void whileLoopInvalidReturn_02() {
		'''
			class Foo {
				def foo() {
					val x = new StringBuilder
					while (x instanceof CharSequence) {
						return x.toString
					}
				}
			}
		'''.parse.assertNoErrors
	} 
	
	@Test def void basicForLoopInvalidReturn_01() {
		'''
			class Foo {
				def void foo() {
					for (val x = new StringBuilder; x instanceof CharSequence;) {
						return x.toString
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XRETURN_EXPRESSION, IssueCodes.INVALID_RETURN)
	} 
	
	@Test def void basicForLoopInvalidReturn_02() {
		'''
			class Foo {
				def foo() {
					for (val x = new StringBuilder; x instanceof CharSequence;) {
						return x.toString
					}
				}
			}
		'''.parse.assertNoErrors
	} 
	
}