/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 ******************************************************************************/
package org.eclipse.ui.ide;

import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorInput;


/**
 * Allows to override editor associations for the IDE.
 * <p>
 * This interface is implemented by <code>org.eclipse.ui.ide.editorAssociationOverride</code>
 * extensions.
 * </p>
 * <p>
 * Clients may implement this interface.
 * </p>
 * 
 * @since 3.8
 */
public interface IEditorAssociationOverride {

	/**
	 * Allows to override the given editor descriptors for the given editor input with different
	 * ones.
	 * 
	 * @param editorInput the editor input for the editor
	 * @param contentType the content type of the input or <code>null</code> if not available
	 * @param editorDescriptors the current association for the given input
	 * @return the editor descriptors to be used for the given input - can be
	 *         <code>editorDescriptors</code>. The order is not relevant.
	 */
	IEditorDescriptor[] overrideEditors(IEditorInput editorInput, IContentType contentType, IEditorDescriptor[] editorDescriptors);

	/**
	 * Allows to override the given editor descriptors for the given file name with different ones.
	 * 
	 * @param fileName the name of the file for which to choose the editor
	 * @param contentType the content type of the input or <code>null</code> if not available
	 * @param editorDescriptors the current association for the given input
	 * @return the editor descriptors to be used for the given input - can be
	 *         <code>editorDescriptors</code>. The order is not relevant.
	 */
	IEditorDescriptor[] overrideEditors(String fileName, IContentType contentType, IEditorDescriptor[] editorDescriptors);

	/**
	 * Allows to override the given editor descriptor for the given editor input with a different
	 * one. Normally, this is used to override the default editor for the given input.
	 * <p>
	 * Though possible, it is advised not to override an editor that has been explicitly chosen by
	 * the user for the given input. This is the case when
	 * <code>IFile#getPersistentProperty(IDE.EDITOR_KEY) != null</code>.
	 * </p>
	 * 
	 * @param editorInput the editor input for the editor
	 * @param contentType the content type of the input or <code>null</code> if not available
	 * @param editorDescriptor the current association for the given input or <code>null</code> if
	 *            none
	 * @return the editor descriptor to be used for the given input or <code>null</code> if none.
	 *         Can be <code>editorDescriptor</code>.
	 */
	IEditorDescriptor overrideDefaultEditor(IEditorInput editorInput, IContentType contentType, IEditorDescriptor editorDescriptor);

	/**
	 * Allows to override the given editor descriptor for the given input with a different one.
	 * Normally, this is used to override the default editor for the given input.
	 * 
	 * @param fileName the name of the file for which to choose the editor
	 * @param contentType the content type of the input or <code>null</code> if not available
	 * @param editorDescriptor the current association for the given input or <code>null</code> if
	 *            none
	 * @return the editor descriptor to be used for the given input or <code>null</code> if none.
	 *         Can be <code>editorDescriptor</code>.
	 */
	IEditorDescriptor overrideDefaultEditor(String fileName, IContentType contentType, IEditorDescriptor editorDescriptor);

}