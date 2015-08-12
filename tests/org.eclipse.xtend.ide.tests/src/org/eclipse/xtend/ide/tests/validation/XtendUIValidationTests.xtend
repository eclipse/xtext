package org.eclipse.xtend.ide.tests.validation

import com.google.inject.Inject
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jdt.internal.core.JavaModelManager
import org.eclipse.jface.preference.IPersistentPreferenceStore
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendClass
import org.eclipse.xtend.core.xtend.XtendField
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper
import org.eclipse.xtext.common.types.JvmParameterizedTypeReference
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess
import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtend.core.xtend.XtendPackage$Literals.*
import static org.eclipse.xtext.common.types.TypesPackage$Literals.*
import static org.eclipse.xtext.xbase.XbasePackage$Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*
import static org.eclipse.xtext.xtype.XtypePackage$Literals.*
import org.eclipse.xtext.util.OnChangeEvictingCache

class XtendUIValidationTests extends AbstractXtendUITestCase {
	@Inject
	private WorkbenchTestHelper testHelper;
	@Inject
	private ValidationTestHelper helper;
	@Inject
	private IPreferenceStoreAccess prefStoreAccess;
	@Inject
	private OnChangeEvictingCache cache
	
	override tearDown() throws Exception {
		testHelper.tearDown
	}
	
	@Test
	def void testWrongPackage() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			package my.foo.pack
			class Foo {
			}
		''')
		helper.assertError(xtendFile, XTEND_FILE, WRONG_PACKAGE)
	}
	
	@Test
	def void testWrongFile() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			class Foo {
			}
		''')
		helper.assertWarning(xtendFile, XTEND_TYPE_DECLARATION, WRONG_FILE)
	}
	
	@Test
	def void testNoWrongFile() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			class Foo {
			}
			class Bar {
			}
		''')
		helper.assertNoWarnings(xtendFile, XTEND_FILE, WRONG_FILE)
	}
	
	@Test
	def void testForbiddenImport() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.restricted.RestrictedClass
			class Foo {
			}
		''')
		helper.assertError(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, FORBIDDEN_REFERENCE)
	}

	@Test
	def void testDiscouragedImport() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.internal.InternalClass
			class Foo {
			}
		''')
		helper.assertWarning(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, DISCOURAGED_REFERENCE)
	}
	
	@Test
	def void testForbiddenImportInnerClass() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass
			class Foo {
			}
		''')
		helper.assertError(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, FORBIDDEN_REFERENCE)
	}

	@Test
	def void testDiscouragedImportInnerClass() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass
			class Foo {
			}
		''')
		helper.assertWarning(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, DISCOURAGED_REFERENCE)
	}

	@Test
	def void testValidImport() {
		val xtendFile = testHelper.xtendFile("Foo.xtend",'''
			import java.util.List
			class Foo {
				def bar(List<?> l){}
			}
		''')
		helper.assertNoIssues(xtendFile.importSection.importDeclarations.get(0))
	}

	@Test
	def void testForbiddenConstructorCall() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.restricted.RestrictedClass
			class Foo {
				RestrictedClass x = new RestrictedClass
			}
		''')
		helper.assertError(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, FORBIDDEN_REFERENCE)
		val field = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendField
		helper.assertError(field.type, JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
		helper.assertError(field.initialValue, XCONSTRUCTOR_CALL, FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testDiscouragedConstructorCall() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.internal.InternalClass
			class Foo {
				InternalClass x = new InternalClass
			}
		''')
		helper.assertWarning(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, DISCOURAGED_REFERENCE)
		val field = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendField
		helper.assertWarning(field.type, JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE)
		helper.assertWarning(field.initialValue, XCONSTRUCTOR_CALL, DISCOURAGED_REFERENCE)
	}
	

	@Test
	def void testDiscouragedConstructorCallInnernClass() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass
			class Foo {
				InnerInternalClass x = new InnerInternalClass
			}
		''')
		helper.assertWarning(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, DISCOURAGED_REFERENCE)
		val field = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendField
		helper.assertWarning(field.type, JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE)
		helper.assertWarning(field.initialValue, XCONSTRUCTOR_CALL, DISCOURAGED_REFERENCE)
	}
	
	@Test
	def void testForbiddenConstructorCallInnerClass() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass
			class Foo {
				InnerRestrictedClass x = new InnerRestrictedClass
			}
		''')
		helper.assertError(xtendFile.importSection.importDeclarations.get(0), XIMPORT_DECLARATION, FORBIDDEN_REFERENCE)
		val field = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendField
		helper.assertError(field.type, JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
		helper.assertError(field.initialValue, XCONSTRUCTOR_CALL, FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testForbiddenTypeUsageInnernClass() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			class Foo {
				def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass$InnerRestrictedClass x) {}
			}
		''')
		val function = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendFunction
		helper.assertError(function.parameters.get(0), JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
	}

	@Test
	def void testDiscouragedTypeUsageInnernClass() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			class Foo {
				def bar(org.eclipse.xtend.core.tests.internal.InternalClass$InnerInternalClass x){}
			}
		''')

		val function = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendFunction
		helper.assertWarning(function.parameters.get(0), JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE)
	}
	
	@Test
	def void testForbiddenTypeUsage() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			class Foo {
				def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass x) {}
			}
		''')
		val function = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendFunction
		helper.assertError(function.parameters.get(0), JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testForbiddenArrayTypeUsage() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			class Foo {
				def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass[] x) {}
			}
		''')
		val function = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendFunction
		helper.assertError(function.parameters.get(0), JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
	}
	
	@Test
	def void testParameterizedTypeReference() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			class Foo {
				def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass<org.eclipse.xtend.core.tests.internal.InternalClass> x) {}
			}
		''')
		val function = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendFunction
		val parameter = function.parameters.get(0)
		val type = parameter.parameterType as JvmParameterizedTypeReference
		val typeParameter = type.arguments.get(0)
		helper.assertError(type, JVM_PARAMETERIZED_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
		helper.assertWarning(typeParameter, JVM_TYPE_REFERENCE, DISCOURAGED_REFERENCE)
	}
	
	@Test
	@Ignore("Enable on demand")
	def void testPerformance_1() {
		testPerformance
	}
	
	@Test
	@Ignore("Enable on demand")
	def void testPerformance_2() {
		testPerformance
	}

	def void testPerformance() {
		val xtendFile = testHelper.xtendFile("Clazz.xtend",'''
			import org.eclipse.xtend.core.tests.restricted.RestrictedClass
			import org.eclipse.xtend.core.tests.internal.InternalClass
			
			class Foo {
			«FOR i : (0..200)»
				RestrictedClass x«i» = new RestrictedClass
				InternalClass y«i» = new InternalClass
				def bar(InternalClass p1«i», RestrictedClass p2«i»){}
			«ENDFOR»
			}
		''')
		helper.validate(xtendFile)
	}
	
	@Test
	def void testIssueCodeDelegation() {
		val javaProject = JavaModelManager::getJavaModelManager().getJavaModel().getJavaProject(testHelper.project)
		val javaSeverity = javaProject.getOption(JavaCore::COMPILER_PB_FORBIDDEN_REFERENCE, true)
		try {
			if (javaSeverity != "error") {
				fail("Wrong expectation Java compiler option '"+JavaCore::COMPILER_PB_FORBIDDEN_REFERENCE+"' should be 'error' by default")
			}
			var otherSeverity = "warning"
			val xtendFile = testHelper.xtendFile("ValidationClazz.xtend",'''
				class ValidationClazz {
					def bar(org.eclipse.xtend.core.tests.restricted.RestrictedClass x) {}
				}
			''')
			val function = xtendFile.xtendTypes.filter(typeof(XtendClass)).head.members.head as XtendFunction
			helper.assertError(function.parameters.get(0), JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
			// clear the cache, since xtend caches computed issues
			cache.clear(xtendFile.eResource)
			javaProject.setOption(JavaCore::COMPILER_PB_FORBIDDEN_REFERENCE, otherSeverity)
			helper.assertWarning(function.parameters.get(0), JVM_TYPE_REFERENCE, FORBIDDEN_REFERENCE)
		} finally {
			javaProject.setOption(JavaCore::COMPILER_PB_FORBIDDEN_REFERENCE, javaSeverity)
		}
	}
	
	@Test
	def void testConfigurableIssueCode() {
		val xtendPrefStore = xtendPreferencesStore
		try {
			xtendPrefStore.setValue(IssueCodes::UNUSED_PRIVATE_MEMBER, "warning")
			
			testHelper.xtendFile("TestConfigurableIssueCode.xtend",'''
				class TestConfigurableIssueCode {
					private String unusedField = "unusedField"
				}
			''') => [
				val unusedField = xtendTypes.filter(typeof(XtendClass)).head.members.head 
				helper.assertWarning(unusedField, XtendPackage$Literals::XTEND_FIELD, UNUSED_PRIVATE_MEMBER)
			]
			
			xtendPrefStore.setValue(IssueCodes::UNUSED_PRIVATE_MEMBER, "error")
			
			testHelper.xtendFile("TestConfigurableIssueCode.xtend",'''
				class TestConfigurableIssueCode {
					private String unusedField = "unusedField"
				}
			''') => [
				val unusedField = xtendTypes.filter(typeof(XtendClass)).head.members.head 
				helper.assertError(unusedField, XtendPackage$Literals::XTEND_FIELD, UNUSED_PRIVATE_MEMBER)
			]
		} finally {
			xtendPrefStore.setToDefault(IssueCodes::UNUSED_PRIVATE_MEMBER)
		}
	}
	
	@Test
    def testJavaDocRefs_Delegation() throws Exception {
		val javaProject = JavaModelManager::getJavaModelManager().getJavaModel().getJavaProject(testHelper.project)
		val javaSeverity = javaProject.getOption(JavaCore::COMPILER_PB_INVALID_JAVADOC, true)
		try {
			if (javaSeverity != "ignore") {
				fail("Wrong expectation Java compiler option '"+JavaCore::COMPILER_PB_INVALID_JAVADOC+"' should be 'ignore' by default")
			}
			var otherSeverity = "warning"
			val xtendFile = testHelper.xtendFile("ValidationClazz.xtend",'''
				class ValidationClazz {
					/**
					* {@link List}
					*/
					def doStuff(){}
				}
			''')
			val clazz = xtendFile.getXtendTypes.head as XtendClass
			val member = clazz.members.head
			helper.assertNoIssues(member)
			// clear the cache, since xtend caches computed issues
			cache.clear(xtendFile.eResource)
			javaProject.setOption(JavaCore::COMPILER_PB_INVALID_JAVADOC, otherSeverity)
			helper.assertWarning(member, XTEND_FUNCTION, IssueCodes::JAVA_DOC_LINKING_DIAGNOSTIC, "javaDoc","List","cannot be resolved to a type");
		} finally {
			javaProject.setOption(JavaCore::COMPILER_PB_INVALID_JAVADOC, javaSeverity)
		}
    }

	def getXtendPreferencesStore() {
		return prefStoreAccess.getWritablePreferenceStore(testHelper.project) as IPersistentPreferenceStore;
	}
	
	
}