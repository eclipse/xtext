package org.eclipse.xtend.lib.annotations

import com.google.common.annotations.Beta
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility

/**
 * @since 2.7
 */
@Target(ElementType.TYPE)
@Active(DataProcessor)
annotation Data {
}

/**
 * @since 2.7
 */
@Beta
class DataProcessor extends AbstractClassProcessor {
	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		extension val util = new DataProcessor.Util(context)
		extension val getterUtil = new AccessorsProcessor.Util(context)
		extension val ehUtil = new EqualsHashCodeProcessor.Util(context)
		extension val toStringUtil = new ToStringProcessor.Util(context)
		extension val requiredArgsUtil = new FinalFieldsConstructorProcessor.Util(context)

		dataFields.forEach [
			final = true
		]
		if (!hasUserDefinedConstructor && !hasFinalFieldsConstructor) {
			addFinalFieldsConstructor
		}
		if (!hasHashCode) {
			addHashCode(dataFields, superConstructor !== null)
		}
		if (!hasEquals) {
			addEquals(dataFields, superConstructor !== null)
		}
		if (!hasToString) {
			if (superConstructor === null) {
				addToString(dataFields, toStringConfig ?: new ToStringConfiguration)
			} else {
				addReflectiveToString(toStringConfig ?: new ToStringConfiguration)
			}
		}
		dataFields.forEach [
			if (shouldAddGetter && canAddGetter) {
				addGetter(getterType?.toVisibility ?: Visibility.PUBLIC)
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

		def getDataFields(MutableClassDeclaration it) {
			declaredFields.filter[!static && ! transient && isThePrimaryGeneratedJavaElement]
		}
	}

}
