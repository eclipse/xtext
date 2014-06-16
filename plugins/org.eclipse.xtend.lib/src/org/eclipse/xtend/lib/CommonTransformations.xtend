package org.eclipse.xtend.lib

import com.google.common.annotations.Beta
import java.lang.annotation.Annotation
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTarget
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration
import org.eclipse.xtext.xbase.lib.util.ToStringHelper

import static extension org.eclipse.xtend.lib.CommonQueries.*

/**
 * @since 2.7
 */
@Beta
class CommonTransformations {

	extension TransformationContext context

	new(TransformationContext context) {
		this.context = context
	}

	def void addGetter(MutableFieldDeclaration field) {
		field.markAsRead
		field.declaringType.addMethod(field.getterName) [
			addAnnotation(Pure)
			returnType = field.type
			body = '''return this.«field.simpleName»;'''
		]
	}

	def void addSetter(MutableFieldDeclaration field) {
		if (field.final) {
			field.addError("Cannot set a final field")
			return
		}
		if (field.type.inferred) {
			field.addError("Type cannot be inferred.")
			return
		}
		field.declaringType.addMethod(field.setterName) [
			returnType = primitiveVoid
			val param = addParameter(field.simpleName, field.type)
			body = '''this.«field.simpleName» = «param.simpleName»;'''
		]
	}

	def void addHashCode(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
		boolean includeSuper) {
		cls.addMethod("hashCode") [
			returnType = primitiveInt
			addAnnotation(Override)
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
				"result = prime * result + ((this." + simpleName + "== null) ? 0 : this." + simpleName + ".hashCode());"
		}
	}

	def void addEquals(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> includedFields,
		boolean includeSuper) {
		cls.addMethod("equals") [
			returnType = primitiveBoolean
			addAnnotation(Override)
			addAnnotation(Pure)
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

	def void addReflectiveToString(MutableClassDeclaration cls) {
		cls.addMethod("toString") [
			returnType = string
			addAnnotation(Override)
			addAnnotation(Pure)
			body = '''
				String result = new «ToStringHelper»().toString(this);
				return result;
			'''
		]
	}

	def void addAnnotation(MutableAnnotationTarget it, Class<? extends Annotation> annotation) {
		addAnnotation(newAnnotationReference(annotation))
	}
}
