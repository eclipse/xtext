package org.eclipse.xtend.lib.annotations

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.AnnotationTarget
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.declaration.Visibility

import static org.eclipse.xtend.lib.annotations.AccessorType.*

/**
 * @since 2.7
 */
@GwtCompatible
@Target(ElementType.FIELD, ElementType.TYPE)
@Active(AccessorsProcessor)
annotation Accessors {
	AccessorType[] value = #[AccessorType.PUBLIC_GETTER, AccessorType.PUBLIC_SETTER]
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
enum AccessorType {
	PUBLIC_GETTER,
	PROTECTED_GETTER,
	PACKAGE_GETTER,
	PRIVATE_GETTER,
	PUBLIC_SETTER,
	PROTECTED_SETTER,
	PACKAGE_SETTER,
	PRIVATE_SETTER,
	NONE
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class AccessorsProcessor implements TransformationParticipant<MutableMemberDeclaration> {

	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		elements.forEach[transform(context)]
	}

	def dispatch void transform(MutableFieldDeclaration it, extension TransformationContext context) {
		extension val util = new AccessorsProcessor.Util(context)
		if (shouldAddGetter) {
			addGetter(getterType.toVisibility)
		}
		if (shouldAddSetter) {
			addSetter(setterType.toVisibility)
		}
	}

	def dispatch void transform(MutableClassDeclaration it, extension TransformationContext context) {
		if (findAnnotation(Data.findTypeGlobally) !== null) {
			return
		}
		val extension requiredArgsUtil = new FinalFieldsConstructorProcessor.Util(context)
		if (needsFinalFieldConstructor) {
			addFinalFieldsConstructor
		}
		declaredFields.filter[!static && thePrimaryGeneratedJavaElement].forEach[_transform(context)]
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

		def toVisibility(AccessorType type) {
			switch type {
				case PUBLIC_GETTER: Visibility.PUBLIC
				case PROTECTED_GETTER: Visibility.PROTECTED
				case PACKAGE_GETTER: Visibility.DEFAULT
				case PRIVATE_GETTER: Visibility.PRIVATE
				case PUBLIC_SETTER: Visibility.PUBLIC
				case PROTECTED_SETTER: Visibility.PROTECTED
				case PACKAGE_SETTER: Visibility.DEFAULT
				case PRIVATE_SETTER: Visibility.PRIVATE
				default: throw new IllegalArgumentException('''Cannot convert «type»''')
			}
		}

		def hasGetter(FieldDeclaration it) {
			declaringType.findDeclaredMethod(getterName) !== null
		}

		def shouldAddGetter(FieldDeclaration it) {
			!hasGetter && getterType !== AccessorType.NONE
		}

		def getGetterType(FieldDeclaration it) {
			val annotation = accessorsAnnotation ?: declaringType.accessorsAnnotation
			if (annotation !== null) {
				val types = annotation.getEnumArrayValue("value").map[AccessorType.valueOf(simpleName)]
				return types.findFirst[name.endsWith("GETTER")] ?: AccessorType.NONE
			}
			return null;
		}

		def getAccessorsAnnotation(AnnotationTarget it) {
			findAnnotation(Accessors.findTypeGlobally)
		}

		def validateGetter(MutableFieldDeclaration field) {
			if (field.type.inferred) {
				field.addWarning('''
					Support for inferred types on getters may be removed in the future.
					Important validations cannot be done. Also, for boolean types the
					getter may incorrectly be prefixed with "get" instead of "is".
				''')
				return
			}
			val overriddenGetter = field.declaringType.newSelfTypeReference.allResolvedMethods.findFirst [
				declaration.simpleName == field.getterName && resolvedParameters.empty
			]
			if (overriddenGetter !== null) {
				val overriddenDeclaration = overriddenGetter.declaration
				if (overriddenDeclaration.final) {
					field.addError(
						'''Cannot override the final method «overriddenGetter.simpleSignature» in «overriddenDeclaration.
							declaringType.simpleName»''')
				}
				if (!overriddenGetter.resolvedReturnType.isAssignableFrom(field.type)) {
					field.addError(
						'''
							Cannot override the method «overriddenGetter.simpleSignature» in «overriddenDeclaration.declaringType.simpleName», 
							because its return type is incompatible with «field.type.simpleName»
						''')
				}
			}
		}

		def getGetterName(FieldDeclaration it) {
			(if(type.booleanType) "is" else "get") + simpleName.toFirstUpper
		}

		def isBooleanType(TypeReference it) {
			!inferred && (name == Boolean.name || name == Boolean.TYPE.name)
		}

		def void addGetter(MutableFieldDeclaration field, Visibility visibility) {
			field.validateGetter
			field.markAsRead
			field.declaringType.addMethod(field.getterName) [
				primarySourceElement = field.primarySourceElement
				addAnnotation(newAnnotationReference(Pure))
				returnType = field.type
				body = '''return «field.fieldOwner».«field.simpleName»;'''
				static = field.static
				it.visibility = visibility
			]
		}

		def getSetterType(FieldDeclaration it) {
			val annotation = accessorsAnnotation ?: declaringType.accessorsAnnotation
			if (annotation !== null) {
				val types = annotation.getEnumArrayValue("value").map[AccessorType.valueOf(simpleName)]
				return types.findFirst[name.endsWith("SETTER")] ?: AccessorType.NONE
			}
			return null
		}

		private def fieldOwner(MutableFieldDeclaration it) {
			if(static) declaringType.newTypeReference else "this"
		}

		def hasSetter(FieldDeclaration it) {
			declaringType.findDeclaredMethod(setterName, type) !== null
		}

		def getSetterName(FieldDeclaration it) {
			"set" + simpleName.toFirstUpper
		}

		def shouldAddSetter(FieldDeclaration it) {
			!final && !hasSetter && setterType !== AccessorType.NONE
		}

		def validateSetter(MutableFieldDeclaration field) {
			if (field.final) {
				field.addError("Cannot set a final field")
			}
			if (field.type.inferred) {
				field.addError("Type cannot be inferred.")
				return
			}
			val overriddenSetter = field.declaringType.newSelfTypeReference.allResolvedMethods.findFirst [
				declaration.simpleName == field.setterName && resolvedParameters.size == 1 &&
					field.type.isAssignableFrom(resolvedParameters.head.resolvedType)
			]
			if (overriddenSetter !== null) {
				val overriddenDeclaration = overriddenSetter.declaration
				if (overriddenDeclaration.final) {
					field.addError(
						'''Cannot override the final method «overriddenSetter.simpleSignature» in «overriddenDeclaration.
							declaringType.simpleName»''')
				}
				if (!overriddenSetter.resolvedReturnType.isVoid) {
					field.addError(
						'''
							Cannot override the method «overriddenSetter.simpleSignature» in «overriddenDeclaration.declaringType.simpleName», because its return type is not void»
						''')
				}
			}
		}

		def void addSetter(MutableFieldDeclaration field, Visibility visibility) {
			field.validateSetter
			field.declaringType.addMethod(field.setterName) [
				primarySourceElement = field.primarySourceElement
				returnType = primitiveVoid
				val param = addParameter(field.simpleName, if (field.type.inferred) object else field.type)
				body = '''«field.fieldOwner».«field.simpleName» = «param.simpleName»;'''
				static = field.static
				it.visibility = visibility
			]
		}
	}

}
