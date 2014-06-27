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
 * Call back to participate in the register-globals phase, where Java types are
 * collected.
 * 
 * Clients should implement this to register and create new Java types.
 * 
 * @author Sven Efftinge
 * 
 * @param <T>
 *            the type of the annotated elements
 */
@Beta
public interface RegisterGlobalsParticipant<T extends NamedElement> {

	/**
	 * Called by the compiler during register-globals phase.
	 * 
	 * @param annotatedSourceElements
	 *            the source elements from the currently processed compilation
	 *            unit which are annotated with active annotation
	 * @param context
	 *            services to register new Java types
	 * @see RegisterGlobalsContext
	 */
	void doRegisterGlobals(List<? extends T> annotatedSourceElements,
			RegisterGlobalsContext context);
}
