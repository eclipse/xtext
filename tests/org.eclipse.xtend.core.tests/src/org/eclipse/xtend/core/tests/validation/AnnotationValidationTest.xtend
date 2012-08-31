package org.eclipse.xtend.core.tests.validation

import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.junit.Test
import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtend.core.xtend.XtendFile

import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*
import org.eclipse.xtend.core.validation.IssueCodes

class AnnotationValidationTest extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void testAnnotationValueTypeCheck_01() {
		val file = parser.parse(''' 
			@interface MyAnnotation {
				StringBuilder notAllowed
			}''')
		helper.assertError(file, XTEND_FIELD, IssueCodes::INVALID_ANNOTATION_VALUE_TYPE)
	}
	
	@Test def void testAnnotationValueTypeCheck_02() {
		val file = parser.parse(''' 
			@interface MyAnnotation {
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
			@interface MyAnnotation {
				String[][] notAllowed
			}''')
		helper.assertError(file, XTEND_FIELD, IssueCodes::INVALID_ANNOTATION_VALUE_TYPE)
	}
	
}