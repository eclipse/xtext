package org.eclipse.xtend.core.tests.macro

import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
import org.junit.Test

class AccessorsAnnotationTest extends AbstractActiveAnnotationTest {
	
	@Test def void testProperty() {
		'''
			import org.eclipse.xtend.core.tests.macro.Accessors
			
			class A {
				@Accessors String field
				@Accessors val String finalField = 'foo'
			}
		'''.compile [
			val ctx = transformationContext
			val classA = ctx.findClass('A')
			assertEquals(Visibility::PUBLIC, classA.findDeclaredMethod('getField').visibility)
			assertEquals(Visibility::PUBLIC, classA.findDeclaredMethod('setField', ctx.string).visibility)
			assertEquals(Visibility::PUBLIC, classA.findDeclaredMethod('getFinalField').visibility)
			assertNull(classA.findDeclaredMethod('setFinalField', ctx.string))
		]
	}
	
	@Test def void testProperty2() {
		'''
			import org.eclipse.xtend.core.tests.macro.Accessors
			
			class A {
				@Accessors String field
				private def String getField() {
					return null
				} 
			}
		'''.compile [
			val ctx = transformationContext
			val classA = ctx.findClass('A')
			assertEquals(Visibility::PRIVATE, classA.findDeclaredMethod('getField').visibility)
			assertEquals(Visibility::PUBLIC, classA.findDeclaredMethod('setField', ctx.string).visibility)
			assertEquals(2, classA.declaredMethods.size)
		]
	}
}

@Active(typeof(AccessorsProcessor))
annotation Accessors {
}

class AccessorsProcessor implements TransformationParticipant<MutableFieldDeclaration> {

	override doTransform(List<? extends MutableFieldDeclaration> javaFields, extension TransformationContext context) {
		for (f : javaFields) {
			val getterName = 'get' + f.simpleName.toFirstUpper
			val setterName = 'set' + f.simpleName.toFirstUpper

			f.declaringType.tryAddMethod(getterName) [
				returnType = f.type
				body = [
					'''
						return «f.simpleName»;
					''']
			]
			if (!f.final) {
				f.declaringType.tryAddMethod(setterName) [
					returnType = primitiveVoid
					addParameter(f.simpleName, f.type)
					body = [
						'''
							this.«f.simpleName» = «f.simpleName»;
						''']
				]
			}
		}
	}

	def MutableMethodDeclaration tryAddMethod(MutableTypeDeclaration it, String name, (MutableMethodDeclaration)=>void initializer) {
		findDeclaredMethod(name) ?: addMethod(name, initializer)
	}
}
