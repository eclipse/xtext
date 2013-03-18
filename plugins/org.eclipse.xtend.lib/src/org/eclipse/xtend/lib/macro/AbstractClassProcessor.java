/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.ClassDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableClassDeclaration;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * A convenient base class to process active annotations for classes.
 * 
 * @author Sven Efftinge
 */
public class AbstractClassProcessor implements RegisterGlobalsParticipant<ClassDeclaration>, TransformationParticipant<MutableClassDeclaration>{

	public void doTransform(List<? extends MutableClassDeclaration> annotatedClasses, @Extension TransformationContext context) {
		for (MutableClassDeclaration annotatedClass : annotatedClasses) {
			doTransform(annotatedClass, context);
		}
	}

	/**
	 * @param annotatedClass a mutable class representation annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doTransform(MutableClassDeclaration annotatedClass, @Extension TransformationContext context) {}

	public void doRegisterGlobals(List<? extends ClassDeclaration> annotatedClasses, RegisterGlobalsContext context) {
		for (ClassDeclaration annotatedClass : annotatedClasses) {
			doRegisterGlobals(annotatedClass, context);
		}
	}

	/**
	 * @param annotatedClass a source element annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(ClassDeclaration annotatedClass, RegisterGlobalsContext context) {}

}
