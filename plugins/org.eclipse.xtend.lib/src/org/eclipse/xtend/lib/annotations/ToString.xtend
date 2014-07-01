package org.eclipse.xtend.lib.annotations

import com.google.common.annotations.Beta
import com.google.common.annotations.GwtCompatible
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder

/**
 * @since 2.7
 */
@Beta
@Target(ElementType.TYPE)
@Active(ToStringProcessor)
@GwtCompatible
annotation ToString {
	val skipNulls = false
	val singleLine = false
	val hideFieldNames = false
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class ToStringConfiguration {
	val boolean skipNulls
	val boolean singleLine
	val boolean hideFieldNames
	
	new() {
		this(false, false, false)
	}

	new(boolean skipNulls, boolean singleLine, boolean hideFieldNames) {
		this.skipNulls = skipNulls
		this.singleLine = singleLine
		this.hideFieldNames = hideFieldNames
	}

	new(AnnotationReference annotation) {
		this.skipNulls = annotation.getBooleanValue("skipNulls")
		this.singleLine = annotation.getBooleanValue("singleLine")
		this.hideFieldNames = annotation.getBooleanValue("hideFieldNames")
	}

	def isSkipNulls() {
		skipNulls
	}

	def isSingleLine() {
		singleLine
	}

	def isHideFieldNames() {
		hideFieldNames
	}
}

/**
 * @since 2.7
 */
@Beta
@GwtCompatible
class ToStringProcessor extends AbstractClassProcessor {

	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		if (findAnnotation(Data.findTypeGlobally) !== null) {
			return
		}
		val extension util = new ToStringProcessor.Util(context)
		val annotation = findAnnotation(ToString.findTypeGlobally)
		val configuration = new ToStringConfiguration(annotation)
		if (hasToString) {
			annotation.addWarning("toString is already defined, this annotation has no effect.")
		} else if (extendedClass != object) {
			addReflectiveToString(configuration)
		} else {
			addToString(declaredFields.filter[thePrimaryGeneratedJavaElement && ! static && !transient], configuration)
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

		def getToStringConfig(ClassDeclaration it) {
			val anno = findAnnotation(ToString.findTypeGlobally)
			if (anno === null) null else new ToStringConfiguration(anno)
		}

		def void addReflectiveToString(MutableClassDeclaration cls, ToStringConfiguration config) {
			cls.addMethod("toString") [
				primarySourceElement = cls.primarySourceElement
				returnType = string
				addAnnotation(newAnnotationReference(Override))
				addAnnotation(newAnnotationReference(Pure))
				body = '''
					String result = new «ToStringBuilder»(this)
						.addAllFields()
						«IF config.skipNulls».skipNulls()«ENDIF»
						«IF config.singleLine».singleLine()«ENDIF»
						«IF config.hideFieldNames».hideFieldNames()«ENDIF»
						.toString();
					return result;
				'''
			]
		}

		def void addToString(MutableClassDeclaration cls, Iterable<? extends FieldDeclaration> fields,
			ToStringConfiguration config) {
			cls.addMethod("toString") [
				primarySourceElement = cls.primarySourceElement
				returnType = string
				addAnnotation(newAnnotationReference(Override))
				addAnnotation(newAnnotationReference(Pure))
				body = '''
					«ToStringBuilder» b = new «ToStringBuilder»(this);
					«IF config.skipNulls»b.skipNulls();«ENDIF»
					«IF config.singleLine»b.singleLine();«ENDIF»
					«IF config.hideFieldNames»b.hideFieldNames();«ENDIF»
					«FOR field : fields»
						b.add("«field.simpleName»", this.«field.simpleName»);
					«ENDFOR»
					return b.toString();
				'''
			]
		}
	}
}
