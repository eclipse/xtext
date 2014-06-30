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
import org.eclipse.xtext.xbase.lib.util.ToStringHelper

/**
 * @since 2.7
 */
@Beta
@Target(ElementType.TYPE)
@Active(ToStringProcessor)
@GwtCompatible
annotation ToString {
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class ToStringProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		val extension util = new ToStringProcessor.Util(context)
		val extension voUtil = new ValueObjectProcessor.Util(context)
		if (hasToString) {
			val annotation = findAnnotation(ToString.findTypeGlobally)
			annotation.addWarning("toString is already defined, this annotation has no effect.")
		} else if (extendedClass != object) {
			addReflectiveToString
		} else {
			addToString(valueObjectFields)
		}
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

		def hasToString(ClassDeclaration it) {
			findDeclaredMethod("toString") !== null
		}

		def void addReflectiveToString(MutableClassDeclaration cls) {
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

		def void addToString(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> fields) {
			cls.addMethod("toString") [
				returnType = string
				addAnnotation(newAnnotationReference(Override))
				addAnnotation(newAnnotationReference(Pure))
				body = '''
					StringBuilder b = new StringBuilder("«cls.simpleName»");
					b.append("{");
					«FOR field : fields SEPARATOR '\nb.append(", ");'»
						b.append("«field.simpleName»=");
						b.append(this.«field.simpleName»);
					«ENDFOR»
					b.append("}");
					return b.toString();
				'''
			]
		}
	}
}
