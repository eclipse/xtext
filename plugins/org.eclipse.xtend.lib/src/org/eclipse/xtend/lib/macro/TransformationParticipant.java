/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro;

import java.util.List;

import org.eclipse.xtend.lib.macro.declaration.MutableNamedElement;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.annotations.Beta;

/**
 * A callback interface for the transformation phase, in which the Xtend AST is translated
 * to the Java elements. This callback is invoked after the primary translation by the Xtend compiler is done.
 * 
 * It is safe to resolve any {@link TypeReference}s during this phase as long as they are not
 * inferred from an expression. It's not allowed to resolve any expressions during this phase.
 * 
 * @param <T> the type which this processor processes.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface TransformationParticipant<T extends MutableNamedElement> {
	
	/**
	 * Invoked by the compiler 
	 * 
	 * @param annotatedTargetElements the mutable java representation of the annotated elements
	 * @param context a {@link TransformationContext} providing useful services.
	 */
	void doTransform(List<? extends T> annotatedTargetElements, @Extension TransformationContext context);
}
