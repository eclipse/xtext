/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.FieldDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableFieldDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * A convenient base class to process active annotations for fields.
 * 
 * @author Sven Efftinge
 */
@Beta
public abstract class AbstractFieldProcessor implements RegisterGlobalsParticipant<FieldDeclaration>, TransformationParticipant<MutableFieldDeclaration>, CodeGenerationParticipant<FieldDeclaration>, ValidationParticipant<FieldDeclaration>{
	
	public void doRegisterGlobals(List<? extends FieldDeclaration> annotatedFields, @Extension RegisterGlobalsContext context) {
		for (FieldDeclaration annotatedField : annotatedFields) {
			doRegisterGlobals(annotatedField, context);
		}
	}
	
	/**
	 * @param annotatedField a source field annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(FieldDeclaration annotatedField, @Extension RegisterGlobalsContext context) {}

	public void doTransform(List<? extends MutableFieldDeclaration> annotatedfields, @Extension TransformationContext context) {
		for (MutableFieldDeclaration annotatedField : annotatedfields) {
			doTransform(annotatedField, context);
		}
	}

	/**
	 * @param annotatedField a mutable field representation annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doTransform(MutableFieldDeclaration annotatedField, @Extension TransformationContext context) {}

	public void doGenerateCode(List<? extends FieldDeclaration> annotatedFields, @Extension CodeGenerationContext context) {
		for (FieldDeclaration annotatedField : annotatedFields) {
			doGenerateCode(annotatedField, context);
		}
	}
	
	/**
	 * Called during code generation. 
	 * 
	 * @param annotatedField a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 * @see CodeGenerationParticipant#doGenerateCode(List, CodeGenerationContext)
	 */
	public void doGenerateCode(FieldDeclaration annotatedField, @Extension CodeGenerationContext context) {}
	
	public void doValidate(List<? extends FieldDeclaration> annotatedFields, @Extension ValidationContext context) {
		for (FieldDeclaration annotatedField : annotatedFields) {
			doValidate(annotatedField, context);
		}
	}

	/**
	 * Invoked by the validator
	 * @param annotatedField the generated field that should be validated 
	 * @param context 
	 * @see #doValidate(List, ValidationContext)
	 * @since 2.7
	 */
	public void doValidate(FieldDeclaration annotatedField, @Extension ValidationContext context) {}
}
