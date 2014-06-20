package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

/**
 * This annotation is used by the Xtend compiler.
 * It turns an annotated class into an immutable value object.
 * 
 * All fields become final and a getter method is added.
 * The fields' name are prepended with an underscore (i.e. <tt>myField</tt> becomes <tt>_myField</tt>)
 * One constructor for initializing the uninitialized fields is added.
 * {@link Object#equals(Object)} and {@link Object#hashCode()} implementations are added.
 * {@link Object#toString()} implementation is added.  
 * 
 * @author Sven Efftinge
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
		extension val getterUtil = new GetterProcessor.Util(context)
		extension val ehUtil = new EqualsHashCodeProcessor.Util(context)
		extension val toStringUtil = new ToStringProcessor.Util(context)

		if (!hasDataConstructor) {
			addDataConstructor
		}
		if (!hasHashCode) {
			addHashCode(dataFields, superConstructor !== null)
		}
		if (!hasEquals) {
			addEquals(dataFields, superConstructor !== null)
		}
		if (!hasToString) {
			addReflectiveToString
		}
		dataFields.forEach [
			if (!hasGetter) {
				addGetter
			}
			final = true
			simpleName = "_" + simpleName.toFirstLower
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

		def hasDataConstructor(ClassDeclaration cls) {
			cls.declaredConstructors.exists [
				val expectedTypes = newArrayList
				if (cls.superConstructor !== null) {
					expectedTypes += cls.superConstructor.parameters.map[type]
				}
				expectedTypes += cls.dataFields.map[type]
				parameters.map[type].toList == expectedTypes
			]
		}

		def addDataConstructor(MutableClassDeclaration cls) {
			cls.addConstructor [ constructor |
				val fieldToParameter = newHashMap
				val superParameters = cls.superConstructor?.parameters ?: #[]
				superParameters.forEach [
					val param = constructor.addParameter(simpleName, type)
					fieldToParameter.put(it, param)
				]
				cls.dataConstructorFields.forEach [
					val param = constructor.addParameter(simpleName, type)
					markAsInitialized
					fieldToParameter.put(it, param)
				]
				constructor.body = '''
					super(«superParameters.join(", ")[simpleName]»);
					«FOR field : cls.dataConstructorFields»
						this.«field.simpleName» = «fieldToParameter.get(field).simpleName»;
					«ENDFOR»
				'''
			]
		}

		def getDataConstructorFields(MutableClassDeclaration it) {
			dataFields.filter[initializer == null]
		}

		def getSuperConstructor(ClassDeclaration it) {
			if (extendedClass == object)
				return null;
			return (extendedClass.type as ClassDeclaration).declaredConstructors.head
		}

		def getDataFields(ClassDeclaration it) {
			declaredFields.filter[!static]
		}

		def getDataFields(MutableClassDeclaration it) {
			declaredFields.filter[!static]
		}
	}

}
