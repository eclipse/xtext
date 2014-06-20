package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
@Target(ElementType.TYPE)
@Active(EqualsHashCodeProcessor)
annotation EqualsHashCode {
}

/**
 * @since 2.7
 */
@Beta
class EqualsHashCodeProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		extension val util = new Util(context)
		if (hasEquals) {
			addWarning("equals is already defined, this annotation has no effect")
		} else if (hasHashCode) {
			addWarning("hashCode is already defined, this annotation has no effect")
		} else {
			val hasSuperClass = extendedClass != object
			val includedFields = declaredFields.filter[!static && !transient]
			addEquals(includedFields, hasSuperClass)
			addHashCode(includedFields, hasSuperClass)
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

		def hasHashCode(ClassDeclaration it) {
			findDeclaredMethod("hashCode") !== null
		}

		def hasEquals(ClassDeclaration it) {
			declaredMethods.exists [
				simpleName == "equals" && parameters.size == 1 && parameters.head.type.name == "java.lang.Object"
			]
		}

		def void addEquals(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
			boolean includeSuper) {
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
						«field.contributeToEquals»
					«ENDFOR»
					return true;
				'''
			]
		}

		private def contributeToEquals(FieldDeclaration it) {
			return switch (type.name) {
				case Double.TYPE.name: '''
					if (Double.doubleToLongBits(other.«simpleName») != Double.doubleToLongBits(this.«simpleName»))
					  return false; 
				'''
				case Float.TYPE.name: '''
					if (Float.floatToIntBits(other.«simpleName») != Float.floatToIntBits(this.«simpleName»))
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

		def void addHashCode(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
			boolean includeSuper) {
			cls.addMethod("hashCode") [
				returnType = primitiveInt
				addAnnotation(newAnnotationReference(Override))
				addAnnotation(newAnnotationReference(Pure))
				body = '''
					final int prime = 31;
					int result = «IF includeSuper»super.hashCode()«ELSE»1«ENDIF»;
					«FOR field : includedFields»
						«field.contributeToHashCode»
					«ENDFOR»
					return result;
				'''
			]
		}

		private def contributeToHashCode(FieldDeclaration it) {
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
					"result = prime * result + ((this." + simpleName + "== null) ? 0 : this." + simpleName +
						".hashCode());"
			}
		}
	}
}
