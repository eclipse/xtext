/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.nature;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.AbstractDirtyStateAwareEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class NatureAddingEditorCallback extends AbstractDirtyStateAwareEditorCallback {
	
	@Inject
	private ToggleXtextNatureAction toggleNature;

	@Override
	public void afterCreatePartControl(XtextEditor editor) {
		super.afterCreatePartControl(editor);
		IResource resource = editor.getResource();
		if (resource!=null && !toggleNature.hasNature(resource.getProject()) && resource.getProject().isAccessible()) {
			String title = "Add Xtext Nature";
			String message = "Do you want to add the Xtext nature to the project '" + resource.getProject().getName() + "'?";
			Image image = null;
			MessageDialog dialog = new MessageDialog(editor.getEditorSite().getShell(), title, image, message, MessageDialog.QUESTION, 
					new String[] { IDialogConstants.YES_LABEL, IDialogConstants.NO_LABEL, IDialogConstants.CANCEL_LABEL }, 0);
			int open = dialog.open();
			if (open==0) {
				toggleNature.toggleNature(resource.getProject());
			}
		}
	}

}