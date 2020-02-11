/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.label;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultEditorImageUtil {
	
	@Inject(optional=true)
	/* @Nullable */
	private IWorkbench workbench;
	
	public ImageDescriptor getDefaultEditorImageDescriptor(String fileName) {
		if (fileName != null && workbench != null) {
			IEditorDescriptor defaultEditor = workbench.getEditorRegistry().getDefaultEditor(fileName);
			if (defaultEditor != null) {
				return defaultEditor.getImageDescriptor();
			} else {
				return workbench.getEditorRegistry().getSystemExternalEditorImageDescriptor(fileName);
			}
		}
		return null;
	}
}
