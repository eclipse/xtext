package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration

/**
 * If the target is a field, creates a setter for that field. If the target is a class, adds setters to all persistent fields.
 * @since 2.7
 */
@Beta
@GwtCompatible
@Active(SetterProcessor)
@Target(ElementType.FIELD, ElementType.TYPE)
annotation Setter {
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class SetterProcessor implements TransformationParticipant<MutableMemberDeclaration> {

	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		elements.forEach[transform(context)]
	}

	protected def dispatch transform(MutableFieldDeclaration it, extension TransformationContext context) {
		extension val util = new Util(context)
		if (hasSetter) {
			val annotation = findAnnotation(Setter.findTypeGlobally)
			annotation.addWarning("A setter is already defined, this annotation has no effect")
		} else if (canAddSetter) {
			addSetter
		}
	}

	protected def dispatch transform(MutableClassDeclaration it, extension TransformationContext context) {
		extension val util = new Util(context)
		declaredFields.filter[!static && isThePrimaryGeneratedJavaElement].forEach [
			if (!hasSetter && canAddSetter) {
				addSetter
			}
		]
	}

	/**
	* @since 2.7
	*/
	@Beta
	@GwtCompatible
	static class Util {
		extension TransformationContext context

		new(TransformationContext context) {
			this.context = context
		}

		def hasSetter(FieldDeclaration it) {
			declaringType.findDeclaredMethod(setterName, type) !== null
		}

		def getSetterName(FieldDeclaration it) {
			"set" + simpleName.toFirstUpper
		}
		
		def canAddSetter(MutableFieldDeclaration field) {
			if (field.final) {
				field.addError("Cannot set a final field")
				return false
			}
			if (field.type.inferred) {
				field.addError("Type cannot be inferred.")
				return false
			}
			
			val overriddenSetter = field.declaringType.newSelfTypeReference.allResolvedMethods.findFirst[
				declaration.simpleName == field.setterName
				&& resolvedParameters.size == 1
				&& field.type.isAssignableFrom(resolvedParameters.head.resolvedType)
			]
			if (overriddenSetter == null)
				return true
			val overriddenDeclaration = overriddenSetter.declaration
			if (overriddenDeclaration.final) {
				field.addError('''Cannot override the final method «overriddenSetter.simpleSignature» in «overriddenDeclaration.declaringType.simpleName»''')
				return false
			}
			if (!overriddenSetter.resolvedReturnType.isVoid) {
				field.addError('''
					Cannot override the method «overriddenSetter.simpleSignature» in «overriddenDeclaration.declaringType.simpleName», because its return type is not void»
				''')
				return false
			}
			return true
		}

		def void addSetter(MutableFieldDeclaration field) {
			field.declaringType.addMethod(field.setterName) [
				returnType = primitiveVoid
				val param = addParameter(field.simpleName, field.type)
				body = '''«field.fieldOwner».«field.simpleName» = «param.simpleName»;'''
				static = field.static
			]
		}
		
		private def fieldOwner(MutableFieldDeclaration it) {
			if (static) declaringType.newTypeReference else "this"
		}
	}
}
