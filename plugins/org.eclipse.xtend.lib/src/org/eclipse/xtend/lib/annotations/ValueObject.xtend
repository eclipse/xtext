package org.eclipse.xtend.lib.annotations

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@Active(ValueObjectProcessor)
@Target(ElementType.TYPE)
annotation ValueObject {
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class ValueObjectProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration cls, extension TransformationContext context) {
		val extension util = new ValueObjectProcessor.Util(context)
		val extension getterUtil = new GetterProcessor.Util(context)
		val extension ehUtil = new EqualsHashCodeProcessor.Util(context)
		val extension toStringUtil = new ToStringProcessor.Util(context)
		
		cls.final = true
		if (cls.extendedClass != object) {
			cls.addError("Inheritance is forbidden for value objects")
		}

		if (!cls.hasVoConstructor) {
			cls.addVoConstructor
		}
		if (!cls.hasToString) {
			cls.addToString(cls.valueObjectFields)
		}
		if (!cls.hasEquals) {
			cls.addEquals(cls.valueObjectFields, false)
		}
		if (!cls.hasHashCode) {
			cls.addHashCode(cls.valueObjectFields, false)
		}
		cls.valueObjectFields.forEach [
			if (!hasGetter) {
				addGetter
			}
			final = true
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

		def hasVoConstructor(MutableClassDeclaration cls) {
			cls.declaredConstructors.exists [
				parameters.map[type].toList == cls.valueObjectFields.map[type].toList
			]
		}

		def addVoConstructor(MutableClassDeclaration cls) {
			cls.addConstructor [ constructor |
				cls.valueObjectConstructorFields.forEach [
					constructor.addParameter(simpleName, type)
					markAsInitializedBy(constructor)
				]
				constructor.body = '''
					«FOR field : cls.valueObjectConstructorFields»
						this.«field.simpleName» = «field.simpleName»;
					«ENDFOR»
				'''
			]
		}

		def getValueObjectConstructorFields(MutableTypeDeclaration it) {
			valueObjectFields.filter[initializer === null]
		}

		def getValueObjectFields(MutableTypeDeclaration it) {
			declaredFields.filter[!static && !transient && isThePrimaryGeneratedJavaElement]
		}
	}
}
