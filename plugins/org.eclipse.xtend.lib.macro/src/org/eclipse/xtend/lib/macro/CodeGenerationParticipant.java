/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.NamedElement;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * Annotation processors implementing this interface will be called in the code generation phase, which is called 
 * when Xtend's actualö Java code is generated and written to the file system.
 * 
 * During this phase it is permitted to write to the file system.
 * 
 * @param <T> the type which this processor processes.
 * 
 * @author Sven Efftinge
 * 
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface CodeGenerationParticipant<T extends NamedElement> {

	/**
	 * Invoked by the compiler during the code generation phase.
	 * 
	 * @param annotatedSourceElements the immutable source representation (i.e. the Xtend AST) of the annotated elements
	 * @param context a {@link TransformationContext} providing useful services.
	 */
	void doGenerateCode(List<? extends T> annotatedSourceElements, @Extension CodeGenerationContext context);
}
