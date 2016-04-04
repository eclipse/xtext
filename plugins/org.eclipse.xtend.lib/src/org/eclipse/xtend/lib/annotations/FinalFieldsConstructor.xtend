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
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import java.lang.annotation.Documented

/**
 * <p>Creates a constructor that takes a parameter for each final field of a class.</p>
 * 
 * Annotated on a class 
 * <p>
 * Creates a constructor that takes all
 * non-static, final fields of the class as an argument and assigns them to
 * their corresponding fields. The order of arguments is the same as the order
 * of the fields.
 * </p>
 * Annotated on a constructor
 * <p>
 * Turns that constructor into a final
 * fields constructor as described above. This is useful for adding annotations
 * to the constructor, e.g. for dependency injection frameworks.
 * </p>
 * 
 * @since 2.7
 */
@Target(ElementType.TYPE, ElementType.CONSTRUCTOR)
@GwtCompatible
@Beta
@Active(FinalFieldsConstructorProcessor)
@Documented
annotation FinalFieldsConstructor {
}

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Beta
class FinalFieldsConstructorProcessor implements TransformationParticipant<MutableTypeParameterDeclarator> {

	override doTransform(List<? extends MutableTypeParameterDeclarator> elements,
		extension TransformationContext context) {
		for (it : elements)
			transform(context)
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
	 * @noextend
	 * @noreference
	 */
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
			val expectedTypes = cls.finalFieldsConstructorArgumentTypes
			cls.declaredConstructors.exists [
				parameters.map[type].toList == expectedTypes
			]
		}
		
		def getFinalFieldsConstructorArgumentTypes(MutableTypeDeclaration cls) {
			val types = newArrayList
			if (cls.superConstructor !== null) {
				types += cls.superConstructor.resolvedParameters.map[resolvedType]
			}
			types += cls.finalFields.map[type]
			types
		}
		
		def String getConstructorAlreadyExistsMessage(MutableTypeDeclaration it) {
			'''Cannot create FinalFieldsConstructor as a constructor with the signature "new(«finalFieldsConstructorArgumentTypes.join(",")»)" already exists.'''
		}

		def addFinalFieldsConstructor(MutableClassDeclaration it) {
			if (finalFieldsConstructorArgumentTypes.empty) {
				val anno = findAnnotation(FinalFieldsConstructor.findTypeGlobally)
				anno.addWarning('''There are no final fields, this annotation has no effect''')
				return
			}
			if (hasFinalFieldsConstructor) {
				addError(constructorAlreadyExistsMessage)
				return
			}
			addConstructor [
				primarySourceElement = declaringType.primarySourceElement
				makeFinalFieldsConstructor
			]
		}
		
		static val EMPTY_BODY = Pattern.compile("(\\{(\\s*\\})?)?")

		def makeFinalFieldsConstructor(MutableConstructorDeclaration it) {
			if (declaringType.finalFieldsConstructorArgumentTypes.empty) {
				val anno = findAnnotation(FinalFieldsConstructor.findTypeGlobally)
				anno.addWarning('''There are no final fields, this annotation has no effect''')
				return
			}
			if (declaringType.hasFinalFieldsConstructor) {
				addError(declaringType.constructorAlreadyExistsMessage)
				return
			}
			if (!parameters.empty) {
				addError("Parameter list must be empty")
			}
			if (body !== null && !EMPTY_BODY.matcher(body.toString).matches) {
				addError("Body must be empty")
			}
			val superParameters = declaringType.superConstructor?.resolvedParameters ?: #[]
			for (p : superParameters) {
				addParameter(p.declaration.simpleName, p.resolvedType)
			}
			val fieldToParameter = newHashMap
			for (p : declaringType.finalFields) {
				p.markAsInitializedBy(it)
				val param = addParameter(p.simpleName, p.type.orObject)
				fieldToParameter.put(p, param)
			}
			body = '''
				super(«superParameters.join(", ")[declaration.simpleName]»);
				«FOR arg : declaringType.finalFields»
					this.«arg.simpleName» = «fieldToParameter.get(arg).simpleName»;
				«ENDFOR»
			'''
		}

		def getSuperConstructor(TypeDeclaration it) {
			if (it instanceof ClassDeclaration) {
				if (extendedClass == object || extendedClass == null)
					return null;
				return extendedClass.declaredResolvedConstructors.head
			} else {
				return null
			}
		}
		
		private def orObject(TypeReference ref) {
			if (ref === null) object else ref
		}
	}
}
