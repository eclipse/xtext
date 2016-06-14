/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.util.ResourceHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class UniqueClassNameValidatorRuntimeTest extends AbstractXtendTestCase {

	@Inject extension ParseHelper<XtendFile> parseHelper
	@Inject extension ResourceHelper resourceHelper
	@Inject extension ValidationTestHelper validationHelper

	@Test def void testSameFile() {
		'''
			class C {
			}
			interface C {
			}
		'''.parse.assertError(XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "The type C is already defined.")
	}
	
	@Test def void testNestedFile() {
		'''
			class A {
				static class C {
				}
				interface C {
				}
			}
		'''.parse.assertError(XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "Duplicate nested type C")
	}
	
	@Test def void testTwoFilesSameProject() {
		val first = '''
			class C {}
		'''.resource(URI.createPlatformResourceURI('projectName/src/C1.xtend', true))
		val second = '''
			interface C {}
		'''.resource(URI.createPlatformResourceURI('projectName/src/C2.xtend', true), first.resourceSet)
		first.assertError(XtendPackage.Literals.XTEND_CLASS, IssueCodes.DUPLICATE_TYPE, "The type C is already defined in C2.xtend.")
		second.assertError(XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.DUPLICATE_TYPE, "The type C is already defined in C1.xtend.")
	}
	
}