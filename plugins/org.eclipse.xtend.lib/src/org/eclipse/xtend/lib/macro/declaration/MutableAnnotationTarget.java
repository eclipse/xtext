package org.eclipse.xtend.lib.macro.declaration;

/**
 * @author Sven Efftinge
 */
public interface MutableAnnotationTarget extends MutableNamedElement, AnnotationTarget {

	/**
	 * @param annotationType
	 * @return a new annotation reference
	 */
	MutableAnnotationReference addAnnotation(Type annotationType);
	
	Iterable<? extends MutableAnnotationReference> getAnnotations();
	
	MutableAnnotationReference findAnnotation(Type annotationType);
}
