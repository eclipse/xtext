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
import org.eclipse.xtend.lib.macro.declaration.TypeReference

/**
 * If the target is a field, creates a getter for that field. If the target is a class, adds getters to all persistent fields.
 * @since 2.7 
 */
@Beta
@GwtCompatible
@Target(ElementType.FIELD, ElementType.TYPE)
@Active(GetterProcessor)
annotation Getter {
}

/**
 * @since 2.7
 */
@Beta
class GetterProcessor implements TransformationParticipant<MutableMemberDeclaration> {

	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		elements.forEach[transform(context)]
	}

	protected def dispatch transform(MutableFieldDeclaration it, extension TransformationContext context) {
		extension val util = new Util(context)
		if (hasGetter) {
			addWarning("A getter is already defined, this annotation has no effect")
		} else {
			addGetter
		}
	}

	protected def dispatch transform(MutableClassDeclaration it, extension TransformationContext context) {
		extension val util = new Util(context)
		declaredFields.filter[!static].forEach [
			if (!hasGetter) {
				addGetter
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

		def hasGetter(FieldDeclaration it) {
			declaringType.findDeclaredMethod(getterName) !== null
		}

		def getGetterName(FieldDeclaration it) {
			(if(type.booleanType) "is" else "get") + simpleName.toFirstUpper
		}

		def void addGetter(MutableFieldDeclaration field) {
			field.markAsRead
			field.declaringType.addMethod(field.getterName) [
				addAnnotation(newAnnotationReference(Pure))
				returnType = field.type
				body = '''return this.«field.simpleName»;'''
			]
		}

		def isBooleanType(TypeReference it) {
			!inferred && (name == Boolean.name || name == Boolean.TYPE.name)
		}
	}

}
