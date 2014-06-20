package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractFieldProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference

/**
 * Creates a getter and setter method for the annotated field.
 * Prepends the field name with an underscore (e.g. <code>_myField</code>)
 * 
 * @author Sven Efftinge
 */
@GwtCompatible
@Target(ElementType.FIELD)
@Active(PropertyProcessor)
annotation Property {
}

/**
 * @since 2.7
 */
@Beta
class PropertyProcessor extends AbstractFieldProcessor {

	override doTransform(MutableFieldDeclaration it, extension TransformationContext context) {
		if (!hasGetter) {
			addGetter(context)
		}
		if (!final && !hasSetter) {
			addSetter(context)
		}
		simpleName = "_" + simpleName.toFirstLower
	}

	def hasGetter(FieldDeclaration it) {
		declaringType.findDeclaredMethod(getterName) !== null
	}

	def getGetterName(FieldDeclaration it) {
		(if(type.booleanType) "is" else "get") + simpleName.toFirstUpper
	}

	def void addGetter(MutableFieldDeclaration field, extension TransformationContext context) {
		field.markAsRead
		field.declaringType.addMethod(field.getterName) [
			addAnnotation(newAnnotationReference(Pure))
			returnType = field.type
			body = '''return this.«field.simpleName»;'''
		]
	}

	def hasSetter(FieldDeclaration it) {
		declaringType.findDeclaredMethod(setterName, type) !== null
	}

	def getSetterName(FieldDeclaration it) {
		"set" + simpleName.toFirstUpper
	}

	def void addSetter(MutableFieldDeclaration field, extension TransformationContext context) {
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

	def isBooleanType(TypeReference it) {
		!inferred && (name == Boolean.name || name == Boolean.TYPE.name)
	}
}
