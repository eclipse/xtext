package org.eclipse.xtend.lib.annotations

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
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend2.lib.StringConcatenationClient
import java.util.Arrays

/**
 * Creates default implementations for {@link Object#equals(Object) equals} and {@link Object#hashCode hashCode}.
 * 
 * All non-static, non-transient fields are used. Subclasses are never equal to their superclasses. 
 * If there is a superclass that overrides equals, then <code>super.equals()</code> and <code>super.hashCode</code> are also called.
 * Array-valued fields are compared using #{@link Arrays#deepEquals}.
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
 * @noreference
 * @noextend
 */
@Beta
class EqualsHashCodeProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		if (findAnnotation(Data.findTypeGlobally) !== null) {
			return
		}
		extension val util = new Util(context)
		if (hasEquals) {
			val annotation = findAnnotation(EqualsHashCode.findTypeGlobally)
			annotation.addWarning("equals is already defined, this annotation has no effect")
		} else if (hasHashCode) {
			addWarning("hashCode is already defined, this annotation has no effect")
		} else {
			val fields = declaredFields.filter[!static && !transient && thePrimaryGeneratedJavaElement]
			addEquals(fields, hasSuperEquals)
			addHashCode(fields, hasSuperHashCode)
		}
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

		def hasHashCode(ClassDeclaration it) {
			findDeclaredMethod("hashCode") !== null
		}

		def hasEquals(ClassDeclaration it) {
			declaredMethods.exists [
				simpleName == "equals" && parameters.size == 1 && parameters.head.type == object
			]
		}

		def boolean hasSuperEquals(ClassDeclaration cls) {
			val superClass = (cls.extendedClass.type as ClassDeclaration)
			if (superClass.newTypeReference.equals(object)) {
				false
			} else if (superClass.hasEquals) {
				true
			} else {
				superClass.hasSuperEquals
			}
		}
		def boolean hasSuperHashCode(ClassDeclaration cls) {
			val superClass = (cls.extendedClass.type as ClassDeclaration)
			if (superClass.newTypeReference.equals(object)) {
				false
			} else if (superClass.hasHashCode) {
				true
			} else {
				superClass.hasSuperHashCode
			}
		}

		def void addEquals(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
			boolean includeSuper) {
			cls.addMethod("equals") [
				primarySourceElement = cls.primarySourceElement
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
					«cls.newWildCardSelfTypeReference» other = («cls.newWildCardSelfTypeReference») obj;
					«FOR field : includedFields»
						«field.contributeToEquals»
					«ENDFOR»
					return true;
				'''
			]
		}

		private def newWildCardSelfTypeReference(ClassDeclaration cls) {
			cls.newTypeReference(cls.typeParameters.map[object.newWildcardTypeReference])
		}

		def StringConcatenationClient contributeToEquals(FieldDeclaration it) {
			switch (type.orObject.name) {
				case Double.TYPE.name: '''
					if («Double».doubleToLongBits(other.«simpleName») != «Double».doubleToLongBits(this.«simpleName»))
					  return false; 
				'''
				case Float.TYPE.name: '''
					if («Float».floatToIntBits(other.«simpleName») != «Float».floatToIntBits(this.«simpleName»))
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
					} else if (!«deepEquals»)
					  return false;
				'''
			}
		}
		
		def StringConcatenationClient deepEquals(FieldDeclaration it) {
			if (type.isArray) {
				if (type.arrayComponentType.isPrimitive) {
					'''«Arrays».equals(this.«simpleName», other.«simpleName»)'''
				} else {
					'''«Arrays».deepEquals(this.«simpleName», other.«simpleName»)'''
				}
			} else {
				'''this.«simpleName».equals(other.«simpleName»)'''
			}
		}

		def void addHashCode(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
			boolean includeSuper) {
			cls.addMethod("hashCode") [
				primarySourceElement = cls.primarySourceElement
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

		def StringConcatenationClient contributeToHashCode(FieldDeclaration it) {
			switch (type.orObject.name) {
				case Double.TYPE.name:
					'''result = prime * result + (int) («Double».doubleToLongBits(this.«simpleName») ^ («Double».doubleToLongBits(this.«simpleName») >>> 32));'''
				case Float.TYPE.name:
					'''result = prime * result + «Float».floatToIntBits(this.«simpleName»);'''
				case Boolean.TYPE.name:
					'''result = prime * result + (this.«simpleName» ? 1231 : 1237);'''
				case Integer.TYPE.name,
				case Character.TYPE.name,
				case Byte.TYPE.name,
				case Short.TYPE.name:
					'''result = prime * result + this.«simpleName»;'''
				case Long.TYPE.name:
					'''result = prime * result + (int) (this.«simpleName» ^ (this.«simpleName» >>> 32));'''
				default:
					'''result = prime * result + ((this.«simpleName»== null) ? 0 : «deepHashCode»);'''
			}
		}
		
		def StringConcatenationClient deepHashCode(FieldDeclaration it) {
			val type = type.orObject
			if (type.isArray) {
				if (type.arrayComponentType.isPrimitive) {
					'''«Arrays».hashCode(this.«simpleName»)'''
				} else {
					'''«Arrays».deepHashCode(this.«simpleName»)'''
				}
			} else {
				'''this.«simpleName».hashCode()'''
			}
		}
		
		private def orObject(TypeReference ref) {
			ref ?: object
		}
	}
}
