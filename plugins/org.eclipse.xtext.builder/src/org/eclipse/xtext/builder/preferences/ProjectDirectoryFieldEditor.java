/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.preferences;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

/**
 * @author Michael Clay - Initial contribution and API
 * @since 2.1
 */
public class ProjectDirectoryFieldEditor extends DirectoryFieldEditor {

	private IProject project;

	public ProjectDirectoryFieldEditor(String name, String labelText, Composite parent, IProject project) {
		super(name, labelText, parent);
		this.project = project;
	}

	@Override
	public String changePressed() {
		ElementTreeSelectionDialog elementTreeSelectionDialog = new ElementTreeSelectionDialog(getShell(),
				new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
		elementTreeSelectionDialog.setTitle(getLabelText());
		elementTreeSelectionDialog.setMessage(Messages.ProjectDirectoryFieldEditor_OutputDirectory);
		String currentPath = getPreferenceStore().getString(getPreferenceName());
		if (null != project && null != currentPath && !"".equals(currentPath)) { //$NON-NLS-1$
			elementTreeSelectionDialog.setInitialSelection(this.project.getFolder(currentPath));
		}
		elementTreeSelectionDialog.setInput(project);
		elementTreeSelectionDialog.open();
		if (elementTreeSelectionDialog.getFirstResult() instanceof IFolder) {
			IFolder folder = (IFolder) elementTreeSelectionDialog.getFirstResult();
			return folder.getProjectRelativePath().toString();
		}
		return null;
	}
}
