package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtext.xbase.lib.util.ToStringHelper

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
	extension PropertyProcessor = new PropertyProcessor

	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		if (!hasDataConstructor) {
			addDataConstructor(context)
		}
		if (!hasHashCode) {
			addHashCode(instanceFields, superConstructor !== null, context)
		}
		if (!hasEquals) {
			addEquals(instanceFields, superConstructor !== null, context)
		}
		if (!hasToString) {
			addReflectiveToString(context)
		}
		instanceFields.forEach [
			if (!hasGetter) {
				addGetter(context)
			}
			final = true
			simpleName = "_" + simpleName.toFirstLower
		]
	}

	def hasDataConstructor(ClassDeclaration cls) {
		cls.declaredConstructors.exists [
			val expectedTypes = newArrayList
			if (cls.superConstructor !== null) {
				expectedTypes += cls.superConstructor.parameters.map[type]
			}
			expectedTypes += cls.instanceFields.map[type]
			parameters.map[type].toList == expectedTypes
		]
	}

	def addDataConstructor(MutableClassDeclaration cls, TransformationContext ctx) {
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

	def constructedFields(MutableClassDeclaration it) {
		instanceFields.filter[initializer == null]
	}

	def getSuperConstructor(ClassDeclaration it) {
		if (extendedClass == null || extendedClass.name == Object.name)
			return null;
		return (extendedClass.type as ClassDeclaration).declaredConstructors.head
	}

	def hasHashCode(ClassDeclaration it) {
		findDeclaredMethod("hashCode") !== null
	}

	def hasEquals(ClassDeclaration it) {
		declaredMethods.exists [
			simpleName == "equals" && parameters.size == 1 && parameters.head.type.name == "java.lang.Object"
		]
	}

	def hasToString(ClassDeclaration it) {
		findDeclaredMethod("toString") !== null
	}

	def getInstanceFields(ClassDeclaration it) {
		declaredFields.filter[!static]
	}

	def getInstanceFields(MutableClassDeclaration it) {
		declaredFields.filter[!static]
	}

	def void addHashCode(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
		boolean includeSuper, extension TransformationContext context) {
		cls.addMethod("hashCode") [
			returnType = primitiveInt
			addAnnotation(newAnnotationReference(Override))
			addAnnotation(newAnnotationReference(Pure))
			body = '''
				final int prime = 31;
				int result = «IF includeSuper»super.hashCode()«ELSE»1«ENDIF»;
				«FOR field : includedFields»
					«field.contributeToHashCode(context)»
				«ENDFOR»
				return result;
			'''
		]
	}

	private def contributeToHashCode(FieldDeclaration it, extension TransformationContext context) {
		return switch (type.name) {
			case Double.TYPE.name:
				"result = prime * result + (int) (Double.doubleToLongBits(this." + simpleName +
					") ^ (Double.doubleToLongBits(this." + simpleName + ") >>> 32));"
			case Float.TYPE.name:
				"result = prime * result + Float.floatToIntBits(this." + simpleName + ");"
			case Boolean.TYPE.name:
				"result = prime * result + (this." + simpleName + " ? 1231 : 1237);"
			case Integer.TYPE.name,
			case Character.TYPE.name,
			case Byte.TYPE.name,
			case Short.TYPE.name:
				"result = prime * result + this." + simpleName + ";"
			case Long.TYPE.name:
				"result = prime * result + (int) (this." + simpleName + " ^ (this." + simpleName + " >>> 32));"
			default:
				"result = prime * result + ((this." + simpleName + "== null) ? 0 : this." + simpleName + ".hashCode());"
		}
	}

	def void addEquals(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
		boolean includeSuper, extension TransformationContext context) {
		cls.addMethod("equals") [
			returnType = primitiveBoolean
			addAnnotation(newAnnotationReference(Override))
			addAnnotation(newAnnotationReference(Pure))
			addParameter("obj", object)
			body = '''
				if (this == obj)
				  return true;
				if (obj == null)
				  return false;
				if (getClass() != obj.getClass())
				  return false;
				«IF includeSuper»
					if (!super.equals(obj))
					  return false;
				«ENDIF»
				«cls.simpleName» other = («cls.simpleName») obj;
				«FOR field : includedFields»
					«field.contributeToEquals(context)»
				«ENDFOR»
				return true;
			'''
		]
	}

	private def contributeToEquals(FieldDeclaration it, extension TransformationContext context) {
		return switch (type.name) {
			case Double.TYPE.name: '''
				if (Double.doubleToLongBits(other.«simpleName») != Double.doubleToLongBits(this.«simpleName»))
				  return false; 
			'''
			case Float.TYPE.name: '''
				if (Float.floatToLongBits(other.«simpleName») != Float.floatToLongBits(this.«simpleName»))
				  return false; 
			'''
			case Boolean.TYPE.name,
			case Integer.TYPE.name,
			case Character.TYPE.name,
			case Byte.TYPE.name,
			case Short.TYPE.name,
			case Long.TYPE.name: '''
				if (other.«simpleName» != this.«simpleName»)
				  return false;
			'''
			default: '''
				if (this.«simpleName» == null) {
				  if (other.«simpleName» != null)
				    return false;
				} else if (!this.«simpleName».equals(other.«simpleName»))
				  return false;
			'''
		}
	}

	def void addReflectiveToString(MutableClassDeclaration cls, extension TransformationContext context) {
		cls.addMethod("toString") [
			returnType = string
			addAnnotation(newAnnotationReference(Override))
			addAnnotation(newAnnotationReference(Pure))
			body = '''
				String result = new «ToStringHelper»().toString(this);
				return result;
			'''
		]
	}
}
