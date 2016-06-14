/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableEnumerationTypeDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * A convenient base class to process active annotations for enumeration types.
 */
@Beta
public abstract class AbstractEnumerationTypeProcessor implements RegisterGlobalsParticipant<EnumerationTypeDeclaration>, TransformationParticipant<MutableEnumerationTypeDeclaration>, CodeGenerationParticipant<EnumerationTypeDeclaration>, ValidationParticipant<EnumerationTypeDeclaration> {

	public void doRegisterGlobals(List<? extends EnumerationTypeDeclaration> annotatedEnumerationTypes, @Extension RegisterGlobalsContext context) {
		for (EnumerationTypeDeclaration annotatedEnumerationType : annotatedEnumerationTypes) {
			doRegisterGlobals(annotatedEnumerationType, context);
		}
	}
	
	/**
	 * Called during global symbol collecting.
	 * 
	 * @param annotatedEnumerationType a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(EnumerationTypeDeclaration annotatedEnumerationType, @Extension RegisterGlobalsContext context) {}
	
	public void doTransform(List<? extends MutableEnumerationTypeDeclaration> annotatedEnumerationTypes, @Extension TransformationContext context) {
		for (MutableEnumerationTypeDeclaration annotatedEnumerationType : annotatedEnumerationTypes) {
			doTransform(annotatedEnumerationType, context);
		}
	}

	/**
	 * @param annotatedEnumerationType a mutable enumeration type representation annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doTransform(MutableEnumerationTypeDeclaration annotatedEnumerationType, @Extension TransformationContext context) {}

	public void doGenerateCode(List<? extends EnumerationTypeDeclaration> annotatedSourceElements, @Extension CodeGenerationContext context) {
		for (EnumerationTypeDeclaration annotatedEnumerationType : annotatedSourceElements) {
			doGenerateCode(annotatedEnumerationType, context);
		}
	}
	
	/**
	 * Called during code generation. 
	 * 
	 * @param annotatedEnumerationType a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 * @see CodeGenerationParticipant#doGenerateCode(List, CodeGenerationContext)
	 */
	public void doGenerateCode(EnumerationTypeDeclaration annotatedEnumerationType, @Extension CodeGenerationContext context) {}
	
	public void doValidate(List<? extends EnumerationTypeDeclaration> annotatedEnumerationTypes, @Extension ValidationContext context) {
		for (EnumerationTypeDeclaration annotatedEnumerationType : annotatedEnumerationTypes) {
			doValidate(annotatedEnumerationType, context);
		}
	}

	/**
	 * Invoked by the validator
	 * @param annotatedEnumerationType the generated enumeration type that should be validated 
	 * @param context 
	 * @see #doValidate(List, ValidationContext)
	 * @since 2.7
	 */
	public void doValidate(EnumerationTypeDeclaration annotatedEnumerationType, @Extension ValidationContext context) {}

}
