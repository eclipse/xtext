package org.eclipse.xtend.lib.annotations

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import java.util.List
import java.util.regex.Pattern
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.TransformationParticipant
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeParameterDeclarator
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration

/**
 * @since 2.7
 */
@Target(ElementType.TYPE, ElementType.CONSTRUCTOR)
@GwtCompatible
@Beta
@Active(FinalFieldsConstructorProcessor)
annotation FinalFieldsConstructor {
}

/**
 * @since 2.7
 */
@GwtCompatible
@Beta
class FinalFieldsConstructorProcessor implements TransformationParticipant<MutableTypeParameterDeclarator> {

	override doTransform(List<? extends MutableTypeParameterDeclarator> elements,
		extension TransformationContext context) {
		elements.forEach[transform(context)]
	}

	def dispatch void transform(MutableClassDeclaration it, extension TransformationContext context) {
		if (findAnnotation(Data.findTypeGlobally) !== null) {
			return
		}
		if (findAnnotation(Accessors.findTypeGlobally) !== null) {
			return
		}
		val extension util = new FinalFieldsConstructorProcessor.Util(context)
		addFinalFieldsConstructor
	}

	def dispatch void transform(MutableConstructorDeclaration it, extension TransformationContext context) {
		val extension util = new FinalFieldsConstructorProcessor.Util(context)
		makeFinalFieldsConstructor
	}

	/**
	 * @since 2.7
	 */
	@GwtCompatible
	@Beta
	static class Util {
		extension TransformationContext context

		new(TransformationContext context) {
			this.context = context
		}

		def getFinalFields(MutableTypeDeclaration it) {
			declaredFields.filter[!static && final == true && initializer == null && thePrimaryGeneratedJavaElement]
		}

		def needsFinalFieldConstructor(MutableClassDeclaration it) {
			!hasFinalFieldsConstructor
			&& (primarySourceElement as ClassDeclaration).declaredConstructors.isEmpty
		}

		def hasFinalFieldsConstructor(MutableTypeDeclaration cls) {
			val expectedTypes = newArrayList
			if (cls.superConstructor !== null) {
				expectedTypes += cls.superConstructor.resolvedParameters.map[resolvedType]
			}
			expectedTypes += cls.finalFields.map[type]
			cls.declaredConstructors.exists [
				parameters.map[type].toList == expectedTypes
			]
		}

		def addFinalFieldsConstructor(MutableClassDeclaration it) {
			if (hasFinalFieldsConstructor) {
				addError("A FinalFieldsConstructor is already defined")
				return
			}
			addConstructor [
				primarySourceElement = declaringType.primarySourceElement
				makeFinalFieldsConstructor
			]
		}
		
		static val EMPTY_BODY = Pattern.compile("\\{\\s*\\}")

		def makeFinalFieldsConstructor(MutableConstructorDeclaration it) {
			if (hasFinalFieldsConstructor(declaringType)) {
				addError("A FinalFieldsConstructor is already defined")
				return
			}
			if (!parameters.empty) {
				addError("Parameter list must be empty")
			}
			if (body !== null && !EMPTY_BODY.matcher(body.toString).matches) {
				addError("Body must be empty")
			}
			val superParameters = declaringType.superConstructor?.resolvedParameters ?: #[]
			superParameters.forEach [ p |
				addParameter(p.declaration.simpleName, p.resolvedType)
			]
			val fieldToParameter = newHashMap
			declaringType.finalFields.forEach [ p |
				p.markAsInitializedBy(it)
				val param = addParameter(p.simpleName, p.type)
				fieldToParameter.put(p, param)
			]
			body = '''
				super(«superParameters.join(", ")[declaration.simpleName]»);
				«FOR arg : declaringType.finalFields»
					this.«arg.simpleName» = «fieldToParameter.get(arg).simpleName»;
				«ENDFOR»
			'''
		}

		def getSuperConstructor(TypeDeclaration it) {
			if (it instanceof ClassDeclaration) {
				if (extendedClass == object)
					return null;
				return extendedClass.declaredResolvedConstructors.head
			} else {
				return null
			}
		}
	}
}
