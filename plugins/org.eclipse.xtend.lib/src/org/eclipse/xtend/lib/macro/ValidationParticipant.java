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

import com.google.common.annotations.Beta;

/**
 * During the Validation phase everything is resolved and linked and no further modifications are allowed.
 * 
 * The purpose of this phase is to add validation problems
 * 
 * @author Sven Efftinge
 */
@Beta
public interface ValidationParticipant<T extends NamedElement> {

	/**
	 * invoked by the compiler during the validation phase.
	 * 
	 * @param annotatedSourceElements
	 * @param context
	 */
	void doValidate(List<? extends T> annotatedSourceElements, ValidationContext context);
}
