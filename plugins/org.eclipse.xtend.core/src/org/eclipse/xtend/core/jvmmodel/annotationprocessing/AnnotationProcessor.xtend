package org.eclipse.xtend.core.jvmmodel.annotationprocessing

import com.google.inject.Inject
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations
import org.eclipse.xtend.core.xtend.XtendAnnotationType
import org.eclipse.xtend.core.xtend.XtendFunction
import org.eclipse.xtext.common.types.JvmAnnotationTarget
import org.eclipse.xtext.util.CancelIndicator
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.interpreter.impl.XbaseInterpreter
import org.eclipse.xtext.xbase.interpreter.impl.DefaultEvaluationContext

public class AnnotationProcesser implements IAnnotationProcessor {
	
	@Inject IXtendJvmAssociations associations;
	@Inject XbaseInterpreter interpreter

	override process(XAnnotation annotation, Iterable<? extends JvmAnnotationTarget> elements,
			CancelIndicator cancelIndicator) {
		if (annotation == null)
			return;
		annotation.xtendAnnotationType => [
			if (it == null || processingFunction == null) 
				return
			val ctx = new DefaultEvaluationContext
			try {
				interpreter.evaluate(processingFunction.expression, ctx, cancelIndicator) 
			} catch (Exception e) {
				e.printStackTrace
			}
		]
	}
	
	def protected XtendFunction getProcessingFunction(XtendAnnotationType annotationType) {
		annotationType?.members?.filter(typeof(XtendFunction)).head
	}
	
	def protected getXtendAnnotationType(XAnnotation annotation) {
		if (annotation.annotationType == null)
			return null
		switch ele : associations.getPrimarySourceElement(annotation.annotationType) {
			XtendAnnotationType : ele
			default : null
		}
	}
	
}