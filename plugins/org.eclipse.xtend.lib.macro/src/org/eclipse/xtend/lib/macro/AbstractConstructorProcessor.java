/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.ConstructorDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableConstructorDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * A convenient base class to process active annotations for constructors.
 * 
 * @author Sven Efftinge
 * @since 2.8
 */
@Beta
public abstract class AbstractConstructorProcessor implements RegisterGlobalsParticipant<ConstructorDeclaration>, TransformationParticipant<MutableConstructorDeclaration>, CodeGenerationParticipant<ConstructorDeclaration>, ValidationParticipant<ConstructorDeclaration> {
	
	public void doRegisterGlobals(List<? extends ConstructorDeclaration> annotatedConstructors, RegisterGlobalsContext context) {
		for (ConstructorDeclaration annotatedConstructor : annotatedConstructors) {
			doRegisterGlobals(annotatedConstructor, context);
		}
	}
	
	/**
	 * @param annotatedConstructor a source method annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(ConstructorDeclaration annotatedConstructor, RegisterGlobalsContext context) {}

	public void doTransform(List<? extends MutableConstructorDeclaration> annotatedConstructors, @Extension TransformationContext context) {
		for (MutableConstructorDeclaration annotatedConstructor : annotatedConstructors) {
			doTransform(annotatedConstructor, context);
		}
	}

	/**
	 * @param annotatedConstructor a mutable method representation annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doTransform(MutableConstructorDeclaration annotatedConstructor, @Extension TransformationContext context) {}

	public void doGenerateCode(List<? extends ConstructorDeclaration> annotatedConstructors, @Extension CodeGenerationContext context) {
		for (ConstructorDeclaration annotatedConstructor : annotatedConstructors) {
			doGenerateCode(annotatedConstructor, context);
		}
	}
	
	/**
	 * @param annotatedConstructor a source method annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doGenerateCode(ConstructorDeclaration annotatedConstructor, @Extension CodeGenerationContext context) {}

	public void doValidate(List<? extends ConstructorDeclaration> annotatedConstructors, @Extension ValidationContext context) {
		for (ConstructorDeclaration annotatedConstructor : annotatedConstructors) {
			doValidate(annotatedConstructor, context);
		}
	}

	/**
	 * Invoked by the validator 
	 * @param annotatedConstructor that generated method that should be validated
	 * @param context
	 * @see #doValidate(ConstructorDeclaration, ValidationContext)
	 * @since 2.7
	 */
	public void doValidate(ConstructorDeclaration annotatedConstructor, ValidationContext context) {
	}
}
