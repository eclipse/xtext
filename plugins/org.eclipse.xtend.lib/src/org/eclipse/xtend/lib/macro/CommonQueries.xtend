package org.eclipse.xtend.lib.macro

import com.google.common.annotations.Beta
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference

/**
 * @since 2.7
 */
@Beta
class CommonQueries {

	def static hasHashCode(ClassDeclaration cls) {
		cls.findDeclaredMethod("hashCode") !== null
	}

	def static hasEquals(ClassDeclaration cls) {
		cls.declaredMethods.exists [
			simpleName == "equals" && parameters.size == 1 && parameters.head.type.simpleName == "java.lang.Object"
		]
	}

	def static hasToString(ClassDeclaration cls) {
		cls.findDeclaredMethod("toString") !== null
	}

	def static hasGetter(FieldDeclaration field) {
		field.declaringType.findDeclaredMethod(field.getterName) !== null
	}

	def static getGetterName(FieldDeclaration field) {
		(if(field.type.booleanType) "is" else "get") + field.simpleName.toFirstUpper
	}

	def static hasSetter(FieldDeclaration field) {
		field.declaringType.findDeclaredMethod(field.setterName, field.type) !== null
	}

	def static getSetterName(FieldDeclaration field) {
		"set" + field.simpleName.toFirstUpper
	}

	def static isBooleanType(TypeReference type) {
		!type.inferred && (type.simpleName == Boolean.name || type.simpleName == Boolean.TYPE.name)
	}

	def static getInstanceFields(ClassDeclaration cls) {
		cls.declaredFields.filter[!static]
	}

	def static getInstanceFields(MutableClassDeclaration cls) {
		cls.declaredFields.filter[!static]
	}

	def static getPersistentFields(ClassDeclaration cls) {
		cls.declaredFields.filter[!static && !transient]
	}

	def static getPersistentFields(MutableClassDeclaration cls) {
		cls.declaredFields.filter[!static && !transient]
	}
}
