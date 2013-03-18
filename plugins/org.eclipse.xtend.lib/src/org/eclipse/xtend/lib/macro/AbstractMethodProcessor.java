/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.MethodDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableMethodDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * A convenient base class to process active method annotations.
 * 
 * @author Sven Efftinge
 */
public class AbstractMethodProcessor implements RegisterGlobalsParticipant<MethodDeclaration>, TransformationParticipant<MutableMethodDeclaration>{

	public void doTransform(List<? extends MutableMethodDeclaration> annotatedMethods, @Extension TransformationContext context) {
		for (MutableMethodDeclaration annotatedMethod : annotatedMethods) {
			doTransform(annotatedMethod, context);
		}
	}

	/**
	 * @param annotatedMethod a mutable method representation annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doTransform(MutableMethodDeclaration annotatedMethod, @Extension TransformationContext context) {}

	public void doRegisterGlobals(List<? extends MethodDeclaration> annotatedMethods, RegisterGlobalsContext context) {
		for (MethodDeclaration annotatedMethod : annotatedMethods) {
			doRegisterGlobals(annotatedMethod, context);
		}
	}

	/**
	 * @param annotatedMethod a source method annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(MethodDeclaration annotatedMethod, RegisterGlobalsContext context) {}

}
