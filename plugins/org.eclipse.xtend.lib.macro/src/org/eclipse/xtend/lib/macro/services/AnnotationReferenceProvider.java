package org.eclipse.xtend.lib.macro.services;

import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.Type;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.common.annotations.Beta;

/**
 * Creates {@link AnnotationReference} instances.
 * 
 * @author Anton Kosyakov
 * @since 2.6
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface AnnotationReferenceProvider {
	
	/**
	 * Creates a new annotation reference for the given name.
	 *  
	 * @param annotationTypeName the name of the annotation type to point to, must be a valid java identifier
	 * @return a {@link AnnotationReference} pointing to the type with the give name, or <code>null</code> if no such annotation type could be found.
	 * @throws IllegalArgumentException if the <code>name</code> is not a valid java identifier
	 */
	AnnotationReference newAnnotationReference(String annotationTypeName);

	/**
	 * Creates a new annotation reference for the given type declaration.
	 *  
	 * @param annotationTypeDelcaration the annotation type to point to, must not be <code>null</code>.
	 * @return a {@link AnnotationReference} pointing to the given type, or <code>null</code> if the given type is not an annotation type.
	 * @throws IllegalArgumentException if the given type declaration is null
	 */
	AnnotationReference newAnnotationReference(Type annotationTypeDelcaration);

	/**
	 * Creates a new annotation reference for the given {@link Class}.
	 *  
	 * @param annotationClass the {@link Class} to point to, must not be <code>null</code>.
	 * @return a {@link AnnotationReference} pointing to the given type, or <code>null</code> if the given type is not on the class path of the compiled project or an annotation type.
	 * @throws IllegalArgumentException if the given {@link Class} is null
	 */
	AnnotationReference newAnnotationReference(Class<?> annotationClass);
	
	/**
	 * Create a new annotation reference base on the given annotation reference.
	 * 
	 * @param annotationReference an annotation reference which is used as a base for a new annotation reference, must not be <code>null</code> or detached.  
	 * @return a {@link AnnotationReference} constructed based on the given annotation reference, can be <code>null</code>
	 * @throws IllegalArgumentException if the given annotation reference is <code>null</code> or detached
	 */
	AnnotationReference newAnnotationReference(AnnotationReference annotationReference);
	
	/**
	 * Creates a new annotation reference for the given name.
	 *  
	 * @param annotationTypeName the name of the annotation type to point to
	 * @param initializer a callback for further initialization of the create annotation reference, must not be <code>null</code>.
	 * @return a {@link AnnotationReference} pointing to the type with the give name, or <code>null</code> if no such annotation type could be found.
	 * @throws IllegalArgumentException if the <code>name</code> is not a valid java identifier or the <code>initializer</code> is <code>null</code>
	 */
	AnnotationReference newAnnotationReference(String annotationTypeName, Procedures.Procedure1<AnnotationReferenceBuildContext> initializer);
	
	/**
	 * Creates a new annotation reference for the given type declaration.
	 *  
	 * @param annotationTypeDelcaration the annotation type to point to, must not be <code>null</code>.
	 * @param initializer a callback for further initialization of the create annotation reference, must not be <code>null</code>.
	 * @return a {@link AnnotationReference} pointing to the given type, or <code>null</code> if the given type is not an annotation type.
	 * @throws IllegalArgumentException if the given type declaration is <code>null</code> or the <code>initializer</code> is <code>null</code>
	 */
	AnnotationReference newAnnotationReference(Type annotationTypeDelcaration, Procedures.Procedure1<AnnotationReferenceBuildContext> initializer);
	
	/**
	 * Creates a new annotation reference for the given {@link Class}.
	 *  
	 * @param annotationClass the {@link Class} to point to, must not be <code>null</code>.
	 * @param initializer a callback for further initialization of the create annotation reference, must not be <code>null</code>.
	 * @return a {@link AnnotationReference} pointing to the given type, or <code>null</code> if the given type is not on the class path of the compiled project or an annotation type.
	 * @throws IllegalArgumentException if the given {@link Class} is <code>null</code> or the <code>initializer</code> is <code>null</code>
	 */
	AnnotationReference newAnnotationReference(Class<?> annotationClass, Procedures.Procedure1<AnnotationReferenceBuildContext> initializer);
	
	/**
	 * Create a new annotation reference base on the given annotation reference.
	 * 
	 * @param annotationReference an annotation reference which is used as a base for a new annotation reference, must not be <code>null</code> or detached. 
	 * @param initializer a callback for further initialization of the create annotation reference, must not be <code>null</code>.
	 * @return a {@link AnnotationReference} constructed based on the given annotation reference, can be <code>null</code> 
	 * @throws IllegalArgumentException if the given annotation reference is <code>null</code> or detached; or the <code>initializer</code> is <code>null</code>
	 */
	AnnotationReference newAnnotationReference(AnnotationReference annotationReference, Procedures.Procedure1<AnnotationReferenceBuildContext> initializer);
	
}
