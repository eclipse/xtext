package org.eclipse.xtend.core.tests.macro

import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration
import org.junit.Ignore
import org.junit.Test

class ImmutableAnnotationTest extends AbstractActiveAnnotationTest {
	
	@Ignore("We need to suppress the initialization check.") @Test def void defSimpleTest() {
		'''
			import org.eclipse.xtend.core.tests.macro.Immutable
			
			@Immutable class MyClass {
				String foo
			}
		'''.compile [
			val clazz = compiledClass
			val constr = clazz.declaredConstructors
			assertEquals(1, constr.length)
			assertEquals(1, constr.head.getParameterTypes.length)
		]
	}
}

@Active(typeof(ImmutableProcessor))
annotation Immutable {
}

class ImmutableProcessor implements TransformationParticipant<MutableClassDeclaration> {
	
	override doTransform(List<? extends MutableClassDeclaration> annotatedTargetElements, extension TransformationContext context) {
		for (clazz : annotatedTargetElements) {
			val fields = clazz.declaredFields
			clazz.addConstructor[
				for (f : fields) {
					addParameter(f.simpleName, f.type)
				}
				body = ['''
					«FOR f : fields»
						this.«f.simpleName» = «f.simpleName»;
					«ENDFOR»
				''']
			]
			for (f : fields) {
				// make everything final
				f.final = true
				
				val getterName = 'get'+f.simpleName.toFirstUpper
				
				clazz.tryAddMethod(getterName) [
					returnType = f.type
					body = ['''
						return «f.simpleName»;
					''']
				]
			}
			
			clazz.tryAddMethod('hashCode') [
				returnType = primitiveInt
				addAnnotation(Override.newAnnotationReference)
				body = ['''
					final int prime = 31;
					«IF clazz.extendsSomethingWithProperHashCode»
						int result = super.hashCode();
					«ELSE»
						int result = 1;
					«ENDIF»
					«FOR f : fields»
						«IF f.type == primitiveBoolean»
							result = prime * result + («f.simpleName» ? 1231 : 1237);
						«ELSEIF #{primitiveInt, primitiveChar, primitiveByte, primitiveShort}.contains(f.type)»
							result = prime * result + «f.simpleName»;
						«ELSEIF primitiveLong == f.type»
							result = prime * result + (int) («f.simpleName» ^ («f.simpleName» >>> 32));
						«ELSEIF primitiveFloat == f.type»
							result = prime * result + Float.floatToIntBits(«f.simpleName»);
						«ELSEIF primitiveDouble == f.type»
							result = prime * result + (int) (Double.doubleToLongBits(«f.simpleName») ^ (Double.doubleToLongBits(«f.simpleName») >>> 32));
						«ELSE»
							result = prime * result + ((«f.simpleName»== null) ? 0 : «f.simpleName».hashCode());
						«ENDIF»
					«ENDFOR»
					return result;
				''']
			]
		}
	}
	
	def boolean getExtendsSomethingWithProperHashCode(MutableClassDeclaration declaration) {
		return false
	}
	
	def MutableMethodDeclaration tryAddMethod(MutableClassDeclaration it, String name, (MutableMethodDeclaration)=>void initializer) {
		findDeclaredMethod(name) ?: addMethod(name, initializer)
	}
}