/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorInput;

/**
 * This factory creates the EMF {@link Resource} for a given editor input.
 * The indirection allows to force a certain resource type for a given
 * input. E.g. if an editor for language A is used on a file of language B,
 * the resource should be created for language A.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IResourceForEditorInputFactory {
	/**
	 * Returns a resource for the given input.
	 * If no resource can be created, a runtime exception is thrown.
	 * It may have a {@link CoreException} as its cause.
	 */
	Resource createResource(IEditorInput input);
}
