/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.InterfaceDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableInterfaceDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * A convenient base class to process active annotations for interfaces.
 */
@Beta
public abstract class AbstractInterfaceProcessor implements RegisterGlobalsParticipant<InterfaceDeclaration>, TransformationParticipant<MutableInterfaceDeclaration>, CodeGenerationParticipant<InterfaceDeclaration>, ValidationParticipant<InterfaceDeclaration> {

	public void doRegisterGlobals(List<? extends InterfaceDeclaration> annotatedInterfaces, @Extension RegisterGlobalsContext context) {
		for (InterfaceDeclaration annotatedInterface : annotatedInterfaces) {
			doRegisterGlobals(annotatedInterface, context);
		}
	}
	
	/**
	 * Called during global symbol collecting.
	 * 
	 * @param annotatedInterface a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(InterfaceDeclaration annotatedInterface, @Extension RegisterGlobalsContext context) {}
	
	public void doTransform(List<? extends MutableInterfaceDeclaration> annotatedInterfaces, @Extension TransformationContext context) {
		for (MutableInterfaceDeclaration annotatedInterface : annotatedInterfaces) {
			doTransform(annotatedInterface, context);
		}
	}

	/**
	 * @param annotatedInterface a mutable interface representation annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doTransform(MutableInterfaceDeclaration annotatedInterface, @Extension TransformationContext context) {}

	public void doGenerateCode(List<? extends InterfaceDeclaration> annotatedSourceElements, @Extension CodeGenerationContext context) {
		for (InterfaceDeclaration annotatedInterface : annotatedSourceElements) {
			doGenerateCode(annotatedInterface, context);
		}
	}
	
	/**
	 * Called during code generation. 
	 * 
	 * @param annotatedInterface a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 * @see CodeGenerationParticipant#doGenerateCode(List, CodeGenerationContext)
	 */
	public void doGenerateCode(InterfaceDeclaration annotatedInterface, @Extension CodeGenerationContext context) {}
	
	public void doValidate(List<? extends InterfaceDeclaration> annotatedInterfaces, @Extension ValidationContext context) {
		for (InterfaceDeclaration annotatedInterface : annotatedInterfaces) {
			doValidate(annotatedInterface, context);
		}
	}

	/**
	 * Invoked by the validator
	 * @param annotatedInterface the generated interface that should be validated 
	 * @param context 
	 * @see #doValidate(List, ValidationContext)
	 * @since 2.7
	 */
	public void doValidate(InterfaceDeclaration annotatedInterface, @Extension ValidationContext context) {}

}
