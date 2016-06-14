/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class AnnotationValidationTest extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void testAnnotationValueTypeCheck_01() {
		val file = parser.parse(''' 
			annotation MyAnnotation {
				StringBuilder notAllowed
			}''')
		helper.assertError(file, XTEND_FIELD, IssueCodes::INVALID_ANNOTATION_VALUE_TYPE)
	}
	
	@Test def void testAnnotationValueTypeCheck_02() {
		val file = parser.parse(''' 
			annotation MyAnnotation {
				Class<? extends StringBuilder>[] allowed1
				String allowed2
				boolean allowed3
				int allowed4
				javax.inject.Inject allowed5
				com.google.common.base.CaseFormat allowed6
			}''')
		helper.assertNoErrors(file)
	}
	
	@Test def void testAnnotationValueTypeCheck_03() {
		val file = parser.parse(''' 
			annotation MyAnnotation {
				String[][] notAllowed
			}''')
		helper.assertError(file, XTEND_FIELD, IssueCodes::INVALID_ANNOTATION_VALUE_TYPE)
	}
	
}

