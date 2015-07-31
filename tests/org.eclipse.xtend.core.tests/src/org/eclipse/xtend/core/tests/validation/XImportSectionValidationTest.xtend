/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.diagnostics.Diagnostic
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.validation.Issue
import org.eclipse.xtext.xbase.annotations.validation.LinkingDiagnosticTypeAwareMessageProducer
import org.junit.Test

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XImportSectionValidationTest extends AbstractXtendTestCase {

	@Inject
	extension ValidationTestHelper
	
	@Test def void checkUnnecessaryImportForEnumLiteral_1() {
		val file = '''
			import static java.lang.annotation.RetentionPolicy.*
			
			class C {
				def m(java.lang.annotation.RetentionPolicy p) {
					switch(p) {
						case CLASS: true
						default: false
					}
				}
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "The import 'java.lang.annotation.RetentionPolicy' is never used.")
	}
	
	@Test def void checkUnnecessaryImportForEnumLiteral_2() {
		val file = '''
			import static java.lang.annotation.ElementType.*
			
			class C {
				def m(java.lang.annotation.RetentionPolicy p) {
					switch(p) {
						case TYPE: true
						default: false
					}
				}
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}
	
	@Test def void checkUnnecessaryImportForEnumLiteral_3() {
		val file = '''
			import static java.lang.annotation.RetentionPolicy.*
			
			@java.lang.annotation.Retention(CLASS)
			annotation A {
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "The import 'java.lang.annotation.RetentionPolicy' is never used.")
	}
	
	@Test def void checkUnnecessaryImportForEnumLiteral_4() {
		val file = '''
			import static java.lang.annotation.ElementType.*
			
			@java.lang.annotation.Target(TYPE, METHOD)
			annotation A {
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "The import 'java.lang.annotation.ElementType' is never used.")
	}
	
	@Test def void checkUnnecessaryImportForEnumLiteral_5() {
		val file = '''
			import static java.lang.annotation.ElementType.*
			
			@java.lang.annotation.Retention(TYPE, METHOD)
			annotation A {
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}
	
	@Test def void checkUnnecessaryImportForEnumLiteral_6() {
		val file = '''
			import static java.lang.annotation.RetentionPolicy.*
			
			@java.lang.annotation.Retention(value=CLASS)
			annotation A {
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "The import 'java.lang.annotation.RetentionPolicy' is never used.")
	}
	
	@Test def void checkUnnecessaryImportForEnumLiteral_7() {
		val file = '''
			import static java.lang.annotation.ElementType.*
			
			@java.lang.annotation.Target(value=#[TYPE, METHOD])
			annotation A {
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "The import 'java.lang.annotation.ElementType' is never used.")
	}
	
	@Test def void checkUnnecessaryImportForEnumLiteral_8() {
		val file = '''
			import static java.lang.annotation.ElementType.*
			
			@java.lang.annotation.Retention(value=#[TYPE, METHOD])
			annotation A {
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}

	@Test def void checkImportWithStaticAccess_0() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.Integer.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertError(XFEATURE_CALL, AMBIGUOUS_FEATURE_CALL)
	}

	@Test def void checkImportWithStaticAccess_1() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithStaticAccess_2() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.Integer.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer.valueOf")
	}

	@Test def void checkImportWithStaticAccess_3() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithStaticAccess_4() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertError(XFEATURE_CALL, AMBIGUOUS_FEATURE_CALL)
	}

	@Test def void checkImportWithStaticAccess_5() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.Integer.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer.valueOf")
	}

	@Test def void checkImportWithStaticAccess_6() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithStaticAccess_7() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertError(XFEATURE_CALL, AMBIGUOUS_FEATURE_CALL)
	}

	@Test def void checkImportWithStaticAccess_8() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithStaticAccess_9() {
		val file = '''
			import static extension java.lang.String.*
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertError(XFEATURE_CALL, AMBIGUOUS_FEATURE_CALL)
	}

	@Test def void checkImportWithExtensionAccess_0() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.Integer.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer.valueOf")
		file.assertFeatureCallError(XMEMBER_FEATURE_CALL)
	}

	@Test def void checkImportWithExtensionAccess_1() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertFeatureCallError(XMEMBER_FEATURE_CALL)
	}
	
	def void assertFeatureCallError(XtendFile file, EClass objectType) {
		val resource = file.eResource

		val List<Issue> allIssues = validate(resource)
		val match = allIssues.filter [
			var EObject object = resource.getResourceSet().getEObject(getUriToProblem(), true)
			val featureCall = data.contains(LinkingDiagnosticTypeAwareMessageProducer.FEATURE_CALL)
			return code == Diagnostic.LINKING_DIAGNOSTIC && getSeverity() === Severity.ERROR &&
				objectType.isInstance(object) && featureCall
		]
		if (match.empty) {
			fail("No Diagnostic.LINKING_DIAGNOSTIC issue with user data FEATURE_CALL found")
		}

	}

	@Test def void checkImportWithExtensionAccess_2() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.Integer.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithExtensionAccess_3() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithExtensionAccess_4() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertFeatureCallError(XMEMBER_FEATURE_CALL)
	}

	@Test def void checkImportWithExtensionAccess_5() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.Integer.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithExtensionAccess_6() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithExtensionAccess_7() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertFeatureCallError(XMEMBER_FEATURE_CALL)
	}

	@Test def void checkImportWithExtensionAccess_8() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
	}

	@Test def void checkImportWithExtensionAccess_9() {
		val file = '''
			import static extension java.lang.String.*
			import static extension java.lang.Integer.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.Integer")
		file.assertError(XMEMBER_FEATURE_CALL, AMBIGUOUS_FEATURE_CALL)
	}
	
	@Test def void unresolvedImport() {
		'''
			import static java.math.BigDecimal.someMethod;
			
			class Foo {}
		'''.toString.file.assertError(XIMPORT_DECLARATION, IMPORT_UNRESOLVED, "java.math.BigDecimal.someMethod")
	}
	
	@Test def void unresolvedImport_2() {
		'''
			import static java.math.BigDecimal.print;
			
			class Foo {}
		'''.toString.file.assertError(XIMPORT_DECLARATION, IMPORT_UNRESOLVED, "java.math.BigDecimal.print")
	}
	
	@Test def void unresolvedImport_3() {
		'''
			import static java.math.BigDecimal.valueOf;
			
			class Foo {}
		'''.toString.file.assertNoErrors(XIMPORT_DECLARATION, IMPORT_UNRESOLVED, "java.math.BigDecimal.valueOf")
	}
	
	

	@Test def void checkDuplicateImportWithStaticAccess_0() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
	}

	@Test def void checkDuplicateImportWithStaticAccess_1() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}

	@Test def void checkDuplicateImportWithStaticAccess_2() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}

	@Test def void checkDuplicateImportWithStaticAccess_3() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
	}

	@Test def void checkDuplicateImportWithStaticAccess_4() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}

	@Test def void checkDuplicateImportWithStaticAccess_5() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}

	@Test def void checkDuplicateImportWithStaticAccess_6() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.String.valueOf
			import static java.lang.String.*
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					copyValueOf(null as char[])
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
	}

	@Test def void checkDuplicateImportWithStaticAccess_7() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					valueOf(2)
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
	}

	@Test def void checkDuplicateImportWithStaticAccess_8() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
				
				def bar() {
					valueOf(2)
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}

	@Test def void checkDuplicateImportWithStaticAccess_9() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "'java.lang.String'")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "'java.lang.String.valueOf'")
	}

	@Test def void checkDuplicateImportWithStaticAccess_10() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}

	@Test def void checkDuplicateImportWithStaticAccess_11() {
		val file = '''
			import static extension java.lang.String.*
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					valueOf(1)
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}
	
	@Test def void checkDuplicateImportWithExtensionAccess_0() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertFeatureCallError(XMEMBER_FEATURE_CALL)
	}

	@Test def void checkDuplicateImportWithExtensionAccess_1() {
		val file = '''
			import static java.lang.String.valueOf
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertFeatureCallError(XMEMBER_FEATURE_CALL)
	}

	@Test def void checkDuplicateImportWithExtensionAccess_2() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String.valueOf")
	}

	@Test def void checkDuplicateImportWithExtensionAccess_3() {
		val file = '''
			import static java.lang.String.valueOf
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "'java.lang.String.valueOf'")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "'java.lang.String'")
	}

	@Test def void checkDuplicateImportWithExtensionAccess_4() {
		val file = '''
			import static java.lang.String.*
			import static java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
		file.assertFeatureCallError(XMEMBER_FEATURE_CALL)
	}

	@Test def void checkDuplicateImportWithExtensionAccess_5() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.String.valueOf
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "'java.lang.String'")
		file.assertNoWarnings(XIMPORT_DECLARATION, IMPORT_UNUSED, "'java.lang.String.valueOf'")
	}

	@Test def void checkDuplicateImportWithExtensionAccess_6() {
		val file = '''
			import static java.lang.String.*
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}

	@Test def void checkDuplicateImportWithExtensionAccess_7() {
		val file = '''
			import static extension java.lang.String.*
			import static extension java.lang.String.*
			
			class Foo {
			
				def foo() {
					1.valueOf
				}
			
			}
		'''.toString.file
		file.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED, "java.lang.String")
	}
	
	@Test
	def void checkImportsNotMarkedAsUsedWhenTypeUnresolved() {
		val file = '''
			import static extension java.lang.String.*
			import static extension java.lang.Integer.*

			class C {
				def m() {
					valueOf(1)
				}
			}
		'''.toString.file
		file.assertNoWarnings(XIMPORT_DECLARATION,IMPORT_UNUSED)
	}

}