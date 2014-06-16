package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.CommonTransformations
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

import static extension org.eclipse.xtend.lib.macro.CommonQueries.*

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
		extension val transformations = new CommonTransformations(context)
		if (!hasDataConstructor) {
			addDataConstructor(context)
		}
		if (!hasHashCode) {
			addHashCode(instanceFields, superConstructor !== null)
		}
		if (!hasEquals) {
			addEquals(instanceFields, superConstructor !== null)
		}
		if (!hasToString) {
			addReflectiveToString
		}
		instanceFields.forEach [
			if (!hasGetter) {
				addGetter
			}
			final = true
			simpleName = "_" + simpleName.toFirstLower
		]
	}

	protected def hasDataConstructor(ClassDeclaration cls) {
		cls.declaredConstructors.exists [
			val expectedTypes = newArrayList
			if (cls.superConstructor !== null) {
				expectedTypes += cls.superConstructor.parameters.map[type]
			}
			expectedTypes += cls.instanceFields.map[type]
			parameters.map[type].toList == expectedTypes
		]
	}

	protected def addDataConstructor(MutableClassDeclaration cls, TransformationContext ctx) {
		cls.addConstructor [ constructor |
			val fieldToParameter = newHashMap
			val superParameters = cls.superConstructor?.parameters ?: #[]
			superParameters.forEach [
				val param = constructor.addParameter(simpleName, type)
				fieldToParameter.put(it, param)
			]
			cls.constructedFields.forEach [
				val param = constructor.addParameter(simpleName, type)
				markAsInitialized
				fieldToParameter.put(it, param)
			]
			constructor.body = '''
				super(«superParameters.join(", ")[simpleName]»);
				«FOR field : cls.constructedFields»
					this.«field.simpleName» = «fieldToParameter.get(field).simpleName»;
				«ENDFOR»
			'''
		]
	}

	protected def constructedFields(MutableClassDeclaration it) {
		instanceFields.filter[initializer == null]
	}

	protected def getSuperConstructor(ClassDeclaration it) {
		if (extendedClass == null || extendedClass.name == Object.name)
			return null;
		return (extendedClass.type as ClassDeclaration).declaredConstructors.head
	}
}
