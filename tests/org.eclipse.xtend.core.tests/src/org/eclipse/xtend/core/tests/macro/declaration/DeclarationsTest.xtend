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
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration

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
			assertEquals('Serializable', clazz.implementedInterfaces.head.toString)
			val field = clazz.members.head as FieldDeclaration
			assertEquals('foo', field.name)
			assertSame(generatedTypeDeclarations.head, field.type.type)
		]
	}
	
	@Test def testXtendClassWithMethodFieldAndConstructor() {
		validFile('''
		package foo
		
		class MyClass {
			
			String myField
			
			new(String initial) {
				this.myField = initial
			}
			
			def MyClass myMethod(String a) {
				myField = myField + a
				return this
			}
		}
		''').asCompilationUnit [
			assertEquals('foo', packageName)
			val clazz = sourceTypeDeclarations.head as ClassDeclaration
			
			assertEquals('foo.MyClass', clazz.name)
			assertNull(clazz.superclass)
			assertTrue(clazz.implementedInterfaces.empty)
			assertEquals(3, clazz.members.size)
			
			val field = clazz.members.head as FieldDeclaration
			assertSame(clazz, field.declaringType)
			assertEquals('myField', field.name)
			assertEquals("String", field.type.toString)
			assertFalse(field.isFinal)
			
			val constructor = clazz.members.get(1) as ConstructorDeclaration
			assertSame(clazz, constructor.declaringType)
			assertEquals('MyClass', constructor.name)
			assertEquals('initial', constructor.parameters.head.name)
			assertEquals('String', constructor.parameters.head.type.toString)
			
			val method = clazz.members.get(2) as MethodDeclaration
			assertSame(clazz, method.declaringType)
			assertEquals('a', method.parameters.head.name)
			assertEquals('String', method.parameters.head.type.toString)
			assertSame(generatedTypeDeclarations.head, method.returnType.type)
			
			assertSame(field, clazz.members.get(0))
			assertSame(constructor, clazz.members.get(1))
			assertSame(method, clazz.members.get(2))
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