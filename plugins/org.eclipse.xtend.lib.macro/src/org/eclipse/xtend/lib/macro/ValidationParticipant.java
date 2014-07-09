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
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * A callback interface for the validation phase. This callback is invoked after all transformations are done.
 * Inferred {@link TypeReference}s are resolved at that time, so it is safe to inspect them.
 * 
 * The AST is read-only in this phase.
 * 
 * @param <T> the type which this processor validates.
 */
@Beta
public interface ValidationParticipant<T extends NamedElement> {
	
	/**
	 * Invoked by the validator 
	 * 
	 * @param annotatedTargetElements the java representation of the annotated elements
	 * @param context a {@link ValidationContext} providing useful services.
	 */
	void doValidate(List<? extends T> annotatedTargetElements, @Extension ValidationContext context);
}
