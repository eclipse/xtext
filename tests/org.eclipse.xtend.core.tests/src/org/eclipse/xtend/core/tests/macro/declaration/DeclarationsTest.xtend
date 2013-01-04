package org.eclipse.xtend.core.tests.macro.declaration

import com.google.inject.Provider
import javax.inject.Inject
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.junit.Test
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration

class DeclarationsTest extends AbstractXtendTestCase {
	
	@Inject Provider<CompilationUnitImpl> compilationUnitProvider
	
	@Test def testSimpleClassWithField() {
		validFile('''
		package foo
		
		class MyClass extends Object implements java.io.Serializable {
			MyClass foo
		}
		''').asCompilationUnit [
			assertEquals('foo', packageName)
			val clazz = sourceTypeDeclarations.head as ClassDeclaration
			assertEquals('foo.MyClass', clazz.name)
			assertEquals('Object', clazz.superclass.toString)
			assertEquals('java.io.Serializable', clazz.implementedInterfaces.head.toString)
			val field = clazz.members.head as FieldDeclaration
			assertEquals('foo', field.name)
			assertSame(generatedTypeDeclarations.head, field.type.type)
		]
	}
	
	def validFile(CharSequence code) {
		file(code.toString, true)
	}
	
	def asCompilationUnit(XtendFile file, (CompilationUnit)=>void block) {
		val compilationUnit = compilationUnitProvider.get
		compilationUnit.xtendFile = file
		block.apply(compilationUnit)
	}
}