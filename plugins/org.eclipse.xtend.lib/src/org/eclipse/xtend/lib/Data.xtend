package org.eclipse.xtend.lib

import java.lang.annotation.Documented
import java.lang.annotation.ElementType
import java.lang.annotation.Target
import org.eclipse.xtend.lib.annotations.AccessorsProcessor
import org.eclipse.xtend.lib.annotations.EqualsHashCodeProcessor
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructorProcessor
import org.eclipse.xtend.lib.annotations.ToStringProcessor
import org.eclipse.xtend.lib.macro.AbstractClassProcessor
import org.eclipse.xtend.lib.macro.Active
import org.eclipse.xtend.lib.macro.TransformationContext
import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration
import org.eclipse.xtend.lib.macro.declaration.Visibility
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
 * @deprecated use {@link org.eclipse.xtend.lib.annotations.Data} instead
 */
@Target(ElementType.TYPE)
@Active(DataProcessor)
@Deprecated
@Documented
annotation Data {
}

/**
 * @since 2.7
 * @noextend
 * @noreference
 */
@Deprecated
class DataProcessor extends AbstractClassProcessor {
	override doTransform(MutableClassDeclaration it, extension TransformationContext context) {
		extension val util = new DataProcessor.Util(context)
		extension val getterUtil = new AccessorsProcessor.Util(context)
		extension val ehUtil = new EqualsHashCodeProcessor.Util(context)
		extension val toStringUtil = new ToStringProcessor.Util(context)
		extension val requiredArgsUtil = new FinalFieldsConstructorProcessor.Util(context)

		for (it : dataFields)
			final = true
		if (needsFinalFieldConstructor) {
			addFinalFieldsConstructor
		}
		if (!hasHashCode) {
			addHashCode(dataFields, hasSuperHashCode)
		}
		if (!hasEquals) {
			addEquals(dataFields, hasSuperEquals)
		}
		if (!hasToString) {
			addDataToString
		}
		for (it : dataFields) {
			if (shouldAddGetter) {
				addGetter(Visibility.PUBLIC)
			}
			simpleName = "_" + simpleName.toFirstLower
		}
	}

	/**
	 * @since 2.7
	 * @noextend
	 * @noreference
 	 */
	@Deprecated
	static class Util {

		extension TransformationContext context

		new(TransformationContext context) {
			this.context = context
		}

		def getDataFields(ClassDeclaration it) {
			declaredFields.filter[!static && isThePrimaryGeneratedJavaElement]
		}

		def getDataFields(MutableClassDeclaration it) {
			declaredFields.filter[!static && isThePrimaryGeneratedJavaElement]
		}
		
		def void addDataToString(MutableClassDeclaration cls) {
			cls.addMethod("toString") [
				primarySourceElement = cls.primarySourceElement
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

}
