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
class SetterProcessor implements TransformationParticipant<MutableMemberDeclaration> {

	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		elements.forEach[transform(context)]
	}

	protected def dispatch transform(MutableFieldDeclaration it, extension TransformationContext context) {
		extension val util = new Util(context)
		if (hasSetter) {
			addWarning("A setter is already defined, this annotation has no effect")
		} else {
			addSetter
		}
	}

	protected def dispatch transform(MutableClassDeclaration it, extension TransformationContext context) {
		extension val util = new Util(context)
		declaredFields.filter[!static && isThePrimaryGeneratedJavaElement].forEach [
			if (!hasSetter) {
				addSetter
			}
		]
	}

	/**
	* @since 2.7
	*/
	@Beta
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

		def void addSetter(MutableFieldDeclaration field) {
			if (field.final) {
				field.addError("Cannot set a final field")
				return
			}
			if (field.type.inferred) {
				field.addError("Type cannot be inferred.")
				return
			}
			field.declaringType.addMethod(field.setterName) [
				returnType = primitiveVoid
				val param = addParameter(field.simpleName, field.type)
				body = '''this.«field.simpleName» = «param.simpleName»;'''
			]
		}
	}
}
