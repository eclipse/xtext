package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.util.List
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.Declaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableMemberDeclaration
import com.google.common.annotations.GwtCompatible

/**
 * @since 2.7
 */
@Target(ElementType.TYPE, ElementType.FIELD)
@Active(WitherProcessor)
@Beta
@GwtCompatible
annotation Wither {
}

/**
 * @since 2.7
 */
@Beta
class WitherProcessor implements TransformationParticipant<MutableMemberDeclaration> {

	override doTransform(List<? extends MutableMemberDeclaration> elements, extension TransformationContext context) {
		elements.forEach[transform(context)]
	}

	protected def dispatch void transform(MutableClassDeclaration cls, extension TransformationContext context) {
		val extension util = new WitherProcessor.Util(context)
		val extension voUtil = new ValueObjectProcessor.Util(context)
		cls.valueObjectConstructorFields.forEach [
			if (!hasWither) {
				addWither(cls.valueObjectConstructorFields)
			}
		]
	}

	protected def dispatch void transform(MutableFieldDeclaration it, extension TransformationContext context) {
		val extension util = new WitherProcessor.Util(context)
		val extension voUtil = new ValueObjectProcessor.Util(context)
		if (hasWither) {
			addWarning("A wither is already defined, this annotation has no effect")
		} else {
			addWither(declaringType.valueObjectConstructorFields)
		}
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

		def hasWither(FieldDeclaration it) {
			declaringType.findDeclaredMethod(witherName, type) !== null
		}

		def getWitherName(FieldDeclaration it) {
			"with" + simpleName.toFirstUpper
		}

		def void addWither(MutableFieldDeclaration field, Iterable<? extends FieldDeclaration> constructorFields) {
			if (field.type.inferred) {
				field.addError("Type cannot be inferred.")
				return
			}
			val cls = field.declaringType as MutableClassDeclaration
			cls.addMethod(field.witherName) [
				addAnnotation(newAnnotationReference(Pure))
				returnType = cls.newTypeReference
				val param = addParameter(field.simpleName, field.type)
				val constructorArguments = <Declaration>newArrayList
				for (otherField : constructorFields) {
					if (field == otherField) {
						constructorArguments += param
					} else {
						constructorArguments += otherField
					}
				}
				body = '''
					return new «cls»(«constructorArguments.join(", ")[simpleName]»);
				'''
			]
		}
	}
}
