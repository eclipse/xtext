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

/**
 * A convenient base class to process active annotations for classes.
 * 
 * @author Sven Efftinge
 */
public class AbstractFieldProcessor implements RegisterGlobalsParticipant<FieldDeclaration>, TransformationParticipant<MutableFieldDeclaration>{

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

	public void doRegisterGlobals(List<? extends FieldDeclaration> annotatedClasses, RegisterGlobalsContext context) {
		for (FieldDeclaration annotatedField : annotatedClasses) {
			doRegisterGlobals(annotatedField, context);
		}
	}

	/**
	 * @param annotatedField a source field annotated with the annotation this processor is responsible for.
	 * @param context
	 */
	public void doRegisterGlobals(FieldDeclaration annotatedField, RegisterGlobalsContext context) {}

}
