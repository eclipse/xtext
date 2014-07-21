/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationTypeDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * A convenient base class to process active annotations for annotation types.
 */
@Beta
public abstract class AbstractAnnotationTypeProcessor implements RegisterGlobalsParticipant<AnnotationTypeDeclaration>, TransformationParticipant<MutableAnnotationTypeDeclaration>, CodeGenerationParticipant<AnnotationTypeDeclaration>, ValidationParticipant<AnnotationTypeDeclaration> {

	public void doRegisterGlobals(List<? extends AnnotationTypeDeclaration> annotatedAnnotationTypes, @Extension RegisterGlobalsContext context) {
		for (AnnotationTypeDeclaration annotatedAnnotationType : annotatedAnnotationTypes) {
			doRegisterGlobals(annotatedAnnotationType, context);
		}
	}
	
	/**
	 * Called during global symbol collecting.
	 * 
	 * @param annotatedAnnotationType a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(AnnotationTypeDeclaration annotatedAnnotationType, @Extension RegisterGlobalsContext context) {}
	
	public void doTransform(List<? extends MutableAnnotationTypeDeclaration> annotatedAnnotationTypes, @Extension TransformationContext context) {
		for (MutableAnnotationTypeDeclaration annotatedAnnotationType : annotatedAnnotationTypes) {
			doTransform(annotatedAnnotationType, context);
		}
	}

	/**
	 * @param annotatedAnnotationType a mutable annotation type representation annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doTransform(MutableAnnotationTypeDeclaration annotatedAnnotationType, @Extension TransformationContext context) {}

	public void doGenerateCode(List<? extends AnnotationTypeDeclaration> annotatedSourceElements, @Extension CodeGenerationContext context) {
		for (AnnotationTypeDeclaration annotatedAnnotationType : annotatedSourceElements) {
			doGenerateCode(annotatedAnnotationType, context);
		}
	}
	
	/**
	 * Called during code generation. 
	 * 
	 * @param annotatedAnnotationType a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 * @see CodeGenerationParticipant#doGenerateCode(List, CodeGenerationContext)
	 */
	public void doGenerateCode(AnnotationTypeDeclaration annotatedAnnotationType, @Extension CodeGenerationContext context) {}
	
	public void doValidate(List<? extends AnnotationTypeDeclaration> annotatedAnnotationTypes, @Extension ValidationContext context) {
		for (AnnotationTypeDeclaration annotatedAnnotationType : annotatedAnnotationTypes) {
			doValidate(annotatedAnnotationType, context);
		}
	}

	/**
	 * Invoked by the validator
	 * @param annotatedAnnotationType the generated annotation type that should be validated 
	 * @param context 
	 * @see #doValidate(List, ValidationContext)
	 * @since 2.7
	 */
	public void doValidate(AnnotationTypeDeclaration annotatedAnnotationType, @Extension ValidationContext context) {}

}
