package org.eclipse.xtend.core.tests.macro.declaration

import com.google.inject.Provider
import javax.inject.Inject
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.CompilationUnit
import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.junit.Test

import static extension org.junit.Assert.*

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
		
		class MyClass<T extends CharSequence> {
			
			String myField
			
			new(String initial) {
				this.myField = initial
			}
			
			def <T2 extends CharSequence> MyClass myMethod(T2 a, T b) {
				myField = myField + a + b
				return this
			}
		}
		''').asCompilationUnit [
			assertEquals('foo', packageName)
			val clazz = sourceTypeDeclarations.head as ClassDeclaration
			val genClazz = generatedTypeDeclarations.head as MutableClassDeclaration
			
			assertEquals('foo.MyClass', clazz.name)
			assertNull(clazz.superclass)
			assertTrue(clazz.implementedInterfaces.empty)
			assertEquals(3, clazz.members.size)
			assertEquals('T', clazz.typeParameters.head.name)
			assertEquals('CharSequence', clazz.typeParameters.head.upperBounds.head.toString)
			assertSame(clazz, clazz.typeParameters.head.typeParameterDeclarator)
			
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
			val genMethod = genClazz.members.get(2) as MutableMethodDeclaration
			
			assertSame(clazz, method.declaringType)
			assertEquals('a', method.parameters.head.name)
			assertEquals('T2', method.parameters.head.type.toString)
			assertSame(genMethod.typeParameters.head, method.parameters.head.type.type)
			assertEquals('T', method.parameters.get(1).type.toString)
			assertSame(genClazz.typeParameters.head, method.parameters.get(1).type.type)
			assertSame(genClazz, method.returnType.type)
			
			assertEquals('T2', method.typeParameters.head.name)
			assertEquals('CharSequence', method.typeParameters.head.upperBounds.head.toString)
			assertSame(method.typeParameters.head, method.typeParameters.head)
			assertSame(method, method.typeParameters.head.typeParameterDeclarator)
			
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