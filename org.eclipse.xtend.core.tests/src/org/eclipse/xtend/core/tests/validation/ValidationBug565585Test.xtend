/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.testing.util.ResourceHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test

/**
 * @author cdietrich - Initial contribution and API
 */
class ValidationBug565585Test extends AbstractXtendTestCase {
	@Inject extension ResourceHelper resourceHelper
	@Inject extension ValidationTestHelper validationHelper

	@Test def void testNoCrash() {
		val first = '''
			class Base {
				def dispatch void doit(String a) {
				}
				def dispatch void doit(Integer i) {
				}	
			}
		'''.resource(URI.createPlatformResourceURI('projectName/src/Base.xtend', true))
		val second = '''
			
			class Sub extends Base {
				def dispatch void doit(Byte a) {
				}
				def void doit(Long s) { 
				}
			}
		'''.resource(URI.createPlatformResourceURI('projectName/src/Sub.xtend', true), first.resourceSet)
		second.assertNoErrors
		second.assertWarning(XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.DISPATCH_PLAIN_FUNCTION_NAME_CLASH,
			"Non-dispatch method has same name and number of parameters as dispatch method")
		second.assertWarning(XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.DISPATCH_PLAIN_FUNCTION_NAME_CLASH,
			"Dispatch method has same name and number of parameters as non-dispatch method")
			
	}
}
