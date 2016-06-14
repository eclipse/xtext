package org.eclipse.xtend.core.tests.macro.declaration

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.xtend.core.macro.ActiveAnnotationContexts
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.junit.Test

class ProblemSupportTests extends AbstractXtendTestCase {
	
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	
	@Test def void testErrorOnSource() {
		validFile('''
			class MyClass {
				String foo = 'foo'
			}
		''').asCompilationUnit [
			problemSupport.addError(sourceTypeDeclarations.head, 'error on source')
			
			assertEquals('error on source', xtendFile.eResource.errors.head.message)
			assertEquals(xtendFile.xtendTypes.head, (xtendFile.eResource.errors.head as EObjectDiagnosticImpl).problematicObject)
		]
	}
	
	@Test def void testErrorOnDerivedElement() {
		validFile('''
			class MyClass {
				String foo = 'foo'
			}
		''').asCompilationUnit [
			val derived = typeLookup.findClass('MyClass')
			problemSupport.addError(derived, 'error on derived element')
			
			assertEquals('error on derived element', xtendFile.eResource.errors.head.message)
			assertEquals(xtendFile.xtendTypes.head, (xtendFile.eResource.errors.head as EObjectDiagnosticImpl).problematicObject)
		]
	}
	
	def validFile(CharSequence code) {
		file(code.toString, true)
	}
	
	def asCompilationUnit(XtendFile file, (CompilationUnitImpl)=>void block) {
		val compilationUnit = compilationUnitProvider.get
		compilationUnit.xtendFile = file
		compilationUnit.before(ActiveAnnotationContexts.AnnotationCallback.INFERENCE)
		block.apply(compilationUnit)
	}
}