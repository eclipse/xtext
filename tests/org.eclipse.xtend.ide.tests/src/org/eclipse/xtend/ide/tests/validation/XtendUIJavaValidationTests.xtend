package org.eclipse.xtend.ide.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.common.types.TypesPackage$Literals.*
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFunction

class XtendUIJavaValidationTests extends AbstractXtendUITestCase {
	@Inject
	private WorkbenchTestHelper testHelper;
	@Inject
	private ValidationTestHelper helper;

	@Test
	def void testForbiddenImport() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
		import org.eclipse.xtext.ui.tests.restricted.RestrictedClass
		class Foo {
		}

		''')
		helper.assertError(xtendFile.imports.get(0), XTEND_IMPORT, FORBIDDEN_REFERENCE)
	}

	@Test
	def void testDiscouragedImport() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
		import org.eclipse.xtext.ui.tests.internal.InternalClass
		class Foo {
		}

		''')
		helper.assertWarning(xtendFile.imports.get(0), XTEND_IMPORT, DISCOURAGED_REFERENCE)
	}

	@Test
	def void testValidImport() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
		import java.util.List
		class Foo {
			def bar(List l){}
		}

		''')
		helper.assertNoIssues(xtendFile.imports.get(0))
	}

	@Test
	def void testForbiddenConstructorCall() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
		import org.eclipse.xtext.ui.tests.restricted.RestrictedClass
		class Foo {
			RestrictedClass x = new RestrictedClass
		}

		''')
		helper.assertError(xtendFile.imports.get(0), XTEND_IMPORT, FORBIDDEN_REFERENCE)
		val field = xtendFile.xtendClasses.get(0).members.get(0) as XtendField
		helper.assertError(field.type, JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
		helper.assertError(field.initialValue, XCONSTRUCTOR_CALL, FORBIDDEN_REFERENCE)
	}

	@Test
	def void testDiscouragedConstructorCall() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
		import org.eclipse.xtext.ui.tests.internal.InternalClass
		class Foo {
			InternalClass x = new InternalClass
		}

		''')
		helper.assertWarning(xtendFile.imports.get(0), XTEND_IMPORT, DISCOURAGED_REFERENCE)
		val field = xtendFile.xtendClasses.get(0).members.get(0) as XtendField
		helper.assertWarning(field.type, JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE)
		helper.assertWarning(field.initialValue, XCONSTRUCTOR_CALL, DISCOURAGED_REFERENCE)
	}

		@Test
	def void testForbiddenTypeUsage() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
		class Foo {
			def bar(org.eclipse.xtext.ui.tests.restricted.RestrictedClass x) {}
		}

		''')
		val function = xtendFile.xtendClasses.get(0).members.get(0) as XtendFunction
		helper.assertError(function.parameters.get(0), JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
	}

	@Test
	def void testDiscouragedTypeUsage() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
		class Foo {
			def bar(org.eclipse.xtext.ui.tests.internal.InternalClass x){}
		}

		''')

		val function = xtendFile.xtendClasses.get(0).members.get(0) as XtendFunction
		helper.assertWarning(function.parameters.get(0), JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE)
	}

}